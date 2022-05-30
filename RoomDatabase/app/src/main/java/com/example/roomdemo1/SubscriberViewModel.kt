package com.example.roomdemo1

import androidx.lifecycle.*
import com.example.roomdemo1.db.Subscriber
import com.example.roomdemo1.db.SubscriberRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val subscribers = getSaveSubscribers()
    private var isUpdateOrDelete = false
    private lateinit var subscriberToUpdateOrDelete: Subscriber

    val inputName = MutableLiveData<String?>()
    val inputEmail = MutableLiveData<String?>()
    val saveOrUpdateBtnTxt = MutableLiveData<String>()
    val clearAllOrDeleteBtnTxt = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()

    val message: LiveData<Event<String>> get() = statusMessage

    init {
        saveOrUpdateBtnTxt.value = SAVE
        clearAllOrDeleteBtnTxt.value = CLEAR_ALL
    }

    fun initUpdateAndDelete(subscriber: Subscriber) {
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email
        isUpdateOrDelete = true
        subscriberToUpdateOrDelete = subscriber
        saveOrUpdateBtnTxt.value = UPDATE
        clearAllOrDeleteBtnTxt.value = DELETE
    }

    fun saveOrUpdate() {
        if (isUpdateOrDelete) {
            subscriberToUpdateOrDelete.name = inputName.value!!
            subscriberToUpdateOrDelete.email = inputEmail.value!!
            update(subscriberToUpdateOrDelete)
        } else {
            val name = inputName.value!!
            val email = inputEmail.value!!
            insert(Subscriber(DEFAULT_ID, name, email))
            inputName.value = null
            inputEmail.value = null
        }
    }

    fun clearAllOrDelete() {
        if (isUpdateOrDelete) {
            delete(subscriberToUpdateOrDelete)
        } else {
            clearAll()
        }
    }

    private fun insert(subscriber: Subscriber) =
        viewModelScope.launch {
            repository.insert(subscriber)
            statusMessage.value = Event(ISERTED_SUCCESSFULLY_MESSAGE)
        }

    private fun update(subscriber: Subscriber) =
        viewModelScope.launch {
            repository.update(subscriber)
            inputName.value = null
            inputEmail.value = null
            isUpdateOrDelete = false
            saveOrUpdateBtnTxt.value = SAVE
            clearAllOrDeleteBtnTxt.value = CLEAR_ALL
            statusMessage.value = Event(UPDATED_SUCCESSFULLY_MESSAGE)
        }

    private fun delete(subscriber: Subscriber) =
        viewModelScope.launch {
            repository.delete(subscriber)
            inputName.value = null
            inputEmail.value = null
            isUpdateOrDelete = false
            saveOrUpdateBtnTxt.value = SAVE
            clearAllOrDeleteBtnTxt.value = CLEAR_ALL
            statusMessage.value = Event(DELETED_SUCCESSFULLY_MESSAGE)
        }

    private fun clearAll() =
        viewModelScope.launch {
            repository.deleteAll()
            statusMessage.value = Event(CLEAR_ALL_SUCCESSFULLY_MESSAGE)
        }

    private fun getSaveSubscribers() = liveData {
        repository.subscribers.collect {
            emit(it)
        }
    }

    companion object {
        private const val SAVE = "Save"
        private const val UPDATE = "Update"
        private const val DELETE = "Delete"
        private const val CLEAR_ALL = "Clear All"
        private const val ISERTED_SUCCESSFULLY_MESSAGE = "Subscriber Inserted Successfully"
        private const val UPDATED_SUCCESSFULLY_MESSAGE = "Subscriber Updated Successfully"
        private const val DELETED_SUCCESSFULLY_MESSAGE = "Subscriber Deleted Successfully"
        private const val CLEAR_ALL_SUCCESSFULLY_MESSAGE = "All Subscribers Deleted Successfully"
        private const val DEFAULT_ID = 0
    }
}