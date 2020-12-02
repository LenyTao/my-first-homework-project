package ru.neostudy.FuzzySet

import ru.neostudy.FuzzySet.FuzzySet.Universe

object FuzzySet {

  class Universe[T](val values: Seq[T])

}

class FuzzySet[T](val m: T => Double) {

  /**
   * Метод проверят являтся ли множество пустым
   */
  def isEmpty(implicit universe: FuzzySet.Universe[T]): Boolean = {
    universe.values.forall(m(_) == 0.0)
  }

  /**
   * Метод проверят содержит ли множество некое значение v
   */
  def contains(v: T): Boolean = {
    if (m(v) > 0) true else false
  }

  /**
   * Метод проверят равно ли одно множество другому
   */
  def equalTo(that: FuzzySet[T])(implicit u: Universe[T]): Boolean = {
    if (this == that) {
      return true
    }
    if (that == null || getClass() != that.getClass()) {
      return false
    }
    u.values.forall(x => m(x) == that.m(x))
  }

  /**
   * Метод осуществляет дополнение множества
   */
  def complement(implicit u: Universe[T]): FuzzySet[T] = {
    new FuzzySet[T]((x: T) => 1 - m(x))
  }

  /**
   * Метод осуществляет объединение множест
   */
  def union(that: FuzzySet[T]): FuzzySet[T] = {
    new FuzzySet[T]((x: T) => m(x) max that.m(x))
  }

  /**
   * Метод осуществляет пересечение множеств
   */
  def intersect(that: FuzzySet[T]): FuzzySet[T] = {
    new FuzzySet[T]((x: T) => m(x) min that.m(x))
  }
}

object FuzzySetApp extends App {

  implicit val fuzzySetUniverse = new FuzzySet.Universe((1 to 10))
  val emptyFuzzySet = new FuzzySet[Int](_ => 0.0)
  val fuzzySet = new FuzzySet[Int]({
    case 1 => 0.5
    case 2 => 0.75
    case 3 => 0.6
    case _ => 0.0
  })
  val fuzzySet2 = new FuzzySet[Int]({
    case 1 => 0.5
    case 2 => 0.75
    case 3 => 1.0
    case _ => 0.0
  })
  val fuzzySet3 = new FuzzySet[Int]({
    case 1 => 0.4
    case 2 => 0.8
    case 3 => 1.0
    case _ => 0.0
  })
}
