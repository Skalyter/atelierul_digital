package com.tiber.helloworldatelier.week5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.tiber.helloworldatelier.R;

public class FirstActivity extends AppCompatActivity {

    public static String TAG = "FirstActivity";
    public static String FIRST_NAME_KEY = "first_name_key";
    public static String RESPONSE_KEY = "response_key";

    private TextView textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button fab= findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSecondActivityForResult("Johnny Doe");
            }
        });
        Button btnSend = findViewById(R.id.btn_send);
        final EditText editName = findViewById(R.id.edit_name);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editName != null
                        && editName.getText()!=null
                        && editName.getText().toString().length()!=0){
                    startSecondActivityForResult(editName.getText().toString());
                } else {
                    startSecondActivityForResult("Stranger");
                }
            }
        });

        textMessage = findViewById(R.id.text_received_message);
        textMessage.setText("Waiting for message...");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0){
            if(resultCode == RESULT_OK){
                if(data != null){
                    String response = data.getStringExtra(RESPONSE_KEY);
                    textMessage.setText(response);
                } else {
                    // no-op
                }
            }else {
                // no-op
            }
        }
    }

    private void startSecondActivity(String text){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(FIRST_NAME_KEY, text);
        startActivity(intent);
    }

    private void startSecondActivityForResult(String name){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(FIRST_NAME_KEY, "From " + name);
        startActivityForResult(intent, 0);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}
