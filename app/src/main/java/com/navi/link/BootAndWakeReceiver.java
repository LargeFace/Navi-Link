package com.navi.link;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

public class BootAndWakeReceiver extends BroadcastReceiver {
    private static final String TAG = "BootAndWakeReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d(TAG, "onReceive: action = " + action);
        if (action == null) return;

        // 1. 读取自启动设置
        SharedPreferences sp = context.getSharedPreferences(MainActivity.PREFS_NAME, Context.MODE_PRIVATE);
        boolean isAutostartEnabled = sp.getBoolean("is_autostart_enabled", false);
        if (!isAutostartEnabled) {
            Log.d(TAG, "自启动功能已禁用");
            return;
        }

        // 2. 检查悬浮窗权限（无权限则不启动，避免异常或无法绘制）
        if (!Settings.canDrawOverlays(context)) {
            Log.w(TAG, "未授予悬浮窗权限，放弃自启动");
            return;
        }

        // 3. 检查服务是否已经在运行
        FloatingWindowManager manager = FloatingWindowManager.getInstance();
        if (manager != null && manager.isShowing()) {
            Log.d(TAG, "AutoMapService 已经在运行中，忽略此次广播");
            return;
        }

        // 4. 启动 AutoMapService 前台服务
        Log.i(TAG, "触发自启动条件，正在启动 AutoMapService. Action: " + action);
        Intent serviceIntent = new Intent(context, AutoMapService.class);
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(serviceIntent);
            } else {
                context.startService(serviceIntent);
            }
        } catch (Exception e) {
            Log.e(TAG, "启动 AutoMapService 失败: " + e.getMessage(), e);
        }
    }
}
