import ShoppingMain.{getCostOffers, printEachItem}

object Runner {
  def main(args: Array[String]): Unit = {
    val items = Array[Fruit](Banana(), Apple(), Apple(), Apple(), Banana(), Orange(), Banana(), Banana(), Banana(), Melon(), Melon(), Melon(), Melon())
    println(getCostOffers(items))

    printEachItem(items)
  }
}
