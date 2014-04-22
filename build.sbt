name := "PROJECT"

version := "0.1"

scalaVersion := "2.11.0"

scalaSource in Compile <<= baseDirectory(_ / "src")

javaSource in Compile <<= baseDirectory(_ / "src")

scalaSource in Test <<= baseDirectory(_ / "test")

javaSource in Test <<= baseDirectory(_ / "test")

scalacOptions ++= Seq(
	  "-deprecation"
	, "-feature"
	, "-unchecked"
	, "-Xfatal-warnings"
	, "-Xlint"
	, "-Yno-adapted-args"
	, "-Ywarn-dead-code"
)

libraryDependencies ++= Seq(
	  "org.scalatest" %% "scalatest" % "latest.release" % "test"
//	, "com.typesafe"  %  "config"    % "0.4.0"
)

incOptions := incOptions.value.withNameHashing(true)

// Download and create Eclipse source attachments for library dependencies
// EclipseKeys.withSource := true

showSuccess := true

showTiming := true
