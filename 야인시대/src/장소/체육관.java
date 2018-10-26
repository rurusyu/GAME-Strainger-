package 장소;

import 야인시대.Music;
import 캐릭터.주인공;
//테스트 체육관 클래스
public class 체육관 extends 장소 {
	/*돈을 내고 능력치를 올리는 공간.
	 * 줄넘기 1000원, 샌드백 2000원, 스파링 2000원
	 */
	
	
	public 체육관(String 장소명) {
		super(장소명);
		// TODO Auto-generated constructor stub
	}
	
	public void 체육관이용설명(주인공 주인공) {
		System.out.println("====================================================================");
		System.out.println(" 줄넘기 : 1000원에 체력+2 상승하며, 아이템을 제외한 순수체력은 최대 200까지 향상가능하다. ");
		System.out.println(" 샌드백 : 2000원에 공격력+1 상승하며, 아이템을 제외한 순수공격력은 최대 130까지 향상가능하다. ");
		System.out.println(" 스파링 : 2000원에 방어력+1 상승하며, 아이템을 제외한 순수방어력은 최대 156까지 향상가능하다. ");
		System.out.println("====================================================================");
		주인공.주인공상태창();
	}
	public void 체육관내부(주인공 주인공) {
		System.out.println("[관장] 무슨 일로 오셨습니까?");
		메뉴_체육관(주인공);
	}
	
	public void 메뉴_체육관(주인공 주인공) {
		Music 체육관배경음 = new Music("GYM.mp3", true);
		체육관배경음.start();
		//가격설명해야함.		
		체육관이용설명(주인공);
		System.out.println("==================================================");
		System.out.println(" 1: 줄넘기를한다.| 2:샌드백친다. | 3:스파링한다. | 4: 나간다. ");
		System.out.println("==================================================");
		String 체육관메뉴 = scan.nextLine();
	while(!체육관메뉴.equals("1")||!체육관메뉴.equals("2")||!체육관메뉴.equals("3")||!체육관메뉴.equals("4")) {
		if(체육관메뉴.equals("1")) {
			if(주인공.get소지금()>=1000) {
				
				체육관배경음.close();
				주인공.줄넘기(주인공);
				메뉴_체육관(주인공);
			}else {
				체육관배경음.close();
				System.out.println("[관장] 돈도 없으면서 줄넘기를 한다고?? 줄로 묶어버리기 전에 확 꺼져!!!!");
				System.out.println("[시스템] 체육관에서 추방당했습니다.");
			}
			
		}else if(체육관메뉴.equals("2")) {
			if(주인공.get소지금()>=2000) {

				체육관배경음.close();
				주인공.샌드백(주인공);
				메뉴_체육관(주인공);
			}else{
				체육관배경음.close();
				System.out.println("[관장] 돈도 없으면서 샌드백을 친다고?? 에이 꺼져!!!");
				System.out.println("[시스템] 체육관에서 추방당했습니다.");
			}
			
		}else if(체육관메뉴.equals("3")) {
			if(주인공.get소지금()>=2000) {
				체육관배경음.close();
				주인공.스파링(주인공);
				메뉴_체육관(주인공);
			}else {
				체육관배경음.close();
				System.out.println("[관장] 돈도 없으면서 스파링을 한다고?? 에이 꺼져!!!");	
				System.out.println("[시스템] 체육관에서 추방당했습니다.");
			}
		}else if(체육관메뉴.equals("4")) {
			체육관배경음.close();
			System.out.println("[시스템] 체육관을 나갔습니다.");
		}else {
			System.out.println("[시스템] 올바른 키를 입력하십시오.");
			체육관메뉴 = scan.nextLine();
			if(체육관메뉴.equals("1")) {
				if(주인공.get소지금()>=1000) {
					주인공.줄넘기(주인공);
					메뉴_체육관(주인공);
				}else {
					System.out.println("[관장] 돈도 없으면서 줄넘기를 한다고?? 줄로 묶어버리기 전에 확 꺼져!!!!");				
				}
			}else if(체육관메뉴.equals("2")) {
				if(주인공.get소지금()>=2000) {
					주인공.샌드백(주인공);
					메뉴_체육관(주인공);
				}else{
					System.out.println("[관장] 돈도 없으면서 샌드백을 친다고?? 에이 꺼져!!!");				
				}
			}else if(체육관메뉴.equals("3")){
				if(주인공.get소지금()>=2000) {
					주인공.스파링(주인공);
					메뉴_체육관(주인공);
				}else {
					System.out.println("[관장] 돈도 없으면서 스파링을 한다고?? 에이 꺼져!!!");				
				}
			}else if(체육관메뉴.equals("4")){
				System.out.println("[시스템] 체육관을 나갔습니다.");
			}else {
				
			}
		}break;
	}//while end
	}

	

	
}
