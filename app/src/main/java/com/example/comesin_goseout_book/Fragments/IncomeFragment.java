package com.example.comesin_goseout_book.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.comesin_goseout_book.Adapters.RecyclerViewIncomeAdapter;
import com.example.comesin_goseout_book.AppDatabase.AppDatabase;
import com.example.comesin_goseout_book.AppDatabase.IncomeDAO;
import com.example.comesin_goseout_book.Custom_Dialog_Box;
import com.example.comesin_goseout_book.R;

import java.util.ArrayList;
import java.util.Objects;


public class IncomeFragment extends Fragment {

    RecyclerView recyclerView;
    ImageButton addIncomeBtn;
    RecyclerViewIncomeAdapter recyclerViewIncomeAdapter;


    public IncomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_income, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewIncome);
        addIncomeBtn = view.findViewById(R.id.addIncomeBtn);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewIncomeAdapter = new RecyclerViewIncomeAdapter(requireActivity().getApplicationContext(), new ArrayList<>());
        recyclerView.setAdapter(recyclerViewIncomeAdapter);

        AppDatabase appDatabase = AppDatabase.getInstance(requireActivity().getApplicationContext());
        IncomeDAO incomeDAO = appDatabase.incomeDAO();
        incomeDAO.getAllIncome().observe(getViewLifecycleOwner(), incomeDataModels -> {
            recyclerViewIncomeAdapter.setIncomeDataList(incomeDataModels);
            recyclerViewIncomeAdapter.notifyDataSetChanged();

        });
        addIncomeBtn.setOnClickListener(v -> {
            Custom_Dialog_Box customDialogBox = new Custom_Dialog_Box();
            customDialogBox.show(requireActivity().getSupportFragmentManager(), "Fragment");
        });

        return view;
    }
}