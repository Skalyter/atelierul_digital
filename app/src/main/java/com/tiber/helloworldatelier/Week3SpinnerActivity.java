package com.tiber.helloworldatelier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Week3SpinnerActivity extends AppCompatActivity {

    private List<String> dataSourceSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week3_spinner);

        //create a spinner object
        Spinner spinner = findViewById(R.id.spinner);

        //get data for spinner (list of Strings)
        dataSourceSpinner = getSource();

        //create an ArrayAdapter with the specified layout and specified data(list of Strings)
        ArrayAdapter<String> adapterSpinner =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        dataSourceSpinner);

        //set the ArrayAdapter to the spinner
        spinner.setAdapter(adapterSpinner);

        //set onItemSelectedListener
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

    private List<String> getSource() {
        List<String> androids = new ArrayList<>();
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
}
