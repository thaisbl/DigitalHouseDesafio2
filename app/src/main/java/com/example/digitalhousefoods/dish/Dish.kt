package com.example.digitalhousefoods.dish

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dish(
    val itemImage: String,
    val itemName: String,
    val itemDescription: String
) : Parcelable