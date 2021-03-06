package com.thevarungupta.broadcastreceiver.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.thevarungupta.broadcastreceiver.R;
import com.thevarungupta.broadcastreceiver.app.MyApplication;
import com.thevarungupta.broadcastreceiver.receivers.ConnectivityReceiver;

public class MainActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectivityReceiver.setConnectivityReceiverListener(this);
    }


    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showMessage(isConnected);
    }

    private void showMessage(boolean isConnected) {
        if (isConnected) {
            setContentView(R.layout.activity_main);
            Toast.makeText(this, "Good! Connected to Internet", Toast.LENGTH_SHORT).show();
        } else {
            setContentView(R.layout.activity_offline);
            Toast.makeText(this, "Sorry! Not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

}
