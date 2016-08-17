package com.yarsnowing.toolssss;


import java.util.ArrayList;
import java.util.UUID;

import android.R.integer;
import android.content.Context;
import android.util.Log;

public class NoteLab {
private ArrayList<Note> mNotes;	
private static final String TAG="NoteLab";
private static final String FILENAME="Note.dat";
	private saveNoteSerializer saveNoteSerializer;
private static NoteLab sNoteLab;
private Context mAppContext;
public NoteLab(Context appContext){
	mAppContext=appContext;
	saveNoteSerializer =new saveNoteSerializer(mAppContext, FILENAME);
	try {
		mNotes=saveNoteSerializer.loadNotes();
		
	} catch (Exception e) {
		// TODO: handle exception
		Log.e(TAG, "error loading alarms");
		mNotes=new ArrayList<Note>();
	}
	//mAlarms=new ArrayList<Alarm>();
	
	/*for (int i=0;i<6;i++){
		
		Alarm a =new Alarm();
		a.setRepeat("Monday"+i);
		a.setMisChoosed(i%2==0);
		mAlarms.add(a);
	}*/
	
	
}
public static NoteLab get(Context c){
	if(sNoteLab==null){
		sNoteLab=new NoteLab(c.getApplicationContext());
	}
	return sNoteLab;
}
public ArrayList<Note> getNotes() {
	return mNotes;
}
public Note getNote(int id){
	for(Note a:mNotes){
		if(a.getId()==id)
			return a;
	}
	return null;
}
public boolean saveNotes(){
	saveNoteSerializer.saveNotes(mNotes);
	Log.i(TAG, "Notes save to file");
	return true;
}
public void addNote(Note a){
	mNotes.add(a);
}
public void deleteNote(Note a){
	mNotes.remove(a);
}
}
