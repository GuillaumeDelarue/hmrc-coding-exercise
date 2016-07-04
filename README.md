# hmrc-coding-exercise

* Project done using Scala/Scalatest on 4/7/2016 in about 45 minutes including refactoring
* IntelliJ IDEA EAP 2016.2 preview used for IDE
* Gradle used for dependency management
* Using TDD: I wrote acceptance criteria first (ShoppingSystemAcceptanceTest.scala), which drove the code for ShoppingSystem
* The point of the last commit (step 2 refactoring) was to separate the business logic (ShoppingSystem.scala) from the domain classes (Item.scala)
* The business logic class has no reference to actual item or special offers - everything is generic and special offers or items can be modified without touching it
* I used functional programming monoid constructs: groupBy and foldLeft in business logic to calculate prices, option for special offers
* Commits for steps were done in traditional TDD steps: red/green/refactor
