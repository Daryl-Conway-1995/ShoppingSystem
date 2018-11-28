object ShoppingMain {

  def main(args: Array[String]): Unit = {
    val apple = new Apple
    val orange = new Orange
    val banana = new Banana
    val items = Array[Fruit](banana, apple)
    println(combineAppleAndBanana(12, 5, 0.60, 0.20))

    println(BigDecimal(combineAppleAndBanana(12, 5, 0.60, 0.20)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble)
  }

  def getCost(items: Array[Fruit]): Double = {
    items.map(i => i.cost).sum
  }

  def combineAppleAndBanana(apple: Int, banana: Int, appleCost: Double, bananaCost: Double): Double = {
    if (apple > banana) {
      //(banana + ((apple - banana) / 2) + ((apple - banana) % 2)) * appleCost
      (banana + ((apple - banana) / 2) + ((apple - banana) % 2)) * 0.6
    }
    else if (apple < banana) {
      (appleCost * apple) + ((banana - apple) / 2 + (banana - apple) % 2) * bananaCost
    }
    else
      appleCost * apple
  }


  def getCostOffers(items: Array[Fruit]): Double = {
    def getDiscount(fruit: Fruit, number: Int): Double = {
      fruit match {
        case o: Orange => ((number / 3) * 2 + number % 3) * o.cost
        case a: Apple => ((number / 2) + number % 2) * a.cost
        case b: Banana => ((number / 2) + number % 2) * b.cost
        case _ => 0.00
      }
    }

    items.groupBy(i => i).map(t => getDiscount(t._1, t._2.length)).sum
  }
}
