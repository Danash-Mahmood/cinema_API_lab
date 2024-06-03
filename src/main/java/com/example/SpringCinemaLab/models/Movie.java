package com.example.SpringCinemaLab.models;


import jakarta.persistence.*;
//The models in the API need to be POJOs

@Entity //this bean says this class will be in the table
@Table(name = "movie table") //naming the table
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //adds the primary key serialisation
    private long id;

    @Column //makes a column in the table and declares the variables at the class level to be initialised in the constructor for new instances of the class
    private String title;
    @Column
    private String rating;
    @Column
    private int duration;


    public Movie(String title, String rating, int duration){
        this.title = title;
        this.rating = rating;
        this.duration = duration;
    }

    public Movie(){


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
