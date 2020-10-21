package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AccountDetails extends AppCompatActivity {

    public TextView name;
    public TextView ref;
    public TextView owner;
    public TextView branch;
    public TextView balance;
    public TextView hold;
    public TextView credit;
    public TextView available;
    public TextView type;
    public TextView CLimit;
    public TextView dLimit;
    public TextView cInterest;
    public TextView dInterest;
    public String accName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);
        name = findViewById(R.id.text_account_name);
        ref = findViewById(R.id.text_ref);
        owner = findViewById(R.id.text_owner);
        branch = findViewById(R.id.text_branch);
        balance = findViewById(R.id.text_balance);
        hold = findViewById(R.id.text_hold);
        credit = findViewById(R.id.text_credit);
        available = findViewById(R.id.text_availble);
        type = findViewById(R.id.text_account_type);
        CLimit = findViewById(R.id.text_credit_limit);
        dLimit = findViewById(R.id.text_debit_limit);
        cInterest = findViewById(R.id.text_credit_interest);
        dInterest = findViewById(R.id.text_debit_interest);

        Bundle bundle = getIntent().getExtras();
        String accName = "My Account";


        if(accName.equals("My Account")){
            this.name.setText("My Account");
            ref.setText("5DSGJ3264H");
            owner.setText("John Doe");
            branch.setText("Koswatta");
            balance.setText("134,754.09");
            hold.setText("0.00");
            credit.setText("0.00");
            available.setText("134,754.09");
            type.setText("Personal");
            CLimit.setText("0.00");
            dLimit.setText("0.00");
            cInterest.setText("24.9%");
            dInterest.setText("0.9%");
        }
        else if(accName.equals("My Savings")){
            this.name.setText("My Savings");
            ref.setText("SFS453SG54");
            owner.setText("John Doe");
            branch.setText("Koswatta");
            balance.setText("$434,795.56");
            hold.setText("0.00");
            credit.setText("0.00");
            available.setText("$434,795.56");
            type.setText("Saving");
            CLimit.setText("0.00");
            dLimit.setText("0.00");
            cInterest.setText("24.9%");
            dInterest.setText("0.9%");
        }
    }

    public void goBack(View view){
        Intent intent = new Intent(this, Select_Account.class);
        startActivity(intent);
    }
    public void openTrans(View view){
        Intent intent = new Intent(this, TransactionHistory.class);
        intent.putExtra("Name",accName);
        startActivity(intent);
    }

    public void menu(View view){
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }
}
