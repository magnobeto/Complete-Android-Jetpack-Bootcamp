package com.example.tmdbclient.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.databinding.ListItemBinding

class TvShowAdapter: RecyclerView.Adapter<MyViewHolder>() {
    private val tvShowList = arrayListOf<TvShow>()

    fun setList(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int = tvShowList.size
}

class MyViewHolder(private val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(tvShow: TvShow) {
        with(binding) {
            titleTextView.text = tvShow.name
            descriptionTextView.text = tvShow.overview
            val posterUrl = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
            Glide.with(imageView.context)
                .load(posterUrl)
                .into(imageView)
        }
    }
}