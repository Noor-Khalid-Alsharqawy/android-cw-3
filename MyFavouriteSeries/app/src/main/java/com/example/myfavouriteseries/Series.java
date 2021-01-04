package com.example.myfavouriteseries;

import java.io.Serializable;

public class Series implements Serializable {
    private String name;
    private int seasons;
    private int episodes;
    private double rating;
    private int image;
    private String genre;
    private String year;
    private String language;

    public Series(String name, int seasons, int episodes, double rating, int image,
                  String genre, String year, String language) {
        this.name = name;
        this.seasons = seasons;
        this.episodes = episodes;
        this.rating = rating;
        this.image = image;
        this.genre = genre;
        this.year = year;
        this.language = language;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

    public String getYear() { return year; }

    public void setYear(String year) { this.year = year; }

    public String getLanguage() { return language; }

    public void setLanguage(String language) { this.language = language; }
}
