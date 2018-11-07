import org.scalatest.FlatSpec


class ShoppingTest extends FlatSpec {

  "Given no items, it" should "cost £0.00" in {
    val items = Array[Fruit]()
    assertResult(ShoppingMain.getCost(items)) {
      0.00
    }
  }
  "Given an apple, it" should "cost £0.60" in {
    val apple = new Apple
    val items = Array[Fruit](apple)
    assertResult(ShoppingMain.getCost(items)) {
      0.60
    }
  }
  "Given a banana, it" should "cost £0.20" in {
    val banana = new Banana
    val items = Array[Fruit](banana)
    assertResult(ShoppingMain.getCost(items)) {
      0.20
    }
  }
  "Given an orange, it" should "cost £0.00" in {
    val orange = new Orange
    val items = Array[Fruit](orange)
    assertResult(ShoppingMain.getCost(items)) {
      0.25
    }
  }
  "Given two apples and an orange, it" should "cost £1.45" in {
    val apple = new Apple
    val orange = new Orange
    val items = Array[Fruit](apple, apple, orange)
    assertResult(ShoppingMain.getCost(items)) {
      1.45
    }
  }

    "Given two bananas and an orange, it" should "cost £0.45" in {
      val banana = new Banana
      val orange = new Orange
      val items = Array[Fruit](banana, banana, orange)
      assertResult(ShoppingMain.getCostOffers(items)) {
        0.45
      }
    }
  "Given three apples and one orange, it" should "cost £2.05" in {
    val apple = new Apple
    val orange = new Orange
    val items = Array[Fruit](apple, apple, orange, apple)
    assertResult(ShoppingMain.getCost(items)) {
      2.05
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
  "Given six apples and nine oranges, it" should "cost £5.85" in {
    val apple = new Apple
    val orange = new Orange
    val items = Array[Fruit](apple, apple, orange, apple, apple, orange, apple, apple, orange, orange, orange, orange, orange,
      orange, orange)
    assertResult(ShoppingMain.getCost(items)) {
      5.85
    }
  }

  "Given six apples and nine oranges with offers, it" should "cost £3.30" in {
    val apple = new Apple
    val orange = new Orange
    val items = Array[Fruit](apple, apple, orange, apple, apple, orange, apple, apple, orange, orange, orange, orange, orange,
      orange, orange)
    assertResult(ShoppingMain.getCostOffers(items)) {
      3.30
    }
  }
}
