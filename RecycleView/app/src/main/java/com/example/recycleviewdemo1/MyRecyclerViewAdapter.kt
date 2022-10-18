package com.example.recycleviewdemo1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewdemo1.databinding.ListItemBinding

class MyRecyclerViewAdapter(private val fruitList: List<SpecialItem>, private val clickListener: (Fruit) -> Unit): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = ListItemBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(fruitList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }
}

class MyViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind (fruit: SpecialItem, listener: (Fruit) -> Unit) {
        with(binding) {
            nameItemTxt.text = fruit.nome
            btnContainer.setOnClickListener {
//                listener(fruit)
            }
        }
    }
}