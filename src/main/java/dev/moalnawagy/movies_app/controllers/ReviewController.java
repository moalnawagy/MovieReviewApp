package dev.moalnawagy.movies_app.controllers;

import dev.moalnawagy.movies_app.models.Movie;
import dev.moalnawagy.movies_app.models.Review;
import dev.moalnawagy.movies_app.services.MovieService;
import dev.moalnawagy.movies_app.services.ReviewService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping
    public ResponseEntity<Review> create(@RequestBody Map<String, String> payload){

        return new ResponseEntity<>(reviewService.createReview(payload.get("body"), payload.get("imdbId")), HttpStatus.CREATED);
    }
}
