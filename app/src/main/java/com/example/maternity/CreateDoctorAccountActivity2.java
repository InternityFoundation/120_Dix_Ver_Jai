package com.example.maternity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CreateDoctorAccountActivity2 extends AppCompatActivity {
    DoctorDetails doctorDetails;

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
    }
}
