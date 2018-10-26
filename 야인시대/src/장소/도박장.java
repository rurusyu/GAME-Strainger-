package 장소;

import java.util.Arrays;
import java.util.Scanner;

import 야인시대.Music;
import 캐릭터.주인공;

public class 도박장 extends 장소{
	Scanner scan = new Scanner(System.in);
	public 도박장(String 장소명) {
		super(장소명);
		// TODO Auto-generated constructor stub
	}

	
	
	
	public void 도박장내부(주인공 주인공) {
		//도박장 배경음만 넣기.
		Music 도박장음악 = new Music("CASINO.mp3", true);
		도박장음악.start();
		//게임종류별 설명넣기
		System.out.println("=====================================================[게임설명]=====================================================");
		System.out.println("  [바카라] 카드 2장의 합이 9에 가까운사람이 승리하며, 뱅커와 플레이어로 나눔. 뱅커와 플레이어 카드 2장의 합계가 같으면 타이로  8배의 보상금을 획득할 수 있다.");
		System.out.println("  [로또] 금액을 배팅하고 1~45까지 원하는 숫자 6개를 뽑고, 실시간 추첨을 통해 당첨여부 확인하며, 최대 2배의 보상금을 획득할 수 있다.");
		System.out.println("  [야바위] 금액을 배팅하고, 5개의 컵 중에 하나를 고르면, 컵속에 돌맹이 유무에 따른 당첨여부 확인하며, 최대 1배의 보상금을 획득할 수 있다.");
		System.out.println("=================================================================================================================");
		System.out.println("===========================================");
		System.out.println("  1:바카라 | 2:로또 | 3.야바위  | 4.나가기");
		System.out.println("===========================================");	
		int 도박선택 = scan.nextInt();  //최상위 메뉴에서 스캐너쓸때, int 인지 String인지 맞춰줘야함. 안에 사용하는 메소드 스캐너들도 맞춰줘야, 밖으로 갑자기 튕기는 일 안생김.
	while(주인공.get소지금() != 0) {
		if(도박선택==1) {
			바카라(주인공);
			도박장내부(주인공); //도박끝나고 이 메뉴로 계속오게 할때 쓰임.
		}else if(도박선택==2) {
			로또(주인공);
			도박장내부(주인공); //도박끝나고 이 메뉴로 계속오게 할때 쓰임.
			
		}else if(도박선택==3) {
			야바위(주인공);
			도박장내부(주인공);
						
		}else if(도박선택==4) {
			도박장음악.close();
			System.out.println("[시스템] 도박장을 나갔습니다.");
			break;
		}else {
			
		}
		도박장음악.close();
		break;
	}//while end
	
	}//도박장 내부 end
	
