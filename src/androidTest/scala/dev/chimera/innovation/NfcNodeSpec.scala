package dev.chimera.innovation

//import android.AndroidNfcDriver

/**
 * Created by jin on 3/14/15.
 */
class NfcNodeSpec extends UnitSpec {


  var mDeviceSetting = new DeviceSetting

  var mNode = new NfcNode(mDeviceSetting)
  var mCup = new CoffeeCup

  // it behave like CoffeeCupNode

  it should "retrive cup model from the system" in {
    var data = ":Map[String, Object]".getBytes()
    //= Map("coffee" -> int2Integer(123), "water" -> int2Integer(100), "name" ->"Djinn")

    mNode.nfcDriver = stub[NfcDriver]
    (mNode.nfcDriver.read _).when().returns(data)
    mCup = mNode.read()
    (mNode.nfcDriver.read _).verify()
  }
}
