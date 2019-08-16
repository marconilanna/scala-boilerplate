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
package project

import org.mockito.Answers
import org.mockito.ArgumentMatchersSugar
import org.mockito.DefaultAnswers
import org.mockito.IdiomaticMockito
import org.mockito.stubbing.DefaultAnswer
import org.scalatest.AsyncFreeSpec
import org.scalatest.DiagrammedAssertions
import org.scalatest.EitherValues
import org.scalatest.FreeSpec
import org.scalatest.OptionValues
import org.scalatest.TryValues

import scala.reflect.ClassTag
import scala.reflect.runtime.universe.WeakTypeTag

// scalastyle:off line.size.limit
/**
 * Base trait for unit tests.
 *
 * Test cases are nested inside text clauses denoted with the dash operator (`-`).
 * Use [[Spec `Spec`]] for general tests and
 * [[AsyncSpec `AsyncSpec`]] for non-blocking asynchronous tests.
 *
 * Mixed-in traits include:
 *
 *  - [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.DiagrammedAssertions `DiagrammedAssertions`]]:
 *  show diagram of expression values when the assertion fails
 *  - [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.EitherValues `EitherValues`]]:
 *  `left.value` and `right.value` methods for `Either`
 *  - [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.OptionValues `OptionValues`]]:
 *  `value` method for `Option`
 *  - [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.TryValues `TryValues`]]:
 *  `success` and `failure` methods for `Try`
 *  - [[https://static.javadoc.io/org.mockito/mockito-scala_2.12/1.1.5/org/mockito/IdiomaticMockito.html `IdiomaticMockito`]] and
 *  - [[https://static.javadoc.io/org.mockito/mockito-scala_2.12/1.1.5/org/mockito/ArgumentMatchersSugar.html `ArgumentMatchersSugar`]]:
 *  syntax sugar for [[https://github.com/mockito/mockito-scala Mockito]]
 *
 * Also consider mixing:
 *
 *  - [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.Inside `Inside`]]:
 *  make assertions about nested object graphs using pattern matching
 *  - [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.Inspectors `Inspectors`]]:
 *  enable assertions to be made about collections
 *  - [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.PartialFunctionValues `PartialFunctionValues`]]:
 *  `valueAt` method for `PartialFunction`
 *  - [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.PrivateMethodTester `PrivateMethodTester`]]:
 *  testing of private methods
 *  - [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.prop.TableDrivenPropertyChecks `TableDrivenPropertyChecks`]]:
 *  property checks against tables of data
 *  - [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.selenium.WebBrowser `WebBrowser`]]:
 *  domain specific language for browser-based tests
 *
 * @see [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.DiagrammedAssertions `DiagrammedAssertions`]]
 * @see [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.EitherValues `EitherValues`]]
 * @see [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.OptionValues `OptionValues`]]
 * @see [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.TryValues `TryValues`]]
 * @see [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.Inside `Inside`]]
 * @see [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.Inspectors `Inspectors`]]
 * @see [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.PartialFunctionValues `PartialFunctionValues`]]
 * @see [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.PrivateMethodTester `PrivateMethodTester`]]
 * @see [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.prop.TableDrivenPropertyChecks `TableDrivenPropertyChecks`]]
 * @see [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.selenium.WebBrowser `WebBrowser`]]
 * @see [[https://static.javadoc.io/org.mockito/mockito-scala_2.12/1.1.5/org/mockito/IdiomaticMockito.html `IdiomaticMockito`]]
 * @see [[https://static.javadoc.io/org.mockito/mockito-scala_2.12/1.1.5/org/mockito/ArgumentMatchersSugar.html `ArgumentMatchersSugar`]]
 * @see [[https://github.com/mockito/mockito-scala Mockito Scala]]
 * @see [[https://github.com/mockito/mockito-scala#idiomatic-mockito Idiomatic Mockito]]
 * @see [[https://medium.com/@bruno.bonanno/introduction-to-mockito-scala-ede30769cbda Introduction to mockito-scala - Part 1]]
 * @see [[https://medium.com/@bruno.bonanno/introduction-to-mockito-scala-part-2-ba1a79cc4c53 Introduction to mockito-scala - Part 2]]
 * @see [[https://medium.com/@bruno.bonanno/introduction-to-mockito-scala-part-3-383c3b2ed55f Introduction to mockito-scala - Part 3]]
 * @see [[https://medium.com/@bruno.bonanno/introduction-to-mockito-scala-part-4-fefa49ea2e23 Introduction to mockito-scala - Part 4]]
 */
