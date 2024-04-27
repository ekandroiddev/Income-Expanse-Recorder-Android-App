package com.example.comesin_goseout_book.AppDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class ExpanseDataModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "expanse_Type")
    public String expanseType;
    @ColumnInfo(name = "expanse_Amount")
    public String expanseAmount;


    public ExpanseDataModel(int id, String expanseType, String expanseAmount) {
        this.id = id;
        this.expanseType = expanseType;
        this.expanseAmount = expanseAmount;
    }
    @Ignore
    public ExpanseDataModel(String expanseType, String expanseAmount) {
        this.expanseType = expanseType;
        this.expanseAmount = expanseAmount;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpanseType() {
        return expanseType;
    }

    public void setExpanseType(String expanseType) {
        this.expanseType = expanseType;
    }

    public String getExpanseAmount() {
        return expanseAmount;
    }

    public void setExpanseAmount(String expanseAmount) {
        this.expanseAmount = expanseAmount;
    }
}
