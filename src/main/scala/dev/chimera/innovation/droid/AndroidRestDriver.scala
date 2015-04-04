package dev.chimera.innovation.droid

/**
 * Created by jin on 3/15/15.
 */

import java.util.{ArrayList, List}

import dev.chimera.innovation.Constants
import org.apache.http.NameValuePair
import org.apache.http.auth.{AuthScope, UsernamePasswordCredentials}
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.{HttpGet, HttpPost}
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.message.BasicNameValuePair
import org.apache.http.util.EntityUtils

class AndroidRestDriver {
  val post: HttpPost = new HttpPost(Constants.SERVER_URL + "Subwebs/WelkomApp/Public/visitor_signIn.php")
  val nameValuePairs: List[NameValuePair] = new ArrayList[NameValuePair](2)
  var result: String = ""
  var client = new DefaultHttpClient

  def writeJSON(incomingString: Array[String], status: String) {
    client.getCredentialsProvider.setCredentials(new AuthScope(Constants.AUTH_HOST, AuthScope.ANY_PORT), new UsernamePasswordCredentials(Constants.AUTH_USERNAME, Constants.AUTH_PASSWORD))
    nameValuePairs.add(new BasicNameValuePair("json", "{\"visit_id\":\"" + incomingString(1) + "\",\"status\":\"" + status + "\",\"tag_id\":\"0\"}"))
    post.setEntity(new UrlEncodedFormEntity(nameValuePairs))
    val response = client.execute(post)
    if (response.getStatusLine().getStatusCode() == 200) {
      result = EntityUtils.toString(response.getEntity());
    } else {
      result = response.getStatusLine().toString();
    }
  }

  def readJson: String = {
    var client = new DefaultHttpClient
    var get = new HttpGet(Constants.SERVER_URL + "Subwebs/WelkomApp/Public/visitors_json.php")

    client.getCredentialsProvider.setCredentials(new AuthScope(Constants.AUTH_HOST, AuthScope.ANY_PORT),
      new UsernamePasswordCredentials(Constants.AUTH_USERNAME, Constants.AUTH_PASSWORD))
    var responseEntity = client.execute(get).getEntity
    EntityUtils.toString(responseEntity)
  }
}
