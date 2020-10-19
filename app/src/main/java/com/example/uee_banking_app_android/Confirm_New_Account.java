package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class Confirm_New_Account extends AppCompatActivity {

    public TextView name;
    public TextView owner;
    public TextView branch;
    public TextView currency;
    public TextView interest;
    public TextView type;
    public TextView CLimit;
    public TextView dLimit;
    public TextView cInterest;
    public TextView dInterest;

    private String[] pageOneData;
    private String[]  pageTwoData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm__new__account);

        Bundle bundle = getIntent().getExtras();
        pageOneData = bundle.getStringArray("pageOneData");
        pageTwoData = bundle.getStringArray("pageTwoData");

        name = findViewById(R.id.header1);
        owner = findViewById(R.id.text_owner);
        branch = findViewById(R.id.text_branch);
        currency = findViewById(R.id.text_currency);
        interest = findViewById(R.id.text_interest);
        type = findViewById(R.id.text_account_type);
        CLimit = findViewById(R.id.text_credit_limit);
        dLimit = findViewById(R.id.text_debit_limit);
        cInterest = findViewById(R.id.text_credit_interest);
        dInterest = findViewById(R.id.text_debit_interest);

        init();


    }


    private void init(){
        name.setText("Hey " +pageTwoData[0]);
        owner.setText(pageOneData[1]);
        branch.setText(pageOneData[2]);
        currency.setText(getCurrencyByIndex(Integer.parseInt(pageTwoData[2])));
        interest.setText(pageTwoData[5]);
        type.setText(getTypeByIndex(Integer.parseInt(pageTwoData[1])));
        CLimit.setText(pageTwoData[3]);
        dLimit.setText(pageTwoData[4]);
        cInterest.setText(pageTwoData[7]);
        dInterest.setText(pageTwoData[6]);
    }



    public void openPage1(View view){
        Intent intent = new Intent(this, CreateAccount.class);
        intent.putExtra("pageOneData",pageOneData);
        intent.putExtra("pageTwoData", pageTwoData);
        startActivity(intent);
    }
    public void openPage2(View view){
        Intent intent = new Intent(this, Create_Account_page2.class);
        intent.putExtra("pageOneData",pageOneData);
        intent.putExtra("pageTwoData", pageTwoData);
        startActivity(intent);
    }

    public void confirm(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
        builder.setTitle("Confromation Message");
        builder.setMessage("Account Repuest has been made an e-mail will be sent to your email within 3 to 5 working days");
        builder.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                next();
            }
        });
        builder.setNegativeButton("Back", null);
        builder.show();

    }
    public void cancel(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
        builder.setTitle("Confromation Message");
        builder.setMessage("are you sure you want to cancel\n all entered information will be lost");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                back();
            }
        });
        builder.setNegativeButton("Return", null);
        builder.show();
    }

    private String getTypeByIndex(int index){
        switch(index){
            case 0: return"Personal";
            case 1: return" Savings";
            case 2: return" Fixed Deposit";
            case 3: return" Money Marketing";
            case 4: return"Retirement Accounts";

        }
             return "Personal";
    }



    private String getCurrencyByIndex(int index){
        switch(index){
            case 0: return"LRK";
            case 1: return"USD";
            case 2: return"EUR";
            case 3: return"JPY";
            case 4: return"GBP";
            case 5: return"AUD";
            case 6: return"CAD";
            case 7: return"CNH";
            case 8: return"NZD";
        }
        return "LRK";
    }


    private void back() {
        Intent intent = new Intent(this, Select_Account.class);
        startActivity(intent);
    }


    private void next(){
        Intent intent = new Intent(this, Select_Account.class);
        startActivity(intent);
    }
}








