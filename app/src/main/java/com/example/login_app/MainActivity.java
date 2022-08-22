package com.example.login_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText eEmail;
    private EditText ePassword;

    private String email;
    private String password;

    boolean isValid = false;
    private Button registerButton;
    private Button signup;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup=(Button) findViewById(R.id.signup);
        signup.setOnClickListener(this);

        //actually login button
        registerButton=(Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(this);

        eEmail=(EditText)findViewById(R.id.editTextTextEmailAddress);
        ePassword=(EditText)findViewById(R.id.editTextTextPassword);

        mAuth=FirebaseAuth.getInstance();
        //eEmail = findViewById(R.id.editTextTextEmailAddress);
        //ePassword = findViewById(R.id.editTextTextPassword);
        //Button eLogin = findViewById(R.id.registerButton);


        /*eLogin.setOnClickListener(view -> {
            String inputEmail = eEmail.getText().toString().trim();
            String inputPassword = ePassword.getText().toString().trim();
           /* if(inputEmail.isEmpty()){
                eEmail.setError("Email is required!");
                eEmail.requestFocus();
                return;
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                eEmail.setError("Please enter a valid email!");
                eEmail.requestFocus();
                return;
            }
            if(inputEmail.isEmpty()){
                eEmail.setError("Email is required!");
                eEmail.requestFocus();
                return;
            }


            if (inputEmail.equals("admin") && inputPassword.equals("admin123")) {
                Toast.makeText(MainActivity.this, "Login was successful", Toast.LENGTH_SHORT).show();

                //Code to direct to home page must be put here!!!
                Intent intent = new Intent(MainActivity.this, HomePage.class);
                startActivity(intent);
            }
            else {
                //Toast.makeText(MainActivity.this,"Please enter Email or Password correctly", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
            }

        });*/

        //ERROR!
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signup:
                startActivity(new Intent(this,Registerr.class));
            break;
            case R.id.registerButton:
                userLogin();
                break;
        }
    }

    private void userLogin() {
        String email= eEmail.getText().toString().trim();
        String password=ePassword.getText().toString().trim();

        if(email.isEmpty()){
            eEmail.setError("Email is required!");
            eEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            eEmail.setError("Please enter a valid email!");
            eEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            eEmail.setError("Password is required!");
            eEmail.requestFocus();
            return;
        }
        if (password.length() < 6) {
            ePassword.setError("Minimum password length should be 6 characters");
            ePassword.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(MainActivity.this,HomePage.class));
                }
                else{
                    Toast.makeText(MainActivity.this,"Failed to login!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}