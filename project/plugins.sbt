resolvers += Resolver.sonatypeRepo("releases")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.7.0")

addSbtPlugin("org.brianmckenna" % "sbt-wartremover" % "0.13")

// Adds a `dependencyUpdates` task to check Maven repositories for dependency updates
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.1.8")

// Creates Eclipse project definitions (.classpath, .project, .settings/)
//addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "3.0.0")
