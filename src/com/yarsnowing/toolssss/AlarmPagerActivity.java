package com.yarsnowing.toolssss;

import java.util.ArrayList;
import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class AlarmPagerActivity extends FragmentActivity {
private ViewPager mViewPager;
private ArrayList<Alarm> mAlarms;
@Override
public void onCreate(Bundle savedInstaceState){
	super.onCreate(savedInstaceState);
	mViewPager=new ViewPager(this);
	mViewPager.setId(R.id.viewPager);
	setContentView(mViewPager);
	mAlarms=AlarmLab.get(this).getAlarms();
	FragmentManager fm =getSupportFragmentManager();
	mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mAlarms.size();
		}
		
		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			Alarm alarm =mAlarms.get(arg0);
			//setTitle("ƒ÷÷”"+"  "+(arg0+1));
			return AddAlarmFragmentt.newInstance(alarm.getId());
		}
	});
	mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			Alarm alarm=mAlarms.get(arg0);
			
			if(alarm.getDate()!=null){
				setTitle("ƒ÷÷”"+"  "+(arg0+1));
			}
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	int alarmId =(int)getIntent().getIntExtra(AddAlarmFragmentt.EXTAR_DATE, 0);
	for (int i = 0; i < mAlarms.size(); i++) {
		if(mAlarms.get(i).getId()==alarmId){
			mViewPager.setCurrentItem(i);
			if (i==0) {
				setTitle("ƒ÷÷”"+"  "+1);
			}
			//mViewPager.setC
			break;
		}
		
	}
}
}
