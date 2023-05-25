package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Movie {
    @Id
    private int id;
    private String movieName;
    private String genre;
    private String releaseDate;

}
