package ĳ����;

import ���νô�.Music;

public class ������ extends ĳ����{

	//Ȯ������
	int Ȯ��;
	
	
	public ������(String �̸�, int ���ݷ�, int ü��, int ������, int ����) {
		super(�̸�, ���ݷ�, ü��, ������, ����);
		// TODO Auto-generated constructor stub
	}

	public void �����ڻ���â() {
		
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
	
	public void �������(���ΰ� ���ΰ�, ������ ������) {
	
		System.out.println("[�ý���] "+������.get�̸�()+"ü���� "+0+"�� �Ǿ� �׺��߽��ϴ�.");
		System.out.println("[�ý���] "+������.get�̸�()+"�� ��ῡ�� ���� ���������ϴ�.");
		System.out.println("[�ý���] ��"+������.get������()+"���� ������ϴ�.");
		���ΰ�.set������(���ΰ�.get������() + ������.get������());
	}
}
