package com.example.simplecounterkotlin.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModels : ViewModel() {

    var _counter :Int = 0

    var counter : MutableLiveData<Int> = MutableLiveData(_counter)

    fun getCounter() : LiveData<Int> = counter

    fun onClickFAB() {

        _counter ++
        counter.postValue(_counter)

    }
    fun onClickReset(){

        _counter = 0
        counter.postValue(_counter)

    }
}