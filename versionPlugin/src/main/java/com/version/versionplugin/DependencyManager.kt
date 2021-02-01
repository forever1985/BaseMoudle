package com.version.versionplugin

/**
 *
 * @Package=        com.version.versionplugin
 * @ClassName=      DependencyManager
 * @Description=    管理使用的三方插件
 * @Author=         Chenqiang
 * @CreateDate=     2021/1/22 13=54
 */
object BuildVersion {
    const val compileSdkVersion = 30
    const val buildToolsVersion = "29.0.3"
    const val minSdkVersion     = 21
    const val targetSdkVersion  = 30
    const val versionCode       = 5
    const val versionName       = "1.4.0"
}

object BuildConfig {
    private const val supportVersion     = "1.2.0-alpha03"
    private const val junitVersion       = "4.12"
    private const val dataBindingVersion = "4.0.0"
    private const val rxBindingVersion   = "4.0.0"
    private const val retrofitVersion    = "2.9.0"
    private const val glideVersion       = "4.11.0"
    private const val rxLifecycleVersion = "4.0.2"
    private const val lifecycleVersion   = "2.2.0"

    //support
    const val supportV4                            = "androidx.legacy:legacy-support-v4:1.0.0"
    const val supportV7                            = "androidx.appcompat:appcompat:$supportVersion"
    const val recyclerviewV7                       = "androidx.recyclerview:recyclerview:$supportVersion"
    const val supportV13                           = "androidx.legacy:legacy-support-v13:$supportVersion"
    const val supportFragment                      = "androidx.fragment:fragment:$supportVersion"
    const val design                               = "com.google.android.material:material:1.0.0"
    const val animatedVectorDrawable               = "androidx.vectordrawable:vectordrawable-animated:$supportVersion"
    const val junit                                = "junit:junit:$junitVersion"
    //rxjava
    const val rxjava                               = "io.reactivex.rxjava3:rxjava:3.0.8"
    const val rxandroid                            = "io.reactivex.rxjava3:rxandroid:3.0.0"
    //rx系列与View生命周期同步
    const val rxlifecycle                          = "com.trello.rxlifecycle4:rxlifecycle-android:$rxLifecycleVersion"
    const val rxlifecycleComponents                = "com.trello.rxlifecycle4:rxlifecycle-components:$rxLifecycleVersion"
    //rxbinding
    const val rxbinding                            = "com.jakewharton.rxbinding4:rxbinding:$rxBindingVersion"
    const val rxbindingCore                        = "com.jakewharton.rxbinding4:rxbinding-core:$rxBindingVersion"
    const val rxbindingAppcompat                   = "com.jakewharton.rxbinding4:rxbinding-appcompat:$rxBindingVersion"
    const val rxbindingDrawerLayout                = "com.jakewharton.rxbinding4:rxbinding-drawerlayout:$rxBindingVersion"
    const val rxbindingLeanBack                    = "com.jakewharton.rxbinding4:rxbinding-leanback:$rxBindingVersion"
    const val rxbindingRecyclerview                = "com.jakewharton.rxbinding4:rxbinding-recyclerview:$rxBindingVersion"
    const val rxbindingSlidingpanelayout           = "com.jakewharton.rxbinding4:rxbinding-slidingpanelayout:$rxBindingVersion"
    const val rxbindingSwiperefreshlayout          = "com.jakewharton.rxbinding4:rxbinding-swiperefreshlayout:$rxBindingVersion"
    const val rxbindingViewpager                   = "com.jakewharton.rxbinding4:rxbinding-viewpager:$rxBindingVersion"
    const val rxbindingViewpager2                  = "com.jakewharton.rxbinding4:rxbinding-viewpager2:$rxBindingVersion"
    //rx 6.0权限请求
    const val rxpermissions                        = "com.github.tbruyelle:rxpermissions:0.12"
    //network
    const val okhttp                               = "com.squareup.okhttp3:okhttp:4.9.0"
    const val retrofit                             = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val converterGson                        = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    const val adapterRxjava                        = "com.squareup.retrofit2:adapter-rxjava3:$retrofitVersion"
    //glide图片加载
    const val glide                                = "com.github.bumptech.glide:glide:$glideVersion"
    const val glideCompiler                        = "com.github.bumptech.glide:compiler:$glideVersion"
    //json解析
    const val gson                                 = "com.google.code.gson:gson:2.8.6"
    //material-dialogs
    const val materialDialogsCore                  = "com.afollestad.material-dialogs:core:3.3.0"
    //recyclerview的databinding套装
    const val bindingcollectionadapter             = "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter:$dataBindingVersion"
    const val bindingcollectionadapterRecyclerview = "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter-recyclerview:$dataBindingVersion"
    const val bindingcollectionadapterViewpager2   = "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter-viewpager2:$dataBindingVersion"
    //Google AAC
    const val lifecycleExtensions                  = "androidx.lifecycle:lifecycle-extensions:$lifecycleVersion"
    const val lifecycleCompiler                    = "androidx.lifecycle:lifecycle-compiler:$lifecycleVersion"
    //statusBar
    const val statusBar                            = "com.jaeger.statusbarutil:library:1.5.1"
    //multidex 65535
    const val multiDex                             = "androidx.multidex:multidex:2.0.1"
    const val multiDexInstrumentation              = "androidx.multidex:multidex-instrumentation:2.0.0"
}