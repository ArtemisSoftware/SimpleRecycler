package com.artemissoftware.simplerecyclerview.movies

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.artemissoftware.simplerecyclerview.databinding.ItemMovieBinding
import kotlinx.android.synthetic.main.item_movie.view.*


class MovieListAdapter : ListAdapter<Movie, MovieListAdapter.MovieViewHolder>(MovieDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    class MovieViewHolder(private val binding: ItemMovieBinding) : ViewHolder(binding.root) {


        fun bind(movie: Movie) {

            itemView.apply {
                nameTextview.text = movie.name
                ratingTextView.text = movie.rating
            }
        }



    }


}