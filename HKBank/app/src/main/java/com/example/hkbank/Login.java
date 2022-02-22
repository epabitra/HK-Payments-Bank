package com.example.hkbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    static String phone;
    static String pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    static boolean validation(String obj,String client){
        boolean returnValue=true;
        if(obj.length() == client.length()) {
            int i = 0;
            while(i<obj.length()){
                if(obj.charAt(i)==client.charAt(i)){
                }else{
                    returnValue=false;
                }
                i++;
            }
        }else{
            returnValue=false;
        }
        return returnValue;
    }

    public void checkLogin(View view){

        Intent Intent = new Intent(this,MainPage.class);

        EditText phoneVerify = findViewById(R.id.phoneVerify);
        EditText pinVerify = findViewById(R.id.pinVerify);
        TextView invalidMassageTB = findViewById(R.id.invalidCaseTV);

        phone = phoneVerify.getText().toString();
        pin = pinVerify.getText().toString();

        for(int i=0;i<createAcc.count;i++) {
            BankAccount tempAcc1 = createAcc.accountsArr[i];
            if(validation(tempAcc1.getPhone(),phone)){
                if(validation(tempAcc1.getPin(),pin)){
                    MainPage.tempAcc = tempAcc1;
                    startActivity(Intent);
                    invalidMassageTB.setVisibility(View.INVISIBLE);
                }else{
                    invalidMassageTB.setVisibility(View.VISIBLE);
                }
            }else{
                invalidMassageTB.setVisibility(View.VISIBLE);
            }
        }
    }

    public void signUp(View View){
        Intent Intent = new Intent(this,createAcc.class);
        startActivity(Intent);
    }

    public void forgetPassword(View view){
        Intent Intent = new Intent(this,ForgetPassword.class);
        startActivity(Intent);
    }

    @Override
    public void onBackPressed(){

    }
}