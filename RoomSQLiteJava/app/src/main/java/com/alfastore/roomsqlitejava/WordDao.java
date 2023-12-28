package com.alfastore.roomsqlitejava;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

// WordDao is an interface; DAOs must either be interfaces or abstract classes.
@Dao
public interface WordDao {
    // 1.) The @Insert annotation is a special DAO method annotation where you don't have to provide
    // any SQL! (There are also @Delete and @Update annotations for deleting and updating rows,
    // but you are not using them in this app.)
    // 2.) onConflict = OnConflictStrategy.IGNORE: The selected on conflict strategy ignores a new word if it's exactly the same as one already in the list.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    // Declares a method to insert one word:
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
//    List<Word> getAlphabetizedWords();
    // LiveData
    LiveData<List<Word>> getAlphabetizedWords();
}
