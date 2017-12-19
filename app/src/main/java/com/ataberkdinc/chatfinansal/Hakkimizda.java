package com.ataberkdinc.chatfinansal;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Hakkimizda extends AppCompatActivity {

TextView textview;
ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hakkimizda);

        TextView tv = (TextView)findViewById(R.id.tv);
        SpannableString content = new SpannableString("Hakkimizda");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        tv.setText(content);

        ImageView imageview = (ImageView)findViewById(R.id.imageView6);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(),Giris.class);
                startActivity(intent);
            }
        });





    }
}
