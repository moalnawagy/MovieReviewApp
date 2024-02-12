package dev.moalnawagy.movies_app.controllers;

import dev.moalnawagy.movies_app.models.Movie;
import dev.moalnawagy.movies_app.services.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAll(){
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/GetById/{id}")
    public ResponseEntity<Optional<Movie>> getById(@PathVariable ObjectId id){
        return new ResponseEntity<>(movieService.getOne(id), HttpStatus.OK);
    }
    @GetMapping("/GetByImdbId/{imdbId}")
    public ResponseEntity<Optional<Movie>> getById(@PathVariable String imdbId){
        return new ResponseEntity<>(movieService.getOne(imdbId), HttpStatus.OK);
    }
}
