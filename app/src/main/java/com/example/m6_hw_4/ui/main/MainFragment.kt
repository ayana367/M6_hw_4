package com.example.m6_hw_4.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.m6_hw_4.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapterViewPager: AdapterViewPager
    private val fragList = arrayListOf(CounterFragment(), ResultFragment(), WorkFragment())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        adapterViewPager = AdapterViewPager(requireActivity(),fragList)
        binding = FragmentMainBinding.inflate(LayoutInflater.from(context),container,false)
        initView()
        return binding.root
    }

    private fun initView() {
        binding.vpFrag.adapter = adapterViewPager
        binding.dotsIndicator.attachTo(binding.vpFrag)
    }

}