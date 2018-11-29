object ShoppingMain {

  def combineAppleAndBanana(apple: Int, banana: Int, appleCost: Int, bananaCost: Int): Int = {
    if (apple > banana) {
      (banana + ((apple - banana) / 2) + ((apple - banana) % 2)) * appleCost
    }
    else if (apple < banana) {
      (appleCost * apple) + ((banana - apple) / 2 + (banana - apple) % 2) * bananaCost
    }
    else
      appleCost * apple
  }

  def combineAppleAndBananaStretchTask(apple: Int, banana: Int, appleCost: Int, bananaCost: Int): Int = {
    if (apple % 2 == 0) {
      (apple / 2) * appleCost + ((banana / 2) + banana % 2) * bananaCost
    } else {
      ((apple / 2) + apple % 2) * appleCost + (banana / 2) * bananaCost
    }
  }

  def printEachItem(items: Array[Fruit]): Unit = {
    (1 to items.length).foreach(i => println(getCostOffers(items.take(i))))
  }

  def getCostOffers(items: Array[Fruit], bestDeal: Boolean = false): Double = {
    def getDiscount(fruit: String, number: Int): Int = {
      fruit match {
        case "Orange" => ((number / 3) * 2 + number % 3) * Orange().cost
        case "AppleAndBanana" => if(bestDeal) {
          combineAppleAndBananaStretchTask(items.filter(i => i.isInstanceOf[Apple]).length, items.filter(i => i.isInstanceOf[Banana]).length, Apple().cost, Banana().cost)
        }
          else{
          combineAppleAndBanana(items.filter(i => i.isInstanceOf[Apple]).length, items.filter(i => i.isInstanceOf[Banana]).length, Apple().cost, Banana().cost)

        }
        case "Melon" => ((number / 3) * 2 + number % 3) * Melon().cost
        case _ => 0
      }
    }

    items.groupBy {
      case o: Orange => "Orange"
      case a: AppleAndBanana => "AppleAndBanana"
      case m: Melon => "Melon"
    }.map(t => getDiscount(t._1, t._2.length)).sum.toDouble / 100
  }
}
