package com.company.baseproject.model

import android.app.Application
import com.company.base_library.application.BaseApplication
import com.company.base_library.base.viewmodel.BaseViewModel
import com.company.baseproject.http.HttpResponseModel
import kotlin.contracts.contract

/**
 *
 * @Package:        com.company.baseproject.model
 * @ClassName:      MainModel
 * @Description:
 * @Author:         Chenqiang
 * @CreateDate:     2021/1/21 14:46
 */
class MainModel(context : Application) : BaseViewModel<HttpResponseModel>(context){

}