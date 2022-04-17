package com.example.livedatabuilderdemo.model

import com.example.livedatabuilderdemo.User
import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUsers(): List<User> {
        delay(8000)
        listOf(
            User(1, "Beto"),
            User(2, "Magno"),
            User(3, "Hawk"),
            User(4, "Garret")
        ).let {
            return it
        }
    }
}