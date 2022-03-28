package com.example.ekmatabdul_comp304_sec002_lab04_group11.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ekmatabdul_comp304_sec002_lab04_group11.Entity.Librarian;

import java.util.List;

@Dao
public interface LibrarianDao {

    @Insert
    void insert(Librarian librarian);

    @Query("SELECT * FROM Librarian")
    List<Librarian> getAllLibrarians();
}
