package com.example.demo.movieservicetest;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieServiceImplementation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {
    private Movie movie;
    @Mock
    private MovieRepository movieRepository;
    @InjectMocks
    private MovieServiceImplementation movieServiceImplementation;
    @BeforeEach
    public void setUp(){
        movie=new Movie(1,"name","romance","1-20-2022");
    }
    @AfterEach
    public void tearDown(){
        movie=null;
    }
    @Test
    void savecheck(){
//        when(movieRepository.findById(movie.getId())).thenReturn(Optional.ofNullable(movie));
        when(movieRepository.save(movie)).thenReturn(movie);
        assertEquals(movie,movieServiceImplementation.addMovie(movie));
        verify(movieRepository,times(1)).save(movie);
//        verify(movieRepository,times(1)).findById(any());
    }
    @Test
    void deleteMoviecheck(){
       boolean falg=movieServiceImplementation.deleteById(movie.getId());
       assertNotEquals(true,falg);
//       verify(movieRepository,times(1)).deleteById(any());


    }
}
