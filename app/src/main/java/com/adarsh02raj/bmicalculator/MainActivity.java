package com.adarsh02raj.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtResult;
        EditText editWeight, editHeightFt, editHeightIn;
        Button btnCalculate;
        LinearLayout loutmain;
        loutmain = findViewById(R.id.loutMain);
        editWeight = findViewById(R.id.editWeight);
        editHeightFt = findViewById(R.id.editHeightFt);
        editHeightIn = findViewById(R.id.editHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = 0;
                try {
                    wt = Integer.parseInt(editWeight.getText().toString());
                }
                catch (NumberFormatException ex){
                    Toast.makeText(getApplicationContext(), "Please Enter a valid weight.", 
                            Toast.LENGTH_SHORT).show();
                }
                int ft = 0;
                try {
                    ft = Integer.parseInt(editHeightFt.getText().toString());
                }
                catch (NumberFormatException ex){
                    Toast.makeText(getApplicationContext(), "Please Enter a valid length.",
                            Toast.LENGTH_SHORT).show();
                }
                int in = 0;
                try {
                    Integer.parseInt(editHeightIn.getText().toString());
                }
                catch (NumberFormatException ex){
                    Toast.makeText(getApplicationContext(), "Please Enter a valid length.",
                            Toast.LENGTH_SHORT).show();
                }
                int totalIn = ft*12 + in;
                double totalCm = totalIn * 2.53;
                double totalM = totalCm/100;
                double bmi = wt/(totalM*totalM);
                if(editWeight.getText().toString().isEmpty() || editHeightFt.getText().toString().isEmpty() || editHeightIn.getText().toString().isEmpty()){
                    txtResult.setText("All fields are Compulsory.");
                }
                else{
                if(bmi>25){
                    txtResult.setText("You are Overweight!!");
                    loutmain.setBackgroundColor(getResources().getColor(R.color.overWeight));
                }
                else if (bmi<18){
                    txtResult.setText("You are Underweight!!");
                    loutmain.setBackgroundColor(getResources().getColor(R.color.underWeight));
                }
                else {
                    txtResult.setText("You are Healthy!!");
                    loutmain.setBackgroundColor(getResources().getColor(R.color.healthy));
                }
            }}
        });
    }
}