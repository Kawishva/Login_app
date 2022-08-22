package com.example.login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Club_main extends AppCompatActivity implements View.OnClickListener {

    private Button Photography,Echoclub,Chessclub;
    private Button Dancingclub,TMclub,Eclub,ARclub;
    private Button Bridgeclub,Rowingclub;
    private Button Rotaractclub,Scoutclub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_main);

      Photography= (Button)findViewById(R.id.Photography_btn);
      Photography.setOnClickListener(this);

      Echoclub= (Button) findViewById(R.id.Echoclub_btn);
      Echoclub.setOnClickListener(this);

      Chessclub= (Button)findViewById(R.id.Chessclub_btn);
      Chessclub.setOnClickListener(this);

      Dancingclub= (Button)findViewById(R.id.Dancingclub_btn);
      Dancingclub.setOnClickListener(this);

      TMclub= (Button)findViewById(R.id.TMclub_btn);
      TMclub.setOnClickListener(this);

      Eclub= (Button) findViewById(R.id.Eclub_btn);
      Eclub.setOnClickListener(this);

      ARclub= (Button)findViewById(R.id.ARclub_btn);
      ARclub.setOnClickListener(this);

      Bridgeclub= (Button)findViewById(R.id.Bridgeclub_btn);
      Bridgeclub.setOnClickListener(this);

      Rowingclub= (Button)findViewById(R.id.Rowingclub_btn);
      Rowingclub.setOnClickListener(this);

      Rotaractclub= (Button)findViewById(R.id.Rotaractclub_btn);
      Rotaractclub.setOnClickListener(this);

      Scoutclub= (Button)findViewById(R.id.Scoutclub_btn);
      Scoutclub.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Photography_btn:
                startActivity(new Intent(this,Photography_club.class));
                return;
            case R.id.Echoclub_btn:
                startActivity(new Intent(this,Echo_club.class));
                return;
            case R.id.Chessclub_btn:
                startActivity(new Intent(this,Chess_club.class));
                return;
            case R.id.Dancingclub_btn:
                startActivity(new Intent(this,Dancing_club.class));
                return;
            case R.id.TMclub_btn:
                startActivity(new Intent(this,Toastmasters_club.class));
                return;
            case R.id.Eclub_btn:
                startActivity(new Intent(this,E_club.class));
                return;
            case R.id.ARclub_btn:
                startActivity(new Intent(this,AR_club.class));
                return;
            case R.id.Bridgeclub_btn:
                startActivity(new Intent(this,Bridge_club.class));
                return;
            case R.id.Rowingclub_btn:
                startActivity(new Intent(this,Rowing_club.class));
                return;
            case R.id.Rotaractclub_btn:
                startActivity(new Intent(this,Rotaract_club.class));
                return;
            case R.id.Scoutclub_btn:
                startActivity(new Intent(this,Scout_club.class));
                return;
        }
    }
}