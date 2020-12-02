package ru.neostudy.FuzzySet

import org.scalatest.flatspec._
import org.scalatest.matchers._

class FuzzySetTest extends AnyFlatSpec with should.Matchers {


  "FuzzySet" should " be empty" in {
    implicit val fuzzySetUniverse = new FuzzySet.Universe((1 to 10))
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
  it should "checks if the value contains the value v in the fuzzy set" in {
    implicit val fuzzySetUniverse = new FuzzySet.Universe((1 to 10))
    val fs = new FuzzySet[Int]({
      case 1 => 0.5
      case 2 => 0.75
      case 3 => 1.0
      case _ => 0.0
    })
    fs.contains(3) should be(true)
    fs.contains(11) should be(false)

  }
  it should "checks if fuzzy sets are equal to each other" in {
    implicit val fuzzySetUniverse = new FuzzySet.Universe((1 to 10))
    val fs = new FuzzySet[Int]({
      case 1 => 0.5
      case 2 => 0.75
      case 3 => 1.0
      case _ => 0.0
    })
    val fs2 = new FuzzySet[Int]({
      case 1 => 0.5
      case 2 => 0.75
      case 3 => 1.0
      case _ => 0.0
    })
    val fs3 = new FuzzySet[Int]({
      case 1 => 0.5
      case 2 => 0.75
      case 3 => 1.0
      case 4 => 0.8
      case _ => 0.0
    })
    fs.equalTo(fs2) should be(true)
    fs.equalTo(fs3) should be(false)
    fs3.equalTo(fs3) should be(true)
  }

      it should "completes the given fuzzy set" in {
        implicit val fuzzySetUniverse = new FuzzySet.Universe((1 to 10))
        val fs = new FuzzySet[Int]({
          case 1 => 0.3
          case 2 => 0.75
          case 3 => 0.2
          case _ => 0.0
        })
        val fs2 = new FuzzySet[Int]({
          case 1 => 0.7
          case 2 => 0.25
          case 3 => 0.8
          case _ => 1.0
        })
        val fs3 = new FuzzySet[Int]({
          case 1 => 0.7
          case 2 => 0.25
          case 3 => 0.1
          case _ => 1.0
        })
        fs2.equalTo(fs.complement) should be (true)

      }


  it should "union the given fuzzy set's " in {
    implicit val fuzzySetUniverse = new FuzzySet.Universe((1 to 10))
    val fs = new FuzzySet[Int]({
      case 1 => 0.3
      case 2 => 0.75
      case 3 => 0.9
      case _ => 0.0
    })
    val fs2 = new FuzzySet[Int]({
      case 1 => 0.7
      case 2 => 0.25
      case 3 => 0.1
      case _ => 0.0
    })
    val fs3 = new FuzzySet[Int]({
      case 1 => 0.7
      case 2 => 0.75
      case 3 => 0.9
      case _ => 0.0
    })
    val fs4 = new FuzzySet[Int]({
      case 1 => 0.8
      case 2 => 0.96
      case 3 => 0.35
      case _ => 0.0
    })
    fs3.equalTo(fs.union(fs2)) should be(true)
    fs4.equalTo(fs.union(fs2)) should be(false)
  }
  it should "intersect the given fuzzy set's " in {
    implicit val fuzzySetUniverse = new FuzzySet.Universe((1 to 10))
    val fs = new FuzzySet[Int]({
      case 1 => 0.3
      case 2 => 0.75
      case 3 => 0.9
      case _ => 0.0
    })
    val fs2 = new FuzzySet[Int]({
      case 1 => 0.7
      case 2 => 0.25
      case 3 => 0.1
      case _ => 0.0
    })
    val fs3 = new FuzzySet[Int]({
      case 1 => 0.3
      case 2 => 0.25
      case 3 => 0.1
      case _ => 0.0
    })
    val fs4 = new FuzzySet[Int]({
      case 1 => 0.8
      case 2 => 0.96
      case 3 => 0.35
      case _ => 0.0
    })
    fs3.equalTo(fs.intersect(fs2)) should be(true)
    fs4.equalTo(fs.intersect(fs2)) should be(false)
  }
}
