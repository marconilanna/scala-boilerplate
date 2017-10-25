/*
 * Copyright 2011-2017 Marconi Lanna
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
import sbt.{CrossVersion, Provided, Test, toGroupID}

object Dependencies extends Dependencies

trait Dependencies {
  object v {
    val akka = "2.5.6"
    val akkaHttp = "10.0.10"
    val jvm = "1.8"
    val macwire = "2.3.0"
    val quartz = "2.3.0"
    val scala = "2.12.4"
    val scalafmt = "1.3.0"
    val scapegoat = "1.3.3"
    val slick = "3.2.1"
  }

  // Resolvers
  val resolvers = Seq(
  )

  // Java
  val commonsCodec      = "commons-codec"               % "commons-codec"        % "1.11"
  val commonsCompress   = "org.apache.commons"          % "commons-compress"     % "1.15"
  val commonsCsv        = "org.apache.commons"          % "commons-csv"          % "1.5"
  val commonsIo         = "commons-io"                  % "commons-io"           % "2.6"
  val commonsLang       = "org.apache.commons"          % "commons-lang3"        % "3.6"
  val commonsMath       = "org.apache.commons"          % "commons-math3"        % "3.6.1"
  val commonsText       = "org.apache.commons"          % "commons-text"         % "1.1"
  val commonsValidator  = "commons-validator"           % "commons-validator"    % "1.6"
  val guava             = "com.google.guava"            % "guava"                % "23.0"
  val httpClient        = "org.apache.httpcomponents"   % "httpclient"           % "4.5.3"
  val icu4j             = "com.ibm.icu"                 % "icu4j"                % "59.1"
  val jBCrypt           = "de.svenkubiak"               % "jBCrypt"              % "0.4.1"
  val jodaMoney         = "org.joda"                    % "joda-money"           % "0.12"
  val jodaTime          = "joda-time"                   % "joda-time"            % "2.9.9"
  val jsoup             = "org.jsoup"                   % "jsoup"                % "1.10.3"
  val logback           = "ch.qos.logback"              % "logback-classic"      % "1.2.3"
  val mysql             = "mysql"                       % "mysql-connector-java" % "6.0.6"
  val postgresql        = "org.postgresql"              % "postgresql"           % "42.1.4"
  val quartz            = "org.quartz-scheduler"        % "quartz"               % v.quartz
  val quartzJobs        = "org.quartz-scheduler"        % "quartz-jobs"          % v.quartz
  val typesafeConfig    = "com.typesafe"                % "config"               % "1.3.2"
  val univocity         = "com.univocity"               % "univocity-parsers"    % "2.5.8"

  // Scala
  val akkaActor         = "com.typesafe.akka"          %% "akka-actor"           % v.akka
  val akkaHttp          = "com.typesafe.akka"          %% "akka-http"            % v.akkaHttp
  val akkaStream        = "com.typesafe.akka"          %% "akka-stream"          % v.akka
  val betterFiles       = "com.github.pathikrit"       %% "better-files"         % "3.2.0"
  val macwire           = "com.softwaremill.macwire"   %% "macros"               % v.macwire  % Provided
  val macwireProxy      = "com.softwaremill.macwire"   %% "proxy"                % v.macwire
  val macwireUtil       = "com.softwaremill.macwire"   %% "util"                 % v.macwire
  val nscalaTime        = "com.github.nscala-time"     %% "nscala-time"          % "2.16.0"
  val quicklens         = "com.softwaremill.quicklens" %% "quicklens"            % "1.4.11"
  val scalaLogging      = "com.typesafe.scala-logging" %% "scala-logging"        % "3.7.2"
  val scalameta         = "org.scalameta"              %% "scalameta"            % "2.0.1"    % Provided
  val scalaCompiler     = "org.scala-lang"              % "scala-compiler"       % v.scala
  val scalaLibrary      = "org.scala-lang"              % "scala-library"        % v.scala
  val scalaReflect      = "org.scala-lang"              % "scala-reflect"        % v.scala
  val slick             = "com.typesafe.slick"         %% "slick"                % v.slick
  val slickHikaricp     = "com.typesafe.slick"         %% "slick-hikaricp"       % v.slick

  // Test
  val akkaHttpTestkit   = "com.typesafe.akka"          %% "akka-http-testkit"    % v.akkaHttp % Test
  val akkaStreamTestkit = "com.typesafe.akka"          %% "akka-stream-testkit"  % v.akka     % Test
  val akkaTestkit       = "com.typesafe.akka"          %% "akka-testkit"         % v.akka     % Test
  val mockito           = "org.mockito"                 % "mockito-core"         % "2.11.0"   % Test
  val scalatest         = "org.scalatest"              %% "scalatest"            % "3.0.4"    % Test
  val selenium          = "org.seleniumhq.selenium"     % "selenium-java"        % "3.6.0"    % Test
  val slf4jNop          = "org.slf4j"                   % "slf4j-nop"            % "1.7.25"   % Test
  val slickTestkit      = "com.typesafe.slick"         %% "slick-testkit"        % v.slick    % Test

  // Compiler plug-ins
  val linter         = "org.psywerx.hairyfotr" %% "linter"   % "0.1.17"
  val macrosParadise = "org.scalamacros"        % "paradise" % "2.1.1"     cross CrossVersion.full
  val metaParadise   = "org.scalameta"          % "paradise" % "3.0.0-M10" cross CrossVersion.full

  val commonDependencies = Seq(
    logback
  , scalaLogging
  )

  val testDependencies = Seq(
    mockito
  , scalatest
  )

  val allDependencies = Seq( // for dependencyUpdates task
    commonsCodec, commonsCompress, commonsCsv, commonsIo, commonsLang, commonsMath, commonsText
  , commonsValidator, guava, httpClient, icu4j, jBCrypt, jodaMoney, jodaTime, jsoup, logback, mysql
  , postgresql, quartz, quartzJobs, typesafeConfig, univocity, akkaActor, akkaHttp, akkaStream
  , betterFiles, macwire, macwireProxy, macwireUtil, nscalaTime, quicklens, scalaLogging, scalameta
  , scalaCompiler, scalaLibrary, scalaReflect, slick, slickHikaricp, akkaHttpTestkit
  , akkaStreamTestkit, akkaTestkit, mockito, scalatest, selenium, slf4jNop, slickTestkit, linter
  , macrosParadise, metaParadise
  )
}
