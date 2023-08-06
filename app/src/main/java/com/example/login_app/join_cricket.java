package com.example.login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class join_cricket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_cricket);

        EditText nameEdit = (EditText) findViewById(R.id.names);
        String name = nameEdit.getText().toString();

        EditText ageEdit = (EditText) findViewById(R.id.age);
        String age = ageEdit.getText().toString();

        EditText facultyEdit = (EditText) findViewById(R.id.faculty);
        String faculty = facultyEdit.getText().toString();

        EditText degreeEdit = (EditText) findViewById(R.id.degree);
        String degree = degreeEdit.getText().toString();

        EditText dobEdit= (EditText) findViewById(R.id.dob);
        String dob = dobEdit.getText().toString();

        EditText phoneEdit = (EditText) findViewById(R.id.Phone);
        String phone = phoneEdit.getText().toString();

        CheckBox yes = (CheckBox) findViewById(R.id.yes);
        CheckBox no = (CheckBox) findViewById(R.id.no);

        Boolean yesState = yes.isChecked();
        Boolean noState = no.isChecked();


    }
}