package com.example.ekmatabdul_comp304_sec002_lab04_group11.Library;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.ekmatabdul_comp304_sec002_lab04_group11.Dao.BookDao;
import com.example.ekmatabdul_comp304_sec002_lab04_group11.Dao.LibrarianDao;
import com.example.ekmatabdul_comp304_sec002_lab04_group11.Dao.StudentDao;
import com.example.ekmatabdul_comp304_sec002_lab04_group11.Entity.Book;
import com.example.ekmatabdul_comp304_sec002_lab04_group11.Entity.Librarian;
import com.example.ekmatabdul_comp304_sec002_lab04_group11.Entity.Student;

@Database(entities = {Book.class, Librarian.class, Student.class}, version = 1)
public abstract class LibraryDatabase extends RoomDatabase {

    private static LibraryDatabase instance;

    public abstract BookDao bookDao();
    public abstract StudentDao studentDao();
    public abstract LibrarianDao librarianDao();

    public static synchronized LibraryDatabase getInstance(Context context){
        if (instance == null)
            instance = Room.databaseBuilder(context.getApplicationContext(), LibraryDatabase.class, "library")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        return instance;
    }

    private static Callback roomCallback = new Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private LibrarianDao librarianDao;
        private BookDao bookDao;
        private StudentDao studentDao;

        private PopulateDbAsyncTask(LibraryDatabase db){
            librarianDao = db.librarianDao();
            studentDao = db.studentDao();
            bookDao = db.bookDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            librarianDao.insert(new Librarian(1, "Yash", "Sheth", "COMP304"));
            librarianDao.insert(new Librarian(7, "James", "Bond", "CasinoRoyale"));
            studentDao.insert(new Student(1, "Yash", "Sheth", "COMP304"));
            studentDao.insert(new Student(7, "James", "Bond", "CasinoRoyale"));
            bookDao.insert(new Book("Harry Potter And The Deathly Hollows", "JK Rowling", "The title of the book refers to three mythical objects featured in the story, collectively known as the \"Deathly Hallows\"—an unbeatable wand (the Elder Wand), a stone to bring the dead to life (the Resurrection Stone), and a cloak of invisibility.", "Fiction", 9));
            bookDao.insert(new Book("Lord of the Rings: Return of The King", "Peter Jackson", "The Return of the King, the third and final volume in The Lord of the Rings, opens as Gandalf and Pippin ride east to the city of Minas Tirith in Gondor, just after parting with King Théoden and the Riders of Rohan at the end of The Two Towers.", "Fiction", 8));
            bookDao.insert(new Book("City of Ember", "Jeanne DuPrau", "The story is about Ember, a post-apocalyptic underground city threatened by aging infrastructure and corruption. The young protagonist, Lina Mayfleet, and her friend, Doon Harrow (the second protagonist), follow clues left behind by the original builders of the City of Ember, to safety in the outside world.", "Fiction", 6));
            bookDao.insert(new Book("Rich Dad, Poor Dad", "Robert Kiyosaki", "Rich Dad Poor Dad tells the story of a boy with two fathers, one rich, one poor, to help you develop the mindset and financial knowledge you need to build a life of wealth and freedom", "Educational", 7));
            bookDao.insert(new Book("Android Cookbook", "Ian Darwin", "Jump in and build working Android apps with the help of more than 200 tested recipes. With this cookbook, you’ll find solutions for working with the user interfaces, multitouch gestures, location awareness, web services, and device features such as the phone, camera, and accelerometer", "Educational", 3));
            bookDao.insert(new Book("The Guns of August", "Barbara Tuchman", "The Guns of August is a volume of history by Barbara W. Tuchman. It is centered on the first month of World War I. After introductory chapters, Tuchman describes in great detail the opening events of the conflict.", "History", 4));
            bookDao.insert(new Book("1776", "David McCullough", "1776 is a book written by David McCullough, published by Simon & Schuster on May 24, 2005. The work is a companion to McCullough's earlier biography of John Adams, and focuses on the events surrounding the start of the American Revolutionary War.", "History", 4));
            bookDao.insert(new Book("Educated", "Tara Westover", "Educated is a memoir by the American author Tara Westover. Westover recounts overcoming her survivalist Mormon family in order to go to college, and emphasizes the importance of education in enlarging her world", "NonFiction", 7));
            bookDao.insert(new Book("Silent Spring", "Rachel Carson", "Silent Spring is an environmental science book by Rachel Carson. The book was published on September 27, 1962, documenting the adverse environmental effects caused by the indiscriminate use of pesticides.", "NonFiction", 13));
            bookDao.insert(new Book("In Cold Blood", "Truman Capote", "In Cold Blood is a non-fiction novel by American author Truman Capote, first published in 1966. It details the 1959 murders of four members of the Clutter family in the small farming community of Holcomb, Kansas", "NonFiction", 19));
            return null;
        }
    }
}
