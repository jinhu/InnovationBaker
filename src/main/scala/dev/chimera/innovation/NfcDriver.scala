package dev.chimera.innovation

/**
 * Created by jin on 3/14/15.
 */
abstract class NfcDriver {
  def retrieve(): Map[String, Object]

}
