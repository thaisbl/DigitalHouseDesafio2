package com.example.digitalhousefoods.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.digitalhousefoods.home.model.Restaurant
import com.example.digitalhousefoods.databinding.ItemRestaurantCardBinding

class HomeAdapter(
    private val restaurantList: List<Restaurant>,
    private val onItemClicked: (Restaurant) -> Unit
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRestaurantCardBinding.inflate(layoutInflater, parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(restaurantList[position], onItemClicked)
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    class HomeViewHolder(
        private val binding: ItemRestaurantCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurant: Restaurant, onItemClicked: (Restaurant) -> Unit) = with(binding) {
            restaurantNameCard.text = restaurant.restaurantName
            restaurantAdressCard.text = restaurant.restaurantAddress
            restaurantClosingTimeCard.text = restaurant.restaurantClosingTime

            Glide.with(itemView.context)
                .load(restaurant.restaurantImage)
                .centerCrop()
                .into(restaurantImageCard)

            restaurantCard.setOnClickListener {
                onItemClicked(restaurant)
            }
        }
    }
}