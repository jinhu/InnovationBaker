package dev.chimera.innovation

/**
 * Created by jin on 3/14/15.
 */
class CoffeeCupSpec extends UnitSpec {

  var mCup = new CoffeeCup()

  it should "have default properties" in {
    mCup.coffee should be(50)
    mCup.water should be(100)
    mCup.milk should be(25)
    mCup.sugar should be(25)
    mCup.temperature should be(70)
  }
  it should "have vairble properties" in {
    mCup = new CoffeeCup(60, 80, 30, 10, 90)
    mCup.coffee should be(60)
    mCup.water should be(80)
    mCup.milk should be(30)
    mCup.sugar should be(10)
    mCup.temperature should be(90)
  }
  it should "have modifiable properties" in {
    mCup.coffee = 100
    mCup.water = 50
    mCup.milk = 0
    mCup.sugar = 0
    mCup.temperature = 80
    mCup.coffee should be(100)
    mCup.water should be(50)
    mCup.milk should be(0)
    mCup.sugar should be(0)
    mCup.temperature should be(80)
  }


}
