package com.example.digitalhousefoods.dish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.example.digitalhousefoods.databinding.FragmentDishBinding

class DishFragment : Fragment() {

    private lateinit var binding: FragmentDishBinding
    private val args: DishFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDishBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        setUpActionBar()

        val dish = args.dish
        dish?.let { setView(it) }
    }

    private fun setView(dish: Dish) {
        binding.tvDishName.text = dish.itemName
        binding.tvDishDescription.text = dish.itemDescription
        binding.appbarToolbar.title = " "

        Glide.with(this)
            .load(dish.itemImage)
            .centerCrop()
            .into(binding.ivDishPicture)

    }


    private fun setUpActionBar() {
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        binding.appbarToolbar.setupWithNavController(navController, appBarConfiguration)
    }

}