package com.example.demo.service;

import com.example.demo.model.Movie;

import java.util.List;

public interface MovieService {
    public Movie addMovie(Movie movie);
    public List<Movie> getAllMovies();
    public boolean deleteById(int id);
    public Movie geMovieByName(String name);
    public Movie updateMovie(Movie movie,int id);

}
