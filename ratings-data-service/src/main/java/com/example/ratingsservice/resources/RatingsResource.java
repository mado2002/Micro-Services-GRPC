package com.example.ratingsservice.resources;

import com.example.ratingsservice.Repositories.RatingsRepository;
import com.example.ratingsservice.Repositories.UserRepository;
import com.example.ratingsservice.models.Rating;
import com.example.ratingsservice.models.RatingDto;
import com.example.ratingsservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RatingsRepository ratingsRepository;
    @RequestMapping("/{userId}")
    public List<Object[]> getRatingsOfUser(@PathVariable(value = "userId") String userId) {
        return ratingsRepository.findRatingsAndMovieIdsByUserId(userId);
    }
    @PostMapping("/addrating")
    public void addrating(@RequestBody User user){
        userRepository.save(user);
    }
    @GetMapping("/getallratings")
    public List<RatingDto> getall(){
        List<Rating> ratings = ratingsRepository.findAll();
        List<RatingDto> ratingDtos =new ArrayList<>();
        for (Rating rating:ratings){
            ratingDtos.add(new RatingDto(rating.getId(),rating.getMovieId(),rating.getRating()));
        }
        return ratingDtos;
    }
}
