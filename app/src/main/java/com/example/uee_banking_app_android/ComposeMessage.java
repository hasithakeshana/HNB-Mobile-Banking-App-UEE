package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ComposeMessage extends AppCompatActivity {

    private EditText composeMsg,composeSubj;
   // private Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_message);

       // btnSend = findViewById(R.id.btnSend);
        composeMsg = findViewById(R.id.input1);
        composeSubj = findViewById(R.id.enterMsg);


    }


    public void sendMsg(View view) {
        if (composeMsg.getText().toString().isEmpty()|| composeMsg.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(),"Please Enter a Message with subject and body", Toast.LENGTH_LONG).show();

        } else {
            Intent intent = new Intent(this, MessageSent.class);
            startActivity(intent);
            this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //fade animations
        }
    }



    /**
     * Disabling back button
     */


}
