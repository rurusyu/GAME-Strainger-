package 야인시대;

import java.util.Calendar;
import java.util.Scanner;

import 아이템.목걸이;
import 아이템.의류;
import 아이템.이상한물건;
import 아이템.장갑;
import 장소.도박장;
import 장소.병원;
import 장소.우미관;
import 장소.잡화점;
import 장소.체육관;
import 캐릭터.가미소리;
import 캐릭터.시바루;
import 캐릭터.주인공;
import 캐릭터.하야시;
import 캐릭터.야쿠자;
//야인시대 : 본격적으로 여기서 활동하는 무대임.
//테스트용 클래스
public class 야인시대 {
	
	public static Scanner scan = new Scanner(System.in);
	public static boolean 낮 = true; //밤은 false
	
	
	public static void 게임설명() {
		System.out.println("===============================================[게임설명]=======================================================");
		System.out.println(" [게임클리어조건] 하야시를 쓰러뜨리면 게임은 종료하게 됩니다.");
		System.out.println(" [플레이방법] 본 게임은 적을 쓰러뜨리고, 돈을모아 아이템을 구매하여 최종보스를 쓰러뜨려야합니다.");
		System.out.println(" [밤과 낮] 밤에는 적들의 공격력, 방어력이 20% 상승하고, 도박장에 출입을 할 수 있습니다. 낮에는 적들의 공격력,방어력이 원상태로 돌아옵니다. 밤과 낮의 시간은 각각 5분 입니다.");
		System.out.println(" [상태창] 캐릭터의 정보를 볼 수 있습니다.");
		System.out.println(" [우미관] 적들과 전투를 하는 곳이며, 적에게 이기면, 돈을 얻습니다. 우미관에는 최고보스인 하야시가 주인공 능력치가 일정값에 도달하면 등장합니다.");
		System.out.println(" [잡화점] 각종 아이템을 구매할 수 있으며, 주인공은 공격아이템, 방어아이템, 체력아이템, 특수아이템 각각 1종류씩만 장착 가능합니다. 밤에는 영업을 안합니다.");
		System.out.println(" [병원] 캐릭터 체력을 회복하는 곳이며, 밤에는 영업을 하지 않습니다.");
		System.out.println(" [체육관] 캐릭터의 능력치를 올리는 공간입니다. 밤에는 영업을 하지 않습니다. ");
		System.out.println(" [도박장] 낮에는 영업을 하지 않으며, 밤에만 영업하는 곳으로써 돈을 벌 수 있습니다.");
		System.out.println(" [게임오버] 주인공이 사망했을 경우 게임은 종료됩니다.");
		System.out.println(" [셧다운] 장시간 플레이를 방지하기 위해 게임플레이 2시간 단위로 알람이 나오며, 10시간 경과후에는 자동으로 게임이 종료됩니다.");
		System.out.println("==============================================================================================================");
	}
	
	
	public static void 메뉴창() {
		System.out.println("============================================================");
		System.out.println("  1:상태창 |2:우미관 |3:잡화점 |4:병원  |5.체육관 | 6.도박장 | 7.게임종료");
		System.out.println("============================================================");
	}
	
	public static void 현재시간알림창() {
		Calendar 달력= Calendar.getInstance();
		int year = 달력.get(Calendar.YEAR);
        int mon = 달력.get(Calendar.MONTH);
        int day = 달력.get(Calendar.DAY_OF_MONTH);
        int hour = 달력.get(Calendar.HOUR_OF_DAY);
        int min = 달력.get(Calendar.MINUTE);
        int sec = 달력.get(Calendar.SECOND);

       
        System.out.print("[현재시간] ");
        System.out.print(year + "년 "+ mon+"월 "+day+"일 ");
        System.out.println(hour + "시 "+ min+"분 "+sec+"초");   
	}
	
