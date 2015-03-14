package dev.chimera.innovation

/**
 * Created by jin on 3/14/15.
 */
class NfcNode() {
  var nfcDriver: NfcDriver = Class.forName("dev.chimera.android.NfcDriver").newInstance()

  def read(): CoffeeCup = {
    var data = nfcDriver.retrive()
    return new CoffeeCup()
  }

}
