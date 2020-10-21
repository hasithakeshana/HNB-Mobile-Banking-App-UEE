package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MessageSent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_sent);
    }

    public void ok(View view)
    {
        Intent intent = new Intent(this,ViewMessages.class);
        startActivity(intent);

    }
    public void NotOkay(View view)
    {
        Intent intent = new Intent(this,ComposeMessage.class);
        startActivity(intent);
    }



    /**
     * Disabling back button
     */
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back button is disabled in this Screen", Toast.LENGTH_LONG).show();
    }
}
