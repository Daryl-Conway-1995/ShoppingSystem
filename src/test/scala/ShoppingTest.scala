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

  "Entering 1 apple" should "return 0.6" in{
    ShoppingMain.getCostOffers(Array[Fruit](Apple())) should equal (0.6)
  }

  "Entering 2 Apple" should "return 0.6" in{
    ShoppingMain.getCostOffers(Array[Fruit](Apple(), Apple())) should equal (0.6)
  }

  "Entering 3 Apple" should "return 1.2" in{
    ShoppingMain.getCostOffers(Array[Fruit](Apple(), Apple(), Apple())) should equal (1.2)
  }

  "Entering 1 Orange" should "return 0.25" in{
    ShoppingMain.getCostOffers(Array[Fruit](Orange())) should equal (0.25)
  }

  "Entering 2 Orange" should "return 0.5" in{
    ShoppingMain.getCostOffers(Array[Fruit](Orange(), Orange())) should equal (0.5)
  }

  "Entering 3 Orange" should "return 0.5" in{
    ShoppingMain.getCostOffers(Array[Fruit](Orange(), Orange(), Orange())) should equal (0.5)
  }

  "Entering 4 Orange" should "return 0.75" in{
    ShoppingMain.getCostOffers(Array[Fruit](Orange(), Orange(), Orange(), Orange())) should equal (0.75)
  }

  "Entering 1 Banana" should "return 0.2" in{
    ShoppingMain.getCostOffers(Array[Fruit](Banana())) should equal (0.2)
  }

  "Entering 2 Banana" should "return 0.2" in{
    ShoppingMain.getCostOffers(Array[Fruit](Banana(), Banana())) should equal (0.2)
  }

  "Entering 3 Banana" should "return 0.4" in{
    ShoppingMain.getCostOffers(Array[Fruit](Banana(), Banana(), Banana())) should equal (0.4)
  }

  "Entering 1 Apple and 1 Banana" should "return 0.6" in{
    ShoppingMain.getCostOffers(Array[Fruit](Banana(), Apple())) should equal (0.6)
  }

  "Entering 1 Apple and 2 Banana" should "return 0.8" in{
    ShoppingMain.getCostOffers(Array[Fruit](Banana(), Banana(), Apple())) should equal (0.8)
  }

  "Entering 2 Apples and 1 Banana" should "return 1.2" in{
    ShoppingMain.getCostOffers(Array[Fruit](Banana(), Apple(), Apple())) should equal (1.2)
  }

  "Entering 2 Apples and 1 Banana given the best deal" should "return 0.8" in{
    ShoppingMain.getCostOffers(Array[Fruit](Banana(), Apple(), Apple()),true) should equal (0.8)
  }

  "Entering a combination of fruit" should "return 2.3" in{
    ShoppingMain.getCostOffers(Array[Fruit](Melon(), Orange(), Orange(), Orange(), Banana(), Banana(), Apple())) should equal (2.3)
  }

  "Entering a combination of fruit given the best deal" should "return 2.9" in{
    ShoppingMain.getCostOffers(Array[Fruit](Melon(), Orange(), Orange(), Orange(), Banana(), Banana(),Apple(), Apple(), Apple()),true) should equal (2.9)
  }
}