	public void 바카라(주인공 주인공) {

		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ[상금안내]ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println(" 뱅커에게 이기면 배팅금의 2배                                 ");
		System.out.println(" 뱅커와 타이시 배팅금의 8배            ");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		System.out.println("[뱅커] 실시간 로또를 즐겨볼까요~?");
		System.out.println("[뱅커] 배팅금액을 입력하세요.");
		System.out.println("[소지금] "+ 주인공.get소지금()+"원");
		System.out.print("[배팅금액] ");
		int 금액입력 = scan.nextInt();
		
		System.out.println();
		int[] 뱅커= new int[2];
		int[] 플레이어= new int[2];

		
		for(int i=0; i<2; i++) {
			
		    	뱅커[i] = (int)(Math.random()*10);
				플레이어[i] = (int)(Math.random()*10);
			
		}

		 int 플레이어카드합 = 플레이어[0]+플레이어[1];
		 int 뱅커카드합 = 뱅커[0]+뱅커[1]; 
			if(뱅커카드합 >=10) {
				뱅커카드합 =뱅커카드합 % 10;
			}
			if(플레이어카드합>=10) {
				플레이어카드합 = 플레이어카드합%10;
			}
			
			System.out.println("뱅커카드 합계 : "+ 뱅커카드합);
			System.out.println("플레이어카드 합계 : "+ 플레이어카드합);
			//카드값 비교.
			
			if(뱅커카드합==9) {
				System.out.println("[뱅커] 제가 승리했네요. 돈은 잘 가지겠습니다.");
				주인공.set소지금(주인공.get소지금()-금액입력);
				System.out.println("[소지금] "+주인공.get소지금());
			}else if(플레이어카드합 == 9) {
				System.out.println("[뱅커] 축하합니다. 배팅금액에  2배를 드리겠습니다. ");
				주인공.set소지금(주인공.get소지금()+금액입력*2);
				System.out.println("[소지금] "+주인공.get소지금());
			}else if(뱅커카드합 >= 플레이어카드합) {
				System.out.println("[뱅커] 제가 승리했네요. 돈은 잘 가지겠습니다.");
				주인공.set소지금(주인공.get소지금()-금액입력);
				System.out.println("[소지금] "+주인공.get소지금());
			}else if(플레이어카드합>뱅커카드합) {
				System.out.println("[뱅커] 축하합니다. 배팅금액에  2배를 드리겠습니다. ");
				주인공.set소지금(주인공.get소지금()+금액입력*2);
				System.out.println("[소지금] "+주인공.get소지금());
			}else if(플레이어카드합 == 뱅커카드합) {
				System.out.println("[뱅커] 무승부군요. 배팅금액에  8배를 드리겠습니다. ");
				주인공.set소지금(주인공.get소지금()+금액입력*8);
				System.out.println("[소지금] "+주인공.get소지금());
			}
			try {
				System.out.println("[뱅커] 카드를 오픈하겠습니다.");
				Thread.sleep(1000);
				System.out.println("뱅크카드 :"+Arrays.toString(뱅커));
				Thread.sleep(1000);
				System.out.println("플레이어카드 :"+Arrays.toString(플레이어));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		
	}
	
	public void 로또(주인공 주인공) {
		
	
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ[상금안내]ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println(" 1~3개 일치시 : 꽝                                            ");
		System.out.println(" 4개 일치시 : 배팅금액의 50%             ");
		System.out.println(" 5개 일치시 : 배팅금액의 100%             ");
		System.out.println(" 6개 일치시 : 배팅금액의 200%            ");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		System.out.println("[겜블러] 실시간 로또를 즐겨볼까요~?");
		System.out.println("[겜블러] 배팅금액을 입력하세요.");
		System.out.println("[소지금] "+ 주인공.get소지금()+"원");
		System.out.print("[배팅금액] ");
		int 금액입력 = scan.nextInt();
		
		System.out.println("[겜블러] 1~45까지 숫자 중 6개를 고르세요.");
		int[] 사용자지정번호  = new int[6];
		for(int i=0;i<6;i++) {
			System.out.println("[겜블러] 1~45까지 숫자 중 "+(i+1)+"번째 숫자를 고르세요.");
			int 로또숫자지정 = scan.nextInt();

			if(로또숫자지정 != 사용자지정번호[i]) {
				사용자지정번호[i] = 로또숫자지정;
			}else if(로또숫자지정 == 사용자지정번호[i]) {
				System.out.println("[겜블러] 이미 뽑은 수입니다. 다시 뽑으세요.");
			}
		}
			Arrays.sort(사용자지정번호);
			System.out.println("[선택하신 번호] "+Arrays.toString(사용자지정번호));
			
		int[] 공번호 = new int[45];
		int[] 결과 = new int[6];
		
		 for(int i=0, len = 공번호.length; i<len; i++){
			   
			 공번호[i] = i+1; //볼담기
			  
			  }

		 //기계뽑는기능
		 for(int i=0; i<6; i++) {
			 
			  int idx = (int)(Math.random()*45); 
			 			 
			 결과[i] = 공번호[idx]; //45개 중 6개 뽑은 번호 여기에 담음
			 
			 //중복된 번호 뽑았을 때 처리
			 if(공번호[idx] == -1) {
				 i--;
			 }
			 공번호[idx] = -1;
			 
		 }
		 
		 System.out.println("자자~ 이제 공을 뽑습니다.");
		  Arrays.sort(결과);
		 
		  System.out.print("[추첨된 공번호] ");
		  System.out.print(Arrays.toString(결과));
		  System.out.println();
		  if(사용자지정번호[0] == 결과[0] ) {
			  System.out.println("[겜블러] 아쉽게도 꽝이네요. 다음 기회에 도전하세요!");
			  주인공.set소지금(주인공.get소지금()-금액입력);
			  System.out.println("[소지금] "+주인공.get소지금());
		  }else if(사용자지정번호[0] == 결과[0] && 사용자지정번호[1] == 결과[1]) {
			  System.out.println("[겜블러] 아쉽게도 꽝이네요. 다음 기회에 도전하세요!");
			  주인공.set소지금(주인공.get소지금()-금액입력);
			  System.out.println("[소지금] "+주인공.get소지금());
		 }else if(사용자지정번호[0] == 결과[0] && 사용자지정번호[1] == 결과[1] && 사용자지정번호[2] == 결과[2]) {
			  System.out.println("[겜블러] 아쉽게도 꽝이네요. 다음 기회에 도전하세요!");
			  주인공.set소지금(주인공.get소지금()-금액입력);
			  System.out.println("[소지금] "+주인공.get소지금());
		  }else if(사용자지정번호[0] == 결과[0] && 사용자지정번호[1] == 결과[1] && 사용자지정번호[2] == 결과[2] && 사용자지정번호[3] == 결과[3] ) {
			  System.out.println("[겜블러] 4개 일치하셨네요!! 배팅금액에 50% 드리겠습니다.");
			  System.out.println("[시스템] "+금액입력/2+"원 만큼 벌었습니다.");
			  주인공.set소지금(주인공.get소지금()+(금액입력/2));
			  System.out.println("[소지금] "+주인공.get소지금());
		  }else if(사용자지정번호[0] == 결과[0] && 사용자지정번호[1] == 결과[1] && 사용자지정번호[2] == 결과[2] && 사용자지정번호[3] == 결과[3] && 사용자지정번호[4] == 결과[4] ) {
			  System.out.println("[겜블러] 5개 일치하셨네요!! 배팅금액에 100% 드리겠습니다.");
			  System.out.println("[시스템] "+금액입력+"원 만큼 벌었습니다.");
			  주인공.set소지금(주인공.get소지금()+(금액입력));
			  System.out.println("[소지금] "+주인공.get소지금());
		  }else if(사용자지정번호[0] == 결과[0] && 사용자지정번호[1] == 결과[1] && 사용자지정번호[2] == 결과[2] && 사용자지정번호[3] == 결과[3] && 사용자지정번호[4] == 결과[4] && 사용자지정번호[5] == 결과[5]) {
			  System.out.println("[겜블러] 6개 일치하셨네요!! 배팅금액에 100% 드리겠습니다.");
			  System.out.println("[시스템] "+금액입력*2+"원 만큼 벌었습니다.");
			  주인공.set소지금(주인공.get소지금()+(금액입력*2));
			  System.out.println("[소지금] "+주인공.get소지금());
		  }else {
			  System.out.println("[겜블러] 아쉽게도 꽝이네요. 다음기회에 도전하세요.");
			  주인공.set소지금(주인공.get소지금()-금액입력);
			  System.out.println("[소지금] "+주인공.get소지금());
		  }
	}//로또 end
	
	public void 야바위(주인공 주인공) {
		//대사 쓰레드
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ[상금안내]ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println(" 맞추면 배팅금의 1배                                 ");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		int 야바위 = (int)(Math.random() *5)+1 ; //난수 1~5까지.
		System.out.println("[겜블러] 야바위를 즐겨볼까요~?");
		System.out.println("[겜블러] 5개 중  돌이 들어있는 컵에 돈을 걸어 맞추면 걸은 금액만큼을 드립니다. 틀리면 건 금액 모두 잃습니다.");
		Thread 야바위섞기 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				 try {
					 
					 for(int i=0; i<5; i++) {
						 Thread.sleep(500);
						 System.out.print("∩");
					 }
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				
			}
		});
		try {
			System.out.println("[겜블러] 야바위를 섞는 중입니다.");
			System.out.println("[야바위 컵] ");
			야바위섞기.start();
			야바위섞기.join();
			System.out.println();
			System.out.println("[시스템] 거실 금액을 입력하세요.");
			System.out.println("[소지금] "+주인공.get소지금());
			System.out.print("[배팅금액] ");
			int 금액입력 = scan.nextInt();
				
				if(금액입력<=주인공.get소지금()) {
					System.out.println("[겜블러] 몇 번 컵에 거시겠습니까?");
					int 컵선택 = scan.nextInt();
					if(컵선택 == 야바위) {
						System.out.println("[겜블러] 저를 이겼군요.. 축하합니다.");
						주인공.set소지금(주인공.get소지금()+(금액입력));
						System.out.println("[소지금] "+주인공.get소지금());
						Thread.sleep(1000);
					}else if(컵선택 != 야바위) {
						System.out.println("[겜블러] 제가 이겼습니다. ㅎㅎㅎ ");
						System.out.println("[시스템] "+금액입력+ "원 만큼 잃었습니다");
						주인공.set소지금(주인공.get소지금()-금액입력); 
						System.out.println("[소지금] "+주인공.get소지금());
						Thread.sleep(1000);
						}
				}else if(금액입력 > 주인공.get소지금()) {
					
					System.out.println("[시스템] 가지고 있는 돈보다 큰 액수를 입력하셨습니다. 다시 입력해주십시오.");
			
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
			}//야바위 end
	
}