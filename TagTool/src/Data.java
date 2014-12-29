import java.util.StringTokenizer;
//�ƧѡGchangeTag�����tag������
//��searchTag==0�h��
//changeTag�ݭn�P�_�s�¦r�꦳�X��tag

public class Data {
	public String directory;	//�]�t���|���ɦW
	private String dataName;	//�ɦW
	public String tags;			//�@�Ӧr��,�H","�������r�����ΥX�U��tag
	public String tagList[];	//�s���Ϋ᪺tag
	private int tagCount=0;		//��data���X��tag
	
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
	
	public String getDataName(){
		return dataName;
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
	
	public int searchTag(String btag){
		int index=0;					//�Yreturn 0 �N���tag���s�b
		for(int i=1;i<=tagCount;i++){
			if(btag==tagList[i]){
				index=i;
				return index;		//���tag�N�^�ǩҦbindex
			}
		}
		
		return index;	//�_�h�^��0
	}
	
	public void sort(){		//����Ϋ᪺tag���Ƨ�
		for(int i=1;i<=tagCount;i++){
			String temp=tagList[i];
			int j;
			for(j=i-1;j>=0 && tagList[j].compareTo(temp)>0;j--)
				tagList[j+1]=tagList[j];
			tagList[j+1]=temp;
		}
	}
	
	public void bind(){		//��Ƨǫ᪺tag��^�r��,�Ψ���ܦbUI�W
		tags="";
		for(int i=1;i<tagCount;i++){
			tags+=tagList[i]+",";
		}
		tags+=tagList[tagCount];
	}
	

}
