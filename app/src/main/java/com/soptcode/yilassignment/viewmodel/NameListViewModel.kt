package com.soptcode.yilassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import com.soptcode.yilassignment.base.BaseViewModel
import com.soptcode.yilassignment.model.NameResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NameListViewModel() : BaseViewModel() {
    val nameListResponse = MutableLiveData<NameResponse>()
    var errorProfile = MutableLiveData<Throwable>()
    var progressProfile = MutableLiveData<Boolean>()

    fun hitNameList(

    ) {
        var dis = apiInterface.getContact(

        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                progressProfile.value = true
            }.doOnTerminate {
                progressProfile.value = false
            }
            .subscribe({
                onSuccess(it)
            },
                {
                    onError(it)
                })
    }

    private fun onSuccess(it: NameResponse) {
        nameListResponse.value = it
    }

    private fun onError(it: Throwable) {
        errorProfile.value = it
    }

}