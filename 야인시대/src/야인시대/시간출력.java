package ���νô�;
import java.util.Calendar;
import java.util.Date;

public class �ð���� extends Thread{

	 Calendar �޷�= Calendar.getInstance();
	 int year = �޷�.get(Calendar.YEAR);
	 int mon = �޷�.get(Calendar.MONTH);
	 int day = �޷�.get(Calendar.DAY_OF_MONTH);
	 int hour = �޷�.get(Calendar.HOUR_OF_DAY);
	 int min = �޷�.get(Calendar.MINUTE);
	 int sec = �޷�.get(Calendar.SECOND);
	
		
		@Override
		public void run() {
			try {

				for(int i=1; i<=10 ;i++) {
							
					Thread.sleep(3600000); //1�ð�(3600�� * 1000)
 					System.out.println("���ӽ��� �� "+i+"�ð��� ����Ͽ����ϴ�.");
					 System.out.print("[����ð�] ");
				     System.out.print(year + "�� "+ mon+"�� "+day+"�� ");
				     System.out.println(hour + "�� "+ min+"�� "); 
				     if(i==2 && i==4 && i==6 && i==8) {				    	 
				    	 System.out.println("[�ý���] ��ð� ������ �ǰ��� �طӽ��ϴ�.");
				     }else if(i==10) {
				    	 System.out.println("[�ý���] ������ ������� �ǰ��� �����Ͽ� SHUT DOWN�ϰڽ��ϴ�.");
				    	 System.exit(0);
				     }
				}
				
				
				
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
	

	
}
