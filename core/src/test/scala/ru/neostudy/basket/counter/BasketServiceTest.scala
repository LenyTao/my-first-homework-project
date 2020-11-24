package ru.neostudy.basket.counter

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class BasketServiceTest extends AnyFlatSpec with should.Matchers with BasketService {


  "ru.neostudy.basket.counter.BasketService" should "сalculating the amount of items in the cart  for given ru.neostudy.basket.counter.Basket data" in {
    val bd = new Basket(List(500.0, 100.0, 10.0), List(10, 5, 25))
    countFinalCost(bd) should be(5750.0)
  }

  it should "return zero if prise iz zero" in {
    val bd = new Basket(List(0.0), List(2))
    countFinalCost(bd) should be(0.0)
  }
  it should "return zero if amt iz zero" in {
    val bd = new Basket(List(2), List(0))
    countFinalCost(bd) should be(0.0)
  }
}
