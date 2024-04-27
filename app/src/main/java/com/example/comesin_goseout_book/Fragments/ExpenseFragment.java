package com.example.comesin_goseout_book.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.comesin_goseout_book.Adapters.RecyclerViewExpanseAdapter;
import com.example.comesin_goseout_book.AppDatabase.AppDatabase;
import com.example.comesin_goseout_book.AppDatabase.ExpanseDAO;
import com.example.comesin_goseout_book.Custom_Dialog_Box;
import com.example.comesin_goseout_book.R;

import java.util.ArrayList;


public class ExpenseFragment extends Fragment {

    RecyclerView recyclerView;
    ImageButton addExpanseBtn;
    RecyclerViewExpanseAdapter recyclerViewExpanseAdapter;

    public ExpenseFragment() {
        // Required empty public constructor
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expense, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewExpanse);
        addExpanseBtn = view.findViewById(R.id.addExpenseBtn);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewExpanseAdapter = new RecyclerViewExpanseAdapter(requireActivity().getApplicationContext(), new ArrayList<>());
        recyclerView.setAdapter(recyclerViewExpanseAdapter);


        AppDatabase appDatabase = AppDatabase.getInstance(requireActivity().getApplicationContext());
        ExpanseDAO expanseDAO = appDatabase.expanseDAO();
        expanseDAO.getAllExpanse().observe(getViewLifecycleOwner(), expanseDataModels -> {
            recyclerViewExpanseAdapter.setExpanseDataList(expanseDataModels);
            recyclerViewExpanseAdapter.notifyDataSetChanged();

        });

        addExpanseBtn.setOnClickListener(v -> {
            Custom_Dialog_Box customDialogBox = new Custom_Dialog_Box();
            customDialogBox.show(requireActivity().getSupportFragmentManager(), "Fragment");
        });
        return view;
    }
}