import java.util.*;
import java.io.*;
import java.lang.*;

	
public class Root {
	private String directory;
	private String imageDir;
	
	void Root(){
		directory =  "C:\\Users\\"+ userName() +"\\git\\TagTool\\TagTool\\";
		imageDir = "C:\\Users\\"+ userName() +"\\git\\TagTool\\TagTool\\images\\";
	} 
	public String userName(){
		String userNameString = System.getenv("USERNAME");
		return userNameString;
	}
	public void setRoot(String setDir){
		directory = setDir;
	}
	public String getRoot(){
		return imageDir;
	}
	public void output(){
		File f = new File(directory, "data.txt");
		File d = new File("C:\\Users\\"+ userName() +"\\git\\TagTool\\TagTool\\images\\");
		try{
			f.createNewFile();
		}catch(IOException e){
		}
		File[] list = d.listFiles();
		System.out.println(d.getAbsolutePath());
		for(int i = 0 ; i < list.length ; i++){
			if(list[i].isFile()){
				System.out.println(list[i].getName());
			}
		}
	}
}
