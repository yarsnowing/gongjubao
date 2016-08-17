package com.yarsnowing.toolssss;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.R.integer;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;




public class AddAlarmFragment extends DialogFragment {
	public static Calendar calendar=Calendar.getInstance();
	
    int year;
    int month;
    int day;
    int hour;
    int minute;
	
	public static final String EXTAR_DATE="Datechoosed";
	private Date mDate;
	
	public static AddAlarmFragment newInstance(Date date){
		Bundle args=new Bundle();
		args.putSerializable(EXTAR_DATE, date);
		AddAlarmFragment fragment =new AddAlarmFragment();
		fragment.setArguments(args);
		return fragment;
	}
private void sendResult(int resultCode){
		if(getTargetFragment()==null)
			return;
		Intent i =new Intent();
		
	
		i.putExtra(EXTAR_DATE, mDate);
		getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
		
	}
	@Override
	public Dialog onCreateDialog(Bundle saveInstanceStated){
		
		mDate=(Date)getArguments().getSerializable(EXTAR_DATE);
		
		//calendar.set
		calendar.setTime(mDate);
		
		View v=getActivity().getLayoutInflater()
				.inflate(R.layout.dialog_date, null);
		
		
		TimePicker timePicker =(TimePicker)v.findViewById(R.id.timepicker);
		timePicker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
		timePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));
		timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
			 
			  @Override
			  public void onTimeChanged(TimePicker arg0, int hour, int minute) {
			  
			mDate =new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), hour, minute).getTime();
			  getArguments().putSerializable(EXTAR_DATE, mDate);
			  }
			  });
		
		return new AlertDialog.Builder(getActivity())
		.setView(v)
				.setTitle(R.string.setdate)
				.setPositiveButton(android.R.string.ok,null)
				.setPositiveButton(android.R.string.ok, new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						sendResult(Activity.RESULT_OK);
					}
				})
		.setNegativeButton(android.R.string.cancel, null).create();
		
	
	}
	@Override
	public void onDestroy(){
		super.onDestroy();
		
	}
}
