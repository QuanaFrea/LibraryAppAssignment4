package com.example.ekmatabdul_comp304_sec002_lab04_group11.Library;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ekmatabdul_comp304_sec002_lab04_group11.Entity.Book;
import com.example.ekmatabdul_comp304_sec002_lab04_group11.Entity.Librarian;
import com.example.ekmatabdul_comp304_sec002_lab04_group11.Entity.Student;

import java.util.List;

public class LibraryViewModel extends AndroidViewModel {
    private LibraryRepository repository;
    private LiveData<List<Book>> allBooks;
    private List<Student> allStudents;
    private List<Librarian> allLibrarians;

    public LibraryViewModel(@NonNull Application application) {
        super(application);
        repository = new LibraryRepository(application);
        allBooks = repository.getAllBooks();
        allStudents = repository.getAllStudents();
        allLibrarians = repository.getAllLibrarians();
    }

    //Book methods
    public void insert(Book book){
        repository.insert(book);
    }

    public void update(Book book){
        repository.update(book);
    }

    public void delete(Book book){
        repository.delete(book);
    }

    public LiveData<List<Book>> getAllBooks(){
        return allBooks;
    }


    //Librarian methods
    public void insert(Librarian librarian){
        repository.insert(librarian);
    }

    public List<Librarian> getAllLibrarians(){
        return allLibrarians;
    }


    //Student methods
    public void insert(Student student){
        repository.insert(student);
    }

    public List<Student> getAllStudents(){
        return allStudents;
    }
}
