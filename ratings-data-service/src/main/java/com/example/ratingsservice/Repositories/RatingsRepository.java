package com.example.ratingsservice.Repositories;

import com.example.ratingsservice.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingsRepository extends JpaRepository<Rating, Long>{
    @Query("SELECT r.movieId, r.rating FROM Rating r WHERE r.user.user_id = :userId")
    List<Object[]> findRatingsAndMovieIdsByUserId(@Param("userId") String userId);

}
