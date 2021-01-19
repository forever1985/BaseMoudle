package com.company.base_library.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.base_library.R;
import com.company.base_library.utils.DensityUtils;


/**
 * @Package: cn.makeid.jj_print.widget
 * @ClassName: AppDialogBuilder
 * @Description:
 * @Author: Chenqiang
 * @CreateDate: 2019/12/21 10:10
 */
public class AppDialogBuilder {

    private Context mContext;

    private boolean isShowTitle = true;

    private String title;

    private String content;

    private String leftString;

    private String rightString;

    private int topImageRes = 0;

    private int contentImageRes = 0;

    private boolean showRightClose = false;
    /**
     * 是否外部点击消失
     */
    private boolean isCancelOutSide = true;
    /**
     * 是否点击按钮之后就消失dialog，默认是true
     */
    private boolean isAllDismission = true;
    /**
     * 顶部图片是否距离左边调整，默认调整15
     */
    private boolean isTopMarginLeft = false;
    /**
     * 是否显示关闭按钮
     */
    private boolean isShowCloseImage = false;

    private OnViewClickListener onViewClickListener;

    private OnDialogDismissListener onDialogDismissListener;

    public AppDialogBuilder(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 是否展示头部
     *
     * @param isShowTitle
     * @return
     */
    public AppDialogBuilder isShowTitle(boolean isShowTitle) {
        this.isShowTitle = isShowTitle;
        return this;
    }

    /**
     * 设置 title
     *
     * @param title
     * @return
     */
    public AppDialogBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * 设置 title
     *
     * @return
     */
    public AppDialogBuilder setTitle(int titleRes) {
        this.title = mContext.getString(titleRes);
        return this;
    }

    /**
     * 设置 content
     *
     * @return
     */
    public AppDialogBuilder setContent(int contentRes) {
        this.content = mContext.getString(contentRes);
        return this;
    }

    /**
     * 设置 content
     *
     * @return
     */
    public AppDialogBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    /**
     * 设置 left
     *
     * @return
     */
    public AppDialogBuilder setLeftString(String left) {
        this.leftString = left;
        return this;
    }

    /**
     * 设置 left
     *
     * @return
     */
    public AppDialogBuilder setLeftString(int left) {
        this.leftString = mContext.getString(left);
        return this;
    }

    /**
     * 设置 right
     *
     * @return
     */
    public AppDialogBuilder setRightString(String right) {
        this.rightString = right;
        return this;
    }

    /**
     * 设置 content
     *
     * @return
     */
    public AppDialogBuilder setRightString(int right) {
        this.rightString = mContext.getString(right);
        return this;
    }

    /**
     * 是否可以外部点击消失
     *
     * @param isCancelOutSide
     * @return
     */
    public AppDialogBuilder setCancelOutOutSide(boolean isCancelOutSide) {
        this.isCancelOutSide = isCancelOutSide;
        return this;
    }

    public AppDialogBuilder setAllDismission(boolean allDismission) {
        isAllDismission = allDismission;
        return this;
    }

    public AppDialogBuilder setTopImageRes(int topImageRes) {
        this.topImageRes = topImageRes;
        return this;
    }

    public AppDialogBuilder setContentImageRes(int contentImageRes) {
        this.contentImageRes = contentImageRes;
        return this;
    }

    public AppDialogBuilder setTopMarginLeft(boolean topMarginLeft) {
        isTopMarginLeft = topMarginLeft;
        return this;
    }

    public AppDialogBuilder setShowRightClose(boolean showRightClose) {
        this.showRightClose = showRightClose;
        return this;
    }

    public AppDialogBuilder setShowCloseImage(boolean showCloseImage) {
        isShowCloseImage = showCloseImage;
        return this;
    }

    /**
     * 底部按钮点击监听
     *
     * @param listener
     * @return
     */
    public AppDialogBuilder onViewClickListener(OnViewClickListener listener) {
        this.onViewClickListener = listener;
        return this;
    }

    /**
     * dialog消失监听
     *
     * @param listener
     * @return
     */
    public AppDialogBuilder onDialogDismissListener(OnDialogDismissListener listener) {
        this.onDialogDismissListener = listener;
        return this;
    }

    /**
     * 创建dialog
     *
     * @return
     */
    public PopupDialog build() {
        PopupDialog dialog = new PopupDialog(mContext, R.layout.dialog_update_version_layout, true);

        ImageView imageCenter = dialog.findViewById(R.id.image_center);

        ImageView imageTop = dialog.findViewById(R.id.image_top);

        ImageView imageRight = dialog.findViewById(R.id.image_close_dialog);

        TextView left = dialog.findViewById(R.id.text_left);

        TextView right = dialog.findViewById(R.id.text_right);

        if (!TextUtils.isEmpty(title)) {
            dialog.setText(R.id.text_title, title);
            dialog.setVisibility(R.id.text_title, View.VISIBLE);
        }
        if (isShowTitle) {
            dialog.setVisibility(R.id.text_title, View.VISIBLE);
        } else {
            dialog.setVisibility(R.id.text_title, View.GONE);
        }
        if (!TextUtils.isEmpty(content)) {
            dialog.setText(R.id.text_content, content);
            dialog.setVisibility(R.id.text_content, View.VISIBLE);
        }
        if (!TextUtils.isEmpty(leftString)) {
            dialog.setText(R.id.text_left, leftString);
            dialog.setVisibility(R.id.text_left, View.VISIBLE);
        } else {
            right.setBackgroundResource(R.drawable.shap_dialog_bottom_all);
        }
        if (!TextUtils.isEmpty(rightString)) {
            dialog.setText(R.id.text_right, rightString);
            dialog.setVisibility(R.id.text_right, View.VISIBLE);
        } else {
            left.setBackgroundResource(R.drawable.shap_dialog_bottom_line_all);
        }

        if (isShowCloseImage) {
            dialog.setVisibility(R.id.image_close, View.VISIBLE);
            dialog.setViewClickListener(R.id.image_close,(v)->{
                dialog.dismiss();
            });
        }

        if (topImageRes != 0) {
            dialog.setVisibility(R.id.image_top, View.VISIBLE);
            dialog.setVisibility(R.id.text_space, View.VISIBLE);
            imageTop.setImageResource(topImageRes);
        }

        if (isTopMarginLeft) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageTop.getLayoutParams();
            layoutParams.leftMargin = (int) DensityUtils.dip2px(mContext,15);
            imageTop.setLayoutParams(layoutParams);
        }

        if (contentImageRes != 0) {
            dialog.setVisibility(R.id.image_center, View.VISIBLE);
            imageCenter.setImageResource(contentImageRes);
        }

        right.setOnClickListener((v)->{
            if (onViewClickListener != null) {
                onViewClickListener.onRightClick();

            }
            if (isAllDismission) {
                dialog.dismiss();
            }

        });

        left.setOnClickListener((v)->{
            if (onViewClickListener != null) {
                onViewClickListener.onLeftClick();
            }
            dialog.dismiss();
        });

        dialog.setOnDismissListener(dialog1 -> {
            if (onDialogDismissListener != null) {
                onDialogDismissListener.onDismiss();
            }
            mContext = null;

        });

        if (showRightClose) {
            imageRight.setVisibility(View.VISIBLE);
            imageRight.setOnClickListener((v)->{
                dialog.dismiss();
            });
        }

        if (!isCancelOutSide) {
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
        }
        dialog.getWindow().setWindowAnimations(R.style.DialogShowAnimation);
        return dialog;
    }

    /**
     * 底部按钮点击监听
     */
    public interface OnViewClickListener {
        void onLeftClick();

        void onRightClick();
    }

    /**
     * dialog消失监听
     */
    public interface OnDialogDismissListener {
        void onDismiss();
    }

}
