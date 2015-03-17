package dev.chimera.innovation

/**
 * Created by jin on 3/16/15.
 */
class BluetoothNodeSpec extends UnitSpec {

  var mDeviceSetting = new DeviceSetting

  var mNode = new BluetoothNode(mDeviceSetting)

  it should "forward read call to driver" in {
    mNode.driver = stub[BluetoothDriver]
    val coffee = mNode.read()
    coffee.coffee should be(100)
  }
}
