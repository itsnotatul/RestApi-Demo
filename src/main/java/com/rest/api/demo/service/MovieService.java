package com.rest.api.demo.service;

import com.rest.api.demo.dto.MovieRequestDto;
import com.rest.api.demo.dto.MovieResponseDto;
import com.rest.api.demo.dto.UpdateMovieRequestDto;
import com.rest.api.demo.dto.UpdateMovieResponseDto;
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

    public UpdateMovieResponseDto update(UpdateMovieRequestDto requestDto) {
        Movie movie = getById(requestDto.getId());
        movie.setName(requestDto.getName());
        movie.setYear(requestDto.getReleaseYear());
        Movie updated =  repo.save(movie);

        return new UpdateMovieResponseDto(updated.getId());
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
