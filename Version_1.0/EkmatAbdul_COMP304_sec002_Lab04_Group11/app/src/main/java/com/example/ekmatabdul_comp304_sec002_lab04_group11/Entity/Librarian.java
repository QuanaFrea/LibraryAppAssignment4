package com.example.ekmatabdul_comp304_sec002_lab04_group11.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Librarian {

    //Columns
    @PrimaryKey
    private int librarianId;
    private String firstName;
    private String lastName;
    private String password;


    //Constructor
    public Librarian(int librarianId, String firstName, String lastName, String password) {
        this.librarianId = librarianId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }


    //Getters
    public int getLibrarianId() {
        return librarianId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }


    //Setters
    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }
}
