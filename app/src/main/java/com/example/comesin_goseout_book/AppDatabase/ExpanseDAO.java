package com.example.comesin_goseout_book.AppDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpanseDAO {
    @Query("SELECT * FROM ExpanseDataModel")
    LiveData<List<ExpanseDataModel>> getAllExpanse();
    @Insert
    void insertExpanse(ExpanseDataModel expanseDataModel);
    @Update
    void updateExpanse(ExpanseDataModel expanseDataModel);
    @Delete
    void deleatExpanse(ExpanseDataModel expanseDataModel);
}