trait SpecLike
  extends DiagrammedAssertions
  with EitherValues
  with OptionValues
  with TryValues
  with Mocking

trait Mocking
  extends IdiomaticMockito
  with ArgumentMatchersSugar {
  /**
   * Allows a chain of method calls to be stubbed at once.
   * Falls back to `SmartNull`, pointing out the line where the unstubbed method was called.
   *
   * @see [[https://static.javadoc.io/org.mockito/mockito-core/2.24.5/org/mockito/Mockito.html#RETURNS_DEEP_STUBS `RETURNS_DEEP_STUBS`]]
   * @see [[https://static.javadoc.io/org.mockito/mockito-core/2.24.5/org/mockito/Mockito.html#RETURNS_SMART_NULLS `RETURNS_SMART_NULLS`]]
   *
   * @tparam T the class to be mocked
   * @return a mock object with `Answer` `RETURNS_DEEP_STUBS`
   */
  def mockDeepStubs[T <: AnyRef: ClassTag: WeakTypeTag]: T = {
    mock(DefaultAnswers.ReturnsDeepStubs orElse DefaultAnswers.ReturnsSmartNulls)
  }

  /**
   * Unstubbed method invocations return an "empty" object for well known types.
   * Falls back to `SmartNull`, pointing out the line where the unstubbed method was called.
   *
   * First tries to return ordinary values (zeros, empty collections, empty string, etc.)
   * then it tries to return `SmartNull`, or plain `null` if the return type is final.
   *
   * @see [[https://static.javadoc.io/org.mockito/mockito-core/2.24.5/org/mockito/Mockito.html#RETURNS_SMART_NULLS `RETURNS_SMART_NULLS`]]
   *
   * @tparam T the class to be mocked
   * @return a mock object with `DefaultAnswer` `ReturnsEmptyValues`
   */
  def mockEmptyValues[T <: AnyRef: ClassTag: WeakTypeTag]: T = {
    mock(DefaultAnswers.ReturnsEmptyValues orElse DefaultAnswers.ReturnsSmartNulls)
  }

  /**
   * Returns the mock itself whenever an unstubbed method is invoked
   * that returns a type equal to the class or a superclass.
   * Falls back to `SmartNull`, pointing out the line where the unstubbed method was called.
   *
   * @see [[https://static.javadoc.io/org.mockito/mockito-core/2.24.5/org/mockito/Mockito.html#RETURNS_SELF `RETURNS_SELF`]]
   * @see [[https://static.javadoc.io/org.mockito/mockito-core/2.24.5/org/mockito/Mockito.html#RETURNS_SMART_NULLS `RETURNS_SMART_NULLS`]]
   *
   * @tparam T the class to be mocked
   * @return a mock object with `Answer` `RETURNS_SELF`
   */
  def mockReturnsSelf[T <: AnyRef: ClassTag: WeakTypeTag]: T = {
    mock(Mocking.ReturnsSelf orElse DefaultAnswers.ReturnsSmartNulls)
  }
}

object Mocking {
  val ReturnsSelf: DefaultAnswer = DefaultAnswer(Answers.RETURNS_SELF)
}

/**
 * Base class for general tests.
 *
 * Based on [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.FreeSpec `FreeSpec`]]:
 * nested tests are written inside text clauses denoted with the dash operator (-).
 *
 * @see [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.FreeSpec `FreeSpec`]]
 * @see [[AsyncSpec `AsyncSpec`]] for non-blocking asynchronous tests
 * @see [[SpecLike `SpecLike`]] base trait
 */
abstract class Spec
  extends FreeSpec
  with SpecLike

/**
 * Base class for non-blocking asynchronous tests.
 *
 * Based on [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.AsyncFreeSpec `AsyncFreeSpec`]]:
 * nested tests are written inside text clauses denoted with the dash operator (-).
 *
 * @see [[http://doc.scalatest.org/3.0.0/index.html#org.scalatest.AsyncFreeSpec `AsyncFreeSpec`]]
 * @see [[Spec `Spec`]] for general tests
 * @see [[SpecLike `SpecLike`]] base trait
 */
abstract class AsyncSpec
  extends AsyncFreeSpec
  with SpecLike
