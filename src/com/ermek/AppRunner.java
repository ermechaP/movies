package com.ermek;


import com.ermek.movie.Movie;
import com.ermek.movie.Movies;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AppRunner {
    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static Path path = Paths.get("src/com/ermek/data/movies.json");
    public static Movies movies;
    //public static List<String> cast = new ArrayList<>();

    public static void readFile() {
        try {
            movies = gson.fromJson(Files.readString(path), Movies.class);
        } catch (IOException e) {
            System.out.println(e);
        }


    }

    public static void allMoviesPrint() {
        for (int i = 0; i < movies.movies.size(); i++) {
            System.out.println();
            System.out.format(" Movie name: %s\n Year of production: %s\n Movie Director: %s\n Movie Description: %s\n",
                    movies.movies.get(i).getName(), movies.movies.get(i).getYear(), movies.movies.get(i).getDirector().getFullName(), movies.movies.get(i).getDescription());

            for (int j = 0; j < movies.movies.get(i).getCast().size(); j++) {
                System.out.format("Actor: %s\n Role: %s\n ", movies.movies.get(i).getCast().get(j).getFullName(), movies.movies.get(i).getCast().get(j).getRole());
            }
        }
    }

    public static void searchMovieByNameOrPartialName(String str) {
//        for (int i = 0; i < movies.movies.size(); i++) {
//            if (movies.movies.get(i).getName().toLowerCase().contains(str.toLowerCase())) {
//                System.out.format(" Movie name: %s\n Year of production: %s\n Movie Director: %s\n Movie Description: %s\n",
//                movies.movies.get(i).getName(), movies.movies.get(i).getYear(), movies.movies.get(i).getDirector().getFullName(), movies.movies.get(i).getDescription());
//                break;
//            } else {
//                System.out.println("Movie not found");
//                break;
//            }
//        }
        movies.movies.stream().filter(n -> n.getName().toLowerCase().contains(str.toLowerCase())).
                forEach(x -> System.out.printf("%s\n%s\n%s\n", x.getName(), x.getDirector(), x.getYear()));
    }

    public static void sortByYear() {
        movies.movies.sort(Comparator.naturalOrder());
        allMoviesPrint();
    }

    public static void sortByMovieName() {
        Comparator<Movie> comp = Comparator.comparing(Movie::getName);
        movies.movies.sort(comp);
        allMoviesPrint();
    }

    public static void sortByMovieDirector() {
        Comparator<Movie> comp = Comparator.comparing(n -> n.getDirector().getFullName());
        movies.movies.sort(comp);
        allMoviesPrint();
    }

    public static void listOfCast() {
        for (int i = 0; i < movies.movies.size(); i++) {
            for (int j = 0; j < movies.movies.get(i).getCast().size(); j++) {
                System.out.format("Actor: %s\n Role: %s\n ", movies.movies.get(i).getCast().get(j).getFullName(), movies.movies.get(i).getCast().get(j).getRole());

            }
        }
    }

    public static void searchByDirector(String str) {
        Map<String, String> director = new HashMap<>();
        System.out.println(str);
        String string = "";
        for (int i = 0; i < movies.movies.size(); i++) {
            if (movies.movies.get(i).getDirector().getFullName().equalsIgnoreCase(str)) {
                string += movies.movies.get(i).getName() + " ,";
            }
        }
        director.put(str, string);
        System.out.println(director.get(str));

        // movies.movies.stream().filter(n -> n.getDirector().getFullName().equalsIgnoreCase(str)).forEach(System.out::println);
    }

    public static void searchByActor(String str) {
        Map<String, String> actor = new HashMap<>();
        String string = "";
        System.out.println(str);
        for (int i = 0; i < movies.movies.size(); i++) {
            for (int j = 0; j < movies.movies.get(i).getCast().size(); j++) {
                if (movies.movies.get(i).getCast().get(j).getFullName().equalsIgnoreCase(str)) {
                    //  System.out.println(movies.movies.get(i).getName());
                    string += movies.movies.get(i).getName() + " ,";
                }
            }
        }
        actor.put(str, string);
        System.out.println(actor.get(str));
        // movies.movies.forEach(n -> n.getCast().stream().filter(x -> x.getFullName().equalsIgnoreCase(str)).forEach(y -> System.out.println(y.getRole())));
    }

    public static void searchByYear(int num) {
//        System.out.println(num);
//        for (int i = 0; i < movies.movies.size(); i++) {
//            if (movies.movies.get(i).getYear() == num) {
//                System.out.println(movies.movies.get(i).getName());
//            }
//        }
        movies.movies.stream().filter(n -> n.getYear() == num).forEach(y -> System.out.printf("%s\n%s\n%s\n", y.getName(), y.getYear(), y.getDirector()));
    }

    public static void run() {
        AppRunner.readFile();
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        String str = "";
        System.out.println("Выберите действие..\n" +
                "1.Весь список\n" +
                "2.Поиск по частичному или полному названию фильма\n" +
                "3.Сортировка по году выпуска\n" +
                "4.Сортировка по названию\n" +
                "5.Сортировка по режиссеру\n" +
                "6.Поиск по имени актера\n" +
                "7.Поиск по имени режиссера\n" +
                "8.Поиск по году выпуска\n" +
                "9.Список всех актеров с ролями");

        choice = scan.nextInt();
        int x = 0;
        if (choice == 2 || choice == 6 || choice == 7) {
            System.out.println("Введите информацию..");
            scan.nextLine();
            str = scan.nextLine();
        } else if (choice == 8) {
            System.out.println("Введите год..");
            x = scan.nextInt();
        }
        switch (choice) {
            case 1:
                allMoviesPrint();
                break;
            case 2:
                searchMovieByNameOrPartialName(str);
                break;
            case 3:
                sortByYear();
                break;
            case 4:
                sortByMovieName();
                break;
            case 5:
                sortByMovieDirector();
                break;
            case 6:
                searchByActor(str);
                break;
            case 7:
                searchByDirector(str);
                break;
            case 8:
                searchByYear(x);
                break;
            case 9:
            default:
                listOfCast();
                break;
        }
        restart();
        scan.close();
    }

    public static void restart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите продолжить?(y/n)");
        // scan.nextLine();
        if (scanner.nextLine().equalsIgnoreCase("y")) run();
        System.out.println("See you!");
        scanner.close();
    }
}


