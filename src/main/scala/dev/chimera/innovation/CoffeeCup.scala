package dev.chimera.innovation

/**
 * Created by jin on 3/14/15.
 */
class CoffeeCup(aCoffee: Integer, aWater: Integer, aMilk: Integer, aSugar: Integer, aTemperature: Integer) {
  var water = aWater
  var sugar = aSugar
  var milk = aMilk
  var coffee = aCoffee
  var temperature = aTemperature

  def this(bytes: Array[Byte]) {
    this(100, 100, 100, 100, 100);
    //    var json = new JSONObject(new String(bytes))
  }

  def this() {
    this(50, 100, 25, 25, 70);

  }

}
