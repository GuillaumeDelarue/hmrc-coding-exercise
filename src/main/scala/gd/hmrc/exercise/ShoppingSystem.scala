package gd.hmrc.exercise

class ShoppingSystem {

  def calculateTotalCost(items: String*): Double = items
    .groupBy(Items.findItem)
    .foldLeft(0.0)((price, itemAndCount) => {
      val (item, allOriginalItems) = itemAndCount
      price + applySpecialOfferIfApplicable(allOriginalItems.size, item.price, item.specialOffer)
    })

  private def applySpecialOfferIfApplicable(count: Int, unitPrice: Double, specialOffer: Option[SpecialOffer]): Double = specialOffer match {
    case Some(offer) => (count + 1) * offer.numberPaid / offer.numberBought * unitPrice
    case None => count * unitPrice
  }
}



