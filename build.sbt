name := "PROJECT"

version := "0.1"

scalaVersion := "2.9.1"

scalaSource in Compile <<= baseDirectory(_ / "src")

javaSource in Compile <<= baseDirectory(_ / "src")

scalaSource in Test <<= baseDirectory(_ / "test")

javaSource in Test <<= baseDirectory(_ / "test")

scalacOptions ++= "-deprecation" :: "-unchecked" :: Nil

libraryDependencies ++=
	"org.scalatest" %% "scalatest" % "latest.release" % "test" ::
	Nil

// Download and create Eclipse source attachments for library dependencies
// EclipseKeys.withSource := true
