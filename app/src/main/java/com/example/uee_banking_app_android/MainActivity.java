package com.example.uee_banking_app_android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DBHelper dbHelper;
    private EditText usernameInput;
    private EditText passwordInput;
    private android.widget.EditText edtPassword;
    public static Boolean autoFill = true;    //Auto fill Login
    private Button buttonSubmit;
    int count=0;

    private AwesomeValidation awesomeValidation;
    private Animation zoomAnimation;
    private ImageView pdlockImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.password);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        pdlockImg = (ImageView) findViewById(R.id.padlockImgView);

        zoomAnimation = AnimationUtils.loadAnimation(this,R.anim.zoomin);
        pdlockImg.startAnimation(zoomAnimation);


        buttonSubmit = (Button) findViewById(R.id.loginBtn);

        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.username, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.usrerror);
        awesomeValidation.addValidation(this, R.id.password, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.pwderror);

        buttonSubmit.setOnClickListener(this);

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

    public void login() {
        SQLiteDatabase DB = dbHelper.getReadableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM users",null);
        cursor.moveToFirst();
        while(cursor.moveToNext())
        {
                String username = cursor.getString(cursor.getColumnIndex("username"));
                String password = cursor.getString(cursor.getColumnIndex("password"));
                if (username.equalsIgnoreCase(usernameInput.getText().toString()) && password.equalsIgnoreCase(passwordInput.getText().toString())) {
                    Intent intent = new Intent(this, sms_verification.class);
                    startActivity(intent);
                    cursor.close();
                    DB.close();
                    return;
                } else {
                    Toast.makeText(getApplicationContext(), "Login details are incorrect", Toast.LENGTH_LONG).show();
                    passwordInput.setText("");
                    usernameInput.setText("");
                    if(count > 3) {
                        Intent frgtPwd = new Intent(this, ForgotPassword.class);
                        startActivity(frgtPwd);
                    }
                    else {
                        count++;
                    }
                }

        }

        cursor.close();
        DB.close();

    }

    public void forgotPassword(View view)
    {
        Intent frgtPwd = new Intent(this, ForgotPassword.class);
        startActivity(frgtPwd);

    }

    public void dontHaveAccount(View v1)
    {
        Intent reg = new Intent(this,Register.class);
        startActivity(reg);
    }

//    /**
//     * Disabling back button
//     */
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back button is disabled in this Screen", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        if (awesomeValidation.validate()) {
            login();
        }
    }
}
