package com.example.flavianagavril.cautamlocatia;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup.LayoutParams;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.StreetViewPanoramaView;


public class StreetViewActivity extends AppCompatActivity {

//Define the LatLng value we’ll be using for the paranorma’s initial camera position//

    private static final LatLng Iasi = new LatLng(47.1567393, 27.5873516);
    private StreetViewPanoramaView mStreetViewPanoramaView;
    private static final String STREETVIEW_BUNDLE_KEY = "StreetViewBundleKey";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//Configure the panorama by passing in a StreetViewPanoramaOptions object//

        StreetViewPanoramaOptions options = new StreetViewPanoramaOptions();
        if (savedInstanceState == null) {

//Set the panorama’s location//

            options.position(Iasi);
        }

        mStreetViewPanoramaView = new StreetViewPanoramaView(this, options);
        addContentView(mStreetViewPanoramaView,
                new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        Bundle mStreetViewBundle = null;
        if (savedInstanceState != null) {
            mStreetViewBundle = savedInstanceState.getBundle(STREETVIEW_BUNDLE_KEY);
        }
        mStreetViewPanoramaView.onCreate(mStreetViewBundle);
    }




}