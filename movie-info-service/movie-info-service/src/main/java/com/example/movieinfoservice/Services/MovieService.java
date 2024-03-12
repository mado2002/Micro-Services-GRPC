package com.example.movieinfoservice.Services;

import com.example.movieinfoservice.RepoMongo.RepoMovieSummary;
import com.example.movieinfoservice.models.MovieSummary;
import com.thoughtworks.xstream.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final RepoMovieSummary repoMovieSummary;

    @Autowired
    public MovieService(RepoMovieSummary repoMovieSummary) {
        this.repoMovieSummary = repoMovieSummary;
    }

    public void saveMovieSummary(MovieSummary movieSummary) {
        repoMovieSummary.save(movieSummary);
    }
    public MovieSummary getMovieSummary(String id) {
        return repoMovieSummary.findById(id).orElse(null);
    }
}
