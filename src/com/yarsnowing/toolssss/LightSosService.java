package com.yarsnowing.toolssss;

import android.app.Service;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.IBinder;
import android.util.Log;

public class LightSosService extends Service {
	 private Camera camera;  
	    private Parameters parameters;  
	    private  LightSosService instance;
	    private boolean statused=true;
	   // @SuppressWarnings("unused")
		public  boolean  status=false;
		 private Thread thread;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	//public class AlarmService extends Service {
		//public static Calendar calendar =Calendar.getInstance();
		// public static Intent intent1 ;
		//intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		//public static PendingIntent iPendingIntent;
		// public static AlarmManager alarm;
		//protected static PendingIntent iPendingIntent;
		//protected static Object alarm;
		//@Override
		//public IBinder onBind(Intent intent) {
			// TODO Auto-generated method stub
			//return null;
		//}
		@Override
		public void onCreate(){
			super.onCreate();
			 Log.d("TAG2","test service");
			 //instance = this;  
		       // camera = Camera.open();
			 
			   
		}
	@Override
	public int onStartCommand (Intent intent,int flags,int startId){
		Log.d("TAG3","test service");
		instance = this;  
       // camera = Camera.open();
		//instance = this;  
       
		status=intent.getBooleanExtra("status", false);
		//new Thread(new Runnable() {
			
			//@Override
			//public void run() {
				// TODO Auto-generated method stub
				//SharedPreferences sharedPreferences2 =getSharedPreferences("date", Context.MODE_PRIVATE);
				/*int year=sharedPreferences2.getInt("year", 0);
				int month=sharedPreferences2.getInt("month", 0);
				int day=sharedPreferences2.getInt("day", 0);
				int hour=sharedPreferences2.getInt("hour", 0);
				int minute=sharedPreferences2.getInt("minute", 0);*/
				//AlarmService.calendar.set(sharedPreferences2.getInt("year", 0), sharedPreferences2.getInt("month", 0), sharedPreferences2.getInt("day", 0), sharedPreferences2.getInt("hour", 0), sharedPreferences2.getInt("minute", 0));
				//long log =(AddAlarmFragment.calendar.getTimeInMillis()-System.currentTimeMillis());
			   // Log.i("time", "设定de时间"+log);
			//}
		//}).start();
		
		if(status=true){
			thread =new Thread(new TurnOnLight());
			thread.start();
			
		}else {
			//Log.i("thread", "stop");
			//thread.interrupt();
			//camera.setPreviewCallback(null);
			//camera.release();
			
			
			//stopSelf();
			
		}
		//SharedPreferences sharedPreferences2 =this.getSharedPreferences("date", Context.MODE_PRIVATE);
		/*int year=sharedPreferences2.getInt("year", 0);
		int month=sharedPreferences2.getInt("month", 0);
		int day=sharedPreferences2.getInt("day", 0);
		int hour=sharedPreferences2.getInt("hour", 0);
		int minute=sharedPreferences2.getInt("minute", 0);*/
		//AddAlarmFragment.calendar.set(sharedPreferences2.getInt("year", 2015), sharedPreferences2.getInt("month", 1), sharedPreferences2.getInt("day", 15), sharedPreferences2.getInt("hour", 12), sharedPreferences2.getInt("minute", 12));
		//startForeground(0, null);
		//Log.i("start foreground", "sucess");
		//intent1 =new Intent("Alarm1");
		//intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		// iPendingIntent =PendingIntent.getBroadcast(this, 0, intent1, 0);
		//SharedPreferences sharedPreferences2 =getSharedPreferences("date", Context.MODE_PRIVATE);
		/*int year=sharedPreferences2.getInt("year", 0);
		int month=sharedPreferences2.getInt("month", 0);
		int day=sharedPreferences2.getInt("day", 0);
		int hour=sharedPreferences2.getInt("hour", 0);
		int minute=sharedPreferences2.getInt("minute", 0);*/
		//AlarmService.calendar.set(sharedPreferences2.getInt("year", 0), sharedPreferences2.getInt("month", 0), sharedPreferences2.getInt("day", 0), sharedPreferences2.getInt("hour", 0), sharedPreferences2.getInt("minute", 0));
	//Toast.makeText(getApplicationContext(), "设定的时间是", Toast.LENGTH_LONG).show();
		 // alarm=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
		// long log =(AddAlarmFragment.calendar.getTimeInMillis()-System.currentTimeMillis());
		// Log.i("time", "设定de时间"+log);
		// if(log<=0){
			//((AlarmManager) alarm).cancel(iPendingIntent);
		//	iPendingIntent.cancel();
		//}
	   // ((AlarmManager) alarm).setRepeating(AlarmManager.RTC_WAKEUP,  
	    //      AddAlarmFragment.calendar.getTimeInMillis(),60000*60*24,iPendingIntent
	   //       ); 
	   // long log1 =(AddAlarmFragment.calendar.getTimeInMillis()-System.currentTimeMillis());
	   // Log.i("time", "chong设定de时间"+log1);
		//startForeground(0, null);
		Log.i("start foreground", "sucess");

		 //return START_STICKY_COMPATIBILITY;
	    //return super.onStartCommand(intent1, flags, startId);
		 //flags = START_STICKY;
		 return super.onStartCommand(intent, flags, startId);
		 // return START_REDELIVER_INTENT;
	}
		/*@SuppressWarnings("deprecation")
		@Override
		public void onStart(Intent intent, int startId)
		{
		// 再次动态注册广播
		IntentFilter localIntentFilter = new IntentFilter("android.intent.action.USER_PRESENT");
		localIntentFilter.setPriority(Integer.MAX_VALUE);// 整形最大值
		MyReceiver searchReceiver = new MyReceiver();
		registerReceiver(searchReceiver, localIntentFilter);
		super.onStart(intent, startId);
		}*/
	  private class TurnOnLight implements Runnable{  
		 
		  @Override  
	        public void run() {  
	           // instance.parameters = instance.camera.getParameters();  
	          //instance.parameters.setFlashMode("torch");  
	            //instance.camera.setParameters(instance.parameters);  
			  camera = Camera.open();
	        	// camera = Camera.open();
	            while(true){
	            	if(statused){
	            		//camera=Camera.open();
	            		instance.parameters = instance.camera.getParameters(); 
	            		instance.parameters.setFlashMode("off");  
	                    instance.camera.setParameters(instance.parameters);  
	                    statused=false;
	                  // instance.camera.stopPreview();
	                   //instance.camera.release();
	                   // instance.camera = null;
	            	}else {
	            		//camera=Camera.open();
	            		 instance.parameters = instance.camera.getParameters();  
	     	            instance.parameters.setFlashMode("torch");  
	     	            instance.camera.setParameters(instance.parameters); 
	     	            statused=true;
	     	          // instance.camera.release();
					}
	            	try {
		            	
		                  Thread.sleep(500);//线程休眠4秒钟    

		              } catch (InterruptedException e) {

		                  e.printStackTrace();
		                  break;
		              }
	            }
	            
	        }  
	    }  
	@Override

	public void onDestroy()
	{
		
		thread.interrupt();
		Log.i("thread", "stop");
		camera.setPreviewCallback(null);
		
		//camera.release();
		camera.release();
	//Intent localIntent = new Intent(this, AlarmService.class);
	//localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	//localIntent.setClass(this, AlarmService.class); // 销毁时重新启动Service
	//getApplicationContext().startService(localIntent);
	Log.i("camera", "releaseing");
	}
	}



