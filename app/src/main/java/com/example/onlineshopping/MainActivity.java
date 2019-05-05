package com.example.onlineshopping;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tabId);
        viewPager=findViewById(R.id.view_pager);

        ViewPagerFragmentAdapter viewPagerFragmentAdapter=new ViewPagerFragmentAdapter(getSupportFragmentManager());


        viewPagerFragmentAdapter.addFragment(new Login(),"Login");
        viewPagerFragmentAdapter.addFragment(new Register(),"Register");

        viewPager.setAdapter(viewPagerFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
