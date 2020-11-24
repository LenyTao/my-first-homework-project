package ru.neostudy.basket.counter

import scala.io.StdIn

object MainBasket extends App with BasketService {
  var prices = List[Double]()
  var amount = List[Int]()

  def recursiveBasket(solutionClient: String): String = {
    if (solutionClient == "sum") {
      Basket(prices, amount)
      solutionClient
    }
    else {
      println("Введите цену товара ")
      prices = prices :+ StdIn.readLine().toDouble
      println("Введите количество товаров ")
      amount = amount :+ StdIn.readInt()
      println("Нажмите Enter или введите комманду sum для подвода итоговой стоимости выбранных товаров ")
      recursiveBasket(StdIn.readLine())
    }
  }

  recursiveBasket("")

  println("Сумма вашего заказа " + countFinalCost(Basket(prices, amount)) + " rub")

}
