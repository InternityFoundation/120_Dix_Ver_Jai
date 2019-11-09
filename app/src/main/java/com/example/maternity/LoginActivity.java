package com.example.maternity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    TextView createAccount;
    RadioGroup radioGroup;
    Button login;
    EditText phone, password;


    AlertDialog.Builder alertDialog;
    private String[] user;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        createAccount = findViewById(R.id.createAccount);

        phone = findViewById(R.id.userPhoneNumber);
        password = findViewById(R.id.userPassword);
        login = findViewById(R.id.loginButton);
        radioGroup = findViewById(R.id.choices);






        alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Create Account as : ");
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("Parent", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getApplicationContext(), CreateParentAccountActivity.class));
            }
        });
        alertDialog.setNegativeButton("Doctor", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getApplicationContext(), CreateDoctorAccountActivity.class));
            }
        });
        alertDialog.setNeutralButton("Babysitter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getApplicationContext(), CreateBabysitterAccountActivity.class));
            }
        });
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) group.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked) {
                    // Changes the textview's text to "Checked: example radiobutton text"
                    user[0] = (String.valueOf(checkedRadioButton.getText().toString().toUpperCase()));
                }
            }
        });
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("USERS");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String id = phone.getText().toString();
                final String pass = password.getText().toString();

                DatabaseReference df = databaseReference.child(user[0]).child(id);
                df.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                        {
                            if (dataSnapshot1.getKey().equals(pass))
                            {
                                Intent i = new Intent(LoginActivity.this, OTPVerificationActivity.class);
                                i.putExtra("phone", id);
                                i.putExtra("user", user[0]);
                                startActivity(i);
                                flag = true;
                            }
                        }
                        if (!flag)
                        {
                            Toast.makeText(LoginActivity.this, "check password", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }
}
