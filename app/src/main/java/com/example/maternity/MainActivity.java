package com.example.maternity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;

import com.example.maternity.Fragments.BabySitterFragment;
import com.example.maternity.Fragments.DoctorFragment;
import com.example.maternity.Fragments.FeaturedFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = getSupportActionBar();
        loadFragment(new BabySitterFragment());

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation_bar_main);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.babysitter:
                    toolbar.setTitle("Babysitters nearby");
                    fragment = new BabySitterFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.doctor:
                    toolbar.setTitle("doctor nearby");
                    fragment = new DoctorFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.featured:
                    toolbar.setTitle("Featured");
                    fragment = new FeaturedFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {

            PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("USER", "").apply();
            PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("PHONE", "").apply();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }


        return super.onOptionsItemSelected(item);
    }

}
