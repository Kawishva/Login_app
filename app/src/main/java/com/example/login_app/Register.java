package com.example.login_app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
//import java.sql.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    private EditText eEmail;
    private  EditText eName;
    private EditText ePassword;
    private EditText eConfirm;

    private String email;
    private String name;
    private String password;
    private String confirm;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eEmail=findViewById(R.id.editTextTextEmailAddress);
        eName=findViewById(R.id.editTextTextName);
        ePassword=findViewById(R.id.editTextTextPassword);
        eConfirm=findViewById(R.id.editTextTextConfirm);

        Button eRegister=findViewById(R.id.button);

        /*eRegister.setOnClickListener(view ->{
            String inputEmail=email.getText().toString();
        });*/
    }
}
