package com.ataberkdinc.chatfinansal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private static int SIGN_IN_REQUEST_CODE = 1;
    private FirebaseListAdapter<ChatMesaj> adapter;
    RelativeLayout activity_main;
    FloatingActionButton fab;




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_cikis)
        {
            AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Snackbar.make(activity_main,"Cikis yaptiniz.", Snackbar.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SIGN_IN_REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                Snackbar.make(activity_main,"Basatiyla giris yapildi. Hosgeldiniz!", Snackbar.LENGTH_SHORT).show();
                displayChatMesaj();
            }
            else{
                Snackbar.make(activity_main,"Hatali giris. Lutfen tekrar deneyiniz!", Snackbar.LENGTH_SHORT).show();
                finish();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);



        activity_main = (RelativeLayout)findViewById(R.id.activity_main);
        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText giris = (EditText)findViewById(R.id.giris);
                FirebaseDatabase.getInstance().getReference().push().setValue(new ChatMesaj(giris.getText().toString(),FirebaseAuth
                .getInstance().getCurrentUser().getEmail()));
                giris.setText("");
            }
        });

        if(FirebaseAuth.getInstance().getCurrentUser()==null)
        {
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(),SIGN_IN_REQUEST_CODE);

        }
        else
        {

            Snackbar.make(activity_main, "Hosgeldiniz "+FirebaseAuth.getInstance().getCurrentUser().getEmail(),Snackbar.LENGTH_SHORT).show();

            displayChatMesaj();
        }


    }

    private void displayChatMesaj() {

        ListView listOfMessage = (ListView)findViewById(R.id.mesaj_list);
        adapter = new FirebaseListAdapter<ChatMesaj>(this,ChatMesaj.class,R.layout.list_item,FirebaseDatabase.getInstance().getReference())
        {
            @Override
            protected void populateView(View v, ChatMesaj model, int position) {

                //Get references to the views of list_item.xml
                TextView messageText, messageUser, messageTime;
                messageText = (TextView) v.findViewById(R.id.mesaj_giris);
                messageUser = (TextView) v.findViewById(R.id.mesaj_kullanici);
                messageTime = (TextView) v.findViewById(R.id.mesaj_zaman);

                messageText.setText(model.getMesajYazi());
                messageUser.setText(model.getMesajKullanici());
                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)", model.getMesajZaman()));

            }
        };
        listOfMessage.setAdapter(adapter);
    }


}

