package 야인시대;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	
	public Player player;  //Player는 javazoom 라이브러리에  있는 클래스.
	public boolean isLoop; // 1번 이냐, 무한반복이냐 
	public File file;
	public FileInputStream fis; //빨대
	public BufferedInputStream bis; //바가지.
	
		//생성자 
		public Music(String name, boolean isLoop) {
			try {
				this.isLoop = isLoop;
				file = new File(야인시대.class.getResource("/music/"+name).toURI()); //야인시대, main 클래스 있는 곳 지정.
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		public int getTime() { //현재 실행되는 음악이 어떤 위치에 실행되고 있는지 알려줌.
			if(player == null)
				return 0;
			return player.getPosition();
		}
		
		public void close() { //다른 곡듣고 싶을떄 언제든지 그만
			isLoop = false;
			player.close();
			this.interrupt(); //해당쓰레드 중지상태로 만듦. 곡종료
			
		}

		
	@Override
	public void run() {
		try {
		
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
				
			}while(isLoop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
		
}
