package com.yarsnowing.toolssss;

import java.util.ArrayList;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;

public class AddRepeat extends DialogFragment {
	private ListView listView;
	//private Button okButton,cancelButton;
	

	 
	
	
	public static final String EXTAR="Datechoosed";
	public ArrayList<Boolean> booleans2=new ArrayList<Boolean>();
	String[] strings={"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
	
	private int i;
	
	
	public static AddRepeat newInstance(ArrayList<Boolean> booleans){
		Bundle args=new Bundle();
		args.putSerializable(EXTAR, booleans);
		AddRepeat fragment =new AddRepeat();
		fragment.setArguments(args);
		return fragment;
	}
	
private void sendResult(int resultCode){
		if(getTargetFragment()==null)
			return;
		Intent i =new Intent();
		
		i.putExtra(EXTAR, booleans2);
		getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
		
	}
	

@SuppressWarnings("unchecked")
@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	booleans2=(ArrayList<Boolean>)getArguments().getSerializable(EXTAR);
	
	

}
@Override
public Dialog onCreateDialog(Bundle saveInstanceStated){
	
	View v=getActivity().getLayoutInflater()
			.inflate(R.layout.repeat_alarmm, null);
	 MyAdapter adapter = new MyAdapter(booleans2);
		listView=(ListView)v.findViewById(R.id.date2);
     listView.setAdapter(adapter);
     listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Log.v("AlarmFregmentt", "你点击了ListView条目" + arg2);
				//Alarm alarm =((MyAdapter)listView.getAdapter()).getItem(arg2);
				//Intent intent=new Intent(getActivity(),AddAlarmFragmenttActivity.class);
				//Intent intent =new Intent(getActivity(),AlarmPagerActivity.class);
				//intent.putExtra(AddAlarmFragmentt.EXTAR_DATE, alarm.getId());
				//startActivity(intent);
			
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
/*@SuppressWarnings("unchecked")
@Override 
public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
	
	booleans2=(ArrayList<Boolean>)getArguments().getSerializable(EXTAR);
	Log.i("booleans2", ""+booleans2.get(i)+booleans2.get(2)+booleans2.get(6));
	View v=getActivity().getLayoutInflater()
			.inflate(R.layout.repeat_alarmm, null);

	listView=(ListView)v.findViewById(R.id.date2);
	okButton=(Button)v.findViewById(R.id.ok);
	cancelButton=(Button)v.findViewById(R.id.cancel);
	okButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			sendResult(Activity.RESULT_OK);
			dismiss();
		}
	});
	cancelButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

		    dismiss();
		}
	});
	
	
		
        MyAdapter adapter = new MyAdapter(booleans2);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Log.v("AlarmFregmentt", "你点击了ListView条目" + arg2);
				//Alarm alarm =((MyAdapter)listView.getAdapter()).getItem(arg2);
				//Intent intent=new Intent(getActivity(),AddAlarmFragmenttActivity.class);
				//Intent intent =new Intent(getActivity(),AlarmPagerActivity.class);
				//intent.putExtra(AddAlarmFragmentt.EXTAR_DATE, alarm.getId());
				//startActivity(intent);
			
			}
		});
       

	    return v;
}*/

		
	
	       
		
		
		//
		
			 
			 
		  
		     
		   
		   
		     
		    // ListView 中某项被选中后的逻辑
		   
		     
		    /**
		     * listview中点击按键弹出对话框
		     */
		  
		     
		     
		     
		    public final class ViewHolder{
		    	public TextView repeatTextView;
		    	//private ListViw listView1;
		    	//private AnalogClock analogClock;
		    	public CheckBox checkBox;
		    }
		     
		     
		    public class MyAdapter extends ArrayAdapter<Boolean>{
		 
		       
		         
		         
		        public MyAdapter(ArrayList<Boolean> arrayList){
		            super(getActivity(), 0, arrayList);
		        }
		       
		 
		       @Override
		       public int getCount(){
		    	   return booleans2.size();
		       }
		       
		        @Override
		        public View getView(final int position, View convertView, ViewGroup parent) {
		            
		            ViewHolder holder = null;
		            if (convertView == null) {
		                 
		                holder=new ViewHolder();  
		                 
		                convertView = getActivity().getLayoutInflater().inflate(R.layout.repeat_alarm, null);
		               // holder.textView1 = (TextView)convertView.findViewById(R.id.textview1);
		                
		                holder.repeatTextView = (TextView)convertView.findViewById(R.id.date3);
		                holder.checkBox = (CheckBox)convertView.findViewById(R.id.isDateChoosed);
		                convertView.setTag(holder);
		                 
		            }else {
		                 
		                holder = (ViewHolder)convertView.getTag();
		            }
		            Boolean booleans=getItem(position);
		            i=position;
		            
		          holder.checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						// TODO Auto-generated method stub
						booleans2.remove(position);
						booleans2.add(position, isChecked);
					getArguments().putSerializable(EXTAR, booleans2);
						
						if(isChecked){
							Log.i("position", ""+isChecked+position);
						}else {
							Log.i("position", ""+isChecked+position);
						}
					}
				});
		         
		           
		           holder.checkBox.setChecked(booleans);
		            holder.repeatTextView.setText(strings[position]);
		             
		            return convertView;
		        }
		         
		    }
		     
     
     
     

}

