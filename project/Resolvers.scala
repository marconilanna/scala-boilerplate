/*
 * Copyright 2011-2018 Marconi Lanna
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
import sbt.Resolver._
import sbt.toRepositoryName

object Resolvers extends Resolvers

trait Resolvers {
  val maven = "maven"
  val public = "public"
  val releases = "releases"
  val snapshots = "snapshots"

  // Default repositories
  def bintray(owner: String, repo: String) = bintrayRepo(owner, repo)
  def bintrayIvy(owner: String, repo: String) = bintrayIvyRepo(owner, repo)

  val jcenter = jcenterRepo

  def sbtPlugin(status: String) = sbtPluginRepo(status)
  def sbtIvy(status: String) = sbtIvyRepo(status)

  val sonatypePublic = sonatypeRepo(public)
  val sonatypeReleases = sonatypeRepo(releases)
  val sonatypeSnapshots = sonatypeRepo(snapshots)

  val typesafeReleases = typesafeRepo(releases)
  val typesafeSnapshots = typesafeRepo(snapshots)

  val typesafeIvyReleases = typesafeIvyRepo(releases)
  val typesafeIvySnapshots = typesafeIvyRepo(snapshots)

  // File repositories
  def user(id: String) = defaultUserFileRepository(id)
  val local = defaultLocal
  val localMaven = mavenLocal
  val shared = defaultShared

  // Custom repositories
  val flyway = "Flyway" at "https://davidmweber.github.io/flyway-sbt.repo"
  val tsec = bintray("jmcardon", "tsec")
}
