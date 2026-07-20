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

public class MinimalPanelDelegate {
    private final MainActivity activity;

    private MaterialCardView cardMinimalAutocenterToggle;
    private SwitchCompat cbMinimalAutocenterEnabled;

    private MaterialCardView cardMinimalCameraToggle;
    private SwitchCompat cbMinimalCameraEnabled;
    private TextView tvMinimalCameraStatus;

    private MaterialCardView cardMinimalLaneToggle;
    private SwitchCompat cbMinimalLaneEnabled;
    private TextView tvMinimalLaneStatus;

    private MaterialCardView cardMinimalRoadNameToggle;
    private SwitchCompat cbMinimalRoadNameEnabled;
    private TextView tvMinimalRoadNameStatus;

    private MaterialCardView cardMinimalDirectionToggle;
    private SwitchCompat cbMinimalDirectionEnabled;
    private TextView tvMinimalDirectionStatus;

    private MaterialCardView cardMinimalTurnInfoToggle;
    private SwitchCompat cbMinimalTurnInfoEnabled;
    private TextView tvMinimalTurnInfoStatus;

    private MaterialCardView cardMinimalSpeedToggle;
    private SwitchCompat cbMinimalSpeedEnabled;
    private TextView tvMinimalSpeedStatus;

    private MaterialCardView cardMinimalLightCountToggle;
    private SwitchCompat cbMinimalLightCountEnabled;
    private TextView tvMinimalLightCountStatus;

    private MaterialCardView cardMinimalSpeedLimitToggle;
    private SwitchCompat cbMinimalSpeedLimitEnabled;
    private TextView tvMinimalSpeedLimitStatus;

    public MinimalPanelDelegate(MainActivity activity) {
        this.activity = activity;
    }

    public void initViews() {
        cardMinimalAutocenterToggle = activity.findViewById(R.id.card_minimal_autocenter_toggle);
        cbMinimalAutocenterEnabled = activity.findViewById(R.id.cb_minimal_autocenter_enabled);

        cardMinimalCameraToggle = activity.findViewById(R.id.card_minimal_camera_toggle);
        cbMinimalCameraEnabled = activity.findViewById(R.id.cb_minimal_camera_enabled);
        tvMinimalCameraStatus = activity.findViewById(R.id.tv_minimal_camera_status);

        cardMinimalLaneToggle = activity.findViewById(R.id.card_minimal_lane_toggle);
        cbMinimalLaneEnabled = activity.findViewById(R.id.cb_minimal_lane_enabled);
        tvMinimalLaneStatus = activity.findViewById(R.id.tv_minimal_lane_status);

        cardMinimalRoadNameToggle = activity.findViewById(R.id.card_minimal_road_name_toggle);
        cbMinimalRoadNameEnabled = activity.findViewById(R.id.cb_minimal_road_name_enabled);
        tvMinimalRoadNameStatus = activity.findViewById(R.id.tv_minimal_road_name_status);

        cardMinimalDirectionToggle = activity.findViewById(R.id.card_minimal_direction_toggle);
        cbMinimalDirectionEnabled = activity.findViewById(R.id.cb_minimal_direction_enabled);
        tvMinimalDirectionStatus = activity.findViewById(R.id.tv_minimal_direction_status);

        cardMinimalTurnInfoToggle = activity.findViewById(R.id.card_minimal_turn_info_toggle);
        cbMinimalTurnInfoEnabled = activity.findViewById(R.id.cb_minimal_turn_info_enabled);
        tvMinimalTurnInfoStatus = activity.findViewById(R.id.tv_minimal_turn_info_status);

        cardMinimalSpeedToggle = activity.findViewById(R.id.card_minimal_speed_toggle);
        cbMinimalSpeedEnabled = activity.findViewById(R.id.cb_minimal_speed_enabled);
        tvMinimalSpeedStatus = activity.findViewById(R.id.tv_minimal_speed_status);

        cardMinimalLightCountToggle = activity.findViewById(R.id.card_minimal_light_count_toggle);
        cbMinimalLightCountEnabled = activity.findViewById(R.id.cb_minimal_light_count_enabled);
        tvMinimalLightCountStatus = activity.findViewById(R.id.tv_minimal_light_count_status);

        cardMinimalSpeedLimitToggle = activity.findViewById(R.id.card_minimal_speed_limit_toggle);
        cbMinimalSpeedLimitEnabled = activity.findViewById(R.id.cb_minimal_speed_limit_enabled);
        tvMinimalSpeedLimitStatus = activity.findViewById(R.id.tv_minimal_speed_limit_status);

        setupListeners();
    }

