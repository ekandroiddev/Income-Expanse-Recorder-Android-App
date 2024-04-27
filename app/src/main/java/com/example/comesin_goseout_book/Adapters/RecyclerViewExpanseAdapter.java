package com.example.comesin_goseout_book.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comesin_goseout_book.AppDatabase.ExpanseDataModel;
import com.example.comesin_goseout_book.R;

import java.util.List;

public class RecyclerViewExpanseAdapter extends RecyclerView.Adapter<RecyclerViewExpanseAdapter.ViewHolder> {

    Context context;
    List<ExpanseDataModel> expanseDataModels;

    public RecyclerViewExpanseAdapter(Context context, List<ExpanseDataModel> expanseDataModels) {
        this.context = context;
        this.expanseDataModels = expanseDataModels;
    }

    public void setExpanseDataList(List<ExpanseDataModel> expanseDataModels){
        this.expanseDataModels=expanseDataModels;
    }

    @NonNull
    @Override
    public RecyclerViewExpanseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.expanse_view_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewExpanseAdapter.ViewHolder holder, int position) {

        ExpanseDataModel expanseDataModel=expanseDataModels.get(position);
        holder.expanseType.setText(expanseDataModel.getExpanseType());
        holder.expanseAmount.setText(expanseDataModel.getExpanseAmount());

    }

    @Override
    public int getItemCount() {
        return expanseDataModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView expanseType,expanseAmount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            expanseType=itemView.findViewById(R.id.expanseType);
            expanseAmount=itemView.findViewById(R.id.expanseAmount);
        }
    }
}
