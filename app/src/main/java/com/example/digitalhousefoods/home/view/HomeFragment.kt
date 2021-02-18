package com.example.digitalhousefoods.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalhousefoods.databinding.FragmentHomeBinding
import com.example.digitalhousefoods.home.model.Restaurant
import com.example.digitalhousefoods.home.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.getRestaurantsList()
        setUpObservables()

    }

    private fun setUpObservables() {
        viewModel.onGetRestaurantsListResult.observe(viewLifecycleOwner) {
            it?.let {
                setUpRecyclerView(it)
            }

        }
    }

    private fun setUpRecyclerView(restaurantsList: List<Restaurant>) {
        binding.rvRestaurantList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = HomeAdapter(restaurantsList) {
                val action = HomeFragmentDirections.actionRestaurantListFragmentToMenuFragment(it)
                findNavController().navigate(action)
            }
        }
    }
}