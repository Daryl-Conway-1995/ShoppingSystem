abstract class Fruit {
  val cost = 0.00
}

class AAndB extends Fruit {
  //class for apple and banana overlap.
}

case class Apple() extends AAndB {
  override val cost: Double = 0.60
}

case class Banana() extends AAndB {
  override val cost: Double = 0.20
}

case class Orange() extends Fruit {
  override val cost: Double = 0.25
}

case class Melon() extends Fruit {
  override val cost: Double = 1
}