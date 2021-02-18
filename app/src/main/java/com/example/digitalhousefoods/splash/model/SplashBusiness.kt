package com.example.digitalhousefoods.splash.model

class SplashBusiness {

    private val repository by lazy {
        SplashRepository()
    }

    fun getSplashResult(): Splash {
        return repository.getSplashResult()
    }

}