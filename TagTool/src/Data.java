
public class Data {
	public String directory;	//�]�t���|���ɦW
	public String tags;			//�@�Ӧr��,�H","�������r�����ΥX�U��tag (��strtok������?)
	
	
	public boolean dataAvailable(){	//�ɮ׬O�_�s�b�ɮרt��
		
		return true;
	}
	
	public void changeTag(String inputString){	//��UI�ե�,change tag���s���U�h�ɭ�
		tags=inputString;
	}
	
	public boolean tagExist(){	//��data�O�_��tag,�w����
		if(tags=="")
			return false;
		else		
			return true;
	}
	public void removeData(){	// �N�⦹�ɮת�tag������,data���ƶq-1�N�n
		
	}
	
	


}
