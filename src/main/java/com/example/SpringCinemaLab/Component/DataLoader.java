package com.example.SpringCinemaLab.Component;


import com.example.SpringCinemaLab.models.Movie;
import com.example.SpringCinemaLab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieService movieService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Movie movie1 = new Movie("The dark knight","15",120);
        Movie movie2 = new Movie("Cars", "U",100);
        Movie movie3 = new Movie("Cars 2","U",100);

        movieService.addMovie(movie1);
        movieService.addMovie(movie2);
        movieService.addMovie(movie3);



    }






}
