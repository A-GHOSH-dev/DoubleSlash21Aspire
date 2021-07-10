package com.example.krishisahayak;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new FarmersCorner();
            case 2:
                return new customersCorner();
            case 3:
                return new ngoCorner();
            case 4:
                return new agroNews();
            case 5:
                return new Contact();
        }
        return new FirstFragment();
    }

    @Override
    public int getItemCount() {
        return 5+1;
    }
}
