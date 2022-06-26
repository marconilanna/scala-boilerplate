/*
 * Copyright 2011-2020 Marconi Lanna
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
val lib = Dependencies
val utf8 = java.nio.charset.StandardCharsets.UTF_8.toString

/*
 * Project definition
 */

lazy val root = project.in(file(".")).settings(
  name := "PROJECT"
, description := "PROJECT DESCRIPTION"
, commonSettings
, scaladocPublishing
, libraryDependencies ++= lib.allDependencies // for dependencyUpdates task
).aggregate(
  common
, module
).enablePlugins(
  GhpagesPlugin
, ScalaUnidocPlugin
)

lazy val common = project.settings(
  description := "Common classes shared across modules"
, commonSettings
, libraryDependencies ++= Seq(
  )
)

lazy val module = project.settings(
  description := "MODULE DESCRIPTION"
, commonSettings
, libraryDependencies ++= Seq(
  )
).dependsOn(
  common % withTests
)

lazy val jmh = project.settings(
  description := "Benchmarking code"
  commonSettings
).dependsOn(
  common
  // add the project you are benchmarking here
).enablePlugins(JmhPlugin)

lazy val commonSettings =
  projectMetadata ++
  projectLayout ++
  scalacConfiguration ++
  scaladocConfiguration ++
  javacConfiguration ++
  dependencies ++
  sbtOptions ++
  publishing ++
  staticAnalysis ++
  codeCoverage

val withTests = "compile->compile;test->test"

/*
 * Project metadata
 */

val projectMetadata = Seq(
//organization := "org.example"
//organizationName := "Example, Inc."
//organizationHomepage := Option(url("http://example.org"))
//homepage := Option(url("http://example.org/project"))
//apiURL := Option(url("http://example.org/project/api"))
  startYear := Option(2011)
, licenses += "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")
  // "MIT " -> url("http://opensource.org/licenses/MIT")
  // "BSD-2-Clause" -> url("http://opensource.org/licenses/BSD-2-Clause")
  // "BSD-3-Clause" -> url("http://opensource.org/licenses/BSD-3-Clause")
  // "GPL-2.0" -> url("http://www.gnu.org/licenses/gpl-2.0.html")
  // "LGPL-2.1" -> url("http://www.gnu.org/licenses/lgpl-2.1.html")
, developers := List(
    Developer("marconilanna", "Marconi Lanna", "@marconilanna", url("http://github.com/marconilanna"))
  )
)

/*
 * Project layout
 */

val projectLayout = Seq(
  scalaSource in Compile := baseDirectory.value / "src"
, scalaSource in Test := baseDirectory.value / "test"
, javaSource in Compile := scalaSource.in(Compile).value
, javaSource in Test := scalaSource.in(Test).value
, resourceDirectory in Compile := scalaSource.in(Compile).value / "resources"
, resourceDirectory in Test := scalaSource.in(Test).value / "resources"
, sourcesInBase := false
)

/*
 * scalac configuration
 */

val coreScalacOptions = Seq(
  "-encoding", utf8 // Specify character encoding used by source files
//"-release 11" // Compile for a specific version of the Java platform (Java 9 and higher)
, "-target:jvm-" + lib.v.jvm // Target platform for object files
)

val commonScalacOptions = Seq(
  "-deprecation" // Emit warning and location for usages of deprecated APIs
//"-explaintypes" // Explain type errors in more detail
, "-feature" // Emit warning and location for usages of features that should be imported explicitly
, "-g:vars" // Set level of generated debugging info: none, source, line, vars, notailcalls
//"-language:_" // Enable or disable language features (see list below)
, "-opt:l:inline" // Enable optimizations (see list below)
, "-opt-inline-from:**" // Classfile names from which to allow inlining
, "-opt-warnings:at-inline-failed" // Enable optimizer warnings: detailed warning for each @inline method call that could not be inlined
, "-unchecked" // Enable additional warnings where generated code depends on assumptions
, "-Werror" // Fail the compilation if there are any warnings
//"-Xasync" // Enable the async phase for scala.async.Async.{async,await}
//"-Xdisable-assertions" // Generate no assertions or assumptions
, "-Xlint:_" // Enable or disable specific warnings (see list below)
//"-Xmigration:<version>" // Warn about constructs whose behavior may have changed since version
//"-Xsource:<version>" // Enable features that will be available in a future version of Scala
, "-Ybackend-parallelism", "8" // Maximum worker threads for backend
, "-Ybackend-worker-queue", "8" // Backend threads worker queue
, "-Ycache-macro-class-loader:last-modified" // Policy for caching class loaders for macros that are dynamically loaded
, "-Ycache-plugin-class-loader:last-modified" // Policy for caching class loaders for compiler plugins that are dynamically loaded
//"-Ymacro-annotations" // Enable support for macro annotations
//"-Yno-imports" // Compile without importing scala.*, java.lang.*, or Predef
//"-Yno-predef" // Compile without importing Predef
//"-Yprofile-enabled" // Enable profiling
)

