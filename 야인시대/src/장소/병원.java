package ���;

import ���νô�.Music;
import ĳ����.���ΰ�;
//�׽�Ʈ�� Ŭ����
public class ���� extends ��� {
	//ĳ���� ȸ���� ����ϴ� �κ�.
	public ����(String ��Ҹ�) {
		super(��Ҹ�);
		
	}
	
	public void �����̿뼳��() {
		System.out.println("============================");
		System.out.println(" ȸ���� 1ȸ 300���̸�, Ǯ�� ä���ش�. ");
		System.out.println("============================");
		
	}
	
	public void �޴�_ȸ��(���ΰ� ���ΰ�) {
		Music ��������� = new Music("HOSPITAL1.mp3", true);
		
		���������.start();
		System.out.println("[�ǻ�] ���� �Ϸ� ���̽��ϱ�?");
		System.out.println("=====================");
		System.out.println(" 1: ȸ���Ѵ�.| 2: ������. ");
		System.out.println("=====================");
		String ȸ���޴� = scan.nextLine();
		
	while(!ȸ���޴�.equals("1")||!ȸ���޴�.equals("2")) {
		if(ȸ���޴�.equals("1")) {
			���������.close();
			
			���ΰ�.ȸ���ϴ�(���ΰ�);
			
		}else if(ȸ���޴�.equals("2")) {
			 System.out.println("[�ý���] ������ �������ϴ�.");
			 ���������.close();
		}else {
			System.out.println("[�ý���] �ùٸ� Ű�� �Է��Ͻʽÿ�.");
			ȸ���޴� = scan.nextLine();
			if(ȸ���޴�.equals("1")) {
				���ΰ�.ȸ���ϴ�(���ΰ�);
			}else if(ȸ���޴�.equals("2")) {
				 System.out.println("[�ý���] ������ �������ϴ�.");
			}else {
				
			}
		}	
		 break;// ����� �ݺ��� ��. ������ ȸ�������� �������� ���ѷ���.
		}//while end
	}
	

	
	
}
