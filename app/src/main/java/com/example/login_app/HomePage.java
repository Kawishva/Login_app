package com.example.login_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    private Button lms,club_btn,location_btn,sports,profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        lms=findViewById(R.id.lms);
        lms.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                gotoUrl("https://nw.lms.kdu.ac.lk/lms");
            }
        });

        location_btn=(Button)findViewById(R.id.map);
        location_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlocation_interface();
            }
        });

        //ERROR
        club_btn=(Button)findViewById(R.id.clubs);
        club_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClub_main();
            }
        });
    sports=(Button)findViewById(R.id.sports);
    sports.setOnClickListener(new View.OnClickListener(){

        @Override


        public void onClick(View v){
            openSports();
        }
    });
    profile=(Button)findViewById(R.id.profile);
    profile.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openProfile();
        }
    });
    }

    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void openLMS_MainActivity2(){
        Intent intent =new Intent(this,LMS_MainActivity2.class);
        startActivity(intent);
    }

    public void openClub_main()
    {
        Intent intent =new Intent(this,Club_main.class);
        startActivity(intent);
    }
    public void openSports(){
        Intent intent=new Intent(this,Sports.class);
        startActivity(intent);
    }
    public void openlocation_interface()
    {
        Intent intent =new Intent(this,location_int.class);
        startActivity(intent);
    }
    public void openProfile(){
        Intent intent=new Intent(this,profile.class);
        startActivity(intent);
    }
}