package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {
    
    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

    }

    public void Submit(View view)
    {
        addNotification();
        Intent intent = new Intent(this,ResetInstructions.class);
        startActivity(intent);
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //fade animations
    }

    private void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.email)
                        .setContentTitle("Reset Password")
                        .setContentText("A reset password link has been sent to your email");
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
