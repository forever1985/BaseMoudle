package com.company.baseproject.factory

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.company.base_library.application.BaseApplication

/**
 *
 * @Package:        com.company.baseproject.factory
 * @ClassName:      AppViewModelFactory
 * @Description:
 * @Author:         Chenqiang
 * @CreateDate:     2021/1/21 17:07
 */
public class AppViewModelFactory private constructor(var app: Application): ViewModelProvider.NewInstanceFactory() {
    companion object{
        val instances : AppViewModelFactory by lazy(
            mode = LazyThreadSafetyMode.SYNCHRONIZED
        ) {
            AppViewModelFactory(app = BaseApplication.getInstance())
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //使用父类判断子类
        if (AndroidViewModel::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(Application::class.java).newInstance(app)
        }
        return super.create(modelClass)
    }
}