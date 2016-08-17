package com.yarsnowing.toolssss;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.UUID;

import android.R.integer;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class AddAlarmFragmentt extends Fragment {
	private Alarm mAlarm;
	private CheckBox isAlarmChoosed;
	
	
	public  Calendar calendar =Calendar.getInstance();
	public  PendingIntent iPendingIntent;
	private Button addTimeButton,addedTimeButton;
	private Button addRepeatButton,addedRepeatButton;
	private Button addContact1,addedContact1;
	private static final int REQUEST_DATE=0;
	private static final int REQUEST_CHOOSED=2;
	public static String  EXTRA_DATEDEALAYDES="daydelay"; 
	private static final String DIALOG_DATE="date";
	private static final String TAG = "AppX_BannerAd";
	public static String EXTAR_DATE="date";
	private ArrayList<PendingIntent> ipendintents;
	private ArrayList<PendingIntent> intents;
	private ArrayList<PendingIntent> savedpendIntents;
	private Intent intent111;
	int alarmId;
	
	 String[] strings={"星期一 ","星期二 ","星期三  ","星期四 ","星期五 ","星期六 ","星期日 "};
	ArrayList<Integer> integers=new ArrayList<Integer>();
	public static AddAlarmFragmentt newInstance(int i){
		Bundle args=new Bundle();
		args.putSerializable(EXTAR_DATE, i);
		AddAlarmFragmentt fragment =new AddAlarmFragmentt();
		fragment.setArguments(args);
		return fragment;
	}
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		
		
		
		
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
		
		
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
		alarmId=(int)getArguments().getInt(EXTAR_DATE);
		mAlarm=AlarmLab.get(getActivity()).getAlarm(alarmId);
		integers.clear();
		integers.add(alarmId+1);
		integers.add(alarmId+2);
		integers.add(alarmId+3);
		integers.add(alarmId+4);
		integers.add(alarmId+5);
		integers.add(alarmId+6);
		integers.add(alarmId+7);
		integers.add(alarmId+8);
		Log.i("alarmId=", ""+alarmId);
		if (NavUtils.getParentActivityName(getActivity())!=null) {
			getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	
		
		
		

		Log.i("AddAlarmFragmentt", "oncreateView suceess");
		savedpendIntents=new ArrayList<PendingIntent>();
	intent111=new Intent("Alarm1");
		intent111.putExtra("contactsid", alarmId);
		savedpendIntents.clear();
		for (int i = 0; i < 8; i++) {
			iPendingIntent=PendingIntent.getBroadcast(getActivity(),integers.get(i), intent111,PendingIntent.FLAG_UPDATE_CURRENT);
			savedpendIntents.add(iPendingIntent);
		}
		ipendintents =new ArrayList<PendingIntent>();
		intents =new ArrayList<PendingIntent>();
		if (mAlarm.getIpPendingIntents()==null) {
			mAlarm.setIpPendingIntents(ipendintents);
			Log.i("setAlarm IpengdingArray", "set suceess");
		}
		if (mAlarm.getiPendingIntent()==null) {
			mAlarm.setiPendingIntent(intents);
			//intents=mAlarm.getiPendingIntent();
		}
		//ipendintents=new ArrayList<PendingIntent>();
		View view= inflater.inflate(R.layout.add_alarmfragmentt, parent,false);
		 isAlarmChoosed=(CheckBox)view.findViewById(R.id.isAlarmChoosed);
		 isAlarmChoosed.setChecked(mAlarm.isMisChoosed());
		 isAlarmChoosed.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
			mAlarm.setMisChoosed(isChecked);
			Intent intent =new Intent(getActivity(),AlarmService.class);
			
			if(isChecked){
				intent.putExtra("autostart", true);
				getActivity().startService(intent);
				Log.i("isAlarmChoosed", ""+isChecked);
			}else {
				Log.i("isAlarmChoosed", ""+isChecked);
				//getActivity().stopService(intent);
				AlarmManager am = (AlarmManager) getActivity().getSystemService(Activity.ALARM_SERVICE);
				
				if (ipendintents==null) {
					ipendintents =new ArrayList<PendingIntent>();
					mAlarm.setIpPendingIntents(ipendintents);
				}else {
					ipendintents =mAlarm.getIpPendingIntents();
					intents=mAlarm.getiPendingIntent();
					for (int i = 0; i < integers.size(); i++) {
						am.cancel(savedpendIntents.get(i));
					}
					Toast.makeText(getActivity(), "闹钟已删除", Toast.LENGTH_SHORT).show();
					//Log.i("ipengsize", ""+ipendintents.size());
					//for(int i=0;i<ipendintents.size();i++){
					//	am.cancel(ipendintents.get(i));
					//	Log.i("cancel", ""+i);
				//}
				
				}
			}
			}
		});
		
		
		
		
		//addTimeButton=(Button)view.findViewById(R.id.addTime);
		//addRepeatButton=(Button)view.findViewById(R.id.addRepeat);
		addedTimeButton=(Button)view.findViewById(R.id.addedTime);
		
			addedTimeButton.setText(formatDate(mAlarm.getDate()));
		
			
		
		addedTimeButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
