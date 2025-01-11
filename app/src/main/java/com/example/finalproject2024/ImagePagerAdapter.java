package com.example.finalproject2024;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ImagePagerAdapter extends PagerAdapter {
    private Context mContext;
    private int[] mImageIds;
    private ViewPager mViewPager;
    private Handler mHandler;
    private Runnable mRunnable;
    private int mCurrentPage = 0;

    public ImagePagerAdapter(Context context, int[] imageIds, ViewPager viewPager) {
        mContext = context;
        mImageIds = imageIds;
        mViewPager = viewPager;
        mHandler = new Handler(Looper.getMainLooper());
        startAutoSlider();
    }

    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.pager_item, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(mImageIds[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    private void startAutoSlider() {
        mRunnable = new Runnable() {
            @Override
            public void run() {
                if (mCurrentPage == mImageIds.length) {
                    mCurrentPage = 0;
                }
                mViewPager.setCurrentItem(mCurrentPage++, true);
                mHandler.postDelayed(this, 3000); // Repeat every 3 seconds
            }
        };
        mHandler.postDelayed(mRunnable, 3000); // Delay 3 seconds
    }

    public void stopAutoSlider() {
        mHandler.removeCallbacks(mRunnable);
    }
}
