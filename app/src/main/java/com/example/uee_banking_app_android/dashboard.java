package com.example.uee_banking_app_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.navigation.NavigationView;

public class dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    LottieAnimationView l;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        l = findViewById(R.id.anima);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        //navigation drawer
        menu = findViewById(R.id.menu_icon);
        setNavigationViewListener();
        navgationDrawer();
    }

    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void navgationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.home);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                        drawerLayout.closeDrawer(GravityCompat.START);
                    } else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }


    public void onBackPressed(){
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else super.onBackPressed();
    }

    public void logout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void viewAccounts(View view) {
        Intent intent = new Intent(this, Select_Account.class);
        startActivity(intent);
    }

    public void transactionHistory(View view) {
        Intent intent = new Intent(this, TransactionHistory.class);
        startActivity(intent);
    }

    public void requestCheckBook(View view) {
        Intent intent = new Intent(this, request_cheque_book.class);
        startActivity(intent);
    }

    public void bankTransfer(View view) {
        Intent intent = new Intent(this, bank_transfer.class);
        startActivity(intent);
    }

    public void viewCreditCards(View view) {
        Intent intent = new Intent(this, credit_cards.class);
        startActivity(intent);
    }

    public void accountDetails(View view) {
        Intent intent = new Intent(this, AccountDetails.class);
        startActivity(intent);
    }

    public void billPaymentDetails(View view) {
        Intent intent = new Intent(this, BillPaymentsMain.class);
        startActivity(intent);
    }

    public void ratingInterface(View view) {
        Intent intent = new Intent(this, RatingActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.home :
                break;
            case R.id.rate : Intent intent = new Intent(this,RatingActivity.class); startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
