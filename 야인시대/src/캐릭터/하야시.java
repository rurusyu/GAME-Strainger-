package ĳ����;

import java.util.Random;

import ���νô�.Music;
import ���.��ȭ��;

public class �Ͼ߽� extends ���̼Ҹ�{

	public �Ͼ߽�(String �̸�, int ���ݷ�, int ü��, int ������, int ����) {
		super(�̸�, ���ݷ�, ü��, ������, ����);
		// TODO Auto-generated constructor stub
	}
	
	public void �Ͼ߽û���â() {
			
			this.�̸� = �̸�;
			this.���ݷ� = ���ݷ�;
			this.���� = ����;
				if(this.ü�� >0) {
					this.ü�� = ü��;
	
				}else {
					this.ü�� = 0;
				}
			this.������ = ������;
			System.out.println("��===================��");
			System.out.println("     ��   �� :"+�̸�);
			System.out.println("     ü   �� :"+ü��);
			System.out.println("     ���ݷ� :"+���ݷ�);
			System.out.println("     ���� :"+����);
			System.out.println("��===================��");
			//	System.out.println("     ������ :"+������);
		}
	
	public void ��ų_�׸��ں���(���ΰ� ���ΰ�, ��ȭ�� ��ȭ��) {
		//��Ÿ��
		
		//20%Ȯ���� ��ų ���
		Random ran = new Random();
		Ȯ�� = ran.nextInt(10)+1;//1~10����
		if(Ȯ�� %5 == 1 || Ȯ�� %5 == 2) {
			
			System.out.println("[�Ͼ߽�] (��ų) �׸��ں���!!");
			if(���ΰ�.getü��() > 0) {
				int ������ = (���ΰ�.get����()/2)-(get���ݷ�()+25); //������ ���
				���ΰ�.setü��(���ΰ�.getü��()+������);
				System.out.println("[�ý���] "+get�̸�()+"�� <�׸��ں���> ��ų�� ����Ͽ� "+������+"�� ���ظ� �������ϴ�.");
				System.out.println("[�ý���] "+���ΰ�.get�̸�()+ "ü���� "+���ΰ�.getü��()+"���ҽ��ϴ�.");	
				
				
				���ΰ�.���ΰ����(��ȭ��);
			}// if end
		}else {
			System.out.println("[�Ͼ߽�] �̰� ���ϴٴ�..");
		}
	
	}
	
	
	public void ��ų_�������(���ΰ� ���ΰ�, ��ȭ�� ��ȭ��) {
		//��Ÿ��
		
		//10%Ȯ���� ��ų ���
		Random ran = new Random();
		Ȯ�� = ran.nextInt(10)+1;//1~10����
		if(Ȯ�� %5 == 4) {
			
			System.out.println("[�Ͼ߽�] (����) �������!!");
			if(���ΰ�.getü��() > 0) {
				int ������ = (���ΰ�.get����()/2)-(get���ݷ�()+50); //������ ���
				���ΰ�.setü��(���ΰ�.getü��()+������);
				System.out.println("[�ý���] "+get�̸�()+"�� <�������> ��ų�� ����Ͽ� "+������+"�� ���ظ� �������ϴ�.");
				System.out.println("[�ý���] "+���ΰ�.get�̸�()+ "ü���� "+���ΰ�.getü��()+"���ҽ��ϴ�.");	
				
				
				���ΰ�.���ΰ����(��ȭ��);
			}// if end
		}else {
			System.out.println("[�Ͼ߽�] �������� ������..");
		}
	}
	
	
	public void �Ͼ߽�_�����_������(���ΰ� ���ΰ�) {
		���ΰ�.set���ݷ�(get���ݷ�()/4);
	}
	
