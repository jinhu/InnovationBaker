package dev.chimera.innovation.android

import android.app.{Activity, Dialog, PendingIntent}
import android.content.{Context, Intent, IntentFilter}
import android.nfc.tech.{Ndef, NdefFormatable}
import android.nfc.{NdefMessage, NfcAdapter, Tag}
import dev.chimera.innovation.NfcDriver

/**
 * Created by jin on 3/14/15.
 */
class AndroidNfcDriver() extends NfcDriver {
  final val MIME_TEXT_PLAIN: String = "text/plain"
  //
  var nfcAdapter: NfcAdapter = null
  var nfcPendingIntent = null
  var writeTagFilters = null
  var ndefExchangeFilters = null
  var writeMode: Boolean = false
  var caughtNDEFMessages: Array[Nothing] = null
  var activity: Activity = null
  var howToUseDialog: Dialog = null

  def this(aContext: Context, anActivity: Activity) {
    this()
    nfcAdapter = NfcAdapter.getDefaultAdapter(aContext)
    activity = anActivity
  }

  override def read(): Array[Byte] = {
    //val tag = new Tag("MYTAG")
    val ndef = Ndef.get(null)
    if (ndef != null) {
      ndef.connect
      var message = ndef.getNdefMessage
      ndef.close
//
//      return Map(
//        "coffee" -> int2Integer(100),
//        "water" -> int2Integer(100),
//        "milk" -> int2Integer(100),
//        "sugar" -> int2Integer(100),
//        "temperature" -> int2Integer(100))
    }
    return null
  }

  def askForTag(disableOrNot: Boolean) {
    writeMode = !disableOrNot
    howToUseDialog = new Dialog(activity, android.R.style.Theme_NoTitleBar_Fullscreen)
    //howToUseDialog.setContentView(R.layout.alert_dialog)
    howToUseDialog.setCancelable(true)
    howToUseDialog.show

    writeMode = disableOrNot
  }

  def writeTag(message: NdefMessage, tag: Tag): Boolean = {
    val ndef: Ndef = Ndef.get(tag)
    if (ndef == null || !ndef.isWritable || ndef.getMaxSize < message.getByteArrayLength) {
      return false
    }
    ndef.connect
    ndef.writeNdefMessage(message)
    ndef.close
    true
  }

  def formatTag(message: NdefMessage, tag: Tag): Boolean = {
    val format: NdefFormatable = NdefFormatable.get(tag)
    if (format != null) {
      format.connect
      format.format(message)
      return true
    }
    return false
  }

  def setupForegroundDispatch(activity: Activity, adapter: NfcAdapter) {
    val intent: Intent = new Intent(activity.getApplicationContext, activity.getClass)
    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
    val pendingIntent: PendingIntent = PendingIntent.getActivity(activity.getApplicationContext, 0, intent, 0)
    val filters: Array[IntentFilter] = new Array[IntentFilter](1)
    val techList: Array[Array[String]] = null //new Array(new Array("test"))
    filters(0) = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED, MIME_TEXT_PLAIN)
    filters(0).addCategory(Intent.CATEGORY_DEFAULT)
    adapter.enableForegroundDispatch(activity, pendingIntent, filters, techList)
  }

  def stopForegroundDispatch(activity: Activity, adapter: NfcAdapter) {
    adapter.disableForegroundDispatch(activity)
  }
}
