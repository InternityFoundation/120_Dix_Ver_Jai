package com.example.maternity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class OTPVerificationActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    EditText otp;
    String codesent;
    Button verify;

    String userLogging, phone;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);
        otp = findViewById(R.id.otp);
        mAuth=FirebaseAuth.getInstance();
        verify =findViewById(R.id.verify);
        userLogging= getIntent().getStringExtra("user");
        phone = getIntent().getStringExtra("phone");
        getVerified();

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifysignincode();
            }
        });
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential)
    {

        mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (task.isSuccessful())
                {

                    Log.d("TAG", "onComplete: ");
                    if (userLogging.equals("PARENT"))
                    {
                        Intent i = new Intent(OTPVerificationActivity.this, ParentHomeActivity.class);
                        i.putExtra("user", userLogging);
                        i.putExtra("phone", phone);
                        startActivity(i);
                    }else if (userLogging.equals("DOCTOR"))
                    {
                        Intent i = new Intent(OTPVerificationActivity.this, DoctorHomeActivity.class);
                        i.putExtra("user", userLogging);
                        i.putExtra("phone", phone);
                        startActivity(i);
                    }else  if (userLogging.equals("BABYSITTER"))
                    {
                        Intent i = new Intent(OTPVerificationActivity.this, BabysitterHomeActivity.class);
                        i.putExtra("user", userLogging);
                        i.putExtra("phone", phone);
                        startActivity(i);
                    }


                }
                else
                {
                    if (task.getException() instanceof FirebaseAuthInvalidCredentialsException)
                    {
                        Toast.makeText(OTPVerificationActivity.this, "invalid code.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mcallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            Log.d("tag", "onCodeSent: "+ s);
            codesent=s;
        }
    };
    private void verifysignincode() {
        String code = otp.getText().toString();
        if(code.isEmpty())
        {
            Toast.makeText(this, "enter the verification code to continue.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            try{
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codesent, code);
                signInWithPhoneAuthCredential(credential);
            }catch (Exception e)
            {
                Toast.makeText(this, "failed"+e, Toast.LENGTH_SHORT).show();
            }


        }

    }
    public void getVerified()
    {
        String phonenumber=phone;
        if(phonenumber.isEmpty() || phonenumber.length()<13)
        {
            Toast.makeText(this, "please enter number properly.", Toast.LENGTH_SHORT).show();
        }
        else{
            PhoneAuthProvider.getInstance().verifyPhoneNumber(phonenumber, 60, TimeUnit.SECONDS, this, mcallbacks);
            Toast.makeText(this, "please check your message box and type the verification code below.", Toast.LENGTH_SHORT).show();

        }


    }

}
