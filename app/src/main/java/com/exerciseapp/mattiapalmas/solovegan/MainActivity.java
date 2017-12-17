package com.exerciseapp.mattiapalmas.solovegan;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ScanFragment.OnFragmentInteractionListener, TravelFragment.OnFragmentInteractionListener, ComponentsFragment.OnFragmentInteractionListener {

    LinearLayout scanLayout, travelLayout, componentsLayout, mainLayout, componentSelectLayout;
    final android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
    DatabaseHelper myDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ScanFragment scanFragment = new ScanFragment();
        fragmentTransaction.replace(R.id.fragment_container, scanFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        initVariables();
        prepareMenuClickable();
        setUpDataBase();
    }

    private void initVariables() {
        scanLayout = findViewById(R.id.scan_clickable_layout);
        travelLayout = findViewById(R.id.travel_clickable_layout);
        componentsLayout = findViewById(R.id.components_clickable_layout);

        componentSelectLayout = findViewById(R.id.component_select_layout);
        mainLayout = findViewById(R.id.main_layout);
        myDataBase = new DatabaseHelper(this);
    }

    private void prepareMenuClickable() {


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

        componentsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ComponentsFragment componentsFragment = new ComponentsFragment();
                fragmentTransaction.replace(R.id.fragment_container, componentsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackPressed() {
        if (componentSelectLayout.getVisibility() == View.VISIBLE){
            mainLayout.setVisibility(View.VISIBLE);
            componentsLayout.setVisibility(View.GONE);
            return;
        }
        super.onBackPressed();
    }

    private void setUpDataBase() {
        Cursor res = myDataBase.getAllData();
        if (res.getCount() == 0) {
            myDataBase.insertData("Aba", "a fabric woven from goat and camel hair", false, true, false, "fabrics");
            myDataBase.insertData("Acrylic", "a synthetic fabric", true, false, false, "fabrics");
            myDataBase.insertData("Aertex", "a trademark for a loosely woven cotton fabric that is used to make shirts and underwear", true, false, false, "fabrics");
            myDataBase.insertData("Acetate (B)", " Vitamin A",false,false, true,"food");
            myDataBase.insertData("Product", "Test product", false, false,true, "product");
            myDataBase.insertData("Fabrics", "Test fabrics", false,true,false,"fabrics");
        }
    }


}
