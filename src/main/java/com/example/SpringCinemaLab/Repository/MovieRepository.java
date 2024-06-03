package com.example.SpringCinemaLab.Repository;

import com.example.SpringCinemaLab.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {



    List<Movie> findBydurationLessThanEqual(int cutOffDuration);
}
