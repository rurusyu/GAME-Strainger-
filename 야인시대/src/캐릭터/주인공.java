package 캐릭터;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import 야인시대.Music;
import 장소.우미관;
import 장소.잡화점;


public class 주인공 extends 캐릭터{
	//적 캐릭 공격하는거 구현하기위해 객체 생성함. Main에도 있으나, 전투 진행하는 부분이 메인이 아닌 주인공클래스에서 진행하기떄문에 생성.
	야쿠자 야쿠자 = new 야쿠자("야쿠자",15,200,(int)(Math.random()*1000),4);
	하야시 하야시 = new 하야시("하야시",50,500,300000,40);
	가미소리 가미소리 = new 가미소리("가미소리",40,400,100000,30);
	시바루 시바루 = new 시바루("시바루",30,200,100000,20);
	
	
	public Boolean 스킬사용 = true;
	
	public Thread 쿨타임;
	
	
	int 최대체력 =100; // 초기값 100맞춰줘야 처음에 맞고 회복하러갈때 -값 안됨. 줄넘기에서 최대체력만들고 나중에 몬스터와 싸운 후 치료할때 최대치에서 데미지 입은만큼 회복해야하기 때문에 변수 만듦
	
	public 주인공(String 이름, int 공격력, int 체력, int 소지금, int 방어력) {
		super(이름, 공격력, 체력, 소지금, 방어력);
		// TODO Auto-generated constructor stub
	}

	
	//상태창 호출될때 이거 호출.
	public void 주인공상태창() {
	
		
		this.이름 = 이름;
		this.공격력 = 공격력;
		this.방어력 = 방어력;
		if(this.체력 >0) {
			this.체력 = 체력;

		}else {
			this.체력 = 0;
		}
		this.소지금 = 소지금;

		System.out.println("●===================●");
		System.out.println("     이   름 :"+이름    );
		System.out.println("     체   력 :"+체력    );
		System.out.println("     공격력 :"+공격력   );
		System.out.println("     방어력 :"+방어력);
		System.out.println("     소지금 :"+소지금+"원");
		System.out.println("●===================●");
		
	}
	
	
	public void 야쿠자과전투하다(우미관 우미관,주인공 주인공, 야쿠자 야쿠자,하야시 하야시, 가미소리 가미소리, 시바루 시바루, 잡화점 잡화점) {
		야쿠자.set체력(30);  //스킬부분 + 나갔다가 돌아오면 피풀로 채워져있게.
		야쿠자.set소지금((int)(Math.random()*1000)); //등장할때 마다 소지금 바뀌게.
		System.out.println("[시스템] 적이 등장했다.");
		야쿠자.야쿠자상태창();

		Thread 졸개공격 = new Thread(new Runnable() {
			//적 자동공격 쓰레드
			@Override
			public void run() {
				int 데미지1 = (주인공.get방어력()/2)-야쿠자.get공격력(); //데미지 계산.
				try {
					while(야쿠자.get체력()>=0 || 주인공.get체력()>=0) {
						if(야쿠자.get체력()>0) {
						Thread.sleep(3000); //3초 단위로 공격
							if(주인공.get방어력()/2 > 야쿠자.get공격력()) { //주인공 방어력이 몹 공격력보다 높으면 체력이 +되는 거 방지.
								주인공.set체력(주인공.get체력()-1); 
								System.out.println("[시스템] "+야쿠자.get이름()+"가 공격하여 "+-1+"의 피해를 입혔습니다.");
								주인공.주인공상태창();
							}else if(주인공.get방어력()/2 <= 야쿠자.get공격력()) {
								주인공.set체력(주인공.get체력()+(주인공.get방어력()/2)-야쿠자.get공격력());
								System.out.println("[시스템] "+야쿠자.get이름()+"가 공격하여 "+데미지1+"의 피해를 입혔습니다.");
								주인공.주인공상태창();
							}//else if end
						
						}if(야쿠자.get체력()<=0) {
							야쿠자.졸개사망(주인공, 야쿠자);
							break;
						}else if(주인공.get체력()<=0) {
							주인공.주인공사망(잡화점);;
							break;
						}
					}//while end
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				
			}
		});
		졸개공격.setDaemon(true);
		졸개공격.start();
		
		while(get체력() != 0) {	//죽을떄까지 싸우게.
				
			System.out.println("=======================================");
			System.out.println("  1.공격하다.|  2.스킬을 사용한다. | 3.도망간다. ");
			System.out.println("=======================================");
			int input1 = scan.nextInt();
				
				if(input1 == 1) {
						//주인공이 적 타격하는 부분
						if(야쿠자.get체력() > 0) {
							야쿠자.set체력(야쿠자.get체력()+(야쿠자.get방어력()/2)-공격하다(get공격력()));
							int 데미지 = (야쿠자.get방어력()/2)-get공격력(); //데미지 계산.
							System.out.println("[시스템] "+get이름()+"이 공격하여 "+데미지+"의 피해를 입혔습니다.");
							야쿠자.야쿠자상태창(); //몹은 자동으로 주인공 때리고, 주인공 상태창 뿌림. 따라서 주인공은 몹 때리고 몹상태창 뿌리게끔.  
							주인공사망(잡화점); //사망시 메소드임.
							
							if(야쿠자.get체력()>0) { //체력 -안되게 하려고 만듦.
							System.out.println("[시스템] "+야쿠자.get이름()+"체력이 "+야쿠자.get체력()+"남았습니다."); 
								
							}else if(야쿠자.get체력() <= 0) {
								
									졸개공격.interrupt();
									야쿠자.졸개사망(주인공, 야쿠자);
									
									break; //브레이크 있어야 죽였을때 공격메뉴 안나옴.
																
						}			
						} //야쿠자 end
				}else if(input1 == 2) { //스킬공격
					
					
					if(잡화점.주인공_공격아이템[1] != null) {
							if(잡화점.주인공_공격아이템[1].equals("김무옥의벨트")) {
								System.out.println("========================================");
								System.out.println("  1.[스킬]김무옥의 박치기(공격력 40) | 2.이전메뉴  ");
								System.out.println("========================================");
			
								int 스킬버튼 = scan.nextInt();  //nextLine으로 했으면 개행문자때문에 맨 위 메뉴(1.공격하다.|  2.스킬을 사용한다. | 3.도망간다. ) 나옴...
							
								if(스킬버튼==1) {
									
									if(스킬사용 == true || 쿨타임.getState() == Thread.State.TERMINATED){ //중복방지용 or 조건쓰면 쿨타임.getState() == Thread.State.TERMINATED 되면 다시 실행가능
									System.out.println("["+get이름()+"] 내 안에 무옥이가 들어온 듯한 느낌을 받는다.");
									System.out.println("[스킬] 김무옥의 박치기!!!!");
									야쿠자.set체력(야쿠자.get체력()-스킬_김무옥의박치기(40)); //여기다 넣어야 피깎인거 출력 제대로 됨. 쿨타임 										
									
									if(야쿠자.get체력()>0) {
										System.out.println("[시스템] "+야쿠자.get이름()+"가 스킬데미지 -40을 입었습니다.");
										System.out.println("[시스템] "+야쿠자.get이름()+"체력이 "+야쿠자.get체력()+"남았습니다."); 
										스킬_박치기쿨타임();
										야쿠자.야쿠자상태창();

										주인공사망(잡화점);
//										break;
										
										if(야쿠자.get체력()>0) { //체력 -안되게 하려고 만듦.
											System.out.println("[시스템] "+야쿠자.get이름()+"체력이 "+야쿠자.get체력()+"남았습니다."); 
										}		
										}else if(야쿠자.get체력() <= 0) {
											try {
												졸개공격.interrupt();
												야쿠자.졸개사망(주인공, 야쿠자);
												break; //브레이크 있어야 죽였을때 공격메뉴 안나옴.
												
											} catch (Exception e) {
												// TODO: handle exception
											}
	
									}
									스킬사용 = false;
									
									}else if(스킬사용 == false) {

										if(쿨타임.getState() == Thread.State.TIMED_WAITING) {
											System.out.println("[시스템] 쿨타임이 종료되지 않았습니다.");

											스킬사용 =false;
										}
								
									}
			
								}else if(스킬버튼==2) {
									//아무것도 없어야 위에 버튼으로 감.
								
								}
							
							}else if(잡화점.주인공_공격아이템[1].equals("신마적의조끼")) {
								
								System.out.println("=========================================");
								System.out.println("  1.[스킬]신마적의 돌려차기(공격력 60) | 2.이전메뉴  ");
								System.out.println("=========================================");
			
								int 스킬버튼 = scan.nextInt();  //nextLine으로 했으면 개행문자때문에 맨 위 메뉴 나옴...
							
								if(스킬버튼==1) {
									if(스킬사용 == true || 쿨타임.getState() == Thread.State.TERMINATED){ //중복방지용 or 조건쓰면 쿨타임.getState() == Thread.State.TERMINATED 되면 다시 실행가능	
								
									System.out.println("["+get이름()+"] 내 안에 신마적이 들어온 듯한 느낌을 받는다.");
									System.out.println("[스킬] 신마적의 돌려차기!!!!");
									야쿠자.set체력(야쿠자.get체력()-스킬_신마적의돌려차기(60));
									if(야쿠자.get체력()>0) {
										System.out.println(야쿠자.get이름()+"가 스킬데미지 -60을 입었습니다.");
										System.out.println("[시스템] "+야쿠자.get이름()+"체력이 "+야쿠자.get체력()+"남았습니다."); 
										스킬_돌려차기쿨타임();
										야쿠자.야쿠자상태창();
																				
										주인공사망(잡화점);
										
										
									}else if(야쿠자.get체력()<=0) {
										졸개공격.interrupt();
										야쿠자.졸개사망(주인공, 야쿠자);
										break;
										}
										
									스킬사용 = false;
									
									}else if(스킬사용 == false) {

										if(쿨타임.getState() == Thread.State.TIMED_WAITING) {
											System.out.println("[시스템] 쿨타임이 종료되지 않았습니다.");
											스킬사용 =false;
										}
								
									} //스킬사용 if end
								}else if(스킬버튼==2) {
									
								}
								
							}else if(잡화점.주인공_공격아이템[1].equals("이정재의경찰뱃지")) {
								
								System.out.println("=========================================");
								System.out.println("  1.[스킬]이정재의 핵펀치(공격력 80) | 2.이전메뉴  ");
								System.out.println("=========================================");
			
								int 스킬버튼 = scan.nextInt();  //nextLine으로 했으면 개행문자때문에 맨 위 메뉴 나옴...
								
								if(스킬버튼==1) {
									if(스킬사용 == true || 쿨타임.getState() == Thread.State.TERMINATED){ //중복방지용 or 조건쓰면 쿨타임.getState() == Thread.State.TERMINATED 되면 다시 실행가능
									System.out.println("["+get이름()+"] 내 안에 정재가 있는 듯한 느낌을 받는다.");
									System.out.println("[스킬] 이정재의 핵펀치!!!!");
									야쿠자.set체력(야쿠자.get체력()-스킬_이정재의핵펀치(80));
									if(야쿠자.get체력()>0) {
										System.out.println(야쿠자.get이름()+"가 스킬데미지 -80을 입었습니다.");
										System.out.println("[시스템] "+야쿠자.get이름()+"체력이 "+야쿠자.get체력()+"남았습니다."); 
										스킬_핵펀치쿨타임();
										야쿠자.야쿠자상태창();
																				
										주인공사망(잡화점);
										
										
									}else if(야쿠자.get체력()<=0) {
										졸개공격.interrupt();
										야쿠자.졸개사망(주인공, 야쿠자);
										break;
										}
									스킬사용 = false;
									
									}else if(스킬사용 == false) {

										if(쿨타임.getState() == Thread.State.TIMED_WAITING) {
											System.out.println("[시스템] 쿨타임이 종료되지 않았습니다.");
											스킬사용 =false;
										}
								
									} //스킬사용 if end
								}else if(스킬버튼==2) {
									
								}
							
								
							}else if(잡화점.주인공_공격아이템[1].equals("시라소니의눈물")) {
								
								System.out.println("============================================");
								System.out.println("  1.[스킬]시라소니의 불꽃하이킥(공격력 100) | 2.이전메뉴  ");
								System.out.println("============================================");
			
								int 스킬버튼 = scan.nextInt();  //nextLine으로 했으면 개행문자때문에 맨 위 메뉴 나옴...
								
									if(스킬버튼==1) {
										if(스킬사용 == true || 쿨타임.getState() == Thread.State.TERMINATED){ //중복방지용 or 조건쓰면 쿨타임.getState() == Thread.State.TERMINATED 되면 다시 실행가능
										System.out.println("["+주인공.get이름()+"] 내 안에 시라소니 형님이 계신 듯한 느낌을 받는다.");
										System.out.println("[스킬] 시라소니의 불꽃 하이킥!!!!");
										야쿠자.set체력(야쿠자.get체력()-스킬_이정재의핵펀치(100));
										if(야쿠자.get체력()>0) {
											System.out.println(야쿠자.get이름()+"가 스킬데미지 -100을 입었습니다.");
											System.out.println("[시스템] "+야쿠자.get이름()+"체력이 "+야쿠자.get체력()+"남았습니다."); 
											야쿠자.야쿠자상태창();
											스킬_불꽃하이킥쿨타임();
																						
											주인공사망(잡화점);
											
											
										}else if(야쿠자.get체력()<=0) {
											졸개공격.interrupt();
											야쿠자.졸개사망(주인공, 야쿠자);
											break;
											}
										스킬사용 = false;
										
										}else if(스킬사용 == false) {

											if(쿨타임.getState() == Thread.State.TIMED_WAITING) {
												System.out.println("[시스템] 쿨타임이 종료되지 않았습니다.");
												스킬사용 =false;
											}
									
										} //스킬사용 if end
								}else if(스킬버튼==2) {
									
								}
							
							}
					}else if(잡화점.주인공_공격아이템[1] == null) {
						System.out.println("[시스템] 사용가능한 스킬이 없습니다.");
						
					}
				}else if(input1 == 3) {
					졸개공격.interrupt();
					System.out.println(get이름()+"은 무서워서 도망갔다.");
					break;
				} //큰 if end
				
			}//while end
		우미관.메뉴_전투끝난후(우미관, 주인공, 야쿠자, 하야시, 잡화점, 가미소리, 시바루);
		
		} // 졸개를 공격하다 end
	
	
	public void 시바루와전투하다(우미관 우미관,주인공 주인공, 야쿠자 야쿠자,하야시 하야시, 가미소리 가미소리, 시바루 시바루, 잡화점 잡화점) {
		Music 시바루등장음 = new Music("SIBARU.mp3", true);
		시바루.set체력(200);  //스킬부분 + 나갔다가 돌아오면 피풀로 채워져있게.
		시바루.set소지금((int)(Math.random()*20000)+10001); //등장할때 마다 소지금 바뀌게.
		시바루등장음.start();
		System.out.println("[시스템] 시바루가 등장했다.");
		시바루.시바루상태창();     

		Thread 시바루공격 = new Thread(new Runnable() {
			//적 자동공격 쓰레드~~
			@Override
			public void run() {
				int 데미지1 = (주인공.get방어력()/2)-시바루.get공격력(); //데미지 계산.
			//	시바루.시바루상태창();  
				try {
					while(시바루.get체력()>=0 || 주인공.get체력()>=0) {
						if(시바루.get체력()>0) {
						Thread.sleep(2000);
							if(주인공.get방어력()/2 > 시바루.get공격력()) { //주인공 방어력이 몹 공격력보다 높으면 체력이 +되는 거 방지.
								주인공.set체력(주인공.get체력()-1); 
								System.out.println("[시스템] "+시바루.get이름()+"가 공격하여 "+-1+"의 피해를 입혔습니다.");
								주인공.주인공상태창();
							}else if(주인공.get방어력()/2 <= 시바루.get공격력()) {
								주인공.set체력(주인공.get체력()+(주인공.get방어력()/2)-시바루.get공격력());
								System.out.println("[시스템] "+시바루.get이름()+"가 공격하여 "+데미지1+"의 피해를 입혔습니다.");
								주인공.주인공상태창();
							}//else if end
						
						시바루.스킬_엎어치기(주인공, 잡화점); //시바루 스킬
						}if(시바루.get체력()<=0) {
							시바루등장음.close();
							시바루.시바루사망(주인공, 시바루);
							break;
						}else if(주인공.get체력()<=0) {
							시바루등장음.close();
							주인공.주인공사망(잡화점);;
							break;
						}
					}//while end
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				
			}
		});
		시바루공격.setDaemon(true);
		시바루공격.start();
		
		while(get체력() != 0) {	//죽을떄까지 싸우게.
			System.out.println("=======================================");
			System.out.println("  1.공격하다.|  2.스킬을 사용한다. | 3.도망간다. ");
			System.out.println("=======================================");
			
			int input1 = scan.nextInt();
				
				if(input1 == 1) {
						//주인공이 떄림.
						if(시바루.get체력() > 0) {
							시바루.set체력(시바루.get체력()+(시바루.get방어력()/2)-공격하다(get공격력()));
							int 데미지 = (시바루.get방어력()/2)-get공격력(); //데미지 계산.
					
							System.out.println("[시스템] "+get이름()+"이 공격하여 "+데미지+"의 피해를 입혔습니다.");
							시바루.시바루상태창();  
							//시바루 공격								
		//					시바루.스킬_엎어치기(주인공, 잡화점); //시바루 스킬
						
							주인공사망(잡화점);
							
							if(시바루.get체력()>0) { //체력 -안되게 하려고 만듦.
							System.out.println("[시스템] "+시바루.get이름()+"체력이 "+시바루.get체력()+"남았습니다."); 
								
							}else if(시바루.get체력() <= 0) {
								시바루공격.interrupt();
								시바루등장음.close();
								시바루.시바루사망(주인공, 시바루);
								break; //브레이크 있어야 죽였을때 공격메뉴 안나옴.
						}			
						} //야쿠자 end
				}else if(input1 == 2) { //스킬공격
					
					
					if(잡화점.주인공_공격아이템[1] != null) {
							if(잡화점.주인공_공격아이템[1].equals("김무옥의벨트")) {
								System.out.println("========================================");
								System.out.println("  1.[스킬]김무옥의 박치기(공격력 40) | 2.이전메뉴  ");
								System.out.println("========================================");
			
								int 스킬버튼 = scan.nextInt();  //nextLine으로 했으면 개행문자때문에 맨 위 메뉴 나옴...
							
								if(스킬버튼==1) {
									if(스킬사용 == true || 쿨타임.getState() == Thread.State.TERMINATED){ //중복방지용 or 조건쓰면 쿨타임.getState() == Thread.State.TERMINATED 되면 다시 실행가능
									System.out.println("["+get이름()+"] 내 안에 무옥이가 들어온 듯한 느낌을 받는다.");
									System.out.println("[스킬] 김무옥의 박치기!!!!");
									시바루.set체력(시바루.get체력()-스킬_김무옥의박치기(40)); //적 체력감소부분
									if(시바루.get체력()>0) {
										System.out.println(시바루.get이름()+"가 스킬데미지 -40을 입었습니다.");
										System.out.println("[시스템] "+시바루.get이름()+"체력이 "+시바루.get체력()+"남았습니다."); 
										시바루.시바루상태창();  
										스킬_박치기쿨타임();
									
				//						시바루.스킬_엎어치기(주인공, 잡화점); //시바루 스킬
														
										주인공사망(잡화점);
									//	break;
										
									}else if(시바루.get체력()<=0) {
										시바루공격.interrupt();
										시바루등장음.close();
										시바루.시바루사망(주인공, 시바루);
										//여긴 브레이크 없어야 스킬쓰고 바로 윗 메뉴로 갈수 있음.
										}
								
									스킬사용 = false;
									
									}else if(스킬사용 == false) {

										if(쿨타임.getState() == Thread.State.TIMED_WAITING) {
											System.out.println("[시스템] 쿨타임이 종료되지 않았습니다.");

											스킬사용 =false;
										}
								
									}
								}else if(스킬버튼==2) {
									
								}
							
							}else if(잡화점.주인공_공격아이템[1].equals("신마적의조끼")) {
								
								System.out.println("=========================================");
								System.out.println("  1.[스킬]신마적의 돌려차기(공격력 60) | 2.이전메뉴  ");
								System.out.println("=========================================");
			
								int 스킬버튼 = scan.nextInt();  //nextLine으로 했으면 개행문자때문에 맨 위 메뉴 나옴...
							
								if(스킬버튼==1) {
									if(스킬사용 == true || 쿨타임.getState() == Thread.State.TERMINATED){ //중복방지용 or 조건쓰면 쿨타임.getState() == Thread.State.TERMINATED 되면 다시 실행가능
									System.out.println("["+get이름()+"] 내 안에 신마적이 들어온 듯한 느낌을 받는다.");
									System.out.println("[스킬] 신마적의 돌려차기!!!!");
									시바루.set체력(시바루.get체력()-스킬_신마적의돌려차기(60));
									if(시바루.get체력()>0) {
										System.out.println(시바루.get이름()+"가 스킬데미지 -60을 입었습니다.");
										System.out.println("[시스템] "+시바루.get이름()+"체력이 "+시바루.get체력()+"남았습니다."); 
										시바루.시바루상태창();
										스킬_돌려차기쿨타임();		
								
										주인공사망(잡화점);
									//	break;
										
									}else if(시바루.get체력()<=0) {
										시바루공격.interrupt();
										시바루등장음.close();
										시바루.시바루사망(주인공, 시바루);
										
										}
									스킬사용 = false;
									
									}else if(스킬사용 == false) {

										if(쿨타임.getState() == Thread.State.TIMED_WAITING) {
											System.out.println("[시스템] 쿨타임이 종료되지 않았습니다.");

											스킬사용 =false;
										}
								
									}
								}else if(스킬버튼==2) {
									
								}
							
							}else if(잡화점.주인공_공격아이템[1].equals("이정재의경찰뱃지")) {
								
								System.out.println("=========================================");
								System.out.println("  1.[스킬]이정재의 핵펀치(공격력 80) | 2.이전메뉴  ");
								System.out.println("=========================================");
			
								int 스킬버튼 = scan.nextInt();  //nextLine으로 했으면 개행문자때문에 맨 위 메뉴 나옴...
								
								if(스킬버튼==1) {
									if(스킬사용 == true || 쿨타임.getState() == Thread.State.TERMINATED){ //중복방지용 or 조건쓰면 쿨타임.getState() == Thread.State.TERMINATED 되면 다시 실행가능
									System.out.println("["+get이름()+"] 내 안에 정재가 있는 듯한 느낌을 받는다.");
									System.out.println("[스킬] 이정재의 핵펀치!!!!");
									시바루.set체력(시바루.get체력()-스킬_이정재의핵펀치(80));
									if(시바루.get체력()>0) {
										System.out.println(시바루.get이름()+"가 스킬데미지 -80을 입었습니다.");
										System.out.println("[시스템] "+시바루.get이름()+"체력이 "+시바루.get체력()+"남았습니다."); 
										시바루.시바루상태창();
										스킬_핵펀치쿨타임();

										주인공사망(잡화점);
									//	break;
										
									}else if(시바루.get체력()<=0) {
										시바루공격.interrupt();
										시바루등장음.close();
										시바루.시바루사망(주인공, 시바루);
										
										}
									스킬사용 = false;
									
									}else if(스킬사용 == false) {

										if(쿨타임.getState() == Thread.State.TIMED_WAITING) {
											System.out.println("[시스템] 쿨타임이 종료되지 않았습니다.");

											스킬사용 =false;
										}
								
									}
								}else if(스킬버튼==2) {
									
								}
						
								
							}else if(잡화점.주인공_공격아이템[1].equals("시라소니의눈물")) {
								
								System.out.println("============================================");
								System.out.println("  1.[스킬]시라소니의 불꽃하이킥(공격력 100) | 2.이전메뉴  ");
								System.out.println("============================================");
			
								int 스킬버튼 = scan.nextInt();  //nextLine으로 했으면 개행문자때문에 맨 위 메뉴 나옴...
								
									if(스킬버튼==1) {
										if(스킬사용 == true || 쿨타임.getState() == Thread.State.TERMINATED){ //중복방지용 or 조건쓰면 쿨타임.getState() == Thread.State.TERMINATED 되면 다시 실행가능
										System.out.println("["+주인공.get이름()+"] 내 안에 시라소니 형님이 계신 듯한 느낌을 받는다.");
										System.out.println("[스킬] 시라소니의 불꽃 하이킥!!!!");
										시바루.set체력(시바루.get체력()-스킬_이정재의핵펀치(100));
										if(시바루.get체력()>0) {
											System.out.println(시바루.get이름()+"가 스킬데미지 -100을 입었습니다.");
											System.out.println("[시스템] "+시바루.get이름()+"체력이 "+시바루.get체력()+"남았습니다."); 
											시바루.시바루상태창();
											스킬_불꽃하이킥쿨타임();
											
											주인공사망(잡화점);
										//	break; // 브레이크 없으면 문제되고.. 있으면 
											
										}else if(시바루.get체력()<=0) {
											시바루공격.interrupt();
											시바루등장음.close();
											시바루.시바루사망(주인공, 시바루);
											break; //죽으면 브레이크 우미관 메뉴.
											}
											
										스킬사용 = false;
										
										}else if(스킬사용 == false) {

											if(쿨타임.getState() == Thread.State.TIMED_WAITING) {
												System.out.println("[시스템] 쿨타임이 종료되지 않았습니다.");

												스킬사용 =false;
											}
									
										}
								}else if(스킬버튼==2) {
									
								}
							
							}
						}else if(잡화점.주인공_공격아이템[1] == null) {
							System.out.println("[시스템] 사용가능한 스킬이 없습니다.");
						}
					//메뉴 3번 
				}else if(input1 == 3) {
					시바루공격.interrupt();
					시바루등장음.close();
					System.out.println(get이름()+"은 무서워서 도망갔다.");
					break; //만약에 없으면 메뉴탈출안됨..
				} //큰 if end1
				
				//break;
			}//while end
			if(시바루.get체력()>0) {
				//도망가기 눌렀을때 하야시방으로 바로 안가지게...
			}else if(시바루.get체력()<=0) {
				우미관.메뉴_시바루처치후(주인공, 우미관, 야쿠자, 하야시, 가미소리, 시바루, 잡화점);  //가미소리 등장조건 맞춰야할 듯...
				
			}
		} // 시바루 공격하다 end
	
	public void 가미소리와전투하다(우미관 우미관,주인공 주인공, 야쿠자 야쿠자,하야시 하야시, 가미소리 가미소리, 시바루 시바루, 잡화점 잡화점) {
		Music 가미소리등장음 = new Music("GAMISORI.mp3", true);
		가미소리.set체력(400);  //스킬부분 + 나갔다가 돌아오면 피풀로 채워져있게.
		가미소리.set소지금((int)(Math.random()*40000)+10001); //등장할때 마다 소지금 바뀌게.
		가미소리등장음.start();
		System.out.println("[시스템] 하야시 오른팔 가미소리가 등장했다.");
		가미소리.가미소리상태창();

		Thread 가미소리공격 = new Thread(new Runnable() {
			//적 자동공격 쓰레드~~
			@Override
			public void run() {
				int 데미지1 = (주인공.get방어력()/2)-가미소리.get공격력(); //데미지 계산.
//				가미소리.가미소리상태창();  
				try {
					while(가미소리.get체력()>=0 || 주인공.get체력()>=0) {
					if(가미소리.get체력()>0) {
						Thread.sleep(2000);
						if(주인공.get방어력()/2 > 가미소리.get공격력()) { //주인공 방어력이 몹 공격력보다 높으면 체력이 +되는 거 방지.
							주인공.set체력(주인공.get체력()-1); 
							System.out.println("[시스템] "+가미소리.get이름()+"가 공격하여 "+-1+"의 피해를 입혔습니다.");
							주인공.주인공상태창();
						}else if(주인공.get방어력()/2 <= 가미소리.get공격력()) {
							주인공.set체력(주인공.get체력()+(주인공.get방어력()/2)-가미소리.get공격력());
							System.out.println("[시스템] "+가미소리.get이름()+"가 공격하여 "+데미지1+"의 피해를 입혔습니다.");
							주인공.주인공상태창();
						}//else if end
						
						가미소리.스킬_두번베기(주인공, 잡화점);
						}if(가미소리.get체력()<=0) {
							가미소리등장음.close();
							가미소리.가미소리사망(주인공,가미소리);
							break;
						}else if(주인공.get체력()<=0) {
							가미소리등장음.close();
							주인공.주인공사망(잡화점);;
							break;
						}
					}//while end
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				
			}
		});
		가미소리공격.setDaemon(true);
		가미소리공격.start();
		
		while(get체력() != 0) {	//죽을떄까지 싸우게.
			System.out.println("=======================================");
			System.out.println("  1.공격하다.|  2.스킬을 사용한다. | 3.도망간다. ");
			System.out.println("=======================================");
			
			int input1 = scan.nextInt();
				
				if(input1 == 1) {
						//주인공이 떄림.
						if(가미소리.get체력() > 0) {
							가미소리.set체력(가미소리.get체력()+(가미소리.get방어력()/2)-공격하다(get공격력()));
							int 데미지 = (가미소리.get방어력()/2)-get공격력(); //데미지 계산.			
							System.out.println("[시스템] "+get이름()+"이 공격하여 "+데미지+"의 피해를 입혔습니다.");
							가미소리.가미소리상태창();  

							주인공사망(잡화점);
							
							if(가미소리.get체력()>0) { //체력 -안되게 하려고 만듦.
							System.out.println("[시스템] "+가미소리.get이름()+"체력이 "+가미소리.get체력()+"남았습니다."); 
								
							}else if(가미소리.get체력() <= 0) {
								가미소리공격.interrupt();
								가미소리등장음.close();
								가미소리.가미소리사망(주인공,가미소리);
								break; //브레이크 있어야 죽였을때 공격메뉴 안나옴.
						}			
						} //야쿠자 end
				}else if(input1 == 2) { //스킬공격
					
					
					if(잡화점.주인공_공격아이템[1] != null) {
						if(잡화점.주인공_공격아이템[1].equals("김무옥의벨트")) {
							System.out.println("========================================");
							System.out.println("  1.[스킬]김무옥의 박치기(공격력 40) | 2.이전메뉴  ");
							System.out.println("========================================");
		
							int 스킬버튼 = scan.nextInt();  //nextLine으로 했으면 개행문자때문에 맨 위 메뉴 나옴...
						try {
							if(스킬버튼==1) {
								if(스킬사용 == true || 쿨타임.getState() == Thread.State.TERMINATED){ //중복방지용 or 조건쓰면 쿨타임.getState() == Thread.State.TERMINATED 되면 다시 실행가능
								System.out.println("["+get이름()+"] 내 안에 무옥이가 들어온 듯한 느낌을 받는다.");
								System.out.println("[스킬] 김무옥의 박치기!!!!");
								가미소리.set체력(가미소리.get체력()-스킬_김무옥의박치기(40)); //적 체력감소부분
								if(가미소리.get체력()>0) {
									System.out.println(가미소리.get이름()+"가 스킬데미지 -40을 입었습니다.");
									System.out.println("[시스템] "+가미소리.get이름()+"체력이 "+가미소리.get체력()+"남았습니다."); 
									가미소리.가미소리상태창();
									스킬_박치기쿨타임();

									주인공사망(잡화점);								
									
								}else if(가미소리.get체력()<=0) {
									가미소리공격.interrupt();
									가미소리등장음.close();
									가미소리.가미소리사망(주인공,가미소리);
									break;
									}
								스킬사용 = false;
								
								}else if(스킬사용 == false) {

									if(쿨타임.getState() == Thread.State.TIMED_WAITING) {
										System.out.println("[시스템] 쿨타임이 종료되지 않았습니다.");

										스킬사용 =false;
									}
							
								}
							}else if(스킬버튼==2) {
								
							}
						}
						 catch (Exception e) {
							
						
						}
						}else if(잡화점.주인공_공격아이템[1].equals("신마적의조끼")) {
							
							System.out.println("=========================================");
							System.out.println("  1.[스킬]신마적의 돌려차기(공격력 60) | 2.이전메뉴  ");
							System.out.println("=========================================");
		
							int 스킬버튼 = scan.nextInt();  //nextLine으로 했으면 개행문자때문에 맨 위 메뉴 나옴...
						try {
							if(스킬버튼==1) {
								if(스킬사용 == true || 쿨타임.getState() == Thread.State.TERMINATED){ //중복방지용 or 조건쓰면 쿨타임.getState() == Thread.State.TERMINATED 되면 다시 실행가능
								System.out.println("["+get이름()+"] 내 안에 신마적이 들어온 듯한 느낌을 받는다.");
								System.out.println("[스킬] 신마적의 돌려차기!!!!");
								가미소리.set체력(가미소리.get체력()-스킬_신마적의돌려차기(60));
								if(가미소리.get체력()>0) {
									System.out.println(가미소리.get이름()+"가 스킬데미지 -60을 입었습니다.");
									System.out.println("[시스템] "+가미소리.get이름()+"체력이 "+가미소리.get체력()+"남았습니다."); 
									가미소리.가미소리상태창();
									스킬_돌려차기쿨타임();
									주인공사망(잡화점);
									
									
								}else if(가미소리.get체력()<=0) {
									가미소리공격.interrupt();
									가미소리등장음.close();
									가미소리.가미소리사망(주인공,가미소리);
									break;
									}
								스킬사용 = false;
								
								}else if(스킬사용 == false) {

									if(쿨타임.getState() == Thread.State.TIMED_WAITING) {
										System.out.println("[시스템] 쿨타임이 종료되지 않았습니다.");

										스킬사용 =false;
									}
							
								}
							}else if(스킬버튼==2) {
								
							}
						}
						 catch (Exception e) {
							
						
						}
						}else if(잡화점.주인공_공격아이템[1].equals("이정재의경찰뱃지")) {
							
							System.out.println("=========================================");
							System.out.println("  1.[스킬]이정재의 핵펀치(공격력 80) | 2.이전메뉴  ");
							System.out.println("=========================================");
		
							int 스킬버튼 = scan.nextInt();  //nextLine으로 했으면 개행문자때문에 맨 위 메뉴 나옴...
							try {
							if(스킬버튼==1) {
								if(스킬사용 == true || 쿨타임.getState() == Thread.State.TERMINATED){ //중복방지용 or 조건쓰면 쿨타임.getState() == Thread.State.TERMINATED 되면 다시 실행가능
								System.out.println("["+get이름()+"] 내 안에 정재가 있는 듯한 느낌을 받는다.");
								System.out.println("[스킬] 이정재의 핵펀치!!!!");
								가미소리.set체력(가미소리.get체력()-스킬_이정재의핵펀치(80));
								if(가미소리.get체력()>0) {
									System.out.println(가미소리.get이름()+"가 스킬데미지 -80을 입었습니다.");
									System.out.println("[시스템] "+가미소리.get이름()+"체력이 "+가미소리.get체력()+"남았습니다."); 
									가미소리.가미소리상태창();
									스킬_핵펀치쿨타임();
									주인공사망(잡화점);
									
									
								}else if(가미소리.get체력()<=0) {
									가미소리공격.interrupt();
									가미소리등장음.close();
									가미소리.가미소리사망(주인공,가미소리);
									break;
									}
								스킬사용 = false;
								
								}else if(스킬사용 == false) {

									if(쿨타임.getState() == Thread.State.TIMED_WAITING) {
										System.out.println("[시스템] 쿨타임이 종료되지 않았습니다.");

										스킬사용 =false;
									}
							
								}
							}else if(스킬버튼==2) {
								
							}
						} catch (Exception e) {
							
						
						}
							
						}else if(잡화점.주인공_공격아이템[1].equals("시라소니의눈물")) {
							
							System.out.println("============================================");
							System.out.println("  1.[스킬]시라소니의 불꽃하이킥(공격력 100) | 2.이전메뉴  ");
							System.out.println("============================================");
		
							int 스킬버튼 = scan.nextInt();  //nextLine으로 했으면 개행문자때문에 맨 위 메뉴 나옴...
							try {
								if(스킬버튼==1) {
									if(스킬사용 == true || 쿨타임.getState() == Thread.State.TERMINATED){ //중복방지용 or 조건쓰면 쿨타임.getState() == Thread.State.TERMINATED 되면 다시 실행가능
									System.out.println("["+주인공.get이름()+"] 내 안에 시라소니 형님이 계신 듯한 느낌을 받는다.");
									System.out.println("[스킬] 시라소니의 불꽃 하이킥!!!!");
									가미소리.set체력(가미소리.get체력()-스킬_이정재의핵펀치(100));
									if(가미소리.get체력()>0) {
										System.out.println(가미소리.get이름()+"가 스킬데미지 -100을 입었습니다.");
										System.out.println("[시스템] "+가미소리.get이름()+"체력이 "+가미소리.get체력()+"남았습니다."); 
										가미소리.가미소리상태창();
										스킬_불꽃하이킥쿨타임();
										주인공사망(잡화점);
										
										
									}else if(가미소리.get체력()<=0) {
										가미소리공격.interrupt();
										가미소리등장음.close();
										가미소리.가미소리사망(주인공,가미소리);
										break;
										}
									스킬사용 = false;
									
									}else if(스킬사용 == false) {

										if(쿨타임.getState() == Thread.State.TIMED_WAITING) {
											System.out.println("[시스템] 쿨타임이 종료되지 않았습니다.");

											스킬사용 =false;
										}
								
									}
							}else if(스킬버튼==2) {
								
							}
						} catch (Exception e) {
							
						
						}
						}
				}else if(잡화점.주인공_공격아이템[1] == null) {
					System.out.println("[시스템] 사용가능한 스킬이 없습니다.");
					
				}
				}else if(input1 == 3) {
					가미소리공격.interrupt();
					가미소리등장음.close();
					System.out.println(get이름()+"은 무서워서 도망갔다.");
					break;
				} //큰 if end
			}//while end
			//도망가거나 제압했을떄 일루나옴..
			if(가미소리.get체력()>0) {
				//도망가기 눌렀을때 하야시방으로 바로 안가지게...
			}else if(가미소리.get체력()<=0) {
				System.out.println("[시스템] 방에 하야시는 없다.");
			
		}
		} // 가미소리 공격하다 end
		
	public void 하야시와전투하다(우미관 우미관,주인공 주인공, 야쿠자 야쿠자,하야시 하야시, 가미소리 가미소리, 시바루 시바루, 잡화점 잡화점) {
		Music 하야시등장음 = new Music("HAYASI.mp3",true);
		하야시.set체력(500);  //스킬부분 + 나갔다가 돌아오면 피풀로 채워져있게.
		하야시.set소지금(100000); //등장할때 마다 소지금 바뀌게.
		하야시등장음.start();
		System.out.println("[디버프:중압감]엄청난 중압감으로 인해 주눅들었습니다.(공격력1/4감소)");
		하야시.하야시상태창();
		
		Thread 하야시공격 = new Thread(new Runnable() {
			//적 자동공격 쓰레드~~
			@Override
			public void run() {
				int 데미지1 = (주인공.get방어력()/2)-하야시.get공격력(); //데미지 계산.
//				하야시.하야시상태창();  
				try {
					while(하야시.get체력()>=0 || 주인공.get체력()>=0) {
					if(하야시.get체력()>0) {
						Thread.sleep(2000);
						if(주인공.get방어력()/2 > 하야시.get공격력()) { //주인공 방어력이 몹 공격력보다 높으면 체력이 +되는 거 방지.
							주인공.set체력(주인공.get체력()-1); 
							System.out.println("[시스템] "+하야시.get이름()+"가 공격하여 "+-1+"의 피해를 입혔습니다.");
							주인공.주인공상태창();
						}else if(주인공.get방어력()/2 <= 하야시.get공격력()) {
							주인공.set체력(주인공.get체력()+(주인공.get방어력()/2)-하야시.get공격력());
							System.out.println("[시스템] "+하야시.get이름()+"가 공격하여 "+데미지1+"의 피해를 입혔습니다.");
							주인공.주인공상태창();
						}//else if end
						
						하야시.스킬_그림자베기(주인공, 잡화점); //하야시 스킬
						하야시.스킬_심장찌르기(주인공, 잡화점);
						}if(하야시.get체력()<=0) {
							하야시등장음.close();
							하야시.하야시사망(주인공,하야시);
							break;
						}else if(주인공.get체력()<=0) {
							하야시등장음.close();
							주인공.주인공사망(잡화점);
							break;
						}
					}//while end
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				
			}
		});
		하야시공격.setDaemon(true);
		하야시공격.start();
		

		while(get체력() != 0) {	//죽을떄까지 싸우게.
			System.out.println("=======================================");
			System.out.println("  1.공격하다.|  2.스킬을 사용한다. | 3.도망간다. ");
			System.out.println("=======================================");
			
			int input1 = scan.nextInt();
				
				if(input1 == 1) {
						//주인공이 떄림.
						if(하야시.get체력() > 0) {
							하야시.set체력(하야시.get체력()+(하야시.get방어력()/2)-공격하다(get공격력()));
							int 데미지 = (하야시.get방어력()/2)-get공격력(); //데미지 계산.
								System.out.println("[시스템] "+get이름()+"이 공격하여 "+데미지+"의 피해를 입혔습니다.");
							하야시.하야시상태창();  
	
							주인공사망(잡화점);
							
							if(하야시.get체력()>0) { //체력 -안되게 하려고 만듦.
							System.out.println("[시스템] "+하야시.get이름()+"체력이 "+하야시.get체력()+"남았습니다."); 
								
							}else if(하야시.get체력() <= 0) {
								하야시공격.interrupt();
								하야시등장음.close();
								하야시.하야시사망(주인공,하야시);
								break; //브레이크 있어야 죽였을때 공격메뉴 안나옴.
																
						}			
						} //야쿠자 end
				}else if(input1 == 2) { //스킬공격
					
					
					if(잡화점.주인공_공격아이템[1] != null) {
						if(잡화점.주인공_공격아이템[1].equals("김무옥의벨트")) {
							System.out.println("========================================");
							System.out.println("  1.[스킬]김무옥의 박치기(공격력 40) | 2.이전메뉴  ");
							System.out.println("========================================");
		
							int 스킬버튼 = scan.nextInt();  //nextLine으로 했으면 개행문자때문에 맨 위 메뉴 나옴...
						try {
							if(스킬버튼==1) {
								if(스킬사용 == true || 쿨타임.getState() == Thread.State.TERMINATED){ //중복방지용 or 조건쓰면 쿨타임.getState() == Thread.State.TERMINATED 되면 다시 실행가능
								System.out.println("["+get이름()+"] 내 안에 무옥이가 들어온 듯한 느낌을 받는다.");
								System.out.println("[스킬] 김무옥의 박치기!!!!");
								하야시.set체력(하야시.get체력()-스킬_김무옥의박치기(40)); //적 체력감소부분
								if(하야시.get체력()>0) {
									System.out.println(하야시.get이름()+"가 스킬데미지 -40을 입었습니다.");
									System.out.println("[시스템] "+하야시.get이름()+"체력이 "+하야시.get체력()+"남았습니다."); 
									하야시.하야시상태창();
									스킬_박치기쿨타임();

									주인공사망(잡화점);
									
								}else if(하야시.get체력()<=0) {
									하야시공격.interrupt();
									하야시등장음.close();
									하야시.하야시사망(주인공,하야시);
									break;
									}
								
								스킬사용 = false;
								
								}else if(스킬사용 == false) {

									if(쿨타임.getState() == Thread.State.TIMED_WAITING) {
										System.out.println("[시스템] 쿨타임이 종료되지 않았습니다.");

										스킬사용 =false;
									}
							
								}
							}else if(스킬버튼==2) {
								
							}
						}
						 catch (Exception e) {
							
						
						}
						}else if(잡화점.주인공_공격아이템[1].equals("신마적의조끼")) {
							
							System.out.println("=========================================");
							System.out.println("  1.[스킬]신마적의 돌려차기(공격력 60) | 2.이전메뉴  ");
							System.out.println("=========================================");
		
							int 스킬버튼 = scan.nextInt();  //nextLine으로 했으면 개행문자때문에 맨 위 메뉴 나옴...
						try {
							if(스킬버튼==1) {
								if(스킬사용 == true || 쿨타임.getState() == Thread.State.TERMINATED){ //중복방지용 or 조건쓰면 쿨타임.getState() == Thread.State.TERMINATED 되면 다시 실행가능
								System.out.println("["+get이름()+"] 내 안에 신마적이 들어온 듯한 느낌을 받는다.");
								System.out.println("[스킬] 신마적의 돌려차기!!!!");
								하야시.set체력(하야시.get체력()-스킬_신마적의돌려차기(60));
								if(하야시.get체력()>0) {
									System.out.println(하야시.get이름()+"가 스킬데미지 -60을 입었습니다.");
									System.out.println("[시스템] "+하야시.get이름()+"체력이 "+하야시.get체력()+"남았습니다."); 
									하야시.하야시상태창();
									스킬_돌려차기쿨타임();
									주인공사망(잡화점);
									
									
								}else if(하야시.get체력()<=0) {
									하야시공격.interrupt();
									하야시등장음.close();
									하야시.하야시사망(주인공,하야시);
									break;
									}
								스킬사용 = false;
								
								}else if(스킬사용 == false) {

									if(쿨타임.getState() == Thread.State.TIMED_WAITING) {
										System.out.println("[시스템] 쿨타임이 종료되지 않았습니다.");

										스킬사용 =false;
									}
							
								}
							}else if(스킬버튼==2) {
								
							}
						}
						 catch (Exception e) {
							
						
						}
						}else if(잡화점.주인공_공격아이템[1].equals("이정재의경찰뱃지")) {
							
							System.out.println("=========================================");
							System.out.println("  1.[스킬]이정재의 핵펀치(공격력 80) | 2.이전메뉴  ");
							System.out.println("=========================================");
		
							int 스킬버튼 = scan.nextInt();  //nextLine으로 했으면 개행문자때문에 맨 위 메뉴 나옴...
							try {
							if(스킬버튼==1) {
								if(스킬사용 == true || 쿨타임.getState() == Thread.State.TERMINATED){ //중복방지용 or 조건쓰면 쿨타임.getState() == Thread.State.TERMINATED 되면 다시 실행가능
								System.out.println("["+get이름()+"] 내 안에 정재가 있는 듯한 느낌을 받는다.");
								System.out.println("[스킬] 이정재의 핵펀치!!!!");
								하야시.set체력(하야시.get체력()-스킬_이정재의핵펀치(80));
								if(하야시.get체력()>0) {
									System.out.println(하야시.get이름()+"가 스킬데미지 -80을 입었습니다.");
									System.out.println("[시스템] "+하야시.get이름()+"체력이 "+하야시.get체력()+"남았습니다."); 
									하야시.하야시상태창();
									스킬_핵펀치쿨타임();
								
									주인공사망(잡화점);
									
									
								}else if(하야시.get체력()<=0) {
									하야시공격.interrupt();
									하야시등장음.close();
									하야시.하야시사망(주인공,하야시);
									break;
									}
								
								스킬사용 = false;
								
								}else if(스킬사용 == false) {

									if(쿨타임.getState() == Thread.State.TIMED_WAITING) {
										System.out.println("[시스템] 쿨타임이 종료되지 않았습니다.");

										스킬사용 =false;
									}
							
								}
							}else if(스킬버튼==2) {
								
							}
						} catch (Exception e) {
							
						
						}
							
						}else if(잡화점.주인공_공격아이템[1].equals("시라소니의눈물")) {
							
							System.out.println("============================================");
							System.out.println("  1.[스킬]시라소니의 불꽃하이킥(공격력 100) | 2.이전메뉴  ");
							System.out.println("============================================");
		
							int 스킬버튼 = scan.nextInt();  //nextLine으로 했으면 개행문자때문에 맨 위 메뉴 나옴...
							try {
								if(스킬버튼==1) {
									if(스킬사용 == true || 쿨타임.getState() == Thread.State.TERMINATED){ //중복방지용 or 조건쓰면 쿨타임.getState() == Thread.State.TERMINATED 되면 다시 실행가능
									System.out.println("["+주인공.get이름()+"] 내 안에 시라소니 형님이 계신 듯한 느낌을 받는다.");
									System.out.println("[스킬] 시라소니의 불꽃 하이킥!!!!");
									하야시.set체력(하야시.get체력()-스킬_이정재의핵펀치(100));
									if(하야시.get체력()>0) {
										System.out.println(하야시.get이름()+"가 스킬데미지 -100을 입었습니다.");
										System.out.println("[시스템] "+하야시.get이름()+"체력이 "+하야시.get체력()+"남았습니다."); 
										하야시.하야시상태창();
										스킬_불꽃하이킥쿨타임();
										주인공사망(잡화점);
										
										
									}else if(하야시.get체력()<=0) {
										하야시공격.interrupt();
										하야시등장음.close();
										하야시.하야시사망(주인공,하야시);
										//System.out.println("게임 끝");  //게임끝나는 부분 설정해야함.
										break;
										}
									스킬사용 = false;
									
									}else if(스킬사용 == false) {

										if(쿨타임.getState() == Thread.State.TIMED_WAITING) {
											System.out.println("[시스템] 쿨타임이 종료되지 않았습니다.");

											스킬사용 =false;
										}
								
									}
							}else if(스킬버튼==2) {
								
							}
						} catch (Exception e) {
							
						
						}
						}
				}else if(잡화점.주인공_공격아이템[1] == null) {
					System.out.println("[시스템] 사용가능한 스킬이 없습니다.");
					
				}
				}else if(input1 == 3) {
					하야시공격.interrupt();
					하야시등장음.close();
					System.out.println(get이름()+"은 무서워서 도망갔다.");
					break;
				} //큰 if end
				//하야시 치면 일루 넘어옴
		}//while end!!!
		if(하야시.get체력()>0) {
			//도망가기 눌렀을때 밖으루
		}else if(하야시.get체력()<=0) {
			
			System.out.println("하야시를 물리쳤다!! 끝!!");//하야시 죽이거나 도망가면 일루나옴
	
	}
	}//하야시 end

	
	public void 주인공사망(잡화점 잡화점) {   //병원에 있으면 안됨.
		Music 게임오버음 = new Music("GAMEOVERBGM.mp3", false);
		
		Music 대사효과음 = new Music("KEYSOUND1.mp3", false);
		if(get체력() <= 0) {
			
			System.out.println("[시스템]"+get이름()+"가 대결에서 졌습니다.");	
			System.out.println("[시스템]"+get이름()+"는 목숨값으로 전부를 빼앗겼습니다.");

			Thread 사망시대사 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						String 사망시대사 = "나는 안되는 놈이구나....";
						for(int i=0; i<사망시대사.length(); i++) {
							Thread.sleep(100);
							System.out.print(사망시대사.charAt(i));
						}
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			});
			try {
				대사효과음.start();
				Thread.sleep(1000);
				System.out.print("["+get이름()+"] ");
				사망시대사.start();
				사망시대사.join();
				대사효과음.close();
				게임오버음.start();
				 System.out.println();
				 Thread.sleep(500);
				 System.out.println();
				 Thread.sleep(500);
				 System.out.println("     ▒▒▒▒▒▒▒         ▒▒▒▒       ▒▒▒▒      ▒▒▒▒    ▒▒▒▒▒▒▒▒▒▒     ▒▒▒▒▒▒▒▒    ▒▒        ▒▒    ▒▒▒▒▒▒▒▒▒▒    ▒▒▒▒▒▒▒▒▒▒                   ");
				 Thread.sleep(500);
				 System.out.println("   ▒▒       ▒▒      ▒▒  ▒▒      ▒▒ ▒▒    ▒▒ ▒▒    ▒▒            ▒▒      ▒▒   ▒▒        ▒▒    ▒▒            ▒▒        ▒▒             ");
				 Thread.sleep(500);
				 System.out.println("   ▒▒       ▒▒     ▒▒    ▒▒     ▒▒  ▒▒  ▒▒  ▒▒    ▒▒            ▒▒      ▒▒   ▒▒        ▒▒    ▒▒            ▒▒        ▒▒          ");
				 Thread.sleep(500);
				 System.out.println("   ▒▒       ▒▒    ▒▒      ▒▒    ▒▒   ▒▒▒▒   ▒▒    ▒▒            ▒▒      ▒▒   ▒▒        ▒▒    ▒▒            ▒▒        ▒▒        ");
				 Thread.sleep(500);
				 System.out.println("   ▒▒             ▒▒▒▒▒▒▒▒▒▒    ▒▒    ▒▒    ▒▒    ▒▒▒▒▒▒▒▒▒▒    ▒▒      ▒▒   ▒▒        ▒▒    ▒▒▒▒▒▒▒▒▒▒    ▒▒▒▒▒▒▒▒▒▒                   ");
				 Thread.sleep(500);
				 System.out.println("   ▒▒     ▒▒▒▒    ▒▒      ▒▒    ▒▒    ▒▒    ▒▒    ▒▒            ▒▒      ▒▒    ▒▒      ▒▒     ▒▒            ▒▒        ▒▒           ");
				 Thread.sleep(500);
				 System.out.println("   ▒▒       ▒▒    ▒▒      ▒▒    ▒▒          ▒▒    ▒▒            ▒▒      ▒▒     ▒▒    ▒▒      ▒▒            ▒▒        ▒▒        ");
				 Thread.sleep(500);
				 System.out.println("   ▒▒       ▒▒    ▒▒      ▒▒    ▒▒          ▒▒    ▒▒            ▒▒      ▒▒      ▒▒  ▒▒       ▒▒            ▒▒        ▒▒       ");
				 Thread.sleep(500);
				 System.out.println("     ▒▒▒▒▒▒▒      ▒▒      ▒▒    ▒▒          ▒▒    ▒▒▒▒▒▒▒▒▒▒     ▒▒▒▒▒▒▒▒         ▒▒         ▒▒▒▒▒▒▒▒▒▒    ▒▒        ▒▒     ");
				 게임오버음.close();
				 System.exit(0);
			} catch (Exception e) {
				// TODO: handle exception
			}
		
			}
	
	}
	
	
	//체육관에서 능력치 향상되는부분
	//주인공 체력증가하는 부분 (한번에 2씩올려줌)
	public void 줄넘기(주인공 주인공) {
		Music 줄넘기효과음 = new Music("JUL4.mp3", false);
		System.out.println("[관장] 줄넘기는 체력증가하는데 효과적이지!");
		if(주인공.get체력()<200) {
			줄넘기효과음.start();
			try {
				for(int i=0; i<7;i++) {
					Thread.sleep(500);
					System.out.print("▶▶▶▶▶");
				}
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			System.out.print("[훈련완료]");
			줄넘기효과음.close();
			System.out.println();
			주인공.set체력(주인공.get체력()+2);
			최대체력 = 주인공.get체력();   //주인공 최대체력을 변수에 담음.
			System.out.println("["+주인공.get이름()+"] 힘들어 죽겠구만.." );
			System.out.println("[시스템] 체력이 +2상승하여 "+주인공.get체력()+"이 되었습니다.");
			//너무 빨리끝나서 조금 딜레이.
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}else if(주인공.get체력()>=200){
			System.out.println("능력치가 이미 한계치까지 도달하였습니다.");
			주인공.set체력(200);
		
		}
	}
	
	//주인공 공격력증가하는 부분
	public void 샌드백(주인공 주인공) {
		Music 샌드백효과음 = new Music("SANDBACK4.mp3", false);
		System.out.println("[관장] 샌드백은 공격력증가하는데 효과적이지!");
		if(주인공.get공격력()<190) {
			샌드백효과음.start();
			try {
				for(int i=0;i<7;i++) {
					Thread.sleep(500);
					System.out.print("▶▶▶▶▶");
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.print("[훈련완료]");
			샌드백효과음.close();
			System.out.println();
			주인공.set공격력(주인공.get공격력()+1);
			System.out.println("["+주인공.get이름()+"] 주먹이 터질 것 같다." );
			System.out.println("[시스템] 공격력이 +1상승하여 "+주인공.get공격력()+"이 되었습니다.");
			//너무 빨리끝나서 조금 딜레이.
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if(주인공.get공격력()>=190){
			System.out.println("능력치가 이미 한계치까지 도달하였습니다.");
			주인공.set공격력(190);
		}
	}
	
	//주인공 방어력증가하는 부분
	public void 스파링(주인공 주인공) {
		Music 스파링효과음 = new Music("SANDBACK4.mp3", false);
		System.out.println("[관장] 스파링은 방어력올리는데 효과적이지!");
		if(주인공.get방어력()<190) {
			스파링효과음.start();
			try {
				for(int i=0;i<7;i++) {
					Thread.sleep(500);
					System.out.print("▶▶▶▶▶");
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.print("[훈련완료]");
			스파링효과음.close();
			System.out.println();
			주인공.set방어력(주인공.get방어력()+1);
			System.out.println("["+주인공.get이름()+"] 맞은 부위가 너무 아프다." );
			System.out.println("[시스템] 방어력이 +1상승하여 "+주인공.get방어력()+"이 되었습니다.");
			//너무 빨리끝나서 조금 딜레이.
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if(주인공.get방어력()>=190){
			System.out.println("능력치가 이미 한계치까지 도달하였습니다.");
			주인공.set방어력(190);
		}
	}
	//병원에 필요기능
	public void 회복하다(주인공 주인공) {
		//돈이 있어야 치료받음.
		Music 회복음 = new Music("RECOVERY.mp3",false);
		if(주인공.get소지금() >=300) {
			System.out.println("[의사] 가격은 300원 입니다.");
			회복음.start();
			for(int i=0; i<13; i++) {
				try {
					Thread.sleep(100);
					System.out.print("▶▶▶▶▶▶▶");
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			try {
				Thread.sleep(500);
				System.out.print("[회복완료]");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println();
			System.out.println("[시스템] 체력이 "+(최대체력-주인공.get체력())+"만큼 회복했습니다."); //최대체력에서 피 단만큼 채우기.
			회복음.close();
			주인공.set체력(최대체력); 
			주인공.set소지금(주인공.get소지금()-300);
			System.out.println("[시스템] 소지금에서 300원이 지불됩니다. 잔액 :"+주인공.get소지금()+"원");
			
		}//돈없으면 치료 못받게
		else if(주인공.get소지금() <300) {
			System.out.println("[의사] 돈없으면 길거리에 가서 죽으슈!!!!");
			System.out.println("[시스템] 병원에서 추방당했습니다.");
		}
		
	} //병원 end
	
	//스킬쿨타임
	public void 스킬_박치기쿨타임() {
		 쿨타임 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						
							for(int i=5; i>0; i--) {
								int 쿨타임 =i;
								Thread.sleep(1000);
								System.out.println("[스킬 쿨타임 ] "+i+"초 남았습니다.");	
								if(쿨타임 == 1) {
									Thread.sleep(1000);
									System.out.println("[스킬사용 가능]");
									
								}
							}// for end
			
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
					
				}
			});
			 쿨타임.start();
		
	}
	
	public void 스킬_돌려차기쿨타임() {
		 쿨타임 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						
							for(int i=7; i>0; i--) {
								int 쿨타임 =i;
								Thread.sleep(1000);
								System.out.println("[스킬 쿨타임 ] "+i+"초 남았습니다.");	
								if(쿨타임 == 1) {
									Thread.sleep(1000);
									System.out.println("[스킬사용 가능]");
									
								}
							}// for end
			
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
					
				}
			});
			 쿨타임.start();
		
	}
	
	public void 스킬_핵펀치쿨타임() {
		 쿨타임 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						
							for(int i=8; i>0; i--) {
								int 쿨타임 =i;
								Thread.sleep(1000);
								System.out.println("[스킬 쿨타임 ] "+i+"초 남았습니다.");	
								if(쿨타임 == 1) {
									Thread.sleep(1000);
									System.out.println("[스킬사용 가능]");
									
								}
							}// for end
			
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
					
				}
			});
			 쿨타임.start();
		
	}
	
	public void 스킬_불꽃하이킥쿨타임() {
		 쿨타임 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						
							for(int i=5; i>0; i--) {
								int 쿨타임 =i;
								Thread.sleep(1000);
								System.out.println("[스킬 쿨타임 ] "+i+"초 남았습니다.");	
								if(쿨타임 == 1) {
									Thread.sleep(1000);
									System.out.println("[스킬사용 가능]");
									
								}
							}// for end
			
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
					
				}
			});
			 쿨타임.start();
		
	}
	//스킬 
	public int 스킬_김무옥의박치기(int 데미지) {

		return 데미지;
	}
	public int 스킬_신마적의돌려차기(int 데미지) {
		
		return 데미지;
		
	}
	
