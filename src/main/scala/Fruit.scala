abstract class Fruit {
  val cost = 0
}

class AppleAndBanana extends Fruit {
  //class for apple and banana overlap.
}

case class Apple() extends AppleAndBanana {
  override val cost = 60
}

case class Banana() extends AppleAndBanana {
  override val cost = 20
}

case class Orange() extends Fruit {
  override val cost = 25
}

case class Melon() extends Fruit {
  override val cost = 100
}