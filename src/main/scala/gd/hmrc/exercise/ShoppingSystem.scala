package gd.hmrc.exercise

class ShoppingSystem {

  def calculateTotalCost(items: String*): Double = items
    .groupBy(Items.findItem)
    .foldLeft(0.0)((price, itemAndCount) => {
      val (item, allOriginalItems) = itemAndCount
      price + applySpecialOfferIfApplicable(allOriginalItems.size, item.specialOffer) * item.price
    })

  private def applySpecialOfferIfApplicable(count: Int, specialOffer: Option[SpecialOffer]): Double = specialOffer
    .map(offer => numberActuallyPaid(count, offer)).getOrElse(count)

  private def numberActuallyPaid(count: Int, offer: SpecialOffer): Double = {
    val underOffer = count / offer.numberBought
    val outsideOffer = count - (underOffer * offer.numberBought)
    underOffer * offer.numberPaid + outsideOffer
  }
}



