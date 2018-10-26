package 캐릭터;
//테스트용 캐릭터 클래스
import java.util.Scanner;

public class 캐릭터 {
	public static Scanner scan = new Scanner(System.in);
	String 이름;
	int 공격력, 체력, 소지금, 방어력;
	
	
	//상태창 호출될때 이거 호출.
	public void 캐릭터상태창() {
	
		
		this.이름 = 이름;
		this.공격력 = 공격력;
		this.방어력 = 방어력;
		if(this.체력 >0) {
			this.체력 = 체력;

		}else {
			this.체력 = 0;
		}
		this.소지금 = 20000;

		System.out.println("●===================●");
		System.out.println("     이   름 :"+이름    );
		System.out.println("     체   력 :"+체력    );
		System.out.println("     공격력 :"+공격력   );
		System.out.println("     방어력 :"+방어력);
		System.out.println("     소지금 :"+소지금+"원");
		System.out.println("●===================●");
		
	}
	
	
	public 캐릭터(String 이름, int 공격력, int 체력, int 소지금, int 방어력) {
		super();
		this.이름 = 이름;
		this.공격력 = 공격력;
		this.체력 = 체력;
		this.소지금 = 소지금;
		this.방어력 = 방어력;
	}

	
	public int 공격하다(int 데미지) {
	
		return 데미지;
	}
	

	public 캐릭터(int 체력) {
		super();
		this.체력 = 체력;	
	}
	
	
	public String get이름() {
		return 이름;
	}

	public void set이름(String 이름) {
		this.이름 = 이름;
	}

	public int get공격력() {
		return 공격력;
	}

	public void set공격력(int 공격력) {
		this.공격력 = 공격력;
	}

	public int get체력() {
		return 체력;
	}

	public void set체력(int 체력) {
		this.체력 = 체력;
	}

	public int get소지금() {
		return 소지금;
	}

	public void set소지금(int 소지금) {
		this.소지금 = 소지금;
	}

	public int get방어력() {
		return 방어력;
	}

	public void set방어력(int 방어력) {
		this.방어력 = 방어력;
	}
	
	

	
	
}
