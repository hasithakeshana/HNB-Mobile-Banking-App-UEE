package com.example.uee_banking_app_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
    }
    public void logout(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void viewAccounts(View view){
        Intent intent = new Intent(this, Select_Account.class);
        startActivity(intent);
    }
    public void transactionHistory(View view){
        Intent intent = new Intent(this, TransactionHistory.class);
        startActivity(intent);
    }
    public void requestCheckBook(View view){
        Intent intent = new Intent(this, request_cheque_book.class);
        startActivity(intent);
    }
    public void bankTransfer(View view){
        Intent intent = new Intent(this, bank_transfer.class);
        startActivity(intent);
    }

    public void viewCreditCards(View view) {
        Intent intent = new Intent(this, credit_cards.class);
        startActivity(intent);
    }

    public void accountDetails(View view){
        Intent intent = new Intent(this, AccountDetails.class);
        startActivity(intent);
    }

    public void billPaymentDetails(View view){
        Intent intent = new Intent(this, BillPaymentsMain.class);
        startActivity(intent);
    }

    public void ratingInterface(View view){
        Intent intent = new Intent(this, RatingActivity.class);
        startActivity(intent);
    }

}
