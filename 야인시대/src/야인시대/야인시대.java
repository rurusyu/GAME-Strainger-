package ���νô�;

import java.util.Calendar;
import java.util.Scanner;

import ������.�����;
import ������.�Ƿ�;
import ������.�̻��ѹ���;
import ������.�尩;
import ���.������;
import ���.����;
import ���.��̰�;
import ���.��ȭ��;
import ���.ü����;
import ĳ����.���̼Ҹ�;
import ĳ����.�ùٷ�;
import ĳ����.���ΰ�;
import ĳ����.�Ͼ߽�;
import ĳ����.������;
//���νô� : ���������� ���⼭ Ȱ���ϴ� ������.
//�׽�Ʈ�� Ŭ����
public class ���νô� {
	
	public static Scanner scan = new Scanner(System.in);
	public static boolean �� = true; //���� false
	
	
	public static void ���Ӽ���() {
		System.out.println("===============================================[���Ӽ���]=======================================================");
		System.out.println(" [����Ŭ��������] �Ͼ߽ø� �����߸��� ������ �����ϰ� �˴ϴ�.");
		System.out.println(" [�÷��̹��] �� ������ ���� �����߸���, ������� �������� �����Ͽ� ���������� �����߷����մϴ�.");
		System.out.println(" [��� ��] �㿡�� ������ ���ݷ�, ������ 20% ����ϰ�, �����忡 ������ �� �� �ֽ��ϴ�. ������ ������ ���ݷ�,������ �����·� ���ƿɴϴ�. ��� ���� �ð��� ���� 5�� �Դϴ�.");
		System.out.println(" [����â] ĳ������ ������ �� �� �ֽ��ϴ�.");
		System.out.println(" [��̰�] ����� ������ �ϴ� ���̸�, ������ �̱��, ���� ����ϴ�. ��̰����� �ְ����� �Ͼ߽ð� ���ΰ� �ɷ�ġ�� �������� �����ϸ� �����մϴ�.");
		System.out.println(" [��ȭ��] ���� �������� ������ �� ������, ���ΰ��� ���ݾ�����, ��������, ü�¾�����, Ư�������� ���� 1�������� ���� �����մϴ�. �㿡�� ������ ���մϴ�.");
		System.out.println(" [����] ĳ���� ü���� ȸ���ϴ� ���̸�, �㿡�� ������ ���� �ʽ��ϴ�.");
		System.out.println(" [ü����] ĳ������ �ɷ�ġ�� �ø��� �����Դϴ�. �㿡�� ������ ���� �ʽ��ϴ�. ");
		System.out.println(" [������] ������ ������ ���� ������, �㿡�� �����ϴ� �����ν� ���� �� �� �ֽ��ϴ�.");
		System.out.println(" [���ӿ���] ���ΰ��� ������� ��� ������ ����˴ϴ�.");
		System.out.println(" [�˴ٿ�] ��ð� �÷��̸� �����ϱ� ���� �����÷��� 2�ð� ������ �˶��� ������, 10�ð� ����Ŀ��� �ڵ����� ������ ����˴ϴ�.");
		System.out.println("==============================================================================================================");
	}
	
	
	public static void �޴�â() {
		System.out.println("============================================================");
		System.out.println("  1:����â |2:��̰� |3:��ȭ�� |4:����  |5.ü���� | 6.������ | 7.��������");
		System.out.println("============================================================");
	}
	
	public static void ����ð��˸�â() {
		Calendar �޷�= Calendar.getInstance();
		int year = �޷�.get(Calendar.YEAR);
        int mon = �޷�.get(Calendar.MONTH);
        int day = �޷�.get(Calendar.DAY_OF_MONTH);
        int hour = �޷�.get(Calendar.HOUR_OF_DAY);
        int min = �޷�.get(Calendar.MINUTE);
        int sec = �޷�.get(Calendar.SECOND);

       
        System.out.print("[����ð�] ");
        System.out.print(year + "�� "+ mon+"�� "+day+"�� ");
        System.out.println(hour + "�� "+ min+"�� "+sec+"��");   
	}
	
