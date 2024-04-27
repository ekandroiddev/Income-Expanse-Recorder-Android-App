package com.example.comesin_goseout_book.AppDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface IncomeDAO {
    @Query("SELECT * FROM incomedatamodel")
    LiveData<List<IncomeDataModel>> getAllIncome();
    @Insert
    void insertIncome(IncomeDataModel incomeDataModel);
    @Delete
    void deleteIncome(IncomeDataModel incomeDataModel);
    @Update
    void updateIncome(IncomeDataModel incomeDataModel);
}
