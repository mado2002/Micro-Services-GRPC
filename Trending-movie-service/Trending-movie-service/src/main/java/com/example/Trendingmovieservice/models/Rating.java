package com.example.Trendingmovieservice.models;

import jakarta.persistence.*;


public class Rating {
private  Long id;
private  String movieId;
private  int rating;

    public Rating(Long id, String movieId, int rating) {
        this.id = id;
        this.movieId = movieId;
        this.rating = rating;
    }
    public Rating() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
