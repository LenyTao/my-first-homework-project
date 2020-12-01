package ru.neostudy.FuzzySet

import org.scalatest.flatspec._
import org.scalatest.matchers._

class FuzzySetTest extends AnyFlatSpec with should.Matchers {
  "FuzzySet" should "should be empty" in {
    val fs = new FuzzySet[Int]({
      case 1 => 0.5
      case 2 => 0.75
      case 3 => 1.0
      case _ => 0.0
    })
    val fs2 = new FuzzySet[Int](_ => 0.0)
    fs2.isEmpty should be(true)
    fs.isEmpty should be(false)

  }
}
