package dev.chimera.innovation

/**
 * Created by jin on 3/14/15.
 */
class CupHolderSpec extends UnitSpec {

  var mHolder = new CupHolder(new DeviceSetting())

  it should "init nodes" in {
    mHolder.nfcReaderNode should not be (null)
    mHolder.bluetoothNode should not be (null)
    mHolder.restNode should not be (null)
  }
}
