package com.example.login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    private Button lms,club_btn,location_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        lms=(Button)findViewById(R.id.lms);
        lms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLMS_MainActivity2();
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

    public void openlocation_interface()
    {
        Intent intent =new Intent(this,location_int.class);
        startActivity(intent);
    }

}