package ������;

import ĳ����.���ΰ�;
//�׽�Ʈ�� Ŭ����
public class �Ƿ� extends ��������{
	//���� �������ۿ� ���� ������ ������ �ɷ�ġ ���ϴ� �κ� �ʿ��ϴ�.
	public �Ƿ�(String �������̸�, int ���ݷ�����, int ��������, int ����, int ü������) {
		super(�������̸�, ���ݷ�����, ��������, ����, ü������);
		
	}

	public void ����������() {
		
		this.���ݷ����� = 0;
		this.�������� = 2;
		this.���� = 3000;

		System.out.println("�̸� : ������");
		System.out.println("���� : �������� ��¡�ϴ� ���� �м��� �ϼ��� ���� �ʼ� ��ǰ.");
		System.out.print("���ݷ�����:"+���ݷ�����);
		System.out.print(" ��������:"+��������);
		System.out.print(" ����:"+����);
	}
	
	public void ȭ��Ʈ��������() {
		
		this.���ݷ����� = 0;
		this.�������� = 4;
		this.���� = 5000;

		System.out.println("�̸� : ȭ��Ʈ����");
		System.out.println("���� : ȭ��ƮĮ���� ù�λ��� �����ϴ� �κ�. ���� Ÿ�� ���ŷڸ� �Ҵ´�.");
		System.out.print("���ݷ�����:"+���ݷ�����);
		System.out.print(" ��������:"+��������);
		System.out.print(" ����:"+����);
	}
	
	
	public void ��������() {
		
		this.���ݷ����� = 0;
		this.�������� = 10;
		this.���� = 10000;

		System.out.println("�̸� : ����");
		System.out.println("���� : �������� ���ε��� ���� ��ŭ �߿��� ���.");
		System.out.print("���ݷ�����:"+���ݷ�����);
		System.out.print(" ��������:"+��������);
		System.out.print(" ����:"+����);
	}
	
	
	public void Ʈ��ġ��Ʈ����() {
		
		this.���ݷ����� = 0;
		this.�������� = 20;
		this.���� = 50000;

		System.out.println("�̸� : Ʈ��ġ��Ʈ");
		System.out.println("���� : �����м��� �ϼ�.�㸮�� ���� ���� ����ǳ ��Ÿ���� �α⸦ ���� �ִ�.");
		System.out.print("���ݷ�����:"+���ݷ�����);
		System.out.print(" ��������:"+��������);
		System.out.print(" ����:"+����);
	}
	

}
