package com.yarsnowing.toolssss;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class StartLightFragment extends Fragment {
	public View aview;
@Override
public void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); 
}
@Override
public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
	View view= inflater.inflate(R.layout.start_light_fragment, parent,false);
	Intent intent =getActivity().getIntent();
	int savedChoosed=intent.getIntExtra("savedChoosed", 0);
	aview =view;
	setLightColor(savedChoosed);
	brightnessMax();
	return view;
}
public void setLightColor(int savedChoosed){
	switch (savedChoosed) {
	
	case 2:
		aview.setBackgroundColor(Color.parseColor("#ff061d"));
		break;
	case 3:
		aview.setBackgroundColor(Color.parseColor("#ffffff"));
		break;
	case 4:
		aview.setBackgroundColor(Color.parseColor("#2f06ff"));
		break;
	case 5:
		aview.setBackgroundColor(Color.parseColor("#06fcff"));
		break;
	case 6:
		aview.setBackgroundColor(Color.parseColor("#00ff54"));
		break;
	case 7:
		aview.setBackgroundColor(Color.parseColor("#fff600"));
		break;
	case 8:
	aview.setBackgroundColor(Color.parseColor("#ff06d9"));
	break;
	default:
		break;
	}
}
private void brightnessMax() {
WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
lp.screenBrightness = 1.0f;
getActivity().getWindow().setAttributes(lp);
}
}