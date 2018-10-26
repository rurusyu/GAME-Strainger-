package ���νô�;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	
	public Player player;  //Player�� javazoom ���̺귯����  �ִ� Ŭ����.
	public boolean isLoop; // 1�� �̳�, ���ѹݺ��̳� 
	public File file;
	public FileInputStream fis; //����
	public BufferedInputStream bis; //�ٰ���.
	
		//������ 
		public Music(String name, boolean isLoop) {
			try {
				this.isLoop = isLoop;
				file = new File(���νô�.class.getResource("/music/"+name).toURI()); //���νô�, main Ŭ���� �ִ� �� ����.
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		public int getTime() { //���� ����Ǵ� ������ � ��ġ�� ����ǰ� �ִ��� �˷���.
			if(player == null)
				return 0;
			return player.getPosition();
		}
		
		public void close() { //�ٸ� ���� ������ �������� �׸�
			isLoop = false;
			player.close();
			this.interrupt(); //�ش羲���� �������·� ����. ������
			
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
