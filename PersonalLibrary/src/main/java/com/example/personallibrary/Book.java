package com.example.personallibrary;

import java.io.Serializable;

public class Book implements Serializable {
    public String Title;
    public String Author;
    public int ID;
    public double Rating;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    public Book(String title, String author, int ID, double rating) {
        Title = title;
        Author = author;
        this.ID = ID;
        Rating = rating;
    }
}

