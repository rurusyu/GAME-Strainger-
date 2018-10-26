package 야인시대;
import java.util.Calendar;
import java.util.Date;

public class 시간출력 extends Thread{

	 Calendar 달력= Calendar.getInstance();
	 int year = 달력.get(Calendar.YEAR);
	 int mon = 달력.get(Calendar.MONTH);
	 int day = 달력.get(Calendar.DAY_OF_MONTH);
	 int hour = 달력.get(Calendar.HOUR_OF_DAY);
	 int min = 달력.get(Calendar.MINUTE);
	 int sec = 달력.get(Calendar.SECOND);
	
		
		@Override
		public void run() {
			try {

				for(int i=1; i<=10 ;i++) {
							
					Thread.sleep(3600000); //1시간(3600초 * 1000)
 					System.out.println("게임시작 후 "+i+"시간이 경과하였습니다.");
					 System.out.print("[현재시간] ");
				     System.out.print(year + "년 "+ mon+"월 "+day+"일 ");
				     System.out.println(hour + "시 "+ min+"분 "); 
				     if(i==2 && i==4 && i==6 && i==8) {				    	 
				    	 System.out.println("[시스템] 장시간 게임은 건강에 해롭습니다.");
				     }else if(i==10) {
				    	 System.out.println("[시스템] 과도한 사용으로 건강을 생각하여 SHUT DOWN하겠습니다.");
				    	 System.exit(0);
				     }
				}
				
				
				
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
	

	
}
