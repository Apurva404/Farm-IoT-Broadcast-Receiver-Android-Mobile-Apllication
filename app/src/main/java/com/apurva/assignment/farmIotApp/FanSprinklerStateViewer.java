package com.apurva.assignment.farmIotApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.apurva.assignment.farmIotApp.util.Util;
import com.apurva.assignment.farmIotApp.util.FanSprinklerState;

public class FanSprinklerStateViewer extends Activity {
    private FanSprinklerState mState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan_sprinkler_state_viewer);

        mState = FanSprinklerState.getInstance();
        Button p1_button = (Button)findViewById(R.id.btn_fanOn);
        Button p2_button = (Button)findViewById(R.id.btn_fanSprinklerOn);

        if(mState.isFanOn()) {
            // set fan label = on
            p1_button.setText(Util.FAN_ON);
        } else {
            // set fan label = off
            p1_button.setText(Util.FAN_OFF);
        }

        if(mState.isSprinklerOn()) {
            // set sprinkler label = on
            p2_button.setText(Util.SPRINKLER_ON);
        } else {
            // set sprinkler label = off
            p2_button.setText(Util.SPRINKLER_OFF);
        }
    }


    // add a close button which will close this actiity and pass the control back to main activity
    public void back(View v) {
        this.finish();
    }
}


