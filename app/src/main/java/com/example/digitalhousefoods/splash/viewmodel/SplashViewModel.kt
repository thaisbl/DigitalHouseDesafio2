package com.example.digitalhousefoods.splash.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.digitalhousefoods.splash.model.Splash
import com.example.digitalhousefoods.splash.model.SplashBusiness
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(application: Application) : AndroidViewModel(application) {

    val onSplashResult: MutableLiveData<Splash> = MutableLiveData()

    private val business by lazy {
        SplashBusiness()
    }

    fun getSplashScreen() {
        viewModelScope.launch {
            delay(2000)
            setSplashResult()
        }
    }

    private fun setSplashResult() {
        onSplashResult.postValue(business.getSplashResult())
    }

}