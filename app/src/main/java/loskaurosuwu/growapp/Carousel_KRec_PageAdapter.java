package loskaurosuwu.growapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class Carousel_KRec_PageAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener{
    public final static float BIG_SCALE = 1.0f;
    public final static float SMALL_SCALE = 0.7f;
    public final static float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;
    private Que_Reciclo context;
    private FragmentManager fragmentManager;
    private float scale;

    public Carousel_KRec_PageAdapter(Que_Reciclo context, FragmentManager fm) {
        super(fm);
        this.fragmentManager = fm;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        // make the first pager bigger than others
        try {
            if (position == Que_Reciclo.FIRST_PAGE)
                scale = BIG_SCALE;
            else
                scale = SMALL_SCALE;

            position = position % Que_Reciclo.count;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ItemFragment.newInstance(context, position, scale);
    }

    @Override
    public int getCount() {
        int count = 0;
        try {
            count = Que_Reciclo.count * Que_Reciclo.LOOPS;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        try {
            if (positionOffset >= 0f && positionOffset <= 1f) {
                Carousel_KRec_LinearLayout cur = getRootView(position);
                if(position + 1 < Que_Reciclo.count) {
                    Carousel_KRec_LinearLayout next = getRootView(position + 1);
                    next.setScaleBoth(SMALL_SCALE + DIFF_SCALE * positionOffset);
                }
                cur.setScaleBoth(BIG_SCALE - DIFF_SCALE * positionOffset);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @SuppressWarnings("ConstantConditions")
    private Carousel_KRec_LinearLayout getRootView(int position) {
        return (Carousel_KRec_LinearLayout) fragmentManager.findFragmentByTag(this.getFragmentTag(position))
                .getView().findViewById(R.id.root_container);
    }

    private String getFragmentTag(int position) {
        return "android:switcher:" + context.pager.getId() + ":" + position;
    }
}
