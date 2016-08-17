package com.yarsnowing.toolssss;




import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class MoreFragment extends Fragment {
	
	private CheckBox checkbox,checkBox2;
	//private static BDBannerAd bannerAdView;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
	
		
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
		View view= inflater.inflate(R.layout.more_fragment, parent,false);
		
		
		//bannerAdView = new BDBannerAd(getActivity(), "l7cojaj2TkqlFLY5srsXNSSA1CVCqud6",
				//"KzzqMFDHqUTvj6znxbL66vdm");

		// 设置横幅广告展示尺寸，如不设置，默认为SIZE_FLEXIBLE;
		//bannerAdView.setAdSize(BDBannerAd.SIZE_320X50);

		// 设置横幅广告行为监听器
		/*bannerAdView.setAdListener(new BannerAdListener() {

			@Override
			public void onAdvertisementDataDidLoadFailure() {
				Log.e(TAG, "load failure");
			}

			@Override
			public void onAdvertisementDataDidLoadSuccess() {
				Log.e(TAG, "load success");
			}

			@Override
			public void onAdvertisementViewDidClick() {
				Log.e(TAG, "on click");
			}

			@Override
			public void onAdvertisementViewDidShow() {
				Log.e(TAG, "on show");
			}

			@Override
			public void onAdvertisementViewWillStartNewIntent() {
				Log.e(TAG, "leave app");
			}
		});*/

		// 创建广告容器
	//LinearLayout	appxBannerContainer = (LinearLayout)view. findViewById(R.id.aLayout);

		// 显示广告视图
		//appxBannerContainer.addView(bannerAdView);
		
		
		
		
		
		
		SharedPreferences sharedPreferences=getActivity().getSharedPreferences("choosed2",Context.MODE_PRIVATE);
		SharedPreferences sharedPreferences1=getActivity().getSharedPreferences("choosed",Context.MODE_PRIVATE);
		boolean boolean1=sharedPreferences1.getBoolean("status", false);
		
		boolean boolean2=sharedPreferences.getBoolean("status", false);
		checkbox=(CheckBox)view.findViewById(R.id.isLightChoosed1);
		checkBox2=(CheckBox)view.findViewById(R.id.setvolume);
		checkbox.setChecked(boolean1);
		checkBox2.setChecked(boolean2);
		checkBox2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
			checkBox2.setChecked(isChecked);
				if (isChecked) {
					SharedPreferences sharedPreferences=getActivity().getSharedPreferences("choosed2",Context.MODE_PRIVATE);
					SharedPreferences.Editor editor=sharedPreferences.edit();
					editor.putBoolean("status", true);
					editor.commit();
				}else {
					SharedPreferences sharedPreferences=getActivity().getSharedPreferences("choosed2",Context.MODE_PRIVATE);
					SharedPreferences.Editor editor=sharedPreferences.edit();
					editor.putBoolean("status", false);
					editor.commit();
				}	
			}
		});
		checkbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				checkbox.setChecked(isChecked);
				if (isChecked) {
					SharedPreferences sharedPreferences=getActivity().getSharedPreferences("choosed",Context.MODE_PRIVATE);
					SharedPreferences.Editor editor=sharedPreferences.edit();
					editor.putBoolean("status", true);
					editor.commit();
				}else {
					SharedPreferences sharedPreferences=getActivity().getSharedPreferences("choosed",Context.MODE_PRIVATE);
					SharedPreferences.Editor editor=sharedPreferences.edit();
					editor.putBoolean("status", false);
					editor.commit();
				}
			}
		});
		return view;
	}
	
}
