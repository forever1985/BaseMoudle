package com.company.baseproject.http

import com.company.base_library.base.model.BaseModel

/**
 * @Package: com.company.baseproject.http
 * @ClassName: HttpResponse
 * @Description:http model
 * @Author: Chenqiang
 * @CreateDate: 2021/1/21 14:45
 */
public class HttpResponseModel private constructor(): BaseModel() {

    companion object{
        val instance : HttpResponseModel by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            HttpResponseModel()
        }
    }

}