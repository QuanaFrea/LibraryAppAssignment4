package com.example.ekmatabdul_comp304_sec002_lab04_group11.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ekmatabdul_comp304_sec002_lab04_group11.Entity.Book;

import java.util.List;

@Dao
public interface BookDao {

    @Insert
    void insert(Book book);

    @Update
    void update(Book book);

    @Delete
    void delete(Book book);

    @Query("SELECT * FROM Book")
    LiveData<List<Book>> getAllBooks();
}
