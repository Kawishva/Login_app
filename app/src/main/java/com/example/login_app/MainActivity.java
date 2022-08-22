package com.example.login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText eEmail;
    private EditText ePassword;

    private String email;
    private String password;

    boolean isValid = false;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup=(Button) findViewById(R.id.signup);
        signup.setOnClickListener(this);

        eEmail = findViewById(R.id.editTextTextEmailAddress);
        ePassword = findViewById(R.id.editTextTextPassword);
        Button eLogin = findViewById(R.id.registerButton);


        eLogin.setOnClickListener(view -> {
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
            }*/


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

        });

        //ERROR!
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signup:
                startActivity(new Intent(this,Registerr.class));
            break;
        }
    }
}