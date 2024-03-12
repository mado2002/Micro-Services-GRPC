package com.example.Trendingmovieservice.services;

import com.example.Trendingmovieservice.DataBase.InMemoryDatabase;
import com.example.Trendingmovieservice.models.Movie;
import com.example.Trendingmovieservice.models.Rating;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import com.example.grpc.MovieServiceGrpc;
import com.example.grpc.TopMoviesRequest;
import com.example.grpc.TopMoviesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;


@GrpcService
public class TrendingMoviesService extends MovieServiceGrpc.MovieServiceImplBase {

    public InMemoryDatabase database= new InMemoryDatabase();
    @Override
    public void getTopMovies(TopMoviesRequest request, StreamObserver<TopMoviesResponse> responseObserver) {
        int count = request.getCount();
            List<Rating> ratings = database.getRatings();
        synchronized (ratings) {
            ratings.sort(Comparator.comparingInt(Rating::getRating).reversed());
        }
            String previous=ratings.get(0).getMovieId();
        StringBuilder topMoviesIds = new StringBuilder();
        topMoviesIds.append(previous).append(",");
        int j=1;
        for (int i=1;i< ratings.size();i++){
            if(ratings.get(i).getMovieId().equals(previous)){
                continue;
            }
            else{
                j++;
                topMoviesIds.append(ratings.get(i).getMovieId()).append(",");
                previous=ratings.get(i).getMovieId();
                if(j==count){
                    break;
                }
            }

        }

        List<Movie> movies = database.getMovies();
        List<com.example.grpc.Movie> topMovies = new ArrayList<>();
        for (Movie movie : movies) {
                topMovies.add(com.example.grpc.Movie.newBuilder()
                        .setMovieId(movie.getMovieId())
                        .setName(movie.getName())
                        .build());
        }
        TopMoviesResponse response = TopMoviesResponse.newBuilder()
                .addAllTopMovies(topMovies)
                .build();

        // Send the response
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

}
