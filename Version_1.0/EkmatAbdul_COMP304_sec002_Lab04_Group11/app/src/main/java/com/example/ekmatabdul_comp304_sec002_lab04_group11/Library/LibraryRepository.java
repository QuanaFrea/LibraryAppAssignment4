package com.example.ekmatabdul_comp304_sec002_lab04_group11.Library;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.ekmatabdul_comp304_sec002_lab04_group11.Dao.BookDao;
import com.example.ekmatabdul_comp304_sec002_lab04_group11.Dao.LibrarianDao;
import com.example.ekmatabdul_comp304_sec002_lab04_group11.Dao.StudentDao;
import com.example.ekmatabdul_comp304_sec002_lab04_group11.Entity.Book;
import com.example.ekmatabdul_comp304_sec002_lab04_group11.Entity.Librarian;
import com.example.ekmatabdul_comp304_sec002_lab04_group11.Entity.Student;

import java.util.List;

public class LibraryRepository {
    private BookDao bookDao;
    private LibrarianDao librarianDao;
    private StudentDao studentDao;
    private LiveData<List<Book>> allBooks;
    private List<Student> allStudents;
    private List<Librarian> allLibrarians;

    public LibraryRepository(Application application) {
        LibraryDatabase database = LibraryDatabase.getInstance(application);
        bookDao = database.bookDao();
        studentDao = database.studentDao();
        librarianDao = database.librarianDao();
        allBooks = bookDao.getAllBooks();
        allStudents = studentDao.getAllStudents();
        allLibrarians = librarianDao.getAllLibrarians();
    }

    //BookDao method
    public void insert(Book book){
        new InsertBookAsyncTask(bookDao).execute(book);
    }

    public void update(Book book){
        new UpdateBookAsyncTask(bookDao).execute(book);
    }

    public void delete(Book book){
        new DeleteBookAsyncTask(bookDao).execute(book);
    }

    public LiveData<List<Book>> getAllBooks(){
        return allBooks;
    }


    //LibrarianDao methods
    public void insert(Librarian librarian){
        new InsertLibrarianAsyncTask(librarianDao).execute(librarian);
    }

    public List<Librarian> getAllLibrarians(){
        return allLibrarians;
    }


    //StudentDao methods
    public void insert(Student student){
        new InsertStudentAsyncTask(studentDao).execute(student);
    }

    public List<Student> getAllStudents(){
        return allStudents;
    }


    private static class InsertBookAsyncTask extends AsyncTask<Book, Void, Void>{
        private BookDao bookDao;

        private InsertBookAsyncTask(BookDao bookDao){
            this.bookDao = bookDao;
        }
        @Override
        protected Void doInBackground(Book... books) {
            bookDao.insert(books[0]);
            return null;
        }
    }
    private static class UpdateBookAsyncTask extends AsyncTask<Book, Void, Void>{
        private BookDao bookDao;

        private UpdateBookAsyncTask(BookDao bookDao){
            this.bookDao = bookDao;
        }
        @Override
        protected Void doInBackground(Book... books) {
            bookDao.update(books[0]);
            return null;
        }
    }
    private static class DeleteBookAsyncTask extends AsyncTask<Book, Void, Void>{
        private BookDao bookDao;

        private DeleteBookAsyncTask(BookDao bookDao){
            this.bookDao = bookDao;
        }
        @Override
        protected Void doInBackground(Book... books) {
            bookDao.delete(books[0]);
            return null;
        }
    }

    private static class InsertStudentAsyncTask extends AsyncTask<Student, Void, Void>{
        private StudentDao studentDao;

        private InsertStudentAsyncTask(StudentDao studentDao){
            this.studentDao = studentDao;
        }
        @Override
        protected Void doInBackground(Student... students) {
            studentDao.insert(students[0]);
            return null;
        }
    }

    private static class InsertLibrarianAsyncTask extends AsyncTask<Librarian, Void, Void>{
        private LibrarianDao librarianDao;

        private InsertLibrarianAsyncTask(LibrarianDao librarianDao){
            this.librarianDao = librarianDao;
        }
        @Override
        protected Void doInBackground(Librarian... librarians) {
            librarianDao.insert(librarians[0]);
            return null;
        }
    }
}
