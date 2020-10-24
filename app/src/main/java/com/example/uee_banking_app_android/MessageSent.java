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
        Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_LONG).show();
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

    }
    public void NotOkay(View view)
    {
        Intent intent = new Intent(this,ComposeMessage.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Type the message again", Toast.LENGTH_LONG).show();
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
