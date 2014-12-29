import java.util.StringTokenizer;
//備忘：changeTag之減少tag未完成
//用searchTag==0去做
//changeTag需要判斷新舊字串有幾個tag

public class Data {
	public String directory;	//包含路徑跟檔名
	private String dataName;	//檔名
	public String tags;			//一個字串,以","之類的字元分割出各個tag
	public String tagList[];	//存分割後的tag
	private int tagCount=0;		//此data有幾個tag
	
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
	
	public String getDataName(){
		return dataName;
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
	
	public int searchTag(String btag){
		int index=0;					//若return 0 代表該tag不存在
		for(int i=1;i<=tagCount;i++){
			if(btag==tagList[i]){
				index=i;
				return index;		//找到tag就回傳所在index
			}
		}
		
		return index;	//否則回傳0
	}
	
	public void sort(){		//把分割後的tag做排序
		for(int i=1;i<=tagCount;i++){
			String temp=tagList[i];
			int j;
			for(j=i-1;j>=0 && tagList[j].compareTo(temp)>0;j--)
				tagList[j+1]=tagList[j];
			tagList[j+1]=temp;
		}
	}
	
	public void bind(){		//把排序後的tag丟回字串,用來顯示在UI上
		tags="";
		for(int i=1;i<tagCount;i++){
			tags+=tagList[i]+",";
		}
		tags+=tagList[tagCount];
	}
	

}
