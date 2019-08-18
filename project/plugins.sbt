/*
 * Copyright 2011-2019 Marconi Lanna
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
resolvers ++= Seq(
  Resolvers.flyway
, Resolvers.sonatypeReleases
)

// http://www.scalastyle.org/
// http://github.com/scalastyle/scalastyle-sbt-plugin
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")

// http://github.com/wartremover/wartremover
addSbtPlugin("org.wartremover" % "sbt-wartremover" % "2.4.2")

// http://github.com/wartremover/wartremover-contrib/
addSbtPlugin("org.wartremover" % "sbt-wartremover-contrib" % "1.3.1")

// http://github.com/danielnixon/extrawarts
addSbtPlugin("org.danielnixon" % "sbt-extrawarts" % "1.0.3")

// http://github.com/sksamuel/scapegoat
// http://github.com/sksamuel/sbt-scapegoat
addSbtPlugin("com.sksamuel.scapegoat" %% "sbt-scapegoat" % "1.0.9")

// http://github.com/scoverage/sbt-scoverage
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.6.0")

// http://github.com/ktoso/sbt-jmh
addSbtPlugin("pl.project13.scala" % "sbt-jmh" % "0.3.7")

// http://flywaydb.org/documentation/sbt/
addSbtPlugin("io.github.davidmweber" % "flyway-sbt" % "5.2.0")

// http://github.com/scala-ide/scalariform
// http://github.com/sbt/sbt-scalariform
//addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.8.3")

// http://scalameta.org/scalafmt
//addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.0.3")

// Adds a `dependencyUpdates` task to check Maven repositories for dependency updates
// http://github.com/rtimush/sbt-updates
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.4.2")

// http://github.com/jrudolph/sbt-dependency-graph
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.2")

// http://github.com/sbt/sbt-license-report
addSbtPlugin("com.typesafe.sbt" % "sbt-license-report" % "1.2.0")

// http://github.com/orrsella/sbt-stats
addSbtPlugin("com.orrsella" % "sbt-stats" % "1.0.7")

// http://github.com/Duhemm/sbt-errors-summary
addSbtPlugin("org.duhemm" % "sbt-errors-summary" % "0.6.3")

// http://github.com/sbt/sbt-dirty-money
addSbtPlugin("com.eed3si9n" % "sbt-dirty-money" % "0.2.0")

// http://github.com/coursier/coursier
addSbtPlugin("io.get-coursier" % "sbt-coursier" % "2.0.0-RC3-3")

// Creates Eclipse project definitions (.classpath, .project, .settings/)
// http://github.com/typesafehub/sbteclipse
//addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")
