package com.navi.link.delegate;
import com.navi.link.R;
import com.navi.link.BuildConfig;
import com.navi.link.activity.*;
import com.navi.link.delegate.*;
import com.navi.link.window.*;
import com.navi.link.view.*;
import com.navi.link.receiver.*;
import com.navi.link.service.*;
import com.navi.link.utils.*;


import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.card.MaterialCardView;

public class NormalPanelDelegate {
    private final MainActivity activity;

    private SwitchCompat cbNormalLaneEnabled;
    private TextView tvNormalLaneStatus;
    private MaterialCardView cardNormalLaneToggle;

    private SwitchCompat cbHideTurnIconBg;
    private TextView tvHideTurnIconBgStatus;
    private MaterialCardView cardHideTurnIconBgToggle;

    private SwitchCompat cbNormalCruiseInfoEnabled;
    private TextView tvNormalCruiseInfoStatus;
    private MaterialCardView cardNormalCruiseInfoToggle;

    private SwitchCompat cbHideNormalCruiseSpeedEnabled;
    private TextView tvHideNormalCruiseSpeedStatus;
    private MaterialCardView cardHideNormalCruiseSpeedToggle;

    private SwitchCompat cbNormalTmcEnabled;
    private TextView tvNormalTmcStatus;
    private MaterialCardView cardNormalTmcToggle;

    private SwitchCompat cbNormalBottomInfoEnabled;
    private TextView tvNormalBottomInfoStatus;
    private MaterialCardView cardNormalBottomInfoToggle;

    public NormalPanelDelegate(MainActivity activity) {
        this.activity = activity;
    }

    public void initViews() {
        cbNormalLaneEnabled = activity.findViewById(R.id.cb_normal_lane_enabled);
        tvNormalLaneStatus = activity.findViewById(R.id.tv_normal_lane_status);
        cardNormalLaneToggle = activity.findViewById(R.id.card_normal_lane_toggle);

        cbHideTurnIconBg = activity.findViewById(R.id.cb_hide_turn_icon_bg);
        tvHideTurnIconBgStatus = activity.findViewById(R.id.tv_hide_turn_icon_bg_status);
        cardHideTurnIconBgToggle = activity.findViewById(R.id.card_hide_turn_icon_bg_toggle);

        cbNormalCruiseInfoEnabled = activity.findViewById(R.id.cb_normal_cruise_info_enabled);
        tvNormalCruiseInfoStatus = activity.findViewById(R.id.tv_normal_cruise_info_status);
        cardNormalCruiseInfoToggle = activity.findViewById(R.id.card_normal_cruise_info_toggle);

        cbHideNormalCruiseSpeedEnabled = activity.findViewById(R.id.cb_hide_normal_cruise_speed_enabled);
        tvHideNormalCruiseSpeedStatus = activity.findViewById(R.id.tv_hide_normal_cruise_speed_status);
        cardHideNormalCruiseSpeedToggle = activity.findViewById(R.id.card_hide_normal_cruise_speed_toggle);

        cbNormalTmcEnabled = activity.findViewById(R.id.cb_normal_tmc_enabled);
        tvNormalTmcStatus = activity.findViewById(R.id.tv_normal_tmc_status);
        cardNormalTmcToggle = activity.findViewById(R.id.card_normal_tmc_toggle);

        cbNormalBottomInfoEnabled = activity.findViewById(R.id.cb_normal_bottom_info_enabled);
        tvNormalBottomInfoStatus = activity.findViewById(R.id.tv_normal_bottom_info_status);
        cardNormalBottomInfoToggle = activity.findViewById(R.id.card_normal_bottom_info_toggle);

        setupListeners();
    }

