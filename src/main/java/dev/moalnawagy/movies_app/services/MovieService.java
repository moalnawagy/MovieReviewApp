package dev.moalnawagy.movies_app.services;

import dev.moalnawagy.movies_app.models.Movie;
import dev.moalnawagy.movies_app.repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
 public List<Movie> getAll(){
    return movieRepository.findAll();
 }
 public Optional<Movie> getOne(ObjectId id){
    return movieRepository.findById(id);
 }
 public Optional<Movie> getOne(String imdbId){
    return movieRepository.findMovieByImdbId(imdbId);
 }
}
