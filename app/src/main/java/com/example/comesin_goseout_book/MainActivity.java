package com.example.comesin_goseout_book;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.comesin_goseout_book.Adapters.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FragmentAdapter fragmentAdapter = new FragmentAdapter(this);
        viewPager2.setAdapter(fragmentAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setCustomView(R.layout.custom_comes_in_tab);
                    break;
                case 1:
                     tab.setCustomView(R.layout.custom_goes_out_tab);
                    break;
            }
        }).attach();

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                int color;
                switch (position) {
                    case 0:
                        color = ContextCompat.getColor(getApplicationContext(), R.color.green);
                        break;
                    case 1:
                        color = ContextCompat.getColor(getApplicationContext(), R.color.red);
                        break;
                    default:
                        color = ContextCompat.getColor(getApplicationContext(), android.R.color.black);
                }
                tabLayout.setSelectedTabIndicatorColor(color);
            }
        });
    }
}