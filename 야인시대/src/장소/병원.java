package 장소;

import 야인시대.Music;
import 캐릭터.주인공;
//테스트용 클래스
public class 병원 extends 장소 {
	//캐릭터 회복을 담당하는 부분.
	public 병원(String 장소명) {
		super(장소명);
		
	}
	
	public void 병원이용설명() {
		System.out.println("============================");
		System.out.println(" 회복은 1회 300원이며, 풀로 채워준다. ");
		System.out.println("============================");
		
	}
	
	public void 메뉴_회복(주인공 주인공) {
		Music 병원배경음 = new Music("HOSPITAL1.mp3", true);
		
		병원배경음.start();
		System.out.println("[의사] 무슨 일로 오셨습니까?");
		System.out.println("=====================");
		System.out.println(" 1: 회복한다.| 2: 나간다. ");
		System.out.println("=====================");
		String 회복메뉴 = scan.nextLine();
		
	while(!회복메뉴.equals("1")||!회복메뉴.equals("2")) {
		if(회복메뉴.equals("1")) {
			병원배경음.close();
			
			주인공.회복하다(주인공);
			
		}else if(회복메뉴.equals("2")) {
			 System.out.println("[시스템] 병원을 나갔습니다.");
			 병원배경음.close();
		}else {
			System.out.println("[시스템] 올바른 키를 입력하십시오.");
			회복메뉴 = scan.nextLine();
			if(회복메뉴.equals("1")) {
				주인공.회복하다(주인공);
			}else if(회복메뉴.equals("2")) {
				 System.out.println("[시스템] 병원을 나갔습니다.");
			}else {
				
			}
		}	
		 break;// 없어야 반복문 됨. 없으면 회복받을떄 돈없으면 무한루프.
		}//while end
	}
	

	
	
}
