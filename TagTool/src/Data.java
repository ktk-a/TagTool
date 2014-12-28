
public class Data {
	public String directory;	//包含路徑跟檔名
	public String tags;			//一個字串,以","之類的字元分割出各個tag (用strtok之類的?)
	
	
	public boolean dataAvailable(){	//檔案是否存在檔案系統
		
		return true;
	}
	
	public void changeTag(String inputString){	//供UI調用,change tag按鈕按下去時候
		tags=inputString;
	}
	
	public boolean tagExist(){	//該data是否有tag,已做完
		if(tags=="")
			return false;
		else		
			return true;
	}
	public void removeData(){	// 就把此檔案的tag都拿掉,data的數量-1就好
		
	}
	
	


}
