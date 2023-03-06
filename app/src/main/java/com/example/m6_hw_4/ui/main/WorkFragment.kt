package com.example.m6_hw_4.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.m6_hw_4.databinding.FragmentWorkBinding

class WorkFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentWorkBinding
    private lateinit var adapterWork: AdapterWork


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        binding = FragmentWorkBinding.inflate(LayoutInflater.from(context),container,false)
        adapterWork = AdapterWork()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvWork.adapter = adapterWork
        viewModel.historyClick.observe(viewLifecycleOwner) {
            adapterWork.initList(it)
            Log.d("work", "onViewCreated:${it}")
        }
    }
}