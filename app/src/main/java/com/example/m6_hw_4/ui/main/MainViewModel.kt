package com.example.m6_hw_4.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var mCounter = 0
    val counter = MutableLiveData<Int>()
    val historyClick = MutableLiveData<ArrayList<String>>()
    private val list = arrayListOf<String>()

    fun onIncrementClick() {
        mCounter++
        list.add ("+")
        historyClick.value = list
        counter.value = mCounter
    }

    fun onDecrementClick() {
        mCounter--
        list.add("-")
        historyClick . value = list
        println(historyClick.value.toString())
        counter.value = mCounter
    }
}