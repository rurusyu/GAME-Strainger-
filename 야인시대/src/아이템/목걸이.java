package 아이템;

import 캐릭터.주인공;

public class 목걸이 extends 방어아이템{

	public 목걸이(String 아이템이름, int 공격력증가, int 방어력증가, int 가격, int 체력증가) {
		super(아이템이름, 공격력증가, 방어력증가, 가격, 체력증가);
		// TODO Auto-generated constructor stub
	}

	public void 음이온목걸이정보() {
		
		this.체력증가 = 10;
		this.방어력증가 = 2;
		this.가격 = 3000;

		System.out.println("이름 : 음이온목걸이");
		System.out.println("설명 : 몸안에 활성산소와 노폐물을 흡수하여 건강하게 만든다는 신비의 목걸이.");
		System.out.print("체력증가:"+체력증가);
		System.out.print(" 방어력증가:"+방어력증가);
		System.out.print(" 가격:"+가격);
	}
	
	public void 은목걸이정보() {
		
		this.체력증가 = 20;
		this.방어력증가 = 4;
		this.가격 = 5000;

		System.out.println("이름 : 은목걸이");
		System.out.println("설명 : 동의보감에 독을 흡수한다는 내용을 바탕으로 만든 건강기능 목걸이.");
		System.out.print("체력증가:"+체력증가);
		System.out.print(" 방어력증가:"+방어력증가);
		System.out.print(" 가격:"+가격);
	}
	
	
	public void 화이트골드목걸이정보() {
		
		this.체력증가 = 30;
		this.방어력증가 = 10;
		this.가격 = 10000;

		System.out.println("이름 : 화이트골드목걸이");
		System.out.println("설명 : 금목걸이 사기엔 돈이 없는 사람들을 위해 나온 합금목걸이.");
		System.out.print("체력증가:"+체력증가);
		System.out.print(" 방어력증가:"+방어력증가);
		System.out.print(" 가격:"+가격);
	}
	
	
	public void 금목걸이정보() {
		
		this.체력증가 = 40;
		this.방어력증가 = 20;
		this.가격 = 50000;

		System.out.println("이름 : 금목걸이");
		System.out.println("설명 : 금목걸이를 차고 다니면 모두가 이 사람이 건달인지 알려주는 기능을 가진 남성적인 목걸이.");
		System.out.print("체력증가:"+체력증가);
		System.out.print(" 방어력증가:"+방어력증가);
		System.out.print(" 가격:"+가격);
	}
	
	
}
