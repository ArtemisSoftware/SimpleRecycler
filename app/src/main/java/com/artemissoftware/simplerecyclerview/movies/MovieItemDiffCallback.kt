package com.artemissoftware.simplerecyclerview.movies

import androidx.recyclerview.widget.DiffUtil

class MovieItemDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie) =
        oldItem.name == newItem.name


}