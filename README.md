Scala Boilerplate
=================

[![Build Status](https://travis-ci.org/marconilanna/scala-boilerplate.svg)](https://travis-ci.org/marconilanna/scala-boilerplate)
[![Coverage Status](https://coveralls.io/repos/github/marconilanna/scala-boilerplate/badge.svg)](https://coveralls.io/github/marconilanna/scala-boilerplate)

Assortment of default settings, best practices, and general goodies for Scala projects.

Scala REPL
----------

The `console` and `consoleQuick` sbt tasks start the Scala REPL with commonly used imports such as
`JavaConverters`, `collection.mutable`, `Future`, `Random`, `Try` and `NonFatal` already in scope.

The REPL also defines a `desugar` macro that expands an expression to its desugared form and inferred type.
Try, for instance, `desugar(1 to 3)`.

Static Analysis
---------------

### Scalastyle

The `scalastyle` and `test:scalastyle` sbt tasks are used to check source and test code with Scalastyle.
The error list is saved to Checkstyle-compatible files `target/scalastyle-result.xml`
and `target/scalastyle-test-result.xml`, respectively.

Scalastyle runs automatically against source and test code with the sbt `test` task.

It is not recommended to make the `compile` task dependent on Scalastyle.
Since Scalastyle runs first and fails if the code does not compile,
one would not get the Scala compiler error messages.

You can switch off checking for a single line ([read below first](#suppressing-warnings))
using an `ignore` comment at the end of the line:

```scala
if (theAnswerToTheUltimateQuestion == 42) ??? // scalastyle:ignore magic.number
```

You can also turn off checking for a section of code with `off`/`on` comments:

```scala
// scalastyle:off magic.number
if (theAnswerToTheUltimateQuestion == 42) ???
// scalastyle:on magic.number
```

**Do not forget to put it `on` back again**

The full list of Scalastyle checks is availabe at http://www.scalastyle.org/rules-1.0.0.html
(you are interested in the `id`).

### Suppressing warnings

Do not abuse "suppress warning" annotations.

Although in rare, exceptional situations they may have legitimate uses,
mindlessly suppressing warnings defeats the purpose of static analysis.
Take a warning as an opportunity to rethink your design and refactor as needed for improvements.
Only after careful consideration contemplate the need to suppress it.

Scalariform
-----------

To format source and test code run the `scalariformFormat` and `test:scalariformFormat` sbt tasks.

Scalariform is provided as a convenience and starting point;
it is not sufficient to be fully compliant with the Scala Style Guide.

scoverage
---------

To execute tests with code coverage enabled run the following sbt tasks:
`clean` `coverage` `test` `coverageReport`.
Coverage reports are saved to `target/scala-2.12/scoverage-report/`.

The `coverage` command is sticky; to turn it off, use `coverageOff`.

Microbenchmarking
-----------------

The `jmh` subproject showcases the `sbt-jmh`
[microbenchmarking](http://openjdk.java.net/projects/code-tools/jmh/)
[plugin](http://github.com/ktoso/sbt-jmh).

To execute a sample benchmark, use the `jmh/jmh:run project.jmh.BenchmarkExample` task.
Use `jmh/jmh:clean` if things get weird or `jmh:run -h` to display the full list of options.

For more information, refer to the
[project documentation](http://jar-download.com/artifacts/org.openjdk.jmh/jmh-core/1.21/documentation) or
[samples in Scala](http://github.com/ktoso/sbt-jmh/tree/master/plugin/src/sbt-test/sbt-jmh/run/src/main/scala/org/openjdk/jmh/samples)

Database migration
------------------

To run database migrations, use the `flywayMigrate` sbt tasks.

Migration files are stored in the `src/resources/db/migration/` folder.
Filenames follow the convention `nnnn.pp__desc.sql` (for instance, `0001__create_user.sql`) where:

* `nnnn` is the version: a unique, leading zero-padded, strictly increasing numeric sequence
* `.pp` is an optional patch number: same rules as above, used only by [hotfixes](http://flywaydb.org/documentation/faq.html#hot-fixes)
* `desc` is a brief description written in `lower_case_underscore`

### Down (reverse) migrations

While Flyway doesn't support down migrations, by convention we put the SQL DDL commands to reverse
the migration as a comment at the bottom of the file:

``` sql
create table if not exists user;

-- down
/*
drop table if exists user;
*/
```

sbt-updates
-----------

There is a `dependencyUpdates` sbt task to check Maven repositories for dependency updates.

sbt-dependency-graph
--------------------

This plugin adds three main tasks:
`dependency-tree` displays the project dependencies as a tree,
`dependency-graph` shows it as a graph,
`what-depends-on <organization> <module> <revision>` shows everything that depends on an artifact.

sbt-license-report
------------------

To generate a report with the dependency licenses used by the project, use the `dumpLicenseReport` sbt task.
The report is saved to the `target/license-reports` directory.

sbt-stats
---------

The `stats` sbt task shows basic line counting statistics.

sbteclipse
----------

Uncomment the related line in `project/plugins.sbt` to enable the `eclipse` sbt task
to create Eclipse project definitions.

License
-------

Copyright 2011-2020 Marconi Lanna

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
