package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class bank_transfer extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager ;
    BankTransferPagesAdapter pageAdapter ;
    TabItem ownAccTab ;
    TabItem hnbTab;
    TabItem otherBankTab;
    Dialog myDialog ;
    String accName;
    EditText name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_transfer);
        tabLayout = findViewById(R.id.tabLayoutbill) ;
        ownAccTab = findViewById(R.id.ownAccTab);
        hnbTab = findViewById(R.id.hnbTab);
        otherBankTab = findViewById(R.id.otherBankTab);
        viewPager = findViewById(R.id.transferViewPager);
        myDialog = new Dialog(this);
        //
        name = findViewById(R.id.email2);
        pageAdapter = new BankTransferPagesAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    public void refreshPage(View view){
        Intent intent = new Intent(this,bank_transfer.class);
        startActivity(intent);
    }

    public void showPopupMsg(View view){
        Button closeBttn ;
        Button yesBttn;
        accName = name.getText().toString();
        Toast toast = Toast.makeText(getApplicationContext(), accName, Toast.LENGTH_LONG);
        toast.show();
        myDialog.setContentView(R.layout.activity_bank_transfer_popup);
        closeBttn = (Button) myDialog.findViewById(R.id.msg_close_bttn);
        yesBttn = (Button) myDialog.findViewById(R.id.msg_yes_bttn);

        closeBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        yesBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Transfer Request Made Successfully", Toast.LENGTH_LONG).show();
            }
        });
        myDialog.show();
    }
}
