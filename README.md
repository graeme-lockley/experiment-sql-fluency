experiment-sql-fluency
======================

I have played around with [jOOQ](http://jooq.org) and [Squeryl](http://squeryl.org) and really like the idea of using an SQL based DSL to formulate DML and queries against a JDBC supported database.  The issues I have with jOOQ is it needs to be licensed for commercial use and Squeryl, for all practical purposes, is Scala only and requires you to de-DRY your system by recapturing your table structure using a collection of classes and objects.

I was also curious how types are used to enable IDE support.

So this project is nothing more than me trying to understand how these SQL based DSLs are put together and how:

- The database's schema's type can be represented and enforced at compile time, and
- The database's table and column structure can be enforced at run-time.

This will allow data intensive applications to be synchronised with their table structures at compile time rather than needing to write collections of tests to confirm this.
