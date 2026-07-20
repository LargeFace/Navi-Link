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
import android.widget.Toast;
import com.google.android.material.card.MaterialCardView;

public class ColorSettingsDelegate {
    private final MainActivity activity;

    private View viewColorPreviewBgDay;
    private View viewColorPreviewBgNight;
    private View viewColorPreviewPrimaryDay;
    private View viewColorPreviewPrimaryNight;
    private View viewColorPreviewSecondaryDay;
    private View viewColorPreviewSecondaryNight;
    private View viewColorPreviewHintDay;
    private View viewColorPreviewHintNight;
    private View viewColorPreviewNormalTurnIconDay;
    private View viewColorPreviewNormalTurnIconNight;
    private View viewColorPreviewNormalTurnBgDay;
    private View viewColorPreviewNormalTurnBgNight;
    private View viewColorPreviewFullMiddleBgDay;
    private View viewColorPreviewFullMiddleBgNight;
    private MaterialCardView btnResetColors;

    public ColorSettingsDelegate(MainActivity activity) {
        this.activity = activity;
    }

    public void initViews() {
        viewColorPreviewBgDay = activity.findViewById(R.id.view_color_preview_bg_day);
        viewColorPreviewBgNight = activity.findViewById(R.id.view_color_preview_bg_night);
        viewColorPreviewPrimaryDay = activity.findViewById(R.id.view_color_preview_primary_day);
        viewColorPreviewPrimaryNight = activity.findViewById(R.id.view_color_preview_primary_night);
        viewColorPreviewSecondaryDay = activity.findViewById(R.id.view_color_preview_secondary_day);
        viewColorPreviewSecondaryNight = activity.findViewById(R.id.view_color_preview_secondary_night);
        viewColorPreviewHintDay = activity.findViewById(R.id.view_color_preview_hint_day);
        viewColorPreviewHintNight = activity.findViewById(R.id.view_color_preview_hint_night);
        viewColorPreviewNormalTurnIconDay = activity.findViewById(R.id.view_color_preview_normal_turn_icon_day);
        viewColorPreviewNormalTurnIconNight = activity.findViewById(R.id.view_color_preview_normal_turn_icon_night);
        viewColorPreviewNormalTurnBgDay = activity.findViewById(R.id.view_color_preview_normal_turn_bg_day);
        viewColorPreviewNormalTurnBgNight = activity.findViewById(R.id.view_color_preview_normal_turn_bg_night);
        viewColorPreviewFullMiddleBgDay = activity.findViewById(R.id.view_color_preview_full_middle_bg_day);
        viewColorPreviewFullMiddleBgNight = activity.findViewById(R.id.view_color_preview_full_middle_bg_night);
        btnResetColors = activity.findViewById(R.id.btn_reset_colors);

        setupListeners();
    }

