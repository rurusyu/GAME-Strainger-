package 아이템;

import 캐릭터.주인공;
//테스트용 클래스
public class 의류 extends 방어아이템{
	//각각 방어아이템에 대한 정보와 장착시 능력치 변하는 부분 필요하다.
	public 의류(String 아이템이름, int 공격력증가, int 방어력증가, int 가격, int 체력증가) {
		super(아이템이름, 공격력증가, 방어력증가, 가격, 체력증가);
		
	}

	public void 중절모정보() {
		
		this.공격력증가 = 0;
		this.방어력증가 = 2;
		this.가격 = 3000;

		System.out.println("이름 : 중절모");
		System.out.println("설명 : 중후함을 상징하는 야인 패션의 완성을 위한 필수 소품.");
		System.out.print("공격력증가:"+공격력증가);
		System.out.print(" 방어력증가:"+방어력증가);
		System.out.print(" 가격:"+가격);
	}
	
	public void 화이트셔츠정보() {
		
		this.공격력증가 = 0;
		this.방어력증가 = 4;
		this.가격 = 5000;

		System.out.println("이름 : 화이트셔츠");
		System.out.println("설명 : 화이트칼라의 첫인상을 결정하는 부분. 때가 타면 고객신뢰를 잃는다.");
		System.out.print("공격력증가:"+공격력증가);
		System.out.print(" 방어력증가:"+방어력증가);
		System.out.print(" 가격:"+가격);
	}
	
	
	public void 정장정보() {
		
		this.공격력증가 = 0;
		this.방어력증가 = 10;
		this.가격 = 10000;

		System.out.println("이름 : 정장");
		System.out.println("설명 : 정장으로 야인들을 평가할 만큼 중요한 요소.");
		System.out.print("공격력증가:"+공격력증가);
		System.out.print(" 방어력증가:"+방어력증가);
		System.out.print(" 가격:"+가격);
	}
	
	
	public void 트렌치코트정보() {
		
		this.공격력증가 = 0;
		this.방어력증가 = 20;
		this.가격 = 50000;

		System.out.println("이름 : 트렌치코트");
		System.out.println("설명 : 야인패션의 완성.허리를 묶는 정통 영국풍 스타일이 인기를 끌고 있다.");
		System.out.print("공격력증가:"+공격력증가);
		System.out.print(" 방어력증가:"+방어력증가);
		System.out.print(" 가격:"+가격);
	}
	

}
