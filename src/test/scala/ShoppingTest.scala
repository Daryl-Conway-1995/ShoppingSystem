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
    val items = Array[Fruit](apple,apple,orange)
    assertResult(ShoppingMain.getCost(items)) {
      1.45
    }
  }
}
