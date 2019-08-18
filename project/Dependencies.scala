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
import sbt.CrossVersion
import sbt.Provided
import sbt.Test
import sbt.stringToOrganization

object Dependencies extends Dependencies

trait Dependencies {
  object v {
    val akka = "2.5.25"
    val akkaHttp = "10.1.9"
    val jvm = "1.8"
    val macwire = "2.3.3"
    val quartz = "2.3.1"
    val scala = "2.12.9"
    val scapegoat = "1.3.10"
    val slick = "3.3.2"
    val tsec = "0.2.0-M1"
  }

  // Resolvers
  val resolvers = Seq(
    Resolvers.tsec
  )

  // Java
  val commonsCodec      = "commons-codec"               % "commons-codec"           % "1.13"
  val commonsCompress   = "org.apache.commons"          % "commons-compress"        % "1.18"
  val commonsCsv        = "org.apache.commons"          % "commons-csv"             % "1.7"
  val commonsIo         = "commons-io"                  % "commons-io"              % "2.6"
  val commonsLang       = "org.apache.commons"          % "commons-lang3"           % "3.9"
  val commonsMath       = "org.apache.commons"          % "commons-math3"           % "3.6.1"
  val commonsText       = "org.apache.commons"          % "commons-text"            % "1.7"
  val commonsValidator  = "commons-validator"           % "commons-validator"       % "1.6"
  val guava             = "com.google.guava"            % "guava"                   % "23.0"
  val httpClient        = "org.apache.httpcomponents"   % "httpclient"              % "4.5.9"
  val icu4j             = "com.ibm.icu"                 % "icu4j"                   % "64.2"
  val jBCrypt           = "de.svenkubiak"               % "jBCrypt"                 % "0.4.1"
  val jodaMoney         = "org.joda"                    % "joda-money"              % "1.0.1"
  val jodaTime          = "joda-time"                   % "joda-time"               % "2.10.3"
  val jsoup             = "org.jsoup"                   % "jsoup"                   % "1.12.1"
  val logback           = "ch.qos.logback"              % "logback-classic"         % "1.2.3"
  val modeshapeCommon   = "org.modeshape"               % "modeshape-common"        % "5.4.1.Final"
  val mysql             = "mysql"                       % "mysql-connector-java"    % "8.0.17"
  val postgresql        = "org.postgresql"              % "postgresql"              % "42.2.6"
  val prettyTime        = "org.ocpsoft.prettytime"      % "prettytime"              % "4.0.2.Final"
  val quartz            = "org.quartz-scheduler"        % "quartz"                  % v.quartz
  val quartzJobs        = "org.quartz-scheduler"        % "quartz-jobs"             % v.quartz
  val typesafeConfig    = "com.typesafe"                % "config"                  % "1.3.4"
  val univocity         = "com.univocity"               % "univocity-parsers"       % "2.8.3"

