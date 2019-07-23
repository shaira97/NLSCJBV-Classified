package unsw.Infs3605.Mydegree;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class year2_pageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public year2_pageAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                year2_Term1 year2Term1 = new year2_Term1();
                return year2Term1;

            case 1:
                year2_Term2 year2Term2 = new year2_Term2();
                return year2Term2;

            case 2:
                year2_Term3 year2Term3 = new year2_Term3();
                return year2Term3;
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
