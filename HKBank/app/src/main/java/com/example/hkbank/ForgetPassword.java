package com.example.hkbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class ForgetPassword extends AppCompatActivity {

    static String phone;
    static String email;
    BankAccount tempAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
    }

    public void validation(View view){
        EditText phoneVerify = findViewById(R.id.phoneVerifyET);
        EditText emailVerify = findViewById(R.id.emailVerifyET);
        TextView invalidMassageTV = findViewById(R.id.invalidCaseTV);
        ConstraintLayout validationLO = findViewById(R.id.validationLO);
        ConstraintLayout changePinLo = findViewById(R.id.changePinLO);

        phone = phoneVerify.getText().toString();
        email = emailVerify.getText().toString();

        for(int i=0;i<createAcc.count;i++) {
            BankAccount tempAcc1 = createAcc.accountsArr[i];
            if(verify(tempAcc1.getPhone(),phone)){
                if(verify(tempAcc1.getEmail(),email)){
                    tempAcc = tempAcc1;
                    invalidMassageTV.setVisibility(View.INVISIBLE);
                    validationLO.setVisibility(View.GONE);
                    changePinLo.setVisibility(View.VISIBLE);
                }else{
                    invalidMassageTV.setVisibility(View.VISIBLE);
                }
            }else{
                invalidMassageTV.setVisibility(View.VISIBLE);
            }
        }
    }

    public void changePin(View view){
        EditText newPinET = findViewById(R.id.newPinET);
        EditText confirmPinET = findViewById(R.id.confirmPinET);
        TextView pinNotMatchingTV = findViewById(R.id.pinNotMatchTV);
        TextView pinChangeMsgTV = findViewById(R.id.pinChangeMsgTV);

        String newPin = newPinET.getText().toString();
        String confirmPin = confirmPinET.getText().toString();

        if(verify(newPin,confirmPin)){
            pinNotMatchingTV.setVisibility(View.INVISIBLE);
            pinChangeMsgTV.setVisibility(View.VISIBLE);
            tempAcc.setPin(newPin);

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent Intent = new Intent(ForgetPassword.this, Login.class);
                    startActivity(Intent);
                    finish();
                }
            }, 500);

        }
        else{
            pinNotMatchingTV.setVisibility(View.VISIBLE);
        }

    }

    static boolean verify(String obj,String client){
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

}