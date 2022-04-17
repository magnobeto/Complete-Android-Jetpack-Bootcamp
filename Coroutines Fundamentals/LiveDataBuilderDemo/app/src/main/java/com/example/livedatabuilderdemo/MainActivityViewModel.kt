package com.example.livedatabuilderdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.livedatabuilderdemo.model.UserRepository
import kotlinx.coroutines.Dispatchers

class MainActivityViewModel : ViewModel() {

    private val userRepository = UserRepository()
    var users = liveData(Dispatchers.IO) {
        val result = userRepository.getUsers()
        emit(result)
    }
}