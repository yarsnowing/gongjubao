package com.yarsnowing.toolssss;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

public class saveNoteSerializer {
private Context mContext;
private String mFilename;
public saveNoteSerializer(Context c, String f){
	mContext=c;
	mFilename=f;
}
public void saveNotes(ArrayList<Note> notes){
	 
	 FileOutputStream fos = null;  
     ObjectOutputStream oos = null;
     try {  
         fos = mContext.openFileOutput(mFilename, 0);  
         oos = new ObjectOutputStream(fos);  
         oos.writeObject(notes);  
     } catch (Exception e) {  
         e.printStackTrace();  
         //这里是保存文件产生异常  
     } finally {  
         if (fos != null){  
             try {  
                 fos.close();  
             } catch (IOException e) {  
                 //fos流关闭异常  
                 e.printStackTrace();  
             }  
         }  
         if (oos != null){  
             try {  
                 oos.close();  
             } catch (IOException e) {  
                 //oos流关闭异常  
                 e.printStackTrace();  
             }  
         }  
     }  
    

}
@SuppressWarnings("unchecked")
public ArrayList<Note> loadNotes(){
	ArrayList<Note> notes =new ArrayList<Note>(); 
	ObjectInputStream ois = null;
	 
	 FileInputStream fis = null;//局部变量必须要初始化
	 try {  
         fis = mContext.openFileInput(mFilename);  
         ois = new ObjectInputStream(fis);  
         notes=(ArrayList<Note>) ois.readObject();
          
     } catch (Exception e) {  
         e.printStackTrace();  
         Log.e("saveNoteSerializer", "error loading notes");
         //这里是读取文件产生异常  
     } finally {  
         if (fis != null){  
             try {  
                 fis.close();  
             } catch (IOException e) {  
                 //fis流关闭异常  
                 e.printStackTrace();  
             }  
         }  
         if (ois != null){  
             try {  
                 ois.close();  
             } catch (IOException e) {  
                 //ois流关闭异常  
                 e.printStackTrace();  
             }  
         }  
     }  
     //读取产生异常，返回null  
	 return notes;
}
}

