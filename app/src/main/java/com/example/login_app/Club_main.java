package com.example.login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Club_main extends AppCompatActivity {

    private Button Photography_btn,Echoclub_btn,Chessclub_btn;
    private Button Dancingclub_btn,TMclub_btn,Eclub_btn,ARclub_btn;
    private Button Bridgeclub_btn,Rowingclub_btn;
    private Button Rotaractclub_btn,Scoutclub_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_main);

      Photography_btn= findViewById(R.id.Photography_btn);
        Photography_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPhotographyclub_interface();
            }
        });

        Echoclub_btn= findViewById(R.id.Echoclub_btn);
        Echoclub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEchoclub_interface();
            }
        });

        Chessclub_btn= findViewById(R.id.Chessclub_btn);
        Chessclub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChessclub_interface();
            }
        });

        Dancingclub_btn= findViewById(R.id.Dancingclub_btn);
        Dancingclub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDancingclub_interface();
            }
        });

        TMclub_btn= findViewById(R.id.TMclub_btn);
        TMclub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTMclub_interface();
            }
        });

        Eclub_btn= findViewById(R.id.Eclub_btn);
        Eclub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEclub_interface();
            }
        });

        ARclub_btn= findViewById(R.id.ARclub_btn);
        ARclub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openARclub_interface();
            }
        });

        Bridgeclub_btn= findViewById(R.id.Bridgeclub_btn);
        Bridgeclub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBridgeclub_interface();
            }
        });

        Rowingclub_btn= findViewById(R.id.Rowingclub_btn);
        Rowingclub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRowingclub_interface();
            }
        });

        Rotaractclub_btn= findViewById(R.id.Rotaractclub_btn);
        Rotaractclub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRotaractclub_interface();
            }
        });

        Scoutclub_btn= findViewById(R.id.Scoutclub_btn);
        Scoutclub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openScoutclub_interface();
            }
        });

    }

    public void openPhotographyclub_interface()
    {
        Intent intent=new Intent(this, Photography_club.class);
        startActivity(intent);
    }

    public void openEchoclub_interface()
    {
        Intent intent=new Intent(this, Echo_club.class);
        startActivity(intent);
    }
    public void openChessclub_interface()
    {
        Intent intent=new Intent(this, Chess_club.class);
        startActivity(intent);
    }
    public void openDancingclub_interface()
    {
        Intent intent=new Intent(this, Dancing_club.class);
        startActivity(intent);
    }
    public void openTMclub_interface()
    {
        Intent intent=new Intent(this, Toastmasters_club.class);
        startActivity(intent);
    }
    public void openEclub_interface()
    {
        Intent intent=new Intent(this, E_club.class);
        startActivity(intent);
    }
    public void openARclub_interface()
    {
        Intent intent=new Intent(this, AR_club.class);
        startActivity(intent);
    }
    public void openBridgeclub_interface()
    {
        Intent intent=new Intent(this, Bridge_club.class);
        startActivity(intent);
    }
    public void openRowingclub_interface()
    {
        Intent intent=new Intent(this, Rowing_club.class);
        startActivity(intent);
    }
    public void openRotaractclub_interface()
    {
        Intent intent=new Intent(this,Rotaract_club.class);
        startActivity(intent);
    }
    public void openScoutclub_interface()
    {
        Intent intent=new Intent(this,Scout_club.class);
        startActivity(intent);
    }
}