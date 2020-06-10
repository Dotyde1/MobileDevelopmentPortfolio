package com.example.l6task2.data

class MoviesRepository {
private val movieApi : MovieApiService = MovieApi.createApi()

    fun getMovies(year : String) = movieApi.getMovieList(year)
}