/*
 * Copyright 2011-2020 Marconi Lanna
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
    val akka = "2.6.6"
    val akkaHttp = "10.1.12"
    val jvm = "1.8"
    val macwire = "2.3.7"
    val quartz = "2.3.2"
    val scailCommons = "1.0.0"
    val scala = "2.12.11"
    val scalatest = "3.2.0"
    val scapegoat = "1.4.4"
    val slick = "3.3.2"
    val slickPg = "0.19.0"
    val tsec = "0.2.1"
  }

  // Resolvers
  val resolvers = Seq(
    Resolvers.tsec
  )

  // Java
  val commonsCodec      = "commons-codec"               % "commons-codec"           % "1.14"
  val commonsCompress   = "org.apache.commons"          % "commons-compress"        % "1.20"
  val commonsCsv        = "org.apache.commons"          % "commons-csv"             % "1.8"
  val commonsIo         = "commons-io"                  % "commons-io"              % "2.7"
  val commonsLang       = "org.apache.commons"          % "commons-lang3"           % "3.10"
  val commonsMath       = "org.apache.commons"          % "commons-math3"           % "3.6.1"
  val commonsText       = "org.apache.commons"          % "commons-text"            % "1.8"
  val commonsValidator  = "commons-validator"           % "commons-validator"       % "1.6"
  val guava             = "com.google.guava"            % "guava"                   % "23.0"
  val httpClient        = "org.apache.httpcomponents"   % "httpclient"              % "4.5.12"
  val icu4j             = "com.ibm.icu"                 % "icu4j"                   % "67.1"
  val jBCrypt           = "de.svenkubiak"               % "jBCrypt"                 % "0.4.1"
  val jodaConvert       = "org.joda"                    % "joda-convert"            % "2.2.1"
  val jodaMoney         = "org.joda"                    % "joda-money"              % "1.0.1"
  val jodaTime          = "joda-time"                   % "joda-time"               % "2.10.6"
  val jsoup             = "org.jsoup"                   % "jsoup"                   % "1.13.1"
  val logback           = "ch.qos.logback"              % "logback-classic"         % "1.2.3"
  val modeshapeCommon   = "org.modeshape"               % "modeshape-common"        % "5.4.1.Final"
  val mysql             = "mysql"                       % "mysql-connector-java"    % "8.0.20"
  val postgresql        = "org.postgresql"              % "postgresql"              % "42.2.14"
  val prettyTime        = "org.ocpsoft.prettytime"      % "prettytime"              % "4.0.5.Final"
  val quartz            = "org.quartz-scheduler"        % "quartz"                  % v.quartz
  val quartzJobs        = "org.quartz-scheduler"        % "quartz-jobs"             % v.quartz
  val typesafeConfig    = "com.typesafe"                % "config"                  % "1.4.0"
  val univocity         = "com.univocity"               % "univocity-parsers"       % "2.8.4"

  // Scala
  val akkaActor         = "com.typesafe.akka"          %% "akka-actor"              % v.akka
  val akkaHttp          = "com.typesafe.akka"          %% "akka-http"               % v.akkaHttp
  val akkaStream        = "com.typesafe.akka"          %% "akka-stream"             % v.akka
  val betterFiles       = "com.github.pathikrit"       %% "better-files"            % "3.9.1"
  val java8Compat       = "org.scala-lang.modules"     %% "scala-java8-compat"      % "0.9.1"
  val macwire           = "com.softwaremill.macwire"   %% "macros"                  % v.macwire      % Provided
  val macwireAkka       = "com.softwaremill.macwire"   %% "macrosakka"              % v.macwire      % Provided
  val macwireProxy      = "com.softwaremill.macwire"   %% "proxy"                   % v.macwire
  val macwireUtil       = "com.softwaremill.macwire"   %% "util"                    % v.macwire
  val nscalaTime        = "com.github.nscala-time"     %% "nscala-time"             % "2.24.0"
  val quicklens         = "com.softwaremill.quicklens" %% "quicklens"               % "1.6.0"
  val scailCommons      = "io.github.scailio"          %% "commons"                 % v.scailCommons
  val scalaCompiler     = "org.scala-lang"              % "scala-compiler"          % v.scala
  val scalaLibrary      = "org.scala-lang"              % "scala-library"           % v.scala
  val scalaReflect      = "org.scala-lang"              % "scala-reflect"           % v.scala
  val scalaLogging      = "com.typesafe.scala-logging" %% "scala-logging"           % "3.9.2"
  val scalameta         = "org.scalameta"              %% "scalameta"               % "4.3.18"        % Provided
  val scalametaContrib  = "org.scalameta"              %% "contrib"                 % "4.1.6"        % Provided
  val slick             = "com.typesafe.slick"         %% "slick"                   % v.slick
  val slickHikaricp     = "com.typesafe.slick"         %% "slick-hikaricp"          % v.slick
  val slickJoda         = "com.github.tototoshi"       %% "slick-joda-mapper"       % "2.4.2"
  val slickPg           = "com.github.tminglei"        %% "slick-pg"                % v.slickPg
  val slickPgJoda       = "com.github.tminglei"        %% "slick-pg_joda-time"      % v.slickPg
  val slickPgPlayJson   = "com.github.tminglei"        %% "slick-pg_play-json"      % v.slickPg
  val sttp              = "com.softwaremill.sttp"      %% "core"                    % "1.7.2"
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
  val akkaHttpTestkit   = "com.typesafe.akka"          %% "akka-http-testkit"       % v.akkaHttp     % Test
  val akkaStreamTestkit = "com.typesafe.akka"          %% "akka-stream-testkit"     % v.akka         % Test
  val akkaTestkit       = "com.typesafe.akka"          %% "akka-testkit"            % v.akka         % Test
  val mockito           = "org.mockito"                 % "mockito-core"            % "3.3.3"        % Test
  val mockitoScala      = "org.mockito"                %% "mockito-scala-scalatest" % "1.14.8"       % Test
  val scailCommonsTest  = "io.github.scailio"          %% "commons-test"            % v.scailCommons % Test
  val scalatest         = "org.scalatest"              %% "scalatest-freespec"      % v.scalatest    % Test
  val scalatestDiagrams = "org.scalatest"              %% "scalatest-diagrams"      % v.scalatest    % Test
  val scalatestSelenium = "org.scalatestplus"          %% "selenium-3-141"          % "3.2.0.0"      % Test
  val selenium          = "org.seleniumhq.selenium"     % "selenium-java"           % "3.141.59"     % Test
  val slf4jNop          = "org.slf4j"                   % "slf4j-nop"               % "1.7.30"       % Test
  val slickTestkit      = "com.typesafe.slick"         %% "slick-testkit"           % v.slick        % Test

  // Compiler plug-ins
  val linter            = "org.psywerx.hairyfotr"      %% "linter"                  % "0.1.17"
  val macrosParadise    = "org.scalamacros"             % "paradise"                % "2.1.1"        cross CrossVersion.full

  val commonDependencies = Seq(
    logback
  , scalaLogging
  )

  val testDependencies = Seq(
    mockitoScala
  , scalatest
  , scalatestDiagrams
  )

  val noJavadoc = Set(modeshapeCommon, mysql)

  val allDependencies = Seq( // for dependencyUpdates task
    commonsCodec, commonsCompress, commonsCsv, commonsIo, commonsLang, commonsMath, commonsText
  , commonsValidator, guava, httpClient, icu4j, jBCrypt, jodaConvert, jodaMoney, jodaTime, jsoup
  , logback, modeshapeCommon, mysql, postgresql, prettyTime, quartz, quartzJobs, typesafeConfig
  , univocity, akkaActor, akkaHttp, akkaStream, betterFiles, java8Compat, macwire, macwireAkka
  , macwireProxy, macwireUtil, nscalaTime, quicklens, scailCommons, scalaCompiler, scalaLibrary
  , scalaReflect, scalaLogging, scalameta, scalametaContrib, slick, slickHikaricp, slickJoda
  , slickPg, slickPgJoda, slickPgPlayJson, sttp, tsec, tsecBouncy, tsecCipher, tsecHash, tsecJwtMac
  , tsecJwtSig, tsecMac, tsecPassword, tsecSignature, akkaHttpTestkit, akkaStreamTestkit
  , akkaTestkit, mockito, mockitoScala, scailCommonsTest, scalatest, scalatestDiagrams
  , scalatestSelenium, selenium, slf4jNop, slickTestkit, linter, macrosParadise
  ) map { dependency =>
    if (noJavadoc(dependency)) dependency.withSources
    else dependency.withSources.withJavadoc
  }
}
