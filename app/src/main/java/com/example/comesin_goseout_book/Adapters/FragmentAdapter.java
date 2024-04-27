package com.example.comesin_goseout_book.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.comesin_goseout_book.Fragments.ExpenseFragment;
import com.example.comesin_goseout_book.Fragments.IncomeFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new IncomeFragment();
            case 1:
                return new ExpenseFragment();
            default:
                throw new IllegalArgumentException("Invalid position");
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
