package dev.chimera.innovation

/**
 * Created by jin on 3/14/15.
 */
class CupHolderSpec extends UnitSpec {

  var mHolder = new CupHolder

  it should "init nodes" in {
    mHolder.nfcReaderNode should not be (null)
    mHolder.bluetoothNode should not be (null)
  }
}
