package gd.hmrc.exercise

sealed abstract class Item(val price: Double)

case object APPLE extends Item(0.60)

case object ORANGE extends Item(0.25)