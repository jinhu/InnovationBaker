package dev.chimera.innovation

import android.content.Context
import android.graphics.Color
import android.view.WindowManager
import org.scaloid.common._

/**
 * Created by jin on 3/14/15.
 */

class BakerActivity extends SActivity with WidgetHelpers {

  var deviceSetting = new DeviceSetting()
  var holder: CupHolder = new CupHolder(deviceSetting)
  onCreate {
    contentView = new SVerticalLayout {

      style {
        case b: SButton => b.textColor(Color.RED).onClick(toast("Bang!"))
        case t: STextView => t textSize 10.dip
        case e: SEditText => e.backgroundColor(Color.YELLOW)
      }
      STextView("I am 10 dip tall")
      STextView("Me too")
      STextView("I am 15 dip tall") textSize 150.dip // overriding
      this += new SLinearLayout {
        STextView("Buttons: ")
        SButton("Red")
        SButton("Clean")
        // clearButton.onClick( .setTextNameInputField(""))
        SButton("Set")

      }.wrap
      SEditText("Yellow input field fills the space").fill
    } padding 20.dip
    deviceSetting.context = applicationContext
    deviceSetting.activity = this
    new CupHolder(deviceSetting)
    getWindow.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)


    //  var jsonCommunication: JsonHelper = null
    //  var internetConnection: InternetHelper = null
    //  var nameOfVisitor: String = ""
    //  var continueManualSigningIn: Boolean = false
    //  var soundPool: SoundPool = null
    //  var nfcStartSound: Int = 0
    //  var nfcEndSound: Int = 0
    //  var nfcErrorSound: Int = 0
    //  var androidNfcDriver: AndroidNfcDriver = null
    //    jsonCommunication = new JsonHelper
    //    internetConnection = new InternetHelper(this)
    //    if (androidNfcDriver.nfcAdapter == null) {
    //      toast("This device doesn't support NFC.")
    //    }else if (!androidNfcDriver.nfcAdapter.isEnabled) {
    //      toast("NFC is disabled.")
    //    } else {
    //      toast("NFC is enabled.")
    //    }
    //    val policy: StrictMode.ThreadPolicy = {
    //      new StrictMode.ThreadPolicy.Builder().permitAll.build
    //    }
    //StrictMode.setThreadPolicy(policy)
    //internetConnection.checkForWiFi
    //    manualButton.onClick((v:View) => {
    //          val manualSigningInactivity: Nothing = new Nothing(BakerActivity.this, classOf[ManualSigningIn])
    //          startActivity(manualSigningInactivity  })
    //
    //      userInterface.setNameInputField(findViewById(R.id.edit_message).asInstanceOf[Nothing])
    //      val adapter: Nothing = new Nothing(MainActivity.this, android.R.layout.simple_list_item_1, new ArrayList[String])
    //      userInterface.getNameInputField.setAdapter(adapter)
    //      userInterface.getNameInputField.addTextChangedListener( new class null {
    //        def onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
    //        }
    //        def beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
    //        }
    //        def afterTextChanged(s: Nothing) {
    //          new MainActivity#refreshSuggestionNames().execute("")
    //        }
    //      })
    //      userInterface.getNameInputField.setOnItemClickListener( new class null {
    //        def onItemClick(parent: Nothing, view: Nothing, position: Int, id: Long) {
    //          nameOfVisitor = userInterface.getTextNameInputField
    //          nfcCommunicationClass.askForTag(false)
    //        }
    //      })
  }

  //
  //  override protected def onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
  //    if (requestCode == 1) {
  //      if (resultCode == Constants.RESULT_OK) {
  //        if (data.getStringExtra("handmatigaanmelden").equalsIgnoreCase("handmatigaanmelden")) {
  //          nameOfVisitor = data.getStringExtra("nameOfPerson")
  //          continueManualSigningIn = true
  //        }
  //      }
  //    }
  //  }

  private def initNfcSounds(context: Context) {
    //nfcStartSound = soundPool.load(context, R.raw.start, 1)
    //nfcEndSound = soundPool.load(context, R.raw.end, 1)
    //nfcErrorSound = soundPool.load(context, R.raw.error, 1)
  }

  private def playNfcSound(id: Int) {
    //            val audioManager: Nothing = getSystemService(Context.AUDIO_SERVICE).asInstanceOf[Nothing]
    //            val actualVolume: Float = audioManager.getStreamVolume(StreamId).asInstanceOf[Float]
    //            val maxVolume: Float = audioManager.getStreamMaxVolume(StreamId).asInstanceOf[Float]
    //            val volume: Float = actualVolume / maxVolume
    //            soundPool.play(id, volume, volume, 1, 0, 1f)
    //    play("content://media/internal/audio/media/50")
  }

  //    private def getNameInputAsNDEF(emptyOrNot: String): Nothing = {
  //      var stringToWrite: String = nameOfVisitor.concat(":" + jsonCommunication.getCollectedJSONnames.get(nameOfVisitor))
  //      if (emptyOrNot != null) {
  //        stringToWrite = emptyOrNot
  //      }
  //      val textBytes: Array[Byte] = new Array[Byte](3 + stringToWrite.length)
  //      textBytes(0) = 2
  //      System.arraycopy("en".getBytes, 0, textBytes, 1, 2)
  //      System.arraycopy(stringToWrite.getBytes, 0, textBytes, 3, stringToWrite.length)
  //      val textRecord: Nothing = new Nothing(NdefRecord.TNF_WELL_KNOWN, NdefRecord.RTD_TEXT, new Array[Byte](0), textBytes)
  //      return new Nothing(Array[Nothing](textRecord))
  //    }
  //
  //    private def getPayloadTextContent(payload: Array[Byte]): String = {
  //      var text: String = ""
  //      if (payload == null || payload.length == 0) {
  //        return text
  //      }
  //      try {
  //        val textEncoding: String = if (((payload(0) & 0200) == 0)) "UTF-8" else "UTF-16"
  //        val languageCodeLength: Int = payload(0) & 0077
  //        text = new String(payload, languageCodeLength + 1, payload.length - languageCodeLength - 1, textEncoding)
  //      }
  //      catch {
  //        case uee: UnsupportedEncodingException => {
  //          uee.printStackTrace
  //        }
  //        case sioobe: StringIndexOutOfBoundsException => {
  //          Log.d(MainActivity.TAG, "StringIndexOutOfBounds: original payload: " + payload.toString, sioobe)
  //          sioobe.printStackTrace
  //        }
  //        case ioobe: IndexOutOfBoundsException => {
  //          Log.d(MainActivity.TAG, "IndexOutOfBounds: original payload: " + payload.toString, ioobe)
  //          ioobe.printStackTrace
  //        }
  //      }
  //      return text
  //    }
  //
  //    private def isTagAuthorized(record: Nothing): Boolean = {
  //      val correctTnf: Boolean = record.getTnf eq NdefRecord.TNF_WELL_KNOWN
  //      val correctType: Boolean = Arrays.equals(record.getType, NdefRecord.RTD_TEXT)
  //      val notEmpty: Boolean = !getPayloadTextContent(record.getPayload).isEmpty
  //      return correctTnf && correctType && notEmpty
  //    }
  //
  //    protected final def onNewIntent(intent: Nothing) {
  //      nfcCommunicationClass.setCaughtNDEFMessages(getNdefMessages(intent))
  //      if (nfcCommunicationClass.getCaughtNDEFMessages == null) {
  //        return
  //      }
  //      val ndefRecords: Array[Nothing] = nfcCommunicationClass.getCaughtNDEFMessages(0).getRecords
  //      if (!isTagAuthorized(ndefRecords(0))) {
  //        Log.d("MainActivity", "Tag not authorized")
  //        showDialog("Tag niet geauthorizeerd voor gebruik in deze applicatie.\nProbeer een andere tag!", true)
  //        return
  //      }
  //      val payload: Array[Byte] = ndefRecords(0).getPayload
  //      val tagdata: String = getPayloadTextContent(payload)
  //      val writeModeEnabled: Boolean = nfcCommunicationClass.getWriteMode
  //      val readModeEnabled: Boolean = !nfcCommunicationClass.getWriteMode
  //      val tagDiscovered: Boolean = NfcAdapter.ACTION_TAG_DISCOVERED == intent.getAction
  //      val ndefDiscovered: Boolean = NfcAdapter.ACTION_NDEF_DISCOVERED == intent.getAction
  //      val tagFound: Boolean = (tagDiscovered || ndefDiscovered)
  //      var handled: Boolean = false
  //      if (writeModeEnabled && tagFound && !handled) {
  //        Log.d(MainActivity.TAG, "Sign in visitor")
  //        Log.d(MainActivity.TAG, "Tag payload: " + tagdata)
  //        if (tagdata.equalsIgnoreCase("empty")) {
  //          signInVisitorOnEmptyTag(intent)
  //        }
  //        else {
  //          signInVisitorOnUsedTag(intent, tagdata)
  //        }
  //        handled = true
  //      }
  //      if (readModeEnabled && tagFound && !handled) {
  //        Log.d(MainActivity.TAG, "Sign off visitor")
  //        Log.d(MainActivity.TAG, "Tag payload: " + tagdata)
  //        if (tagdata.equalsIgnoreCase("empty")) {
  //          signOffVisitorOnEmptyTag
  //        }
  //        else {
  //          signOffVisitorOnUsedTag(intent, tagdata)
  //        }
  //        handled = true
  //      }
  //      if (!handled) {
  //        Log.d(MainActivity.TAG, "No actions perfomed on tag")
  //      }
  //    }
  //
  //    private def signOffVisitorOnEmptyTag {
  //      if (nfcCommunicationClass.getHowToUseDialog != null) {
  //        nfcCommunicationClass.getHowToUseDialog.dismiss
  //      }
  //      showDialog("Tag is niet gebruikt voor aanmelden. Probeer een andere!", true)
  //      userInterface.getNameInputField.setFocusable(true)
  //      userInterface.setTextNameInputField("")
  //      playNfcSound(nfcErrorSound)
  //    }
  //
  //    private def signOffVisitorOnUsedTag(intent: Nothing, tagdata: String) {
  //      signOffVisitorOnUsedTag(intent, tagdata, true)
  //    }
  //
  //    private def signOffVisitorOnUsedTag(intent: Nothing, tagdata: String, playSound: Boolean) {
  //      val splittedString: Array[String] = tagdata.split(":")
  //      jsonCommunication.writeJSON(splittedString, "archive")
  //      val detectedTag: Nothing = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG)
  //      if (nfcCommunicationClass.writeTag(getNameInputAsNDEF("empty"), detectedTag)) {
  //        showDialog(splittedString(0) + " is afgemeld bij Altran, een prettige dag verder!")
  //        userInterface.getNameInputField.setFocusable(true)
  //        userInterface.setTextNameInputField("")
  //        if (playSound) {
  //          playNfcSound(nfcStartSound)
  //        }
  //      }
  //      else {
  //        showDialog("Scan tag opnieuw voor " + splittedString(0))
  //      }
  //    }
  //
  //    private def signInVisitorOnUsedTag(intent: Nothing, tagdata: String) {
  //      signOffVisitorOnUsedTag(intent, tagdata, false)
  //      signInVisitorOnEmptyTag(intent)
  //    }
  //
  //    private def signInVisitorOnEmptyTag(intent: Nothing) {
  //      val detectedTag: Nothing = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG)
  //      if (nfcCommunicationClass.writeTag(getNameInputAsNDEF(null), detectedTag)) {
  //        val tempString: Array[String] = Array[String](nameOfVisitor, jsonCommunication.getCollectedJSONnames.get(nameOfVisitor))
  //        jsonCommunication.writeJSON(tempString, "present")
  //        if (nfcCommunicationClass.getHowToUseDialog.isShowing) {
  //          nfcCommunicationClass.getHowToUseDialog.dismiss
  //        }
  //        showDialog(nameOfVisitor + " is aangemeld bij Altran\n")
  //        userInterface.getNameInputField.setFocusable(true)
  //        userInterface.setTextNameInputField("")
  //        playNfcSound(nfcStartSound)
  //      }
  //      else {
  //        showDialog("Scan tag opnieuw voor " + nameOfVisitor)
  //      }
  //    }
  //
  //    /**
  //     * After a NFC tag has been discovered, this
  //     * method will parse the NFC tag and put all the
  //     * NDEF messages in an array.
  //     *
  //     * @param 	intent
  //     * The intent of the discovered NFC tag.
  //     * @return All of the parsed NDEF messages in an array.
  //     */
  //    private def getNdefMessages(intent: Nothing): Array[Nothing] = {
  //      var msgs: Array[Nothing] = null
  //      val action: String = intent.getAction
  //      if ((NfcAdapter.ACTION_TAG_DISCOVERED == action) || (NfcAdapter.ACTION_NDEF_DISCOVERED == action)) {
  //        val rawMsgs: Array[Nothing] = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)
  //        if (rawMsgs != null) {
  //          msgs = new Array[Nothing](rawMsgs.length)
  //          {
  //            var i: Int = 0
  //            while (i < rawMsgs.length) {
  //              {
  //                msgs(i) = rawMsgs(i).asInstanceOf[Nothing]
  //              }
  //              ({
  //                i += 1; i - 1
  //              })
  //            }
  //          }
  //        }
  //        else {
  //          val empty: Array[Byte] = Array[Byte]
  //          val record: Nothing = new Nothing(NdefRecord.TNF_UNKNOWN, empty, empty, empty)
  //          val msg: Nothing = new Nothing(Array[Nothing](record))
  //          msgs = Array[Nothing](msg)
  //        }
  //      }
  //      else {
  //        Log.d(Constants.NFC_TAG, "Unknown Intent")
  //        finish
  //      }
  //      return msgs
  //    }
  //
  //    protected final def onResume {
  //      super.onResume
  //      nfcCommunicationClass.setWriteMode(false)
  //      nfcCommunicationClass.setupForegroundDispatch(this, nfcCommunicationClass.getNFCAdapter)
  //      if (continueManualSigningIn) {
  //        nfcCommunicationClass.askForTag(false)
  //        continueManualSigningIn = false
  //      }
  //    }
  //
  //    protected final def onPause {
  //      nfcCommunicationClass.stopForegroundDispatch(this, nfcCommunicationClass.getNFCAdapter)
  //      super.onPause
  //    }
  //
  //    def onSaveInstanceState(savedInstanceState: Nothing) {
  //      super.onSaveInstanceState(savedInstanceState)
  //    }
  //
  //    /**
  //     * Showing a dialog
  //     *
  //     * @param 	message
  //     * The string that will be shown
  //     * in the pop up.
  //     */
  //    def showDialog(message: String) {
  //      showDialog(message, false)
  //    }
  //
  //    def showDialog(message: String, isErrorMessage: Boolean) {
  //      val inflater: Nothing = getLayoutInflater
  //      val layout: Nothing = inflater.inflate(R.layout.message_dialog, findViewById(R.id.messageDialogToast).asInstanceOf[Nothing])
  //      if (isErrorMessage) {
  //        layout.setBackgroundColor(Color.rgb(180, 14, 22))
  //      }
  //      val text: Nothing = layout.findViewById(R.id.text).asInstanceOf[Nothing]
  //      text.setText(message)
  //      val toast: Nothing = new Nothing(this)
  //      toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
  //      toast.setDuration(Toast.LENGTH_LONG)
  //      toast.setView(layout)
  //      toast.show
  //      Log.d(MainActivity.TAG, message)
  //    }
  //
  //    /**
  //     * Calling this method will refresh the suggestions of the
  //     * input text field. It reads out the database and puts
  //     * the names of all visitors today in the suggestion list.
  //     */
  //    private class refreshSuggestionNames extends AsyncTask[String, Void, ArrayList[String]] {
  //      protected def doInBackground(params: String*): ArrayList[String] = {
  //        val names: String = jsonCommunication.readDatabaseJSON
  //        val result: ArrayList[String] = new ArrayList[String]
  //        try {
  //          jsonCommunication.setDatabaseJSONObject(new Nothing(names))
  //          val iterator: Iterator[String] = jsonCommunication.getDatabaseJSONObject.keys
  //          while (iterator.hasNext) {
  //            val key: String = iterator.next
  //            result.add(String.valueOf(key))
  //            val bla: Nothing = jsonCommunication.getDatabaseJSONObject.getJSONObject(key)
  //            jsonCommunication.setACollectedJSONName(key, bla.getString("visitID"))
  //          }
  //          updateLogWithFetchedNames
  //        }
  //        catch {
  //          case e: Exception => {
  //            Log.d(Constants.JSON_TAG, "No JSON object retrieved from PHP Server", e)
  //          }
  //        }
  //        return result
  //      }
  //
  //      private def updateLogWithFetchedNames {
  //        val enumKey: Enumeration[String] = jsonCommunication.getCollectedJSONnames.keys
  //        while (enumKey.hasMoreElements) {
  //          val key: String = enumKey.nextElement
  //          val `val`: String = jsonCommunication.getCollectedJSONnames.get(key)
  //          Log.i(key, `val`)
  //        }
  //      }
  //
  //      protected def onPostExecute(listOfNames: ArrayList[String]) {
  //        val adapter: Nothing = userInterface.getNameInputField.getAdapter.asInstanceOf[Nothing]
  //        adapter.clear
  //        adapter.addAll(listOfNames)
  //      }
  //    }
  //
  //  }
}