    private void setupListeners() {
        cbMinimalAutocenterEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.isMinimalAutocenterEnabled = isChecked;
            activity.savePreferences();
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.setAutoCenteringEnabled(isChecked);
            }
        });
        if (cardMinimalAutocenterToggle != null) {
            cardMinimalAutocenterToggle.setOnClickListener(v -> cbMinimalAutocenterEnabled.toggle());
        }

        cbMinimalCameraEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.isMinimalCameraEnabled = isChecked;
            activity.savePreferences();
            if (tvMinimalCameraStatus != null) {
                tvMinimalCameraStatus.setText(isChecked ? "灵动岛布局显示摄像头距离" : "已关闭灵动岛摄像头显示");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.refreshWindow();
            }
        });
        if (cardMinimalCameraToggle != null) {
            cardMinimalCameraToggle.setOnClickListener(v -> cbMinimalCameraEnabled.toggle());
        }

        cbMinimalLaneEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.minimalLaneEnabled = isChecked;
            activity.savePreferences();
            if (tvMinimalLaneStatus != null) {
                tvMinimalLaneStatus.setText(isChecked ? "车道线已启用" : "车道线已禁用");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.refreshWindow();
            }
        });
        if (cardMinimalLaneToggle != null) {
            cardMinimalLaneToggle.setOnClickListener(v -> cbMinimalLaneEnabled.toggle());
        }

        cbMinimalRoadNameEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.isMinimalRoadNameEnabled = isChecked;
            activity.savePreferences();
            if (tvMinimalRoadNameStatus != null) {
                tvMinimalRoadNameStatus.setText(isChecked ? "道路名称已启用" : "道路名称已禁用");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.refreshWindow();
            }
        });
        if (cardMinimalRoadNameToggle != null) {
            cardMinimalRoadNameToggle.setOnClickListener(v -> cbMinimalRoadNameEnabled.toggle());
        }

        cbMinimalDirectionEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.isMinimalDirectionEnabled = isChecked;
            activity.savePreferences();
            if (tvMinimalDirectionStatus != null) {
                tvMinimalDirectionStatus.setText(isChecked ? "方向显示已启用" : "方向显示已禁用");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.refreshWindow();
            }
        });
        if (cardMinimalDirectionToggle != null) {
            cardMinimalDirectionToggle.setOnClickListener(v -> cbMinimalDirectionEnabled.toggle());
        }

        cbMinimalTurnInfoEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.isMinimalTurnInfoEnabled = isChecked;
            activity.savePreferences();
            if (tvMinimalTurnInfoStatus != null) {
                tvMinimalTurnInfoStatus.setText(isChecked ? "转向信息已启用" : "转向信息已禁用");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.refreshWindow();
            }
        });
        if (cardMinimalTurnInfoToggle != null) {
            cardMinimalTurnInfoToggle.setOnClickListener(v -> cbMinimalTurnInfoEnabled.toggle());
        }

        cbMinimalSpeedEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.isMinimalSpeedEnabled = isChecked;
            activity.savePreferences();
            if (tvMinimalSpeedStatus != null) {
                tvMinimalSpeedStatus.setText(isChecked ? "车速显示已启用" : "车速显示已禁用");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.refreshWindow();
            }
        });
        if (cardMinimalSpeedToggle != null) {
            cardMinimalSpeedToggle.setOnClickListener(v -> cbMinimalSpeedEnabled.toggle());
        }

        cbMinimalLightCountEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.isMinimalLightCountEnabled = isChecked;
            activity.savePreferences();
            if (tvMinimalLightCountStatus != null) {
                tvMinimalLightCountStatus.setText(isChecked ? "红绿灯计数已启用" : "红绿灯计数已禁用");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.refreshWindow();
            }
        });
        if (cardMinimalLightCountToggle != null) {
            cardMinimalLightCountToggle.setOnClickListener(v -> cbMinimalLightCountEnabled.toggle());
        }

        cbMinimalSpeedLimitEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.isMinimalSpeedLimitEnabled = isChecked;
            activity.savePreferences();
            if (tvMinimalSpeedLimitStatus != null) {
                tvMinimalSpeedLimitStatus.setText(isChecked ? "限速显示已启用" : "限速显示已禁用");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.refreshWindow();
            }
        });
        if (cardMinimalSpeedLimitToggle != null) {
            cardMinimalSpeedLimitToggle.setOnClickListener(v -> cbMinimalSpeedLimitEnabled.toggle());
        }
    }

    public void loadSettings() {
        cbMinimalAutocenterEnabled.setChecked(activity.isMinimalAutocenterEnabled);

        cbMinimalCameraEnabled.setChecked(activity.isMinimalCameraEnabled);
        if (tvMinimalCameraStatus != null) {
            tvMinimalCameraStatus.setText(activity.isMinimalCameraEnabled ? "灵动岛布局显示摄像头距离" : "已关闭灵动岛摄像头显示");
        }

        cbMinimalLaneEnabled.setChecked(activity.minimalLaneEnabled);
        if (tvMinimalLaneStatus != null) {
            tvMinimalLaneStatus.setText(activity.minimalLaneEnabled ? "车道线已启用" : "车道线已禁用");
        }

        cbMinimalRoadNameEnabled.setChecked(activity.isMinimalRoadNameEnabled);
        if (tvMinimalRoadNameStatus != null) {
            tvMinimalRoadNameStatus.setText(activity.isMinimalRoadNameEnabled ? "道路名称已启用" : "道路名称已禁用");
        }

        cbMinimalDirectionEnabled.setChecked(activity.isMinimalDirectionEnabled);
        if (tvMinimalDirectionStatus != null) {
            tvMinimalDirectionStatus.setText(activity.isMinimalDirectionEnabled ? "方向显示已启用" : "方向显示已禁用");
        }

        cbMinimalTurnInfoEnabled.setChecked(activity.isMinimalTurnInfoEnabled);
        if (tvMinimalTurnInfoStatus != null) {
            tvMinimalTurnInfoStatus.setText(activity.isMinimalTurnInfoEnabled ? "转向信息已启用" : "转向信息已禁用");
        }

        cbMinimalSpeedEnabled.setChecked(activity.isMinimalSpeedEnabled);
        if (tvMinimalSpeedStatus != null) {
            tvMinimalSpeedStatus.setText(activity.isMinimalSpeedEnabled ? "车速显示已启用" : "车速显示已禁用");
        }

        cbMinimalLightCountEnabled.setChecked(activity.isMinimalLightCountEnabled);
        if (tvMinimalLightCountStatus != null) {
            tvMinimalLightCountStatus.setText(activity.isMinimalLightCountEnabled ? "红绿灯计数已启用" : "红绿灯计数已禁用");
        }

        cbMinimalSpeedLimitEnabled.setChecked(activity.isMinimalSpeedLimitEnabled);
        if (tvMinimalSpeedLimitStatus != null) {
            tvMinimalSpeedLimitStatus.setText(activity.isMinimalSpeedLimitEnabled ? "限速显示已启用" : "限速显示已禁用");
        }
    }

    public void updateThemeColors(int accentColor, android.content.res.ColorStateList accentColorStateList) {
        activity.updateSwitchTheme(cbMinimalAutocenterEnabled, accentColor);
        activity.updateSwitchTheme(cbMinimalCameraEnabled, accentColor);
        activity.updateSwitchTheme(cbMinimalLaneEnabled, accentColor);
        activity.updateSwitchTheme(cbMinimalRoadNameEnabled, accentColor);
        activity.updateSwitchTheme(cbMinimalDirectionEnabled, accentColor);
        activity.updateSwitchTheme(cbMinimalTurnInfoEnabled, accentColor);
        activity.updateSwitchTheme(cbMinimalSpeedEnabled, accentColor);
        activity.updateSwitchTheme(cbMinimalLightCountEnabled, accentColor);
        activity.updateSwitchTheme(cbMinimalSpeedLimitEnabled, accentColor);
    }
}
