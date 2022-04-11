package com.example.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.lifecycledemo.databinding.MainActivityBinding
import com.example.lifecycledemo.ui.main.MainFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        lifecycleScope.launch {
            delay(5000)
            binding.progressBar.visibility = View.VISIBLE
            delay(10000)
            binding.progressBar.visibility = View.GONE
        }
    }
}