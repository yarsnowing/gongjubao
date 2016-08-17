package com.yarsnowing.toolssss;

import android.R.integer;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

public class AlarmToastFragment extends Fragment {
	int count=1;
	private int contactsssid;
	public static Intent intents ;
	 public static PendingIntent iPendingIntents;
	  public static AlarmManager alarms;
	public static final String EXTRA_COUNT="extra_date";
	 public WakeLock mWakelock;
	private Alarm mAlarm;
	public KeyguardLock kl;

	 
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		SharedPreferences sharedPreferences=getActivity().getSharedPreferences("count", Activity.MODE_PRIVATE);
		count =sharedPreferences.getInt("counts",1);
		Log.i("counted", "="+count);
		getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); 
		
		PowerManager pm = (PowerManager)getActivity().getSystemService(Context.POWER_SERVICE);
		mWakelock = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP|PowerManager.SCREEN_BRIGHT_WAKE_LOCK,"SimpleTimer");
		KeyguardManager km= (KeyguardManager)getActivity(). getSystemService(Context.KEYGUARD_SERVICE);  
		 //这里参数”unLock”作为调试时LogCat中的Tag
	 kl = km.newKeyguardLock("unLock");   
		
	    
	}
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
		
		
		
		
		View view= inflater.inflate(R.layout.activity_fragment, parent,false);
				//view.getBackground().setAlpha(50);
		contactsssid=getActivity().getIntent().getIntExtra("contactssid", 0);
		mAlarm=AlarmLab.get(getActivity()).getAlarm(contactsssid);
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
		dialogBuilder.setTitle("闹钟");
		dialogBuilder.setMessage("设定的时间到了!!!");
		dialogBuilder.setCancelable(false);
		dialogBuilder.setPositiveButton("关闭", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//销毁所有的活动
				//ActivityController.finishAll();
				//Intent intent = new Intent(getActivity(),AlarmActivity.class);
				//在广播接收器里面启动活动，因此一定要给intent加入如下标识。
				//intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				//getActivity().startActivity(intent);
				//Toast.makeText(null, "闹钟已关闭", Toast.LENGTH_LONG).show();
				//AlarmToastFragment.this.getActivity().finish();
				SharedPreferences sharedPreferences1=getActivity().getSharedPreferences("count", Activity.MODE_PRIVATE);
			   	 
			   	SharedPreferences.Editor editor11=sharedPreferences1.edit();
			   	editor11.putInt("counts", 1);
			   	editor11.commit();
				Intent intent=new Intent("Alarm1");
				//PendingIntent intent3 =PendingIntent.getBroadcast(getActivity(), 0, intent, 0);
				//AlarmManager manager =(AlarmManager)getActivity().getSystemService(Context.ALARM_SERVICE);
				//manager.cancel(intent3);
				//intent3.cancel();
				 NotificationManager manger = (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
			        manger.cancel(1);
			        String content ="我起床了！！！，我是一只勤奋的猪,欧耶！！";//短信内容
			       SharedPreferences sharedPreferences=getActivity().getSharedPreferences("saveContact", Context.MODE_PRIVATE);
			        
		           //String phone =sharedPreferences.getString("phoneNum", "123");//电话号码
		           String phone=mAlarm.getContactphone();
		           if (phone!=null) {
		        	   SmsManager smsManager =SmsManager.getDefault();
		        	   smsManager.sendTextMessage(phone,null, content, null, null);
		        	  
		           }
		           AlarmToastFragment.this.getActivity().finish();
		            
			}

			//private Context getActivity() {
				// TODO Auto-generated method stub
				//return null;
			//}
		});
		dialogBuilder.setNegativeButton("暂停", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//Toast.makeText(null, "闹钟推迟10分钟", Toast.LENGTH_LONG).show();
				AlarmToastFragment.this.onDestroy();
				//Toast.makeText(null, "闹钟推迟10分钟", Toast.LENGTH_LONG).show();
				//Intent intent2 =new Intent(getActivity(),AlarmToastActivity.class);
				
		       
		       /* count=count++;
		        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("count", Context.MODE_PRIVATE);
		   	 
		   	SharedPreferences.Editor editor1=sharedPreferences.edit();
		   	editor1.putInt("counts", count);
		   	editor1.commit();
		   	int countss=0;
		        if((countss=sharedPreferences.getInt("counts", 0))>=4){
		        	Log.i("conut", "="+countss);
		        	String content ="我是懒猪! 按了"+countss+"次闹钟后才起床";//短信内容

		            String phone ="18502408512";//电话号码

		            SmsManager smsManager =SmsManager.getDefault();
		            smsManager.sendTextMessage(phone,null, content, null, null);
		        }*/
		        count=count+1;
		        
				SharedPreferences sharedPreferences=getActivity().getSharedPreferences("count", Activity.MODE_PRIVATE);
			   	 
			   	SharedPreferences.Editor editor1=sharedPreferences.edit();
			   	editor1.putInt("counts", count);
			   	editor1.commit();
			   //Toast.makeText(getActivity(), "数据成功写入SharedPreferences！", Toast.LENGTH_LONG).show();
			   	Log.i("count+1", "="+count);
			   	int countss=1;
			   	countss=sharedPreferences.getInt("counts", 1);
			   	Log.i("conutss", "="+countss);
			        if(countss>=5){
			        	Log.i("conut", "="+countss);
			        	countss=countss-1;
			        	String content ="我是懒猪! 按了"+countss+"次闹钟后才起床";//短信内容

			          // String phone ="18502408512";//电话号码
			        	String phone=mAlarm.getContactphone();
			        	if (phone!=null) {
			        		SmsManager smsManager =SmsManager.getDefault();
				            smsManager.sendTextMessage(phone,null, content, null, null);
						}
			            
			            
			        }
			        intents =new Intent("Alarm1");
			        intents.putExtra("contactsid", contactsssid);
					 iPendingIntents =PendingIntent.getBroadcast(getActivity(), 1, intents, PendingIntent.FLAG_UPDATE_CURRENT);
					
					 alarms=(AlarmManager)getActivity().getSystemService(Context.ALARM_SERVICE);
			        alarms.set(AlarmManager.RTC_WAKEUP,  
			               System.currentTimeMillis()+60000*5,  
			              iPendingIntents
			              ); 
			        NotificationManager manger = (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
			        manger.cancel(1);
		        AlarmToastFragment.this.getActivity().finish();
				//intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				//getActivity().startActivity(intent2);
			}
		});
		AlertDialog alertDialog = dialogBuilder.create();
		//需要设置AlertDialog的类型，保证在广播接收器中可以正常弹出
		alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		alertDialog.show();		
		return view;
}
	@SuppressWarnings("deprecation")
	@Override
	public void onResume() {
        super.onResume();
        kl.disableKeyguard();
        mWakelock.acquire();
     }
	
	
	
		
	

	@Override
	public void onDestroy(){
		super.onDestroy();
		mWakelock.release();
		kl.reenableKeyguard();
		AudioManager mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
		//int max = mAudioManager.getStreamMaxVolume( AudioManager.STREAM_RING );
		Log.i("AlarmToastFragment", "ondestroy");
		SharedPreferences sharedPreferences=getActivity().getSharedPreferences("ringmode", Context.MODE_PRIVATE);
		int i1=sharedPreferences.getInt("ringermode", 2);
		int i=sharedPreferences.getInt("streamvolume", 4);
		mAudioManager.setRingerMode(i1);
		mAudioManager.setStreamVolume(AudioManager.STREAM_RING, i, 0);
	}
}
