package 장소;

import java.util.Scanner;
//테스트용 클래스
public class 장소 {
	public static Scanner scan = new Scanner(System.in);
	String 장소명;

	public 장소(String 장소명) {
		super();
		this.장소명 = 장소명;
	}

	public String get장소명() {
		return 장소명;
	}

	public void set장소명(String 장소명) {
		this.장소명 = 장소명;
	}
}
