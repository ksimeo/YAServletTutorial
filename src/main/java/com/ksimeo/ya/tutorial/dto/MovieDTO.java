package com.ksimeo.ya.tutorial.dto;

import com.ksimeo.ya.tutorial.models.Actor;
import com.ksimeo.ya.tutorial.models.Director;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Ksimeo. Created on 01.11.2016 at 19:47 for "Movies(withServlets)" project.
 * @version 1.0
 * @since 1.0
 */
public class MovieDTO {
    public String title;
    public String description;
    public LocalDate year;
    public List<Actor> cast;
    public Director director;

    public MovieDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
