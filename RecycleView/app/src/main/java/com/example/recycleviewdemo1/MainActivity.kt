package com.example.recycleviewdemo1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val fruitList = listOf("Mango", "Apple", "Banana", "Guava", "Lemon", "Pear", "Orange")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recycle_view.setBackgroundColor(Color.GREEN)
        my_recycle_view.layoutManager = LinearLayoutManager(this)
        my_recycle_view.adapter = MyRecyclerViewAdapter(fruitList)
    }
}