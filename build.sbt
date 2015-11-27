/*
 * Copyright 2011-2015 Marconi Lanna
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

/*
 * Project metadata
 */

name := "PROJECT"

version := "0.1"

description := "PROJECT DESCRIPTION"

// organization := "org.example"

// organizationName := "Example, Inc."

// organizationHomepage := Some(url("http://example.org"))

// homepage := Some(url("http://project.org"))

startYear := Some(2015)

licenses += "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")
// "GPLv2" -> url("http://www.gnu.org/licenses/gpl-2.0.html")

/*
 * scalac configuration
 */

scalaVersion in ThisBuild := "2.11.7"

scalaSource in Compile := baseDirectory.value / "src"

javaSource in Compile := baseDirectory.value / "src"

scalaSource in Test := baseDirectory.value / "test"

javaSource in Test := baseDirectory.value / "test"

resourceDirectory in Test := (scalaSource in Test).value / "resources"

compileOrder := CompileOrder.JavaThenScala

val commonScalacOptions = Seq(
  "-encoding", "UTF-8" // Specify character encoding used by source files
, "-target:jvm-1.8" // Target platform for object files
, "-Xexperimental" // Enable experimental extensions
, "-Xfuture" // Turn on future language features
, "-Ybackend:GenBCode" // Choice of bytecode emitter
)

scalacOptions ++= commonScalacOptions ++ Seq(
  "-deprecation" // Emit warning and location for usages of deprecated APIs
, "-feature" // Emit warning and location for usages of features that should be imported explicitly
, "-g:vars" // Set level of generated debugging info: none, source, line, vars, notailcalls
//"-language:_" // Enable or disable language features (see list below)
, "-optimise" // Generates faster bytecode by applying optimisations to the program
, "-unchecked" // Enable additional warnings where generated code depends on assumptions
//"-Xdev" // Indicates user is a developer - issue warnings about anything which seems amiss (Doesn't play well with ScalaTest)
, "-Xfatal-warnings" // Fail the compilation if there are any warnings
, "-Xlint:_" // Enable or disable specific warnings (see list below)
, "-Yclosure-elim" // Perform closure elimination
, "-Yconst-opt" // Perform optimization with constant values
, "-Ydead-code" // Perform dead code elimination
, "-Yinline" // Perform inlining when possible
, "-Yinline-handlers" // Perform exception handler inlining when possible
, "-Yinline-warnings" // Emit inlining warnings
, "-Yno-adapted-args" // Do not adapt an argument list to match the receiver
//"-Yno-imports" // Compile without importing scala.*, java.lang.*, or Predef
//"-Yno-predef" // Compile without importing Predef
, "-Yopt:_" // Enable optimizations
, "-Ywarn-dead-code" // Warn when dead code is identified
//"-Ywarn-numeric-widen" // Warn when numerics are widened (Not really useful)
, "-Ywarn-unused" // Warn when local and private vals, vars, defs, and types are unused
, "-Ywarn-unused-import" // Warn when imports are unused
, "-Ywarn-value-discard" // Warn when non-Unit expression results are unused
)

scalacOptions in (Compile, console) := commonScalacOptions ++ Seq(
  "-language:_" // Enable or disable language features (see list below)
, "-nowarn" // Generate no warnings
)

scalacOptions in (Test, console) := (scalacOptions in (Compile, console)).value


