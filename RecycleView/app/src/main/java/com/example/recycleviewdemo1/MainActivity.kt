package com.example.recycleviewdemo1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fruitList = listOf(
        Fruit("Mango", "Tom"),
        Fruit("Apple", "Joe"),
        Fruit("Banana", "Mark"),
        Fruit("Guava", "Mike"),
        Fruit("Lemon", "Mike" ),
        Fruit("Pear", "Frang"),
        Fruit("Orange", "Joe"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recycle_view.setBackgroundColor(Color.GREEN)
        my_recycle_view.layoutManager = LinearLayoutManager(this)
        my_recycle_view.adapter = MyRecyclerViewAdapter(fruitList)
    }
}