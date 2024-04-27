package com.ermek.movie;

import java.util.Arrays;


public class Movies {
    public Movie [] movies;



    @Override
    public String toString() {
        return "Movies{" +
                "list=" + Arrays.toString(movies) +
                '}';
    }
}
