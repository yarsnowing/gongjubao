package com.yarsnowing.toolssss;

import java.util.ArrayList;
import java.util.UUID;

import android.R.integer;
import android.content.Context;
import android.util.Log;

public class AlarmLab {
private ArrayList<Alarm> mAlarms;	
private static final String TAG="AlarmLab";
private static final String FILENAME="Alarm.dat";
	private SaveAlarmSerializer saveAlarmSerializer;
private static AlarmLab sAlarmLab;
private Context mAppContext;
public AlarmLab(Context appContext){
	mAppContext=appContext;
	saveAlarmSerializer =new SaveAlarmSerializer(mAppContext, FILENAME);
	try {
		mAlarms=saveAlarmSerializer.loadAlarms();
		
	} catch (Exception e) {
		// TODO: handle exception
		Log.e(TAG, "error loading alarms");
		mAlarms=new ArrayList<Alarm>();
	}
	//mAlarms=new ArrayList<Alarm>();
	
	/*for (int i=0;i<6;i++){
		
		Alarm a =new Alarm();
		a.setRepeat("Monday"+i);
		a.setMisChoosed(i%2==0);
		mAlarms.add(a);
	}*/
	
	
}
public static AlarmLab get(Context c){
	if(sAlarmLab==null){
		sAlarmLab=new AlarmLab(c.getApplicationContext());
	}
	return sAlarmLab;
}
public ArrayList<Alarm> getAlarms() {
	return mAlarms;
}
public Alarm getAlarm(int id){
	for(Alarm a:mAlarms){
		if(a.getId()==id)
			return a;
	}
	return null;
}
public boolean saveAlarms(){
	saveAlarmSerializer.saveAlarms(mAlarms);
	Log.i(TAG, "Alarms save to file");
	return true;
}
public void addAlarm(Alarm a){
	mAlarms.add(a);
}
public void deleteAlarm(Alarm a){
	mAlarms.remove(a);
}
}
