import java.util.*;
import java.io.*;
import java.lang.*;

import javax.swing.JFileChooser;

	
public class Root {
	private String directory;
	private String tagDir;
	
	void Root(){
		directory =  "C:\\Users\\"+ userName() +"\\git\\TagTool\\TagTool\\";
		tagDir = "";
	} 
	public String userName(){
		String userNameString = System.getenv("USERNAME");
		return userNameString;
	}
	public void setRoot(String setDir,String settagDir){
		directory = setDir;
		tagDir = settagDir;
	}
	public String getRoot(){
		return directory;
	}
	public String getTagRoot(){
		return tagDir;
	}
	public void changeRoot(){
		JFileChooser chooser = new JFileChooser(); 
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("選擇你的目錄");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.showOpenDialog(null) ;

		setRoot(chooser.getSelectedFile().getAbsolutePath(),chooser.getSelectedFile().getParentFile().getAbsolutePath()+"\\tags\\");

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
