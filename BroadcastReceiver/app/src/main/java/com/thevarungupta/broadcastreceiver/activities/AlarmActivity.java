package com.thevarungupta.broadcastreceiver.activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thevarungupta.broadcastreceiver.receivers.MyAlarmReceiver;
import com.thevarungupta.broadcastreceiver.R;

public class AlarmActivity extends AppCompatActivity {

    EditText editTime;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        editTime = findViewById(R.id.edit_time);
        startButton = findViewById(R.id.button_start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = Integer.parseInt(editTime.getText().toString());
                Intent intent = new Intent(AlarmActivity.this, MyAlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmActivity.this,
                        234324243, intent, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +
                        (i * 1000), pendingIntent);

                Toast.makeText(AlarmActivity.this, "Alarm set in " + i + " seconds",
                        Toast.LENGTH_LONG).show();
            }
        });

    }


}