val compileScalacOptions = Seq(
)

val testScalacOptions = Seq(
  "-Xcheckinit" // Wrap field accessors to throw an exception on uninitialized access
)

val consoleScalacOptions = Seq(
  "-language:_" // Enable or disable language features (see list below)
, "-nowarn" // Generate no warnings
)

val scalacConfiguration = Seq(
  scalaVersion := lib.v.scala
//crossScalaVersions := Seq(scalaVersion.value)
, scalacOptions ++= coreScalacOptions ++ commonScalacOptions ++ compileScalacOptions
, scalacOptions in (Test, compile) ++= testScalacOptions
, scalacOptions in (Test, compile) --= compileScalacOptions
, scalacOptions in (Compile, console) := coreScalacOptions ++ consoleScalacOptions
, scalacOptions in (Test, console) := scalacOptions.in(Compile, console).value
, compileOrder := CompileOrder.JavaThenScala
)

/*
scalac -language:help

dynamics             Allow direct or indirect subclasses of scala.Dynamic
existentials         Existential types (besides wildcard types) can be written and inferred
experimental.macros  Allow macro definition (besides implementation and application)
higherKinds          Allow higher-kinded types
implicitConversions  Allow definition of implicit functions called views
postfixOps           Allow postfix operator notation, such as `1 to 10 toList'
reflectiveCalls      Allow reflective access to members of structural types

*//*

scalac -opt:help

allow-skip-class-loading     Allow optimizations that can skip or delay class loading
allow-skip-core-module-init  Allow eliminating unused module loads for core modules of the standard library
assume-modules-non-null      Assume loading a module never results in null
box-unbox                    Eliminate box-unbox pairs within the same method
closure-invocations          Rewrite closure invocations to the implementation method
compact-locals               Eliminate empty slots in the sequence of local variables
copy-propagation             Eliminate redundant local variables and unused values
inline                       Inline method invocations according to -Yopt-inline-heuristics and -opt-inline-from
nullness-tracking            Track nullness / non-nullness of local variables and apply optimizations
redundant-casts              Eliminate redundant casts using a type propagation analysis
simplify-jumps               Simplify branching instructions, eliminate unnecessary ones
unreachable-code             Eliminate unreachable code, exception handlers guarding no instructions, redundant metadata
l:none                       Disable optimizations
l:default                    Enable default optimizations: unreachable-code
l:method                     Enable intra-method optimizations: allow-skip-class-loading, allow-skip-core-module-init,
                             assume-modules-non-null, box-unbox, closure-invocations, compact-locals, copy-propagation,
                             nullness-tracking, redundant-casts, simplify-jumps, unreachable-code
l:inline                     Enable cross-method optimizations: l:method, inline

*//*

scalac -Xlint:help

adapted-args            An argument list was modified to match the receiver
byname-implicit         Block adapted by implicit with by-name parameter
constant                Evaluation of a constant arithmetic expression resulted in an error
delayedinit-select      Selecting member of DelayedInit
deprecation             Enable -deprecation and also check @deprecated annotations
doc-detached            When running scaladoc, warn if a doc comment is discarded
eta-sam                 The Java-defined target interface for eta-expansion was not annotated @FunctionalInterface
eta-zero                Usage `f` of parameterless `def f()` resulted in eta-expansion, not empty application `f()`
implicit-not-found      Check @implicitNotFound and @implicitAmbiguous messages
implicit-recursion      Implicit resolves to an enclosing definition
inaccessible            Warn about inaccessible types in method signatures
infer-any               A type argument was inferred as Any
missing-interpolator    A string literal appears to be missing an interpolator id
multiarg-infix          Infix operator was defined or used with multiarg operand
nonlocal-return         A return statement used an exception for flow control
nullary-unit            `def f: Unit` looks like an accessor; add parens to look side-effecting
option-implicit         Option.apply used an implicit view
package-object-classes  Class or object defined in package object
poly-implicit-overload  Parameterized overloaded implicit methods are not visible as view bounds
private-shadow          A private field (or class parameter) shadows a superclass field
recurse-with-default    Recursive call used default argument
serial                  @SerialVersionUID on traits and non-serializable classes
stars-align             In a pattern, a sequence wildcard `_*` should match all of a repeated parameter
type-parameter-shadow   A local type parameter shadows a type already in scope
unit-special            Warn for specialization of Unit in parameter position
unused                  Enable -Wunused: imports, privates, locals, implicits, nowarn
valpattern              Enable pattern checks in val definitions

*//*

scalac -Wmacros:help

after   Only inspect expanded trees when generating unused symbol warnings
before  Only inspect unexpanded user-written code for unused symbols
both    Inspect both user-written code and expanded trees when generating unused symbol warnings
none    Do not inspect expansions or their original trees when generating unused symbol warnings

*//*

scalac -Wunused:help

explicits  Warn if an explicit parameter is unused
implicits  Warn if an implicit parameter is unused
imports    Warn if an import selector is not referenced
linted     -Xlint:unused
locals     Warn if a local definition is unused
nowarn     Warn if a @nowarn annotation does not suppress any warnings
params     Warn if a value parameter is unused
patvars    Warn if a variable bound in a pattern is unused
privates   Warn if a private member is unused
*/

