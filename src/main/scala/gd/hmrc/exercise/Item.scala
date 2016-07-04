package gd.hmrc.exercise

sealed abstract class Item(val price: Double, val specialOffer: Option[SpecialOffer])

case object APPLE extends Item(0.60, Option(SpecialOffer(2, 1)))

case object ORANGE extends Item(0.25, Option(SpecialOffer(3, 2)))

case class SpecialOffer(numberBought: Int, numberPaid: Int)

object Items {
  def findItem(asString: String): Item = asString match {
    case "Apple" => APPLE
    case "Orange" => ORANGE
    case unknown => throw new IllegalArgumentException(s"'$unknown' is an unknown item")
  }
}
