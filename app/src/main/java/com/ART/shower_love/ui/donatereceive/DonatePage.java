package com.ART.shower_love.ui.donatereceive;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.ART.shower_love.R;

public class DonatePage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String [] condition = {"Excellent","Good","Bad","Worst"};
    String [] recycle = {"Yes","No",};
    String [] use = {"Can use directly","Need a recycle"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate_page);
        Spinner cond = findViewById(R.id.spinnercondition);
        Spinner rcyc = findViewById(R.id.spinnerrecycle);
        Spinner usecondition = findViewById(R.id.spinneruse);
        ArrayAdapter<String> ConditionAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,condition);
        ArrayAdapter<String> RecycleAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,recycle);
        ArrayAdapter<String> UseAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,use);
        ConditionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        RecycleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        UseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cond.setAdapter(ConditionAdapter);
        rcyc.setAdapter(RecycleAdapter);
        usecondition.setAdapter(UseAdapter);
        cond.setOnItemSelectedListener(this);
        rcyc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        usecondition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
