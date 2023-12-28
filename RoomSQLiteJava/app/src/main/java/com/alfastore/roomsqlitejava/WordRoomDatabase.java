package com.alfastore.roomsqlitejava;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 1.) The database class for Room must be abstract and extend RoomDatabase
// 2.) You annotate the class to be a Room database with @Database and use the annotation parameters
// to declare the entities that belong in the database and set the version number. Each entity
// corresponds to a table that will be created in the database. Database migrations are beyond the
// scope of this codelab, so we set exportSchema to false here to avoid a build warning. In a real app,
// you should consider setting a directory for Room to use to export the schema so you can check the
// current schema into your version control system.
@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {
    public abstract WordDao wordDao();

    // We've defined a singleton, WordRoomDatabase, to prevent having multiple instances of the database opened at the same time.
    private static volatile WordRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    // We've created an ExecutorService with a fixed thread pool that you will use to run database operations asynchronously on a background thread.
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null){
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                WordDao dao = INSTANCE.wordDao();
                dao.deleteAll();

                Word word = new Word("Hello");
                dao.insert(word);
                word = new Word("World");
                dao.insert(word);
            });
        }
    };
}
