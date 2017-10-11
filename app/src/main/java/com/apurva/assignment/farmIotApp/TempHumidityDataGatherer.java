package com.apurva.assignment.farmIotApp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
import com.apurva.assignment.farmIotApp.util.Util;

public class TempHumidityDataGatherer extends Activity {
    private EditText tempEditText;
    private EditText humidityEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_humidity_data_gatherer);
        tempEditText = (EditText)findViewById(R.id.temp_view);
        humidityEditText =  (EditText)findViewById(R.id.humidity_view);
    }

    public void sendUserInput(View v) {
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(Util.BROADCAST_ACTION);

        String tempValue = tempEditText.getText().toString();
        String humidityValue = humidityEditText.getText().toString();
        broadcastIntent.putExtra(Util.EXTRA_TEMPERATURE, tempValue);
        broadcastIntent.putExtra(Util.EXTRA_HUMIDITY, humidityValue);

        sendBroadcast(broadcastIntent);
        this.finish();
    }

    public void closeActivity(View v) {
        this.finish();

    }
}
