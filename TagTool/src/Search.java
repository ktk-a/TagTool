import java.io.File;


public class Search {
	
	void main(){
		Root a = new Root();
		File f = new File("C:\\Users\\"+ a.userName() +"\\Pictures\\tagTool","123.txt");
		File t = new File("C:\\Users\\"+ a.userName() +"\\Pictures\\tagTool\\tags","123.txt");
		if(!t.exists()){
			t.getParentFile().mkdirs();
			System.out.println("a");
		}
	}

}
