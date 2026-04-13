package com.jlboat.phone.adapter;
public class MainFragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    java.util.ArrayList list;

    public MainFragmentPagerAdapter(android.support.v4.app.FragmentManager p1, java.util.ArrayList p2)
    {
        super(p1);
        super.list = p2;
        return;
    }

    public int getCount()
    {
        return this.list.size();
    }

    public android.support.v4.app.Fragment getItem(int p2)
    {
        return ((android.support.v4.app.Fragment) this.list.get(p2));
    }
}
