package com.example.digitalhousefoods

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.digitalhousefoods.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val navController = findNavController(R.id.nav_host_fragment)
////my_nav_host defined in activity xml file as id of fragment or FragmentContainerView
//        val appBarConfiguration = AppBarConfiguration(navController.graph)
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }


}