package com.example.maternity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateParentAccountActivity extends AppCompatActivity {
    String username, email, phone_no, password, availability, genderOfBaby, permanentAddress, zipCode, rateHR, description, profilePic;
    private EditText USERNAME, EMAIL, PASSWORD, AVAILABILTY, SEX, ADDRESS, ZIPCODE, RATE_HR, DESC, PHONE;
    private Button SUBMIT;
    private ImageView IMG;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private ProgressDialog progressdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_parent_account);

        USERNAME = (EditText)findViewById(R.id.username);
        EMAIL = (EditText)findViewById(R.id.email);
        PASSWORD = (EditText)findViewById(R.id.pass);
        PHONE = (EditText)findViewById(R.id.phone);
        SEX = (EditText)findViewById(R.id.gob);
        AVAILABILTY = (EditText)findViewById(R.id.availibility);
        ADDRESS = (EditText)findViewById(R.id.address);
        ZIPCODE = (EditText)findViewById(R.id.zipcode);
        RATE_HR = (EditText)findViewById(R.id.rate);
        DESC = (EditText)findViewById(R.id.desc);
        IMG = (ImageView)findViewById(R.id.imageView);
        SUBMIT = (Button)findViewById(R.id.submitbtn);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        progressdialog = new ProgressDialog(this);

        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validate()){
                    username = USERNAME.getText().toString().trim();
                    email = EMAIL.getText().toString().trim();
                    password = PASSWORD.getText().toString().trim();
                    phone_no = PHONE.getText().toString().trim();
                    availability = AVAILABILTY.getText().toString().trim();
                    genderOfBaby = SEX.getText().toString().trim();
                    permanentAddress = ADDRESS.getText().toString().trim();
                    zipCode = ZIPCODE.getText().toString().trim();
                    rateHR =  RATE_HR.getText().toString().trim();
                    description = DESC.getText().toString().trim();
                    progressdialog.setMessage("uploading data");
                    progressdialog.show();
                    sendUserData();
                    progressdialog.dismiss();
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));




                }

            }
        });





    }

    public Boolean validate(){
     Boolean res =false;
     String user = USERNAME.getText().toString().trim();
     String userEmail = EMAIL.getText().toString().trim();
     String pass = PASSWORD.getText().toString().trim();
     String phone = PHONE.getText().toString().trim();
     String gender = SEX.getText().toString().trim();
     String avail = AVAILABILTY.getText().toString().trim();
     String address = ADDRESS.getText().toString().trim();
     String zip = ZIPCODE.getText().toString().trim();
     String rate = RATE_HR.getText().toString().trim();
     String desc = DESC.getText().toString().trim();

     if(user.isEmpty() || userEmail.isEmpty() || phone.isEmpty() || gender.isEmpty() || avail.isEmpty() || address.isEmpty() || zip.isEmpty() || rate.isEmpty() || desc.isEmpty()){
         Toast.makeText(CreateParentAccountActivity.this, "Enter all details", Toast.LENGTH_SHORT).show();
     }
     else{
         res = true;
     }
     return res;
    }

    public void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference myref = firebaseDatabase.getReference("USERS").child("PARENT").child(phone_no);

        myref.setValue(new ParentDetails(username,email,phone_no, availability,genderOfBaby,permanentAddress,zipCode,rateHR,description,profilePic,password ));



    }
}
