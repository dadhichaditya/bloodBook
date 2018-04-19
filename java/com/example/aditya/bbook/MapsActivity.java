package com.example.aditya.bbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;SeekActivity seek_instance;
//    Button mseekbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Button mseekbtn = (Button) findViewById(R.id.seekbtn);
        mseekbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent seekintent = new Intent(MapsActivity.this,SeekActivity.class);
            startActivity(seekintent);

            }
        });
    }


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
       googleMap.getUiSettings().setMapToolbarEnabled(true);

        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
       


        // Add a marker in Sydney and move the camera

        LatLng chandigarh= new LatLng(30.7333, 76.7794);
        mMap.addMarker(new MarkerOptions().position(chandigarh).title("Marker in chandigarh"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(chandigarh));


    }
}
