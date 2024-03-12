package com.example.movieinfoservice.resources;
import com.example.movieinfoservice.Services.MovieService;
import com.example.movieinfoservice.models.Movie;
import com.example.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private  MovieService MovieService;
    @Value("${api.key}")
    private String apiKey;

    private RestTemplate restTemplate;

    public MovieResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {

        // Get the movie info from TMDB

        long startTime = System.nanoTime();
        MovieSummary movieSummary =MovieService.getMovieSummary(movieId);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time to call MongoDB: " + elapsedTime + "nanoseconds");

        if(movieSummary==null){
            startTime = System.nanoTime();
            final String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey;
            movieSummary = restTemplate.getForObject(url, MovieSummary.class);
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            System.out.println("Elapsed time to call KEYAPI: " + elapsedTime + " nanoseconds");
            MovieService.saveMovieSummary(movieSummary);
            System.out.println("iam in *|* ");
        }
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }
}