/*
 * Scaladoc configuration
 */

def docSourceUrl(version: String) = {
  s"http://github.com/marconilanna/scala-boilerplate/blob/${version}€{FILE_PATH_EXT}#L€{FILE_LINE}"
}

val scaladocConfiguration = Seq(
  autoAPIMappings := true
, apiMappings ++= (
    scalaInstance.value.libraryJars.filter { file =>
      file.getName.startsWith("scala-library") && file.getName.endsWith(".jar")
    }.map {
      _ -> url(s"http://www.scala-lang.org/api/${scalaVersion.value}/")
    }.toMap
  )
, scalacOptions in (Compile, doc) := coreScalacOptions ++ Seq(
    "-author" // Include authors
  //"-diagrams" // Create inheritance diagrams for classes, traits and packages
  //"-doc-footer", "footer" // A footer on every Scaladoc page
  //"-doc-root-content", "path" // The file from which the root package documentation should be imported
  , "-doc-source-url", docSourceUrl("v" + version.value) // A URL pattern used to link to the source file
  , "-doc-title", "Scala Boilerplate" // The overall name of the Scaladoc site
  , "-doc-version", version.value // An optional version number, to be appended to the title
  , "-groups" // Group similar functions together (based on the @group annotation)
  , "-implicits" // Document members inherited by implicit conversions
  , "-sourcepath", baseDirectory.in(ThisBuild).value.toString // To obtain a relative path for €{FILE_PATH_EXT} instead of an absolute one
  )
, scalacOptions in (Test, doc) := scalacOptions.in(Compile, doc).value
)

/*
 * Scaladoc publishing (Scala Unidoc, sbt-site, GitHub Pages)
 */

val scaladocPublishing = Seq(
  addMappingsToSiteDir(mappings.in(ScalaUnidoc, packageDoc), siteSubdirName.in(ScalaUnidoc))
, ghpagesNoJekyll := true
, git.remoteRepo := "git@github.com:marconilanna/scala-boilerplate.git"
//scalacOptions in (ScalaUnidoc, unidoc) += "-Ymacro-expand:none"
, siteSubdirName in ScalaUnidoc := version.value
, includeFilter in ghpagesCleanSite := new sbt.io.PrefixFilter(version.value)
, excludeFilter in ghpagesCleanSite := NothingFilter
, unidocConfigurationFilter in (ScalaUnidoc, unidoc) := inConfigurations(Compile, Test)
)

