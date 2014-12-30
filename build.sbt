name := "PROJECT"

version := "0.1"

scalaVersion := "2.11.4"

scalaSource in Compile <<= baseDirectory(_ / "src")

javaSource in Compile <<= baseDirectory(_ / "src")

scalaSource in Test <<= baseDirectory(_ / "test")

javaSource in Test <<= baseDirectory(_ / "test")

scalacOptions ++= Seq(
	"-deprecation"          // Emit warning and location for usages of deprecated APIs
,
	"-encoding", "UTF-8"    // Specify character encoding used by source files
,
	"-feature"              // Emit warning and location for usages of features that should be imported explicitly
,
	"-unchecked"            // Enable additional warnings where generated code depends on assumptions
,
	"-Xfatal-warnings"      // Fail the compilation if there are any warnings
,
	"-Xlint:_"              // Enable all specific warnings (see list below)
,
	"-Yno-adapted-args"     // Do not adapt an argument list to match the receiver
,
	"-Ywarn-dead-code"      // Warn when dead code is identified
,
	"-Ywarn-unused"         // Warn when local and private vals, vars, defs, and types are are unused
,
	"-Ywarn-unused-import"  // Warn when imports are unused
,
	"-Ywarn-value-discard"  // Warn when non-Unit expression results are unused
)

/*
scala -Xlint:help

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
type-parameter-shadow      A local type parameter shadows a type already in scope
unsound-match              Pattern match may not be typesafe
*/

libraryDependencies ++= Seq(
	"org.scalatest" %% "scalatest" % "latest.release" % "test"
//	"com.typesafe"  %  "config"    % "1.2.1"
)

// Improved incremental compilation
incOptions := incOptions.value.withNameHashing(true)

// Download and create Eclipse source attachments for library dependencies
// EclipseKeys.withSource := true

showSuccess := true

showTiming := true
