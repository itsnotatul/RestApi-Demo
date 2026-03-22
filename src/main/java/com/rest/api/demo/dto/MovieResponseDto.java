package com.rest.api.demo.dto;

public class MovieResponseDto {
    private Long id;

    public MovieResponseDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
