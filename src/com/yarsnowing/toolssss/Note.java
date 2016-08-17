package com.yarsnowing.toolssss;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class Note implements Serializable{
private Date mDate;
private int id;
private String contextString;
private boolean issolved;
public  Note() {
	mDate=new Date();
	Random random =new Random();
	id=random.nextInt(1000);
	
}
public Date getDate() {
	return mDate;
}
public void setDate(Date date) {
	mDate = date;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getContextString() {
	return contextString;
}
public void setContextString(String contextString) {
	this.contextString = contextString;
}
public boolean isIssolved() {
	return issolved;
}
public void setIssolved(boolean issolved) {
	this.issolved = issolved;
}

}

