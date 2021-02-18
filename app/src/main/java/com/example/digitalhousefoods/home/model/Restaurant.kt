package com.example.digitalhousefoods.home.model

import android.os.Parcelable
import com.example.digitalhousefoods.dish.Dish
import kotlinx.parcelize.Parcelize

@Parcelize
data class Restaurant(
    val restaurantMenu: List<Dish>,
    val restaurantImage: String,
    val restaurantName: String,
    val restaurantAddress: String,
    val restaurantClosingTime: String,
) : Parcelable