/*
scalac -language:help

dynamics             Allow direct or indirect subclasses of scala.Dynamic
existentials         Existential types (besides wildcard types) can be written and inferred
experimental.macros  Allow macro defintion (besides implementation and application)
higherKinds          Allow higher-kinded types
implicitConversions  Allow definition of implicit functions called views
postfixOps           Allow postfix operator notation, such as `1 to 10 toList'
reflectiveCalls      Allow reflective access to members of structural types

*//*

scalac -Xlint:help

adapted-args               Warn if an argument list is modified to match the receiver
by-name-right-associative  By-name parameter of right associative operator
delayedinit-select         Selecting member of DelayedInit
doc-detached               A ScalaDoc comment appears to be detached from its element
inaccessible               Warn about inaccessible types in method signatures
infer-any                  Warn when a type argument is inferred to be `Any`
missing-interpolator       A string literal appears to be missing an interpolator id
nullary-override           Warn when non-nullary `def f()' overrides nullary `def f'
nullary-unit               Warn when nullary methods return Unit
option-implicit            Option.apply used implicit view
package-object-classes     Class or object defined in package object
poly-implicit-overload     Parameterized overloaded implicit methods are not visible as view bounds
private-shadow             A private field (or class parameter) shadows a superclass field
stars-align                Pattern sequence wildcard must align with sequence component
type-parameter-shadow      A local type parameter shadows a type already in scope
unsound-match              Pattern match may not be typesafe

*//*

scalac -Yopt:help

compact-locals      Eliminate empty slots in the sequence of local variables
empty-labels        Eliminate and collapse redundant labels in the bytecode
empty-line-numbers  Eliminate unnecessary line number information
inline-global       Inline methods from any source, including classfiles on the compile classpath
inline-project      Inline only methods defined in the files being compiled
nullness-tracking   Track nullness / non-nullness of local variables and apply optimizations
simplify-jumps      Simplify branching instructions, eliminate unnecessary ones
unreachable-code    Eliminate unreachable code, exception handlers protecting no instructions, debug information of eliminated variables
l:none              Don't enable any optimizations
l:default           Enable default optimizations: unreachable-code
l:method            Enable intra-method optimizations: unreachable-code,simplify-jumps,empty-line-numbers,empty-labels,compact-locals,nullness-tracking
l:project           Enable cross-method optimizations within the current project: l:method,inline-project
l:classpath         Enable cross-method optimizations across the entire classpath: l:project,inline-global
*/

/*
 * Managed dependencies
 */

libraryDependencies ++= Seq(
  "commons-codec"                     % "commons-codec"                    % "1.10"
, "commons-io"                        % "commons-io"                       % "2.4"
, "commons-validator"                 % "commons-validator"                % "1.4.1"
, "joda-time"                         % "joda-time"                        % "2.9.1"
, "mysql"                             % "mysql-connector-java"             % "5.1.37"
, "ch.qos.logback"                    % "logback-classic"                  % "1.1.3"
, "com.github.pathikrit"             %% "better-files"                     % "2.13.0"
, "com.github.nscala-time"           %% "nscala-time"                      % "2.6.0"
, "com.github.t3hnar"                %% "scala-bcrypt"                     % "2.5"
, "com.google.guava"                  % "guava"                            % "18.0"
, "com.ibm.icu"                       % "icu4j"                            % "56.1"
, "com.softwaremill.quicklens"       %% "quicklens"                        % "1.4.2"
, "com.typesafe"                      % "config"                           % "1.3.0"
, "com.typesafe.scala-logging"       %% "scala-logging"                    % "3.1.0"
, "com.typesafe.slick"               %% "slick"                            % "3.1.0"
, "com.univocity"                     % "univocity-parsers"                % "1.5.6"
, "org.apache.commons"                % "commons-compress"                 % "1.10"
, "org.apache.commons"                % "commons-csv"                      % "1.2"
, "org.apache.commons"                % "commons-lang3"                    % "3.4"
, "org.apache.commons"                % "commons-math3"                    % "3.5"
, "org.apache.httpcomponents"         % "httpclient"                       % "4.5.1"
, "org.joda"                          % "joda-money"                       % "0.10.0"
, "org.jsoup"                         % "jsoup"                            % "1.8.3"
, "org.scalactic"                    %% "scalactic"                        % "2.2.5"
, "org.mockito"                       % "mockito-core"                     % "1.10.19"      % Test
, "org.scalamock"                    %% "scalamock-scalatest-support"      % "3.2.2"        % Test
, "org.scalatest"                    %% "scalatest"                        % "2.2.5"        % Test
, "org.seleniumhq.selenium"           % "selenium-java"                    % "2.48.2"       % Test
)

/*
 * Statements executed when starting the Scala REPL (sbt's `console` task)
 */

initialCommands := """
import
  scala.annotation.{switch, tailrec}
, scala.beans.{BeanProperty, BooleanBeanProperty}
, scala.collection.JavaConverters._
, scala.collection.mutable
, scala.concurrent.{Await, Future}
, scala.concurrent.ExecutionContext.Implicits.global
, scala.concurrent.duration._
, scala.language.experimental.macros
, scala.reflect.macros.blackbox
, scala.util.{Failure, Random, Success, Try}
, scala.util.control.NonFatal
, System.{currentTimeMillis => now}
, System.nanoTime

def desugarImpl[T](c: blackbox.Context)(expr: c.Expr[T]): c.Expr[Unit] = {
  import c.universe._, scala.io.AnsiColor.{BOLD, GREEN, RESET}

  val exp = show(expr.tree)
  val typ = expr.actualType.toString takeWhile '('.!=

  println(s"$exp: $BOLD$GREEN$typ$RESET")
  reify { (): Unit }
}

def desugar[T](expr: T): Unit = macro desugarImpl[T]
"""

