package com.yarsnowing.toolssss;

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
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

public class AlarmService extends Service {
	public static Calendar calendar;
	 public static Intent intent1 ;
	//intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	public static PendingIntent iPendingIntent;
	 public static AlarmManager alarm;
	 public  ArrayList<PendingIntent> iPendingIntents;
	 public ArrayList<PendingIntent> intents;
	 public  ArrayList<Boolean> aBooleans;
	  public ArrayList<Integer> daydelaysaved;
	 public  ArrayList<PendingIntent> ipendintents;
	 public Alarm alarm2;
	 public Date mDate;
	 public Date dates;
	 public ArrayList<Alarm> mAlarmss;
	 public boolean mBoolean;
	 public boolean mB;
	public ArrayList<Integer> integers;
	public static int i,i1;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onCreate(){
		super.onCreate();
		 Log.i("oncreate","succees");
		 
		
		 
		
		   
	}
@SuppressWarnings("deprecation")
@Override
public int onStartCommand (Intent intent,int flags,int startId){
	Log.i("onstartCommand","succeess");
	calendar =Calendar.getInstance();
	
	integers=new ArrayList<Integer>();
	
	iPendingIntents=new ArrayList<PendingIntent>();
	ipendintents =new ArrayList<PendingIntent>();
	intents =new ArrayList<PendingIntent>();
	daydelaysaved=new ArrayList<Integer>();
	aBooleans=new ArrayList<Boolean>();
	 alarm=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
	// calendar=Calendar.getInstance();
	 Intent intent1=new Intent("Alarm1");
	 
	mBoolean=true;
	
	//mB=intent.getBooleanExtra("autostart", false);
	try {
		if (intent.getBooleanExtra("autostart", false)) {
			
			mAlarmss=AlarmLab.get(getApplicationContext()).getAlarms();
			for (int i = 0; i <mAlarmss.size(); i++) {
				calendar =Calendar.getInstance();
				alarm2=mAlarmss.get(i);
				if (alarm2.isMisChoosed()) {
					int alarmid=alarm2.getId();
					intent1.putExtra("contactsid", alarmid);
					integers.clear();
					integers.add(alarmid+1);
					integers.add(alarmid+2);
					integers.add(alarmid+3);
					integers.add(alarmid+4);
					integers.add(alarmid+5);
					integers.add(alarmid+6);
					integers.add(alarmid+7);
					integers.add(alarmid+8);
					Log.i("integer size", ""+integers.size());
					Log.i("alarmid=", ""+alarmid);
					if (alarm2.getIpPendingIntents()==null) {
						alarm2.setIpPendingIntents(iPendingIntents);
						
					}
					
					if (alarm2.getiPendingIntent()==null) {
						alarm2.setiPendingIntent(intents);
					}
					
					//AlarmManager am = (AlarmManager)getApplicationContext() .getSystemService(Activity.ALARM_SERVICE);
					
					intents=alarm2.getiPendingIntent();
					
					
			
					
					//mAlarm.setIpPendingIntents(ipendintents);
					ipendintents=alarm2.getIpPendingIntents();
					aBooleans=alarm2.getDateArrayList();
					//for(int i1=0;i1<ipendintents.size();i1++){
					//	am.cancel(ipendintents.get(i1));
					//	Log.i("cancel", ""+i1);
					//}
					Log.i("ipendingintents", ""+ipendintents.size());
					ipendintents.clear();
				
					//Random rand = new Random();
					
					//AlarmManager am = (AlarmManager) getActivity().getSystemService(Activity.ALARM_SERVICE);
					daydelaysaved=alarm2.getDaydelaysaved();
					
					Log.i("daydelaysaved", ""+daydelaysaved.size());
					daydelaysaved.clear();
					int dayofweek=calendar.get(Calendar.DAY_OF_WEEK);
					Log.i("dayofweek", ""+dayofweek);
					
					
					for(int i1=0;i1<=6;i1++){
						
						if (aBooleans.get(i1)) {
							int daydelay;
							if(dayofweek>i1+1){
							daydelay=9-dayofweek+i1;
							Log.i("daydelay", ""+daydelay);
						}else {
							daydelay=i1+2-dayofweek;
							Log.i("daydelayrr", ""+daydelay);
						}
						
						daydelaysaved.add(daydelay);
						//int as=daydelaysaved.get(1);
						
						}
					}
					//if(daydelaysaved.size()>0){
					//	Log.i("daydelaysaved", daydelaysaved.size()+"");
						//Log.i("get", daydelaysaved.get(1)+"");
					//}
						if (daydelaysaved.size()>0) {
							for(int i1=0;i1<daydelaysaved.size();i1++){
								
								iPendingIntent=PendingIntent.getBroadcast(getApplicationContext(), integers.get(i1), intent1, PendingIntent.FLAG_UPDATE_CURRENT);
								ipendintents.add(iPendingIntent);
								//alarm.setRepeating(AlarmManager.RTC_WAKEUP, alarm2.getDate().getTime()+100000, daydelaysaved.get(i1),iPendingIntents.get(i1));
								Log.i("ipengdingintent", ""+(i1+1));
								
								
								}
							
						}
						if(daydelaysaved.size()==ipendintents.size()){
							
							alarm2.setIpPendingIntents(ipendintents);
							alarm2.setDaydelaysaved(daydelaysaved);
							Log.i("ipendingintents", ""+ipendintents.size());
							
								//Intent intent =new Intent(getActivity(),AlarmService.class);
							//intent.putExtra(EXTRA_DATEDEALAYDES, alarmId);
						//	getActivity().startService(intent);
							//setAlarm(iPendingIntents);
							//for(int i=0;i<ipendintents.size();i++){
								//Log.i("getiPendingIntents", ""+ipendintents.get(i));
								//am.set(AlarmManager.RTC_WAKEUP, mAlarm.getDate().getTime()+daydelaysaved.get(i)*100000, ipendintents.get(i));
								
							}
					
						//Intent intent11=new Intent("Alarm1");
						//Random rand1 = new Random();
						//intents=new ArrayList<PendingIntent>();
						intents=alarm2.getiPendingIntent();
						//AlarmManager am1 = (AlarmManager) getApplicationContext().getSystemService(Activity.ALARM_SERVICE);
						//for(int i1=0;i1<intents.size();i1++){
							//am1.cancel(intents.get(i1));
							//Log.i("cancel", ""+i1);
						//}
						Log.i("intents", ""+intents.size());
						intents.clear();
						iPendingIntent=PendingIntent.getBroadcast(getApplicationContext(), integers.get(7), intent1, PendingIntent.FLAG_UPDATE_CURRENT);
						//Log.i("rand1.nextInt=", ""+rand1.nextInt(1000));
						intents.add(iPendingIntent);
						alarm2.setiPendingIntent(intents);
					
					
					
					
					
					
					
					dates=alarm2.getDate();
					Log.i("dates time", ""+dates.getTime());
					
					 mDate =new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), dates.getHours(), dates.getMinutes()).getTime();
					Log.i("mdate time", ""+mDate.getTime());
				
					 iPendingIntents=alarm2.getIpPendingIntents();
						
					 
					 daydelaysaved=alarm2.getDaydelaysaved();
						Log.i("AlarmService ipending size", ""+iPendingIntents.size());
						for(int i1=0;i1<daydelaysaved.size();i1++){
							if (mDate.getTime()>calendar.getTimeInMillis()) {
								int i11=calendar.get(Calendar.DAY_OF_WEEK);
								calendar.setTime(mDate);
								int b=calendar.get(Calendar.DAY_OF_WEEK);
								if (i11==b) {
									if (daydelaysaved.contains(7)) {
										alarm.set(AlarmManager.RTC_WAKEUP, mDate.getTime(), intents.get(0));
										Log.i("setalarm", mDate.getTime()+"");
									}
									//alarm.set(AlarmManager.RTC_WAKEUP, mDate.getTime(), intents.get(0));
								}
								
							}
						Log.i("getiPendingIntents", ""+iPendingIntents.get(i1));
							alarm.setRepeating(AlarmManager.RTC_WAKEUP, mDate.getTime()+daydelaysaved.get(i1)*60000*24*60,24*60000*60*7, iPendingIntents.get(i1));
							
						}
						
						
						intents =alarm2.getiPendingIntent();
						if(daydelaysaved.size()==0&&intents.size()>0){
							Log.i("nowtime", calendar.getTimeInMillis()+"");
							if (mDate.getTime()>calendar.getTimeInMillis()) {
								alarm.set(AlarmManager.RTC_WAKEUP, mDate.getTime(), intents.get(0));
								
								Log.i("setalarm", ""+(mDate.getTime()-calendar.getTimeInMillis()));
							}else {
								alarm.set(AlarmManager.RTC_WAKEUP,mDate.getTime()+24*60000*60, intents.get(0));
								Log.i("setalarm", ""+(mDate.getTime()-calendar.getTimeInMillis()+4*60000));
							}
							/* new Thread(new Runnable() {  
						            public void run() {  
						               // Log.d("mark", "Service in Thread: " + "\n" + "当前线程名称："  
						                     //   + Thread.currentThread().getName() + "," + "当前线程名称："  
						                     //   + Thread.currentThread().getId());  
						                Looper.prepare();  
						                String string;
						                if (mDate.getTime()>calendar.getTimeInMillis()) {
						                	  string=(mDate.getTime()-calendar.getTimeInMillis())+"";
										}else {
											  string=((mDate.getTime()-calendar.getTimeInMillis())+24*60000*60)+"";
										}
						               // String string=(mDate.getTime()-calendar.getTimeInMillis())+"";
						                Toast.makeText(getApplicationContext(), string, Toast.LENGTH_LONG).show();  
						                Looper.loop();  
						            }  
						        }).start();  */
						}	
				}
				
			}
		
		
		
		
	}else {
		
			int alarmId=(int)intent.getIntExtra(AddAlarmFragmentt.EXTRA_DATEDEALAYDES, 0);
			
			alarm2=AlarmLab.get(getApplicationContext()).getAlarm(alarmId);
			
			if (alarm2.isMisChoosed()) {
				Log.i("alarmid=", ""+alarmId);
				if(alarm2!=null){
					Log.i("alarm", ""+alarm2.getId());
				}
				ArrayList<PendingIntent> intents =alarm2.getiPendingIntent();
				ArrayList<Integer> daydelaysaved=new ArrayList<Integer>();
				 dates=alarm2.getDate();
				mDate =new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), dates.getHours(), dates.getMinutes()).getTime();
				
