package com.yarsnowing.toolssss;

import java.lang.reflect.Field;
import java.lang.reflect.Method;



import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends FragmentActivity {  
	  //private ChatFragment chatFragment;
	private LightFragment lightFragment;

	/**
	 * ���ֽ����Fragment
	 */
	//private FoundFragment foundFragment;
	private NoteListFragment noteListFragment;
	/**
	 * ͨѶ¼�����Fragment
	 */
	//private ContactsFragment contactsFragment;
	//private AlarmFragment alarmFragment;
	private AlarmFragmentt alarmFragmentt;

	/**
	 * PagerSlidingTabStrip��ʵ��
	 */
	private PagerSlidingTabStrip tabs;

	/**
	 * ��ȡ��ǰ��Ļ���ܶ�
	 */
	private DisplayMetrics dm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setOverflowShowingAlways();
		dm = getResources().getDisplayMetrics();
		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
		tabs.setViewPager(pager);
		setTabsValue();
		
	}

	/**
	 * ��PagerSlidingTabStrip�ĸ������Խ��и�ֵ��
	 */
	private void setTabsValue() {
		// ����Tab���Զ��������Ļ��
		tabs.setShouldExpand(true);
		// ����Tab�ķָ�����͸����
		tabs.setDividerColor(Color.TRANSPARENT);
		// ����Tab�ײ��ߵĸ߶�
		tabs.setUnderlineHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 1, dm));
		// ����Tab Indicator�ĸ߶�
		tabs.setIndicatorHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, dm));
		// ����Tab�������ֵĴ�С
		tabs.setTextSize((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_SP, 16, dm));
		// ����Tab Indicator����ɫ
		tabs.setIndicatorColor(Color.parseColor("#0096ca"));
		// ����ѡ��Tab���ֵ���ɫ (�������Զ����һ������)
		tabs.setSelectedTextColor(Color.parseColor("#0096ca"));
		// ȡ�����Tabʱ�ı���ɫ
		tabs.setTabBackground(0);
	}

	public class MyPagerAdapter extends FragmentPagerAdapter {

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		private final String[] titles = { "�ֵ�Ͳ", "����¼", "����" };

		@Override
		public CharSequence getPageTitle(int position) {
			return titles[position];
		}

		@Override
		public int getCount() {
			return titles.length;
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				if (lightFragment == null) {
					lightFragment = new LightFragment();
				}
				return lightFragment;
			case 1:
				if (noteListFragment == null) {
					noteListFragment= new NoteListFragment();
				}
				return noteListFragment;
			case 2:
				if (alarmFragmentt == null) {
				alarmFragmentt = new AlarmFragmentt();
				}
				return alarmFragmentt;
			default:
				return null;
			}
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
			if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
				try {
					Method m = menu.getClass().getDeclaredMethod(
							"setOptionalIconsVisible", Boolean.TYPE);
					m.setAccessible(true);
					m.invoke(menu, true);
				} catch (Exception e) {
				}
			}
		}
		return super.onMenuOpened(featureId, menu);
	}

	private void setOverflowShowingAlways() {
		try {
			ViewConfiguration config = ViewConfiguration.get(this);
			Field menuKeyField = ViewConfiguration.class
					.getDeclaredField("sHasPermanentMenuKey");
			menuKeyField.setAccessible(true);
			menuKeyField.setBoolean(config, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override  
	public boolean onOptionsItemSelected(MenuItem item) {  
	    switch (item.getItemId()) {  
	   // case R.id.action_compose:  
	    //    Toast.makeText(this, "Compose", Toast.LENGTH_SHORT).show();  
	    //    return true;  
	    case R.id.more:  
	    	 Intent intent1=new Intent(this,AboutFragmentActivity.class);
		        startActivity(intent1);
	       // Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();  
	        return true;  
	    case R.id.action_settings:  
	        //Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show(); 
	        Intent intent=new Intent(this,MoreFragmentActivity.class);
	        startActivity(intent);
	        return true;  
	    default:  
	        return super.onOptionsItemSelected(item);  
	    }  
	}  

}