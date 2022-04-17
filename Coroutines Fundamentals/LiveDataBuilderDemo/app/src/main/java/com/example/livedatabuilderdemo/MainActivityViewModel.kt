package com.example.livedatabuilderdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.livedatabuilderdemo.model.UserRepository

class MainActivityViewModel : ViewModel() {

    private val userRepository = UserRepository()
    var users = liveData {
        val result = userRepository.getUsers()
        emit(result)
    }
}