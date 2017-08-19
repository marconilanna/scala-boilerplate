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
package project

import org.mockito.Mockito.when

import scala.concurrent.Future

class SampleAsyncSpec extends AsyncSpec {
  class Context {
    // shared objects
    val expected = "forty two"

    // shared mocks
    val obj = mock[AnyRef]

    // common expectations
    when(obj.toString) thenReturn expected

    // helper functions

    // test setup
  }

  "Async Test:" - {
    "Sample async test" in {
      val ctx = new Context; import ctx._ // scalastyle:ignore

      val future = Future(obj.toString)

      future map { result =>
        assert(!result.isEmpty)
        assert(result === expected)
      }
    }

    "Multiple futures test" in {
      val ctx = new Context; import ctx._ // scalastyle:ignore

      val a = "the answer is "

      val fut1 = Future(a)
      val fut2 = Future(obj.toString)
      val fut3 = Future(a + obj)

      for {
        f1 <- fut1
        f2 <- fut2
        f3 <- fut3
      } yield {
        assert(f1 === a)
        assert(f2 === expected)
        assert(f3 === a + expected)
      }
    }
  }
}
