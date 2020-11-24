package ru.neostudy.basket.counter

trait BasketService {
  def countFinalCost(bd: Basket): Double = {
    val pricesAndAmounts = bd.prices.zip(bd.amount)
    val pricesMultipliedByQuantity = pricesAndAmounts.map(lot => lot._1 * lot._2)
    pricesMultipliedByQuantity.sum
  }
}
