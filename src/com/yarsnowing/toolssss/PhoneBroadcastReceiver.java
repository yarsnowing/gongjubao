package com.yarsnowing.toolssss;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneBroadcastReceiver extends BroadcastReceiver {
	 private static final String TAG = "message";
	    private static boolean mIncomingFlag = false;
	    private static String mIncomingNumber = null;
	    private boolean status = false;  
	   // private LightSosService instance;
	    private Camera camera; 
	   // private PhoneBroadcastReceiver instance;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		//camera=Camera.open();
		SharedPreferences sharedPreferences =context.getSharedPreferences("choosed", Context.MODE_PRIVATE);
		Boolean statuss=sharedPreferences.getBoolean("status", false);
		Intent intent2=new Intent(context,LightSosService.class);
       // intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent2.putExtra("status", status);
       // context.startService(intent2);
		 if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
	            mIncomingFlag = false;
	            String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
	            Log.i(TAG, "call OUT:" + phoneNumber);
	          // intent2.putExtra("status", status);
               // context.startService(intent2);
	            
	        } else {
	            // 如果是来电
	            TelephonyManager tManager = (TelephonyManager) context
	                    .getSystemService(Service.TELEPHONY_SERVICE);
	            switch (tManager.getCallState()) {
	            
	            case TelephonyManager.CALL_STATE_RINGING:
	                mIncomingNumber = intent.getStringExtra("incoming_number");
	                status = true;  
	                if(statuss==true){
                   // new Thread(new TurnOnLight()).start(); 
	               // Intent intent2=new Intent(context,LightSosService.class);
	              // intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                intent2.putExtra("status", status);
	                context.startService(intent2);
	                Log.i(TAG, "RINGING :" + mIncomingNumber);}
	                break;
	            case TelephonyManager.CALL_STATE_OFFHOOK:
	                if (mIncomingFlag) {
	                    Log.i(TAG, "incoming ACCEPT :" + mIncomingNumber);
	                }
	                status = false; 
	                //instance =new LightSosService();
	                //instance.ca
	                //camera=Camera.open();
	                //camera.release();
	                
	                intent2.putExtra("status", status);
	                context.stopService(intent2);
	               // LightSosService.in
	                //Intent intent21=new Intent(context,LightSosService.class);
	               // intent21.putExtra("status", status);
	                //context.startService(intent2);
                   // openLight.setText("打开");  
                    //instance.parameters.setFlashMode("off");  
                    //instance.camera.setParameters(instance.parameters);  
	                break;
	            case TelephonyManager.CALL_STATE_IDLE:
	                if (mIncomingFlag) {
	                    Log.i(TAG, "incoming IDLE");
	                }
	               // camera=Camera.open();
	               // camera.release();
	                status = false; 
	                intent2.putExtra("status", status);
	                context.stopService(intent2);
	                //camera=Camera.open();
	                break;
	            }
	        }
	    }
	
	}


