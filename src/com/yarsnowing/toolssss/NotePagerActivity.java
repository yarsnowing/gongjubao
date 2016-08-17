package com.yarsnowing.toolssss;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class NotePagerActivity extends FragmentActivity {
private ViewPager mViewPager;
private ArrayList<Note> mNotes;
@Override
public void onCreate(Bundle savedInstaceState){
	super.onCreate(savedInstaceState);
	mViewPager=new ViewPager(this);
	mViewPager.setId(R.id.viewPager);
	setContentView(mViewPager);
	mNotes=NoteLab.get(this).getNotes();
	FragmentManager fm =getSupportFragmentManager();
	mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mNotes.size();
		}
		
		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			Note alarm =mNotes.get(arg0);
			//setTitle("ÄÖÖÓ"+"  "+(arg0+1));
			return AddNoteFragment.newInstance(alarm.getId());
		}
	});
	mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			Note alarm=mNotes.get(arg0);
			
			if(alarm.getDate()!=null){
				setTitle("±¸Íü"+"  "+(arg0+1));
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
	int noteId =(int)getIntent().getIntExtra(AddAlarmFragmentt.EXTAR_DATE, 0);
	for (int i = 0; i < mNotes.size(); i++) {
		if(mNotes.get(i).getId()==noteId){
			mViewPager.setCurrentItem(i);
			if (i==0) {
				setTitle("±¸Íü"+"  "+1);
			}
			//mViewPager.setC
			break;
		}
		
	}
}
}
