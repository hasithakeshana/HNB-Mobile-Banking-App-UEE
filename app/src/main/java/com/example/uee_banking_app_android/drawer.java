package com.example.uee_banking_app_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class drawer extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_header);
    }
    public void viewAccounts(View view){
        Intent intent = new Intent(this, Select_Account.class);
        startActivity(intent);
    }
}
