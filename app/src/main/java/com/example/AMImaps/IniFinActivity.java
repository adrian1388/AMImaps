package com.example.AMImaps;

import android.graphics.Color;
import android.location.LocationListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import java.util.List;
import java.util.Random;

public class IniFinActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Long idSubida;
    private Long idBajada;
    private Rutas mRutas = new Rutas();
    PolylineOptions polylineOptions;
    private GoogleMap mMap;
    private List<Rutas.Linea> listaRutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ini_fin);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapa_ini_fin);
        mapFragment.getMapAsync(this);

        idSubida = getIntent().getExtras().getLong("idSubida");
        idBajada = getIntent().getExtras().getLong("idBajada");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mRutas.init();
        LatLng punto;
        Random rnd = new Random();
        listaRutas = mRutas.lineas;
        Rutas.Linea mLinea;
        for (int i = 0; i < listaRutas.size(); i++){
            mLinea = listaRutas.get(i);
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            polylineOptions = new PolylineOptions();
            punto = mLinea.getInicio();
            polylineOptions.color(color);
            polylineOptions.width(8);
            polylineOptions.addAll(mLinea.getRecorrido());
            mMap.addMarker(new MarkerOptions().position(punto)
                    .title("start")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            mMap.addPolyline(polylineOptions);
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(-2.145723, -79.900045)));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12), 2000, null);

        for (int i = 0; i < listaRutas.size(); i++){
            mLinea = listaRutas.get(i);
            final Rutas.Linea finalMLinea = mLinea;
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    boolean isOnRoute = PolyUtil.isLocationOnPath(latLng, finalMLinea.getRecorrido(), true, 20.0);
                    if (isOnRoute) {
                        Toast.makeText(getApplicationContext(), "Línea : " + finalMLinea.getNumero(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

}
