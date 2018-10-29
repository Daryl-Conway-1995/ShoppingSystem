object ShoppingMain {

  def main(args: Array[String]): Unit = {

  }

  def getCost(items: Array[Fruit]) = {
    items.map(i=>i.cost).sum
  }
}
