package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends AppCompatActivity {
    private android.widget.EditText edtPassword;
    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void submit(View view)
    {
        regNotification();
        Intent intent = new Intent(this,LoginDetailsMessage.class);
        startActivity(intent);
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //fade animations
    }
    public void viewPassword(View v)
    {
        edtPassword = (EditText) findViewById(R.id.regPassword);
        edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
    }

    private void regNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.email)
                        .setContentTitle("Verification Email")
                        .setContentText("A verification link has been sent to your email");
        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
    /**
     * Disabling back button
     */
//    @Override
//    public void onBackPressed() {
//        Toast.makeText(getApplicationContext(), "Back button is disabled in this Screen", Toast.LENGTH_LONG).show();
//    }
}

