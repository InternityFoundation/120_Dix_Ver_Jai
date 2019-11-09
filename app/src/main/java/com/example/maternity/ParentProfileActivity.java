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
    String username, email, availabity, genderOfBaby, permanentAddress, zipCode, rateHR, description, profilePic;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_profile);

        firebaseDatabase = FirebaseDatabase.getInstance();
        dbref = firebaseDatabase.getReference("USERS").child("PARENT").child("+919521420343");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ParentDetails  parentDetails = dataSnapshot.getValue(ParentDetails.class);
                username = parentDetails.getUsername();
                email = parentDetails.getEmail();
                genderOfBaby = parentDetails.getGenderOfBaby();
                availabity = parentDetails.getAvailablity();
                permanentAddress = parentDetails.getPermanentAddress();
                zipCode = parentDetails.getZipcode();
                rateHR = parentDetails.getRateHr();
                description = parentDetails.getDescription();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ParentProfileActivity.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }
        });




    }
}
