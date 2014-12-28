import java.util.StringTokenizer;


public class Data {
	public String directory;	//包含路徑跟檔名
	public String tags;			//一個字串,以","之類的字元分割出各個tag (用strtok之類的?)
								//////改存索引值?
	private String tagList[];	//存分割後的tag
	private int tagCount=0;		//有幾個tag
	
	public boolean dataAvailable(){	//檔案是否存在檔案系統
		
		return true;
	}
	
	public void changeTag(String inputString){	//供UI調用,change tag按鈕按下去時候
		tags=inputString;
		tagToken(tags);
	}
	
	public boolean tagExist(){	//該data是否有tag(已完成)
		if(tags=="")
			return false;
		else		
			return true;
	}
	public void removeData(){	// 就把此檔案的tag都拿掉,主程式端data的數量-1就好
		tags="";
		tagCount=0;
		
	}
	
	private void tagToken(String tagString){
		StringTokenizer Tok=new StringTokenizer(tagString,",");	//以","做區隔
		String buffer="";
		
		while (Tok.hasMoreElements()){
			buffer=(String) Tok.nextElement();
			if(searchTag(buffer)==0){
				tagList[++tagCount]=buffer;	//注意陣列索引值是從1~tagCount,0暫不使用
			}
		}
		
	}
	
	public int searchTag(String tag){
		int index=0;					//若return 0 代表該tag不存在
		for(int i=1;i<=tagCount;i++){
			if(tag==tagList[i]){
				index=i;
				return index;
			}
		}
		
		return index;
	}


}
