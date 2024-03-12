package com.example.Trendingmovieservice.DataBase;

import com.example.Trendingmovieservice.models.Movie;
import com.example.Trendingmovieservice.models.Rating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDatabase {

    private static final List<Movie> movies = new ArrayList<>();
    private static final List<Rating> ratings = new ArrayList<>();

    static {
        // Sample movies data
        movies.add( new Movie("1", "The Shawshank Redemption", "Two imprisoned men bond over a number of years..."));
        movies.add( new Movie("2", "The Godfather", "The aging patriarch of an organized crime dynasty..."));
        movies.add( new Movie("3", "The Dark Knight", "When the menace known as the Joker wreaks havoc..."));
        movies.add( new Movie("4", "The Godfather: Part II", "The early life and career of Vito Corleone in 1920s New York..."));
        movies.add( new Movie("6", "The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World"));
        movies.add( new Movie("7", "The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World"));
        movies.add( new Movie("8", "The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World"));
        movies.add( new Movie("9", "The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World"));
        movies.add( new Movie("10", "The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World"));
        movies.add( new Movie("11", "The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World"));
        movies.add( new Movie("12", "The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World"));
        movies.add( new Movie("13", "The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World"));
        movies.add( new Movie("14", "The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World"));
        movies.add( new Movie("15", "The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World"));
        movies.add( new Movie("16", "The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World"));
        movies.add( new Movie("17", "The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World"));

        // Add more movies as needed

        // Sample ratings data
        ratings.add(new Rating(1L, "1", 5));
        ratings.add(new Rating(2L, "1", 4));
        ratings.add(new Rating(3L, "1", 3));
        ratings.add(new Rating(4L, "2", 5));
        ratings.add(new Rating(5L, "2", 4));
        ratings.add(new Rating(6L, "2", 3));
        ratings.add(new Rating(7L, "3", 5));
        ratings.add(new Rating(8L, "3", 4));
        ratings.add(new Rating(9L, "3", 3));
        ratings.add(new Rating(10L, "4", 5));
        ratings.add(new Rating(11L, "4", 4));
        ratings.add(new Rating(12L, "4", 3));

        // Add more ratings as needed
    }

    public  List<Movie> getMovies() {
        return movies;
    }



    public  List<Rating> getRatings() {
        return ratings;
    }
}
