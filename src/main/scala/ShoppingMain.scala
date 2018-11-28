object ShoppingMain {



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

  def printEachItem(items: Array[Fruit]): Unit ={
    (1 to items.length).foreach(i => println(BigDecimal(getCostOffers(items.take(i))).setScale(2, BigDecimal.RoundingMode.HALF_UP)))
  }


  def getCostOffers(items: Array[Fruit]): Double = {
    def getDiscount(fruit: String, number: Int): Double = {
      fruit match {
        case "Orange" => ((number / 3) * 2 + number % 3) * Orange().cost
        case "AAndB" => combineAppleAndBanana(items.filter(i => i.isInstanceOf[Apple]).length, items.filter(i => i.isInstanceOf[Banana]).length, Apple().cost, Banana().cost)
        case "Melon" => ((number / 3) * 2 + number % 3) * Melon().cost
        case _ => 0.00
      }
    }

    items.groupBy{
      case o:Orange => "Orange"
      case a:AAndB => "AAndB"
      case m:Melon => "Melon"
    }.map(t => getDiscount(t._1, t._2.length)).sum

    //items.groupBy(i => i).map(t => getDiscount(t._1, t._2.length)).sum
  }
}
