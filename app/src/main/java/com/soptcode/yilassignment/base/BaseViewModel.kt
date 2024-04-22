package com.soptcode.yilassignment.base

import androidx.lifecycle.ViewModel
import com.soptcode.yilassignment.utils.RetrofitUtil
import com.soptcode.yilassignment.apiservises.ApiServices

open class BaseViewModel : ViewModel() {

    val apiInterface: ApiServices by lazy {
        RetrofitUtil.apiService()
    }
}