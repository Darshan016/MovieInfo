package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies/")
public class MovieController {
    @Autowired
    private MovieService movieService;
    //http://localhost:8082/movies/addmovie
    @PostMapping("/addmovie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);
    }
    //http://localhost:8082/movies/getAll
    @GetMapping("/getAll")
    public ResponseEntity<?> getMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(),HttpStatus.FOUND);
    }
    //http://localhost:8082/movies/movie/name
    @GetMapping("/{name}")
    public ResponseEntity<?> getMovieById(@PathVariable String name){
        return new ResponseEntity<>(movieService.geMovieByName(name),HttpStatus.FOUND);
    }
    //http://localhost:8082/movies/movie/4
    @DeleteMapping("/movie/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable int id){
        return new ResponseEntity<>(movieService.deleteById(id),HttpStatus.GONE);
    }
    //http://localhost:8082/movies/movie/4
    @PutMapping("/movie/{id}")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie,@PathVariable int id){
        return new ResponseEntity<>(movieService.updateMovie(movie,id),HttpStatus.ACCEPTED);
    }
}
