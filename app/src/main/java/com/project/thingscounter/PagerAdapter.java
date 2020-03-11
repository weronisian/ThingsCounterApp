package com.project.thingscounter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int numberOfTabs;

    public PagerAdapter(FragmentManager fm, int nOfTabs){
        super(fm);
        this.numberOfTabs = nOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                FragmentApple fApple = new FragmentApple();
                return fApple;
            case 1:
                FragmentBanana fBanana = new FragmentBanana();
                return fBanana;
            case 2:
                FragmentCoffee fCoffee = new FragmentCoffee();
                return fCoffee;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
