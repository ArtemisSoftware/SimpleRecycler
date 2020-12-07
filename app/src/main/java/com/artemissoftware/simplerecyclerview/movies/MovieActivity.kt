package com.artemissoftware.simplerecyclerview.movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.simplerecyclerview.R
import kotlinx.android.synthetic.main.activity_movie.*

import java.util.Random;

class MovieActivity : AppCompatActivity(), MovieListAdapter.MovieClickInterface  {

    private lateinit var viewModel : MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)


        viewModel = MovieViewModel()

        val movieListAdapter = MovieListAdapter(this)
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

        button_update.setOnClickListener {

            val randomPostion: Int = Random().nextInt(movieListAdapter.getItemCount())
            val movie: Movie = movieListAdapter.getCurrentList().get(randomPostion)

            val updateMovie = Movie(movie.name, movie.rating)

            updateMovie.id = movie.id
            updateMovie.name = movie.name + " :updated"
            viewModel.updateMovie(updateMovie, randomPostion)
        }


        button_add_list.setOnClickListener {

            val movieList = listOf<Movie>(Movie("Avenger's", "9"), Movie("Avenger's Endgame", "3"))
            viewModel.addMovies(movieList)
        }


//        val movieList = listOf<Movie>(Movie("Captain America", "8"),Movie("Iron Man", "7"), Movie("Thor", "6") )
//        movieListAdapter.submitList(movieList)

        viewModel.getMovieList().observe(this, Observer<List<Movie>> {
                 movieListAdapter.submitList(it)
//                 movieListAdapter.update(it)
        })
    }

    override fun onDelete(position: Int) {
        viewModel.deleteMovie(position);
    }


}