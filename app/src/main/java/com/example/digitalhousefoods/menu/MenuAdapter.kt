package com.example.digitalhousefoods.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.digitalhousefoods.databinding.ItemMenuCardBinding
import com.example.digitalhousefoods.dish.Dish

class MenuAdapter(
    private val restaurantList: List<Dish>,
    private val onItemClicked: (Dish) -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMenuCardBinding.inflate(layoutInflater, parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(restaurantList[position], onItemClicked)
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    class MenuViewHolder(
        private val binding: ItemMenuCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dish: Dish, onItemClicked: (Dish) -> Unit) = with(binding) {
            restaurantNameCard.text = dish.itemName

            Glide.with(itemView.context)
                .load(dish.itemImage)
                .into(restaurantImageCard)

            restaurantCard.setOnClickListener {
                onItemClicked(dish)
            }
        }
    }
}