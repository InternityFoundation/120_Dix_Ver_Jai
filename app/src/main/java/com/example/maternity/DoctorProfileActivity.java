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

public class DoctorProfileActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbref;
    String username, email, permanentAddress, phone, zip;
    private TextView USER, EMAIL, PHONE, ADDRESS, ZIP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);

        USER = findViewById(R.id.doc_user);
        EMAIL = findViewById(R.id.doc_email);
        ADDRESS = findViewById(R.id.doc_permanent_address);
        PHONE = findViewById(R.id.doc_phone);
        ZIP = findViewById(R.id.doc_zip);

        firebaseDatabase = FirebaseDatabase.getInstance();
        dbref = firebaseDatabase.getReference("USERS").child("PARENT").child("8126099087");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DoctorDetails doctorDetails = dataSnapshot.getValue(DoctorDetails.class);
                username = doctorDetails.getUsername();
                email = doctorDetails.getEmail();
                phone = doctorDetails.getPhone();
                permanentAddress = doctorDetails.getPermanentAddress();
                zip = doctorDetails.getZipcode();


                USER.setText("Username: " + username);
                EMAIL.setText("Email: " + email);
                PHONE.setText("Phone: " + phone);
                ADDRESS.setText("Address: " + permanentAddress);
                ZIP.setText("Zipcode: " + zip);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(DoctorProfileActivity.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
