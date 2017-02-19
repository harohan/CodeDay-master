package com.example.harshdasika.goeco_official;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    BluetoothHelper btHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btHelper= new BluetoothHelper();
        btHelper.initializeBT();
    }

    protected void overridePendingTransitionLR() {
        overridePendingTransition(R.animator.slide_from_right, R.animator.slide_to_left);
    }

    public void connectBT(View v){
        btHelper.connectBT();
    }
    public void Disconnect(View v)
    {
        btHelper.Disconnect();
    }
    public void next(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransitionLR();
    }

    public BluetoothHelper getBTHelper(){
        return btHelper;
    }

}