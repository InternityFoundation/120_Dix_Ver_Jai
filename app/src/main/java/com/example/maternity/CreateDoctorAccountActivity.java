package com.example.maternity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class CreateDoctorAccountActivity extends AppCompatActivity {
    EditText username, regno, phone, experience, email, permanentAddress, zipcode;

    Button continueBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_doctor_account);
        username = findViewById(R.id.username);
        regno = findViewById(R.id.registrationNumber);
        phone = findViewById(R.id.userPhoneNumber);
        experience = findViewById(R.id.experience);
        email = findViewById(R.id.userEmail);
        permanentAddress = findViewById(R.id.userPermanentAddress);
        zipcode = findViewById(R.id.userZipcode);
        continueBtn = findViewById(R.id.continueProfile);


        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username2, regno2, phone2, experience2, email2, permanentAddress2, zipcode2;
                username2 = String.valueOf(username.getText());
                regno2 = String.valueOf(regno.getText());
                phone2 = String.valueOf(phone.getText());
                experience2 = String.valueOf(experience.getText());
                email2 = String.valueOf(email.getText());
                permanentAddress2 = String.valueOf(permanentAddress.getText());
                zipcode2 = String.valueOf(zipcode.getText());

                if (username2.isEmpty() || regno2.isEmpty() || phone2.isEmpty() || experience2.isEmpty() || email2.isEmpty() || permanentAddress2.isEmpty() || zipcode2.isEmpty())
                {
                    Toast.makeText(CreateDoctorAccountActivity.this, "All entries MUST NOT be empty.", Toast.LENGTH_SHORT).show();
                }else{
                    if(!isValidEmailId(email2.trim()))
                    {
                        Toast.makeText(CreateDoctorAccountActivity.this, "Email not correct", Toast.LENGTH_SHORT).show();
                    }else if(!isValidMobile(phone2))
                    {
                        Toast.makeText(CreateDoctorAccountActivity.this, "Phone number not correct", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Intent i = new Intent(CreateDoctorAccountActivity.this, CreateDoctorAccountActivity2.class);
                        i.putExtra("username", username2);
                        i.putExtra("phone", phone2);
                        i.putExtra("experience", experience2);
                        i.putExtra("regno", regno2);
                        i.putExtra("email", email2);
                        i.putExtra("permanentAddress", permanentAddress2);
                        i.putExtra("zipcode", zipcode2);
                        startActivity(i);
                    }
                }
            }
        });




    }
    private boolean isValidEmailId(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }
    private boolean isValidMobile(String phone) {
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }
}
