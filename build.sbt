name := "PROJECT"

version := "0.1"

scalaVersion := "2.10.3"

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
	, "-Ywarn-all"
	, "-Ywarn-dead-code"
)

libraryDependencies ++= Seq(
	  "org.scalatest" %% "scalatest" % "latest.release" % "test"
//	, "com.typesafe"  %  "config"    % "0.4.0"
)

// Download and create Eclipse source attachments for library dependencies
// EclipseKeys.withSource := true

showSuccess := true

showTiming := true
