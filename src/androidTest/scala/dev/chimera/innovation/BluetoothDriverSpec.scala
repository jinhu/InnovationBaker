package dev.chimera.innovation

/**
 * Created by jin on 3/16/15.
 */
class BluetoothDriverSpec extends UnitSpec {
  var mDriver = new BluetoothDriver
  it should "send binary data" in {
    mDriver.write("AAAAAAAAAAA".getBytes) should be(true)
  }
}
