package com.navi.link;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;

public class BootStartReceiver extends BroadcastReceiver {
    private static final String TAG = "BootStartReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        Log.d(TAG, "Received broadcast action: " + action);

        SharedPreferences sp = context.getSharedPreferences("floating_config", Context.MODE_PRIVATE);
        boolean autoStart = sp.getBoolean("auto_start", false);
        if (!autoStart) {
            Log.d(TAG, "Auto-start is disabled in configuration.");
            return;
        }

        // 启动主悬浮窗服务
        Intent serviceIntent = new Intent(context, AutoMapService.class);
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(serviceIntent);
            } else {
                context.startService(serviceIntent);
            }
            Log.d(TAG, "AutoMapService started successfully from boot/ACC event: " + action);
        } catch (Exception e) {
            Log.e(TAG, "Failed to start AutoMapService on boot/ACC", e);
        }
    }
}
