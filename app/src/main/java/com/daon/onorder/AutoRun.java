package com.daon.onorder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AutoRun extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Intent it = new Intent(context, LoginActivity.class);
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(it);
        }
    }
}