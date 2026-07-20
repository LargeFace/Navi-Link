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


import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.card.MaterialCardView;

public class FeaturesPanelDelegate {
    private final MainActivity activity;

    private SwitchCompat cbAvoidForegroundEnabled;
    private TextView tvAvoidForegroundStatus;
    private MaterialCardView cardAvoidForegroundToggle;

    private SwitchCompat cbCrossMapHideEnabled;
    private TextView tvCrossMapHideStatus;
    private MaterialCardView cardCrossMapHideToggle;

    private SwitchCompat cbHideLaneLineBgEnabled;
    private TextView tvHideLaneLineBgStatus;
    private MaterialCardView cardHideLaneLineBgToggle;

    private SwitchCompat cbClusterMirrorEnabled;
    private TextView tvClusterMirrorStatus;
    private MaterialCardView cardClusterMirrorToggle;

    private MaterialCardView cardClusterDisplaySelect;
    private TextView tvClusterDisplaySelectStatus;
    private TextView btnAdjustClusterPos;

    private MaterialCardView cardHideMainWhenClusterActive;
    private SwitchCompat cbHideMainWhenClusterActive;
    private TextView tvHideMainWhenClusterActiveStatus;

    public FeaturesPanelDelegate(MainActivity activity) {
        this.activity = activity;
    }

    public void initViews() {
        cbAvoidForegroundEnabled = activity.findViewById(R.id.cb_avoid_foreground_enabled);
        tvAvoidForegroundStatus = activity.findViewById(R.id.tv_avoid_foreground_status);
        cardAvoidForegroundToggle = activity.findViewById(R.id.card_avoid_foreground_toggle);

        cbCrossMapHideEnabled = activity.findViewById(R.id.cb_cross_map_hide_enabled);
        tvCrossMapHideStatus = activity.findViewById(R.id.tv_cross_map_hide_status);
        cardCrossMapHideToggle = activity.findViewById(R.id.card_cross_map_hide_toggle);

        cbHideLaneLineBgEnabled = activity.findViewById(R.id.cb_hide_lane_line_bg_enabled);
        tvHideLaneLineBgStatus = activity.findViewById(R.id.tv_hide_lane_line_bg_status);
        cardHideLaneLineBgToggle = activity.findViewById(R.id.card_hide_lane_line_bg_toggle);

        cbClusterMirrorEnabled = activity.findViewById(R.id.cb_cluster_mirror_enabled);
        tvClusterMirrorStatus = activity.findViewById(R.id.tv_cluster_mirror_status);
        cardClusterMirrorToggle = activity.findViewById(R.id.card_cluster_mirror_toggle);

        cardClusterDisplaySelect = activity.findViewById(R.id.card_cluster_display_select);
        tvClusterDisplaySelectStatus = activity.findViewById(R.id.tv_cluster_display_select_status);
        btnAdjustClusterPos = activity.findViewById(R.id.btn_adjust_cluster_pos);

        cardHideMainWhenClusterActive = activity.findViewById(R.id.card_hide_main_when_cluster_active);
        cbHideMainWhenClusterActive = activity.findViewById(R.id.cb_hide_main_when_cluster_active);
        tvHideMainWhenClusterActiveStatus = activity.findViewById(R.id.tv_hide_main_when_cluster_active_status);

        setupListeners();
    }

