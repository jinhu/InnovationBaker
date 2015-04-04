package dev.chimera.innovation

/**
 * Created by jin on 3/14/15.
 */
class NfcReaderSpec extends UnitSpec {


  var mNfcReader = new NfcNode()

  var mCup = new CoffeeCup()

  // it behave like CoffeeCupNode

  it should "retrive cup model from the system" in {
    //val nfcMock = mock[NfcHardware]
    mCup = mNfcReader.read()
    //exce

  }
}
