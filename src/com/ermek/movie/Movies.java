package com.ermek.movie;

import java.util.List;


public class Movies {
    public List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Movies: " +
                "movies: " + movies;
    }
}
