package com.example.comesin_goseout_book;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.comesin_goseout_book.AppDatabase.AppDatabase;
import com.example.comesin_goseout_book.AppDatabase.ExpanseDAO;
import com.example.comesin_goseout_book.AppDatabase.ExpanseDataModel;
import com.example.comesin_goseout_book.AppDatabase.IncomeDAO;
import com.example.comesin_goseout_book.AppDatabase.IncomeDataModel;

import java.util.Objects;

public class Custom_Dialog_Box extends androidx.fragment.app.DialogFragment {

    EditText amountType,amount;
    RadioGroup radioGroup;
    RadioButton incometype,expansetype;

    Button cancleBtn,saveBtn;
    String amounttype, Amount;
    AppDatabase appDatabase;

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            Objects.requireNonNull(getDialog().getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_dialog_box, container, false);

        amountType=view.findViewById(R.id.amountType);
        amount=view.findViewById(R.id.amount);
        radioGroup = view.findViewById(R.id.radioGroup);
        cancleBtn=view.findViewById(R.id.cancle);
        saveBtn=view.findViewById(R.id.saveData);
        incometype=view.findViewById(R.id.incomeamount);
        expansetype=view.findViewById(R.id.expanseamount);

        appDatabase=AppDatabase.getInstance(getContext());


        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId==R.id.incomeamount){
                incometype.setChecked(true);
            }
            if (checkedId==R.id.expanseamount){
                expansetype.setChecked(true);
            }

        });
        saveBtn.setOnClickListener(v -> {
            amounttype=amountType.getText().toString();
            Amount=amount.getText().toString();
            if (!amounttype.isEmpty() && !Amount.isEmpty()){
                if (incometype.isChecked()){
                    Toast.makeText(getContext(), "Selected: Income", Toast.LENGTH_SHORT).show();
                    IncomeDataModel incomeDataModel=new IncomeDataModel(amounttype,Amount);
                    AppDatabase.executorService.execute(() -> {
                        IncomeDAO incomeDAO= appDatabase.incomeDAO();
                        incomeDAO.insertIncome(incomeDataModel);

                    });
                    dismiss();
                }
                if (expansetype.isChecked()) {
                    Toast.makeText(getContext(), "Selected:Expense ", Toast.LENGTH_SHORT).show();
                    ExpanseDataModel expanseDataModel=new ExpanseDataModel(amounttype,Amount);
                    AppDatabase.executorService.execute(() -> {
                        ExpanseDAO expanseDAO= appDatabase.expanseDAO();
                        expanseDAO.insertExpanse(expanseDataModel);
                    });
                    dismiss();
                }

            }else {
                dismiss();
                Toast.makeText(getContext(), "input data correctly", Toast.LENGTH_SHORT).show();
            }
        });
        cancleBtn.setOnClickListener(v -> dismiss());


        return view;
    }
}