FragmentManager fm =getActivity().getSupportFragmentManager();
				
				//AddAlarmFragment dialog =new AddAlarmFragment();
				//================================
				AddAlarmFragment dialog =AddAlarmFragment.newInstance(mAlarm.getDate());
				dialog.setTargetFragment(AddAlarmFragmentt.this, REQUEST_DATE);
			dialog.show(fm, DIALOG_DATE);
			}
		});
		addedRepeatButton=(Button)view.findViewById(R.id.addedRepeat);
		StringBuilder stringBuilder =new StringBuilder();
		for(int i = 0;i<=6;i++){
			
			if(mAlarm.getDateArrayList().get(i)==true){
				
				stringBuilder.append(strings[i]);
				
				
			}
			
		}
	
			addedRepeatButton.setText(stringBuilder.toString());
		
		
		addedRepeatButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fm =getActivity().getSupportFragmentManager();
				AddRepeat dialog =AddRepeat.newInstance(mAlarm.getDateArrayList());
				dialog.setTargetFragment(AddAlarmFragmentt.this, REQUEST_CHOOSED);
			dialog.show(fm, "addrepeat");
			}
		});
		
		//addContact1=(Button)view.findViewById(R.id.addContact1);
		addedContact1=(Button)view.findViewById(R.id.addedContact1);
		if (mAlarm.getContactname()!=null) {
			addedContact1.setText(mAlarm.getContactname());
		}
		addedContact1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_PICK,android.provider.ContactsContract.Contacts.CONTENT_URI);
				startActivityForResult(intent, 1);
			}
		});
		
		
		
		return view;
}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode,Intent date){
		if (resultCode!=Activity.RESULT_OK) return;
		if(requestCode==REQUEST_DATE){
			
			Date date2=(Date)date.getSerializableExtra(AddAlarmFragment.EXTAR_DATE);
			mAlarm.setDate(date2);
			
			
			addedTimeButton.setText(formatDate(mAlarm.getDate()));
			//addedTimeButton.setTextColor(android.graphics.Color.YELLOW);
			//Intent intent1=new Intent("Alarm1");
			//Random rand = new Random();
			intents=new ArrayList<PendingIntent>();
			intents=mAlarm.getiPendingIntent();
			AlarmManager am = (AlarmManager) getActivity().getSystemService(Activity.ALARM_SERVICE);
			for(int i=0;i<intents.size();i++){
				am.cancel(intents.get(i));
				Log.i("cancel", ""+i);
			}
			Log.i("intents", ""+intents.size());
			intents.clear();
			iPendingIntent=PendingIntent.getBroadcast(getActivity(),integers.get(7), intent111, 0);
			intents.add(iPendingIntent);
			mAlarm.setiPendingIntent(intents);
			isAlarmChoosed.setChecked(true);
			Intent intent =new Intent(getActivity(),AlarmService.class);
			intent.putExtra(EXTRA_DATEDEALAYDES, alarmId);
			getActivity().startService(intent);
			isAlarmChoosed.setChecked(true);
			String string=formatDate(mAlarm.getDate());
			long a=(mAlarm.getDate().getTime()-Calendar.getInstance().getTimeInMillis())/1000;
			long hour=Math.abs(a/3600);
			long minutes=Math.abs(a-hour*3600)/60;
			Toast.makeText(getActivity(), "闹钟添加成功,时间: "+string, Toast.LENGTH_SHORT).show();
			if(a<0){
				//Toast.makeText(getActivity(), "闹钟将于"+(hour+24)+"小时"+minutes+"分钟后启动", Toast.LENGTH_SHORT).show();
				
			}else {
				//Toast.makeText(getActivity(), "闹钟将于"+hour+"小时"+(minutes+1)+"分钟后启动", Toast.LENGTH_SHORT).show();
			}
			
			
		}
		if(requestCode==1){
			Uri contactDate=date.getData();
			Cursor cursor = this.getActivity().getContentResolver().query(contactDate, 
	                null, null, null, null);
	       int contactIdIndex = 0;
	       int nameIndex = 0;
	       
	       if(cursor.getCount() > 0) {
	           contactIdIndex = cursor.getColumnIndex(ContactsContract.Contacts._ID);
	           nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
	       }
	       while(cursor.moveToNext()) {
	           String contactId = cursor.getString(contactIdIndex);
	           String name = cursor.getString(nameIndex);
	           //SharedPreferences sharedPreferences=getActivity().getSharedPreferences("saveContact", Context.MODE_PRIVATE);
				//SharedPreferences.Editor editor1=sharedPreferences.edit();
				//editor.putString("savedRecoredString", null);
				//editor1.putString("contact", name);
				
				//editor1.commit();
				
				mAlarm.setContactname(name);
				
				addedContact1.setText(mAlarm.getContactname());
	           Log.i(TAG, contactId);
	           Log.i(TAG, name);
	           
	           /*
	            * 查找该联系人的phone信息
	            */
	           Cursor phones = this.getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, 
	                   null, 
	                   ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactId, 
	                   null, null);
	           int phoneIndex = 0;
	           if(phones.getCount() > 0) {
	               phoneIndex = phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
	           }
	           while(phones.moveToNext()) {
	               String phoneNumber = phones.getString(phoneIndex);
	              //SharedPreferences sharedPreferences1=getActivity().getSharedPreferences("saveContact", Context.MODE_PRIVATE);
	   			//SharedPreferences.Editor editor2=sharedPreferences1.edit();
	             //  editor2.putString("phoneNum", phoneNumber);
	             //  editor2.commit();
	               
	               
	               mAlarm.setContactphone(phoneNumber);
	               
	               
	               //contactSeted.setText(sharedPreferences.getString("phoneNum", null));
	              // Log.i(TAG, sharedPreferences.getString("phoneNum", null));
	           }
	           
	       }}
		if(requestCode==2){
			
			
			ArrayList<Boolean> aBooleans =(ArrayList<Boolean>)date.getSerializableExtra(AddRepeat.EXTAR);
			mAlarm.setDateArrayList(aBooleans);
			
			StringBuilder stringBuilder =new StringBuilder();
			for(int i = 0;i<=6;i++){
				
				if(aBooleans.get(i)==true){
					
					stringBuilder.append(strings[i]);
					
					
				}
				
			}
			addedRepeatButton.setText(stringBuilder.toString());
			//ArrayList<Boolean> aBooleansd= mAlarm.getDateArrayList();
			//aBooleansd=(ArrayList<Boolean>) aBooleans.clone();
		
			AlarmManager am = (AlarmManager) getActivity().getSystemService(Activity.ALARM_SERVICE);
			Log.i("requestcode=2", ""+aBooleans.get(1)+aBooleans.get(2)+aBooleans.get(6));
			Log.i("requstcode=2", "ok");
			intents=mAlarm.getiPendingIntent();
			//for (int i = 0; i < integers.size(); i++) {
			//	am.cancel(savedpendIntents.get(i));
			//}
			
	
			for (int i = 0; i < integers.size(); i++) {
				am.cancel(savedpendIntents.get(i));
			}
			
			
			//ipendintents =new ArrayList<PendingIntent>();
			//mAlarm.setIpPendingIntents(ipendintents);
			ArrayList<PendingIntent> ipendintents=mAlarm.getIpPendingIntents();
			
			//for(int i=0;i<ipendintents.size();i++){
				//am.cancel(ipendintents.get(i));
				//Log.i("cancel", ""+i);
			//}
			Log.i("ipendingintents", ""+ipendintents.size());
			ipendintents.clear();
		
			//Random rand = new Random();
			//Intent intent1=new Intent("Alarm1");
			//AlarmManager am = (AlarmManager) getActivity().getSystemService(Activity.ALARM_SERVICE);
			ArrayList<Integer> daydelaysaved=mAlarm.getDaydelaysaved();
			
			Log.i("daydelaysaved", ""+daydelaysaved.size());
			daydelaysaved.clear();
			int dayofweek=calendar.get(Calendar.DAY_OF_WEEK);
			Log.i("dayofweek", ""+dayofweek);
			
			
			for(int i=0;i<=6;i++){
				
				if (aBooleans.get(i)) {
					int daydelay;
					if(dayofweek>i+1){
					daydelay=9-dayofweek+i;
					Log.i("daydelay", ""+daydelay);
				}else {
					daydelay=i+2-dayofweek;
					Log.i("daydelayrr", ""+daydelay);
				}
				
				daydelaysaved.add(daydelay);
				//int as=daydelaysaved.get(1);
				
				}
			}
			if(daydelaysaved.size()>0){
				Log.i("daydelaysaved", daydelaysaved.size()+"");
				//Log.i("get", daydelaysaved.get(1)+"");
			}
				if (daydelaysaved.size()>0) {
					for(int i1=0;i1<daydelaysaved.size();i1++){
						
						iPendingIntent=PendingIntent.getBroadcast(getActivity(),integers.get(i1), intent111, 0);
						ipendintents.add(iPendingIntent);
						//alarm.setRepeating(AlarmManager.RTC_WAKEUP, alarm2.getDate().getTime()+100000, daydelaysaved.get(i1),iPendingIntents.get(i1));
						Log.i("ipengdingintent", ""+(i1+1));
						
						
						}
					
				}
				if(daydelaysaved.size()==ipendintents.size()){
					
					mAlarm.setIpPendingIntents(ipendintents);
					mAlarm.setDaydelaysaved(daydelaysaved);
					Log.i("ipendingintents", ""+ipendintents.size());
					
						Intent intent =new Intent(getActivity(),AlarmService.class);
					intent.putExtra(EXTRA_DATEDEALAYDES, alarmId);
					getActivity().startService(intent);
					//setAlarm(iPendingIntents);
					//for(int i=0;i<ipendintents.size();i++){
						//Log.i("getiPendingIntents", ""+ipendintents.get(i));
						//am.set(AlarmManager.RTC_WAKEUP, mAlarm.getDate().getTime()+daydelaysaved.get(i)*100000, ipendintents.get(i));
						
					}
				
					
				}
			
			
			
		
		
	}
	private String formatDate(Date date3){
		SimpleDateFormat sdf = new SimpleDateFormat("H:m");

		return sdf.format(date3).toString();
	}
	@Override
	public  boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case android.R.id.home:
			if (NavUtils.getParentActivityName(getActivity())!=null) {
				NavUtils.navigateUpFromSameTask(getActivity());
			}
			return true;
			
			

		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
