package com.loancalculator.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ResultScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);
        //Get Extra value
        //getIntent() method = asking "Who called me?"
        Intent intent=getIntent();
        String status= intent.getStringExtra(MainScreen.LOANSTATUS);

        //For numerical data, a default value must be provided
        double repayment = intent.getDoubleExtra(MainScreen.LOANREPAYMENT,0);
    }

    public void closeApp(View view){
        finish();
    }
}
