package com.example.hkbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class createAcc extends AppCompatActivity {

    static BankAccount[] accountsArr= new BankAccount[10];
    static int count = 0;

    static String accountHName;
    static String phone;
    static String email;
    static String pin;
    static String balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);

    }

    public void register(View View){

        EditText userNInput = findViewById(R.id.userNInput);
        EditText phoneInput =  findViewById(R.id.phoneVerifyET);
        EditText emailInput =  findViewById(R.id.emailVerifyET);
        EditText balInput = findViewById(R.id.balInput);
        EditText pinVerify = findViewById(R.id.confirmPinET);

        accountHName = userNInput.getText().toString();
        phone = phoneInput.getText().toString();
        email = emailInput.getText().toString();
        pin = pinVerify.getText().toString();
        balance = balInput.getText().toString();
        createAcc(accountHName,phone,email,balance,pin);
        //startActivity(Intent);
    }

    // On Click Listeners..



    // My Won Methods...
    void createAcc(String accountHName,String phone,String email,String balance,String pin){
        accountsArr[count] = addAccDetails(accountHName,phone,email,balance,pin);
        count++;

        TextView accCreatedMsgTV = findViewById(R.id.accCreatedMsgTV);
        accCreatedMsgTV.setVisibility(View.VISIBLE);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent Intent = new Intent(createAcc.this, Login.class);
                startActivity(Intent);
                finish();
            }
        }, 500);

    }

    BankAccount addAccDetails(String accountHName,String phone,String email,String balance,String pin){
        BankAccount tempAcc = new BankAccount();
        tempAcc.setAccountHName(accountHName);
        tempAcc.setPhone(phone);
        tempAcc.setEmail(email);
        tempAcc.setBalance(balance);
        tempAcc.setPin(pin);
        return tempAcc;
    }

    public void logIn(View view){
        Intent Intent = new Intent(this,Login.class);
        startActivity(Intent);
    }

}