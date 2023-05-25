package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImplementation implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {

        if (movieRepository.existsById(id)){
            movieRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Movie geMovieByName(String name) {
        return movieRepository.findBymovieName(name);
    }

    @Override
    public Movie updateMovie(Movie movie, int id) {
        Optional<Movie> movie1=movieRepository.findById(id);
        if(movie1.isEmpty()){
            return null;
        }
        Movie movie2=movie1.get();
        if(movie.getMovieName()!=null){
            movie2.setMovieName(movie.getMovieName());
        }
        if(movie.getGenre()!=null){
            movie2.setGenre(movie.getGenre());
        }
        if(movie.getReleaseDate()!=null){
            movie2.setReleaseDate(movie.getReleaseDate());
        }
        return movieRepository.save(movie2);
    }
}
