package com.yarsnowing.toolssss;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import android.app.PendingIntent;

public class Alarm implements Serializable {
private int mId;
private Date mDate;
private boolean misChoosed;
private String repeat;
private boolean[] booleans;
private ArrayList<Boolean> dateArrayList;
private  transient ArrayList<PendingIntent> ipPendingIntents;
private  transient ArrayList<PendingIntent> iPendingIntentsss;
private ArrayList<Integer> daydelaysaved;
private String contactname;
private String contactphone;
public  Alarm(){
	Random random=new Random();
	mId=random.nextInt(10000);
	mDate=new Date();
	dateArrayList=new ArrayList<Boolean>();
	dateArrayList.add(false);
	dateArrayList.add(false);dateArrayList.add(false);dateArrayList.add(false);dateArrayList.add(false);dateArrayList.add(false);dateArrayList.add(false);
	ipPendingIntents=new ArrayList<PendingIntent>();
	daydelaysaved=new ArrayList<Integer>();
	
}
public int getId() {
	return mId;
}
public void setId(int id) {
	mId = id;
}
public Date getDate() {
	return mDate;
}
public void setDate(Date date) {
	mDate = date;
}

public String getRepeat() {
	return repeat;
}
public void setRepeat(String repeat) {
	this.repeat = repeat;
}
public boolean isMisChoosed() {
	return misChoosed;
}
public void setMisChoosed(boolean misChoosed) {
	this.misChoosed = misChoosed;
}


public boolean[] getBooleans() {
	return booleans;
}
public void setBooleans(boolean[] booleans) {
	this.booleans = booleans;
}
public ArrayList<Boolean> getDateArrayList() {
	return dateArrayList;
}
public void setDateArrayList(ArrayList<Boolean> dateArrayList) {
	this.dateArrayList = dateArrayList;
}
public ArrayList<PendingIntent> getIpPendingIntents() {
	return ipPendingIntents;
}
public void setIpPendingIntents(ArrayList<PendingIntent> ipPendingIntents) {
	this.ipPendingIntents = ipPendingIntents;
}
public ArrayList<Integer> getDaydelaysaved() {
	return daydelaysaved;
}
public void setDaydelaysaved(ArrayList<Integer> daydelaysaved) {
	this.daydelaysaved = daydelaysaved;
}
public ArrayList<PendingIntent> getiPendingIntent() {
	return iPendingIntentsss;
}

public void setiPendingIntent(ArrayList<PendingIntent> iPendingIntent) {
	this.iPendingIntentsss = iPendingIntent;
}
public String getContactname() {
	return contactname;
}
public void setContactname(String contactname) {
	this.contactname = contactname;
}
public String getContactphone() {
	return contactphone;
}
public void setContactphone(String contactphone) {
	this.contactphone = contactphone;
}


}
