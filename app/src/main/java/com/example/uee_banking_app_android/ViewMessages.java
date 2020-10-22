package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ViewMessages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_messages);
    }

    public void readMessage(View view)
    {
        Intent intent = new Intent(this,OpenMessage.class);
        startActivity(intent);
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //fade animations

    }

    public void composeMessage(View view)
    {
        Intent intent = new Intent(this,ComposeMessage.class);
        startActivity(intent);
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

    }

    public void menu(View view)
    {
        Intent intent = new Intent(this,menu_screen.class);
        startActivityForResult(intent,0);
//        startActivity(intent);

    }

    public void dashboard(View view){

        Intent intent = new Intent(this,dashboard.class);
        startActivity(intent);
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }


    /**
     * Disabling back button
     */
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back button is disabled in this Screen", Toast.LENGTH_LONG).show();
    }
}
