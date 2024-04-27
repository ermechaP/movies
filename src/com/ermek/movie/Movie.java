package com.ermek.movie;

import java.util.Arrays;
import java.util.List;

public class Movie {
    private String name;
    private int year;
    private String description;
    private Director director;
    private Cast [] cast;

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", director=" + director +
                ", cast=" + Arrays.toString(cast) +
                '}';
    }
}
