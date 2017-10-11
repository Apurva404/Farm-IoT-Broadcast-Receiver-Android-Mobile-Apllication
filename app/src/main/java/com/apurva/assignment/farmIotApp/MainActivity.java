package com.apurva.assignment.farmIotApp;

import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.view.View;
import android.content.IntentFilter;
import android.widget.Button;
import android.widget.TextView;

import com.apurva.assignment.farmIotApp.util.Util;
import com.apurva.assignment.farmIotApp.util.FanSprinklerState;

public class MainActivity extends Activity {
    private Button mFanButton, mSprinklerButton;
    private TextView mNoActionRequiredTextLabel, mFanOnTemperatureTextLabel, mFanSprinklerTemperatureTextLabel;
    private FanSprinklerState mState;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String tempValue = intent.getStringExtra(Util.EXTRA_TEMPERATURE);
            String humidityValue = intent.getStringExtra(Util.EXTRA_HUMIDITY);

            int tempIntValue = 0;
            if((tempValue != null) && (!tempValue.isEmpty()))
                tempIntValue = Integer.parseInt(tempValue);

            mFanButton.setVisibility(View.GONE);
            mSprinklerButton.setVisibility(View.GONE);
            mNoActionRequiredTextLabel.setVisibility(View.GONE);
            mFanOnTemperatureTextLabel.setVisibility(View.GONE);
            mFanOnTemperatureTextLabel.setVisibility(View.GONE);

            if((tempIntValue > 70) && (tempIntValue < 90)) {
                mFanButton.setVisibility(View.VISIBLE);
                mFanOnTemperatureTextLabel.setVisibility(View.VISIBLE);
            } else if ((tempIntValue > 90) && (tempIntValue < 125)) {
                mSprinklerButton.setVisibility(View.VISIBLE);
                mFanSprinklerTemperatureTextLabel.setVisibility(View.VISIBLE);
            } else {
                mNoActionRequiredTextLabel.setVisibility(View.VISIBLE);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filterReceiver = new IntentFilter();
        filterReceiver.addAction(Util.BROADCAST_ACTION);
        registerReceiver(receiver, filterReceiver);

        mFanButton = (Button)findViewById(R.id.btn_turnFan);
        mSprinklerButton = (Button)findViewById(R.id.btn_turnFanSprinkler);
        mNoActionRequiredTextLabel = (TextView)findViewById(R.id.no_action);
        mFanOnTemperatureTextLabel = (TextView)findViewById(R.id.temp_range);
        mFanSprinklerTemperatureTextLabel = (TextView)findViewById(R.id.temp_range2);

        mState = FanSprinklerState.getInstance();

        mFanButton.setVisibility(View.GONE);
        mSprinklerButton.setVisibility(View.GONE);
        mNoActionRequiredTextLabel.setVisibility(View.GONE);
        mFanOnTemperatureTextLabel.setVisibility(View.GONE);
        mFanSprinklerTemperatureTextLabel.setVisibility(View.GONE);
    }

    public void launchTempHumidityDataGathererActivity(View v){
        Intent myIntent = new Intent(MainActivity.this, TempHumidityDataGatherer.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void turnFan(View v){
        mState.turnFanOn();
        mState.turnSprinklerOff();
        Intent myIntent = new Intent(MainActivity.this, FanSprinklerStateViewer.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void turnFanSprinkler(View v){
        mState.turnFanOn();
        mState.turnSprinklerOn();
        Intent myIntent = new Intent(MainActivity.this, FanSprinklerStateViewer.class);
        MainActivity.this.startActivity(myIntent);
    }


}
