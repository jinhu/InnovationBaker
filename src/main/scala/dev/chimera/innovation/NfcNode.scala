package dev.chimera.innovation


/**
 * Created by jin on 3/14/15.
 */
class NfcNode(aDeviceSetting: DeviceSetting) {
  var deviceSetting = aDeviceSetting
  var nfcDriver = new NfcDriver()
  //nfcDriver =new AndroidNfcDriver(deviceSetting.context, deviceSetting.activity) //Class.forName("dev.chimera.innovation.NfcDriver").newInstance()

  def read(): CoffeeCup = {
    var data = nfcDriver.read()
    return new CoffeeCup(data)
  }

}
