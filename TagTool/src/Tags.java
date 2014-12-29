
public class Tags {
	private String tagName;
	
	private String[] dataList;		//紀錄哪些data用到此tag(紀錄name)
	private int dataCount=0;		//有幾個data用到此tag
	
	
	//備忘︰在主程式端寫deleteTag,changeTagName,以名字排序Data[]跟Tags[]
	
	public String[] getDataList(){
		return dataList;
	}
	public int getDataCount(){
		return dataCount;
	}
	
	public String getTagName(){		//取得tag的name
		return tagName;
	}
	public void changeTagName(String newName){	//修改tag的name
		tagName=newName;
	}
	
	
	public int searchData(String bdata){
		int index=0;					//若return 0 代表該tag不存在
		for(int i=1;i<=dataCount;i++){
			if(bdata==dataList[i]){
				index=i;
				return index;
			}
		}
		
		return index;
	}
	
}
