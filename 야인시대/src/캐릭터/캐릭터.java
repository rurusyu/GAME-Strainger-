package ĳ����;
//�׽�Ʈ�� ĳ���� Ŭ����
import java.util.Scanner;

public class ĳ���� {
	public static Scanner scan = new Scanner(System.in);
	String �̸�;
	int ���ݷ�, ü��, ������, ����;
	
	
	//����â ȣ��ɶ� �̰� ȣ��.
	public void ĳ���ͻ���â() {
	
		
		this.�̸� = �̸�;
		this.���ݷ� = ���ݷ�;
		this.���� = ����;
		if(this.ü�� >0) {
			this.ü�� = ü��;

		}else {
			this.ü�� = 0;
		}
		this.������ = 20000;

		System.out.println("��===================��");
		System.out.println("     ��   �� :"+�̸�    );
		System.out.println("     ü   �� :"+ü��    );
		System.out.println("     ���ݷ� :"+���ݷ�   );
		System.out.println("     ���� :"+����);
		System.out.println("     ������ :"+������+"��");
		System.out.println("��===================��");
		
	}
	
	
	public ĳ����(String �̸�, int ���ݷ�, int ü��, int ������, int ����) {
		super();
		this.�̸� = �̸�;
		this.���ݷ� = ���ݷ�;
		this.ü�� = ü��;
		this.������ = ������;
		this.���� = ����;
	}

	
	public int �����ϴ�(int ������) {
	
		return ������;
	}
	

	public ĳ����(int ü��) {
		super();
		this.ü�� = ü��;	
	}
	
	
	public String get�̸�() {
		return �̸�;
	}

	public void set�̸�(String �̸�) {
		this.�̸� = �̸�;
	}

	public int get���ݷ�() {
		return ���ݷ�;
	}

	public void set���ݷ�(int ���ݷ�) {
		this.���ݷ� = ���ݷ�;
	}

	public int getü��() {
		return ü��;
	}

	public void setü��(int ü��) {
		this.ü�� = ü��;
	}

	public int get������() {
		return ������;
	}

	public void set������(int ������) {
		this.������ = ������;
	}

	public int get����() {
		return ����;
	}

	public void set����(int ����) {
		this.���� = ����;
	}
	
	

	
	
}
