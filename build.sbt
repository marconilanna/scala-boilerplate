name := "PROJECT"

version := "0.2"

scalaVersion := "2.9.1"

scalaSource in Compile <<= baseDirectory(_ / "src")

scalaSource in Test <<= baseDirectory(_ / "test")

scalacOptions ++= "-deprecation" :: "-unchecked" :: Nil

libraryDependencies ++=
	"org.scalatest" %% "scalatest" % "latest.release" % "test" ::
	Nil
