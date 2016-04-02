/*
 * Copyright 2012-2015 Marconi Lanna
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

import org.scalatest.{DiagrammedAssertions, FreeSpec, OneInstancePerTest}
import org.scalatest.mock.MockitoSugar

abstract class Spec
  extends FreeSpec
  with DiagrammedAssertions
  with MockitoSugar

abstract class FixtureSpec
  extends Spec
  with OneInstancePerTest
