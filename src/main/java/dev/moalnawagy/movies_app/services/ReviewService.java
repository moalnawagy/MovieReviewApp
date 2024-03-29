package dev.moalnawagy.movies_app.services;

import dev.moalnawagy.movies_app.models.Movie;
import dev.moalnawagy.movies_app.models.Review;
import dev.moalnawagy.movies_app.repositories.MovieRepository;
import dev.moalnawagy.movies_app.repositories.ReviewRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired

    private MongoTemplate mongoTemplate;

    public Review createReview(String body, String imdbId){
        Review review =reviewRepository.insert(new Review(body)) ;
        mongoTemplate.update(Movie.class).
                matching(Criteria.where("imdbId").is(imdbId)).
                apply(new Update().push("reviewIds").value(review)).
                first();
        return review;
    }
}
