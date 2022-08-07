package com.example.login_app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
//import java.sql.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Registerr extends AppCompatActivity {
    private EditText eEmail;
    private  EditText eName;
    private EditText ePassword;
    private EditText eConfirm;

    private String email;
    private String name;
    private String password;
    private String confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerr);

        eEmail=findViewById(R.id.editTextTextEmailAddress);
        eName=findViewById(R.id.editTextTextName);
        ePassword=findViewById(R.id.editTextTextPassword);
        eConfirm=findViewById(R.id.editTextTextConfirm);

        Button eRegister=findViewById(R.id.signup);

        eRegister.setOnClickListener(view ->{
            String inputEmail=eEmail.getText().toString();
            String inputName=eName.getText().toString();
            String inputPassword=ePassword.getText().toString();
            String inputConfirm=eConfirm.getText().toString();
        });
    }
}