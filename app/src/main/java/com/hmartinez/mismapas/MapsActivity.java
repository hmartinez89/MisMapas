package com.hmartinez.mismapas;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private Lugar lugar;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Intent i = getIntent();
        lugar = (Lugar)i.getSerializableExtra(getString(R.string.extra_intent_mainActivity));

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng puntoMapa = new LatLng(lugar.getLatitud(),lugar.getLongitud());

        Marker puntero =  mMap.addMarker(new MarkerOptions()
                .position(puntoMapa)
                .title("Marker in:" + lugar.getNombre()));

        CameraPosition cp = new CameraPosition.Builder()
                            .target(puntoMapa)
                            .zoom(15)
                            .build();

        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cp));

        if(lugar.getNombre().equalsIgnoreCase(getString(R.string.item1_mainActivity))){
            BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.icons8_palace_48);
            puntero.setIcon(icon);
        }
        else if(lugar.getNombre().equalsIgnoreCase(getString(R.string.item2_mainActivity))){
            BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.icons8_stadium_48);
            puntero.setIcon(icon);
        }
        else if(lugar.getNombre().equalsIgnoreCase(getString(R.string.item3_mainActivity))){
            BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.icons8_soccer_ball_48);
            puntero.setIcon(icon);
        }
        else{
            BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.icons8_stage_48);
            puntero.setIcon(icon);
        }
    }
}