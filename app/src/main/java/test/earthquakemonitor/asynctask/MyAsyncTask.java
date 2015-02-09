package test.earthquakemonitor.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONObject;

import test.earthquakemonitor.R;
import test.earthquakemonitor.dto.DtoAllHour;
import test.earthquakemonitor.iface.AsyncTaskResult;
import test.earthquakemonitor.json.JSonParser;
import test.earthquakemonitor.preferences.MySharedPreferences;

/**
 * Created by luisangelgarcia on 05/02/15.
 */
public class MyAsyncTask extends AsyncTask<Void, Void, DtoAllHour> {
    // ===========================================================
    // Constants
    // ===========================================================
    private final String FIELD_TYPE = "type";
    private final String FIELD_METADATA = "metadata";
    private final String FIELD_FEATURES = "features";
    private final String FIELD_BBOX = "bbox";
    // ===========================================================
    // Fields
    // ===========================================================
    private Context context;
    private ProgressDialog progressDialog;
    private String url;
    private AsyncTaskResult asyncTaskResult = null;
    private JSONObject jsonObject;

    // ===========================================================
    // Constructors
    // ===========================================================
    public MyAsyncTask(Context context) {
        this.context = context;
        url = this.context.getResources().getString(R.string.URL_JSON);
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    protected DtoAllHour doInBackground(Void... params) {
        DtoAllHour dtoAllHour = null;
        try {
            JSonParser jSonParser = new JSonParser();
            jsonObject = jSonParser.getJsonObject(url);
            if (jsonObject == null) {
                MySharedPreferences mySharedPreferences = new MySharedPreferences(this.context);
                String json = mySharedPreferences.getString(context.getResources()
                        .getString(R.string.sp_json_key), null);
                if (json == null) {
                    return dtoAllHour;
                }
                jsonObject = new JSONObject(json);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            dtoAllHour = objectMapper.readValue(jsonObject.toString(), new TypeReference<DtoAllHour>() {
            });
        } catch (Throwable t) {
            Log.e("Throwable", t.getMessage());
        }
        return dtoAllHour;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.progressDialog = new ProgressDialog(this.context);
        this.progressDialog.setMessage(this.context.getResources().getString(R.string.txt_progress_dialog));
        this.progressDialog.setCancelable(false);
        this.progressDialog.show();
    }

    @Override
    protected void onPostExecute(DtoAllHour dtoAllHour) {
        super.onPostExecute(dtoAllHour);
        if (this.progressDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
        try {
            asyncTaskResult = (AsyncTaskResult) context;
            asyncTaskResult.taskFinish(dtoAllHour, jsonObject.toString());
        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
