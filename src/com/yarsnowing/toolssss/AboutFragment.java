package com.yarsnowing.toolssss;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AboutFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		//mAlarms= AlarmLab.get(getActivity()).getAlarms();
		
		
	}
	@Override 
	public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
		View view= inflater.inflate(R.layout.about, parent,false);
		return view;
}
}
