package ru.neostudy.trapezoid.counter

trait TrapezoidService {
  def countAreaTrapezoid(td: Trapezoid): Double = {
    if (td.baseA == 0 || td.baseB == 0 || td.height == 0) {
      println("Любая из сторон не может быть равна нулю!")
      -1.0
    } else {
      ((td.baseA + td.baseB) / 2) * td.height
    }
  }
}