/*
 * javac configuration
 */

val javacConfiguration = Seq(
  javacOptions ++= Seq(
    "-encoding", utf8 // Specify character encoding used by source files
  , "-g:none" // Generate no debugging info
  , "-target", lib.v.jvm // Generate class files for specific VM version
  , "-Werror" // Terminate compilation if warnings occur
  //"-Xdoclint:all" // Enable recommended checks for problems in javadoc comments
  , "-Xlint:all" // Enable recommended warnings (see list below)
  )
)

/*
javac -Xlint options: prefix with "-" to disable specific warning

auxiliaryclass cast           classfile      deprecation    dep-ann
divzero        empty          fallthrough    finally        options
overloads      overrides      path           processing     rawtypes
serial         static         try            unchecked      varargs
*/

/*
 * Macros
 */

val scalaCompiler = libraryDependencies += lib.scalaCompiler

val scalaReflect = libraryDependencies += lib.scalaReflect

val scalameta = libraryDependencies ++= Seq(
  lib.scalameta
)

/*
 * Managed dependencies
 */

val dependencies = Seq(
  libraryDependencies ++= lib.commonDependencies ++ lib.testDependencies
, resolvers ++= lib.resolvers
)

/*
 * sbt options
 */

val consoleDefinitions = """
import
  scala.annotation.{switch, tailrec}
, scala.beans.{BeanProperty, BooleanBeanProperty}
, scala.collection.JavaConverters._
, scala.collection.{breakOut, mutable}
, scala.concurrent.{Await, ExecutionContext, Future}
, scala.concurrent.ExecutionContext.Implicits.global
, scala.concurrent.duration._
, scala.language.experimental.macros
, scala.math._
, scala.reflect.macros.{blackbox, whitebox}
, scala.reflect.runtime.{currentMirror => mirror}
, scala.reflect.runtime.universe._
, scala.tools.reflect.ToolBox
, scala.util.{Failure, Random, Success, Try}
, scala.util.control.NonFatal
, java.io._
, java.net._
, java.nio.file._
, java.time.{Duration => jDuration, _}
, java.util.{Date, Locale, UUID}
, java.util.regex.{Matcher, Pattern}
, System.{currentTimeMillis => now, nanoTime}

val toolbox = mirror.mkToolBox()

import toolbox.{PATTERNmode, TERMmode, TYPEmode}

def time[T](f: => T): T = {
  val start = now
  try f finally {
    println("Elapsed: " + (now - start)/1000.0 + " s")
  }
}

def desugar[T](expr: => T): Unit = macro desugarImpl[T]

def desugarImpl[T](c: blackbox.Context)(expr: c.Expr[T]) = {
  import c.universe._, scala.io.AnsiColor.{BOLD, GREEN, RESET}

  val exp = showCode(expr.tree)
  val typ = expr.actualType.toString takeWhile '('.!=

  println(s"$exp: $BOLD$GREEN$typ$RESET")

  q"()"
}
"""

cleanKeepFiles += target.in(LocalRootProject).value / ".history"

turbo in ThisBuild := true

