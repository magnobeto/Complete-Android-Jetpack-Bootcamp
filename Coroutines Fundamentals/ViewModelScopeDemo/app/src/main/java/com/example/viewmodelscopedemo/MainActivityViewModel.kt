package com.example.viewmodelscopedemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodelscopedemo.model.UserRepository
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val userRepository = UserRepository()

    fun getUserData(){
        viewModelScope.launch {
            //write some code
        }
    }
}