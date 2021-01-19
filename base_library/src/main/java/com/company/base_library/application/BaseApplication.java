package com.company.base_library.application;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.company.base_library.R;
import com.company.base_library.base.AppManager;
import com.company.base_library.utils.ConvertUtils;
import com.company.base_library.utils.ResUtils;
import com.company.base_library.utils.Utils;
import com.company.base_library.widget.SimpleTitleBarBuilder;

/**
 * Created by goldze on 2017/6/15.
 */

public class BaseApplication extends Application {
    private static Application sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        setApplication(this);
        initSimpleTitleBarOptions();
    }

    /**
     * 当主工程没有继承BaseApplication时，可以使用setApplication方法初始化BaseApplication
     *
     * @param application
     */
    public static synchronized void setApplication(@NonNull Application application) {
        sInstance = application;
        //初始化工具类
        Utils.init(application);
        //注册监听每个activity的生命周期,便于堆栈式管理
        application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {

            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                AppManager.getAppManager().addActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                AppManager.getAppManager().removeActivity(activity);
            }
        });
    }

    /**
     * 获得当前app运行的Application
     */
    public static Application getInstance() {
        if (sInstance == null) {
            throw new NullPointerException("please inherit BaseApplication or call setApplication.");
        }
        return sInstance;
    }

    /**
     * 初始化标题栏的参数
     */
    private void initSimpleTitleBarOptions() {
        SimpleTitleBarBuilder.DefaultOptions options = new SimpleTitleBarBuilder.DefaultOptions();

        // 背景
        options.backgroundColor = ResUtils.getColor(R.color.white);
        options.titleBarHeight = getResources().getDimensionPixelSize(R.dimen.dp_48);

        // 左边
        options.leftTextColor = ResUtils.getColor(R.color.black);
        options.leftTextSize = ConvertUtils.px2sp(getResources().getDimensionPixelSize(R.dimen.sp_14));
        options.leftBackDrawable = R.drawable.ic_title_back;

        // 右边
        options.rightTextColor = ResUtils.getColor(R.color.black);
        options.rightTextSize = ConvertUtils.px2sp(getResources().getDimensionPixelSize(R.dimen.sp_14));

        // 标题
        options.titleColor = ResUtils.getColor(R.color.black);
        options.titleSize = ConvertUtils.px2sp(getResources().getDimensionPixelSize(R.dimen.sp_16));

        // 阴影
//        options.shadowHeight = (int) ResUtils.getDimensionPixelSize(R.dimen.top_bar_shadow_height);
//        options.shadowColor = ResUtils.getColor(R.color.top_bar_shadow_color);

        // 6.0一下系统不使用沉浸式状态栏
        options.immersive = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

        SimpleTitleBarBuilder.initDefaultOptions(options);
    }
}
