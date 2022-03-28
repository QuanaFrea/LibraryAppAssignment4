package com.example.ekmatabdul_comp304_sec002_lab04_group11.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Book {

    //Columns
    @PrimaryKey(autoGenerate = true)
    private int bookId;
    private String title;
    private String author;
    private String description;
    private String category;
    private int quantity;


    //Constructor
    public Book(String title, String author, String description, String category, int quantity) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
    }


    //Getters
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }


    //Setters
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
