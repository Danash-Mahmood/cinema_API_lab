package com.example.SpringCinemaLab.services;


import com.example.SpringCinemaLab.Repository.MovieRepository;
import com.example.SpringCinemaLab.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //give the service tag so Springboot can autowire it
public class MovieService {


    @Autowired
    MovieRepository movieRepository;



    public void addMovie(Movie movie){
        this.movieRepository.save(movie);
    }

    public Optional<Movie> getMovieById(long id){
        return this.movieRepository.findById(id); //the optional datatype won't return anything if its not there
    }

    public List<Movie> getAllMovies(){
        return this.movieRepository.findAll();
    }



    public void updateMovie(long currentMovieId,Movie newMovie){
        Optional<Movie> tempMovie = this.getMovieById(currentMovieId); //this makes a new movie object which takes its information from the corresponding movie with the id we pass in to it
        // but doesnt link to the database directly so changing this object does nothing to the one in the database


        Movie tempMovieActual = tempMovie.get(); //this will unbox the Optional<Movie> and give us a Movie data type so we can use the Movie methods

        tempMovieActual.setTitle(newMovie.getTitle());
        tempMovieActual.setRating(newMovie.getRating());
        tempMovieActual.setDuration(newMovie.getDuration());

        movieRepository.save(tempMovieActual); //this will overwrite what was previously at the id with the new information



    }

    public void deleteMovie(long id){
        movieRepository.deleteById(id);
    }

   public ArrayList<Movie> findBydurationLessThan(int cutOffDuration) {
       ArrayList<Movie> returnArray = new ArrayList<>();
       for (Movie movie : this.getAllMovies()) {
           if (movie.getDuration() < cutOffDuration) {
               returnArray.add(movie);

           }
       }
       return returnArray;

   }



}
