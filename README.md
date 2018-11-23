# Spring Transaction Isolation Levels examples

## How is it used in example

- [PersonService.java](SpringTransactionIsolationExamples/src/main/java/com/vipul/service/PersonService.java) has different methods defined with isolation levels as DEFAULT, READ_COMMITTED, READ_UNCOMMITTED,REPEATABLE_READ, SERIALIZABLE
- [SpringTransactionIsolationExamplesApplication.java](SpringTransactionIsolationExamples/src/main/java/com/vipul/SpringTransactionIsolationExamplesApplication.java) gets the PersonService bean and calls callTransactionalMethodsWithoutTrasaction() and callTransactionalMethodsWithTrasaction()

## Importing and running project

1. Import project as Maven project
2. Run application as Spring Boot Application
3. Observe log and relate it with PersonService logging statements.