/*
 * Scalastyle: http://www.scalastyle.org/
 */

scalastyleConfig := baseDirectory.value / "project" / "scalastyle-config.xml"

scalastyleFailOnError := true

// Create a default Scalastyle task to run with tests
lazy val mainScalastyle = taskKey[Unit]("mainScalastyle")
lazy val testScalastyle = taskKey[Unit]("testScalastyle")

mainScalastyle := org.scalastyle.sbt.ScalastylePlugin.scalastyle.in(Compile).toTask("").value
testScalastyle := org.scalastyle.sbt.ScalastylePlugin.scalastyle.in(Test).toTask("").value

(test in Test) <<= (test in Test) dependsOn testScalastyle
(test in Test) <<= (test in Test) dependsOn mainScalastyle

/*
 * WartRemover: http://github.com/puffnfresh/wartremover
 */

wartremoverErrors ++= Seq(
  Wart.Any
, Wart.Any2StringAdd
, Wart.AsInstanceOf
, Wart.EitherProjectionPartial
//Wart.Enumeration
, Wart.ExplicitImplicitTypes
, Wart.FinalCaseClass
, Wart.IsInstanceOf
, Wart.JavaConversions
, Wart.ListOps
//Wart.MutableDataStructures
, Wart.NonUnitStatements
, Wart.Nothing
, Wart.Null
, Wart.Option2Iterable
, Wart.OptionPartial
, Wart.Product
, Wart.Return
, Wart.Serializable
, Wart.Throw
//Wart.ToString
, Wart.TryPartial
, Wart.Var
)

/*
 * Scapegoat: http://github.com/sksamuel/scalac-scapegoat-plugin
 */

scapegoatDisabledInspections := Seq()

/*
 * Linter: http://github.com/HairyFotr/linter
 */

addCompilerPlugin("org.psywerx.hairyfotr" %% "linter" % "0.1.12")

scalacOptions += "-P:linter:enable-only:" +
  "AssigningOptionToNull+" +
  "AvoidOptionCollectionSize+" +
  "AvoidOptionMethod+" +
  "AvoidOptionStringSize+" +
  "BigDecimalNumberFormat+" +
  "BigDecimalPrecisionLoss+" +
  "CloseSourceFile+" +
  "ContainsTypeMismatch+" +
  "DecomposingEmptyCollection+" +
  "DivideByOne+" +
  "DivideByZero+" +
  "DuplicateIfBranches+" +
  "DuplicateKeyInMap+" +
  "EmptyStringInterpolator+" +
  "FilterFirstThenSort+" +
  "FuncFirstThenMap+" +
  "IdenticalCaseBodies+" +
  "IdenticalCaseConditions+" +
  "IdenticalIfCondition+" +
  "IdenticalIfElseCondition+" +
  "IdenticalStatements+" +
  "IfDoWhile+" +
  "IndexingWithNegativeNumber+" +
  "InefficientUseOfListSize+" +
  "IntDivisionAssignedToFloat+" +
  "InvalidParamToRandomNextInt+" +
  "InvalidStringConversion+" +
  "InvalidStringFormat+" +
  "InvariantCondition+" +
  "InvariantExtrema+" +
  "InvariantReturn+" +
  "JavaConverters+" +
  "LikelyIndexOutOfBounds+" +
  "MalformedSwap+" +
  "MergeMaps+" +
  "MergeNestedIfs+" +
  "ModuloByOne+" +
  "NumberInstanceOf+" +
  "OnceEvaluatedStatementsInBlockReturningFunction+" +
  "OperationAlwaysProducesZero+" +
  "OptionOfOption+" +
  "PassPartialFunctionDirectly+" +
  "PatternMatchConstant+" +
  "PossibleLossOfPrecision+" +
  "PreferIfToBooleanMatch+" +
  "ProducesEmptyCollection+" +
  "ReflexiveAssignment+" +
  "ReflexiveComparison+" +
  "RegexWarning+" +
  "StringMultiplicationByNonPositive+" +
  "SuspiciousMatches+" +
  "TransformNotMap+" +
  "TypeToType+" +
  "UndesirableTypeInference+" +
  "UnextendedSealedTrait+" +
  "UnitImplicitOrdering+" +
  "UnlikelyEquality+" +
  "UnlikelyToString+" +
  "UnnecessaryMethodCall+" +
  "UnnecessaryReturn+" +
  "UnnecessaryStringIsEmpty+" +
  "UnnecessaryStringNonEmpty+" +
  "UnsafeAbs+" +
  "UnthrownException+" +
  "UnusedForLoopIteratorValue+" +
  "UnusedParameter+" +
  "UseAbsNotSqrtSquare+" +
  "UseCbrt+" +
  "UseConditionDirectly+" +
  "UseContainsNotExistsEquals+" +
  "UseCountNotFilterLength+" +
  "UseExistsNotCountCompare+" +
  "UseExistsNotFilterEmpty+" +
  "UseExistsNotFilterIsEmpty+" +
  "UseExistsNotFindIsDefined+" +
  "UseExp+" +
  "UseExpm1+" +
  "UseFilterNotFlatMap+" +
  "UseFindNotFilterHead+" +
  "UseFlattenNotFilterOption+" +
  "UseFuncNotFold+" +
  "UseFuncNotReduce+" +
  "UseGetOrElseOnOption+" +
  "UseHypot+" +
  "UseIfExpression+" +
  "UseIsNanNotNanComparison+" +
  "UseIsNanNotSelfComparison+" +
  "UseLog10+" +
  "UseLog1p+" +
  "UseMapNotFlatMap+" +
  "UseMinOrMaxNotSort+" +
  "UseOptionGetOrElse+" +
  "UseOptionOrNull+" +
  "UseQuantifierFuncNotFold+" +
  "UseSignum+" +
  "UseSqrt+" +
  "UseUntilNotToMinusOne+" +
  "VariableAssignedUnusedValue+" +
  "WrapNullWithOption+" +
  "YodaConditions+" +
  "ZeroDivideBy"

