package com.example.digitalhousefoods.home.model

class HomeBusiness {

    private val repository by lazy {
        HomeRepository()
    }

    fun getRestaurantsList(): List<Restaurant> {
        return repository.getRestaurantsList()
    }

}