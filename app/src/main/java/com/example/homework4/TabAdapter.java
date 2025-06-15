package com.example.homework4;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class TabAdapter extends FragmentStateAdapter {

    private final List<Fragment> fragments;
    private final List<String> tabTitles;

    public TabAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragments, List<String> tabTitles) {
        super(fragmentActivity);
        this.fragments = fragments;
        this.tabTitles = tabTitles;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }

    public String getTabTitle(int position) {
        return tabTitles.get(position);
    }
}