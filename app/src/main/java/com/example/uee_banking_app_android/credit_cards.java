package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class credit_cards extends AppCompatActivity {

    TabLayout tabLayout ;
    ViewPager viewPager ;
    CreditCardsPageAdapter pageAdapter ;
    TabItem myCardTab ;
    TabItem addCardTab ;
    EditText name;
    Dialog myDialog ;

    EditText creditCardNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_cards);

        myDialog = new Dialog(this);

        tabLayout = findViewById(R.id.tabLayout) ;
        myCardTab = findViewById(R.id.myCards);
        addCardTab = findViewById(R.id.addCards);
        viewPager = findViewById(R.id.viewPager);
       // name = (EditText) findViewById(R.id.emailSwitch);


        pageAdapter = new CreditCardsPageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
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

    public void mainMenu(View v){
        Intent intent = new Intent(this,menu_screen.class);
        startActivity(intent);
    }

    public void addCardPopup(View view){
        Button closeBttn ;
        Button yesBttn;
        TextView textMsg ;

        myDialog.setContentView(R.layout.activity_popup_message_request_book);
        closeBttn = (Button) myDialog.findViewById(R.id.msg_close_bttn);
        yesBttn = (Button) myDialog.findViewById(R.id.msg_yes_bttn);
        textMsg = (TextView) myDialog.findViewById(R.id.textView19);

        textMsg.setText("Are you sure u want to add new card?");

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
                Toast.makeText(getApplicationContext(), "Successfully added", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(credit_cards.this,dashboard.class);
                startActivity(intent);
            }
        });
        myDialog.show();
    }

    public void delinkCard(View view){
        Button closeBttn ;
        Button yesBttn;
        TextView textMsg ;

        myDialog.setContentView(R.layout.activity_popup_message_request_book);
        closeBttn = (Button) myDialog.findViewById(R.id.msg_close_bttn);
        yesBttn = (Button) myDialog.findViewById(R.id.msg_yes_bttn);
        textMsg = (TextView) myDialog.findViewById(R.id.textView19);

        textMsg.setText("Are you sure u want to delink card?");

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
                Toast.makeText(getApplicationContext(), "Successfully removed", Toast.LENGTH_LONG).show();
            }
        });
        myDialog.show();
    }


    //    /**
//     * Disabling back button
//     */
//    @Override
//    public void onBackPressed() {
//        Toast.makeText(getApplicationContext(), "Back button is disabled in this Screen", Toast.LENGTH_LONG).show();
//    }

    public void backToDashboard(View view) {
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }

}
