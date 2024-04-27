package com.example.comesin_goseout_book.AppDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {IncomeDataModel.class, ExpanseDataModel.class},version = 2,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME="app_Database";
    private static AppDatabase appDataBaseInstance;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService executorService =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized AppDatabase getInstance(Context context){
        if (appDataBaseInstance == null){
            appDataBaseInstance=Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return appDataBaseInstance;
    }

    public abstract IncomeDAO incomeDAO();
    public abstract ExpanseDAO expanseDAO();
}
