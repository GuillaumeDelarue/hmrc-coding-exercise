package gd.hmrc.exercise.acceptance

import gd.hmrc.exercise.{APPLE, JunitFunSuite, ORANGE, ShoppingSystem}

class ShoppingSystemAcceptanceTest extends JunitFunSuite {
  private val shoppingSystem = new ShoppingSystem()

  test("acceptance criteria") {
    shoppingSystem.calculateTotalCost("Apple") must be(APPLE.price)
    shoppingSystem.calculateTotalCost("Orange") must be(ORANGE.price)
    shoppingSystem.calculateTotalCost("Apple", "Orange") must be(APPLE.price + ORANGE.price)
  }

  test("throws exception for unknown items") {
    val expectedMessage = "'Bunch of monkeys' is an unknown item"
    val expectedException = intercept[IllegalArgumentException] {
      shoppingSystem.calculateTotalCost("Bunch of monkeys")
    }
    expectedException.getMessage must be(expectedMessage)
  }

  test("first promotion: buy one apple get one free") {
    shoppingSystem.calculateTotalCost("Apple", "Apple") must be(APPLE.price)
    shoppingSystem.calculateTotalCost("Apple", "Apple", "Apple") must be(2 * APPLE.price)
    shoppingSystem.calculateTotalCost("Apple", "Apple", "Apple", "Apple") must be(2 * APPLE.price)
    shoppingSystem.calculateTotalCost("Apple", "Apple", "Apple", "Apple", "Apple") must be(3 * APPLE.price)

    shoppingSystem.calculateTotalCost("Apple", "Orange", "Apple") must be(APPLE.price + ORANGE.price)
    shoppingSystem.calculateTotalCost("Apple", "Orange", "Apple", "Orange") must be(APPLE.price + 2 * ORANGE.price)
  }

  test("second promotion: three oranges for the price of two") {
    shoppingSystem.calculateTotalCost("Orange", "Orange") must be(2 * ORANGE.price)
    shoppingSystem.calculateTotalCost("Orange", "Orange", "Orange") must be(2 * ORANGE.price)
    shoppingSystem.calculateTotalCost("Orange", "Orange", "Orange", "Orange") must be(3 * ORANGE.price)
    shoppingSystem.calculateTotalCost("Orange", "Orange", "Orange", "Orange", "Orange") must be(4 * ORANGE.price)
    shoppingSystem.calculateTotalCost("Orange", "Orange", "Orange", "Orange", "Orange", "Orange") must be(4 * ORANGE.price)
  }
}