					iPendingIntents=alarm2.getIpPendingIntents();
					daydelaysaved=alarm2.getDaydelaysaved();
					Log.i("AlarmService ipending size", ""+iPendingIntents.size());
				
					if (iPendingIntents.size()==daydelaysaved.size()) {
						
					for(int i=0;i<iPendingIntents.size();i++){
				Log.i("getiPendingIntents", ""+iPendingIntents.get(i));
				if (mDate.getTime()>calendar.getTimeInMillis()) {
					int i1=calendar.get(Calendar.DAY_OF_WEEK);
					calendar.setTime(mDate);
					int b=calendar.get(Calendar.DAY_OF_WEEK);
					if (i1==b) {
						if (daydelaysaved.contains(7)) {
							alarm.set(AlarmManager.RTC_WAKEUP, mDate.getTime(), intents.get(0));
						}
					}
					
				}
				alarm.setRepeating(AlarmManager.RTC_WAKEUP, mDate.getTime()+daydelaysaved.get(i)*60000*24*60,24*60000*60*7, iPendingIntents.get(i));
					
					
				}
					}
			
				if(daydelaysaved.size()==0&&intents.size()>0){
					if (alarm2.getDate().getTime()>calendar.getTimeInMillis()) {
						alarm.set(AlarmManager.RTC_WAKEUP, mDate.getTime(), intents.get(0));
						Log.i("setalarm", ""+(mDate.getTime()-calendar.getTimeInMillis()));
					}else {
						alarm.set(AlarmManager.RTC_WAKEUP, mDate.getTime()+24*60000*60, intents.get(0));
						Log.i("setalarm", ""+(mDate.getTime()-calendar.getTimeInMillis()+24*60000*60));
					}
				}
			}
			
		
		
	}


 
 
	startForeground(0, null);

	
	


	


	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return START_STICKY_COMPATIBILITY;	
}  

	
public void onDestroy()
{
daydelaysaved.clear();
Log.i("AlarmService", "destoryed");
}
}
