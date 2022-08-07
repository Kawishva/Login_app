package com.example.login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText eEmail;
    private EditText ePassword;

    private String email;
    private String password;

    boolean isValid = false;
    private Button signup;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup=(Button)findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openRegister();
            }
        });

        eEmail = findViewById(R.id.editTextTextEmailAddress);
        ePassword = findViewById(R.id.editTextTextPassword);
        Button eLogin = findViewById(R.id.signup);
        //Button eRegister = findViewById(R.id.register);


        eLogin.setOnClickListener(view -> {
            String inputEmail = eEmail.getText().toString();
            String inputPassword = ePassword.getText().toString();
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
    public void openRegister(){
        Intent intent=new Intent(this,Registerr.class);
        startActivity(intent);
    }

}