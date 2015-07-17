Scala Boilerplate
=================

[![Build Status](https://travis-ci.org/marconilanna/scala-boilerplate.svg)](https://travis-ci.org/marconilanna/scala-boilerplate)

Assortment of default settings, best practices, and general goodies for Scala projects.

Code Coverage
-------------

https://github.com/scoverage/sbt-scoverage

Then run the your tests with coverage enabled by entering:

```sh
$ sbt clean coverage test
```

or if you have integration tests as well

```sh
$ sbt clean coverage it:test
```

After the tests have finished you should then run

```sh
$ sbt coverageReport
```

to generate the reports. You will find the coverage reports inside `target/scoverage-report`.

License
-------

Copyright 2012 Marconi Lanna

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
