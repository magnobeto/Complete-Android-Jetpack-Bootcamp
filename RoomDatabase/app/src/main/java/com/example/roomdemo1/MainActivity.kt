package com.example.roomdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdemo1.databinding.ActivityMainBinding
import com.example.roomdemo1.db.Subscriber
import com.example.roomdemo1.db.SubscriberDatabase
import com.example.roomdemo1.db.SubscriberRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = SubscriberDatabase.getInstance(application).subscriberDAO
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        subscriberViewModel = ViewModelProvider(this, factory).get(SubscriberViewModel::class.java)
        binding.myViewModel = subscriberViewModel
        binding.lifecycleOwner = this
        initRecycerView()
    }

    private fun initRecycerView() {
        binding.subscriberRecyclerView.layoutManager = LinearLayoutManager(this)
        displaySubscriberList()
    }

    private fun displaySubscriberList() {
        subscriberViewModel.subscribers.observe(this) {
            Log.i("MyTag", it.toString())
            binding.subscriberRecyclerView.adapter =
                MyRecyclerViewAdapter(it) { selectedItem: Subscriber ->
                    listItemClicked(selectedItem)
                }
        }
    }

    private fun listItemClicked(subscriber: Subscriber) {
        Toast.makeText(this, "selected name is: ${subscriber.name}", Toast.LENGTH_SHORT).show()
    }
}