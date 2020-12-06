package com.artemissoftware.simplerecyclerview.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.artemissoftware.simplerecyclerview.databinding.ItemMovieBinding
import kotlinx.android.synthetic.main.item_movie.view.*


class MovieListAdapter(private val listener : MovieClickInterface) : ListAdapter<Movie, MovieListAdapter.MovieViewHolder>(MovieDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : ViewHolder(binding.root) {

        init {

            binding.root.deleteButton.setOnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION) {

                    val item = getItem(position)

                    if (item != null) {
                        listener.onDelete(position)
                    }
                }
            }
        }

        fun bind(movie: Movie) {

            itemView.apply {
                nameTextview.text = movie.name
                ratingTextView.text = movie.rating

            }
        }



    }


    interface MovieClickInterface {
        fun onDelete(position: Int)
    }


}