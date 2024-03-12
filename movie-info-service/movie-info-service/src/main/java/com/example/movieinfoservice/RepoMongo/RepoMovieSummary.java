package com.example.movieinfoservice.RepoMongo;

import com.example.movieinfoservice.models.MovieSummary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoMovieSummary extends MongoRepository<MovieSummary,String> {
}
