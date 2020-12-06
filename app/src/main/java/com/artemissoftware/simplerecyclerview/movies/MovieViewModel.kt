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
        movieList.add(Movie("Thor", "6"))
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
}