package com.example.roomdemo1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdemo1.db.Subscriber
import com.example.roomdemo1.db.SubscriberRepository
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val subscribers = repository.subscribers

    val inputName = MutableLiveData<String?>()
    val inputEmail = MutableLiveData<String?>()
    val saveOrUpdateBtnTxt = MutableLiveData<String>()
    val clearAllOrDeleteBtnTxt = MutableLiveData<String>()

    init {
        saveOrUpdateBtnTxt.value = SAVE
        clearAllOrDeleteBtnTxt.value = CLEAR_ALL
    }

    fun saveOrUpdate() {
        val name = inputName.value!!
        val email = inputEmail.value!!
        insert(Subscriber(0, name, email))
        inputName.value = null
        inputEmail.value = null
    }

    fun clearAllOrDelete() {
        clearAll()
    }

    fun insert(subscriber: Subscriber) =
        viewModelScope.launch {
            repository.insert(subscriber)
        }

    fun update(subscriber: Subscriber) =
        viewModelScope.launch {
            repository.update(subscriber)
        }

    fun delete(subscriber: Subscriber) =
        viewModelScope.launch {
            repository.delete(subscriber)
        }

    private fun clearAll() =
        viewModelScope.launch {
            repository.deleteAll()
        }

    companion object {
        private const val SAVE = "Save"
        private const val CLEAR_ALL = "Clear All"
    }
}