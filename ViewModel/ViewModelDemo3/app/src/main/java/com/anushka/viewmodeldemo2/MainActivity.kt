package com.anushka.viewmodeldemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.anushka.viewmodeldemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

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