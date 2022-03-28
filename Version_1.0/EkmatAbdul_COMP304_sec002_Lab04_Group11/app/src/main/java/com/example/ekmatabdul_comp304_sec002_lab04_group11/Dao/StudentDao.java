package com.example.ekmatabdul_comp304_sec002_lab04_group11.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ekmatabdul_comp304_sec002_lab04_group11.Entity.Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insert(Student student);

    @Query("SELECT * FROM Student")
    List<Student> getAllStudents();

}
