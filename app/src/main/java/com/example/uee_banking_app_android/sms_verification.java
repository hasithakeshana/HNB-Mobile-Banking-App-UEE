package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sms_verification extends AppCompatActivity {

    private EditText i1, i2, i3, i4, i5, i6;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_verification);

        i1 = findViewById(R.id.input1);
        i2 = findViewById(R.id.input2);
        i3 = findViewById(R.id.input3);
        i4 = findViewById(R.id.input4);
        i5 = findViewById(R.id.input5);
        i6 = findViewById(R.id.input6);

        btnSubmit = findViewById(R.id.button9);

        i1.addTextChangedListener(new TextWatcher() {


            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (i1.getText().toString().length() == 1) {
                    i2.requestFocus();
                }
            }

            public void afterTextChanged(Editable s) {

            }
        });

        i2.addTextChangedListener(new TextWatcher() {


            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (i2.getText().toString().length() == 1) {
                    i3.requestFocus();
                }
            }

            public void afterTextChanged(Editable s) {

            }
        });
        i3.addTextChangedListener(new TextWatcher() {


            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (i3.getText().toString().length() == 1) {
                    i4.requestFocus();
                }
            }

            public void afterTextChanged(Editable s) {

            }
        });
        i4.addTextChangedListener(new TextWatcher() {


            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (i4.getText().toString().length() == 1) {
                    i5.requestFocus();
                }
            }

            public void afterTextChanged(Editable s) {

            }
        });
        i5.addTextChangedListener(new TextWatcher() {


            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (i5.getText().toString().length() == 1) {
                    i6.requestFocus();
                }
            }

            public void afterTextChanged(Editable s) {

            }
        });
        i6.addTextChangedListener(new TextWatcher() {


            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (i6.getText().toString().length() == 1) {
                    btnSubmit.requestFocus();
                }
            }

            public void afterTextChanged(Editable s) {

            }
        });


        if (btnSubmit.hasFocus()) {

        }
    }

    public void submitBttn(View view) {

        if (i1.getText().toString().isEmpty() || i2.getText().toString().isEmpty() || i3.getText().toString().isEmpty() || i4.getText().toString().isEmpty() || i5.getText().toString().isEmpty() || i6.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please the Code Properly", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, dashboard.class);
            startActivity(intent);
        }
    }

    public void resendOtp(View view) {
        Toast.makeText(getApplicationContext(), "Code send to +94xxxxxxxxx", Toast.LENGTH_LONG).show();
    }


}





    /**
     * Disabling back button
     */
//    @Override
//    public void onBackPressed() {
//        Toast.makeText(getApplicationContext(), "Back button is disabled in this Screen", Toast.LENGTH_LONG).show();
//    }