  // Scala
  val akkaActor         = "com.typesafe.akka"          %% "akka-actor"              % v.akka
  val akkaHttp          = "com.typesafe.akka"          %% "akka-http"               % v.akkaHttp
  val akkaStream        = "com.typesafe.akka"          %% "akka-stream"             % v.akka
  val betterFiles       = "com.github.pathikrit"       %% "better-files"            % "3.8.0"
  val java8Compat       = "org.scala-lang.modules"     %% "scala-java8-compat"      % "0.9.0"
  val macwire           = "com.softwaremill.macwire"   %% "macros"                  % v.macwire  % Provided
  val macwireAkka       = "com.softwaremill.macwire"   %% "macrosakka"              % v.macwire  % Provided
  val macwireProxy      = "com.softwaremill.macwire"   %% "proxy"                   % v.macwire
  val macwireUtil       = "com.softwaremill.macwire"   %% "util"                    % v.macwire
  val nscalaTime        = "com.github.nscala-time"     %% "nscala-time"             % "2.22.0"
  val quicklens         = "com.softwaremill.quicklens" %% "quicklens"               % "1.4.12"
  val scalaCompiler     = "org.scala-lang"              % "scala-compiler"          % v.scala
  val scalaLibrary      = "org.scala-lang"              % "scala-library"           % v.scala
  val scalaReflect      = "org.scala-lang"              % "scala-reflect"           % v.scala
  val scalaLogging      = "com.typesafe.scala-logging" %% "scala-logging"           % "3.9.2"
  val scalameta         = "org.scalameta"              %% "scalameta"               % "4.2.1"    % Provided
  val scalametaContrib  = "org.scalameta"              %% "contrib"                 % "4.1.6"    % Provided
  val slick             = "com.typesafe.slick"         %% "slick"                   % v.slick
  val slickHikaricp     = "com.typesafe.slick"         %% "slick-hikaricp"          % v.slick
  val sttp              = "com.softwaremill.sttp"      %% "core"                    % "1.6.4"
  val tsec              = "io.github.jmcardon"         %% "tsec-common"             % v.tsec
  val tsecBouncy        = "io.github.jmcardon"         %% "tsec-bouncy"             % v.tsec
  val tsecCipher        = "io.github.jmcardon"         %% "tsec-cipher-jca"         % v.tsec
  val tsecHash          = "io.github.jmcardon"         %% "tsec-hash-jca"           % v.tsec
  val tsecJwtMac        = "io.github.jmcardon"         %% "tsec-jwt-mac"            % v.tsec
  val tsecJwtSig        = "io.github.jmcardon"         %% "tsec-jwt-sig"            % v.tsec
  val tsecMac           = "io.github.jmcardon"         %% "tsec-mac"                % v.tsec
  val tsecPassword      = "io.github.jmcardon"         %% "tsec-password"           % v.tsec
  val tsecSignature     = "io.github.jmcardon"         %% "tsec-signatures"         % v.tsec

  // Test
  val akkaHttpTestkit   = "com.typesafe.akka"          %% "akka-http-testkit"       % v.akkaHttp % Test
  val akkaStreamTestkit = "com.typesafe.akka"          %% "akka-stream-testkit"     % v.akka     % Test
  val akkaTestkit       = "com.typesafe.akka"          %% "akka-testkit"            % v.akka     % Test
  val mockito           = "org.mockito"                 % "mockito-core"            % "3.0.0"    % Test
  val mockitoScala      = "org.mockito"                %% "mockito-scala-scalatest" % "1.5.14"   % Test
  val scalatest         = "org.scalatest"              %% "scalatest"               % "3.0.8"    % Test
  val selenium          = "org.seleniumhq.selenium"     % "selenium-java"           % "3.141.59" % Test
  val slf4jNop          = "org.slf4j"                   % "slf4j-nop"               % "1.7.28"   % Test
  val slickTestkit      = "com.typesafe.slick"         %% "slick-testkit"           % v.slick    % Test

  // Compiler plug-ins
  val linter            = "org.psywerx.hairyfotr"      %% "linter"                  % "0.1.17"
  val macrosParadise    = "org.scalamacros"             % "paradise"                % "2.1.1"    cross CrossVersion.full

  val commonDependencies = Seq(
    logback
  , scalaLogging
  )

  val testDependencies = Seq(
    mockitoScala
  , scalatest
  )

  val allDependencies = Seq( // for dependencyUpdates task
    commonsCodec, commonsCompress, commonsCsv, commonsIo, commonsLang, commonsMath, commonsText
  , commonsValidator, guava, httpClient, icu4j, jBCrypt, jodaMoney, jodaTime, jsoup, logback
  , modeshapeCommon, mysql, postgresql, prettyTime, quartz, quartzJobs, typesafeConfig, univocity
  , akkaActor, akkaHttp, akkaStream, betterFiles, java8Compat, macwire, macwireAkka, macwireProxy
  , macwireUtil, nscalaTime, quicklens, scalaCompiler, scalaLibrary, scalaReflect, scalaLogging
  , scalameta, scalametaContrib, slick, slickHikaricp, sttp, tsec, tsecBouncy, tsecCipher, tsecHash
  , tsecJwtMac, tsecJwtSig, tsecMac, tsecPassword, tsecSignature, akkaHttpTestkit, akkaStreamTestkit
  , akkaTestkit, mockito, mockitoScala, scalatest, selenium, slf4jNop, slickTestkit, linter
  , macrosParadise
  ) map (_.withSources.withJavadoc)
}
