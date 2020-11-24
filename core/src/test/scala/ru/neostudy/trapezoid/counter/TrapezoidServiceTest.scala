package ru.neostudy.trapezoid.counter


import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._


class TrapezoidServiceTest extends AnyFlatSpec with should.Matchers with TrapezoidService {

  "ru.neostudy.trapezoid.counter.TrapezoidService" should "calculate area for given trapezoid data" in {
    val td = new Trapezoid(12.0, 18.0, 10.0)

    countAreaTrapezoid(td) should be(150)
  }

  it should "return zero if height iz zero" in {
    val td = new Trapezoid(12.0, 18.0, 0.0)
    countAreaTrapezoid(td) should be(-1.0)
  }
  it should "return zero if baseA iz zero" in {
    val td = new Trapezoid(0.0, 18.0, 20.0)
    countAreaTrapezoid(td) should be(-1.0)
  }
  it should "return zero if baseB iz zero" in {
    val td = new Trapezoid(12.0, 0.0, 0.0)
    countAreaTrapezoid(td) should be(-1.0)
  }


}
