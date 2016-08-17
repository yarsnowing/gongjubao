package com.yarsnowing.toolssss;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.yarsnowing.toolssss.AlarmFragmentt.MyAdapter;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class NoteListFragment extends Fragment {
	 private ArrayList<Note> mNotes;
	 
	 
	 private ListView listView;
		private Button button;
		private static final String EXTRA_ALARM_ID="extraid";
		public TextView timeTextView,repeatTextView;
		
		public CheckBox checkBox;
		
		  String[] strings={"一 ;"," 二 ;"," 三 ;"," 四 ;"," 五 ;"," 六 ;"," 日 ;"};
		 
		   private ArrayList<PendingIntent> savedpendIntents;
		   private  PendingIntent iPendingIntent;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		mNotes= NoteLab.get(getActivity()).getNotes();
		setHasOptionsMenu(true);
		
	}
	
	@Override 
	public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
		View view= inflater.inflate(R.layout.notelistfragment, parent,false);
		
		savedpendIntents=new ArrayList<PendingIntent>();
		
		button=(Button)view.findViewById(R.id.addnote);
		
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Note note=new Note();
				NoteLab.get(getActivity()).addNote(note);
				Intent i = new Intent(getActivity(), NotePagerActivity.class);  
			     // i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);  
			       i.putExtra(AddNoteFragment.EXTAR_DATE, note.getId());
			     startActivityForResult(i, 0);
			        
			      
			}
		});
		listView=(ListView)view.findViewById(R.id.notelist);
		
		
		
		
		registerForContextMenu(listView);
		
       
		
		MyAdapter adapter = new MyAdapter(mNotes);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Log.v("AlarmFregmentt", "你点击了ListView条目" + arg2);
				Note note =((MyAdapter)listView.getAdapter()).getItem(arg2);
				
				Intent intent =new Intent(getActivity(),NotePagerActivity.class);
				intent.putExtra(AddNoteFragment.EXTAR_DATE, note.getId());
				startActivity(intent);
			
			}
		});
        return view;
    }
		
	@Override
	public void onResume(){
		super.onResume();
		((MyAdapter)listView.getAdapter()).notifyDataSetChanged();
	}
	
	//
	
		 
		 
	  
	     
	   
	   
	     
	    
	     
	     
	     
	    public final class ViewHolder{
	    	public TextView timeTextView,repeatTextView;
	    	
	    	public CheckBox checkBox;
	    }
	     
	     
	    public class MyAdapter extends ArrayAdapter<Note>{
	 
	       
	         
	         
	        public MyAdapter(ArrayList<Note> notes){
	            super(getActivity(), 0, notes);
	        }
	       
	 
	       @Override
	       public int getCount(){
	    	   return mNotes.size();
	       }
	       
	        @Override
	        public View getView(  int position, View convertView, ViewGroup parent) {
	            
	          //  ViewHolder holder = null;
	            if (convertView == null) {
	                 
	               // holder=new ViewHolder();  
	                 
	                convertView = getActivity().getLayoutInflater().inflate(R.layout.note_list, null);
	               // holder.textView1 = (TextView)convertView.findViewById(R.id.textview1);
	              //  timeTextView = (TextView)convertView.findViewById(R.id.timesetted);
	              //  repeatTextView = (TextView)convertView.findViewById(R.id.repeatsetted);
	               // checkBox = (CheckBox)convertView.findViewById(R.id.isClockOpen);
	               // convertView.setTag(holder);
	                 
	            }//else {
	                 
	               // holder = (ViewHolder)convertView.getTag();
	           // }
	            
	            timeTextView = (TextView)convertView.findViewById(R.id.timesette);
                repeatTextView = (TextView)convertView.findViewById(R.id.repeatsette);
                
                checkBox = (CheckBox)convertView.findViewById(R.id.isClockOpe);
	           final Note  note =getItem(position);
	           final int  noteId=note.getId();
	           
	             Log.i("noteid idd", ""+noteId);
	             if (note.getContextString()!=null) {
	            	 repeatTextView.setText(note.getContextString());
				}
	            // ArrayList<PendingIntent> ipPendingIntents=new ArrayList<PendingIntent>();
	            // alarm.setIpPendingIntents(ipPendingIntents);
	           
	            //holder.textView1.setBackgroundResource((Integer)mData.get(position).get("img"));
	            timeTextView.setText(formatDate(note.getDate()));
	            StringBuilder stringBuilder =new StringBuilder();
	    		/*for(int i = 0;i<=6;i++){
	    			
	    			if(alarm.getDateArrayList().get(i)==true){
	    				
	    				stringBuilder.append(strings[i]);
	    				
	    				
	    			}
	    			
	    		}
	    		if (stringBuilder.length()>0) {
	    			repeatTextView.setText("星期  "+stringBuilder.toString());
	    		}else {
					repeatTextView.setText("不重复");
				}
				repeatTextView.setText(stringBuilder.toString());*/
	    	
	         
	      checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						// TODO Auto-generated method stub
						note.setIssolved(isChecked);
						//holder.checkBox.setChecked(alarm.isMisChoosed());
						if(isChecked){
							//Toast.makeText(getActivity(), "已完成", Toast.LENGTH_SHORT).show();
							//Intet intent =new Intent(getActivity(),AlarmService.class);
							//intent.putExtra("autostart", true);
							//getActivity().startService(intent);
							//Log.i("checkbox", ""+true);
						}else {
							/*ArrayList<Integer> integers=new ArrayList<Integer>();
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
							}*/
							Log.i("checkbox", ""+false);
						}
					}
				}); 
	          checkBox.setChecked(note.isIssolved());
	           
	             
	            return convertView;
	        }
	         
	    }
	     
	    @Override
	    public void onPause(){
	    	super.onPause();
	    	NoteLab.get(getActivity()).saveNotes();
	    }
	    private String formatDate(Date date3){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:m");

			return sdf.format(date3).toString();
		}
	     @Override
	     public void onCreateContextMenu(ContextMenu menu,View v,ContextMenuInfo menuInfo){
	    	//switch (v.getId()) {
			//case R.id.notelist:
				 getActivity().getMenuInflater().inflate(R.menu.note_list_item_context, menu);
				//break;

			//default:
				//break;
			//}
	    	
	     }
	   @Override
	     public boolean onContextItemSelected(MenuItem item){
	    	 AdapterContextMenuInfo info =(AdapterContextMenuInfo)item.getMenuInfo();
	    	 int position=info.position;
	    	 MyAdapter adapter=(MyAdapter) listView.getAdapter();
	    	 
	         
	    	
	    	 switch (item.getItemId()) {
			case R.id.menu_item_delete_note:
				Log.i("delete note", "sucess");
				Note note=adapter.getItem(position);
				NoteLab.get(getActivity()).deleteNote(note);
				adapter.notifyDataSetChanged();
				return true;
				

			
			}
	    	 return super.onContextItemSelected(item);
	     }
	     
	
}
