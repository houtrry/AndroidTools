package com.houtrry.androidtools.utils;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

/**
 * @author houtrry
 * @version $Rev$
 * @time 2017/11/2 11:00
 * @desc 剪贴板工具
 */

public class ClipboardUtils {

    private static final String TAG = ClipboardUtils.class.getSimpleName();

    /**
     * 复制内容到剪贴板
     *
     * @param context 上下文, 用来获取ClipboardManager
     * @param message 将要复制到剪贴板的内容
     */
    public static void copyToClipboard(Context context, String message) {
        if (context == null || TextUtils.isEmpty(message)) {
            Log.e(TAG, "copyToClipboard: fail, context: " + context + ", message: " + message);
            throw new IllegalArgumentException("copyToClipboard: fail, context: " + context + ", message: " + message);
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboardManager = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            clipboardManager.setText(message);
        } else {
            // 得到剪贴板管理器
            android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, message));
        }
    }
}
