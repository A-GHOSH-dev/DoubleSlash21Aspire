package com.example.krishisahayak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class Home extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager;
    FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tabLayout=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.view_pager);

        FragmentManager fm =getSupportFragmentManager();
        adapter = new FragmentAdapter(fm,getLifecycle());
        viewPager.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Farmer's Corner"));
        tabLayout.addTab(tabLayout.newTab().setText("Customer's Corner"));
        tabLayout.addTab(tabLayout.newTab().setText("NGO/Consultant's Corner"));
        tabLayout.addTab(tabLayout.newTab().setText("Agro News"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
//        Intent i =getIntent();
//        int pos=i.getIntExtra("key",0);
//        if(pos==1){
//            Toast.makeText(Home.this,"it worked!",Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(Home.this,Streekrishi.class);
//            startActivity(intent);
//        }

    }
}