val sbtOptions = Seq(
  // Statements executed when starting the Scala REPL (sbt's `console` task)
  initialCommands += consoleDefinitions
  // Statements executed before the Scala REPL exits
//cleanupCommands := ""
  // Improved dependency management
, updateOptions := updateOptions.value.withCachedResolution(true)
  // Clean locally cached project artifacts
, publishLocal := publishLocal
    .dependsOn(cleanCache.toTask(""))
    .dependsOn(cleanLocal.toTask(""))
    .value
, credentials += Credentials(Path.userHome / ".sbt" / "sonatype_credentials")
  // Share history among all projects instead of using a different history for each project
, historyPath := Option(target.in(LocalRootProject).value / ".history")
, cleanKeepFiles := cleanKeepFiles.value filterNot { file =>
    file.getPath.endsWith(".history")
  }
, fork in run := true
, classLoaderLayeringStrategy in Compile := ClassLoaderLayeringStrategy.AllLibraryJars
, classLoaderLayeringStrategy in Test := ClassLoaderLayeringStrategy.AllLibraryJars
, trapExit := false
, connectInput := true
, outputStrategy := Option(StdoutOutput)
, logLevel in Global := { if (insideCI.value) Level.Error else Level.Info }
, logBuffered in Test := false
, onChangedBuildSource in Global := WarnOnSourceChanges
, showSuccess := true
, showTiming := true
  // ScalaTest configuration
, testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest
    // F: show full stack traces
    // S: show short stack traces
    // D: show duration for each test
    // I: print "reminders" of failed and canceled tests at the end of the summary,
    //    eliminating the need to scroll and search to find failed or canceled tests
    //    replace with G (or T) to show reminders with full (or short) stack traces
    // K: exclude canceled tests from reminder
  , "-oDI"
    // Periodic notification of slowpokes (tests that have been running longer than 30s)
  , "-W", "30", "30"
  )
  // Enable colors in Scala console (2.11.4+)
, initialize ~= { _ =>
    val ansi = System.getProperty("sbt.log.noformat", "false") != "true"
    if (ansi) System.setProperty("scala.color", "true")
  }
  // Draw a separator between triggered runs (e.g, ~test)
, watchTriggeredMessage := { (count, _, _) =>
  val msg = if (count > 1) {
    val nl = System.lineSeparator * 2
    nl + "#" * 72 + nl
  } else ""
  Option(msg)
}
  // Alternative: clear the console between triggered runs
//watchTriggeredMessage := Watch.clearScreenOnTrigger
, shellPrompt := { state =>
    import scala.Console.{BLUE, BOLD, RESET}
    s"$BLUE$BOLD${name.value}$RESET $BOLD\u25b6$RESET "
  }
  // Download and create Eclipse source attachments for library dependencies
//EclipseKeys.withSource := true
)

addCommandAlias("cd", "project")
addCommandAlias("ls", "projects")
addCommandAlias("cr", ";clean ;reload")
addCommandAlias("cru", ";clean ;reload ;test:update")
addCommandAlias("du", "dependencyUpdates")
addCommandAlias("rdu", ";reload ;dependencyUpdates")
addCommandAlias("ru", ";reload ;test:update")
addCommandAlias("tc", "test:compile")
addCommandAlias("testCoverage", ";clean ;coverageOn ;test ;coverageAggregate ;coverageOff")

// Uncomment to enable offline mode
//offline in ThisBuild := true

/*
 * Publishing settings
 */

import xerial.sbt.Sonatype.GitHubHosting
val publishing = Seq(
  scmInfo := Option(ScmInfo(
    url("http://github.com/marconilanna/scala-boilerplate"),
    "scm:git@github.com:marconilanna/scala-boilerplate.git"
  ))
//sonatypeProfileName := ""
//sonatypeProjectHosting := Option(GitHubHosting("username", "projectName", "user@example.com"))
, pomIncludeRepository := { _ => false }
, publishTo := sonatypePublishTo.value
, publishMavenStyle := true
)

/*
 * Database migration
 */

lazy val databaseMigration = {
  import com.typesafe.config.ConfigFactory

  val conf = ConfigFactory.parseFile(file("common/src/resources/application.conf")).resolve

  Seq(
    flywayUrl := conf.getString("db.url")
  , flywayLocations := Seq("classpath:db/migration")
  , flywaySqlMigrationPrefix := ""
  )
}

/*
 * Scalastyle: http://www.scalastyle.org/
 */

val scalastyleConfiguration = Seq(
  scalastyleConfig := baseDirectory.in(LocalRootProject).value / "project" / "scalastyle-config.xml"
, scalastyleConfig in Test := baseDirectory.in(LocalRootProject).value / "project" / "scalastyle-test-config.xml"
, scalastyleFailOnError := true
, test in Test := test.in(Test)
    .dependsOn(scalastyle.in(Test).toTask(""))
    .dependsOn(scalastyle.in(Compile).toTask(""))
    .value
)

/*
 * WartRemover: http://github.com/wartremover/wartremover
 */

