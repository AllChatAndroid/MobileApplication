package com.ataberkdinc.chatfinansal;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class AcilisEkrani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(AcilisEkrani.this)
                .withFullScreen()
                .withTargetActivity(Giris.class)
                .withSplashTimeOut(4000)
                .withBackgroundColor(Color.parseColor("#4F4F4F"))
                .withLogo(R.drawable.chat)
                .withAfterLogoText("All Chat");


        config.getAfterLogoTextView().setTextColor(Color.WHITE);

        View view = config.create();
        setContentView(view);
    }
}