	public static void main(String[] args) {
		�ð���� �ð� = new �ð����();
		Thread �ð���� = new Thread(�ð�);
		Music ���Ժ����� = new Music("SHORT_OST.mp3", true); //Ȯ���ڸ� �������� �ȵ�.
		Music Ű����Ҹ� = new Music("KEYSOUND1.mp3", true);
		Music ������� = new Music("MAINOST2.mp3", true);
		Music ��ȭ������� = new Music("GTA.mp3", true);
		
		
		���Ժ�����.start();
		
			//������ �������	
		 Thread ���� = new Thread(
				 new Runnable() { //1ȸ���̶� �̷��� ���.
					
					@Override
					public void run() {
						try {
							 System.out.println(); //����ũ�� �ֱ�. ���񾲷��� ó��! �ε��ϸ鼭 ���ǳ�����!
							 Thread.sleep(500);
							 System.out.println();
							 Thread.sleep(500);
							 System.out.println("     �ƢƢ�      �Ƣ�       �ƢƢ�      �Ƣ�         �Ƣ�       �Ƣ�    �ƢƢƢƢƢ�  �Ƣ�   �Ƣ�                          ");
							 Thread.sleep(500);
							 System.out.println("   �Ƣ�   �Ƣ�    �Ƣ�     �Ƣ�   �Ƣ�    �Ƣ�       �Ƣ�  �Ƣ�     �Ƣ�    �Ƣ�      �Ƣ�   �Ƣ�        �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�   ");
							 Thread.sleep(500);
							 System.out.println("   �Ƣ�   �Ƣ�    �ƢƢƢ�   �Ƣ�   �Ƣ�    �Ƣ�      �Ƣ�    �Ƣ�    �Ƣ�    �Ƣ�      �Ƣ�   �Ƣ�       �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ� ");
							 Thread.sleep(500);
							 System.out.println("   �Ƣ�   �Ƣ�    �Ƣ�     �Ƣ�   �Ƣ�    �Ƣ�      �Ƣ�    �Ƣ�    �Ƣ�    �Ƣ�      �Ƣ�   �Ƣ�     �ƢƢƢƢƢ�|�ƢƢƢ�|�ƢƢƢ�|�ƢƢ� ");
							 Thread.sleep(500);
							 System.out.println("   �Ƣ�   �Ƣ�    �Ƣ�       �ƢƢ�      �Ƣ�      �Ƣ�    �Ƣ�    �Ƣ�    �Ƣ�      �ƢƢƢƢƢƢ�    �Ƣ�|�ƢƢƢ�|�ƢƢƢ�|�ƢƢƢ�|�ƢƢ� ");
							 Thread.sleep(500);
							 System.out.println("   �Ƣ�   �Ƣ�    �ƢƢƢ�                      �Ƣ�    �Ƣ�    �Ƣ�    �Ƣ�      �Ƣ�   �Ƣ�   �ƢƢ�|�ƢƢƢ�|�ƢƢƢ�|�ƢƢƢ�|�ƢƢ� ");
							 Thread.sleep(500);
							 System.out.println("   �Ƣ�   �Ƣ�    �Ƣ�          �Ƣ�            �Ƣ�    �Ƣ�    �Ƣ�    �Ƣ�      �Ƣ�   �Ƣ�   �ƢƢ�|�ƢƢƢ�|�ƢƢƢ�|�ƢƢƢ�|�Ƣ�  ");
							 Thread.sleep(500);
							 System.out.println("     �ƢƢ�      �Ƣ�          �ƢƢƢƢƢƢƢƢƢ�    �Ƣ�    �Ƣ�    �Ƣ�    �ƢƢƢƢƢ�  �Ƣ�   �Ƣ�    �ƢƢƢƢƢ�                ");
							 Thread.sleep(500);
							 System.out.println("                                                                                                   ");
						} catch (InterruptedException e) {
							
						}
						
					}
				}
				 );
		 ����.start();//���񾲷��� ����
		 
		//�����Ҷ� �̸� ȯ�����
		������ ���� = new ������("������",15,200,(int)(Math.random()*1000),10);
		�Ͼ߽� ���������� = new �Ͼ߽�("�Ͼ߽�",50,500,300000,40);//���ݷ�, ü��, ������, ���� ��
		���̼Ҹ� ����2���� = new ���̼Ҹ�("���̼Ҹ�",40,400,100000,30);
		�ùٷ� ����1���� = new �ùٷ�("�ùٷ�",30,200,100000,20);
		��ȭ�� ���� = new ��ȭ��("��ȭ��");
		��̰� ������= new ��̰�("��̰�");
		�尩 ���� = new �尩("���尩",3,0,5000,0);
		�Ƿ� �� = new �Ƿ�("������",0,2,5000,0);
		����� ����� = new �����("�����",0,2,3000,10);
		�̻��ѹ��� �̻��ѹ��� = new �̻��ѹ���("�蹫���Ǻ�Ʈ",20,0,20000,0);
		���� ���� = new ����("����");
		ü���� ü���� = new ü����("ü����");
		������ ������ = new ������("������");
		Thread �㳷 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					while(true) {
						
							
							����������.set���ݷ�(50); //������ ���ݷ� ����
							����������.set����(40); 
							����1����.set���ݷ�(30);
							����1����.set����(20);
							����2����.set���ݷ�(40);
							����2����.set����(30);
							����.set���ݷ�(15);
							����.set����(10);
							//Thread.sleep(300000); //5�� (300��, 1�ʿ� 1000)
							for(int i=5;i>=1;i--) {
								System.out.println("[�ý���] ����� "+i+"�� ���ҽ��ϴ�.");
								Thread.sleep(20000); //60000 �̸� 1��
								if(i==1) {
									�� = false;
									
								}
							}
				
							System.out.println("[�ý���] ���� �Ǿ����ϴ�. �������� ���Ƚ��ϴ�. ������ ���ݷ�, ������ 20% ����Ͽ����ϴ�.");
							����������.set���ݷ�(60);
							����������.set����(48);
							����1����.set���ݷ�(36);
							����1����.set����(24);
							����2����.set���ݷ�(48);
							����2����.set����(36);
							����.set���ݷ�(17);
							����.set����(14);
							
							for(int i=5;i>=1;i--) {
								System.out.println("[�ý���] ������ "+i+"�� ���ҽ��ϴ�.");
								Thread.sleep(60000);
								if(i==1) {
								�� = true;
								System.out.println("[�ý���] ���� �Ǿ����ϴ�. ������ ���ݷ�, ������ ������� ���ƿԽ��ϴ�.");
								}
							}
						
					
					}//while end
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				
			}
		});

		//ĳ������ �κ�	
		try {	
			����.join(); //�� ������ ������ ����.
		}catch (InterruptedException e) {
			// TODO: handle exception
		}
			
		���Ӽ���();
		System.out.println("[�ý���] ĳ���� �̸��� ���ϼ���.");
		String name = scan.nextLine();
		���Ժ�����.close();
		System.out.println();
		
		���ΰ� �ൿ = new ���ΰ�(name,20,100,1000000,39);//���ݷ�, ü��, ������, ���� ��
		System.out.println("[�ý���] ĳ���Ͱ� �����Ǿ����ϴ�.");
		�ð����.start();
		System.out.println();
		System.out.print("["+�ൿ.get�̸�()+"]");
		Thread ���ΰ���� = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					String ĳ��������_��� = "�� �̸��� "+�ൿ.get�̸�()+". ���θ� �����Ϸ� ������?!";
					for(int i=0; i<ĳ��������_���.length(); i++) {
						Thread.sleep(100);
						System.out.print(ĳ��������_���.charAt(i)); //ĳ���� �迭�� ��Ƽ� ���
						
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		try {
			
			Ű����Ҹ�.start();  //��� ȿ����
			Thread.sleep(1000);
			���ΰ����.start();
			���ΰ����.join();
			Ű����Ҹ�.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		�������.start();
		System.out.println();
		�ൿ.���ΰ�����â();
		����ð��˸�â();
		try {
			�㳷.start();
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}

		��ȭ�������.start(); //while �ȿ� ������   IllegalThreadStateException �߻���. (start�� �ι� ����Ǽ� ����� ������). //����ȭ�� �ذ��ؾ���.
		��ȭ�������.suspend(); //���۰� ���ÿ� �Ͻ�����. ��ȭ�� ���� �ȿ��� �׳� Ʈ�¼��ۿ� ����..
		
			�޴�â();
			String �����Է� = scan.nextLine();
			// ���丮 ����
			while(!�����Է�.equals("1")||!�����Է�.equals("2")||!�����Է�.equals("3")||!�����Է�.equals("4")||!�����Է�.equals("5")||!�����Է�.equals("6")||!�����Է�.equals("7")||!�����Է�.equals("+")) {
				if(�����Է�.equals("1")) {
					�ൿ.���ΰ�����â();
					�����Է� = "+";
					
				}else if(�����Է�.equals("2")) {
					//��̰� �޼ҵ�.
					�������.suspend();
					������.��̰���_����(); //��̰� ����� ���ϱ�.
					�ൿ.�����ڰ������ϴ�(������, �ൿ, ����, ����������, ����2����, ����1����, ����);
					
					�����Է� = "+";
					
				}else if(�����Է�.equals("3")) {
					//��ȭ��	
					if(��==true) {
						�������.suspend();
						��ȭ�������.resume();
						����.�޴�_����������(�ൿ,����, ��,�����,�̻��ѹ���);
						��ȭ�������.suspend();
						�����Է� = "+";						
					}else if(��==false) {
						System.out.println("["+�ൿ.get�̸�()+"] ���̶� ������ �����ߴٺ���. ���� ����ִ�.");
						�����Է� = "+";
					}
				}else if(�����Է�.equals("4")) {
					if(��==true) {
						�������.suspend();
						����.�޴�_ȸ��(�ൿ);
						�����Է� = "+";				
					}else if(��==false) {
						System.out.println("["+�ൿ.get�̸�()+"] ���̶� ������ �����ߴٺ���. ���� ����ִ�.");
						�����Է� = "+";
					}
				}else if(�����Է�.equals("5")) {
					if(��==true) {
						�������.suspend();
						//ü����
						ü����.ü��������(�ൿ);
						�����Է� = "+";
					}else if(��==false) {
						System.out.println("["+�ൿ.get�̸�()+"] ���̶� ������ �����ߴٺ���. ���� ����ִ�.");
						�����Է� = "+";
					}
					
				}else if(�����Է�.equals("6")) {
					�������.suspend();
					//������
					if(��==true) {
						System.out.println("[������] ������ ���� ���մϴ�.");
						�����Է� = "+";
					}else if(�� == false) {
						������.�����峻��(�ൿ);
						�����Է� = "+";
					}
					
				}else if(�����Է�.equals("7")) {
					//��������
					�������.close();
					�ð����.interrupt();
					System.out.println("[�ý���] ������ �����Ͽ����ϴ�.");
					break;
				}else if(�����Է�.equals("+")) {
					�������.resume();
					�޴�â();
					�����Է� = scan.nextLine(); //���⼭ �Է½� �ٽ� �޴��� �����ְ��ؾ� ���� �� ����. �׷��� �̰ž�.
				}else {
						System.out.println("[�ý���] �ùٸ�Ű�� �Է��Ͻʽÿ�"); //�Է°� �߸� ������� ����ó��
						�޴�â();
						�����Է� =scan.nextLine();
				    		if(�����Է�.equals("1")) {
				    			�����Է� = "1";
				    			
							}else if(�����Է�.equals("2")) {
								�����Է� = "2";
								
							}else if(�����Է�.equals("3")){
								�����Է� = "3";
							}else if(�����Է�.equals("4")){
								�����Է� = "4";	
							}else if(�����Է�.equals("5")){
									�����Է� = "5";	
							}else if(�����Է�.equals("6")){
								�����Է� = "6";
							}else if(�����Է�.equals("7")){
								�����Է� = "7";	
							}else {
								
							}
			
				
			}//while end
				
		
	}

	}	//main end
}