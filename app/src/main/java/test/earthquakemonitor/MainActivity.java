package test.earthquakemonitor;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import test.earthquakemonitor.adapter.AdapterQuake;
import test.earthquakemonitor.asynctask.MyAsyncTask;
import test.earthquakemonitor.dto.DtoAllHour;
import test.earthquakemonitor.dto.DtoBundle;
import test.earthquakemonitor.dto.DtoFeatures;
import test.earthquakemonitor.iface.AsyncTaskResult;
import test.earthquakemonitor.preferences.MySharedPreferences;

public class MainActivity extends ActionBarActivity implements AsyncTaskResult {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private ListView quakeList;
    private AdapterQuake adapterQuake;
    private ArrayList<DtoFeatures> items;
    private TextView txtNoData;
    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyAsyncTask myAsyncTask = new MyAsyncTask(this);
        myAsyncTask.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            MyAsyncTask myAsyncTask = new MyAsyncTask(this);
            myAsyncTask.execute();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void taskFinish(DtoAllHour dtoAllHour, String json) {
        makeQuakeList(dtoAllHour.getFeatures(), json);
    }

    // ===========================================================
    // Methods
    // ===========================================================
    private void makeQuakeList(DtoFeatures[] dtoFeatureses, String json) {
        if (dtoFeatureses == null) {
            return;
        } else {
            // Save data
            MySharedPreferences mySharedPreferences = new MySharedPreferences(this);
            mySharedPreferences.putString(getResources().getString(R.string.sp_json_key), json);
        }
        txtNoData = (TextView) findViewById(R.id.txt_no_data);
        txtNoData.setVisibility(View.INVISIBLE);
        this.quakeList = (ListView) findViewById(R.id.quake_list);
        this.items = new ArrayList<>();
        for (int i = 0; i < dtoFeatureses.length; i++) {
            this.items.add(dtoFeatureses[i]);
            Log.d("TAG", dtoFeatureses[i].toString());
        }
        this.adapterQuake = new AdapterQuake(this, items);
        this.quakeList.setAdapter(this.adapterQuake);
        this.quakeList.setOnItemClickListener(this.onItemClickListener);
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent iDetail = new Intent(getApplicationContext(), DetailActivity.class);
            String title = items.get(position).getProperties().getTitle();
            float mag = items.get(position).getProperties().getMag();
            long time = items.get(position).getProperties().getTime();
            long updated = items.get(position).getProperties().getUpdated();
            String place = items.get(position).getProperties().getPlace();
            double lat = items.get(position).getGeometry().getCoordinates()[1];
            double lon = items.get(position).getGeometry().getCoordinates()[0];
            double depth = items.get(position).getGeometry().getCoordinates()[2];
            DtoBundle dtoBundle = new DtoBundle(title, mag, time, updated, place, lat, lon, depth);
            iDetail.putExtra("dtoBundle", dtoBundle);
            startActivity(iDetail);
        }
    };
}
