package com.example.digitalhousefoods.splash.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.digitalhousefoods.databinding.FragmentSplashBinding
import com.example.digitalhousefoods.splash.viewmodel.SplashViewModel

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    private lateinit var splashViewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        initSplashScreen()
    }

    private fun initSplashScreen() {
        splashViewModel.getSplashScreen()
        splashViewModel.onSplashResult.observe(viewLifecycleOwner, {
            val action = SplashFragmentDirections.actionSplashFragmentToLoginFragment()
            findNavController().navigate(action)
        })
    }

}