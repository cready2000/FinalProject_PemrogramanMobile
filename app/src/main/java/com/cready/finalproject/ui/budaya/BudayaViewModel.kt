package com.cready.finalproject.ui.budaya

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BudayaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Budaya Fragment"
    }
    val text: LiveData<String> = _text
}