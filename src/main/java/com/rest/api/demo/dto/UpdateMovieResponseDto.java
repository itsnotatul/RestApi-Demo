package com.rest.api.demo.dto;

public class UpdateMovieResponseDto {
    private Long Id;

    public UpdateMovieResponseDto(Long id) {
        Id = id;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
