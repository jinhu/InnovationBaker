package dev.chimera.innovation

/**
 * Created by jin on 3/14/15.
 */
class NfcDriver {
  def write(bytes: Array[Byte]): Boolean = {
    return true
  }

  def read(): Array[Byte] = {
    return "{C:100,W:100,M:100,S:100,T:100}".getBytes()
  }

}
