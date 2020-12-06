package com.artemissoftware.simplerecyclerview.movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.simplerecyclerview.R
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : AppCompatActivity() {

    private lateinit var viewModel : MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)


        viewModel = MovieViewModel()

        val movieListAdapter = MovieListAdapter()
        //recyclerView.adapter = movieListAdapter

        rcl_movies.apply {
            adapter = movieListAdapter
            layoutManager = LinearLayoutManager(this@MovieActivity)
            setHasFixedSize(true)
        }

        button_add.setOnClickListener {

            val movie = Movie("Avenger's", "9")
            viewModel.addMovie(movie)

        }


//        val movieList = listOf<Movie>(Movie("Captain America", "8"),Movie("Iron Man", "7"), Movie("Thor", "6") )
//        movieListAdapter.submitList(movieList)

        viewModel.getMovieList().observe(this, Observer<List<Movie>> {
                 movieListAdapter.submitList(it)
        })
    }

}