package ���;


import ���νô�.Music;
import ĳ����.���̼Ҹ�;
import ĳ����.�ùٷ�;
import ĳ����.���ΰ�;
import ĳ����.�Ͼ߽�;
import ĳ����.������;
//�׽�Ʈ�� Ŭ����
public class ��̰� extends ��� {
//��̰��� �������� ���ΰ��� ����, ������ ������ �Ͼ�� �ϴ� �κ���. 
	Music ��̰����� = new Music("UMIGWAN.mp3",true);
	
	public ��̰�(String ��Ҹ�) {
		super(��Ҹ�);
		
	}

	public void ��̰���_����() {
		Music ���ȿ���� = new Music("KEYSOUND1.mp3", true);  //Ȯ���� �� �ֱ�!!!!!
		
		System.out.println("[�ý���] ��̰��� ���Դ�.");
		System.out.println();
		System.out.print("[�Ͼ߽ýɺ�] ");
		Thread �ɺ���� = new Thread(new Runnable() {
			
			@Override
			public void run() {
			try {
				String �ɺ���� = "���Ⱑ ����� ����¡�� ����!! �Ķ�!!";
				for(int i=0; i<�ɺ����.length(); i++) {
					Thread.sleep(100);
					System.out.print(�ɺ����.charAt(i));
				}
				
			
			} catch (Exception e) {
				
			}
				
			}
		});

		
		try {
			��̰�����.suspend();
			���ȿ����.start();
			Thread.sleep(1000);
			�ɺ����.start();
			�ɺ����.join();
			System.out.println();
			���ȿ����.close();
			��̰�����.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	
	
	
	
	public void �޴�_����������(��̰� ��̰�, ���ΰ� ���ΰ�, ������ ������, �Ͼ߽� �Ͼ߽�,��ȭ�� ��ȭ��,���̼Ҹ� ���̼Ҹ�, �ùٷ� �ùٷ�) {
		
		System.out.println("================================================");
		System.out.println("  1: ��� �ο��.| 2: �Ͼ߽ù����� ����.| 3.��̰��� ������.");
		System.out.println("================================================");
		String ��Ʋ�޴�1 =scan.nextLine();
		if(��Ʋ�޴�1.equals("1")) {
			���ΰ�.�����ڰ������ϴ�(��̰�, ���ΰ�, ������, �Ͼ߽�, ���̼Ҹ�, �ùٷ�, ��ȭ��);;
		}else if(��Ʋ�޴�1.equals("2")) {
			//���̼Ҹ�, �ùٷ�� �����ϴ°� �־����.
			Thread �Ͼ߽ù�� = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						String ��� = "�Ͼ߽� ������ ���� �߿� �տ� ���� ���� ���� ���ִ�.";
						for(int i=0; i<���.length();i++) {
							Thread.sleep(100);
							System.out.print(���.charAt(i));
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			});
			try {
				Thread.sleep(100);
				System.out.print("[�ý���] ");
				
				�Ͼ߽ù��.start();
				�Ͼ߽ù��.join();
				System.out.println();
				��̰�����.suspend();
				���ΰ�.�ùٷ�������ϴ�(��̰�, ���ΰ�, ������, �Ͼ߽�, ���̼Ҹ�, �ùٷ�, ��ȭ��); //�ѹ� ������ ������ ������..
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			//�ùٷ�
	

		}else if(��Ʋ�޴�1.equals("3")) {
				��̰�����.close();
			 System.out.println("[�ý���] ��̰��� �������ϴ�.");
		}
	}
	
	public void �޴�_�ùٷ�óġ��(���ΰ� ���ΰ�, ��̰� ��̰�, ������ ������, �Ͼ߽� �Ͼ߽�, ���̼Ҹ� ���̼Ҹ�, �ùٷ� �ùٷ�, ��ȭ�� ��ȭ��) {
		Music ���ȿ���� = new Music("KEYSOUND1.mp3", true);
		��̰�����.resume();
		System.out.println("===============================");
		System.out.println("  1: ������ ����. | 2.��̰��� ������.");
		System.out.println("===============================");
		String ��Ʋ�޴�2 =scan.nextLine();
		if(��Ʋ�޴�2.equals("1")) {
			if(���ΰ�.get���ݷ�() < 90 || ���ΰ�.get����() < 80) {
				
				System.out.println("[�ý���] �Ͼ߽� ������ ����.");
				��̰�����.suspend();
				try {
					for(int i =0; i<5; i++) {
						Thread.sleep(500);
						System.out.println("           :        "); // ���̼Ҹ� ����� ���̼Ҹ� ���� ���� �ֱ�.
						
					}
				
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}				
				
				Thread ���̼Ҹ���� =new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							String ���̴�� = " ������ ������ �Ĵ±���.";
							for(int i=0; i<���̴��.length(); i++) {
							Thread.sleep(100);
							System.out.print(���̴��.charAt(i));
								
							}
						} catch (InterruptedException e) {
							// TODO: handle exception
						}
						
					}
				});
				try {
					���ȿ����.start();
					Thread.sleep(1000);
					System.out.print("[���̼Ҹ�] ");
					���̼Ҹ����.start();
					���̼Ҹ����.join();
					���ȿ����.close();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println();
				
				���ΰ�.���̼Ҹ��������ϴ�(��̰�, ���ΰ�, ������, �Ͼ߽�, ���̼Ҹ�, �ùٷ�, ��ȭ��);
				if(���ΰ�.getü��()<=0) {
				
					���ΰ�.���ΰ����(��ȭ��);
					
				}
			}else if(���ΰ�.get���ݷ�() >= 90 && ���ΰ�.get����() >= 80) {
				
				System.out.println("[�ý���] �Ͼ߽� ������ ����.");
				��̰�����.suspend();
				try {
					for(int i =0; i<5; i++) {
						Thread.sleep(500);
						System.out.println("           :        "); // ���̼Ҹ� ����� ���̼Ҹ� ���� ���� �ֱ�.
						
					}
				
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}	
				Thread �Ͼ߽ô�� =new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							String �Ͼ߽ô�� = "�ǹ����� ������� ���ٴ�, �̹��� ���� ���� ���̴�.";
							for(int i=0; i<�Ͼ߽ô��.length(); i++) {
							Thread.sleep(100);
							System.out.print(�Ͼ߽ô��.charAt(i));
								
							}
						} catch (InterruptedException e) {
							// TODO: handle exception
						}
						
					}
				});
				try {
					���ȿ����.start();
					Thread.sleep(1000);
					System.out.print("[�Ͼ߽�] ");
					�Ͼ߽ô��.start();
					�Ͼ߽ô��.join();
					���ȿ����.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				���ΰ�.�Ͼ߽ÿ������ϴ�(��̰�, ���ΰ�, ������, �Ͼ߽�, ���̼Ҹ�, �ùٷ�, ��ȭ��); //�Ͼ߽� �ѹ������� ������..
				if(���ΰ�.getü��()<=0) {
					���ΰ�.���ΰ����(��ȭ��);
					
				}
			
			}else {
				System.out.println("[�ý���] �濡 �ƹ��� ����.");
				��̰�����.close();
			}
		
		}else if(��Ʋ�޴�2.equals("2")) {
			��̰�����.close();
			System.out.println("[�ý���] ��̰��� �������ϴ�.");
		}
		
		
	}
	

	

	

}
