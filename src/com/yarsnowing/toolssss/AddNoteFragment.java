package com.yarsnowing.toolssss;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddNoteFragment extends Fragment {

	public static String EXTAR_DATE="date";
	public int noteId;
	private Note mNote;
	private Button cancelButton,doneButton;
	private EditText editText;
	private TextView titleTextView;
	private String string;
	
	public static AddNoteFragment newInstance(int i){
		Bundle args=new Bundle();
		args.putSerializable(EXTAR_DATE, i);
		AddNoteFragment fragment =new AddNoteFragment();
		fragment.setArguments(args);
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		
		
		
		
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
		
		
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
		noteId=(int)getArguments().getInt(EXTAR_DATE);
		mNote=NoteLab.get(getActivity()).getNote(noteId);
		
		Log.i("noteId=", ""+noteId);
		if (NavUtils.getParentActivityName(getActivity())!=null) {
			getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		View view= inflater.inflate(R.layout.add_note, parent,false);
		cancelButton=(Button)view.findViewById(R.id.addcancel);
		doneButton=(Button)view.findViewById(R.id.adddone);
		titleTextView=(TextView)view.findViewById(R.id.time);
		titleTextView.setText(formatDate(mNote.getDate()));
		editText=(EditText)view.findViewById(R.id.editnote);
		if (mNote.getContextString()!=null) {
			editText.setText(mNote.getContextString());
			editText.setSelection(mNote.getContextString().length());
		}
		//editText.setText(formatDate(mNote.getDate()));
		//titleTextView.setText(mNote.getContextString());
		
		doneButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				string=editText.getText().toString();
				mNote.setContextString(string);
				Log.i("string", ""+string);
				Toast.makeText(getActivity(), "添加成功,注意不要忘记哦!", Toast.LENGTH_SHORT).show();
				AddNoteFragment.this.getActivity().finish();
			}
		});
		cancelButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AddNoteFragment.this.getActivity().finish();
			}
		});
	return view;
}
	private String formatDate(Date date3){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:m");

		return sdf.format(date3).toString();
	}
}
