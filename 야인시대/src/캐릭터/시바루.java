package ĳ����;

import java.util.Random;

import ���.��ȭ��;

public class �ùٷ� extends ������{

	
	public �ùٷ�(String �̸�, int ���ݷ�, int ü��, int ������, int ����) {
		super(�̸�, ���ݷ�, ü��, ������, ����);
		// TODO Auto-generated constructor stub
	}

	public void �ùٷ����â() {
		
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
	
	
	
	
	public void ��ų_����ġ��(���ΰ� ���ΰ�, ��ȭ�� ��ȭ��) {
		//��Ÿ��
		
		//40%Ȯ���� ��ų ���
		Random ran = new Random();
		Ȯ�� = ran.nextInt(10)+1;//1~10����
		if(Ȯ�� %5 == 0 || Ȯ�� %5 == 1) {
			
			System.out.println("[�ùٷ�] (��ų) ����ġ��!!");
			if(���ΰ�.getü��() > 0) {
				int ������ = (���ΰ�.get����()/2)-(get���ݷ�()+15); //������ ���
				���ΰ�.setü��(���ΰ�.getü��()+������);
				System.out.println("[�ý���] "+get�̸�()+"�� <����ġ��> ��ų�� ����Ͽ� "+������+"�� ���ظ� �������ϴ�.");
				System.out.println("[�ý���] "+���ΰ�.get�̸�()+ "ü���� "+���ΰ�.getü��()+"���ҽ��ϴ�.");	
				���ΰ�.���ΰ�����â();
				
				���ΰ�.���ΰ����(��ȭ��);
			}// if end
		}else {
			System.out.println("[�ùٷ�] ������ ���� ������ �ʴ� ��..");
		}
		
	} //��ų end
		
	public void �ùٷ���(���ΰ� ���ΰ�,�ùٷ� �ùٷ�) {
		System.out.println("[�ý���] "+�ùٷ�.get�̸�()+"ü���� "+0+"�� �Ǿ� �׺��߽��ϴ�.");
		System.out.println("[�ý���] "+�ùٷ�.get�̸�()+"�� �й踦 �����߽��ϴ�.");
		System.out.println("["+�ùٷ�.get�̸�()+"] ���� ���� �ݵ�� �̰��ָ�.");
		System.out.println("[�ý���] ��"+�ùٷ�.get������()+"���� ������ϴ�.");
		���ΰ�.set������(���ΰ�.get������() + �ùٷ�.get������());
	}
	
}
