package com.example.uee_banking_app_android;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class BillPaymentsPagesAdapter extends FragmentPagerAdapter {
    private int num ;

    BillPaymentsPagesAdapter(FragmentManager fm, int numTabs){
        super(fm);
        this.num = numTabs ;
    }

    @Override
    public Fragment getItem(int position){
        switch(position){
            case 0:
                return new BillAddProvider();
            case 1:
                return new BillMyProviders();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return num ;
    }
}
