package 캐릭터;

import java.util.Random;

import 야인시대.Music;
import 장소.잡화점;

public class 하야시 extends 가미소리{

	public 하야시(String 이름, int 공격력, int 체력, int 소지금, int 방어력) {
		super(이름, 공격력, 체력, 소지금, 방어력);
		// TODO Auto-generated constructor stub
	}
	
	public void 하야시상태창() {
			
			this.이름 = 이름;
			this.공격력 = 공격력;
			this.방어력 = 방어력;
				if(this.체력 >0) {
					this.체력 = 체력;
	
				}else {
					this.체력 = 0;
				}
			this.소지금 = 소지금;
			System.out.println("●===================●");
			System.out.println("     이   름 :"+이름);
			System.out.println("     체   력 :"+체력);
			System.out.println("     공격력 :"+공격력);
			System.out.println("     방어력 :"+방어력);
			System.out.println("●===================●");
			//	System.out.println("     소지금 :"+소지금);
		}
	
	public void 스킬_그림자베기(주인공 주인공, 잡화점 잡화점) {
		//쿨타임
		
		//20%확률로 스킬 사용
		Random ran = new Random();
		확률 = ran.nextInt(10)+1;//1~10까지
		if(확률 %5 == 1 || 확률 %5 == 2) {
			
			System.out.println("[하야시] (스킬) 그림자베기!!");
			if(주인공.get체력() > 0) {
				int 데미지 = (주인공.get방어력()/2)-(get공격력()+25); //데미지 계산
				주인공.set체력(주인공.get체력()+데미지);
				System.out.println("[시스템] "+get이름()+"가 <그림자베기> 스킬을 사용하여 "+데미지+"의 피해를 입혔습니다.");
				System.out.println("[시스템] "+주인공.get이름()+ "체력이 "+주인공.get체력()+"남았습니다.");	
				
				
				주인공.주인공사망(잡화점);
			}// if end
		}else {
			System.out.println("[하야시] 이걸 피하다니..");
		}
	
	}
	
	
	public void 스킬_심장찌르기(주인공 주인공, 잡화점 잡화점) {
		//쿨타임
		
		//10%확률로 스킬 사용
		Random ran = new Random();
		확률 = ran.nextInt(10)+1;//1~10까지
		if(확률 %5 == 4) {
			
			System.out.println("[하야시] (오의) 심장찌르기!!");
			if(주인공.get체력() > 0) {
				int 데미지 = (주인공.get방어력()/2)-(get공격력()+50); //데미지 계산
				주인공.set체력(주인공.get체력()+데미지);
				System.out.println("[시스템] "+get이름()+"가 <심장찌르기> 스킬을 사용하여 "+데미지+"의 피해를 입혔습니다.");
				System.out.println("[시스템] "+주인공.get이름()+ "체력이 "+주인공.get체력()+"남았습니다.");	
				
				
				주인공.주인공사망(잡화점);
			}// if end
		}else {
			System.out.println("[하야시] 생각보다 빠르군..");
		}
	}
	
	
	public void 하야시_디버프_프레셔(주인공 주인공) {
		주인공.set공격력(get공격력()/4);
	}
	
	public void 하야시사망(주인공 주인공,하야시 하야시) {
		
		System.out.println("[시스템] "+하야시.get이름()+"체력이 "+0+"이 되어 항복했습니다.");
		System.out.println("[시스템] "+하야시.get이름()+"가 대결에서 졌습니다.");
		Thread 하야시사망대사 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					String 사망대사 = "내가 졌으니 모든 것을 주고 떠나겠네..";
					for(int i=0; i<사망대사.length(); i++) {
						Thread.sleep(100);
						System.out.print(사망대사.charAt(i));
					}
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				
			}
		});
		try {
			Music 엔딩곡 = new Music("ENDINGOST.mp3",false);
			System.out.print("["+하야시.get이름()+"] ");
			하야시사망대사.start();
			하야시사망대사.join();
			엔딩곡.start();
			 System.out.println();
			 Thread.sleep(500);
			 System.out.println();
			 Thread.sleep(500);
			 System.out.println("     ▒▒▒▒▒▒▒         ▒▒▒▒       ▒▒▒▒      ▒▒▒▒    ▒▒▒▒▒▒▒▒▒▒     ▒▒▒▒▒▒▒▒    ▒▒            ▒▒▒▒▒▒▒▒▒▒       ▒▒▒▒       ▒▒▒▒▒▒▒▒▒▒      ▒▒▒▒ ");
			 Thread.sleep(500);
			 System.out.println("   ▒▒       ▒▒      ▒▒  ▒▒      ▒▒ ▒▒    ▒▒ ▒▒    ▒▒            ▒▒           ▒▒            ▒▒              ▒▒  ▒▒      ▒▒        ▒▒    ▒▒▒▒           ");
			 Thread.sleep(500);
			 System.out.println("   ▒▒       ▒▒     ▒▒    ▒▒     ▒▒  ▒▒  ▒▒  ▒▒    ▒▒            ▒▒           ▒▒            ▒▒             ▒▒    ▒▒     ▒▒        ▒▒    ▒▒▒▒        ");
			 Thread.sleep(500);
			 System.out.println("   ▒▒       ▒▒    ▒▒      ▒▒    ▒▒   ▒▒▒▒   ▒▒    ▒▒            ▒▒           ▒▒            ▒▒            ▒▒      ▒▒    ▒▒        ▒▒    ▒▒▒▒    ");
			 Thread.sleep(500);
			 System.out.println("   ▒▒             ▒▒▒▒▒▒▒▒▒▒    ▒▒    ▒▒    ▒▒    ▒▒▒▒▒▒▒▒▒▒    ▒▒           ▒▒            ▒▒▒▒▒▒▒▒▒▒    ▒▒▒▒▒▒▒▒▒▒    ▒▒▒▒▒▒▒▒▒▒      ▒▒▒▒             ");
			 Thread.sleep(500);
			 System.out.println("   ▒▒     ▒▒▒▒    ▒▒      ▒▒    ▒▒    ▒▒    ▒▒    ▒▒            ▒▒           ▒▒            ▒▒            ▒▒      ▒▒    ▒▒        ▒▒    ▒▒▒▒       ");
			 Thread.sleep(500);
			 System.out.println("   ▒▒       ▒▒    ▒▒      ▒▒    ▒▒          ▒▒    ▒▒            ▒▒           ▒▒            ▒▒            ▒▒      ▒▒    ▒▒        ▒▒        ");
			 Thread.sleep(500);
			 System.out.println("   ▒▒       ▒▒    ▒▒      ▒▒    ▒▒          ▒▒    ▒▒            ▒▒           ▒▒            ▒▒            ▒▒      ▒▒    ▒▒        ▒▒    ▒▒▒▒   ");
			 Thread.sleep(500);
			 System.out.println("     ▒▒▒▒▒▒▒      ▒▒      ▒▒    ▒▒          ▒▒    ▒▒▒▒▒▒▒▒▒▒     ▒▒▒▒▒▒▒▒    ▒▒▒▒▒▒▒▒▒▒    ▒▒▒▒▒▒▒▒▒▒    ▒▒      ▒▒    ▒▒        ▒▒    ▒▒▒▒");
			 엔딩곡.join();
			
			System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
