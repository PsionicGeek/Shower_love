package com.ART.shower_love;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneNumber extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {
    public boolean isphoneverified = false;
    String[] users = { "Electronics", "Food","Cloths","Books","furniture" };
    String[] gender = {"Male" , "Female", "Other"};


    private EditText mCountrycode;
    private EditText mPhoneNumber;

    private Button mGeneratbtn;
    private ProgressBar mLoginProgress;

    private FirebaseUser mCurrentUser;
    private  FirebaseAuth mAuth;

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks McallBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phoneactivity);

        mCountrycode = findViewById(R.id.country_code_et);
        mPhoneNumber = findViewById(R.id.Mobile_Number_et);
        mGeneratbtn = findViewById(R.id.button_generate_otp);
        mLoginProgress = findViewById(R.id.generate_progress_bar);

        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();


        mGeneratbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String country_code = mCountrycode.getText().toString();
                String phone_number = mPhoneNumber.getText().toString();

                String complete_phone_number = "+"+country_code + phone_number;

                if (country_code.isEmpty() || phone_number.isEmpty() ){
                    Toast.makeText(getApplicationContext(),"Please Fill",Toast.LENGTH_LONG).show();
                }else {
                    mLoginProgress.setVisibility(View.VISIBLE);

                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            complete_phone_number,
                            60,
                            TimeUnit.SECONDS,
                            PhoneNumber.this,
                            McallBack
                    );
                }
            }
        });
        Spinner gen = findViewById(R.id.spinner2);
        ArrayAdapter<String> genderadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,gender);
        genderadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gen.setAdapter(genderadapter);
        gen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Selected User: "+users[position] , Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spin =  findViewById(R.id.spinnercondition);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
        McallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredentials(phoneAuthCredential);
            }



            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {

                Toast.makeText(getApplicationContext(),"verification Failed" + e.getMessage(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);

                Intent otpIntent = new Intent(PhoneNumber.this,OTPverifyActivity.class);
                otpIntent.putExtra("AuthCredentials",s);
                startActivity(otpIntent);

            }
        };



    }

    private void signInWithPhoneAuthCredentials(PhoneAuthCredential credential){
        mAuth.getCurrentUser().linkWithCredential(credential)
                .addOnCompleteListener(PhoneNumber.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            sendUserhome();
                             isphoneverified = true;
                        }else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException){
                                Toast.makeText(getApplicationContext(),"error In verifying OTP",Toast.LENGTH_LONG).show();
                            }
                        }
                        mLoginProgress.setVisibility(View.VISIBLE);
                    }
                });
    }

    private void sendUserhome(){
        Intent homeIntent = new Intent(PhoneNumber.this,MainActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(homeIntent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mCurrentUser != null && isphoneverified ){
            sendUserhome();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
        Toast.makeText(getApplicationContext(), "Selected User: "+users[i] , Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO - Custom Code

    }
}