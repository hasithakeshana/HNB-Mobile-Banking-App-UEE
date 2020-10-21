package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.uee_banking_app_android.util.RecyclerViewAdapterAccountCard;

import java.util.ArrayList;

public class Select_Account extends AppCompatActivity {

    private ArrayList<String> accountName = new ArrayList<>();
    private ArrayList<String>  ownerName = new ArrayList<>();
    private ArrayList<String>  balance = new ArrayList<>();
    private ArrayList<String>  avaBalance = new ArrayList<>();
    private ArrayList<String>  accRef = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_account);
        initValues();
        initRecyclerView();
    }

    private void initValues(){
        //Account 1
        accountName.add("My Account");
        ownerName.add("John Doe");
        balance.add("134,754.09");
        avaBalance.add("20,860.78");
        accRef.add("Ref: #58DJ34QQ4F");
        //Account 2
        accountName.add("My Savings");
        ownerName.add("John Doe");
        balance.add("434,985.56");
        avaBalance.add("325,345.87");
        accRef.add("Ref: #635KDQ3E34");
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapterAccountCard adapter = new RecyclerViewAdapterAccountCard(this, accountName,
                ownerName, balance, avaBalance, accRef);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void openCreate (View view){
        Intent intent = new Intent(this,CreateAccount.class);
        startActivity(intent);
    }

    public void menu(View view){
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }


}
