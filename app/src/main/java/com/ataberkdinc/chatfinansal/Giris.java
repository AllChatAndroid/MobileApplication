package com.ataberkdinc.chatfinansal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Giris extends AppCompatActivity {

    Button buton_giris;
    Button buton_cikis;
    Button buton_hakkimizda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        buton_giris = (Button)findViewById(R.id.button3);
        buton_cikis = (Button)findViewById(R.id.button5);
        buton_hakkimizda = (Button)findViewById(R.id.button4) ;


        buton_giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        buton_hakkimizda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(),Hakkimizda.class);
                startActivity(intent);
            };

        });

        buton_cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


    }
}
