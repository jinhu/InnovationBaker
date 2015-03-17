package dev.chimera.innovation

/**
 * Created by jin on 3/14/15.
 */
class CupHolder(deviceSetting: DeviceSetting) {
  var nfcReaderNode = new NfcNode(deviceSetting)
  var bluetoothNode = new BluetoothNode(deviceSetting)
  var restNode = new RestNode(deviceSetting)

}
