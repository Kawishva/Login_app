package com.example.login_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Registerr extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener{
    private FirebaseAuth mAuth;
    private EditText eEmail;
    private  EditText eName;
    private EditText ePassword;
    private EditText eConfirm;
    private Button Regbtn;
    private Spinner faculty;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerr);

        mAuth  = FirebaseAuth.getInstance();


        Regbtn = (Button) findViewById(R.id.registerButton);
        Regbtn.setOnClickListener(this);

        eEmail=(EditText) findViewById(R.id.editTextTextEmailAddress);

        eName=(EditText) findViewById(R.id.editTextTextName);

        ePassword=(EditText) findViewById(R.id.editTextTextPassword);

        eConfirm=(EditText) findViewById(R.id.editTextTextConfirm);

        faculty=findViewById(R.id.faculties);
        String[] faculties=getResources().getStringArray(R.array.faculty);
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_spinner_item,faculties);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        faculty.setAdapter(adapter);
    }

    private void registerUser ()
    {
        String password = ePassword.getText().toString().trim();
        String confirm = eConfirm.getText().toString().trim();
        String email = eEmail.getText().toString().trim();
        String name = eName.getText().toString().trim();

        if (email.isEmpty()) {
            eEmail.setError("Email is required");
            eEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            eEmail.setError("Please provide a valid email");
            eEmail.requestFocus();
            return;
        }

        if (name.isEmpty()) {
            eName.setError("Name is required");
            eName.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            ePassword.setError("Password is required");
            ePassword.requestFocus();
            return;
        }
        if (ePassword.length() < 6) {
            ePassword.setError("Minimum password length should be 6 characters");
            ePassword.requestFocus();
            return;
        }
        if (confirm.isEmpty()) {
            eConfirm.setError("Please confirm password");
            eConfirm.requestFocus();
            return;
        }
        if (!password.equals(confirm)){
            eConfirm.setError("Password doesn't match");
            eConfirm.requestFocus();
            return;
        }

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                User user = new User(email, name);
                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(Registerr.this, "User has been registered successfully", Toast.LENGTH_LONG).show();
                                                    startActivity(new Intent(Registerr.this,HomePage.class));

                                                } else {
                                                    Toast.makeText(Registerr.this, "Failed to register! Try again", Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });
                            } else {
                                Toast.makeText(Registerr.this, "Failed to register! Try again", Toast.LENGTH_LONG).show();
                            }
                        }
                    });


    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.registerButton:
                registerUser();

                break;

        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}