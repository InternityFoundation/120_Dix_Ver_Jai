package com.example.maternity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateDoctorAccountActivity2 extends AppCompatActivity {
    DoctorDetails doctorDetails;
    EditText aboutMe, password;
    Button createAccount;
    RadioGroup gender;
    CheckBox checkBoxLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_doctor_account2);
        doctorDetails = new DoctorDetails();
        doctorDetails.setUsername(getIntent().getStringExtra("username"));
        doctorDetails.setEmail(getIntent().getStringExtra("email"));
        doctorDetails.setExperience(getIntent().getStringExtra("experience"));
        doctorDetails.setPermanentAddress(getIntent().getStringExtra("permanentAddress"));
        doctorDetails.setPhone(getIntent().getStringExtra("phone"));
        doctorDetails.setRegistrationNumber(getIntent().getStringExtra("regno"));

        aboutMe = findViewById(R.id.userAboutme);
        password = findViewById(R.id.userPassword);
        gender = findViewById(R.id.genderRadioButton);
        checkBoxLocation = findViewById(R.id.locationCheck);
        createAccount = findViewById(R.id.createAccount);

        final String[] genderValue = new String[1];
        final String[] lati = new String[1];
        final String[] longi = new String[1];
        lati[0]="";
        longi[0]="";
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) group.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked) {
                    // Changes the textview's text to "Checked: example radiobutton text"
                    genderValue[0] = (String.valueOf(checkedRadioButton.getText()));
                }
            }
        });

        checkBoxLocation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
                    if (!lm.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                            !lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                        // Build the alert dialog
                        AlertDialog.Builder builder = new AlertDialog.Builder(CreateDoctorAccountActivity2.this);
                        builder.setTitle("Location Services Not Active");
                        builder.setMessage("Please enable Location Services and GPS");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Show location settings when the user acknowledges the alert dialog
                                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(intent);
                            }
                        });
                        Dialog alertDialog = builder.create();
                        alertDialog.setCanceledOnTouchOutside(false);
                        alertDialog.show();
                    } else {
                        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                        }else{
                            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if(location != null)
                            {
                                double longitude = location.getLongitude();
                                double latitude = location.getLatitude();
                                lati[0] = String.valueOf(latitude);
                                longi[0] = String.valueOf(longitude);
                            }

                        }

                    }
                }
            }
        });


        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aboutMe2, password2, gender2, locationLati, locationLongi;

                aboutMe2 = String.valueOf(aboutMe.getText());
                password2 = String.valueOf(password.getText());
                gender2 = genderValue[0];
                locationLati = lati[0];
                locationLongi = longi[0];
                Log.d("TAG", "onClick: "+ aboutMe2+password2+gender2+locationLati+locationLongi);

                if(aboutMe2.isEmpty()
                        || password2.isEmpty()
                        || gender2.isEmpty())
                {
                    Toast.makeText(CreateDoctorAccountActivity2.this, "FILL ALL FIELDS", Toast.LENGTH_SHORT).show();
                }else {
                    doctorDetails.setAboutMe(aboutMe2);
                    doctorDetails.setPassword(password2);
                    doctorDetails.setGender(gender2);
                    doctorDetails.setLongitude(locationLongi);
                    doctorDetails.setLatitude(locationLati);
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("USERS").child("DOCTOR").child(doctorDetails.getPhone());
                    databaseReference.setValue(doctorDetails);
                }
            }
        });
    }
}
