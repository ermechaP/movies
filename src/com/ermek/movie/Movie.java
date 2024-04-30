package com.ermek.movie;

import java.util.List;

public class Movie implements Comparable<Movie> {
    private String name;
    private int year;
    private String description;
    private Director director;
    private List<Cast> cast;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie: " +
                name +
                ", year: " + year +
                ", description: " + description + " ," + director +
                ", cast: " + cast;
    }

    @Override
    public int compareTo(Movie o) {
        if (this.getYear() > o.getYear()) return 1;
        return -1;
    }
}
