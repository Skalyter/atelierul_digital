package com.tiber.helloworldatelier.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.tiber.helloworldatelier.R;

public class SecondActivity extends AppCompatActivity {

    private static String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
        setContentView(R.layout.activity_second);
        TextView textFirstName = findViewById(R.id.text_first_name);
        String firstName = null;

        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = getIntent().getExtras();
            if(bundle != null){
                firstName = bundle.getString(FirstActivity.FIRST_NAME_KEY);

            }
        }
        if(firstName == null){
            firstName = "Stranger";
        }

        textFirstName.setText("Hello, " + firstName);

        final EditText response  = findViewById(R.id.edit_response);

        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(FirstActivity.RESPONSE_KEY, response.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
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