val wartremoverConfiguration = Seq(
  wartremoverErrors ++= Seq(
    Wart.Any
  , Wart.AnyVal
  , Wart.ArrayEquals
  , Wart.AsInstanceOf
  //Wart.DefaultArguments
  , Wart.EitherProjectionPartial
  //Wart.Enumeration
  //Wart.Equals
  , Wart.ExplicitImplicitTypes
  , Wart.FinalCaseClass
  //Wart.FinalVal
  //Wart.ImplicitConversion
  //Wart.ImplicitParameter
  , Wart.IsInstanceOf
  , Wart.JavaConversions
  , Wart.JavaSerializable
  , Wart.LeakingSealed
  //Wart.MutableDataStructures
  //Wart.NonUnitStatements
  , Wart.Nothing
  , Wart.Null
  , Wart.Option2Iterable
  , Wart.OptionPartial
  //Wart.Overloading
  , Wart.Product
  //Wart.PublicInference
  //Wart.Recursion
  , Wart.Return
  , Wart.Serializable
  //Wart.StringPlusAny
  , Wart.Throw
  //Wart.ToString
  , Wart.TraversableOps
  , Wart.TryPartial
  , Wart.Var
  //Wart.While
  //ContribWart.Apply
  , ContribWart.DiscardedFuture
  , ContribWart.ExposedTuples
  , ContribWart.MissingOverride
  , ContribWart.NoNeedImport
  , ContribWart.OldTime
  , ContribWart.RefinedClasstag
  , ContribWart.SealedCaseClass
  , ContribWart.SomeApply
  //ContribWart.SymbolicName
  //ContribWart.UnintendedLaziness
  //ContribWart.UnsafeInheritance
  )
)

/*
 * Scapegoat: http://github.com/sksamuel/scapegoat
 */

scapegoatVersion in ThisBuild := lib.v.scapegoat

