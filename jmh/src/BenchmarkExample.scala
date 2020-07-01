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
package project.jmh

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State

import BenchmarkExample.i
import BenchmarkExample.s

import scala.util.Random

/**
 * Sample benchmark class. To run:
 *
 * {{{$ sbt "jmh/jmh:run project.jmh.BenchmarkExample"}}}
 *
 * Tip: use `jmh/jmh:clean` if things get weird.
 *
 * More info:
 *
 * - [[http://openjdk.java.net/projects/code-tools/jmh/ Project homepage]]
 * - [[http://jar-download.com/artifacts/org.openjdk.jmh/jmh-core/1.21/documentation Javadocs]]
 * - [[http://github.com/ktoso/sbt-jmh sbt plugin]]
 * - [[http://bit.ly/2CKKao3 Samples in Scala]]
 */
@BenchmarkMode(Array(Mode.AverageTime))
class BenchmarkExample {
  @Benchmark
  def ops1(): Unit = {
    s filter (_.size > i)
  }

  @Benchmark
  def ops2(): Unit = {
    s foreach (_.sorted)
  }
}

object BenchmarkExample {
  @State(Scope.Benchmark)
  val i: Int = 100

  @State(Scope.Benchmark)
  val s: Seq[String] = Seq.fill(i) {
    val n = i/2 + (i * Random.nextGaussian).toInt
    Random.alphanumeric.take(n).mkString
  }
}