    private void setupListeners() {
        if (viewColorPreviewBgDay != null) {
            viewColorPreviewBgDay.setOnClickListener(v -> activity.showColorPickerDialog("白天背景色", activity.bgColorDay, color -> {
                activity.bgColorDay = color;
                activity.updateColorPreview(viewColorPreviewBgDay, color);
                activity.savePreferences();
                activity.refreshFloatingWindow();
            }));
        }
        if (viewColorPreviewBgNight != null) {
            viewColorPreviewBgNight.setOnClickListener(v -> activity.showColorPickerDialog("夜间背景色", activity.bgColorNight, color -> {
                activity.bgColorNight = color;
                activity.updateColorPreview(viewColorPreviewBgNight, color);
                activity.savePreferences();
                activity.refreshFloatingWindow();
            }));
        }
        if (viewColorPreviewPrimaryDay != null) {
            viewColorPreviewPrimaryDay.setOnClickListener(v -> activity.showColorPickerDialog("白天主文字颜色", activity.textPrimaryDay, color -> {
                activity.textPrimaryDay = color;
                activity.updateColorPreview(viewColorPreviewPrimaryDay, color);
                activity.savePreferences();
                activity.refreshFloatingWindow();
            }));
        }
        if (viewColorPreviewPrimaryNight != null) {
            viewColorPreviewPrimaryNight.setOnClickListener(v -> activity.showColorPickerDialog("夜间主文字颜色", activity.textPrimaryNight, color -> {
                activity.textPrimaryNight = color;
                activity.updateColorPreview(viewColorPreviewPrimaryNight, color);
                activity.savePreferences();
                activity.refreshFloatingWindow();
            }));
        }
        if (viewColorPreviewSecondaryDay != null) {
            viewColorPreviewSecondaryDay.setOnClickListener(v -> activity.showColorPickerDialog("白天次文字颜色", activity.textSecondaryDay, color -> {
                activity.textSecondaryDay = color;
                activity.updateColorPreview(viewColorPreviewSecondaryDay, color);
                activity.savePreferences();
                activity.refreshFloatingWindow();
            }));
        }
        if (viewColorPreviewSecondaryNight != null) {
            viewColorPreviewSecondaryNight.setOnClickListener(v -> activity.showColorPickerDialog("夜间次文字颜色", activity.textSecondaryNight, color -> {
                activity.textSecondaryNight = color;
                activity.updateColorPreview(viewColorPreviewSecondaryNight, color);
                activity.savePreferences();
                activity.refreshFloatingWindow();
            }));
        }
        if (viewColorPreviewHintDay != null) {
            viewColorPreviewHintDay.setOnClickListener(v -> activity.showColorPickerDialog("白天提示文字颜色", activity.textHintDay, color -> {
                activity.textHintDay = color;
                activity.updateColorPreview(viewColorPreviewHintDay, color);
                activity.savePreferences();
                activity.refreshFloatingWindow();
            }));
        }
        if (viewColorPreviewHintNight != null) {
            viewColorPreviewHintNight.setOnClickListener(v -> activity.showColorPickerDialog("夜间提示文字颜色", activity.textHintNight, color -> {
                activity.textHintNight = color;
                activity.updateColorPreview(viewColorPreviewHintNight, color);
                activity.savePreferences();
                activity.refreshFloatingWindow();
            }));
        }

        if (viewColorPreviewNormalTurnIconDay != null) {
            viewColorPreviewNormalTurnIconDay.setOnClickListener(v -> activity.showColorPickerDialog("常规转向图标白天颜色", activity.normalTurnIconColorDay, color -> {
                activity.normalTurnIconColorDay = color;
                activity.updateColorPreview(viewColorPreviewNormalTurnIconDay, color);
                activity.savePreferences();
                activity.refreshFloatingWindow();
            }));
        }
        if (viewColorPreviewNormalTurnIconNight != null) {
            viewColorPreviewNormalTurnIconNight.setOnClickListener(v -> activity.showColorPickerDialog("常规转向图标夜间颜色", activity.normalTurnIconColorNight, color -> {
                activity.normalTurnIconColorNight = color;
                activity.updateColorPreview(viewColorPreviewNormalTurnIconNight, color);
                activity.savePreferences();
                activity.refreshFloatingWindow();
            }));
        }
        if (viewColorPreviewNormalTurnBgDay != null) {
            viewColorPreviewNormalTurnBgDay.setOnClickListener(v -> activity.showColorPickerDialog("常规转向背景白天颜色", activity.normalTurnIconBgColorDay, color -> {
                activity.normalTurnIconBgColorDay = color;
                activity.updateColorPreview(viewColorPreviewNormalTurnBgDay, color);
                activity.savePreferences();
                activity.refreshFloatingWindow();
            }));
        }
        if (viewColorPreviewNormalTurnBgNight != null) {
            viewColorPreviewNormalTurnBgNight.setOnClickListener(v -> activity.showColorPickerDialog("常规转向背景夜间颜色", activity.normalTurnIconBgColorNight, color -> {
                activity.normalTurnIconBgColorNight = color;
                activity.updateColorPreview(viewColorPreviewNormalTurnBgNight, color);
                activity.savePreferences();
                activity.refreshFloatingWindow();
            }));
        }
        if (viewColorPreviewFullMiddleBgDay != null) {
            viewColorPreviewFullMiddleBgDay.setOnClickListener(v -> activity.showColorPickerDialog("全数据卡片白天背景", activity.fullMiddleBgColorDay, color -> {
                activity.fullMiddleBgColorDay = color;
                activity.updateColorPreview(viewColorPreviewFullMiddleBgDay, color);
                activity.savePreferences();
                activity.refreshFloatingWindow();
            }));
        }
        if (viewColorPreviewFullMiddleBgNight != null) {
            viewColorPreviewFullMiddleBgNight.setOnClickListener(v -> activity.showColorPickerDialog("全数据卡片夜间背景", activity.fullMiddleBgColorNight, color -> {
                activity.fullMiddleBgColorNight = color;
                activity.updateColorPreview(viewColorPreviewFullMiddleBgNight, color);
                activity.savePreferences();
                activity.refreshFloatingWindow();
            }));
        }

        if (btnResetColors != null) {
            btnResetColors.setOnClickListener(v -> new android.app.AlertDialog.Builder(activity)
                    .setTitle("提示")
                    .setMessage("确定要将所有色调配置恢复为默认吗？")
                    .setNegativeButton("取消", null)
                    .setPositiveButton("确定", (dialog, which) -> {
                        activity.resetToDefaultColors();
                        activity.savePreferences();
                        activity.refreshFloatingWindow();
                        Toast.makeText(activity, "已恢复默认颜色配置", Toast.LENGTH_SHORT).show();
                    }).show());
        }
    }

    public void loadSettings() {
        updateColorPreviews();
    }

    public void updateColorPreviews() {
        activity.updateColorPreview(viewColorPreviewBgDay, activity.bgColorDay);
        activity.updateColorPreview(viewColorPreviewBgNight, activity.bgColorNight);
        activity.updateColorPreview(viewColorPreviewPrimaryDay, activity.textPrimaryDay);
        activity.updateColorPreview(viewColorPreviewPrimaryNight, activity.textPrimaryNight);
        activity.updateColorPreview(viewColorPreviewSecondaryDay, activity.textSecondaryDay);
        activity.updateColorPreview(viewColorPreviewSecondaryNight, activity.textSecondaryNight);
        activity.updateColorPreview(viewColorPreviewHintDay, activity.textHintDay);
        activity.updateColorPreview(viewColorPreviewHintNight, activity.textHintNight);
        activity.updateColorPreview(viewColorPreviewNormalTurnIconDay, activity.normalTurnIconColorDay);
        activity.updateColorPreview(viewColorPreviewNormalTurnIconNight, activity.normalTurnIconColorNight);
        activity.updateColorPreview(viewColorPreviewNormalTurnBgDay, activity.normalTurnIconBgColorDay);
        activity.updateColorPreview(viewColorPreviewNormalTurnBgNight, activity.normalTurnIconBgColorNight);
        activity.updateColorPreview(viewColorPreviewFullMiddleBgDay, activity.fullMiddleBgColorDay);
        activity.updateColorPreview(viewColorPreviewFullMiddleBgNight, activity.fullMiddleBgColorNight);
    }
}
