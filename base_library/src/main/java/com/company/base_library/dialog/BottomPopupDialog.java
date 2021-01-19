package com.company.base_library.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager.LayoutParams;

import com.company.base_library.R;


/**
 * 底部弹出对话框
 *
 * @author mos
 * @date 2017.02.24
 * @note -
 * -------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @note -
 */
public class BottomPopupDialog extends PopupDialog {

    /**
     * 构造函数
     *
     * @param context 上下文(Activity的Context)
     * @param layoutId 布局id
     * @param dim 是否背景变暗
     */
    public BottomPopupDialog(Context context, int layoutId, boolean dim) {
        super(context, layoutId, (dim ? R.style.FullScreenDialog : R.style.FullScreenDialogTrans));
        initView();
        if (dim) {
            setDimAmount(0.3f);
        }

    }
    /**
     * 构造函数
     *
     * @param context 上下文(Activity的Context)
     * @param layoutId 布局id
     * @param dim 是否背景变暗
     */
    public BottomPopupDialog(Context context, int layoutId, boolean dim, boolean canClick) {
        super(context, layoutId, (dim ? R.style.FullScreenDialog : R.style.FullScreenDialogTrans));
        initView();
        if (dim) {
            setDimAmount(0.3f);
        }
        if (canClick) {
            setCanClick();
        }
    }
    /**
     * 构造函数
     *
     * @param context 上下文(Activity的Context)
     * @param layoutId 布局id
     * @param style 样式
     */
    public BottomPopupDialog(Context context, int layoutId, int style, boolean dim) {
        super(context, layoutId, style);
        initView();
        if (dim) {
            setDimAmount(0.3f);
        }
    }

    /**
     * 构造函数
     *
     * @param context 上下文(Activity的Context)
     * @param layoutId 布局id
     * @param style 样式
     */
    public BottomPopupDialog(Context context, int layoutId, int style) {
        super(context, layoutId, style);
        initView();
        setDimAmount(0.3f);
    }

    public BottomPopupDialog(Context context, View contentView, boolean dim) {
        super(context, contentView, dim);
        initView();
        if (dim) {
            setDimAmount(0.3f);
        }
    }

    /**
     * 初始化View
     */
    private void initView() {
        mWindow.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        mWindow.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        // 默认使用底部弹出效果
        setWindowAnimations(R.style.BottomDialogAnimation);
    }
}
