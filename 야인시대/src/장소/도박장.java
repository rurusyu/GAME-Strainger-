package ���;

import java.util.Arrays;
import java.util.Scanner;

import ���νô�.Music;
import ĳ����.���ΰ�;

public class ������ extends ���{
	Scanner scan = new Scanner(System.in);
	public ������(String ��Ҹ�) {
		super(��Ҹ�);
		// TODO Auto-generated constructor stub
	}

	
	
	
	public void �����峻��(���ΰ� ���ΰ�) {
		//������ ������� �ֱ�.
		Music ���������� = new Music("CASINO.mp3", true);
		����������.start();
		//���������� ����ֱ�
		System.out.println("=====================================================[���Ӽ���]=====================================================");
		System.out.println("  [��ī��] ī�� 2���� ���� 9�� ��������� �¸��ϸ�, ��Ŀ�� �÷��̾�� ����. ��Ŀ�� �÷��̾� ī�� 2���� �հ谡 ������ Ÿ�̷�  8���� ������� ȹ���� �� �ִ�.");
		System.out.println("  [�ζ�] �ݾ��� �����ϰ� 1~45���� ���ϴ� ���� 6���� �̰�, �ǽð� ��÷�� ���� ��÷���� Ȯ���ϸ�, �ִ� 2���� ������� ȹ���� �� �ִ�.");
		System.out.println("  [�߹���] �ݾ��� �����ϰ�, 5���� �� �߿� �ϳ��� ����, �żӿ� ������ ������ ���� ��÷���� Ȯ���ϸ�, �ִ� 1���� ������� ȹ���� �� �ִ�.");
		System.out.println("=================================================================================================================");
		System.out.println("===========================================");
		System.out.println("  1:��ī�� | 2:�ζ� | 3.�߹���  | 4.������");
		System.out.println("===========================================");	
		int ���ڼ��� = scan.nextInt();  //�ֻ��� �޴����� ��ĳ�ʾ���, int ���� String���� ���������. �ȿ� ����ϴ� �޼ҵ� ��ĳ�ʵ鵵 �������, ������ ���ڱ� ƨ��� �� �Ȼ���.
	while(���ΰ�.get������() != 0) {
		if(���ڼ���==1) {
			��ī��(���ΰ�);
			�����峻��(���ΰ�); //���ڳ����� �� �޴��� ��ӿ��� �Ҷ� ����.
		}else if(���ڼ���==2) {
			�ζ�(���ΰ�);
			�����峻��(���ΰ�); //���ڳ����� �� �޴��� ��ӿ��� �Ҷ� ����.
			
		}else if(���ڼ���==3) {
			�߹���(���ΰ�);
			�����峻��(���ΰ�);
						
		}else if(���ڼ���==4) {
			����������.close();
			System.out.println("[�ý���] �������� �������ϴ�.");
			break;
		}else {
			
		}
		����������.close();
		break;
	}//while end
	
	}//������ ���� end
	
