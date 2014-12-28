import java.util.StringTokenizer;


public class Data {
	public String directory;	//�]�t���|���ɦW
	public String tags;			//�@�Ӧr��,�H","�������r�����ΥX�U��tag (��strtok������?)
								//////��s���ޭ�?
	private String tagList[];	//�s���Ϋ᪺tag
	private int tagCount=0;		//���X��tag
	
	public boolean dataAvailable(){	//�ɮ׬O�_�s�b�ɮרt��
		
		return true;
	}
	
	public void changeTag(String inputString){	//��UI�ե�,change tag���s���U�h�ɭ�
		tags=inputString;
		tagToken(tags);
	}
	
	public boolean tagExist(){	//��data�O�_��tag(�w����)
		if(tags=="")
			return false;
		else		
			return true;
	}
	public void removeData(){	// �N�⦹�ɮת�tag������,�D�{����data���ƶq-1�N�n
		tags="";
		tagCount=0;
		
	}
	
	private void tagToken(String tagString){
		StringTokenizer Tok=new StringTokenizer(tagString,",");	//�H","���Ϲj
		String buffer="";
		
		while (Tok.hasMoreElements()){
			buffer=(String) Tok.nextElement();
			if(searchTag(buffer)==0){
				tagList[++tagCount]=buffer;	//�`�N�}�C���ޭȬO�q1~tagCount,0�Ȥ��ϥ�
			}
		}
		
	}
	
	public int searchTag(String tag){
		int index=0;					//�Yreturn 0 �N���tag���s�b
		for(int i=1;i<=tagCount;i++){
			if(tag==tagList[i]){
				index=i;
				return index;
			}
		}
		
		return index;
	}


}
