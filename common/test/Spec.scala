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
package project

import org.mockito.Answers
import org.mockito.ArgumentMatchersSugar
import org.mockito.DefaultAnswers
import org.mockito.IdiomaticMockito
import org.mockito.stubbing.DefaultAnswer
import org.scalatest.EitherValues
import org.scalatest.OptionValues
import org.scalatest.TryValues
import org.scalatest.diagrams.Diagrams
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.freespec.AsyncFreeSpec

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
 *  - [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/diagrams/Diagrams.html `Diagrams`]]:
 *  show diagram of expression values when the assertion fails
 *  - [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/EitherValues.html `EitherValues`]]:
 *  `left.value` and `right.value` methods for `Either`
 *  - [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/OptionValues.html `OptionValues`]]:
 *  `value` method for `Option`
 *  - [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/TryValues.html `TryValues`]]:
 *  `success` and `failure` methods for `Try`
 *
 * Also consider mixing:
 *
 *  - [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/Inside.html `Inside`]]:
 *  make assertions about nested object graphs using pattern matching
 *  - [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/Inspectors.html `Inspectors`]]:
 *  enable assertions to be made about collections
 *  - [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/PartialFunctionValues.html `PartialFunctionValues`]]:
 *  `valueAt` method for `PartialFunction`
 *  - [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/PrivateMethodTester.html `PrivateMethodTester`]]:
 *  testing of private methods
 *  - [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/prop/TableDrivenPropertyChecks.html `TableDrivenPropertyChecks`]]:
 *  property checks against tables of data
 *  - [[http://javadoc.io/doc/org.scalatestplus/selenium-3-141_2.12/latest/org/scalatestplus/selenium/WebBrowser.html `WebBrowser`]]:
 *  domain specific language for browser-based tests
 *
 * @see [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/diagrams/Diagrams.html `Diagrams`]]
 * @see [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/EitherValues.html `EitherValues`]]
 * @see [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/OptionValues.html `OptionValues`]]
 * @see [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/TryValues.html `TryValues`]]
 * @see [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/Inside.html `Inside`]]
 * @see [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/Inspectors.html `Inspectors`]]
 * @see [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/PartialFunctionValues.html `PartialFunctionValues`]]
 * @see [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/PrivateMethodTester.html `PrivateMethodTester`]]
 * @see [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/prop/TableDrivenPropertyChecks.html `TableDrivenPropertyChecks`]]
 * @see [[http://javadoc.io/doc/org.scalatestplus/selenium-3-141_2.12/latest/org/scalatestplus/selenium/WebBrowser.html `WebBrowser`]]
 */
trait SpecLike
  extends Diagrams
  with EitherValues
  with OptionValues
  with TryValues

/**
 * Base trait for mocking.
 *
 * Mixed-in traits include:
 *
 *  - [[http://javadoc.io/doc/org.mockito/mockito-scala_2.12/latest/org/mockito/IdiomaticMockito.html `IdiomaticMockito`]]
 *  - [[http://javadoc.io/doc/org.mockito/mockito-scala_2.12/latest/org/mockito/ArgumentMatchersSugar.html `ArgumentMatchersSugar`]]:
 *  syntax sugar for [[http://github.com/mockito/mockito-scala Mockito]]
 *
 * @see [[http://javadoc.io/doc/org.mockito/mockito-scala_2.12/latest/org/mockito/IdiomaticMockito.html `IdiomaticMockito`]]
 * @see [[http://javadoc.io/doc/org.mockito/mockito-scala_2.12/latest/org/mockito/ArgumentMatchersSugar.html `ArgumentMatchersSugar`]]
 * @see [[http://github.com/mockito/mockito-scala Mockito Scala]]
 * @see [[http://github.com/mockito/mockito-scala#idiomatic-mockito Idiomatic Mockito]]
 * @see [[http://medium.com/@bruno.bonanno/introduction-to-mockito-scala-ede30769cbda Introduction to mockito-scala - Part 1]]
 * @see [[http://medium.com/@bruno.bonanno/introduction-to-mockito-scala-part-2-ba1a79cc4c53 Introduction to mockito-scala - Part 2]]
 * @see [[http://medium.com/@bruno.bonanno/introduction-to-mockito-scala-part-3-383c3b2ed55f Introduction to mockito-scala - Part 3]]
 * @see [[http://medium.com/@bruno.bonanno/introduction-to-mockito-scala-part-4-fefa49ea2e23 Introduction to mockito-scala - Part 4]]
 */
trait Mocking
  extends IdiomaticMockito
  with ArgumentMatchersSugar {
  /**
   * Allows a chain of method calls to be stubbed at once.
   * Falls back to `SmartNull`, pointing out the line where the unstubbed method was called.
   *
   * @see [[http://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#RETURNS_DEEP_STUBS `RETURNS_DEEP_STUBS`]]
   * @see [[http://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#RETURNS_SMART_NULLS `RETURNS_SMART_NULLS`]]
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
   * @see [[http://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#RETURNS_SMART_NULLS `RETURNS_SMART_NULLS`]]
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
   * @see [[http://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#RETURNS_SELF `RETURNS_SELF`]]
   * @see [[http://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#RETURNS_SMART_NULLS `RETURNS_SMART_NULLS`]]
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
 * Based on [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/freespec/AnyFreeSpec.html `AnyFreeSpec`]]:
 * nested tests are written inside text clauses denoted with the dash operator (-).
 *
 * @see [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/freespec/AnyFreeSpec.html `AnyFreeSpec`]]
 * @see [[AsyncSpec `AsyncSpec`]] for non-blocking asynchronous tests
 * @see [[SpecLike `SpecLike`]] base trait
 */
abstract class Spec
  extends AnyFreeSpec
  with SpecLike
  with Mocking

/**
 * Base class for non-blocking asynchronous tests.
 *
 * Based on [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/freespec/AsyncFreeSpec.html `AsyncFreeSpec`]]:
 * nested tests are written inside text clauses denoted with the dash operator (-).
 *
 * @see [[http://scalatest.org/scaladoc/3.2.0/org/scalatest/freespec/AsyncFreeSpec.html `AsyncFreeSpec`]]
 * @see [[Spec `Spec`]] for general tests
 * @see [[SpecLike `SpecLike`]] base trait
 */
abstract class AsyncSpec
  extends AsyncFreeSpec
  with SpecLike
  with Mocking
