package com.example.maternity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
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

        final String[] user = new String[1];

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
                Log.d("tag", "onClick: "+pass);

                DatabaseReference df = databaseReference.child(user[0]);
                df.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Intent i;
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                        {
                            Log.d("TAG", "onDataChange: "+dataSnapshot1.getKey());

                            if (dataSnapshot1.getKey().equals(id))
                            {
                                //Log.d("TAG", "onDataChange: "+id);
                                if (user[0].equals("NANNY"))
                                {
                                    NannyDetails nannyDetails = dataSnapshot1.getValue(NannyDetails.class);
                                    if (nannyDetails.getPassword().equals(pass))
                                    {
                                        i = new Intent(LoginActivity.this, OTPVerificationActivity.class);
                                        i.putExtra("phone", id);
                                        i.putExtra("user", user[0]);
                                        startActivity(i);
                                        flag = true;
                                        finish();
                                    }
                                }else if (user[0].equals("PARENT"))
                                {
                                    ParentDetails nannyDetails = dataSnapshot1.getValue(ParentDetails.class);
                                    if (nannyDetails.getPassword().equals(pass))
                                    {
                                        i = new Intent(LoginActivity.this, OTPVerificationActivity.class);
                                        i.putExtra("phone", id);
                                        i.putExtra("user", user[0]);
                                        startActivity(i);
                                        flag = true;
                                        finish();
                                    }

                                }else if (user[0].equals("DOCTOR"))
                                {
                                    DoctorDetails nannyDetails = dataSnapshot1.getValue(DoctorDetails.class);
                                    if (nannyDetails.getPassword().equals(pass))
                                    {
                                        i = new Intent(LoginActivity.this, OTPVerificationActivity.class);
                                        i.putExtra("phone", id);
                                        i.putExtra("user", user[0]);
                                        startActivity(i);
                                        flag = true;
                                        finish();
                                    }

                                }



                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                        Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}
