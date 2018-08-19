package com.example.AMImaps;

import android.content.Context;
import android.graphics.Color;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,OnClickListener {

    LatLng espol = new LatLng(-2.145572, -79.967447);
    LatLng casa = new LatLng(-2.120284, -79.593949);

    double lat1 = 0.0, lng1 = 0.0, lat2 = 0.0, lng2 = 0.0;

    private GoogleMap mMap;
    TextView messageTextView;

    private boolean grabando = false;
    private Button GrabarRuta;
    private Button MostrarRutas;
    private Timer t;

    private String provider;
    LinearLayout layoutOfPopup;
    PopupWindow popupMessage;
    Button popupButton, insidePopupButton;
    TextView popupText;
    PolylineOptions polylineOptions;
    List<LatLng> points;
    List<LatLng> bus1;
    MyLocationListener mlocListener;
    private Timer t2 = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        messageTextView = (TextView) findViewById(R.id.message_id);

        //init();
        //popupInit();
        LocationManager mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mlocListener = new MyLocationListener();
        mlocListener.setMapsActivity(this);
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) mlocListener);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        GrabarRuta = (Button) findViewById(R.id.grabar_ruta);

//        Criteria criteria = new Criteria();
//        provider = mLocationManager.getBestProvider(criteria, false);
//        Location location = mLocationManager.getLastKnownLocation(provider);
//        if (location != null)
//            messageTextView.setText(location.getLatitude() + ", " + location.getLongitude());
//        else
//            messageTextView.setText(0 + ", " + 0);

//        if (location != null) {
//            Toast.makeText(this, "Selected Provider " + provider,
//                    Toast.LENGTH_SHORT).show();
//            mlocListener.onLocationChanged(location);
//        } else {
//
//            //do something
//        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.mostrar_rutas) {
            popupMessage.showAsDropDown(popupButton, 0, 0);
        }

        else {
            popupMessage.dismiss();
        }
    }

//    public void init() {
//        popupButton = (Button) findViewById(R.id.mostrar_rutas);
//        popupText = new TextView(this);
//        insidePopupButton = new Button(this);
//        layoutOfPopup = new LinearLayout(this);
//        insidePopupButton.setText("OK");
//        popupText.setText("This is Popup Window.press OK to dismiss it.");
//        popupText.setPadding(0, 0, 0, 20);
//        layoutOfPopup.setOrientation(LinearLayout.VERTICAL);
//        layoutOfPopup.addView(popupText);
//        layoutOfPopup.addView(insidePopupButton);
//        //popupMessage.update(5,10,-1,-1,true);
//    }
//
//    public void popupInit() {
//        popupButton.setOnClickListener(this);
//        insidePopupButton.setOnClickListener(this);
//        popupMessage = new PopupWindow(layoutOfPopup, LayoutParams.FILL_PARENT,
//                LayoutParams.WRAP_CONTENT);
//        popupMessage.setContentView(layoutOfPopup);
//    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in ESPOL and move the camera

        mMap.addMarker(new MarkerOptions().position(espol).title("Marker in ESPOL, GYE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(espol));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
    }

    public void onClickGrabarButton(View v) {

        final Animation animation = new AlphaAnimation(1, 0);
        animation.setDuration(500);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);

        mMap.addMarker(new MarkerOptions().position(mlocListener.points.iterator().next())).setTitle("home");
        mMap.animateCamera(CameraUpdateFactory.newLatLng(mlocListener.points.iterator().next()));
        polylineOptions = new PolylineOptions();
        polylineOptions.color(Color.rgb(18, 178, 0));
        polylineOptions.width(8);
        polylineOptions.addAll(mlocListener.points);
        mMap.addPolyline(polylineOptions);

        if (v == GrabarRuta && grabando == false) {
            v.setBackgroundResource(R.drawable.marker_blue);
            grabando = true;
            v.startAnimation(animation);
            t = new Timer();
            t.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Log.d("PRUEBA", "asdasdasdasdasd");
                    //points.add();
                    //polylineOptions.addAll(mlocListener.points);
                    //mMap.addPolyline(polylineOptions);
                }
            },0,5000);
        } else if (v == GrabarRuta && grabando == true) {
            v.setBackgroundResource(R.drawable.rec);
            grabando = false;
            v.clearAnimation();
            t.cancel();

        } else {
            v.setBackgroundResource(R.drawable.rec);
            grabando = false;
            v.clearAnimation();
            t.cancel();
        }
    }

    public void onClickMostrarButton(View v) {
        bus1 = new ArrayList<LatLng>();
        mMap.animateCamera(CameraUpdateFactory.newLatLng(casa));
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
        mMap.addMarker(new MarkerOptions().position(bus1.iterator().next())
                .title("home")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addPolyline(polylineOptions);

    }

    public void setLocation(Location location){
        if (location.getLatitude() != 0.0 && location.getLongitude() != 0.0){
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                if (!list.isEmpty()){
                    Address address = list.get(0);
//                    messageTextView2.setText("Mi dirección es: \n" + address.getAddressLine(0));
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /* Class My Location Listener */
    public class MyLocationListener implements LocationListener {
        MapsActivity mapsActivity;
        List<LatLng> points = new ArrayList<LatLng>();
        LatLng coordinate;


        public MapsActivity getMapsActivity() {
            return mapsActivity;
        }

        public void setMapsActivity(MapsActivity mapsActivity) {
            this.mapsActivity = mapsActivity;
        }

        public List<LatLng> getPoints(){
            return points;
        }

        public void setPoints(List<LatLng> points){
            this.points = points;
        }
        @Override
        public void onLocationChanged(Location loc) {
            // Este mŽtodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
            // debido a la detecci—n de un cambio de ubicacion

            DecimalFormat dFormat = new DecimalFormat("#.####");

            lat1 = loc.getLatitude();
            lng1 = loc.getLongitude();
            String Text = "Mi ubicación actual es: " + "\n Lat = " + lat1 + "\n Long = " + lng1;
            coordinate = new LatLng(lat1, lng1);
            lat1 = Double.valueOf(dFormat.format(lat1));
            lng1 = Double.valueOf(dFormat.format(lng1));
            if (lat1 != lat2 || lng1 != lng2){
                points.add(coordinate);
                Text = "Mi ubicación actual es: " + "\n Lat = " + lat1 + "\n Long = " + lng1;
                Log.d("PRUEBA", "puntos (LatLng): " + coordinate.latitude + " - " + coordinate.longitude);
                lat2 = lat1;
                lng2 = lng1;
            }
//
//            t2.scheduleAtFixedRate(new TimerTask() {
//                @Override
//                public void run() {
//                    Log.d("PRUEBA", "puntos (LatLng): " + coordinate.latitude + " - " + coordinate.longitude);
//                    points.add(coordinate);
//                }
//            }, 0, 5000);
            //points.add(coordinate);
            messageTextView.setText(Text);
            //this.mapsActivity.setLocation(loc);
        }

        @Override
        public void onProviderDisabled(String provider) {
            messageTextView.setText("GPS Desactivado");
        }

        @Override
        public void onProviderEnabled(String provider) {
            messageTextView.setText("GPS Activado");
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // Este mŽtodo se ejecuta cada vez que se detecta un cambio en el
            // status del proveedor de localizaci—n (GPS)
            // Los diferentes Status son:
            // OUT_OF_SERVICE -> Si el proveedor esta fuera de servicio
            // TEMPORARILY_UNAVAILABLE -> Temp˜ralmente no disponible pero se
            // espera que este disponible en breve
            // AVAILABLE -> Disponible
        }

    }/* End of Class MyLocationListener */

}
