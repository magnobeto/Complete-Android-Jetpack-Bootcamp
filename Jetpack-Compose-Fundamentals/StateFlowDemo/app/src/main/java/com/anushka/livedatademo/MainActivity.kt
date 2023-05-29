package com.anushka.livedatademo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.anushka.livedatademo.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainViewModelActivityFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory = MainViewModelActivityFactory(10)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainActivityViewModel::class.java]

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
        lifecycleScope.launchWhenCreated {
            viewModel.totalSum.collect { totalSum ->
                binding.totalSum.text = totalSum.toString()
            }
        }
    }
}