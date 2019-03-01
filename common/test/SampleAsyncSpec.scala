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
package project

import scala.concurrent.Future
import scala.util.Random

class SampleAsyncSpec extends AsyncSpec {
  "Async Test:" - {
    "Sample async test" in {
      val ctx = new Context; import ctx._ // scalastyle:ignore

      val future = Future.successful(obj.toString)

      future map { result =>
        assert(!result.isEmpty)
        assert(result == expected)
      }
    }

    "Multiple futures test" in {
      val fa = Future.successful(Random.nextInt(6))
      val fb = Future.successful(Random.nextBoolean)

      for {
        a <- fa
        b <- fb
      } yield {
        assert(a < 6)
        assert(b || !b) // that is the question

        // async tests must end with assertion; use `succeed` if they don't
        succeed
      }
      // but be careful to not put `succeed` here, outside the future mapping
    }
  }

  class Context {
    // shared objects
    val expected = "forty two"

    // shared mocks
    val obj = mock[AnyRef]

    // common expectations
    obj.toString shouldReturn expected

    // helper functions

    // test setup
  }
}
