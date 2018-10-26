package 아이템;

import 캐릭터.주인공;
//테스트용 클래스
public class 장갑 extends 공격아이템{
	//각각 공격아이템에 대한 정보와 장착시 능력치 변하는 부분 필요하다.
	public 장갑(String 아이템이름, int 공격력증가, int 방어력증가, int 가격, int 체력증가) {
		super(아이템이름, 공격력증가, 방어력증가, 가격, 체력증가);
		// TODO Auto-generated constructor stub
	}

	public void 면장갑정보() {
		
		this.공격력증가 = 3;
		this.방어력증가 = 0;
		this.가격 = 5000;

		System.out.println("이름 : 면장갑");
		System.out.println("설명 : 면으로 만든 얇은 장갑, 껴도 느낌이 안난다.");
		System.out.print("공격력증가: "+공격력증가);
		System.out.print(" 방어력증가: "+방어력증가);
		System.out.print(" 가격: "+가격);
	}
	
	public void 목장갑정보() {
		
		this.공격력증가 = 7;
		this.방어력증가 = 0;
		this.가격 = 10000;

		System.out.println("이름 : 목장갑");
		System.out.println("설명 : 건축현장에서 끼는 장갑. 답답하다.");
		System.out.print("공격력증가: "+공격력증가);
		System.out.print(" 방어력증가: "+방어력증가);
		System.out.print(" 가격: "+가격);
	}
	
	public void 가죽장갑정보() {
		
		this.공격력증가 = 15;
		this.방어력증가 = 0;
		this.가격 = 30000;

		System.out.println("이름 : 가죽장갑");
		System.out.println("설명 : 신사들이 끼는 광택나는 장갑. 우아하다.");
		System.out.print("공격력증가: "+공격력증가);
		System.out.print(" 방어력증가: "+방어력증가);
		System.out.print(" 가격: "+가격);
	}
	
	public void 해골장갑정보() {
		
		this.공격력증가 = 20;
		this.방어력증가 = 0;
		this.가격 = 50000;

		System.out.println("이름 : 해골장갑");
		System.out.println("설명 : 사람의 뼈가 박혀있는 장갑. 맞으면 굉장히 아프다. 사람을 해칠 수도 있다.");
		System.out.print("공격력증가: "+공격력증가);
		System.out.print(" 방어력증가: "+방어력증가);
		System.out.print(" 가격: "+가격);
	}

	

	
}
