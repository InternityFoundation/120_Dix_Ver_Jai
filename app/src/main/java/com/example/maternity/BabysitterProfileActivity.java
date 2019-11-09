package com.example.maternity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BabysitterProfileActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbref;
    String username, email, dob, aadhar, Address, rateHR, phone, aboutME, profilePic,availabity, gender, latitude, longitude;
    private TextView USER, EMAIL, AADHAR, ADDRESS, RATE, PHONE, DOB, ABOUT_ME, GENDER, AVAILABILITY, LOCATION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_babysitter_profile);

        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


            USER = (TextView)findViewById(R.id.bbysittername);
            EMAIL = (TextView)findViewById(R.id.bbysitteremail);
            PHONE =  (TextView)findViewById(R.id.bbysitterphone);
            AADHAR = (TextView)findViewById(R.id.bbysitteraadhar);
            ADDRESS = (TextView)findViewById(R.id.bbysitteraddress);
            DOB = (TextView)findViewById(R.id.bbysitterdob);
            RATE = (TextView)findViewById(R.id.bbysitterrate);
            ABOUT_ME = (TextView)findViewById(R.id.aboutme);
            GENDER = (TextView)findViewById(R.id.bbysittegender);
            AVAILABILITY = (TextView)findViewById(R.id.bbysitteravail);
            LOCATION = (TextView)findViewById(R.id.bbysitterlocation);


            firebaseDatabase = FirebaseDatabase.getInstance();
            dbref = firebaseDatabase.getReference("USERS").child("NANNY");
            dbref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        assert firebaseUser != null;
                        if (dataSnapshot1.getKey().equals(firebaseUser.getPhoneNumber()))
                        {
                            NannyDetails  nannyDetails = dataSnapshot1.getValue(NannyDetails.class);
                            username = nannyDetails.getUsername();
                            email = nannyDetails.getEmail();
                            phone = nannyDetails.getPhone();
                            aadhar = nannyDetails.getAadharNo();
                            dob = nannyDetails.getDOB();
                            Address = nannyDetails.getPermanentAddress();
                            rateHR = nannyDetails.getRateHr();
                            aboutME = nannyDetails.getAboutMe();
                            availabity = nannyDetails.getAvailablity();
                            gender = nannyDetails.getGender();
                            latitude = nannyDetails.getLatitude();
                            longitude = nannyDetails.getLongitude();
                        }
                    }






                    USER.setText("Username: " + username);
                    EMAIL.setText("Email: " + email);
                    PHONE.setText("Phone: " + phone);
                    AVAILABILITY.setText("Availability: " + availabity);
                    DOB.setText("Dob: " + dob);
                    ADDRESS.setText("Address: " + Address);
                    LOCATION.setText("Latitude, Longitude: " + latitude+ "," + longitude);
                    RATE.setText("Rate/hr: " + rateHR);
                    ABOUT_ME.setText("About me: " + aboutME);
                    AADHAR.setText("Aadhar number: " + aadhar);
                    GENDER.setText("gender: " + gender);



                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(BabysitterProfileActivity.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

                }
            });




        }

    }
