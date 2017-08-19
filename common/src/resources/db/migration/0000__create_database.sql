/*
Always prefer 'bin' as the default database collation instead of 'general_ci' or 'unicode_ci'.

Since collations are used in comparisons, the following statement would, for instance, update
all rows with name "Antonio" to "Antônio":

    update user set name = "Antônio" where name = "Antônio"

Collations are also used to determine uniqueness. If 'name' is a unique key, the table can't
have two rows with names "Antonio" and "Antônio".

The default collation can always be overridden as needed on a query basis:

http://dev.mysql.com/doc/refman/5.7/en/charset-collate.html
*/

create database DATABASE
  charset utf8mb4
  collate utf8mb4_bin;

-- down
/*
drop database if exists sample;
*/
