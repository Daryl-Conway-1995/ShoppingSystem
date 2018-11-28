import org.scalatest.{FlatSpec, Matchers}


class ShoppingTest extends FlatSpec with Matchers{

    "Given two bananas and an orange, it" should "cost £0.45" in {
      val banana = new Banana
      val orange = new Orange
      val items = Array[Fruit](banana, banana, orange)
      assertResult(ShoppingMain.getCostOffers(items)) {
        0.45
      }
    }

  "Given three apples and one orange with offers, it" should "cost £1.45" in {
    val apple = new Apple
    val orange = new Orange
    val items = Array[Fruit](apple, apple, orange, apple)
    assertResult(ShoppingMain.getCostOffers(items)) {
      1.45
    }
  }
  "Given nothing with offers, it" should "cost £0.00" in {
    val items = Array[Fruit]()
    assertResult(ShoppingMain.getCostOffers(items)) {
      0.00
    }
  }


  "Given nine oranges with offers, it" should "cost £1.50" in {
    val orange = new Orange
    val items = Array[Fruit]( orange, orange,  orange, orange, orange, orange, orange, orange, orange)
    assertResult(ShoppingMain.getCostOffers(items)) {
      1.50
    }
  }

  "given the 2 for 1 of both apples and bananas it" should "cost £0.60" in {
    val banana = new Banana
    val apple = new Apple
    val items = Array[Fruit]( apple, banana)
    assertResult(ShoppingMain.getCostOffers(items)){
      0.60
    }
  }

  "Entering 1 melon" should "return 1" in{
    ShoppingMain.getCostOffers(Array[Fruit](Melon())) should equal (1)
  }

  "Entering 2 melon" should "return 2" in{
    ShoppingMain.getCostOffers(Array[Fruit](Melon(), Melon())) should equal (2)
  }

  "Entering 3 melon" should "return 2" in{
    ShoppingMain.getCostOffers(Array[Fruit](Melon(), Melon(), Melon())) should equal (2)
  }

  "Entering 4 melon" should "return 3" in{
    ShoppingMain.getCostOffers(Array[Fruit](Melon(), Melon(), Melon(), Melon())) should equal (3)
  }
}
