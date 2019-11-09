package com.example.maternity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ParentProfileActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbref;
    String username, email, availabity, genderOfBaby, permanentAddress, zipCode, rateHR, phone, description, profilePic;
    private TextView USER, EMAIL, AVAILABILITY, GOB, ADDRESS, ZIP, RATE, DESC,PHONE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_profile);

        USER = (TextView)findViewById(R.id.tvuser);
        EMAIL = (TextView)findViewById(R.id.tvemail);
        PHONE =  (TextView)findViewById(R.id.doc_phone);
        AVAILABILITY = (TextView)findViewById(R.id.doc_permanent_address);
        GOB = (TextView)findViewById(R.id.tvgob);
        ADDRESS = (TextView)findViewById(R.id.tvaddress);
        ZIP = (TextView)findViewById(R.id.doc_zip);
        RATE = (TextView)findViewById(R.id.tvrate);
        DESC = (TextView)findViewById(R.id.tvdesc);

        firebaseDatabase = FirebaseDatabase.getInstance();
        dbref = firebaseDatabase.getReference("USERS").child("PARENT").child("8126099087");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ParentDetails  parentDetails = dataSnapshot.getValue(ParentDetails.class);
                username = parentDetails.getUsername();
                email = parentDetails.getEmail();
                phone = parentDetails.getPhone();
                genderOfBaby = parentDetails.getGenderOfBaby();
                availabity = parentDetails.getAvailablity();
                permanentAddress = parentDetails.getPermanentAddress();
                zipCode = parentDetails.getZipcode();
                rateHR = parentDetails.getRateHr();
                description = parentDetails.getDescription();

                USER.setText("Username: " + username);
                EMAIL.setText("Email: " + email);
                PHONE.setText("Phone: " + phone);
                AVAILABILITY.setText("Availability: " + availabity);
                GOB.setText("Gender(Baby): " + genderOfBaby);
                ADDRESS.setText("Address: " + permanentAddress);
                ZIP.setText("Zipcode: " + zipCode);
                RATE.setText("Rate/hr: " + rateHR);
                DESC.setText("Description/requirements: " + description);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ParentProfileActivity.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }
        });




    }
}
