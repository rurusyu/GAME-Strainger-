package 장소;


import 야인시대.Music;
import 캐릭터.가미소리;
import 캐릭터.시바루;
import 캐릭터.주인공;
import 캐릭터.하야시;
import 캐릭터.야쿠자;
//테스트용 클래스
public class 우미관 extends 장소 {
//우미관은 실질적인 주인공과 몬스터, 보스의 전투가 일어나야 하는 부분임. 
	Music 우미관음악 = new Music("UMIGWAN.mp3",true);
	
	public 우미관(String 장소명) {
		super(장소명);
		
	}

	public void 우미관에_들어갔다() {
		Music 대사효과음 = new Music("KEYSOUND1.mp3", true);  //확장자 꼭 넣기!!!!!
		
		System.out.println("[시스템] 우미관에 들어왔다.");
		System.out.println();
		System.out.print("[하야시심복] ");
		Thread 심복대사 = new Thread(new Runnable() {
			
			@Override
			public void run() {
			try {
				String 심복대사 = "여기가 어디라고 조센징이 들어와!! 쳐라!!";
				for(int i=0; i<심복대사.length(); i++) {
					Thread.sleep(100);
					System.out.print(심복대사.charAt(i));
				}
				
			
			} catch (Exception e) {
				
			}
				
			}
		});

		
		try {
			우미관음악.suspend();
			대사효과음.start();
			Thread.sleep(1000);
			심복대사.start();
			심복대사.join();
			System.out.println();
			대사효과음.close();
			우미관음악.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	
	
	
	
	public void 메뉴_전투끝난후(우미관 우미관, 주인공 주인공, 야쿠자 야쿠자, 하야시 하야시,잡화점 잡화점,가미소리 가미소리, 시바루 시바루) {
		
		System.out.println("================================================");
		System.out.println("  1: 계속 싸운다.| 2: 하야시방으로 간다.| 3.우미관을 나간다.");
		System.out.println("================================================");
		String 배틀메뉴1 =scan.nextLine();
		if(배틀메뉴1.equals("1")) {
			주인공.야쿠자과전투하다(우미관, 주인공, 야쿠자, 하야시, 가미소리, 시바루, 잡화점);;
		}else if(배틀메뉴1.equals("2")) {
			//가미소리, 시바루와 전투하는거 넣어야함.
			Thread 하야시방앞 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						String 방앞 = "하야시 방으로 가는 중에 앞에 누가 길을 막고 서있다.";
						for(int i=0; i<방앞.length();i++) {
							Thread.sleep(100);
							System.out.print(방앞.charAt(i));
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			});
			try {
				Thread.sleep(100);
				System.out.print("[시스템] ");
				
				하야시방앞.start();
				하야시방앞.join();
				System.out.println();
				우미관음악.suspend();
				주인공.시바루와전투하다(우미관, 주인공, 야쿠자, 하야시, 가미소리, 시바루, 잡화점); //한번 떄리고 밖으로 나가짐..
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			//시바루
	

		}else if(배틀메뉴1.equals("3")) {
				우미관음악.close();
			 System.out.println("[시스템] 우미관을 나갔습니다.");
		}
	}
	
	public void 메뉴_시바루처치후(주인공 주인공, 우미관 우미관, 야쿠자 야쿠자, 하야시 하야시, 가미소리 가미소리, 시바루 시바루, 잡화점 잡화점) {
		Music 대사효과음 = new Music("KEYSOUND1.mp3", true);
		우미관음악.resume();
		System.out.println("===============================");
		System.out.println("  1: 방으로 들어간다. | 2.우미관을 나간다.");
		System.out.println("===============================");
		String 배틀메뉴2 =scan.nextLine();
		if(배틀메뉴2.equals("1")) {
			if(주인공.get공격력() < 90 || 주인공.get방어력() < 80) {
				
				System.out.println("[시스템] 하야시 방으로 들어갔다.");
				우미관음악.suspend();
				try {
					for(int i =0; i<5; i++) {
						Thread.sleep(500);
						System.out.println("           :        "); // 가미소리 등장시 가미소리 등장 음악 넣기.
						
					}
				
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}				
				
				Thread 가미소리대사 =new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							String 가미대사 = " 무덤을 스스로 파는구나.";
							for(int i=0; i<가미대사.length(); i++) {
							Thread.sleep(100);
							System.out.print(가미대사.charAt(i));
								
							}
						} catch (InterruptedException e) {
							// TODO: handle exception
						}
						
					}
				});
				try {
					대사효과음.start();
					Thread.sleep(1000);
					System.out.print("[가미소리] ");
					가미소리대사.start();
					가미소리대사.join();
					대사효과음.close();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println();
				
				주인공.가미소리와전투하다(우미관, 주인공, 야쿠자, 하야시, 가미소리, 시바루, 잡화점);
				if(주인공.get체력()<=0) {
				
					주인공.주인공사망(잡화점);
					
				}
			}else if(주인공.get공격력() >= 90 && 주인공.get방어력() >= 80) {
				
				System.out.println("[시스템] 하야시 방으로 들어갔다.");
				우미관음악.suspend();
				try {
					for(int i =0; i<5; i++) {
						Thread.sleep(500);
						System.out.println("           :        "); // 가미소리 등장시 가미소리 등장 음악 넣기.
						
					}
				
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}	
				Thread 하야시대사 =new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							String 하야시대사 = "건방지게 여기까지 오다니, 이번엔 쉽지 않을 것이다.";
							for(int i=0; i<하야시대사.length(); i++) {
							Thread.sleep(100);
							System.out.print(하야시대사.charAt(i));
								
							}
						} catch (InterruptedException e) {
							// TODO: handle exception
						}
						
					}
				});
				try {
					대사효과음.start();
					Thread.sleep(1000);
					System.out.print("[하야시] ");
					하야시대사.start();
					하야시대사.join();
					대사효과음.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				주인공.하야시와전투하다(우미관, 주인공, 야쿠자, 하야시, 가미소리, 시바루, 잡화점); //하야시 한번때리고 나와짐..
				if(주인공.get체력()<=0) {
					주인공.주인공사망(잡화점);
					
				}
			
			}else {
				System.out.println("[시스템] 방에 아무도 없다.");
				우미관음악.close();
			}
		
		}else if(배틀메뉴2.equals("2")) {
			우미관음악.close();
			System.out.println("[시스템] 우미관을 나갔습니다.");
		}
		
		
	}
	

	

	

}
