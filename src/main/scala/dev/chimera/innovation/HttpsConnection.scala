package dev.chimera.innovation

import java.io.InputStream
import java.security.KeyStore

import android.content.Context
import org.apache.http.conn.ClientConnectionManager
import org.apache.http.conn.scheme.{PlainSocketFactory, Scheme, SchemeRegistry}
import org.apache.http.conn.ssl.SSLSocketFactory
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.impl.conn.SingleClientConnManager

class HttpsConnection(aContext: Context, aParamSet: Nothing) extends DefaultHttpClient {
  var context: Context = aContext
  var params: Nothing = aParamSet


  protected override def createClientConnectionManager: ClientConnectionManager = {
    val registry: SchemeRegistry = new SchemeRegistry
    registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory, 80))
    registry.register(new Scheme("https", newSslSocketFactory, 443))
    return new SingleClientConnManager(getParams, registry)
  }

  protected def newSslSocketFactory: SSLSocketFactory = {
    try {
      val trusted: KeyStore = KeyStore.getInstance("BKS")
      val is: InputStream = context.getResources.openRawResource(R.raw.test_server_keystore)
      try {
        trusted.load(is, "".toCharArray)
      } finally {
        is.close
      }
      val sf: SSLSocketFactory = new SSLSocketFactory(trusted)
      sf.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER)
      return sf
    }
    catch {
      case e: Exception => {
        e.printStackTrace
        throw new AssertionError(e)
      }
    }
  }
}
