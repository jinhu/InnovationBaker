package dev.chimera.innovation

class RestNode(deviceSetting: DeviceSetting) {
  //} extends DefaultHttpClient {
  var driver = new RestDriver()
  //  var context: Context = deviceSetting.context
  //  var params: HttpParams = deviceSetting.paramSet
  //
  //
  //  protected override def createClientConnectionManager: ClientConnectionManager = {
  //    val registry: SchemeRegistry = new SchemeRegistry
  //    registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory, 80))
  //    registry.register(new Scheme("https", newSslSocketFactory, 443))
  //    return new SingleClientConnManager(params, registry)
  //  }
  //
  //  protected def newSslSocketFactory: SSLSocketFactory = {
  //    try {
  //      val trusted: KeyStore = KeyStore.getInstance("BKS")
  //      val is: InputStream = context.getResources.openRawResource(R.raw.test_server_keystore)
  //      try {
  //        trusted.load(is, "".toCharArray)
  //      } finally {
  //        is.close
  //      }
  //      val sf: SSLSocketFactory = new SSLSocketFactory(trusted)
  //      sf.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER)
  //      return sf
  //    }
  //    catch {
  //      case e: Exception => {
  //        e.printStackTrace
  //        throw new AssertionError(e)
  //      }
  //    }
  //  }
}
