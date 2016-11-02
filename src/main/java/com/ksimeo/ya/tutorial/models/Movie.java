package com.ksimeo.ya.tutorial.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Ksimeo. Created on 01.11.2016 at 19:01 for "Movies(withServlets)" project.
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    private int id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private LocalDate year;
    @Column
    private Director director;
    @Column
    @OneToMany
    private List<Actor> cast;


    public Movie() {
    }

    public Movie(String title, String description, LocalDate year, Director director, List<Actor> cast) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.director = director;
        this.cast = cast;
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

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }
}
