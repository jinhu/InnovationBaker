package dev.chimera.innovation

/**
 * Created by jin on 3/15/15.
 */

import android.app.{Activity, AlertDialog}
import android.content.Context
import android.net.{ConnectivityManager, NetworkInfo}
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.params.{BasicHttpParams, HttpConnectionParams, HttpParams}

/** Holding all the information about
  * connecting with the Internet.
  */
class InternetHelper {
  private var activityMain: Activity = null
  private var applicationContext: Context = null
  private var jsonCommunication: JsonHelper = null
  private var builder: AlertDialog.Builder = null

  /**
   * Constructor.
   * Primarily used for initializing.
   *
   * @param 	activity
	 * Reference to Activity class.
   */
  def this(activity: Activity) {
    this()
    activityMain = activity
    applicationContext = activityMain.getApplicationContext
    jsonCommunication = new JsonHelper
    builder = new AlertDialog.Builder(activityMain)
  }

  /**
   * Checking if the tablet is connected with
   * the Internet.
   */
  def isNetworkAvailable: Boolean = {
    val cm: ConnectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE).asInstanceOf[ConnectivityManager]
    val networkInfo: NetworkInfo = cm.getActiveNetworkInfo
    if (networkInfo != null && networkInfo.isConnected) {
      return true
    }
    return false
  }

  /**
   * ONLY BEING USED IN APELDOORN!
   * Search for the IP Address being used.
   */
  def searchForRightIP {
    {
      var i: Int = Constants.MIN_IP
      while (i <= Constants.MAX_IP) {
        {
          try {
            val request: HttpGet = new HttpGet("http://10.11.2." + i + ":8000/")
            val httpParameters: HttpParams = new BasicHttpParams
            HttpConnectionParams.setConnectionTimeout(httpParameters, Constants.MS_TO_WAIT_HTTP)
            val httpClient: HttpClient = new DefaultHttpClient(httpParameters)
            httpClient.execute(request)
            jsonCommunication.ipToSet = "10.11.2." + i
          }
          catch {
            case e1: Exception => {
              e1.printStackTrace
            }
          }
        }
        ({
          i += 1;
          i - 1
        })
      }
    }
  }

  /**
   * Simple check if WiFi is turned on.
   * If false, let the user go to the
   * WiFi settings activity.
   */
  //  def checkForWiFi {
  //    if (!isNetworkAvailable) {
  //      builder.setMessage("WiFi staat niet aan. " + "Wilt u het aan zetten?\nLet op: " + "applicatie wordt afgesloten als " + "het niet nu aangezet wordt")
  //      builder.setCancelable(true)
  //      builder.setPositiveButton("OK", new class null {
  //        def onClick(dialog: DialogInterface, which: Int) {
  //          activityMain.startActivityForResult(new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS), 0)
  //        }
  //      })
  //      builder.setNegativeButton("Later", new class null {
  //        def onClick(dialog: DialogInterface, which: Int) {
  //          System.exit(0)
  //        }
  //      })
  //      val dialog: AlertDialog = builder.create
  //      dialog.show
  //    }
  //    else {
  //    }
  //  }
}