	public static void main(String[] args) {
		시간출력 시간 = new 시간출력();
		Thread 시간출력 = new Thread(시간);
		Music 도입부음악 = new Music("SHORT_OST.mp3", true); //확장자명 빼먹으면 안됨.
		Music 키보드소리 = new Music("KEYSOUND1.mp3", true);
		Music 배경음악 = new Music("MAINOST2.mp3", true);
		Music 잡화점배경음 = new Music("GTA.mp3", true);
		
		
		도입부음악.start();
		
			//쓰레드 제목출력	
		 Thread 제목 = new Thread(
				 new Runnable() { //1회용이라 이렇게 사용.
					
					@Override
					public void run() {
						try {
							 System.out.println(); //제목크게 넣기. 제목쓰레드 처리! 로딩하면서 음악나오게!
							 Thread.sleep(500);
							 System.out.println();
							 Thread.sleep(500);
							 System.out.println("     ▒▒▒      ▒▒       ▒▒▒      ▒▒         ▒▒       ▒▒    ▒▒▒▒▒▒  ▒▒   ▒▒                          ");
							 Thread.sleep(500);
							 System.out.println("   ▒▒   ▒▒    ▒▒     ▒▒   ▒▒    ▒▒       ▒▒  ▒▒     ▒▒    ▒▒      ▒▒   ▒▒        ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒   ");
							 Thread.sleep(500);
							 System.out.println("   ▒▒   ▒▒    ▒▒▒▒   ▒▒   ▒▒    ▒▒      ▒▒    ▒▒    ▒▒    ▒▒      ▒▒   ▒▒       ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒ ");
							 Thread.sleep(500);
							 System.out.println("   ▒▒   ▒▒    ▒▒     ▒▒   ▒▒    ▒▒      ▒▒    ▒▒    ▒▒    ▒▒      ▒▒   ▒▒     ▒▒▒▒▒▒|▒▒▒▒|▒▒▒▒|▒▒▒ ");
							 Thread.sleep(500);
							 System.out.println("   ▒▒   ▒▒    ▒▒       ▒▒▒      ▒▒      ▒▒    ▒▒    ▒▒    ▒▒      ▒▒▒▒▒▒▒    ▒▒|▒▒▒▒|▒▒▒▒|▒▒▒▒|▒▒▒ ");
							 Thread.sleep(500);
							 System.out.println("   ▒▒   ▒▒    ▒▒▒▒                      ▒▒    ▒▒    ▒▒    ▒▒      ▒▒   ▒▒   ▒▒▒|▒▒▒▒|▒▒▒▒|▒▒▒▒|▒▒▒ ");
							 Thread.sleep(500);
							 System.out.println("   ▒▒   ▒▒    ▒▒          ▒▒            ▒▒    ▒▒    ▒▒    ▒▒      ▒▒   ▒▒   ▒▒▒|▒▒▒▒|▒▒▒▒|▒▒▒▒|▒▒  ");
							 Thread.sleep(500);
							 System.out.println("     ▒▒▒      ▒▒          ▒▒▒▒▒▒▒▒▒▒    ▒▒    ▒▒    ▒▒    ▒▒▒▒▒▒  ▒▒   ▒▒    ▒▒▒▒▒▒                ");
							 Thread.sleep(500);
							 System.out.println("                                                                                                   ");
						} catch (InterruptedException e) {
							
						}
						
					}
				}
				 );
		 제목.start();//제목쓰레드 실행
		 
		//시작할때 미리 환경셋팅
		야쿠자 몬스터 = new 야쿠자("야쿠자",15,200,(int)(Math.random()*1000),10);
		하야시 최종보스몹 = new 하야시("하야시",50,500,300000,40);//공격력, 체력, 소지금, 방어력 순
		가미소리 보스2차몹 = new 가미소리("가미소리",40,400,100000,30);
		시바루 보스1차몹 = new 시바루("시바루",30,200,100000,20);
		잡화점 상점 = new 잡화점("잡화점");
		우미관 전투장= new 우미관("우미관");
		장갑 정보 = new 장갑("면장갑",3,0,5000,0);
		의류 방어구 = new 의류("중절모",0,2,5000,0);
		목걸이 목걸이 = new 목걸이("목걸이",0,2,3000,10);
		이상한물건 이상한물건 = new 이상한물건("김무옥의벨트",20,0,20000,0);
		병원 병원 = new 병원("병원");
		체육관 체육관 = new 체육관("체육관");
		도박장 도박장 = new 도박장("도박장");
		Thread 밤낮 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					while(true) {
						
							
							최종보스몹.set공격력(50); //낮에는 공격력 원복
							최종보스몹.set방어력(40); 
							보스1차몹.set공격력(30);
							보스1차몹.set방어력(20);
							보스2차몹.set공격력(40);
							보스2차몹.set방어력(30);
							몬스터.set공격력(15);
							몬스터.set방어력(10);
							//Thread.sleep(300000); //5분 (300초, 1초에 1000)
							for(int i=5;i>=1;i--) {
								System.out.println("[시스템] 밤까지 "+i+"분 남았습니다.");
								Thread.sleep(20000); //60000 이면 1분
								if(i==1) {
									낮 = false;
									
								}
							}
				
							System.out.println("[시스템] 밤이 되었습니다. 도박장이 열렸습니다. 적들의 공격력, 방어력이 20% 상승하였습니다.");
							최종보스몹.set공격력(60);
							최종보스몹.set방어력(48);
							보스1차몹.set공격력(36);
							보스1차몹.set방어력(24);
							보스2차몹.set공격력(48);
							보스2차몹.set방어력(36);
							몬스터.set공격력(17);
							몬스터.set방어력(14);
							
							for(int i=5;i>=1;i--) {
								System.out.println("[시스템] 낮까지 "+i+"분 남았습니다.");
								Thread.sleep(60000);
								if(i==1) {
								낮 = true;
								System.out.println("[시스템] 낮이 되었습니다. 적들의 공격력, 방어력이 원래대로 돌아왔습니다.");
								}
							}
						
					
					}//while end
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				
			}
		});

		//캐릭생성 부분	
		try {	
			제목.join(); //위 쓰레드 끝나고 진행.
		}catch (InterruptedException e) {
			// TODO: handle exception
		}
			
		게임설명();
		System.out.println("[시스템] 캐릭터 이름을 정하세요.");
		String name = scan.nextLine();
		도입부음악.close();
		System.out.println();
		
		주인공 행동 = new 주인공(name,20,100,1000000,39);//공격력, 체력, 소지금, 방어력 순
		System.out.println("[시스템] 캐릭터가 생성되었습니다.");
		시간출력.start();
		System.out.println();
		System.out.print("["+행동.get이름()+"]");
		Thread 주인공대사 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					String 캐릭생성시_대사 = "내 이름은 "+행동.get이름()+". 종로를 접수하러 가볼까?!";
					for(int i=0; i<캐릭생성시_대사.length(); i++) {
						Thread.sleep(100);
						System.out.print(캐릭생성시_대사.charAt(i)); //캐릭터 배열로 담아서 출력
						
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		try {
			
			키보드소리.start();  //대사 효과음
			Thread.sleep(1000);
			주인공대사.start();
			주인공대사.join();
			키보드소리.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		배경음악.start();
		System.out.println();
		행동.주인공상태창();
		현재시간알림창();
		try {
			밤낮.start();
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}

		잡화점배경음.start(); //while 안에 넣으면   IllegalThreadStateException 발생함. (start가 두번 실행되서 생기는 오류임). //동기화로 해결해야함.
		잡화점배경음.suspend(); //시작과 동시에 일시정지. 잡화점 갈떄 안에서 그냥 트는수밖에 없음..
		
			메뉴창();
			String 유저입력 = scan.nextLine();
			// 스토리 진행
			while(!유저입력.equals("1")||!유저입력.equals("2")||!유저입력.equals("3")||!유저입력.equals("4")||!유저입력.equals("5")||!유저입력.equals("6")||!유저입력.equals("7")||!유저입력.equals("+")) {
				if(유저입력.equals("1")) {
					행동.주인공상태창();
					유저입력 = "+";
					
				}else if(유저입력.equals("2")) {
					//우미관 메소드.
					배경음악.suspend();
					전투장.우미관에_들어갔다(); //우미관 배경음 구하기.
					행동.야쿠자과전투하다(전투장, 행동, 몬스터, 최종보스몹, 보스2차몹, 보스1차몹, 상점);
					
					유저입력 = "+";
					
				}else if(유저입력.equals("3")) {
					//잡화점	
					if(낮==true) {
						배경음악.suspend();
						잡화점배경음.resume();
						상점.메뉴_물건을본다(행동,정보, 방어구,목걸이,이상한물건);
						잡화점배경음.suspend();
						유저입력 = "+";						
					}else if(낮==false) {
						System.out.println("["+행동.get이름()+"] 밤이라 영업을 종료했다보다. 문이 잠겨있다.");
						유저입력 = "+";
					}
				}else if(유저입력.equals("4")) {
					if(낮==true) {
						배경음악.suspend();
						병원.메뉴_회복(행동);
						유저입력 = "+";				
					}else if(낮==false) {
						System.out.println("["+행동.get이름()+"] 밤이라 영업을 종료했다보다. 문이 잠겨있다.");
						유저입력 = "+";
					}
				}else if(유저입력.equals("5")) {
					if(낮==true) {
						배경음악.suspend();
						//체육관
						체육관.체육관내부(행동);
						유저입력 = "+";
					}else if(낮==false) {
						System.out.println("["+행동.get이름()+"] 밤이라 영업을 종료했다보다. 문이 잠겨있다.");
						유저입력 = "+";
					}
					
				}else if(유저입력.equals("6")) {
					배경음악.suspend();
					//도박장
					if(낮==true) {
						System.out.println("[관리인] 낮에는 영업 안합니다.");
						유저입력 = "+";
					}else if(낮 == false) {
						도박장.도박장내부(행동);
						유저입력 = "+";
					}
					
				}else if(유저입력.equals("7")) {
					//게임종료
					배경음악.close();
					시간출력.interrupt();
					System.out.println("[시스템] 게임을 종료하였습니다.");
					break;
				}else if(유저입력.equals("+")) {
					배경음악.resume();
					메뉴창();
					유저입력 = scan.nextLine(); //여기서 입력시 다시 메뉴로 갈수있게해야 게임 안 끝남. 그래서 이거씀.
				}else {
						System.out.println("[시스템] 올바른키를 입력하십시오"); //입력값 잘못 받을경우 예외처리
						메뉴창();
						유저입력 =scan.nextLine();
				    		if(유저입력.equals("1")) {
				    			유저입력 = "1";
				    			
							}else if(유저입력.equals("2")) {
								유저입력 = "2";
								
							}else if(유저입력.equals("3")){
								유저입력 = "3";
							}else if(유저입력.equals("4")){
								유저입력 = "4";	
							}else if(유저입력.equals("5")){
									유저입력 = "5";	
							}else if(유저입력.equals("6")){
								유저입력 = "6";
							}else if(유저입력.equals("7")){
								유저입력 = "7";	
							}else {
								
							}
			
				
			}//while end
				
		
	}

	}	//main end
}