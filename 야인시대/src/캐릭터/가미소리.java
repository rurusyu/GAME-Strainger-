package 캐릭터;

import java.util.Random;

import 장소.잡화점;

public class 가미소리 extends 야쿠자{

	public 가미소리(String 이름, int 공격력, int 체력, int 소지금, int 방어력) {
		super(이름, 공격력, 체력, 소지금, 방어력);
		// TODO Auto-generated constructor stub
	}

	public void 가미소리상태창() {
			
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
	
	public void 스킬_두번베기(주인공 주인공, 잡화점 잡화점) {
		//쿨타임
		
		//30%확률로 스킬 사용
		Random ran = new Random();
		확률 = ran.nextInt(10)+1;//1~10까지
		if(확률 %3 == 1) {
			
			System.out.println("[가미소리] (스킬) 두번베기!!");
			if(주인공.get체력() > 0) {
				int 데미지 = (주인공.get방어력()/2)-(get공격력()+20); //데미지 계산
				주인공.set체력(주인공.get체력()+데미지);
				System.out.println("[시스템] "+get이름()+"가 <두번베기> 스킬을 사용하여 "+데미지+"의 피해를 입혔습니다.");
				System.out.println("[시스템] "+주인공.get이름()+ "체력이 "+주인공.get체력()+"남았습니다.");	
				
				
				주인공.주인공사망(잡화점);
			}// if end
		}else {
			System.out.println("[가미소리] 잘피했군..");
		}
		
	} //스킬 end
	public void 가미소리사망(주인공 주인공,가미소리 가미소리) {
		System.out.println("[시스템] "+가미소리.get이름()+"체력이 "+0+"이 되어 항복했습니다.");
		System.out.println("[시스템] "+가미소리.get이름()+"가 패배를 인정했습니다.");
		System.out.println("[시스템] 돈"+가미소리.get소지금()+"원을 얻었습니다.");
		주인공.set소지금(주인공.get소지금() + 가미소리.get소지금());
	}
	
}
