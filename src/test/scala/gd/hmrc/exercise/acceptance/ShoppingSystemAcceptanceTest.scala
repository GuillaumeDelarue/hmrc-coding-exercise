package gd.hmrc.exercise.acceptance

import gd.hmrc.exercise.{JunitFunSuite, ShoppingSystem}

class ShoppingSystemAcceptanceTest extends JunitFunSuite {
  private val shoppingSystem = new ShoppingSystem()

  test("acceptance criteria") {
    shoppingSystem.calculateTotalCost("Apple") must be(0.60)
    shoppingSystem.calculateTotalCost("Orange") must be(0.25)
    shoppingSystem.calculateTotalCost("Apple", "Apple", "Orange", "Apple") must be(2.05)
  }

  test("throws exception for unknown items") {
    val expectedMessage = "'Bunch of monkeys' is an unknown item"
    val expectedException = intercept[IllegalArgumentException] {
      shoppingSystem.calculateTotalCost("Bunch of monkeys")
    }
    expectedException.getMessage must be(expectedMessage)
  }
}
