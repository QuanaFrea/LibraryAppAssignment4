package com.example.ekmatabdul_comp304_sec002_lab04_group11.Entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = Book.class,
                parentColumns = "bookId",
                childColumns = "bookId",
                onDelete = ForeignKey.CASCADE)})
public class Student {

    //Columns
    @PrimaryKey
    private int studentId;
    private String firstName;
    private String lastName;
    private String password;
    private int bookId;


    //Constructor
    public Student(int studentId, String firstName, String lastName, String password) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.bookId = 1;
    }


    //Getters
    public int getStudentId() {
        return studentId;
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

    public int getBookId() {
        return bookId;
    }


    //Setters
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
