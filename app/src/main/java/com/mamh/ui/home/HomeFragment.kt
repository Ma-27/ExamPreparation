package com.mamh.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mamh.R
import com.mamh.database.local.AccountDatabase
import com.mamh.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_home,
                container,
                false
        )

        val application = requireNotNull(this.activity).application
        val accountDao = AccountDatabase.getInstance(application).accountDatabaseDao

        homeViewModel =
                ViewModelProvider(this, HomeViewModelFactory(application, accountDao)).get(HomeViewModel::class.java)


        binding.lifecycleOwner = this
        binding.homeFragmentViewModel = homeViewModel

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textHome.text = it
        })


        return binding.root
    }
}