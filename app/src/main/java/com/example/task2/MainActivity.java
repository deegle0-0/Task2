package com.example.task2;

import static java.lang.Math.round;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    EditText input;
    Spinner type_select,from_select,to_select;
    TextView output;
    Button convertButton;
    ArrayList<String> arrayList_parent;
    ArrayList<String> arrayList_Weight,arrayList_Temperature,arrayList_Distance;
    ArrayAdapter<String> arrayAdapter_parent;
    ArrayAdapter<String> arrayAdapter_child;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        type_select = findViewById(R.id.type_spinner);

        from_select = findViewById(R.id.fromType);

        to_select = findViewById(R.id.toType);

        input = findViewById(R.id.inputNumber);

        output = findViewById(R.id.outputNumber);

        convertButton = findViewById(R.id.button);

        arrayList_parent = new ArrayList<>();
        arrayList_parent.add("Weight");
        arrayList_parent.add("Distance");
        arrayList_parent.add("Temperature");

        arrayAdapter_parent = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_item,arrayList_parent);

        type_select.setAdapter(arrayAdapter_parent);


        // for sub selection from weight, distance, temp


        arrayList_Weight = new ArrayList<>();
        arrayList_Weight.add("Kilogram");
        arrayList_Weight.add("Pounds");
        arrayList_Weight.add("Ounce");
        arrayList_Weight.add("Ton");

        arrayList_Temperature = new ArrayList<>();
        arrayList_Temperature.add("Celsius");
        arrayList_Temperature.add("Kelvin");
        arrayList_Temperature.add("Fahrenheit");

        arrayList_Distance = new ArrayList<>();
        arrayList_Distance.add("Kilometer");
        arrayList_Distance.add("Centimeter");
        arrayList_Distance.add("Mile");
        arrayList_Distance.add("Yards");
        arrayList_Distance.add("Inch");
        arrayList_Distance.add("Foot");


        type_select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item,arrayList_Weight);
                }
                if(position==1){
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item,arrayList_Distance);
                }
                if(position==2){
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item,arrayList_Temperature);
                }
                from_select.setAdapter(arrayAdapter_child);
                to_select.setAdapter(arrayAdapter_child);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConvertWeight();
                ConvertDistance();
                ConvertTemperature();
            }
        });
    }

    private void ConvertDistance() {
        if(from_select.getSelectedItem().toString() == "Kilometer")
        {
            String valueEntered = input.getText().toString();
            double KiloM = Double.parseDouble(valueEntered);
            double centi= KiloM * 100000 ;
            double mile = KiloM/1.609;
            double yards = KiloM * 1094;
            double inch = KiloM * 39370;
            double foot = KiloM *3281;
            if(to_select.getSelectedItem().toString() == "Centimeter")
            {
                output.setText(""+centi);
            }
            else if(to_select.getSelectedItem().toString() == "Mile")
            {
                output.setText(""+mile);
            }
            else if(to_select.getSelectedItem().toString() == "Yards")
            {
                output.setText(""+yards);
            }
            else if(to_select.getSelectedItem().toString() == "Inch")
            {
                output.setText(""+inch);
            }
            else if(to_select.getSelectedItem().toString() == "Foot")
            {
                output.setText(""+foot);
            }
            else{
                output.setText(""+KiloM);
            }
        }
    }

    private void ConvertTemperature() {
        if(from_select.getSelectedItem().toString() == "Celsius")
        {
            String valueEntered = input.getText().toString();
            double celsius = Double.parseDouble(valueEntered);
            double kelvin=  celsius + 273.15;
            double fahrenheit = (celsius*1.8) + 32;
            if(to_select.getSelectedItem().toString() == "Kelvin")
            {
                output.setText(""+kelvin);
            }
            else if(to_select.getSelectedItem().toString() == "Fahrenheit")
            {
                output.setText(""+fahrenheit);
            }
            else{
                output.setText(""+celsius);
            }
        }
    }

    private void ConvertWeight() {
        if(from_select.getSelectedItem().toString() == "Kilogram")
        {
            String valueEntered = input.getText().toString();
            double KiloG = Double.parseDouble(valueEntered);
            double pounds=  2.205*KiloG ;
            double ounce =  35.274* KiloG ;
            double ton = KiloG/907.185 ;
            if(to_select.getSelectedItem().toString() == "Pounds")
            {
                output.setText(""+pounds);
            }
            else if(to_select.getSelectedItem().toString() == "Ounce")
            {
                output.setText(""+ounce);
            }
            else if(to_select.getSelectedItem().toString() == "Ton")
            {
                output.setText(""+ton);
            }
            else{
                output.setText(""+KiloG);
            }
        }
    }
}