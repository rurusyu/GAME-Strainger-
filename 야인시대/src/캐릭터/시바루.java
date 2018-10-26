package 캐릭터;

import java.util.Random;

import 장소.잡화점;

public class 시바루 extends 야쿠자{

	
	public 시바루(String 이름, int 공격력, int 체력, int 소지금, int 방어력) {
		super(이름, 공격력, 체력, 소지금, 방어력);
		// TODO Auto-generated constructor stub
	}

	public void 시바루상태창() {
		
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
	
	
	
	
	public void 스킬_엎어치기(주인공 주인공, 잡화점 잡화점) {
		//쿨타임
		
		//40%확률로 스킬 사용
		Random ran = new Random();
		확률 = ran.nextInt(10)+1;//1~10까지
		if(확률 %5 == 0 || 확률 %5 == 1) {
			
			System.out.println("[시바루] (스킬) 엎어치기!!");
			if(주인공.get체력() > 0) {
				int 데미지 = (주인공.get방어력()/2)-(get공격력()+15); //데미지 계산
				주인공.set체력(주인공.get체력()+데미지);
				System.out.println("[시스템] "+get이름()+"가 <엎어치기> 스킬을 사용하여 "+데미지+"의 피해를 입혔습니다.");
				System.out.println("[시스템] "+주인공.get이름()+ "체력이 "+주인공.get체력()+"남았습니다.");	
				주인공.주인공상태창();
				
				주인공.주인공사망(잡화점);
			}// if end
		}else {
			System.out.println("[시바루] 도무지 쉽게 잡히질 않는 군..");
		}
		
	} //스킬 end
		
	public void 시바루사망(주인공 주인공,시바루 시바루) {
		System.out.println("[시스템] "+시바루.get이름()+"체력이 "+0+"이 되어 항복했습니다.");
		System.out.println("[시스템] "+시바루.get이름()+"가 패배를 인정했습니다.");
		System.out.println("["+시바루.get이름()+"] 다음 번엔 반드시 이겨주마.");
		System.out.println("[시스템] 돈"+시바루.get소지금()+"원을 얻었습니다.");
		주인공.set소지금(주인공.get소지금() + 시바루.get소지금());
	}
	
}
