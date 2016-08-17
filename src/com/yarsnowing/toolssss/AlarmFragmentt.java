package com.yarsnowing.toolssss;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R.integer;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AnalogClock;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;

public class AlarmFragmentt extends Fragment {
	private ListView listView1;
	private Button button,deButton;
	private static final String EXTRA_ALARM_ID="extraid";
	public TextView timeTextView,repeatTextView;
	//private ListView listView1;
	//private AnalogClock analogClock;
	public CheckBox checkBox;
	  private ArrayList<Alarm> mAlarms;
	  String[] strings={"一 ;"," 二 ;"," 三 ;"," 四 ;"," 五 ;"," 六 ;"," 日 ;"};
	  //private Date mDate;
	//private Button buttontime;
	   private ArrayList<PendingIntent> savedpendIntents;
	   private  PendingIntent iPendingIntent;
	   Alarm alarm;
	   int alarmId;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		mAlarms= AlarmLab.get(getActivity()).getAlarms();
		
		
	}
	@Override 
	public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
		View view= inflater.inflate(R.layout.alarm_fragmentt, parent,false);
		
		savedpendIntents=new ArrayList<PendingIntent>();
		
		button=(Button)view.findViewById(R.id.addAlarm1);
		
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Alarm alarm=new Alarm();
				AlarmLab.get(getActivity()).addAlarm(alarm);
				Intent i = new Intent(getActivity(), AlarmPagerActivity.class);  
			     // i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);  
			       i.putExtra(AddAlarmFragmentt.EXTAR_DATE, alarm.getId());
			     startActivityForResult(i, 0);
			        
			      
			}
		});
		listView1=(ListView)view.findViewById(R.id.listview1);
		
		
		
		
		registerForContextMenu(listView1);
		
       
		
		MyAdapter adapter = new MyAdapter(mAlarms);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Log.v("AlarmFregmentt", "你点击了ListView条目" + arg2);
				Alarm alarm =((MyAdapter)listView1.getAdapter()).getItem(arg2);
				
				Intent intent =new Intent(getActivity(),AlarmPagerActivity.class);
				intent.putExtra(AddAlarmFragmentt.EXTAR_DATE, alarm.getId());
				startActivity(intent);
			
			}
		});
        return view;
    }
		
	@Override
	public void onResume(){
		super.onResume();
		((MyAdapter)listView1.getAdapter()).notifyDataSetChanged();
	}
	
	//
	
		 
		 
	  
	     
	   
	   
	     
	    
	     
	     
	     
	  //  public final class ViewHolder{
	    //	public TextView timeTextView,repeatTextView;
	    	
	    	//public CheckBox checkBox;
	   // }
	     
	     
	    public class MyAdapter extends ArrayAdapter<Alarm>{
	 
	       
	         
	         
	        public MyAdapter(ArrayList<Alarm> alarms){
	            super(getActivity(), 0, alarms);
	        }
	       
	 
	       @Override
	       public int getCount(){
	    	   return mAlarms.size();
	       }
	       
	        @Override
	        public View getView(int position, View convertView, ViewGroup parent) {
	            
	          // ViewHolder holder = null;
	            if (convertView == null) {
	                 
	                //holder=new ViewHolder();  
	                 
	                convertView = getActivity().getLayoutInflater().inflate(R.layout.listview1, null);
	               //holder.textView1 = (TextView)convertView.findViewById(R.id.textview1);
	              timeTextView = (TextView)convertView.findViewById(R.id.timesetted);
	             repeatTextView = (TextView)convertView.findViewById(R.id.repeatsetted);
	               checkBox = (CheckBox)convertView.findViewById(R.id.isClockOpen);
	               //convertView.setTag(holder);
	                 
	            }//else{
	                 
	              // holder = (ViewHolder)convertView.getTag();
	           // }
	            
	           timeTextView = (TextView)convertView.findViewById(R.id.timesetted);
               repeatTextView = (TextView)convertView.findViewById(R.id.repeatsetted);
                checkBox = (CheckBox)convertView.findViewById(R.id.isClockOpen);
	          final Alarm  alarm =getItem(position);
	           final int  alarmId=alarm.getId();
	             Log.i("alarmid idd", ""+alarmId);
	            // ArrayList<PendingIntent> ipPendingIntents=new ArrayList<PendingIntent>();
	            // alarm.setIpPendingIntents(ipPendingIntents);
	           
	            //holder.textView1.setBackgroundResource((Integer)mData.get(position).get("img"));
	         timeTextView.setText(formatDate(alarm.getDate()));
	           final StringBuilder stringBuilder =new StringBuilder();
	    		for(int i = 0;i<=6;i++){
	    			
	    			if(alarm.getDateArrayList().get(i)==true){
	    				
	    				stringBuilder.append(strings[i]);
	    				
	    				
	    			}
	    			
	    		}
	    		if (stringBuilder.length()>0) {
	    			repeatTextView.setText("星期  "+stringBuilder.toString());
	    			//repeatTextView.setText(stringBuilder.toString());
	    		}else {
					repeatTextView.setText("不重复");
				}
	    		Log.i("stringbuiler", stringBuilder.toString());
	    	
	         
	      checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						// TODO Auto-generated method stub
						alarm.setMisChoosed(isChecked);
						//holder.checkBox.setChecked(alarm.isMisChoosed());
						if(isChecked){
							Intent intent =new Intent(getActivity(),AlarmService.class);
							intent.putExtra("autostart", true);
							getActivity().startService(intent);
							Log.i("checkbox", ""+true);
							//Toast.makeText(getActivity(), "闹钟打开成功", Toast.LENGTH_SHORT).show();
						}else {
							ArrayList<Integer> integers=new ArrayList<Integer>();
							integers.clear();
							integers.add(alarmId+1);
							integers.add(alarmId+2);
							integers.add(alarmId+3);
							integers.add(alarmId+4);
							integers.add(alarmId+5);
							integers.add(alarmId+6);
							integers.add(alarmId+7);
							integers.add(alarmId+8);
							Intent intent1=new Intent("Alarm1");
							savedpendIntents.clear();
							for (int i = 0; i < 8; i++) {
								iPendingIntent=PendingIntent.getBroadcast(getActivity(),integers.get(i), intent1, 0);
								savedpendIntents.add(iPendingIntent);
							}
							AlarmManager am = (AlarmManager) getActivity().getSystemService(Activity.ALARM_SERVICE);
							for (int i = 0; i < integers.size(); i++) {
								am.cancel(savedpendIntents.get(i));
							}
							//Toast.makeText(getActivity(), "闹钟已删除", Toast.LENGTH_SHORT).show();
							Log.i("checkbox", ""+false);
						}
					}
				}); 
	         checkBox.setChecked(alarm.isMisChoosed());
	           
	             
	            return convertView;
	        }
	         
	    }
	     
	    @Override
	    public void onPause(){
	    	super.onPause();
	    	AlarmLab.get(getActivity()).saveAlarms();
	    }
	    private String formatDate(Date date3){
			SimpleDateFormat sdf = new SimpleDateFormat("H:m");

			return sdf.format(date3).toString();
		}
	     @Override
	     public void onCreateContextMenu(ContextMenu menu,View v,ContextMenuInfo menuInfo){
	    	 //switch (v.getId()) {
	    	 //case R.id.listview1:
	    	 getActivity().getMenuInflater().inflate(R.menu.alarm_list_item_context, menu);
	    	// break;
	    	// }
	     }
	     @Override
	     public boolean onContextItemSelected(MenuItem item){
	    	 AdapterContextMenuInfo info =(AdapterContextMenuInfo)item.getMenuInfo();
	    	 int position=info.position;
	    	 MyAdapter adapter=(MyAdapter) listView1.getAdapter();
	    	 
	    	 switch (item.getItemId()) {
			case R.id.menu_item_delete_crime:
				Log.i("delete_crime", "suceess");
				Alarm alarm=adapter.getItem(position);
		    	 int alarmId=alarm.getId();
				ArrayList<Integer> integers=new ArrayList<Integer>();
				integers.clear();
				integers.add(alarmId+1);
				integers.add(alarmId+2);
				integers.add(alarmId+3);
				integers.add(alarmId+4);
				integers.add(alarmId+5);
				integers.add(alarmId+6);
				integers.add(alarmId+7);
				integers.add(alarmId+8);
				Intent intent1=new Intent("Alarm1");
				savedpendIntents.clear();
				for (int i = 0; i < 8; i++) {
					iPendingIntent=PendingIntent.getBroadcast(getActivity(),integers.get(i), intent1, 0);
					savedpendIntents.add(iPendingIntent);
				}
				AlarmManager am = (AlarmManager) getActivity().getSystemService(Activity.ALARM_SERVICE);
				for (int i = 0; i < integers.size(); i++) {
					am.cancel(savedpendIntents.get(i));
				}
				AlarmLab.get(getActivity()).deleteAlarm(alarm);
				adapter.notifyDataSetChanged();
				return true;
				

			
			}
	    	 return super.onContextItemSelected(item);
	     }
	     
	
}