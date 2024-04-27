package com.example.comesin_goseout_book.AppDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class IncomeDataModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "income_type")
    public String incomeType;
    @ColumnInfo(name = "income_Amount")
    public String incomeAmount;

    public IncomeDataModel(int id, String incomeType, String incomeAmount) {
        this.id = id;
        this.incomeType = incomeType;
        this.incomeAmount = incomeAmount;
    }
    @Ignore
    public IncomeDataModel(String incomeType, String incomeAmount) {
        this.incomeType = incomeType;
        this.incomeAmount = incomeAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    public String getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(String incomeAmount) {
        this.incomeAmount = incomeAmount;
    }
}
