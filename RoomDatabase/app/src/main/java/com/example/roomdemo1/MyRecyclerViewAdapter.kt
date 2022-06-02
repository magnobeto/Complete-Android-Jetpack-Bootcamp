package com.example.roomdemo1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo1.databinding.ListItemBinding
import com.example.roomdemo1.db.Subscriber

class MyRecyclerViewAdapter(
    private val clickListener: (Subscriber) -> Unit
) : RecyclerView.Adapter<MyViewHolder>() {

    private val subscribersList = mutableListOf<Subscriber>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(subscribersList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return subscribersList.size
    }

    fun setList(subscribers: List<Subscriber>) {
        subscribersList.clear()
        subscribersList.addAll(subscribers)
    }
}

class MyViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(subscriber: Subscriber, clickListener: (Subscriber) -> Unit) {
        with(binding) {
            nameTextView.text = subscriber.name
            emailTextView.text = subscriber.email
            listItemLayout.setOnClickListener {
                clickListener(subscriber)
            }
        }
    }
}
