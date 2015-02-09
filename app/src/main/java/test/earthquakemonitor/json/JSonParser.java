package test.earthquakemonitor.json;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import test.earthquakemonitor.R;

/**
 * Created by luisangelgarcia on 05/02/15.
 */
public class JSonParser {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private InputStream iStream = null;
    private JSONObject jsonObject = null;
    private String json = "";
    // ===========================================================
    // Constructors
    // ===========================================================
    public JSonParser() {

    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================
    public JSONObject getJsonObject(String url) {
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            iStream = httpEntity.getContent();
        } catch(UnsupportedOperationException e) {
            e.printStackTrace();
        } catch(ClientProtocolException e) {
            Log.e("ClientProtocolException", e.getMessage());
            e.printStackTrace();
        } catch(IOException e) {
            Log.e("IOException", e.getMessage());
            e.printStackTrace();
        } catch(Exception e) {
            Log.e("Exception", e.getMessage());
            e.printStackTrace();
        }
        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream, "iso-8859-1"), 8);
            StringBuilder sBuilder = new StringBuilder();
            String readLine = null;
            while((readLine = bReader.readLine()) != null) {
                sBuilder.append(readLine + "\n");
            }
            iStream.close();
            json = sBuilder.toString();
        } catch(IOException e) {
            Log.e("IOException", e.getMessage());
            e.printStackTrace();
        } catch(Exception e) {
            Log.e("Exception", e.getMessage());
            e.printStackTrace();
        }
        try {
            jsonObject = new JSONObject(json);
        } catch(JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
