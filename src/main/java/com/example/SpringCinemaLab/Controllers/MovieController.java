package com.example.SpringCinemaLab.Controllers;


import com.example.SpringCinemaLab.models.Movie;
import com.example.SpringCinemaLab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies") //sets the default end point so no need to keep repeating it for all other request types


public class MovieController {

    //autowire a new movieService as this autowires the database. So we can connect the controller to the database

    @Autowired
    MovieService movieService;


    //post request

    @PostMapping("/addMovie")
    public ResponseEntity<Movie> newMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }


    //get request


    @GetMapping("/maxDuration")
    public ResponseEntity<List<Movie>> allMovies(@RequestParam(defaultValue = "") String cutOffDuration){  //the brief requires us to use request parameters so we need to include the case where we don't want to filter by a duration using the default value as "". But the reqeust param gives a String so we need to convert back to an integer when using the actual cut off method
        if(cutOffDuration.equals("")){
        List<Movie> listOfMovies = movieService.getAllMovies(); //The controller shouldnt have business logic or do anything than use service methods so
        return new ResponseEntity<>(listOfMovies,HttpStatus.OK);
    }
        else{
            ArrayList<Movie> listOfMovies = movieService.findBydurationLessThan(Integer.parseInt(cutOffDuration));
            return new ResponseEntity<>(listOfMovies,HttpStatus.OK);

        }

        }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Movie>>getMovieById(@PathVariable long id){
        Optional<Movie> movie  = movieService.getMovieById(id);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @PutMapping(value = "/updateMovie/{id}")

    public ResponseEntity<Movie> updateMovies(@RequestBody Movie movie, @PathVariable long id){
        movieService.updateMovie(id,movie);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @PutMapping(value = "/deleteMovie/{id}")

    public ResponseEntity<Optional<Movie>>deleteMovie(@PathVariable long id){
        Optional<Movie> deletedMovie = movieService.getMovieById(id);
        movieService.deleteMovie(id);
        return new ResponseEntity<>(deletedMovie,HttpStatus.OK);
    }












}
