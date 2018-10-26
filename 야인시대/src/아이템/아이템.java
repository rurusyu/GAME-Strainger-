package 아이템;
//테스트용 클래스
public class 아이템 {
		//밑에 아이템들이 분류가 많아지면 사용하기 편하도록 부모클래스에서 생성자와 Get/Set 메소드 사용.
		String 아이템이름;
		int 공격력증가;
		int 방어력증가;
		int 가격;
		int 체력증가;
		public 아이템(String 아이템이름, int 공격력증가, int 방어력증가, int 가격, int 체력증가) {
			super();
			this.아이템이름 = 아이템이름;
			this.공격력증가 = 공격력증가;
			this.방어력증가 = 방어력증가;
			this.체력증가 = 체력증가;
			this.가격 = 가격;
		}

		public String get아이템이름() {
			return 아이템이름;
		}

		public int get체력증가() {
			return 체력증가;
		}

		public void set체력증가(int 체력증가) {
			this.체력증가 = 체력증가;
		}

		public void set아이템이름(String 아이템이름) {
			this.아이템이름 = 아이템이름;
		}

		public int get공격력증가() {
			return 공격력증가;
		}

		public void set공격력증가(int 공격력증가) {
			this.공격력증가 = 공격력증가;
		}

		public int get방어력증가() {
			return 방어력증가;
		}

		public void set방어력증가(int 방어력증가) {
			this.방어력증가 = 방어력증가;
		}

		public int get가격() {
			return 가격;
		}

		public void set가격(int 가격) {
			this.가격 = 가격;
		}
		
		
		
		
		}
