Scala Boilerplate
=================

[![Build Status](https://travis-ci.org/marconilanna/scala-boilerplate.svg)](https://travis-ci.org/marconilanna/scala-boilerplate)

Assortment of default settings, best practices, and general goodies for Scala projects.

Scalastyle
----------

The `scalastyle` and `test:scalastyle` sbt tasks are used to check source and test code with Scalastyle. The error list is saved to Checkstyle-compatible files `target/scalastyle-result.xml` and `target/scalastyle-test-result.xml` respectively.

Scalastyle runs automatically against source and test code with the sbt `test` task.

It is not recommended to make the `compile` task dependent on Scalastyle. Since Scalastyle runs first and fails if the code does not compile, one would not get the Scala compiler error messages.

scoverage
---------

To execute tests with code coverage enabled run the following sbt tasks: `clean` `coverage` `test` `coverageReport`. Coverage reports are saved to `target/scala-2.11/scoverage-report/`.

Scalariform
-----------

To format source and test code run the `scalariformFormat` and `test:scalariformFormat` sbt tasks.

Scalariform is provided as a convenience and starting point; it is not sufficient to be fully compliant with the Scala Style Guide.

License
-------

Copyright 2011-2015 Marconi Lanna

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
