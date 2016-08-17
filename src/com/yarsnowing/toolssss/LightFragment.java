package com.yarsnowing.toolssss;

import java.security.PublicKey;

import android.R.integer;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class LightFragment extends Fragment {

	private Button button2,button3,button4,button5,button6,button7,button8,button9,button10;
	static Boolean isClick=false;
	int savedChoosed=0;
	LightFragment aFragment;
	 private boolean status = false;  
	    private Camera camera;  
	    private Parameters parameters;  
	    private LightFragment instance;  
	    private boolean choosed=false;
	    private boolean statusss=false;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		SharedPreferences sharedPreferences=getActivity().getSharedPreferences("savedRecored", Context.MODE_PRIVATE);
		savedChoosed =sharedPreferences.getInt("savedChoosed", 0);
		 instance = this;  
	        //camera = Camera.open();
	}
		@Override
		public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
			View view= inflater.inflate(R.layout.light_fragment, parent,false);
		button2=(Button)view.findViewById(R.id.button2);
		button3=(Button)view.findViewById(R.id.button3);
		button4=(Button)view.findViewById(R.id.button4);
		button5=(Button)view.findViewById(R.id.button5);
		button6=(Button)view.findViewById(R.id.button6);
		button7=(Button)view.findViewById(R.id.button7);
		button8=(Button)view.findViewById(R.id.button8);
		button9=(Button)view.findViewById(R.id.button9);
		button9.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!status) {  
                    //openLight.setText("¹Ø±Õ");
					button9.setBackgroundDrawable(getResources().getDrawable(R.drawable.lightafter));
                    status = true;  
                    new Thread(new TurnOnLight()).start();  
                }else {  
                    status = false;  
                   // openLight.setText("´ò¿ª");  
                    button9.setBackgroundDrawable(getResources().getDrawable(R.drawable.lightbefore));
                    instance.parameters.setFlashMode("off");  
                    instance.camera.setParameters(instance.parameters);  
                    instance.camera.release();
                    //Intent  intent =new Intent(getActivity(),PhoneBroadcastReceiver.class);
                  //  intent.putExtra("stutas", )
                   // getActivity().sendBroadcast(intent);
                }  
            }  
			
		});
		/*button10=(Button)view.findViewById(R.id.button10);
		setChoosed();
		button10.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(choosed==false){
				SharedPreferences sharedPreferences=getActivity().getSharedPreferences("choosed",Context.MODE_PRIVATE);
				SharedPreferences.Editor editor=sharedPreferences.edit();
				editor.putBoolean("status", true);
				editor.commit();
				choosed=true;
				setChoosed();
				}else {
					SharedPreferences sharedPreferences=getActivity().getSharedPreferences("choosed",Context.MODE_PRIVATE);
					SharedPreferences.Editor editor=sharedPreferences.edit();
					editor.putBoolean("status", false);
					editor.commit();
					choosed=false;
					setChoosed();
				}
			}
		});*/
		//aFragment=new LightFragment();
		setBackgroundColor(savedChoosed);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				savedChoosed=2;
				setBackground();
			}
		});
		button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				savedChoosed=3;
				setBackground();
			}
		});
		button4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				savedChoosed=4;
				setBackground();
			}
		});
		
		button5.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				savedChoosed=5;
				setBackground();
			}
		});
		button6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				savedChoosed=6;
				setBackground();
			}
		});
		button7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				savedChoosed=7;
				setBackground();
			}
		});
		button8.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				savedChoosed=8;
				setBackground();
				
			}
		});
			return view;
		}
		private class TurnOnLight implements Runnable{  
	       
			@Override  
	        public void run() {  
				camera=Camera.open();
	            instance.parameters = instance.camera.getParameters();  
	            instance.parameters.setFlashMode("torch");  
	            instance.camera.setParameters(instance.parameters);  
	            
	            
	    }  
		}
		public  void setBackground(){
		 isClick=true;
		 SharedPreferences preferences=getActivity().getSharedPreferences("savedRecored", Context.MODE_PRIVATE);
			SharedPreferences.Editor editor =preferences.edit();
			
			editor.putInt("savedChoosed", savedChoosed);
			editor.commit();
			Log.i("saveChoosed", "savedChoosed"+"="+savedChoosed);
			setBackgroundColor(savedChoosed);
			startLight(savedChoosed);
		}
		@SuppressWarnings("deprecation")
		public void setBackgroundColor(int savedChoosed){
			switch (savedChoosed) {
			case 2:
				button2.setBackgroundDrawable(getResources().getDrawable(R.drawable.done));
				//button2.getBackground().setAlpha(50);
				button3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button3));
				button4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button4));
				button5.setBackgroundDrawable(getResources().getDrawable(R.drawable.button5));
				button6.setBackgroundDrawable(getResources().getDrawable(R.drawable.button6));
				button7.setBackgroundDrawable(getResources().getDrawable(R.drawable.button7));
				button8.setBackgroundDrawable(getResources().getDrawable(R.drawable.button8));
				
				
				break;
			case 3:
				button2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button2));
				button3.setBackgroundDrawable(getResources().getDrawable(R.drawable.done));
				button4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button4));
				button5.setBackgroundDrawable(getResources().getDrawable(R.drawable.button5));
				button6.setBackgroundDrawable(getResources().getDrawable(R.drawable.button6));
				button7.setBackgroundDrawable(getResources().getDrawable(R.drawable.button7));
				button8.setBackgroundDrawable(getResources().getDrawable(R.drawable.button8));
			break;
			case 4:
				button2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button2));
				button3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button3));
				button4.setBackgroundDrawable(getResources().getDrawable(R.drawable.done));
				button5.setBackgroundDrawable(getResources().getDrawable(R.drawable.button5));
				button6.setBackgroundDrawable(getResources().getDrawable(R.drawable.button6));
				button7.setBackgroundDrawable(getResources().getDrawable(R.drawable.button7));
				button8.setBackgroundDrawable(getResources().getDrawable(R.drawable.button8));
				break;
			case 5:
				button2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button2));
				button3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button3));
				button4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button4));
				button5.setBackgroundDrawable(getResources().getDrawable(R.drawable.done));
				button6.setBackgroundDrawable(getResources().getDrawable(R.drawable.button6));
				button7.setBackgroundDrawable(getResources().getDrawable(R.drawable.button7));
				button8.setBackgroundDrawable(getResources().getDrawable(R.drawable.button8));
				break;
			case 6:
				button2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button2));
				button3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button3));
				button4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button4));
				button5.setBackgroundDrawable(getResources().getDrawable(R.drawable.button5));
				button6.setBackgroundDrawable(getResources().getDrawable(R.drawable.done));
				button7.setBackgroundDrawable(getResources().getDrawable(R.drawable.button7));
				button8.setBackgroundDrawable(getResources().getDrawable(R.drawable.button8));
				break;
			case 7:
				button2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button2));
				button3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button3));
				button4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button4));
				button5.setBackgroundDrawable(getResources().getDrawable(R.drawable.button5));
				button6.setBackgroundDrawable(getResources().getDrawable(R.drawable.button6));
				button7.setBackgroundDrawable(getResources().getDrawable(R.drawable.done));
				button8.setBackgroundDrawable(getResources().getDrawable(R.drawable.button8));
				break;
			case 8:
				button2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button2));
				button3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button3));
				button4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button4));
				button5.setBackgroundDrawable(getResources().getDrawable(R.drawable.button5));
				button6.setBackgroundDrawable(getResources().getDrawable(R.drawable.button6));
				button7.setBackgroundDrawable(getResources().getDrawable(R.drawable.button7));
				button8.setBackgroundDrawable(getResources().getDrawable(R.drawable.done));
				break;
			default:
				break;
			}
			
		}
		public void startLight(int savedChoosed){
			Intent intent =new Intent(getActivity(),StartLightFragmentActivity.class);
			intent.putExtra("savedChoosed", savedChoosed);
			startActivity(intent);
		}
		/*@SuppressWarnings("deprecation")
		public void setChoosed(){
			SharedPreferences sharedPreferences=getActivity().getSharedPreferences("choosed",Context.MODE_PRIVATE);
			statusss =sharedPreferences.getBoolean("status", false);
			Log.i("statusss", statusss+"");
			if(statusss==true){
				button10.setBackgroundDrawable(getResources().getDrawable(R.drawable.done));
				Log.i("setChoosed", "set drawable done");}
				else {
					button10.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher));
				}
			}
		*/
		
}
