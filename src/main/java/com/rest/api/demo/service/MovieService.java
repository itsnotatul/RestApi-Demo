package com.rest.api.demo.service;

import com.rest.api.demo.dto.MovieRequestDto;
import com.rest.api.demo.dto.MovieResponseDto;
import com.rest.api.demo.model.Movie;
import com.rest.api.demo.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repo;

    public MovieService(MovieRepository movieRepository) {
        this.repo = movieRepository;
    }

    public MovieResponseDto create(MovieRequestDto requestDto) {
        Movie movie = new Movie();
        movie.setName(requestDto.getName());
        movie.setYear(requestDto.getYear());

        Movie saved = repo.save(movie);

        return new MovieResponseDto(saved.getId());

    }

    public List<Movie> getAll() {
        return repo.findAll();
    }

    public Movie getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Movie update(Long id, Movie updated) {
        Movie movie = getById(id);
        movie.setName(updated.getName());
        movie.setYear(updated.getYear());
        return repo.save(movie);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