    private void setupListeners() {
        cbAvoidForegroundEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.avoidForegroundEnabled = isChecked;
            activity.savePreferences();
            if (tvAvoidForegroundStatus != null) {
                tvAvoidForegroundStatus.setText(isChecked ? "高德前台时隐藏悬浮窗" : "前台正常显示浮窗");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.updateFloatingWindowVisibility();
            }
        });
        if (cardAvoidForegroundToggle != null) {
            cardAvoidForegroundToggle.setOnClickListener(v -> cbAvoidForegroundEnabled.toggle());
        }

        cbCrossMapHideEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.crossMapHideEnabled = isChecked;
            activity.savePreferences();
            if (tvCrossMapHideStatus != null) {
                tvCrossMapHideStatus.setText(isChecked ? "路口放大图时隐藏悬浮窗" : "路口放大图时正常显示浮窗");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.updateFloatingWindowVisibility();
            }
        });
        if (cardCrossMapHideToggle != null) {
            cardCrossMapHideToggle.setOnClickListener(v -> cbCrossMapHideEnabled.toggle());
        }

        cbHideLaneLineBgEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.hideLaneLineBg = isChecked;
            activity.savePreferences();
            if (tvHideLaneLineBgStatus != null) {
                tvHideLaneLineBgStatus.setText(isChecked ? "背景已隐藏" : "背景已显示");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.refreshWindow();
            }
        });
        if (cardHideLaneLineBgToggle != null) {
            cardHideLaneLineBgToggle.setOnClickListener(v -> cbHideLaneLineBgEnabled.toggle());
        }

        cbClusterMirrorEnabled.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.clusterMirrorEnabled = isChecked;
            activity.savePreferences();
            if (tvClusterMirrorStatus != null) {
                tvClusterMirrorStatus.setText(isChecked ? "已启用副屏镜像投屏" : "已禁用副屏投屏");
            }
            if (btnAdjustClusterPos != null) {
                btnAdjustClusterPos.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.onClusterMirrorConfigChanged();
            }
        });
        if (cardClusterMirrorToggle != null) {
            cardClusterMirrorToggle.setOnClickListener(v -> cbClusterMirrorEnabled.toggle());
        }

        cbHideMainWhenClusterActive.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity.hideMainWhenClusterActive = isChecked;
            activity.savePreferences();
            if (tvHideMainWhenClusterActiveStatus != null) {
                tvHideMainWhenClusterActiveStatus.setText(isChecked ? "副屏成功显示后自动隐藏主屏悬浮窗" : "已关闭该功能，主副屏同时显示");
            }
            FloatingWindowManager fwm = FloatingWindowManager.getInstance();
            if (fwm != null) {
                fwm.updateFloatingWindowVisibility();
            }
        });
        if (cardHideMainWhenClusterActive != null) {
            cardHideMainWhenClusterActive.setOnClickListener(v -> cbHideMainWhenClusterActive.toggle());
        }

        if (cardClusterDisplaySelect != null) {
            cardClusterDisplaySelect.setOnClickListener(v -> activity.showClusterDisplaySelectionDialog());
        }

        if (btnAdjustClusterPos != null) {
            btnAdjustClusterPos.setOnClickListener(v -> {
                FloatingWindowManager fwm = FloatingWindowManager.getInstance();
                if (fwm == null || !fwm.isClusterMirrorActive()) {
                    Toast.makeText(activity, "副屏投屏未开启，请先开启投屏", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(activity, ClusterPositionActivity.class);
                activity.startActivity(intent);
            });
        }
    }

    public void loadSettings() {
        cbAvoidForegroundEnabled.setChecked(activity.avoidForegroundEnabled);
        if (tvAvoidForegroundStatus != null) {
            tvAvoidForegroundStatus.setText(activity.avoidForegroundEnabled ? "高德前台时隐藏悬浮窗" : "前台正常显示浮窗");
        }

        cbCrossMapHideEnabled.setChecked(activity.crossMapHideEnabled);
        if (tvCrossMapHideStatus != null) {
            tvCrossMapHideStatus.setText(activity.crossMapHideEnabled ? "路口放大图时隐藏悬浮窗" : "路口放大图时正常显示浮窗");
        }

        cbHideLaneLineBgEnabled.setChecked(activity.hideLaneLineBg);
        if (tvHideLaneLineBgStatus != null) {
            tvHideLaneLineBgStatus.setText(activity.hideLaneLineBg ? "背景已隐藏" : "背景已显示");
        }

        cbClusterMirrorEnabled.setChecked(activity.clusterMirrorEnabled);
        if (tvClusterMirrorStatus != null) {
            tvClusterMirrorStatus.setText(activity.clusterMirrorEnabled ? "已启用副屏镜像投屏" : "已禁用副屏投屏");
        }
        if (btnAdjustClusterPos != null) {
            btnAdjustClusterPos.setVisibility(activity.clusterMirrorEnabled ? View.VISIBLE : View.GONE);
        }

        cbHideMainWhenClusterActive.setChecked(activity.hideMainWhenClusterActive);
        if (tvHideMainWhenClusterActiveStatus != null) {
            tvHideMainWhenClusterActiveStatus.setText(activity.hideMainWhenClusterActive ? "副屏成功显示后自动隐藏主屏悬浮窗" : "已关闭该功能，主副屏同时显示");
        }

        updateClusterDisplayStatus();
    }

    public void updateClusterDisplayStatus() {
        if (tvClusterDisplaySelectStatus != null) {
            if (activity.clusterDisplayId == -1) {
                tvClusterDisplaySelectStatus.setText("默认副显示器");
            } else {
                tvClusterDisplaySelectStatus.setText("显示器 ID: " + activity.clusterDisplayId);
            }
        }
    }

    public void updateThemeColors(int accentColor) {
        activity.updateSwitchTheme(cbAvoidForegroundEnabled, accentColor);
        activity.updateSwitchTheme(cbCrossMapHideEnabled, accentColor);
        activity.updateSwitchTheme(cbHideLaneLineBgEnabled, accentColor);
        activity.updateSwitchTheme(cbClusterMirrorEnabled, accentColor);
        activity.updateSwitchTheme(cbHideMainWhenClusterActive, accentColor);
        if (btnAdjustClusterPos != null) {
            btnAdjustClusterPos.setTextColor(accentColor);
        }
    }
}
