package com.example.hkbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    static BankAccount tempAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        TextView nameDisplay = findViewById(R.id.nameDisplayTV);
        TextView atmNameDisplay = findViewById(R.id.atmNameDisplayTV);
        TextView balanceDisplay = findViewById(R.id.balanceDisplayTV);

        nameDisplay.setText(tempAcc.getAccountHName());
        atmNameDisplay.setText(tempAcc.getAccountHName());
        balanceDisplay.setText(tempAcc.getBalance());
    }

    public void deposit(View view){
        Deposit.tempAcc = tempAcc;
        Deposit.count = 1;
        Intent Intent = new Intent(this,Deposit.class);
        startActivity(Intent);
    }

    public void withdraw(View view){
        Deposit.tempAcc = tempAcc;
        Deposit.count = 0;
        Intent Intent = new Intent(this,Deposit.class);
        startActivity(Intent);
    }

    public void accDetails(View view){
        AccDetails.tempAcc = tempAcc;
        Intent Intent = new Intent(this,AccDetails.class);
        startActivity(Intent);
    }

    public void logOut(View view){
        Intent Intent = new Intent(this,Login.class);
        startActivity(Intent);
    }
}