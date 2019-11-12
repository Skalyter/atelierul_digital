package com.tiber.helloworldatelier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText email, phone;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.input_email);
        phone = findViewById(R.id.input_phone);
        button = findViewById(R.id.submit_form);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email == null
                        || email.getText() == null
                        || email.getText().toString().length() == 0) {
                    email.setError("Fill the input with a valid email address");
                }
                if (phone == null
                        || phone.getText() == null
                        || phone.getText().toString().length() == 0) {
                    phone.setError("Fill the input with a valid phone number");
                }
            }
        });
    }
}
