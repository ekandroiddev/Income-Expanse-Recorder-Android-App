package com.example.comesin_goseout_book.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comesin_goseout_book.AppDatabase.IncomeDataModel;
import com.example.comesin_goseout_book.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class RecyclerViewIncomeAdapter extends RecyclerView.Adapter<RecyclerViewIncomeAdapter.ViewHolder> {
    Context context;
    List<IncomeDataModel> allIncomeData;

    public RecyclerViewIncomeAdapter(Context context, List<IncomeDataModel> allIncomeData) {
        this.context=context;
        this.allIncomeData=allIncomeData;
    }
    public void setIncomeDataList(List<IncomeDataModel> allIncomeData) {
        this.allIncomeData = allIncomeData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.income_view_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        IncomeDataModel incomeDataModel=allIncomeData.get(position);
        holder.incomeType.setText(incomeDataModel.getIncomeType());
        holder.incomeAmount.setText(incomeDataModel.getIncomeAmount());
    }

    @Override
    public int getItemCount() {
        return allIncomeData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView incomeType,incomeAmount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            incomeType=itemView.findViewById(R.id.incomeType);
            incomeAmount=itemView.findViewById(R.id.incomeAmount);
        }
    }
}
