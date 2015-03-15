package dev.chimera.innovation

/**
Created by jin on 3/15/15.
  */
object Constants {
  /** The Constant NFC_TAG.
    * A debug info tag. Used for
    * NFC information. */
  val NFC_TAG: String = "NFC_ACTION"
  /** The Constant JSON_TAG.
    * A debug info tag. Used for
    * JSON information. */
  val JSON_TAG: String = "JSON_ACTION"
  /** The Constant INFO_TAG.
    * A debug info tag. Used for general
    * information. */
  val INFO_TAG: String = "GENERAL"
  /** The Constant DIALOG_MS_TO_LIVE.
    * Is telling how much milliseconds a dialog
    * may 'live' */
  val DIALOG_MS_TO_LIVE: Int = 2000
  /** The Constant HTTP_OK.
    * Used as check. */
  val HTTP_OK: Int = 200
  /** Constant to determine the minimum and
    * maximum IP address. (ONLY USED FOR DEBUGGING
    * IN APELDOORN) */
  val MIN_IP: Int = 100
  val MAX_IP: Int = 120
  /** Constant holding the number of milliseconds
    * the ping must try when trying to reach
    * multiple addresses of server. */
  val MS_TO_WAIT_HTTP: Int = 5
  val SERVER_URL: String = "https://www.onderwegmettass.nl/"
  val AUTH_HOST: String = "www.onderwegmettass.nl"
  val TEST_SERVER_URL: String = "https://testextranet.tass.lan/"
  val TEST_AUTH_HOST: String = "testextranet.tass.lan"
  val AUTH_USERNAME: String = "welkom_app"
  val AUTH_PASSWORD: String = "3rNxWf3D0jUyrtucJl3O"
  val RESULT_OK: Int = 200

}
