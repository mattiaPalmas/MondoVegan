package com.exerciseapp.mattiapalmas.solovegan;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ScanFragment.OnFragmentInteractionListener, TravelFragment.OnFragmentInteractionListener {

    LinearLayout scanLayout, travelLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        prepareMenuClickable();
    }

    private void initVariables() {
        scanLayout = findViewById(R.id.scan_clickable_layout);
        travelLayout = findViewById(R.id.travel_clickable_layout);
    }

    private void prepareMenuClickable() {
        final android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();


        scanLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ScanFragment scanFragment = new ScanFragment();
                fragmentTransaction.replace(R.id.fragment_container, scanFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        travelLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                TravelFragment travelFragment = new TravelFragment();
                fragmentTransaction.replace(R.id.fragment_container, travelFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