    private void setupListeners() {
        cbNormalLaneEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.normalLaneEnabled = isChecked;
            activity.savePreferences();
            if (tvNormalLaneStatus != null) {
                tvNormalLaneStatus.setText(isChecked ? "车道线已启用" : "车道线已禁用");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.refreshWindow();
            }
        });
        if (cardNormalLaneToggle != null) {
            cardNormalLaneToggle.setOnClickListener(v -> cbNormalLaneEnabled.toggle());
        }

        cbHideTurnIconBg.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.hideTurnIconBg = isChecked;
            activity.savePreferences();
            if (tvHideTurnIconBgStatus != null) {
                tvHideTurnIconBgStatus.setText(isChecked ? "背景已隐藏" : "背景已显示");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.refreshWindow();
            }
        });
        if (cardHideTurnIconBgToggle != null) {
            cardHideTurnIconBgToggle.setOnClickListener(v -> cbHideTurnIconBg.toggle());
        }

        cbNormalCruiseInfoEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.normalCruiseInfoEnabled = isChecked;
            activity.savePreferences();
            if (tvNormalCruiseInfoStatus != null) {
                tvNormalCruiseInfoStatus.setText(isChecked ? "第一排图文信息已启用" : "第一排图文信息已禁用");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.refreshWindow();
            }
        });
        if (cardNormalCruiseInfoToggle != null) {
            cardNormalCruiseInfoToggle.setOnClickListener(v -> cbNormalCruiseInfoEnabled.toggle());
        }

        cbHideNormalCruiseSpeedEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.hideNormalCruiseSpeed = isChecked;
            activity.savePreferences();
            if (tvHideNormalCruiseSpeedStatus != null) {
                tvHideNormalCruiseSpeedStatus.setText(isChecked ? "已隐藏常规巡航车速" : "常规巡航时显示车速");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.refreshWindow();
            }
        });
        if (cardHideNormalCruiseSpeedToggle != null) {
            cardHideNormalCruiseSpeedToggle.setOnClickListener(v -> cbHideNormalCruiseSpeedEnabled.toggle());
        }

        cbNormalTmcEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.normalTmcEnabled = isChecked;
            activity.savePreferences();
            if (tvNormalTmcStatus != null) {
                tvNormalTmcStatus.setText(isChecked ? "TMC路况进度条已启用" : "TMC路况进度条已禁用");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.refreshWindow();
            }
        });
        if (cardNormalTmcToggle != null) {
            cardNormalTmcToggle.setOnClickListener(v -> cbNormalTmcEnabled.toggle());
        }

        cbNormalBottomInfoEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.normalBottomInfoEnabled = isChecked;
            activity.savePreferences();
            if (tvNormalBottomInfoStatus != null) {
                tvNormalBottomInfoStatus.setText(isChecked ? "底栏到达信息已启用" : "底栏到达信息已禁用");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.refreshWindow();
            }
        });
        if (cardNormalBottomInfoToggle != null) {
            cardNormalBottomInfoToggle.setOnClickListener(v -> cbNormalBottomInfoEnabled.toggle());
        }
    }

    public void loadSettings() {
        cbNormalLaneEnabled.setChecked(activity.normalLaneEnabled);
        if (tvNormalLaneStatus != null) {
            tvNormalLaneStatus.setText(activity.normalLaneEnabled ? "车道线已启用" : "车道线已禁用");
        }

        cbHideTurnIconBg.setChecked(activity.hideTurnIconBg);
        if (tvHideTurnIconBgStatus != null) {
            tvHideTurnIconBgStatus.setText(activity.hideTurnIconBg ? "背景已隐藏" : "背景已显示");
        }

        cbNormalCruiseInfoEnabled.setChecked(activity.normalCruiseInfoEnabled);
        if (tvNormalCruiseInfoStatus != null) {
            tvNormalCruiseInfoStatus.setText(activity.normalCruiseInfoEnabled ? "第一排图文信息已启用" : "第一排图文信息已禁用");
        }

        cbHideNormalCruiseSpeedEnabled.setChecked(activity.hideNormalCruiseSpeed);
        if (tvHideNormalCruiseSpeedStatus != null) {
            tvHideNormalCruiseSpeedStatus.setText(activity.hideNormalCruiseSpeed ? "已隐藏常规巡航车速" : "常规巡航时显示车速");
        }

        cbNormalTmcEnabled.setChecked(activity.normalTmcEnabled);
        if (tvNormalTmcStatus != null) {
            tvNormalTmcStatus.setText(activity.normalTmcEnabled ? "TMC路况进度条已启用" : "TMC路况进度条已禁用");
        }

        cbNormalBottomInfoEnabled.setChecked(activity.normalBottomInfoEnabled);
        if (tvNormalBottomInfoStatus != null) {
            tvNormalBottomInfoStatus.setText(activity.normalBottomInfoEnabled ? "底栏到达信息已启用" : "底栏到达信息已禁用");
        }
    }

    public void updateThemeColors(int accentColor) {
        activity.updateSwitchTheme(cbNormalLaneEnabled, accentColor);
        activity.updateSwitchTheme(cbHideTurnIconBg, accentColor);
        activity.updateSwitchTheme(cbNormalCruiseInfoEnabled, accentColor);
        activity.updateSwitchTheme(cbHideNormalCruiseSpeedEnabled, accentColor);
        activity.updateSwitchTheme(cbNormalTmcEnabled, accentColor);
        activity.updateSwitchTheme(cbNormalBottomInfoEnabled, accentColor);
    }
}
