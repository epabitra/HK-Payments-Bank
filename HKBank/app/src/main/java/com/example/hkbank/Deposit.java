package com.example.hkbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Deposit extends AppCompatActivity {

    static BankAccount tempAcc;
    static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        Button depositBtn = findViewById(R.id.depositBtn);
        Button withdrawBtn = findViewById(R.id.withdrawBtn);
        TextView nameDisTV = findViewById(R.id.nameDisTV);

        if(count == 0)
            depositBtn.setVisibility(View.GONE);
        else
            withdrawBtn.setVisibility(View.GONE);

        nameDisTV.setText(tempAcc.getAccountHName());
    }

    public void deposit(View view){
        EditText amountScanET = findViewById(R.id.amountScanET);
        String amount = amountScanET.getText().toString();
        double deposit_bal;
        if(amount.length()==0){
            deposit_bal = 0.0;
        }else {
            deposit_bal = Double.parseDouble(amount);
        }
        double avl_bal = Double.parseDouble(tempAcc.getBalance());
        String final_bal = Double.toString(avl_bal+deposit_bal);
        tempAcc.setBalance(final_bal);
        MainPage.tempAcc = tempAcc;
        Intent Intent = new Intent(this,MainPage.class);
        startActivity(Intent);
    }

    public void withdraw(View view){

        EditText amountScanET = findViewById(R.id.amountScanET);
        TextView insufficientBTV = findViewById(R.id.insufficientBTV);

        String amount = amountScanET.getText().toString();
        double withdraw_bal;
        if(amount.length()==0){
            withdraw_bal = 0.0;
        }else {
            withdraw_bal = Double.parseDouble(amount);
        }
        double avl_bal = Double.parseDouble(tempAcc.getBalance());

        String final_bal = Double.toString(avl_bal-withdraw_bal);

        if(Double.parseDouble(final_bal)>=0) {
            insufficientBTV.setVisibility(View.GONE);
            tempAcc.setBalance(final_bal);
            MainPage.tempAcc = tempAcc;
            Intent Intent = new Intent(this,MainPage.class);
            startActivity(Intent);
        }
        else{
            insufficientBTV.setVisibility(View.VISIBLE);
        }
    }

}