package com.example.digitalhousefoods.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.digitalhousefoods.home.model.Restaurant
import com.example.digitalhousefoods.home.model.HomeBusiness


class HomeViewModel(application: Application) : AndroidViewModel(application) {

    val onGetRestaurantsListResult: MutableLiveData<List<Restaurant>> = MutableLiveData()

    private val business by lazy {
        HomeBusiness()
    }

    fun getRestaurantsList() {
        val restaurantsList = business.getRestaurantsList()
        onGetRestaurantsListResult.postValue(restaurantsList)
    }

}