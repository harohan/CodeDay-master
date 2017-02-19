package com.example.harshdasika.goeco_official;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.ToggleButton;
import android.widget.SeekBar.OnSeekBarChangeListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import static android.support.v7.appcompat.R.styleable.CompoundButton;

public class ConfigureActivity extends AppCompatActivity {

    //BUTTONS
    Switch bedroom;
    Switch kitchen;
    Switch office;
    Switch basement;
    Switch outside;
    Switch acButton;
    SeekBar acSeeker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_configure);


        addEventListeners();
        if(ArduinoInterface.pins.contains("3")) bedroom.setChecked(true);
        if(ArduinoInterface.pins.contains("4")) kitchen.setChecked(true);
        if(ArduinoInterface.pins.contains("5")) office.setChecked(true);
        if(ArduinoInterface.pins.contains("6")) basement.setChecked(true);
        if(ArduinoInterface.pins.contains("7")) outside.setChecked(true);
        if(ArduinoInterface.pins.contains("11") && ArduinoInterface.pins.contains("12") && ArduinoInterface.pins.contains("13")) acButton.setChecked(true);

        ArduinoInterface.pins = new ArrayList<>();


    }

    public void addEventListeners(){
        acSeeker = (SeekBar) findViewById(R.id.seekBar2);
        acSeeker.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                System.out.print(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                System.out.print("nuggr");
            }
        });

        acButton = (Switch) findViewById(R.id.AC);
        acButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ArduinoInterface.pins.add("11");
                    ArduinoInterface.pins.add("12");
                    ArduinoInterface.pins.add("13");
                }else{
                    if(ArduinoInterface.pins.contains("11") && ArduinoInterface.pins.contains("12") && ArduinoInterface.pins.contains("13")){
                        ArduinoInterface.pins.remove(ArduinoInterface.pins.indexOf("11"));
                        ArduinoInterface.pins.remove(ArduinoInterface.pins.indexOf("12"));
                        ArduinoInterface.pins.remove(ArduinoInterface.pins.indexOf("13"));
                }}
            }
        });

        bedroom = (Switch) findViewById(R.id.bedroom);
        bedroom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ArduinoInterface.pins.add("3");
                }else{
                    if(ArduinoInterface.pins.contains("3"))
                        ArduinoInterface.pins.remove(ArduinoInterface.pins.indexOf("3"));
                }
            }
        });
        kitchen = (Switch) findViewById(R.id.kitchen);
        kitchen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ArduinoInterface.pins.add("4");
                }else{
                    if(ArduinoInterface.pins.contains("4"))
                        ArduinoInterface.pins.remove(ArduinoInterface.pins.indexOf("4"));

                }
            }
        });
        office = (Switch) findViewById(R.id.office);
        office.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ArduinoInterface.pins.add("5");
                }
                else{
                    if(ArduinoInterface.pins.contains("5"))
                        ArduinoInterface.pins.remove(ArduinoInterface.pins.indexOf("5"));
                }
            }
        });
        basement = (Switch) findViewById(R.id.basement);
        basement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ArduinoInterface.pins.add("6");
                }
                else{
                    if(ArduinoInterface.pins.contains("6"))
                        ArduinoInterface.pins.remove(ArduinoInterface.pins.indexOf("6"));
                }
            }
        });
        outside = (Switch) findViewById(R.id.outside);
        outside.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ArduinoInterface.pins.add("7");
                }
                else{
                    if(ArduinoInterface.pins.contains("7"))
                        ArduinoInterface.pins.remove(ArduinoInterface.pins.indexOf("7"));
                }
            }
        });

    }

    public void slideUp(View v){
        if(bedroom.isChecked() && !ArduinoInterface.pins.contains("3")) ArduinoInterface.pins.add("3");
        if(kitchen.isChecked() && !ArduinoInterface.pins.contains("4")) ArduinoInterface.pins.add("4");
        if(office.isChecked() && !ArduinoInterface.pins.contains("5")) ArduinoInterface.pins.add("5");
        if(basement.isChecked() && !ArduinoInterface.pins.contains("6")) ArduinoInterface.pins.add("6");
        if(outside.isChecked() && !ArduinoInterface.pins.contains("7")) ArduinoInterface.pins.add("7");
        if(acButton.isChecked() && !(ArduinoInterface.pins.contains("11") && ArduinoInterface.pins.contains("12") && ArduinoInterface.pins.contains("13"))){
            ArduinoInterface.pins.add("11");
            ArduinoInterface.pins.add("12");
            ArduinoInterface.pins.add("13");
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransitionBT();


}
    private void overridePendingTransitionBT() {
        overridePendingTransition(R.animator.slide_from_top, R.animator.slide_to_bottom);
    }


}
