package com.alfastore.roomsqlitejava;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    // The getAllWords method returns the LiveData list of words from Room;
    // we can do this because of how we defined the getAlphabetizedWords method to return LiveData
    // in the "The LiveData class" step. Room executes all queries on a separate thread.
    // Then observed LiveData will notify the observer on the main thread when the data has changed.
    LiveData<List<Word>> getmAllWords(){
        return mAllWords;
    }

    // We need to not run the insert on the main thread,
    // so we use the ExecutorService we created in the WordRoomDatabase to perform the insert on a background thread.
    void insert(Word word){
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {mWordDao.insert(word);});
    }
}
