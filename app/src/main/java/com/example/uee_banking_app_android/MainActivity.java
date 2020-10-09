package com.example.uee_banking_app_android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private EditText usernameInput;
    private EditText passwordInput;
    private android.widget.EditText edtPassword;
    public static Boolean autoFill = true;    //Auto fill Login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.password);

        if(autoFill)
        {
            usernameInput.setText("John Doe");
            passwordInput.setText("thanos");
        }

        dbHelper = new DBHelper(this.getApplicationContext()); //Creating Tables
        SQLiteDatabase DB = dbHelper.getWritableDatabase();
        DB.close();

        SharedPreferences prefs = getSharedPreferences("Settings", MODE_PRIVATE);
        if (!prefs.contains("emailVerification"))
        {
            SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
            editor.putInt("emailVerification", 0);
            editor.putInt("smsVerification", 1);
            editor.apply();
        }

    }

    public void viewPassword(View v)
    {
        edtPassword = (EditText) findViewById(R.id.password);
        edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
    }

    public void login(View view) {
        SQLiteDatabase DB = dbHelper.getReadableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM users",null);
        cursor.moveToFirst();
        while(cursor.moveToNext())
        {
            String username = cursor.getString(cursor.getColumnIndex("username"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            if(username.equalsIgnoreCase(usernameInput.getText().toString()) && password.equalsIgnoreCase(passwordInput.getText().toString()))
            {
                Intent intent = new Intent(this,sms_verification.class);
                startActivity(intent);
                cursor.close();
                DB.close();
                return;
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Login details are incorrect", Toast.LENGTH_LONG).show();
                passwordInput.setText("");
                usernameInput.setText("");
            }
        }

        cursor.close();
        DB.close();
    }

    public void forgotPassword(View view)
    {
        Intent intent = new Intent(this,ForgotPassword.class);
        startActivity(intent);

    }

    public void dontHaveAccount(View view)
    {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }

//    /**
//     * Disabling back button
//     */
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back button is disabled in this Screen", Toast.LENGTH_LONG).show();
    }
}
