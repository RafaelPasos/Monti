package com.prodevsmx.monti;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class ActivityMain extends AppCompatActivity {

    BottomNavigationView navigationBar;
    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUIElements();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_toolbar, menu);
        return true;
    }


    public void initializeUIElements(){
        navigationBar = findViewById(R.id.bottomNavView);
        fragmentManager = getSupportFragmentManager();
        addBottomNavigationListener();
        navigationBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager = getSupportFragmentManager();
    }


    public void addBottomNavigationListener(){
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navRides:
                        Log.d("Fragment", "Rides");
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        android.support.v4.app.Fragment fragment = new FragmentRides();
                        //fragment.setEnterTransition(new Slide(Gravity.RIGHT));
                        //fragment.setExitTransition(new Slide(Gravity.LEFT));
                        fragment.setEnterTransition(new Fade(1));
                        fragment.setExitTransition(new Fade(2));
                        transaction.replace(R.id.fragmentMain, fragment);
                        transaction.addToBackStack(null).commit();
                        return true;
                    case R.id.navSearch:
                        //TODO: GO TO REQUESTS PAGE
                        Log.d("Fragment", "Search");
                        transaction = fragmentManager.beginTransaction();
                        fragment = new FragmentSearch();
                        //fragment.setEnterTransition(new Slide(Gravity.RIGHT));
                        //fragment.setExitTransition(new Slide(Gravity.LEFT));
                        fragment.setEnterTransition(new Fade(1));
                        fragment.setExitTransition(new Fade(2));
                        transaction.replace(R.id.fragmentMain, fragment);
                        transaction.addToBackStack(null).commit();
                        return true;
                    case R.id.navPublish:
                        Log.d("Fragment", "Publish");
                        transaction = fragmentManager.beginTransaction();
                        fragment = new FragmentPublish();
                        //fragment.setEnterTransition(new Slide(Gravity.RIGHT));
                        //fragment.setExitTransition(new Slide(Gravity.LEFT));
                        fragment.setEnterTransition(new Fade(1));
                        fragment.setExitTransition(new Fade(2));
                        transaction.replace(R.id.fragmentMain, fragment);
                        transaction.addToBackStack(null).commit();
                        return true;
                }
                return false;
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.navProfile) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            android.support.v4.app.Fragment fragment = new FragmentProfile();
            //fragment.setEnterTransition(new Slide(Gravity.RIGHT));
            //fragment.setExitTransition(new Slide(Gravity.LEFT));
            fragment.setEnterTransition(new Fade(1));
            fragment.setExitTransition(new Fade(2));
            transaction.replace(R.id.fragmentMain, fragment, "lol");
            transaction.addToBackStack(null).commit();
            return true;
        }
        if (id == R.id.navRequests) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            android.support.v4.app.Fragment fragment = new FragmentRequests();
            //fragment.setEnterTransition(new Slide(Gravity.RIGHT));
            //fragment.setExitTransition(new Slide(Gravity.LEFT));
            fragment.setEnterTransition(new Fade(1));
            fragment.setExitTransition(new Fade(2));
            transaction.replace(R.id.fragmentMain, fragment, "lol");
            transaction.addToBackStack(null).commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
