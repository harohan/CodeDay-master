package com.example.harshdasika.goeco_official;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Switch;
import android.widget.ToggleButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import static android.support.v7.appcompat.R.styleable.CompoundButton;

public class ConfigureActivity extends AppCompatActivity {

    //BUTTONS
    Switch bedroom;
    //bedroom.setOnCheckedChangeListener(this);
    Switch kitchen;
    //kitchen.setOnCheckedChangeListener(this);
    Switch office;
    //office.setOnCheckedChangeListener(this);
    Switch basement;
    //basement.setOnCheckedChangeListener(this);
    Switch outside;
    //outside.setOnCheckedChangeListener(this);

    ArrayList<String> changedPins;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_configure);

        bedroom = (Switch) findViewById(R.id.bedroom);
        bedroom.setOnCheckedChangeListener(this);
        kitchen = (Switch) findViewById(R.id.kitchen);
        kitchen.setOnCheckedChangeListener(this);
        office = (Switch) findViewById(R.id.office);
        office.setOnCheckedChangeListener(this);
        basement = (Switch) findViewById(R.id.basement);
        basement.setOnCheckedChangeListener(this);
        outside = (Switch) findViewById(R.id.outside);
        outside.setOnCheckedChangeListener(this);
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            if(isChecked){
                switchStatus.setText("Switch is currently ON");
            }else{
                switchStatus.setText("Switch is currently OFF");
            }

        }
        if(ArduinoInterface.pins.contains("3")) bedroom.setChecked(true);
        if(ArduinoInterface.pins.contains("4")) kitchen.setChecked(true);
        if(ArduinoInterface.pins.contains("5")) office.setChecked(true);
        if(ArduinoInterface.pins.contains("6")) basement.setChecked(true);
        if(ArduinoInterface.pins.contains("7")) outside.setChecked(true);

    }


    public void slideUp(View v){
        for(String str : changedPins){
            ArduinoInterface.pins.add(str);
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransitionBT();

}
    private void overridePendingTransitionBT() {
        overridePendingTransition(R.animator.slide_from_top, R.animator.slide_to_bottom);
    }


}
