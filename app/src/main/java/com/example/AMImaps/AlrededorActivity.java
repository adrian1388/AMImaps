package com.example.AMImaps;

import android.content.Context;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class AlrededorActivity extends AppCompatActivity implements OnMapReadyCallback,LocationListener {


    private GoogleMap mMap;
    private Location location;
    private LocationManager mLocationManager;
    List<LatLng> bus1;
    PolylineOptions polylineOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alrededor);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapa_alrededor);
        mapFragment.getMapAsync(this);

        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        String provider = mLocationManager.getBestProvider(new Criteria(), true);
        location = mLocationManager.getLastKnownLocation(provider);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in ESPOL and move the camera

//        mMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(),location.getLongitude()))
//                .title("Mi posición, " + mLocationManager.getBestProvider(new Criteria(), true)));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude())));
//        mMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
        MostrarRutas();
    }

    @Override
    public void onLocationChanged(Location location) {
//        if (location != null) {
//            Toast.makeText(this, "Latud: " + location.getLatitude() + ", Longitud: " + location.getLongitude(),
//                    Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Latud: 0, Longitud: 0",
//                    Toast.LENGTH_SHORT).show();
//        }
    }

    public void MostrarRutas() {
        bus1 = new ArrayList<LatLng>();
//        mMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
//        mMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(-2.123375, -79.593435)));
        polylineOptions = new PolylineOptions();
        polylineOptions.color(Color.BLUE);
        polylineOptions.width(6);
        bus1.add(new LatLng(-2.120568, -79.594029));
        bus1.add(new LatLng(-2.120547, -79.593053));
        bus1.add(new LatLng(-2.12111, -79.593089));
        bus1.add(new LatLng(-2.121727, -79.593221));
        bus1.add(new LatLng(-2.122255, -79.593274));
        bus1.add(new LatLng(-2.122579, -79.593339));
        bus1.add(new LatLng(-2.122941, -79.593384));
        bus1.add(new LatLng(-2.123375, -79.593435));
        bus1.add(new LatLng(-2.124083, -79.593519));
        bus1.add(new LatLng(-2.124364, -79.593454));
        bus1.add(new LatLng(-2.124967, -79.593505));
        bus1.add(new LatLng(-2.125651, -79.593591));
        bus1.add(new LatLng(-2.126423, -79.593685));
        bus1.add(new LatLng(-2.127042, -79.593749));
        bus1.add(new LatLng(-2.127444, -79.5938));
        polylineOptions.addAll(bus1);
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2.123375, -79.593435))
                .title("Mi posición, " + mLocationManager.getBestProvider(new Criteria(), true))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(-2.123375, -79.593435)));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
        mMap.addPolyline(polylineOptions);

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
