package com.jh.rental.user.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jh.rental.user.R;

public class LoopNewsView extends RelativeLayout {
	
	private ViewPager mViewPager;
	private LinearLayout mDotsContainer;
	private int mLastPosition = 0;
	private int mDotSize;
	private AutoChangTask mTask;
	private int[] mImages = {Color.parseColor("#61fdff"),Color.parseColor("#C2185B"),Color.parseColor("#50B4FD"),Color.parseColor("#303F9F")};
	public LoopNewsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LoopNewsView);
		mDotSize =  a.getDimensionPixelSize(R.styleable.LoopNewsView_dot_size, 12);
		a.recycle();
		init();
	}

	private void init() {
		LayoutInflater.from(getContext()).inflate(R.layout.view_loop_news,this);
        initView();
        initData();
        initEvent();
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
	}

	private void initEvent() {
    	mViewPager.addOnPageChangeListener(mOnPageChangeListener);
	}
    
    private OnPageChangeListener mOnPageChangeListener = new OnPageChangeListener() {
		@Override
		public void onPageSelected(int position) {
			position = position % mImages.length;
			if (position == mLastPosition) {
				return;
			}
			View dot = mDotsContainer.getChildAt(position);
			dot.setBackgroundResource(R.drawable.point_normal);
			View preDot = mDotsContainer.getChildAt(mLastPosition);
			preDot.setBackgroundResource(R.drawable.point_select);
			mLastPosition = position;
			
		}

		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {
		}

		@Override
		public void onPageScrollStateChanged(int state) {}
	};


	private void initData() {
    	mViewPager.setAdapter(mPagerAdapter);
		int initPosition = Integer.MAX_VALUE / 2;
		initPosition = initPosition - initPosition % mImages.length;
		mViewPager.setCurrentItem(initPosition);
    	for (int i = 0; i < mImages.length; i++) {
    		View dot = new View(getContext());
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mDotSize, mDotSize);
			if (i != mImages.length - 1) {
				layoutParams.rightMargin = mDotSize;
			}
			dot.setLayoutParams(layoutParams);
			autoSwitchPage();
			if (i == 0) {
				dot.setBackgroundResource(R.drawable.point_normal);
			} else {
				dot.setBackgroundResource(R.drawable.point_select);
			}

			mDotsContainer.addView(dot);
			
		}
	}

	private void autoSwitchPage() {
		if(mTask ==null){
			mTask = new AutoChangTask();
		}
		mTask.start();
	}

	private void initView() {
    	mViewPager = (ViewPager) findViewById(R.id.view_pager);
    	mDotsContainer = (LinearLayout) findViewById(R.id.dots_container);
	}

	private PagerAdapter mPagerAdapter = new PagerAdapter() {
			@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}
		
		@Override
		public int getCount() {
			return Integer.MAX_VALUE;
		}

		public Object instantiateItem(android.view.ViewGroup container, int position) {
			position = position % mImages.length;
			ImageView item = new ImageView(getContext());
		/*	item.setImageResource(mImages[position]);*/
			item.setBackgroundColor(mImages[position]);
			//item.setImageResource(mImages[position]);
			item.setScaleType(ScaleType.FIT_XY);
			container.addView(item);
			
			return item;
		};

		public void destroyItem(android.view.ViewGroup container, int position, Object object) {
			container.removeView((ImageView)object);
		};
	};

	class AutoChangTask extends Handler
			implements Runnable{
		@Override
		public void run() {
			int currentItme = mViewPager.getCurrentItem();
			if(currentItme == mViewPager.getAdapter().getCount()-1){
				mViewPager.setCurrentItem(0);
			}else{
				mViewPager.setCurrentItem(currentItme+1);
			}
			postDelayed(this , 3000);
		}

		public void start(){
			removeCallbacks(this);
			postDelayed(this , 3000);
		}

		public void stop() {
			removeCallbacks(this);
		}
	}

}
