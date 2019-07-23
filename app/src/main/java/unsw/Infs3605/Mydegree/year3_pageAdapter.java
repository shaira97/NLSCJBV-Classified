package unsw.Infs3605.Mydegree;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class year3_pageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public year3_pageAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                year3_Term1 year3Term1 = new year3_Term1();
                return year3Term1;

            case 1:
                year3_Term2 year3Term2 = new year3_Term2();
                return year3Term2;

            case 2:
                year3_Term3 year3Term3 = new year3_Term3();
                return year3Term3;
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