	public void ��ī��(���ΰ� ���ΰ�) {

		System.out.println("�ѤѤѤѤѤѤѤѤѤ�[��ݾȳ�]�ѤѤѤѤѤѤѤѤѤ�");
		System.out.println(" ��Ŀ���� �̱�� ���ñ��� 2��                                 ");
		System.out.println(" ��Ŀ�� Ÿ�̽� ���ñ��� 8��            ");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		
		System.out.println("[��Ŀ] �ǽð� �ζǸ� ��ܺ����~?");
		System.out.println("[��Ŀ] ���ñݾ��� �Է��ϼ���.");
		System.out.println("[������] "+ ���ΰ�.get������()+"��");
		System.out.print("[���ñݾ�] ");
		int �ݾ��Է� = scan.nextInt();
		
		System.out.println();
		int[] ��Ŀ= new int[2];
		int[] �÷��̾�= new int[2];

		
		for(int i=0; i<2; i++) {
			
		    	��Ŀ[i] = (int)(Math.random()*10);
				�÷��̾�[i] = (int)(Math.random()*10);
			
		}

		 int �÷��̾�ī���� = �÷��̾�[0]+�÷��̾�[1];
		 int ��Ŀī���� = ��Ŀ[0]+��Ŀ[1]; 
			if(��Ŀī���� >=10) {
				��Ŀī���� =��Ŀī���� % 10;
			}
			if(�÷��̾�ī����>=10) {
				�÷��̾�ī���� = �÷��̾�ī����%10;
			}
			
			System.out.println("��Ŀī�� �հ� : "+ ��Ŀī����);
			System.out.println("�÷��̾�ī�� �հ� : "+ �÷��̾�ī����);
			//ī�尪 ��.
			
			if(��Ŀī����==9) {
				System.out.println("[��Ŀ] ���� �¸��߳׿�. ���� �� �����ڽ��ϴ�.");
				���ΰ�.set������(���ΰ�.get������()-�ݾ��Է�);
				System.out.println("[������] "+���ΰ�.get������());
			}else if(�÷��̾�ī���� == 9) {
				System.out.println("[��Ŀ] �����մϴ�. ���ñݾ׿�  2�踦 �帮�ڽ��ϴ�. ");
				���ΰ�.set������(���ΰ�.get������()+�ݾ��Է�*2);
				System.out.println("[������] "+���ΰ�.get������());
			}else if(��Ŀī���� >= �÷��̾�ī����) {
				System.out.println("[��Ŀ] ���� �¸��߳׿�. ���� �� �����ڽ��ϴ�.");
				���ΰ�.set������(���ΰ�.get������()-�ݾ��Է�);
				System.out.println("[������] "+���ΰ�.get������());
			}else if(�÷��̾�ī����>��Ŀī����) {
				System.out.println("[��Ŀ] �����մϴ�. ���ñݾ׿�  2�踦 �帮�ڽ��ϴ�. ");
				���ΰ�.set������(���ΰ�.get������()+�ݾ��Է�*2);
				System.out.println("[������] "+���ΰ�.get������());
			}else if(�÷��̾�ī���� == ��Ŀī����) {
				System.out.println("[��Ŀ] ���ºα���. ���ñݾ׿�  8�踦 �帮�ڽ��ϴ�. ");
				���ΰ�.set������(���ΰ�.get������()+�ݾ��Է�*8);
				System.out.println("[������] "+���ΰ�.get������());
			}
			try {
				System.out.println("[��Ŀ] ī�带 �����ϰڽ��ϴ�.");
				Thread.sleep(1000);
				System.out.println("��ũī�� :"+Arrays.toString(��Ŀ));
				Thread.sleep(1000);
				System.out.println("�÷��̾�ī�� :"+Arrays.toString(�÷��̾�));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		
	}
	
	public void �ζ�(���ΰ� ���ΰ�) {
		
	
		System.out.println("�ѤѤѤѤѤѤѤѤѤ�[��ݾȳ�]�ѤѤѤѤѤѤѤѤѤ�");
		System.out.println(" 1~3�� ��ġ�� : ��                                            ");
		System.out.println(" 4�� ��ġ�� : ���ñݾ��� 50%             ");
		System.out.println(" 5�� ��ġ�� : ���ñݾ��� 100%             ");
		System.out.println(" 6�� ��ġ�� : ���ñݾ��� 200%            ");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		
		System.out.println("[�׺�] �ǽð� �ζǸ� ��ܺ����~?");
		System.out.println("[�׺�] ���ñݾ��� �Է��ϼ���.");
		System.out.println("[������] "+ ���ΰ�.get������()+"��");
		System.out.print("[���ñݾ�] ");
		int �ݾ��Է� = scan.nextInt();
		
		System.out.println("[�׺�] 1~45���� ���� �� 6���� ������.");
		int[] �����������ȣ  = new int[6];
		for(int i=0;i<6;i++) {
			System.out.println("[�׺�] 1~45���� ���� �� "+(i+1)+"��° ���ڸ� ������.");
			int �ζǼ������� = scan.nextInt();

			if(�ζǼ������� != �����������ȣ[i]) {
				�����������ȣ[i] = �ζǼ�������;
			}else if(�ζǼ������� == �����������ȣ[i]) {
				System.out.println("[�׺�] �̹� ���� ���Դϴ�. �ٽ� ��������.");
			}
		}
			Arrays.sort(�����������ȣ);
			System.out.println("[�����Ͻ� ��ȣ] "+Arrays.toString(�����������ȣ));
			
		int[] ����ȣ = new int[45];
		int[] ��� = new int[6];
		
		 for(int i=0, len = ����ȣ.length; i<len; i++){
			   
			 ����ȣ[i] = i+1; //�����
			  
			  }

		 //���̴±��
		 for(int i=0; i<6; i++) {
			 
			  int idx = (int)(Math.random()*45); 
			 			 
			 ���[i] = ����ȣ[idx]; //45�� �� 6�� ���� ��ȣ ���⿡ ����
			 
			 //�ߺ��� ��ȣ �̾��� �� ó��
			 if(����ȣ[idx] == -1) {
				 i--;
			 }
			 ����ȣ[idx] = -1;
			 
		 }
		 
		 System.out.println("����~ ���� ���� �̽��ϴ�.");
		  Arrays.sort(���);
		 
		  System.out.print("[��÷�� ����ȣ] ");
		  System.out.print(Arrays.toString(���));
		  System.out.println();
		  if(�����������ȣ[0] == ���[0] ) {
			  System.out.println("[�׺�] �ƽ��Ե� ���̳׿�. ���� ��ȸ�� �����ϼ���!");
			  ���ΰ�.set������(���ΰ�.get������()-�ݾ��Է�);
			  System.out.println("[������] "+���ΰ�.get������());
		  }else if(�����������ȣ[0] == ���[0] && �����������ȣ[1] == ���[1]) {
			  System.out.println("[�׺�] �ƽ��Ե� ���̳׿�. ���� ��ȸ�� �����ϼ���!");
			  ���ΰ�.set������(���ΰ�.get������()-�ݾ��Է�);
			  System.out.println("[������] "+���ΰ�.get������());
		 }else if(�����������ȣ[0] == ���[0] && �����������ȣ[1] == ���[1] && �����������ȣ[2] == ���[2]) {
			  System.out.println("[�׺�] �ƽ��Ե� ���̳׿�. ���� ��ȸ�� �����ϼ���!");
			  ���ΰ�.set������(���ΰ�.get������()-�ݾ��Է�);
			  System.out.println("[������] "+���ΰ�.get������());
		  }else if(�����������ȣ[0] == ���[0] && �����������ȣ[1] == ���[1] && �����������ȣ[2] == ���[2] && �����������ȣ[3] == ���[3] ) {
			  System.out.println("[�׺�] 4�� ��ġ�ϼ̳׿�!! ���ñݾ׿� 50% �帮�ڽ��ϴ�.");
			  System.out.println("[�ý���] "+�ݾ��Է�/2+"�� ��ŭ �������ϴ�.");
			  ���ΰ�.set������(���ΰ�.get������()+(�ݾ��Է�/2));
			  System.out.println("[������] "+���ΰ�.get������());
		  }else if(�����������ȣ[0] == ���[0] && �����������ȣ[1] == ���[1] && �����������ȣ[2] == ���[2] && �����������ȣ[3] == ���[3] && �����������ȣ[4] == ���[4] ) {
			  System.out.println("[�׺�] 5�� ��ġ�ϼ̳׿�!! ���ñݾ׿� 100% �帮�ڽ��ϴ�.");
			  System.out.println("[�ý���] "+�ݾ��Է�+"�� ��ŭ �������ϴ�.");
			  ���ΰ�.set������(���ΰ�.get������()+(�ݾ��Է�));
			  System.out.println("[������] "+���ΰ�.get������());
		  }else if(�����������ȣ[0] == ���[0] && �����������ȣ[1] == ���[1] && �����������ȣ[2] == ���[2] && �����������ȣ[3] == ���[3] && �����������ȣ[4] == ���[4] && �����������ȣ[5] == ���[5]) {
			  System.out.println("[�׺�] 6�� ��ġ�ϼ̳׿�!! ���ñݾ׿� 100% �帮�ڽ��ϴ�.");
			  System.out.println("[�ý���] "+�ݾ��Է�*2+"�� ��ŭ �������ϴ�.");
			  ���ΰ�.set������(���ΰ�.get������()+(�ݾ��Է�*2));
			  System.out.println("[������] "+���ΰ�.get������());
		  }else {
			  System.out.println("[�׺�] �ƽ��Ե� ���̳׿�. ������ȸ�� �����ϼ���.");
			  ���ΰ�.set������(���ΰ�.get������()-�ݾ��Է�);
			  System.out.println("[������] "+���ΰ�.get������());
		  }
	}//�ζ� end
	
	public void �߹���(���ΰ� ���ΰ�) {
		//��� ������
		
		System.out.println("�ѤѤѤѤѤѤѤѤѤ�[��ݾȳ�]�ѤѤѤѤѤѤѤѤѤ�");
		System.out.println(" ���߸� ���ñ��� 1��                                 ");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		int �߹��� = (int)(Math.random() *5)+1 ; //���� 1~5����.
		System.out.println("[�׺�] �߹����� ��ܺ����~?");
		System.out.println("[�׺�] 5�� ��  ���� ����ִ� �ſ� ���� �ɾ� ���߸� ���� �ݾ׸�ŭ�� �帳�ϴ�. Ʋ���� �� �ݾ� ��� �ҽ��ϴ�.");
		Thread �߹������� = new Thread(new Runnable() {
			
			@Override
			public void run() {
				 try {
					 
					 for(int i=0; i<5; i++) {
						 Thread.sleep(500);
						 System.out.print("��");
					 }
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				
			}
		});
		try {
			System.out.println("[�׺�] �߹����� ���� ���Դϴ�.");
			System.out.println("[�߹��� ��] ");
			�߹�������.start();
			�߹�������.join();
			System.out.println();
			System.out.println("[�ý���] �Ž� �ݾ��� �Է��ϼ���.");
			System.out.println("[������] "+���ΰ�.get������());
			System.out.print("[���ñݾ�] ");
			int �ݾ��Է� = scan.nextInt();
				
				if(�ݾ��Է�<=���ΰ�.get������()) {
					System.out.println("[�׺�] �� �� �ſ� �Žðڽ��ϱ�?");
					int �ż��� = scan.nextInt();
					if(�ż��� == �߹���) {
						System.out.println("[�׺�] ���� �̰屺��.. �����մϴ�.");
						���ΰ�.set������(���ΰ�.get������()+(�ݾ��Է�));
						System.out.println("[������] "+���ΰ�.get������());
						Thread.sleep(1000);
					}else if(�ż��� != �߹���) {
						System.out.println("[�׺�] ���� �̰���ϴ�. ������ ");
						System.out.println("[�ý���] "+�ݾ��Է�+ "�� ��ŭ �Ҿ����ϴ�");
						���ΰ�.set������(���ΰ�.get������()-�ݾ��Է�); 
						System.out.println("[������] "+���ΰ�.get������());
						Thread.sleep(1000);
						}
				}else if(�ݾ��Է� > ���ΰ�.get������()) {
					
					System.out.println("[�ý���] ������ �ִ� ������ ū �׼��� �Է��ϼ̽��ϴ�. �ٽ� �Է����ֽʽÿ�.");
			
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
			}//�߹��� end
	
}