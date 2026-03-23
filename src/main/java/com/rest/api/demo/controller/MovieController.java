package com.rest.api.demo.controller;

import com.rest.api.demo.dto.MovieRequestDto;
import com.rest.api.demo.dto.MovieResponseDto;
import com.rest.api.demo.dto.UpdateMovieRequestDto;
import com.rest.api.demo.dto.UpdateMovieResponseDto;
import com.rest.api.demo.model.Movie;
import com.rest.api.demo.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @PostMapping
    public MovieResponseDto create(@RequestBody MovieRequestDto requestDto) {
        return service.create(requestDto);
    }

    @GetMapping
    public List<Movie> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping
    public UpdateMovieResponseDto update(@RequestBody UpdateMovieRequestDto request) {
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