	public void �Ͼ߽û��(���ΰ� ���ΰ�,�Ͼ߽� �Ͼ߽�) {
		
		System.out.println("[�ý���] "+�Ͼ߽�.get�̸�()+"ü���� "+0+"�� �Ǿ� �׺��߽��ϴ�.");
		System.out.println("[�ý���] "+�Ͼ߽�.get�̸�()+"�� ��ῡ�� �����ϴ�.");
		Thread �Ͼ߽û����� = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					String ������ = "���� ������ ��� ���� �ְ� �����ڳ�..";
					for(int i=0; i<������.length(); i++) {
						Thread.sleep(100);
						System.out.print(������.charAt(i));
					}
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				
			}
		});
		try {
			Music ������ = new Music("ENDINGOST.mp3",false);
			System.out.print("["+�Ͼ߽�.get�̸�()+"] ");
			�Ͼ߽û�����.start();
			�Ͼ߽û�����.join();
			������.start();
			 System.out.println();
			 Thread.sleep(500);
			 System.out.println();
			 Thread.sleep(500);
			 System.out.println("     �ƢƢƢƢƢƢ�         �ƢƢƢ�       �ƢƢƢ�      �ƢƢƢ�    �ƢƢƢƢƢƢƢƢƢ�     �ƢƢƢƢƢƢƢ�    �Ƣ�            �ƢƢƢƢƢƢƢƢƢ�       �ƢƢƢ�       �ƢƢƢƢƢƢƢƢƢ�      �ƢƢƢ� ");
			 Thread.sleep(500);
			 System.out.println("   �Ƣ�       �Ƣ�      �Ƣ�  �Ƣ�      �Ƣ� �Ƣ�    �Ƣ� �Ƣ�    �Ƣ�            �Ƣ�           �Ƣ�            �Ƣ�              �Ƣ�  �Ƣ�      �Ƣ�        �Ƣ�    �ƢƢƢ�           ");
			 Thread.sleep(500);
			 System.out.println("   �Ƣ�       �Ƣ�     �Ƣ�    �Ƣ�     �Ƣ�  �Ƣ�  �Ƣ�  �Ƣ�    �Ƣ�            �Ƣ�           �Ƣ�            �Ƣ�             �Ƣ�    �Ƣ�     �Ƣ�        �Ƣ�    �ƢƢƢ�        ");
			 Thread.sleep(500);
			 System.out.println("   �Ƣ�       �Ƣ�    �Ƣ�      �Ƣ�    �Ƣ�   �ƢƢƢ�   �Ƣ�    �Ƣ�            �Ƣ�           �Ƣ�            �Ƣ�            �Ƣ�      �Ƣ�    �Ƣ�        �Ƣ�    �ƢƢƢ�    ");
			 Thread.sleep(500);
			 System.out.println("   �Ƣ�             �ƢƢƢƢƢƢƢƢƢ�    �Ƣ�    �Ƣ�    �Ƣ�    �ƢƢƢƢƢƢƢƢƢ�    �Ƣ�           �Ƣ�            �ƢƢƢƢƢƢƢƢƢ�    �ƢƢƢƢƢƢƢƢƢ�    �ƢƢƢƢƢƢƢƢƢ�      �ƢƢƢ�             ");
			 Thread.sleep(500);
			 System.out.println("   �Ƣ�     �ƢƢƢ�    �Ƣ�      �Ƣ�    �Ƣ�    �Ƣ�    �Ƣ�    �Ƣ�            �Ƣ�           �Ƣ�            �Ƣ�            �Ƣ�      �Ƣ�    �Ƣ�        �Ƣ�    �ƢƢƢ�       ");
			 Thread.sleep(500);
			 System.out.println("   �Ƣ�       �Ƣ�    �Ƣ�      �Ƣ�    �Ƣ�          �Ƣ�    �Ƣ�            �Ƣ�           �Ƣ�            �Ƣ�            �Ƣ�      �Ƣ�    �Ƣ�        �Ƣ�        ");
			 Thread.sleep(500);
			 System.out.println("   �Ƣ�       �Ƣ�    �Ƣ�      �Ƣ�    �Ƣ�          �Ƣ�    �Ƣ�            �Ƣ�           �Ƣ�            �Ƣ�            �Ƣ�      �Ƣ�    �Ƣ�        �Ƣ�    �ƢƢƢ�   ");
			 Thread.sleep(500);
			 System.out.println("     �ƢƢƢƢƢƢ�      �Ƣ�      �Ƣ�    �Ƣ�          �Ƣ�    �ƢƢƢƢƢƢƢƢƢ�     �ƢƢƢƢƢƢƢ�    �ƢƢƢƢƢƢƢƢƢ�    �ƢƢƢƢƢƢƢƢƢ�    �Ƣ�      �Ƣ�    �Ƣ�        �Ƣ�    �ƢƢƢ�");
			 ������.join();
			
			System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
