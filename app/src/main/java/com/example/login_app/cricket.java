package com.example.login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cricket extends AppCompatActivity {

    private Button upcoming,join;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket);

        upcoming=(Button)findViewById(R.id.upcoming_act);
        upcoming.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openUpcoming();
            }

        });
        join=(Button)findViewById(R.id.joinbtn);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJoin();
            }
        });
    }
    private void openUpcoming() {
        Intent intent=new Intent(this,upcoming_cricket.class);
        startActivity(intent);
    }
    private void openJoin(){
        Intent intent=new Intent(this,join_cricket.class);
        startActivity(intent);
    }

}