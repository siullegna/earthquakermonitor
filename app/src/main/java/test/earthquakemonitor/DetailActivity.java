package test.earthquakemonitor;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.Date;

import test.earthquakemonitor.dto.DtoBundle;


public class DetailActivity extends ActionBarActivity {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private DtoBundle dtoBundle;
    private ActionBar actionBar;
    private GoogleMap googleMap;
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
        setContentView(R.layout.activity_detail);
        this.actionBar = getSupportActionBar();
        this.actionBar.setDisplayHomeAsUpEnabled(true);
        if (getIntent().getExtras() != null) {
            this.dtoBundle = getIntent().getParcelableExtra("dtoBundle");
            this.actionBar.setTitle(this.dtoBundle.getTitle());
            Log.d("dtoBundle", this.dtoBundle.toString());
        } else {
            // No Extra Information
            this.dtoBundle = null;
        }
        init();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if(id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    // ===========================================================
    // Methods
    // ===========================================================
    private void init() {
        if (this.dtoBundle != null) {
            TextView txtMagnitude = (TextView) findViewById(R.id.txt_magnitude);
            TextView txtDate = (TextView) findViewById(R.id.txt_date);
            TextView txtLocation = (TextView) findViewById(R.id.txt_location);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm");
            Date date = new Date(this.dtoBundle.getTime());
            txtMagnitude.setText(String.valueOf(this.dtoBundle.getMag()));
            txtDate.setText(simpleDateFormat.format(date));
            txtLocation.setText(this.dtoBundle.getPlace());
            addMap();
        }
    }

    private void addMap() {
        this.googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        if(this.googleMap != null) {
            LatLng place = new LatLng(this.dtoBundle.getLat(), this.dtoBundle.getLon());
            this.googleMap.addMarker(new MarkerOptions().position(place).title(this.dtoBundle.getPlace()));
            this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place, 10));
        }
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
