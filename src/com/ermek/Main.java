package com.ermek;

import com.ermek.movie.Movies;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;




public class Main {
    public static void main(String[] args) throws IOException {

       Gson gson=new GsonBuilder().setPrettyPrinting().create();
       Path path= Paths.get("src/com/ermek/data/movies.json");
       Movies movies = gson.fromJson(Files.readString(path), Movies.class);
        System.out.println(movies);
    }
}