/*
 * scoverage: http://github.com/scoverage/sbt-scoverage
 */

coverageMinimum := 90

coverageFailOnMinimum := true

coverageOutputCobertura := false

coverageOutputHTML := true

coverageOutputXML := false

/*
 * Scalariform: http://github.com/daniel-trinh/scalariform
 */

import scalariform.formatter.preferences._

defaultScalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignArguments, false)
  .setPreference(AlignParameters, false)
  .setPreference(AlignSingleLineCaseStatements, false)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 12)
  .setPreference(CompactControlReadability, false)
  .setPreference(CompactStringConcatenation, false)
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(FormatXml, false)
  .setPreference(IndentLocalDefs, false)
  .setPreference(IndentPackageBlocks, true)
  .setPreference(IndentSpaces, 2)
  .setPreference(IndentWithTabs, false)
  .setPreference(MultilineScaladocCommentsStartOnFirstLine, false)
  .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk, false)
  .setPreference(PreserveDanglingCloseParenthesis, true)
  .setPreference(PreserveSpaceBeforeArguments, false)
  .setPreference(RewriteArrowSymbols, false)
  .setPreference(SpaceBeforeColon, false)
  .setPreference(SpaceInsideBrackets, false)
  .setPreference(SpaceInsideParentheses, false)
  .setPreference(SpacesAroundMultiImports, false)
  .setPreference(SpacesWithinPatternBinders, true)

/*
 * sbt options
 */

// Uncomment to enable offline mode
// offline := true

showSuccess := true

showTiming := true

// Draw a separator between triggered runs (e.g, ~test)
triggeredMessage := { ws =>
  if (ws.count > 1) {
    val nl = System.lineSeparator * 2
    nl + "#" * 100 + nl
  } else ""
}

// Do not exit sbt when Ctrl-C is used to stop a running app
cancelable in Global := true

// Improved incremental compilation
incOptions := incOptions.value.withNameHashing(true)

// Improved dependency management
updateOptions := updateOptions.value.withCachedResolution(true)

// Enable colors in Scala console (2.11.4)
initialize ~= { _ =>
  val ansi = System.getProperty("sbt.log.noformat", "false") != "true"
  if (ansi) System.setProperty("scala.color", "true")
}

shellPrompt := { state =>
  import scala.Console.{BLUE, BOLD, RESET}
  val p = Project.extract(state)
  val name = p.getOpt(sbt.Keys.name) getOrElse p.currentProject.id
  s"$BLUE$BOLD$name$RESET $BOLD\u25b6$RESET "
}

net.virtualvoid.sbt.graph.Plugin.graphSettings

// Download and create Eclipse source attachments for library dependencies
// EclipseKeys.withSource := true
