package com.example.maternity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class CreateParentAccountActivity extends AppCompatActivity {
    String username, email, availabity, prefferedDays, genderOfBaby, permanentAddress, zipCode, rateHR, description, profilePicture;
    private EditText USERNAME, EMAIL, AVAILABILTY, PREFFERED_DAYS, SEX, ADDRESS, ZIPCODE, RATE_HR, DESC;
    private Button SUBMIT;
    private ImageView IMG;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_parent_account);

        USERNAME = (EditText)findViewById(R.id.username);
        EMAIL = (EditText)findViewById(R.id.email);
        SEX = (EditText)findViewById(R.id.gob);
        AVAILABILTY = (EditText)findViewById(R.id.availibility);
        ADDRESS = (EditText)findViewById(R.id.address);
        ZIPCODE = (EditText)findViewById(R.id.zipcode);
        RATE_HR = (EditText)findViewById(R.id.rate);
        IMG = (ImageView)findViewById(R.id.imageView);
        SUBMIT = (Button)findViewById(R.id.submitbtn);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });





    }
}
