
public class Tags {
	private String tagName;
	
	private String[] dataList;		//��������data�Ψ즹tag(����name)
	private int dataCount=0;		//���X��data�Ψ즹tag
	
	
	//�ƧѡJ�b�D�{���ݼgdeleteTag,changeTagName,�H�W�r�Ƨ�Data[]��Tags[]
	
	
	
	public String getTagName(){		//���otag��name
		return tagName;
	}
	public void changeTagName(String newName){	//�ק�tag��name
		tagName=newName;
	}
	
	
}