	public int 스킬_이정재의핵펀치(int 데미지) {
		
		return 데미지;
		
	}
	
	public int 스킬_시라소니의불꽃하이킥(int 데미지) {
		
		return 데미지;
		
	}
	
	//아이템 장착
	//장착시 능력치 향상 & 제거시 능력치 원복.
	public void 면장갑장착(주인공 주인공스텟) {

		주인공스텟.set소지금(주인공스텟.get소지금() - 5000);
		주인공스텟.set공격력(주인공스텟.get공격력()+3);
		
	}
	
	public void 목장갑장착(주인공 주인공스텟) {

		주인공스텟.set소지금(주인공스텟.get소지금() - 10000);
		주인공스텟.set공격력(주인공스텟.get공격력()+7);
		
	}
	
	public void 가죽장갑장착(주인공 주인공스텟) {

		주인공스텟.set소지금(주인공스텟.get소지금() - 30000);
		주인공스텟.set공격력(주인공스텟.get공격력()+15);
		
	}
	
	public void 해골장갑장착(주인공 주인공스텟) {

		주인공스텟.set소지금(주인공스텟.get소지금() - 50000);
		주인공스텟.set공격력(주인공스텟.get공격력()+20);
		
	}

	//제거시 능력치 중복향상 방지
	public void 면장갑제거(주인공 주인공스텟) {

		주인공스텟.set공격력(주인공스텟.get공격력()-3);
		
	}
	
