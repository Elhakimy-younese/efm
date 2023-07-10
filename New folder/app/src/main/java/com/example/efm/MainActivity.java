package com.example.efm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText number;
    Spinner spinner;
    Button calculate;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = findViewById(R.id.etnumber);
        spinner = findViewById(R.id.spinner);
        calculate = findViewById(R.id.btncalculate);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapter.add("opposite");
        adapter.add("Absolute Value");
        adapter.add("Squere");
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberText = number.getText().toString();

                try {
                    int numberValue = Integer.parseInt(numberText);
                    if (TextUtils.isEmpty(numberText)) {
                    throw new Exception();
                    }

                } catch (Exception e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Caution")
                            .setMessage("You chould enter number value")
                            .create()
                            .show();
                }
                }

        });


    }
}