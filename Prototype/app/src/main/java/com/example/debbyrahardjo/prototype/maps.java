package com.example.debbyrahardjo.prototype;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class maps extends ActionBarActivity {

    static final LatLng Semarang = new LatLng(-6.990922064089975 , 110.42298316955566);
    private GoogleMap googleMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        try {
            if (googleMap == null) {
                googleMap = ((MapFragment) getFragmentManager().
                        findFragmentById(R.id.map)).getMap();
            }

            // ENABLE MY LOCATION
            googleMap.setMyLocationEnabled(true);
            // GET COORDINATE MY LOCATION

            // FOKUS KE LOKASI KITA DAN ZOOM TO 12
            CameraUpdate MyLocation = CameraUpdateFactory.newLatLngZoom(Semarang, 12);
            googleMap.animateCamera(MyLocation);

            // JENIS TAMPILAN MAPSNYA
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            // POSISI MARKER/TITIK
            //    googleMap.addMarker(new MarkerOptions().position(MyLoc).title("Lokasi Gueeh"));
            googleMap.addMarker(new MarkerOptions().position(Semarang).title("Rumah Makan Padang Sederhana, Kota Semarang"));
            // ENABLE ZOOM BY GESTURES
            googleMap.getUiSettings().setZoomGesturesEnabled(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent st = new Intent(this,settings.class);
            startActivity(st);
        }
        else if (id == R.id.action_about){
            Intent ab = new Intent (this,about_us.class);
            startActivity(ab);
        }

        return super.onOptionsItemSelected(item);
    }
}