	public void 목장갑제거(주인공 주인공스텟) {

		주인공스텟.set공격력(주인공스텟.get공격력()-7);
		
	}
	
	public void 가죽장갑제거(주인공 주인공스텟) {

		주인공스텟.set공격력(주인공스텟.get공격력()-15);
		
	}
	
	public void 해골장갑제거(주인공 주인공스텟) {

		주인공스텟.set공격력(주인공스텟.get공격력()-20);
		
	}

	//장착시 능력치 향상
	public void 김무옥의벨트장착(주인공 주인공스텟) {

		주인공스텟.set소지금(주인공스텟.get소지금() - 20000);
		주인공스텟.set공격력(주인공스텟.get공격력()+20);
		
	}
	
	public void 신마적의조끼장착(주인공 주인공스텟) {

		주인공스텟.set소지금(주인공스텟.get소지금() - 40000);
		주인공스텟.set공격력(주인공스텟.get공격력()+30);
		
	}
	
	public void 이정재의경찰뱃지장착(주인공 주인공스텟) {

		주인공스텟.set소지금(주인공스텟.get소지금() - 60000);
		주인공스텟.set공격력(주인공스텟.get공격력()+40);
		
	}
	
	public void 시라소니의눈물장착(주인공 주인공스텟) {

		주인공스텟.set소지금(주인공스텟.get소지금() - 80000);
		주인공스텟.set공격력(주인공스텟.get공격력()+50);
		
	}
	
