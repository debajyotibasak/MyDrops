package com.deboxtream.mydrops.recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.deboxtream.mydrops.extras.Util;

public class BootReciever extends BroadcastReceiver {
    public BootReciever() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Util.scheduleAlarm(context);
    }
}
