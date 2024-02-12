package dev.moalnawagy.movies_app.repositories;

import dev.moalnawagy.movies_app.models.Movie;
import dev.moalnawagy.movies_app.models.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
