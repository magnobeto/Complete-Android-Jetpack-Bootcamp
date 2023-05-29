package com.anushka.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anushka.livedatademo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainViewModelActivityFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory = MainViewModelActivityFactory(10)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        setOnClickListener()
        observe()
    }

    private fun setOnClickListener() {
        binding.apply {
            addButton.setOnClickListener {
                viewModel.sumNumberInput(numberInput.text.toString().toInt())
                numberInput.text.clear()
            }
        }
    }

    private fun observe() {
        viewModel.totalSum.observe(this, Observer { totalSum ->
            binding.totalSum.text = totalSum.toString()
        })
    }
}