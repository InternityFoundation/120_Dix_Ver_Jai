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

public class CreateBabySitterAccount2 extends AppCompatActivity {
    NannyDetails nannyDetails;
    EditText aboutMe, password;
    Button createAccount;
    RadioGroup gender, availability;
    CheckBox checkBoxLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_baby_sitter_account2);
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

        final String[] genderValue = new String[1];
        final String[] availabilityValue = new String[1];
        final String[] lati = new String[1];
        final String[] longi = new String[1];
        lati[0]="";
        longi[0]="";
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
               if(availability_isChecked){
                   availabilityValue[0] = (String.valueOf(checkedRadioButton.getText()));
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
                        AlertDialog.Builder builder = new AlertDialog.Builder(CreateBabySitterAccount2.this);
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
                String aboutMe2, password2, gender2, availability2, locationLati, locationLongi;

                aboutMe2 = String.valueOf(aboutMe.getText());
                password2 = String.valueOf(password.getText());
                gender2 = genderValue[0];
                availability2 = availabilityValue[0];
                locationLati = lati[0];
                locationLongi = longi[0];
                Log.d("TAG", "onClick: "+ aboutMe2+password2+gender2+availability2+locationLati+locationLongi);

                if(aboutMe2.isEmpty()
                        || password2.isEmpty()
                        || gender2.isEmpty()||availability2.isEmpty())
                {
                    Toast.makeText(CreateBabySitterAccount2.this, "FILL ALL FIELDS", Toast.LENGTH_SHORT).show();
                }else {
                    nannyDetails.setAboutMe(aboutMe2);
                    nannyDetails.setPassword(password2);
                    nannyDetails.setGender(gender2);
                    nannyDetails.setLongitude(locationLongi);
                    nannyDetails.setLatitude(locationLati);
                    nannyDetails.setAvailablity(availability2);
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("USERS").child("NANNY").child(nannyDetails.getPhone());
                    databaseReference.setValue(nannyDetails);
                    Toast.makeText(CreateBabySitterAccount2.this, ""+nannyDetails, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
