package unsw.Infs3605.Mydegree;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class year1_pageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public year1_pageAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                year1_Term1 year1Term1 = new year1_Term1();
                return year1Term1;

            case 1:
                year1_Term2 year1Term2 = new year1_Term2();
                return year1Term2;

            case 2:
                year1_Term3 year1Term3 = new year1_Term3();
                return year1Term3;
            default:
                return null;
        }
    }


    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;

    }

    @Override
    public int getCount() {

        return 3;
    }
}

