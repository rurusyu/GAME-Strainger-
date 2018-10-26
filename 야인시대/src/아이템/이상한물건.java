package 아이템;

import 캐릭터.주인공;

public class 이상한물건 extends 공격아이템{

	public 이상한물건(String 아이템이름, int 공격력증가, int 방어력증가, int 가격, int 체력증가) {
		super(아이템이름, 공격력증가, 방어력증가, 가격, 체력증가);
		// TODO Auto-generated constructor stub
	}

	public void 김무옥의벨트정보() {
		
		this.공격력증가 = 20;
		this.방어력증가 = 0;
		this.가격 = 20000;

		System.out.println("이름 : 김무옥의 벨트");
		System.out.println("설명 : 왠지쓰면 김무옥처럼 힘이 쎄질 것 같고, 김무옥이 자기벨트 찾으러 올 것 같은 느낌이 드는 이상한 물건");
		System.out.print("공격력증가: "+공격력증가);
		System.out.print(" 방어력증가: "+방어력증가);
		System.out.print(" 가격: "+가격);
	}
	
	public void 신마적의조끼정보() {
		
		this.공격력증가 = 30;
		this.방어력증가 = 0;
		this.가격 = 40000;

		System.out.println("이름 : 신마적의 조끼");
		System.out.println("설명 : 신마적의 최애 조끼, 왠지 입으면 신마적이 찾으러 올 것 같은 느낌이 드는 이상한 물건");
		System.out.print("공격력증가: "+공격력증가);
		System.out.print(" 방어력증가: "+방어력증가);
		System.out.print(" 가격: "+가격);
	}
	
	public void 이정재의경찰뱃지정보() {
		
		this.공격력증가 = 40;
		this.방어력증가 = 0;
		this.가격 = 60000;

		System.out.println("이름 : 이정재의 경찰뱃지");
		System.out.println("설명 : 경찰 이정재가 잃어버린 뱃지, 가지고 있으면 찾으러 올 것 같은 느낌이 드는 이상한 물건");
		System.out.print("공격력증가: "+공격력증가);
		System.out.print(" 방어력증가: "+방어력증가);
		System.out.print(" 가격: "+가격);
	}
	
	public void 시라소니의눈물정보() {
		
		this.공격력증가 = 50;
		this.방어력증가 = 0;
		this.가격 = 80000;

		System.out.println("이름 : 시라소니의 눈물");
		System.out.println("설명 : 시라소니가 이정재에게 린치당한 후 흘린 눈물, 지니고 있으면 시라소니의 마음을 알 수 있을 것 같은 이상한 물건");
		System.out.print("공격력증가: "+공격력증가);
		System.out.print(" 방어력증가: "+방어력증가);
		System.out.print(" 가격: "+가격);
	}
	

}
