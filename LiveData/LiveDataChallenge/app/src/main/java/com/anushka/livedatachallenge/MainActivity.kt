package com.anushka.livedatachallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anushka.livedatachallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        setOnClickListener()
        observe()
    }

    private fun setOnClickListener() {
        binding.button.setOnClickListener {
            viewModel.updateCount()
        }
    }

    private fun observe() {
        viewModel.count.observe(this, Observer { updatedCount ->
            binding.countText.text = updatedCount.toString()
        })
    }
}
