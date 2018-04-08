package com.joshigloballogic.harshit.practice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

public class broadcast extends AppCompatActivity {
    private Switch wifiSwitch;
    private WifiManager wifiManagers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        wifiSwitch =findViewById(R.id.wifi_switch);
        wifiManagers=(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wifiManagers.setWifiEnabled(true);
                    wifiSwitch.setText("WiFi is ON");
                }
                else
                {
                    wifiManagers.setWifiEnabled(false);
                    wifiSwitch.setText("WiFi is OFF");

                }
            }
        });
        if (wifiManagers.isWifiEnabled())
        {
            wifiSwitch.setChecked(true);
            wifiSwitch.setText("Wifi is ON");
        }
        else
        {
            wifiSwitch.setChecked(false);
            wifiSwitch.setText("Wifi is OFF");
        }
    }
    @Override
    protected void onStart()
    {
       super.onStart();
        IntentFilter intentFilter =new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiStateReceiver,intentFilter);
    }
    @Override
    protected  void onStop()
    {
        super.onStop();
        unregisterReceiver(wifiStateReceiver);
    }
    private BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int WifiStateExtra=intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN);
            switch (WifiStateExtra)
            {
                case WifiManager.WIFI_STATE_ENABLED:
                    wifiSwitch.setChecked(true);
                    wifiSwitch.setText("Wifi is ON");
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    wifiSwitch.setChecked(false);
                    wifiSwitch.setText("WiFi is OFF");
                    break;
            }
        }
    };
}
