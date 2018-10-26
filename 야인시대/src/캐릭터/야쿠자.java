package 캐릭터;

import 야인시대.Music;

public class 야쿠자 extends 캐릭터{

	//확률변수
	int 확률;
	
	
	public 야쿠자(String 이름, int 공격력, int 체력, int 소지금, int 방어력) {
		super(이름, 공격력, 체력, 소지금, 방어력);
		// TODO Auto-generated constructor stub
	}

	public void 야쿠자상태창() {
		
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
	
	public void 졸개사망(주인공 주인공, 야쿠자 야쿠자) {
	
		System.out.println("[시스템] "+야쿠자.get이름()+"체력이 "+0+"이 되어 항복했습니다.");
		System.out.println("[시스템] "+야쿠자.get이름()+"가 대결에서 져서 도망갔습니다.");
		System.out.println("[시스템] 돈"+야쿠자.get소지금()+"원을 얻었습니다.");
		주인공.set소지금(주인공.get소지금() + 야쿠자.get소지금());
	}
}
