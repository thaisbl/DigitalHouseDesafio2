package com.example.digitalhousefoods.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.digitalhousefoods.databinding.FragmentMenuBinding
import com.example.digitalhousefoods.dish.Dish
import com.example.digitalhousefoods.home.model.Restaurant

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private val args: MenuFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        setUpActionBar()

        val restaurant = args.restaurant
        restaurant?.let { setView(it) }
    }

    private fun setView(restaurant: Restaurant) {
        binding.restaurantName.text = restaurant.restaurantName
        binding.appbarToolbar.title = " "

        Glide.with(this)
            .load(restaurant.restaurantImage)
            .centerCrop()
            .into(binding.ivRestaurantPicture)

        setUpRecyclerView(restaurant.restaurantMenu)
    }

    private fun setUpRecyclerView(dishesList: List<Dish>) {
        binding.rvDishesList.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = MenuAdapter(dishesList) {
                val action = MenuFragmentDirections.actionMenuFragmentToDishFragment(it)
                findNavController().navigate(action)
            }
        }
    }

    private fun setUpActionBar() {
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        binding.appbarToolbar.setupWithNavController(navController, appBarConfiguration)
    }
}