package com.example.maternity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;

public class CreateBabysitterAccountActivity extends AppCompatActivity {
    EditText username, dob, aadhar, phone, email, address, rph;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_babysitter_account);
        btnNext = findViewById(R.id.button_babysitter_next);
        username = findViewById(R.id.babysitter_username);
        dob = findViewById(R.id.babysitter_dob);
        aadhar = findViewById(R.id.babysitter_aadhar);
        phone = findViewById(R.id.babysitter_phone);
        email = findViewById(R.id.babysitter_email);
        address = findViewById(R.id.babysitter_address);
        rph = findViewById(R.id.babysitter_rate_per_hour);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username2, dob2, aadhar2, phone2, email2, address2, rph2;
                username2 = String.valueOf(username.getText());
                dob2 = String.valueOf(dob.getText());
                aadhar2 = String.valueOf(aadhar.getText());
                phone2 = String.valueOf(phone.getText());
                email2 = String.valueOf(email.getText());
                address2 = String.valueOf(address.getText());
                rph2 = String.valueOf(rph.getText());

                if (username2.isEmpty() || dob2.isEmpty() || phone2.isEmpty() || aadhar2.isEmpty() || email2.isEmpty() || address2.isEmpty() || rph2.isEmpty())
                {
                    Toast.makeText(CreateBabysitterAccountActivity.this, "All entries MUST NOT be empty.", Toast.LENGTH_SHORT).show();
                }else{
                    if(!isValidEmailId(email2.trim()))
                    {
                        Toast.makeText(CreateBabysitterAccountActivity.this, "Email not correct", Toast.LENGTH_SHORT).show();
                    }else if(!isValidMobile(phone2))
                    {
                        Toast.makeText(CreateBabysitterAccountActivity.this, "Phone number not correct", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Intent i = new Intent(CreateBabysitterAccountActivity.this, CreateBabySitterAccount2.class);
                        i.putExtra("username", username2);
                        i.putExtra("dob", dob2);
                        i.putExtra("aadhar", aadhar2);
                        i.putExtra("phone", phone2);
                        i.putExtra("email", email2);
                        i.putExtra("address", address2);
                        i.putExtra("rph", rph2);
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

