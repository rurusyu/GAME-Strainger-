package ĳ����;

import java.util.Random;

import ���.��ȭ��;

public class ���̼Ҹ� extends ������{

	public ���̼Ҹ�(String �̸�, int ���ݷ�, int ü��, int ������, int ����) {
		super(�̸�, ���ݷ�, ü��, ������, ����);
		// TODO Auto-generated constructor stub
	}

	public void ���̼Ҹ�����â() {
			
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
	
	public void ��ų_�ι�����(���ΰ� ���ΰ�, ��ȭ�� ��ȭ��) {
		//��Ÿ��
		
		//30%Ȯ���� ��ų ���
		Random ran = new Random();
		Ȯ�� = ran.nextInt(10)+1;//1~10����
		if(Ȯ�� %3 == 1) {
			
			System.out.println("[���̼Ҹ�] (��ų) �ι�����!!");
			if(���ΰ�.getü��() > 0) {
				int ������ = (���ΰ�.get����()/2)-(get���ݷ�()+20); //������ ���
				���ΰ�.setü��(���ΰ�.getü��()+������);
				System.out.println("[�ý���] "+get�̸�()+"�� <�ι�����> ��ų�� ����Ͽ� "+������+"�� ���ظ� �������ϴ�.");
				System.out.println("[�ý���] "+���ΰ�.get�̸�()+ "ü���� "+���ΰ�.getü��()+"���ҽ��ϴ�.");	
				
				
				���ΰ�.���ΰ����(��ȭ��);
			}// if end
		}else {
			System.out.println("[���̼Ҹ�] �����߱�..");
		}
		
	} //��ų end
	public void ���̼Ҹ����(���ΰ� ���ΰ�,���̼Ҹ� ���̼Ҹ�) {
		System.out.println("[�ý���] "+���̼Ҹ�.get�̸�()+"ü���� "+0+"�� �Ǿ� �׺��߽��ϴ�.");
		System.out.println("[�ý���] "+���̼Ҹ�.get�̸�()+"�� �й踦 �����߽��ϴ�.");
		System.out.println("[�ý���] ��"+���̼Ҹ�.get������()+"���� ������ϴ�.");
		���ΰ�.set������(���ΰ�.get������() + ���̼Ҹ�.get������());
	}
	
}
