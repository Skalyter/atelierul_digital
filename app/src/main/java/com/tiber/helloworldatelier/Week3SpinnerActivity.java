package com.tiber.helloworldatelier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Week3SpinnerActivity extends AppCompatActivity {

    private Spinner spinner;
    private List<String> dataSourceSpinner;
    private ArrayAdapter<String> adapterSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week3_spinner);
        spinner = findViewById(R.id.spinner);
        dataSourceSpinner = getSource();
        adapterSpinner = getAdapter();
        spinner.setAdapter(adapterSpinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),
                        "Selected: " + dataSourceSpinner.get(position),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(parent.getContext(), "Selected: none", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<String> getSource(){
        List<String> androids= new ArrayList<>();
        androids.add("Cupcake");
        androids.add("Donut");
        androids.add("Eclair");
        androids.add("Froyo");
        androids.add("Gingerbread");
        androids.add("Honeycomb");
        androids.add("IceCream Sandwich");
        androids.add("KitKat");
        androids.add("Lollipop");
        androids.add("Marshmallow");
        androids.add("Nougat");
        androids.add("Oreo");
        androids.add("Pie");
        androids.add("10");

        return androids;
    }

    private ArrayAdapter<String> getAdapter(){
        return new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                dataSourceSpinner);
    }


}
