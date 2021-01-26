package com.company.baseproject

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.company.base_library.base.activity.BaseBindingActivity
import com.company.base_library.dialog.AppDialogBuilder
import com.company.base_library.utils.ToastUtils
import com.company.baseproject.databinding.ActivityMainBinding
import com.company.baseproject.factory.AppViewModelFactory
import com.company.baseproject.model.MainModel

class MainActivity : BaseBindingActivity<ActivityMainBinding,MainModel>() {

    override fun getTitleRes(): Int {
        return R.string.lb_guidedaction_continue_title
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main
    }

    override fun initVariableId(): Int {
        return 0
    }

    override fun initData() {

    }

    override fun initViewObservable() {
        binding.textDialog.setOnClickListener {
            AppDialogBuilder(this)
                .isShowTitle(false)
                .setContent("测试")
                .setLeftString("取消")
                .setRightString("确定")
                .onViewClickListener(object  : AppDialogBuilder.OnViewClickListener {
                    override fun onLeftClick() {
                        ToastUtils.showShortSafe("left click")
                    }

                    override fun onRightClick() {
                        ToastUtils.showShortSafe("right click")
                    }

                })
                .build()
                .show()
        }
    }

    override fun initViewModel(): MainModel? {
        return ViewModelProvider(this,AppViewModelFactory.instances).get(MainModel::class.java)
    }
}