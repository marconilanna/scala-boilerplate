/*
 * Copyright 2012-2016 Marconi Lanna
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

class SampleSpec extends Spec {
  trait Context {
    // shared objects
    val expected = "forty two"

    // shared mocks
    val obj = mock[AnyRef]

    // common expectations
    when(obj.toString) thenReturn expected

    // helper functions

    // test setup
  }

  "Test:" - {
    "Sample test" in new Context {
      val result = obj.toString

      assert(result === expected)
    }
  }
}
