package gd.hmrc.exercise

class ShoppingSystem {

  def calculateTotalCost(items: String*): Double = items
    .groupBy(findItem)
    .foldLeft(0.0)((price, item) => price + calculatePriceFor(item._1, item._2.size))

  private def calculatePriceFor(item: Item, count: Int): Double = item match {
    case APPLE => applesPromotion(count, item.price)
    case ORANGE => orangesPromotion(count, item.price)
  }

  private def applesPromotion(count: Int, unitPrice: Double) = ((count + 1) / 2) * unitPrice

  private def orangesPromotion(count: Int, unitPrice: Double) = ((count + 1) * 2 / 3) * unitPrice

  private def findItem(asString: String): Item = asString match {
    case "Apple" => APPLE
    case "Orange" => ORANGE
    case unknown => throw new IllegalArgumentException(s"'$unknown' is an unknown item")
  }
}



