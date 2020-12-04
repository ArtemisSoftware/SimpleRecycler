package com.artemissoftware.simplerecyclerview.movies

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.simplerecyclerview.R
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val movieListAdapter = MovieListAdapter()
        //recyclerView.adapter = movieListAdapter

        rcl_movies.apply {
            adapter = movieListAdapter
            layoutManager = LinearLayoutManager(this@MovieActivity)
            setHasFixedSize(true)
        }


        val movieList = listOf<Movie>(Movie("Captain America", "8"),Movie("Iron Man", "7"), Movie("Thor", "6") )
        movieListAdapter.submitList(movieList)
    }
}