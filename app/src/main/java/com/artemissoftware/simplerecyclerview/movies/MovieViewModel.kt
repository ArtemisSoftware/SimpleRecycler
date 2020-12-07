package com.artemissoftware.simplerecyclerview.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MovieViewModel : ViewModel() {

    private lateinit var mutableLiveData: MutableLiveData<List<Movie>>

    init {
        mutableLiveData = MutableLiveData()
    }

    fun getMovieList(): LiveData<List<Movie>> {
        if (mutableLiveData.value == null) {
            initMovieList()
        }
        return mutableLiveData
    }


    private fun initMovieList() {

        val movieList: MutableList<Movie> = ArrayList()
        movieList.add(Movie("Captain America", "8"))
        movieList.add(Movie("Iron Man", "7"))
        movieList.add(MovieUtil.bestMovie)
        movieList.add(Movie("222","Terminator", "7"))
        mutableLiveData.value = movieList
    }




    fun addMovie(movie: Movie) {

        val movieList = mutableListOf<Movie>()

        mutableLiveData.getValue()?.let {
            movieList.addAll(it)
        }
        movieList.add(movie)
        mutableLiveData.setValue(movieList)

    }

    fun addMovies(movies: List<Movie>) {

        val movieList = mutableListOf<Movie>()
        mutableLiveData.value?.let {
            movieList.addAll(it)

            movieList.addAll(movies)

            //val index = movieList.indexOf(MovieUtil.bestMovie);
            //val movie = movieList.get(2)
            movieList.removeAt(3)

            val movie = Movie("222","Terminator", "7")
            movie.name = movie.name + " Final cut"
            movieList.set(3,movie)

        }


        mutableLiveData.setValue(movieList)

    }


    fun updateMovie( newMovie: Movie, position: Int) {

        val movieList = mutableListOf<Movie>()

        mutableLiveData.getValue()?.let {
            movieList.addAll(it)
            movieList.removeAt(position)
            movieList.add(position, newMovie)
        }

        mutableLiveData.setValue(movieList)

    }


    fun deleteMovie(position: Int) {

        val movieList = mutableListOf<Movie>()

        mutableLiveData.getValue()?.let {
            movieList.addAll(it)
            movieList.removeAt(position)
        }

        mutableLiveData.setValue(movieList)

    }

}