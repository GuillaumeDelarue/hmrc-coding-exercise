package gd.hmrc.exercise

class ShoppingSystem {
  def calculateTotalCost(items: String*): Double = items.map(findItem(_).price).sum

  private def findItem(asString: String): Item = asString match {
    case "Apple" => APPLE
    case "Orange" => ORANGE
    case unknown => throw new IllegalArgumentException(s"'$unknown' is an unknown item")
  }
}



