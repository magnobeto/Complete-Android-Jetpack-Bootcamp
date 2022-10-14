package com.example.recycleviewdemo1

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleviewdemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val fruitList = listOf(
        Fruit("Mango", "Tom"),
        Fruit("Apple", "Joe"),
        Fruit("Banana", "Mark"),
        Fruit("Guava", "Mike"),
        Fruit("Lemon", "Mike"),
        Fruit("Pear", "Frang"),
        Fruit("Orange", "Joe")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        val list = ListConverter.getJsonDataFromAsset(this)
        with(binding.myRecycleView) {
            setBackgroundColor(Color.GREEN)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter =
                MyRecyclerViewAdapter(list) { selectFruitItem: Fruit ->
                    listItemClicked(
                        selectFruitItem
                    )
                }
        }
    }

    private fun listItemClicked(fruit: Fruit) {
        Toast.makeText(this@MainActivity, "Suplier name is: ${fruit.supplier}", Toast.LENGTH_SHORT)
            .show()
    }
}