package dev.chimera.innovation

/**
 * Created by jin on 3/14/15.
 */
class NfcNode() {
  var nfcDriver = new AndroidNfcDriver() //Class.forName("dev.chimera.innovation.NfcDriver").newInstance()

  def read(): CoffeeCup = {
    var data = nfcDriver.retrieve()
    return new CoffeeCup()
  }

}
