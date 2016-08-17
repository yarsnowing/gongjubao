package com.yarsnowing.toolssss;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AutoStartReceiver extends BroadcastReceiver {
	public static String  EXTRA_DATE="alarms"; 
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Intent i = new Intent(context, AlarmService.class);  
      i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
       i.putExtra("autostart", true);
      context.startService(i); 
        
        
        /*Intent intent1 =new Intent("Alarm1");
		PendingIntent iPendingIntent =PendingIntent.getBroadcast(context, 0, intent1, 0);
        AlarmManager alarm=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarm.setRepeating(AlarmManager.RTC_WAKEUP,  
               AddAlarmFragment.calendar.getTimeInMillis(),60000*60*24,iPendingIntent);	*/
        //Toast.makeText(context, "Fun ÄÖÖÓ×ÔÆô³É¹¦", Toast.LENGTH_LONG).show();
              
	}

}