	//아이템 교체시 능력치 중복향상 제거
	public void 김무옥의벨트제거(주인공 주인공스텟) {

		주인공스텟.set공격력(주인공스텟.get공격력()-20);
		
	}
	
	public void 신마적의조끼제거(주인공 주인공스텟) {

		주인공스텟.set공격력(주인공스텟.get공격력()-30);
		
	}
	
	public void 이정재의경찰뱃지제거(주인공 주인공스텟) {

		주인공스텟.set공격력(주인공스텟.get공격력()-40);
		
	}
	
	public void 시라소니의눈물제거(주인공 주인공스텟) {

		주인공스텟.set공격력(주인공스텟.get공격력()-50);
		
	}
	
	//장착시 능력치 향상
		public void 중절모장착(주인공 주인공스텟) {
		
			주인공스텟.set소지금(주인공스텟.get소지금() - 3000);
			주인공스텟.set방어력(주인공스텟.get방어력()+2);
			
		}
		
		public void 화이트셔츠장착(주인공 주인공스텟) {
		
			주인공스텟.set소지금(주인공스텟.get소지금() - 5000);
			주인공스텟.set방어력(주인공스텟.get방어력()+4);
			
		}

		public void 정장장착(주인공 주인공스텟) {
		
			주인공스텟.set소지금(주인공스텟.get소지금() - 10000);
			주인공스텟.set방어력(주인공스텟.get방어력()+10);
		
		}

