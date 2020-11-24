package ru.neostudy.trapezoid.counter

import scala.io.StdIn

object MainTrapezoid extends App with TrapezoidService {

  print("Trapezoid baseA: ")
  val baseA = StdIn.readDouble()

  print("Trapezoid baseB: ")
  val baseB = StdIn.readDouble()

  print("Trapezoid Height: ")
  val height = StdIn.readDouble()

  val td = Trapezoid(baseA, baseB, height)

  if (countAreaTrapezoid(td) != -1) {
    println(s"Trapezoid Area: ${countAreaTrapezoid(td)}")
  }
  else {
    println("Площадь тапеции невозможно рассчитать")
  }

  println("Press ENTER...")
  StdIn.readLine()
}
