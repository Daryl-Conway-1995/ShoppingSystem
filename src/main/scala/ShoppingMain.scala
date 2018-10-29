object ShoppingMain {

  def main(args: Array[String]): Unit = {
    val apple = new Apple
    val orange = new Orange
    val items = Array[Fruit](apple,apple,orange,apple)
    println(getCost(items))
    println(getCostOffers(items))
  }

  def getCost(items: Array[Fruit]) = {
    items.map(i=>i.cost).sum
  }

  def getCostOffers(items :Array[Fruit])={
    def getDiscount(cost: Double, number: Int):Double={
      cost match {
        case 0.25 => (((number/3)*2)+number%3)*cost
        case 0.60 => (((number/2)+number%2))*cost
        case _  => 0.00
      }
    }
    items.groupBy(i=>i.cost).map(t=> getDiscount(t._1 , t._2.length)).sum
  }
}