		public void 트렌치코트장착(주인공 주인공스텟) {
		
			주인공스텟.set소지금(주인공스텟.get소지금() - 50000);
			주인공스텟.set방어력(주인공스텟.get방어력()+20);
		
		}

		//교체시 능력치 중복향상 방지
		public void 중절모제거(주인공 주인공스텟) {
				
			주인공스텟.set방어력(주인공스텟.get방어력()-2);
			
		}
		
		public void 화이트셔츠제거(주인공 주인공스텟) {
		
			주인공스텟.set방어력(주인공스텟.get방어력()-4);
			
		}

		public void 정장제거(주인공 주인공스텟) {
			
			주인공스텟.set방어력(주인공스텟.get방어력()-10);
		
		}

		public void 트렌치코트제거(주인공 주인공스텟) {
				
			주인공스텟.set방어력(주인공스텟.get방어력()-20);
		
		}
	
		public void 음이온목걸이장착(주인공 주인공스텟) {

			주인공스텟.set소지금(주인공스텟.get소지금() - 3000);
			주인공스텟.set방어력(주인공스텟.get방어력()+2);
			주인공스텟.set체력(주인공스텟.get체력()+10);
			
		}
		
		public void 은목걸이장착(주인공 주인공스텟) {
		
			주인공스텟.set소지금(주인공스텟.get소지금() - 5000);
			주인공스텟.set방어력(주인공스텟.get방어력()+4);
			주인공스텟.set체력(주인공스텟.get체력()+20);
			
		}

