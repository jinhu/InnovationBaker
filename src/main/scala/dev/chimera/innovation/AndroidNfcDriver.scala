package dev.chimera.innovation

import scala.collection.immutable.HashMap

/**
 * Created by jin on 3/14/15.
 */
class AndroidNfcDriver extends NfcDriver {
  override def retrieve(): Map[String, Object] = {
    //    val data: Map[String, Object] = Map(
    //      ("coffee",      100),
    //      ("water",       100),
    //      ("milk",        100),
    //      ("sugar",       100),
    //      ("temperature", 100))
    //    return data
    return HashMap()
  }
}