val scapegoatConfiguration = Seq(
  scapegoatDisabledInspections := Seq.empty
, scapegoatIgnoredFiles := Seq.empty
, scapegoatReports := Seq("none")
, scalacOptions in Scapegoat += "-P:scapegoat:overrideLevels" +
    ":ArrayEquals=Error" +
    ":ArraysInFormat=Error" +
    ":ArraysToString=Error" +
    ":AsInstanceOf=Error" +
    ":AvoidOperatorOverload=Error" +
    ":AvoidSizeEqualsZero=Error" +
    ":AvoidSizeNotEqualsZero=Error" +
    ":AvoidToMinusOne=Error" +
    ":BigDecimalDoubleConstructor=Error" +
    ":BigDecimalScaleWithoutRoundingMode=Error" +
    ":BoundedByFinalType=Error" +
    ":BrokenOddness=Error" +
    ":CatchException=Error" +
    ":CatchFatal=Error" +
    ":CatchNpe=Error" +
    ":CatchThrowable=Error" +
    ":ClassNames=Error" +
    ":CollectionIndexOnNonIndexedSeq=Error" +
    ":CollectionNamingConfusion=Error" +
    ":CollectionNegativeIndex=Error" +
    ":CollectionPromotionToAny=Error" +
    ":ComparingFloatingPointTypes=Error" +
    ":ComparingUnrelatedTypes=Error" +
    ":ComparisonToEmptyList=Error" +
    ":ComparisonToEmptySet=Error" +
    ":ComparisonWithSelf=Error" +
    ":ConstantIf=Error" +
    ":DivideByOne=Error" +
    ":DoubleNegation=Error" +
    ":DuplicateImport=Error" +
    ":DuplicateMapKey=Error" +
    ":DuplicateSetValue=Error" +
    ":EitherGet=Error" +
    ":EmptyCaseClass=Error" +
    ":EmptyFor=Error" +
    ":EmptyIfBlock=Error" +
    ":EmptyInterpolatedString=Error" +
    ":EmptyMethod=Error" +
    ":EmptySynchronizedBlock=Error" +
    ":EmptyTryBlock=Error" +
    ":EmptyWhileBlock=Error" +
    ":ExistsSimplifiableToContains=Error" +
    ":FilterDotHead=Error" +
    ":FilterDotHeadOption=Error" +
    ":FilterDotIsEmpty=Error" +
    ":FilterDotSize=Error" +
    ":FilterOptionAndGet=Error" +
    ":FinalModifierOnCaseClass=Error" +
    ":FinalizerWithoutSuper=Error" +
    ":FindAndNotEqualsNoneReplaceWithExists=Error" +
    ":FindDotIsDefined=Error" +
    ":IllegalFormatString=Error" +
    ":ImpossibleOptionSizeCondition=Error" +
    ":IncorrectNumberOfArgsToFormat=Error" +
    ":IncorrectlyNamedExceptions=Error" +
    ":InvalidRegex=Error" +
    ":IsInstanceOf=Error" +
    ":JavaConversionsUse=Error" +
    ":ListAppend=Error" +
    ":ListSize=Error" +
    ":LonelySealedTrait=Error" +
    ":LooksLikeInterpolatedString=Error" +
    ":MapGetAndGetOrElse=Error" +
    ":MaxParameters=Error" +
    ":MethodNames=Error" +
    ":MethodReturningAny=Error" +
    ":ModOne=Error" +
    ":NanComparison=Error" +
    ":NegationIsEmpty=Error" +
    ":NegationNonEmpty=Error" +
    ":NoOpOverride=Error" +
    ":NullAssignment=Error" +
    ":NullParameter=Error" +
    ":ObjectNames=Error" +
    ":OptionGet=Error" +
    ":OptionSize=Error" +
    ":ParameterlessMethodReturnsUnit=Error" +
    ":PartialFunctionInsteadOfMatch=Error" +
    ":PointlessTypeBounds=Error" +
    ":PreferMapEmpty=Error" +
    ":PreferSeqEmpty=Error" +
    ":PreferSetEmpty=Error" +
    ":ProductWithSerializableInferred=Error" +
    ":PublicFinalizer=Error" +
    ":RedundantFinalModifierOnMethod=Error" +
    ":RedundantFinalModifierOnVar=Error" +
    ":RedundantFinalizer=Error" +
    ":RepeatedCaseBody=Error" +
    ":RepeatedIfElseBody=Error" +
    ":ReverseFunc=Error" +
    ":ReverseTailReverse=Error" +
    ":ReverseTakeReverse=Error" +
    ":SimplifyBooleanExpression=Error" +
    ":StripMarginOnRegex=Error" +
    ":SubstringZero=Error" +
    ":SuspiciousMatchOnClassObject=Error" +
    ":SwallowedException=Error" +
    ":SwapSortFilter=Error" +
    ":TryGet=Error" +
    ":TypeShadowing=Error" +
    ":UnnecessaryConversion=Error" +
    ":UnnecessaryIf=Error" +
    ":UnnecessaryReturnUse=Error" +
    ":UnreachableCatch=Error" +
    ":UnsafeContains=Error" +
    ":UnsafeStringContains=Error" +
    ":UnsafeTraversableMethods=Error" +
    ":UnusedMethodParameter=Error" +
    ":UseCbrt=Error" +
    ":UseExpM1=Error" +
    ":UseLog10=Error" +
    ":UseLog1P=Error" +
    ":UseSqrt=Error" +
    ":VarClosure=Error" +
    ":VarCouldBeVal=Error" +
    ":VariableShadowing=Error" +
    ":WhileTrue=Error" +
    ":ZeroNumerator=Error"
, test in Test := test.in(Test)
    .dependsOn(scapegoat.in(Test))
    .dependsOn(scapegoat.in(Compile))
    .value
)

val staticAnalysis =
  scalastyleConfiguration ++
  wartremoverConfiguration ++
  scapegoatConfiguration

/*
 * scoverage: http://github.com/scoverage/sbt-scoverage
 */

val codeCoverage = Seq(
  coverageMinimum := 90
, coverageFailOnMinimum := true
, coverageOutputCobertura := true
, coverageOutputHTML := true
, coverageOutputXML := false
)

/*
 * Scalafmt: http://github.com/lucidsoftware/neo-sbt-scalafmt
 */

//val scalafmt = Seq(
//  scalafmtConfig := baseDirectory.in(LocalRootProject).value / "project" / "scalafmt.conf"
//)