		public void 화이트골드목걸이장착(주인공 주인공스텟) {

			주인공스텟.set소지금(주인공스텟.get소지금() - 10000);
			주인공스텟.set방어력(주인공스텟.get방어력()+10);
			주인공스텟.set체력(주인공스텟.get체력()+30);
		
		}

		public void 금목걸이장착(주인공 주인공스텟) {
			
			주인공스텟.set소지금(주인공스텟.get소지금() - 50000);
			주인공스텟.set방어력(주인공스텟.get방어력()+20);
			주인공스텟.set체력(주인공스텟.get체력()+40);
		
		}
		
		public void 음이온목걸이제거(주인공 주인공스텟) {

			주인공스텟.set방어력(주인공스텟.get방어력()-2);
			주인공스텟.set체력(주인공스텟.get체력()-10);
			
		}
		
		public void 은목걸이제거(주인공 주인공스텟) {
			
			주인공스텟.set방어력(주인공스텟.get방어력()-4);
			주인공스텟.set체력(주인공스텟.get체력()-20);
			
		}
		
		public void 화이트골드목걸이제거(주인공 주인공스텟) {

			주인공스텟.set방어력(주인공스텟.get방어력()-10);
			주인공스텟.set체력(주인공스텟.get체력()-30);
		
		}
		
		public void 금목걸이제거(주인공 주인공스텟) {
			
			주인공스텟.set방어력(주인공스텟.get방어력()-20);
			주인공스텟.set체력(주인공스텟.get체력()-40);
		
		}
		
		
}//main end
