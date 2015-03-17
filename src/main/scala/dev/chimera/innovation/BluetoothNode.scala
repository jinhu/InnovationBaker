package dev.chimera.innovation

/**
 * Created by jin on 3/14/15.
 */
class BluetoothNode(deviceSetting: DeviceSetting) {


  var mDriver = new BluetoothDriver
  var driver = new BluetoothDriver()

  def read(): CoffeeCup = {
    var bytes = mDriver.read()
    val coffeeCup = new CoffeeCup(bytes)
    return coffeeCup
  }
}
