package com.example.recycleviewdemo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class MyRecyclerViewAdapter(private val fruitList: List<Fruit>): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(fruitList[position])
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }
}

class MyViewHolder(private val view : View): RecyclerView.ViewHolder(view) {

    fun bind (fruit: Fruit) {
        view.name_item_txt.text = fruit.name
    }
}