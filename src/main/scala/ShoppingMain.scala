object ShoppingMain {

  def main(args: Array[String]): Unit = {
    val apple = new Apple
    val orange = new Orange
    val banana = new Banana
    val items = Array[Fruit](banana, banana)
    println(getCost(items))
    println(getCostOffers(items))
  }

  def getCost(items: Array[Fruit]): Double = {
    items.map(i => i.cost).sum
  }

  def getOffer(cost: Double, numberOfItems: Int, discountDonominator: Int, discountNumerator: Int): Double = {
    (((numberOfItems / discountNumerator) * discountDonominator) + numberOfItems % discountDonominator) * cost
  }

  def getCostOffers(items: Array[Fruit]): Double = {
    def getDiscount(fruit: Fruit, number: Int): Double = {
      fruit match {
        case o: Orange => getOffer(o.cost, number, 3, 2)
        case a: Apple => ((number / 2) + number % 2) * a.cost
        case b: Banana => ((number / 2) + number % 2) * b.cost
        case _ => 0.00
      }
    }

    items.groupBy(i => i).map(t => getDiscount(t._1, t._2.length)).sum
  }
}
