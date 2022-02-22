package com.example.hkbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AccDetails extends AppCompatActivity {

    static BankAccount tempAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc_details);

        TextView nameShowTV = findViewById(R.id.nameShowTV);
        TextView phoneShowTV = findViewById(R.id.phoneshowTV);
        TextView emailShowTV = findViewById(R.id.emailShowTV);
        TextView balanceShowTV = findViewById(R.id.balanceShowTV);

        nameShowTV.setText(tempAcc.getAccountHName());
        phoneShowTV.setText(tempAcc.getPhone());
        emailShowTV.setText(tempAcc.getEmail());
        balanceShowTV.setText(tempAcc.getBalance());
    }

    public void back(View view){
        Intent Intent = new Intent(this,MainPage.class);
        startActivity(Intent);
    }
}