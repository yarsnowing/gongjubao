package com.yarsnowing.toolssss;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.net.Uri;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;


public class PushAlarm extends BroadcastReceiver {
 public static int i;
 public static int i1;
  
	@SuppressWarnings("deprecation")

@Override
public void onReceive(Context context, Intent intent){
	//Toast.makeText(context, "时间到了!", Toast.LENGTH_LONG).show();
	
	 AudioManager mAudioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
		SharedPreferences sharedPreferences=context.getSharedPreferences("ringmode", Context.MODE_PRIVATE);
		SharedPreferences.Editor sEditor=sharedPreferences.edit();
		i=mAudioManager.getStreamVolume(AudioManager.STREAM_RING);
		i1=mAudioManager.getRingerMode();
		sEditor.putInt("streamvolume", i);
		sEditor.putInt("ringermode", i1);
		sEditor.commit();
		
	
	
	int alarmidd=intent.getIntExtra("contactsid", 0);

	SharedPreferences sharedPreferencess=context.getSharedPreferences("choosed2", Context.MODE_PRIVATE);
	boolean booleans=sharedPreferencess.getBoolean("status", false);
	if (booleans) {
		
		int mode=mAudioManager.getRingerMode();
		Log.i("mode", ""+mode);
		
		
		mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		 mode=mAudioManager.getRingerMode();
		 Log.i("mode", ""+mode);
		int max = mAudioManager.getStreamMaxVolume( AudioManager.STREAM_RING );
		
		mAudioManager.setStreamVolume(AudioManager.STREAM_RING, max,0 );
	}
	
	
	NotificationManager manager =(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
	Notification notification =new Notification(R.drawable.appphoto,"Fun闹钟",System.currentTimeMillis());
	notification.setLatestEventInfo(context, "Fun闹钟", "设定的时间到了", null);
	notification.sound=Uri.parse("android.resource://" + context.getPackageName() + "/" +R.raw.music1);
	//notification.sound=uri;
	long [] vibrates={0,2000,1000,2000,1000,000,1000,2000,1000,000,1000,2000,1000,000,1000,2000,1000,000,1000,2000,1000,000,1000,2000,1000,000,1000,2000,1000,000,1000,2000,1000,
	000,1000,2000,1000,000,1000,2000,1000,000,1000,2000,1000,000,1000,2000,1000,};
	notification.vibrate=vibrates;
	//notification.defaults = Notification.DEFAULT_VIBRATE;
	//notification.defaults=Notification.DEFAULT_ALL;
	 manager.notify(1,notification);
	/*AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
	dialogBuilder.setTitle("Warning");
	dialogBuilder.setMessage("You are forced to be offline.Please try to login again.");
	dialogBuilder.setCancelable(false);
	dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			//销毁所有的活动
			//ActivityController.finishAll();
			//Intent intent = new Intent(getActivity(),AlarmActivity.class);
			//在广播接收器里面启动活动，因此一定要给intent加入如下标识。
			//intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			//getActivity().startActivity(intent);
			//Toast.makeText(null, "闹钟推迟10分钟", Toast.LENGTH_LONG).show();
		}

		//private Context getActivity() {
			// TODO Auto-generated method stub
			//return null;
		//}
	});
	AlertDialog alertDialog = dialogBuilder.create();
	//需要设置AlertDialog的类型，保证在广播接收器中可以正常弹出
	alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
	alertDialog.show();
}*/
	// AddAlarmFragment dialog =AddAlarmFragment.newInstance(AlarmDate.getDate());
		//dialog.setTargetFragment(AlarmFragment.this, REQUEST_DATE_STRING);
	//Intent intent3 =new Intent(context,AlarmService.class);
	 //context.startService(intent3);
		//Intent intent2=new Intent(context,AlarmActivity.class);
	    //intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	   // context.startActivity(intent2);
		 //Intent intent3 =new Intent(context,SingleFragmentActivity.class);
		 //intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		 //context.startActivity(intent3);
	Intent intent21 =new Intent(context,AlarmToastActivity.class);
	intent21.putExtra("contactssid", alarmidd);
	intent21.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	context.startActivity(intent21);

}
//private String formatDate(Date date3){
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:m");

	//return sdf.format(AlarmDate.getDate()).toString();
//}


 
}



