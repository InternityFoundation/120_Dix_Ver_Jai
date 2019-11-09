package com.example.maternity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;

public class DoctorHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);
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
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }


        return super.onOptionsItemSelected(item);
    }
}
