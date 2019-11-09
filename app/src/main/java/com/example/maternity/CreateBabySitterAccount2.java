package com.example.maternity;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CreateBabySitterAccount2 extends AppCompatActivity {
    NannyDetails nannyDetails;
    EditText aboutMe, password;
    Button createAccount;
    RadioGroup gender, availability;
    CheckBox checkBoxLocation;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    private FusedLocationProviderClient mFusedLocationClient;
    private int locationRequestCode = 1000;
    private double wayLatitude = 0.0, wayLongitude = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_baby_sitter_account2);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        nannyDetails = new NannyDetails();
        nannyDetails.setUsername(getIntent().getStringExtra("username"));
        nannyDetails.setAadharNo(getIntent().getStringExtra("aadhar"));
        nannyDetails.setDOB(getIntent().getStringExtra("dob"));
        nannyDetails.setEmail(getIntent().getStringExtra("email"));
        nannyDetails.setPermanentAddress(getIntent().getStringExtra("address"));
        nannyDetails.setPhone(getIntent().getStringExtra("phone"));
        nannyDetails.setRateHr(getIntent().getStringExtra("rph"));



        aboutMe = findViewById(R.id.babySitterAboutme);
        password = findViewById(R.id.babysitter_Password);
        gender = findViewById(R.id.genderRadioButton);
        availability = findViewById(R.id.availabilityRadioButton);
        checkBoxLocation = findViewById(R.id.locationCheck);
        createAccount = findViewById(R.id.babysitter_create_account);

//        try {
//            if (ActivityCompat.checkSelfPermission(this, mPermission)
//                    != PERMISSION_GRANTED) {
//
//                ActivityCompat.requestPermissions(this, new String[]{mPermission},
//                        locationRequestCode);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        final String[] genderValue = new String[1];
        final String[] availabilityValue = new String[1];
        final String[] lati = new String[1];
        final String[] longi = new String[1];
        lati[0] = "";
        longi[0] = "";
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) group.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean gender_isChecked = checkedRadioButton.isChecked();
                boolean availability_isChecked = checkedRadioButton.isChecked();

                // If the radiobutton that has changed in check state is now checked...
                if (gender_isChecked) {
                    // Changes the textview's text to "Checked: example radiobutton text"
                    genderValue[0] = (String.valueOf(checkedRadioButton.getText()));
                }
                if (availability_isChecked) {
                    availabilityValue[0] = (String.valueOf(checkedRadioButton.getText()));
                }
            }
        });


        checkBoxLocation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                            && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(CreateBabySitterAccount2.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                                locationRequestCode);

                    } else {
                        // already permission granted
                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            //locationCheckBox.setChecked(false);
                            return;
                        }
                        mFusedLocationClient.getLastLocation().addOnSuccessListener(CreateBabySitterAccount2.this, new OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location) {
                                if (location != null) {
                                    wayLatitude = location.getLatitude();
                                    wayLongitude = location.getLongitude();
                                    lati[0] = String.valueOf(wayLatitude);
                                    longi[0] = String.valueOf(wayLongitude);
                                    Log.d("TAG",longi[0]+lati[0]);
                                }
                            }
                        });
                    }
                }
                createAccount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String aboutMe2, password2, gender2, availability2, locationLati, locationLongi;

                        aboutMe2 = String.valueOf(aboutMe.getText());
                        password2 = String.valueOf(password.getText());
                        gender2 = genderValue[0];
                        availability2 = availabilityValue[0];
                        locationLati = lati[0];
                        locationLongi = longi[0];
                        Log.d("TAG", "onClick: " + aboutMe2 + password2 + gender2 + availability2 + locationLati + locationLongi);

                        if (aboutMe2.isEmpty()
                                || password2.isEmpty()
                                || gender2.isEmpty() || availability2.isEmpty()) {
                            Toast.makeText(CreateBabySitterAccount2.this, "FILL ALL FIELDS", Toast.LENGTH_SHORT).show();
                        } else {
                            nannyDetails.setAboutMe(aboutMe2);
                            nannyDetails.setPassword(password2);
                            nannyDetails.setGender(gender2);
                            nannyDetails.setLongitude(locationLongi);
                            nannyDetails.setLatitude(locationLati);
                            nannyDetails.setAvailablity(availability2);
                            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("USERS").child("NANNY").child(nannyDetails.getPhone());
                            databaseReference.setValue(nannyDetails);
                            Toast.makeText(CreateBabySitterAccount2.this, "" + nannyDetails, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }


        });



            }
}