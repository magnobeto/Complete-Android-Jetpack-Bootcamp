package com.anushka.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
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

        showingTotalSumSetup()

    }

    private fun showingTotalSumSetup() {
        binding.apply {
            totalSum.text = viewModel.showTotalSum().toString()
            addButton.setOnClickListener {
                val number: Int = Integer.parseInt(numberInput.text.toString())
                viewModel.sumNumberInput(number)
                totalSum.text = viewModel.showTotalSum().toString()
                numberInput.text.clear()
            }
        }
    }
}