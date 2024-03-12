package com.moviecatalogservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.moviecatalogservice.models.Movie;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;
import com.example.grpc.MovieServiceGrpc;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrendingMovieClientService {
    ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    public List<Movie> getTrendingMovies(int count) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8090).usePlaintext().build();
        MovieServiceGrpc.MovieServiceBlockingStub stub = MovieServiceGrpc.newBlockingStub(channel);
        com.example.grpc.TopMoviesRequest request = com.example.grpc.TopMoviesRequest.newBuilder().setCount(count).build();
        com.example.grpc.TopMoviesResponse response = stub.getTopMovies(request);
        channel.shutdown();
        List<com.example.grpc.Movie> topMovies = response.getTopMoviesList();
        List<Movie> movies = new ArrayList<>();
        for (com.example.grpc.Movie movie : topMovies) {
            movies.add(new Movie(movie.getMovieId(), movie.getName(), movie.getDescription()));
        }


        return movies;
    }
}
