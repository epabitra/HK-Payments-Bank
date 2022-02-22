package com.example.hkbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private boolean viewCall = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout constraintLO = findViewById(R.id.constraintLO);

        constraintLO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
                viewCall = true;
            }
        });

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(viewCall == false) {
                    Intent Intent = new Intent(MainActivity.this, Login.class);
                    startActivity(Intent);
                    finish();
                }
            }
        }, 3000);

        /** This method also Work but above is easy
                                  to understand...

        Thread th = new Thread(){
            public void run(){
                try{
                    sleep(4000);
                }catch(Exception ex){
                    Toast.makeText(MainActivity.this, "Tap to continue...", Toast.LENGTH_SHORT).show();
                }finally{
                    if (viewcall==false) {
                        Intent Intent = new Intent(MainActivity1.this, MainActivity2.class);
                        startActivity(Intent);
                    }
                }
            }
        };th.start();*/

    }
    public void nextActivity(){
        Intent Intent = new Intent(this, Login.class);
        startActivity(Intent);
    }
}