package com.prodevsmx.monti;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.prodevsmx.monti.fragments.FragmentProfile;
import com.prodevsmx.monti.fragments.FragmentPublish;
import com.prodevsmx.monti.fragments.FragmentRequests;
import com.prodevsmx.monti.fragments.FragmentRides;
import com.prodevsmx.monti.fragments.FragmentSearch;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ActivityMain extends AppCompatActivity {

    BottomNavigationView navigationBar;
    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUIElements();

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.prodevsmx.monti",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }

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
