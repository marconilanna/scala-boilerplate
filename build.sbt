name := "PROJECT"

version := "0.1"

scalaVersion := "2.11.0"

scalaSource in Compile <<= baseDirectory(_ / "src")

javaSource in Compile <<= baseDirectory(_ / "src")

scalaSource in Test <<= baseDirectory(_ / "test")

javaSource in Test <<= baseDirectory(_ / "test")

scalacOptions ++= Seq(
	  "-deprecation"          // Emit warning and location for usages of deprecated APIs.
	, "-feature"              // Emit warning and location for usages of features that should be imported explicitly.
	, "-unchecked"            // Enable additional warnings where generated code depends on assumptions.
	, "-Xfatal-warnings"      // Fail the compilation if there are any warnings.
	, "-Xlint"                // Enable recommended additional warnings.
	, "-Yno-adapted-args"     // Do not adapt an argument list to match the receiver.
	, "-Ywarn-dead-code"      // Warn when dead code is identified.
)

libraryDependencies ++= Seq(
	  "org.scalatest" %% "scalatest" % "latest.release" % "test"
//	, "com.typesafe"  %  "config"    % "1.2.0"
)

incOptions := incOptions.value.withNameHashing(true)

// Download and create Eclipse source attachments for library dependencies
// EclipseKeys.withSource := true

showSuccess := true

showTiming := true
