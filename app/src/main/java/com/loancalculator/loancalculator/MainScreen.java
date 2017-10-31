package com.loancalculator.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainScreen extends AppCompatActivity {

    public static final String LOANSTATUS = "status";
    public static final String LOANPAYMENT = "payment";
    private EditText editTextPrice,editTextDownPayment,editTextInterestRate,editTextRepayment,editTextSalary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        editTextPrice = (EditText)findViewById(R.id.editTextPrice);
        editTextDownPayment = (EditText)findViewById(R.id.editTextDownPayment);
        editTextInterestRate = (EditText)findViewById(R.id.editTextInterestRate);
        editTextRepayment = (EditText)findViewById(R.id.editTextRepayment);
        editTextSalary = (EditText)findViewById(R.id.editTextSalary);


    }

    public void calculateRepayment(View view){
        double payment = 0,totalInterest,totalLoan;
        totalInterest=(Double.parseDouble(editTextPrice.getText().toString())-Double.parseDouble(editTextDownPayment.getText().toString()))*Double.parseDouble(editTextInterestRate.getText().toString())*(Double.parseDouble(editTextRepayment.getText().toString())/12);
        totalLoan=(Double.parseDouble(editTextPrice.getText().toString())-Double.parseDouble(editTextDownPayment.getText().toString()))*totalInterest;
        payment=totalLoan/Double.parseDouble(editTextDownPayment.getText().toString());
        Intent intent = new Intent(this, ResultScreen.class);
        //putExtra has 2 parameter(Tag, Value)
        intent.putExtra(LOANSTATUS,"Approve");
        intent.putExtra(LOANPAYMENT,payment);
        startActivity(intent);
    }
}
