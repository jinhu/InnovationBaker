package dev.chimera.innovation

/**
 * Created by jin on 3/15/15.
 */

import org.apache.http.NameValuePair
import org.apache.http.auth.{AuthScope, UsernamePasswordCredentials}
import org.apache.http.client.ResponseHandler
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.{HttpGet, HttpPost}
import org.apache.http.impl.client.{BasicResponseHandler, DefaultHttpClient}
import org.apache.http.message.BasicNameValuePair

//import org.bouncycastle.jce.provider.BouncyCastleProvider

import java.io.{BufferedReader, InputStream, InputStreamReader}
import java.util.{ArrayList, List}

import org.json.JSONObject

class JsonHelper {

  var databaseJSONObject: JSONObject = null
  var ipToSet: String = null
  //Security.addProvider(new Provider())

  var collectedJsonNames = null

  final def writeJSON(incomingString: Array[String], status: String) {
    try {
      val client: DefaultHttpClient = new DefaultHttpClient
      val post: HttpPost = new HttpPost(Constants.SERVER_URL + "Subwebs/WelkomApp/Public/visitor_signIn.php")
      client.getCredentialsProvider.setCredentials(new AuthScope(Constants.AUTH_HOST, AuthScope.ANY_PORT), new UsernamePasswordCredentials(Constants.AUTH_USERNAME, Constants.AUTH_PASSWORD))
      val nameValuePairs: List[NameValuePair] = new ArrayList[NameValuePair](2)
      nameValuePairs.add(new BasicNameValuePair("json", "{\"visit_id\":\"" + incomingString(1) + "\",\"status\":\"" + status + "\",\"tag_id\":\"0\"}"))
      post.setEntity(new UrlEncodedFormEntity(nameValuePairs))
      //Log.d(JsonHelper.toString(), nameValuePairs.toString)
      val responseHandler: ResponseHandler[String] = new BasicResponseHandler
      client.execute(post, responseHandler)
    }
    catch {
      case e: Exception => {
        //Log.d(JsonHelper.TAG, "Could not update visitor data", e)
        e.printStackTrace
      }
    }
  }

  /**
   * Get information from the database in
   * JSON language. Requesting it with a
   * HTTP GET.
   */
  final def readDatabaseJSON: String = {
    val builder: StringBuilder = new StringBuilder
    try {
      val client: DefaultHttpClient = new DefaultHttpClient
      val get: HttpGet = new HttpGet(Constants.SERVER_URL + "Subwebs/WelkomApp/Public/visitors_json.php")
      client.getCredentialsProvider.setCredentials(new AuthScope(Constants.AUTH_HOST, AuthScope.ANY_PORT),
        new UsernamePasswordCredentials(Constants.AUTH_USERNAME, Constants.AUTH_PASSWORD))
      val responseEntity = client.execute(get).getEntity
      val content: InputStream = responseEntity.getContent
      val reader: BufferedReader = new BufferedReader(new InputStreamReader(content))
      var line: String = null
      while ( {
        line = reader.readLine;
        line
      } != null) {
        if (line.contains("%%%")) {
          val parts: Array[String] = line.split("%%%")
          builder.append(parts(1).trim)
        }
      }
    }
    catch {
      case e: Exception => {
        //Log.d(JsonHelper.TAG, "Could not read visitor data", e)
        e.printStackTrace
      }
    }
    val s: String = builder.toString
    //Log.d(JsonHelper.TAG, "ReadDatabaseJSON: " + s)
    return s
  }
}
