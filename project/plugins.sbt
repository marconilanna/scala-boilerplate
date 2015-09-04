resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
, Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(Resolver.ivyStylePatterns)
)

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.7.0")

addSbtPlugin("org.brianmckenna" % "sbt-wartremover" % "0.14")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.3.1")

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.4.0")

// Adds a `dependencyUpdates` task to check Maven repositories for dependency updates
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.1.9")

addSbtPlugin("com.orrsella" % "sbt-stats" % "1.0.5")

// Creates Eclipse project definitions (.classpath, .project, .settings/)
//addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "4.0.0")
