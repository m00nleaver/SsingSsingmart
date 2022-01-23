package com.java.project.mart;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
/**
 * IdNew 클래스입니다.
 * 회원가입을 통해 고객의 정보를 저장합니다.
 * @author 이정현
 */
public class IdNew { // 회원가입

	/**
	 * 회원가입메뉴 실행 메소드
	 */
	public static void idNewRun() {
		System.out.println(title.IDNEW);
		System.out.println("\n지금 편리한 배송, 씽씽마트의 회원이 되세요!\n\n내용은 순서대로 입력해주세요.\n");
		
		
		
		// 1. 아이디 (영소문자, 숫자만, 4~12자리, 중복없음, 관리자 admin)
		Scanner scan = new Scanner(System.in);
		String id;
		do {			
			System.out.print("아이디 : ");
			id = scan.nextLine();
		} while (!isvalidmember(id));
		
		
		// 2. 비밀번호 (4~10자, 영어대문자/소문자, 숫자 가능, 영어 대소문자 구분, 조건x경고메시지+다시입력)
		String password;
		do {			
			System.out.print("비밀번호 : ");
			password = scan.nextLine();
		} while (!isPasswd(password));

		
		// 3. 이름 (2~4자, 한글만, 조건x경고메시지+다시입력)
		String name;
		do {			
			System.out.print("이름: ");
			name = scan.nextLine();
		} while (!isName(name));


		// 4. 나이 (1~2자, 99세까지)
		String age;
		
		do {			
			System.out.print("나이: ");
			age = scan.nextLine();
		} 
		while (!isAge(age));
		
		
		// 5. 전화번호(0-9자리, -유무 상관없이, 오류메세지+다시입력)
		String tel;
		do {
			System.out.print("전화번호: 010-");
			tel = scan.nextLine();
			if (tel.length() == 9) {
				tel = "010-" + tel;
			} else if (tel.length() == 8) {
				tel = "010-" + tel.substring(0, 4) + "-" + tel.substring(4, tel.length());
				System.out.println();
			}
		} while (!isTel(tel));

		
		
		// 6. 주소
		address();
		String address;
		do {			
			System.out.print("입력 : ");
			address = scan.nextLine();
		} while (!isAddress(address));
		
		
		// 7. 베지테리언옵션
		vegOption();
		String veg;
		do {			
			System.out.print("입력: ");
			veg = scan.nextLine();
		} while (!isVeg(veg));
		

		try {


			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.MEMBERDIR, true)); // 누적

			// 아이디, 비밀번호, 이름, 나이, 전화번호, 주소, 베지
			writer.write(String.format("%s,%s,%s,%s,%s,%s,%s\r\n", id, password, name, age, tel, address, veg));

			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		pause("회원가입이 완료되었습니다");

	}// main

	/**
	 * 회원가입시 전화번호 유효성 검사
	 * 조건 : 숫자 0 ~ 9, '-' 입력 유무 상관없음
	 * @param tel 전화번호 입력
	 * @return 입력실패 false, 입력성공시 true 반환 
	 */
	public static boolean isTel(String tel) {
		if (tel.length() == 13) {
			//010-1234-1234 == 13자리
			//010-123412345 == 13자리 (잘못된 기입) -> 처리
			
			String telExtra = tel.substring(4, tel.length()); //010- 이후 자리부터 잘라줌
			//4번째 자리가 '-'인지 검사
			//System.out.println(telExtra); //잘라진 telExtra 확인용
			if (telExtra.charAt(4) == '-') {
				
			} else {
				System.out.println("😥 입력하신 번호를 다시 확인해 주세요 😥");
				return false;
			}
		} else {
			System.out.println("😥 010을 제외한 핸드폰번호를 입력해주세요('-'포함 유무 상관없음) 😥");
			return false;
		}
		for (int i = 0; i < tel.length(); i++) {
			if ((tel.charAt(i) >= '0' && tel.charAt(i) <= '9') // 숫자
					|| (tel.charAt(i) == '-')) { 
			} else {
				System.out.println("😥 010을 제외한 핸드폰번호를 입력해주세요('-'포함 유무 상관없음) 😥");
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 회원가입시 주소 유효성 검사
	 * 조건 : 숫자 1 ~ 5 선택
	 * @param address 회원 주소
	 * @return 숫자 1~5 입력시 ture, 입력 실패시 false값 반환
	 */
	public static boolean isAddress(String address) {
		switch (address) {
		case "1":
		case "2":
		case "3":
		case "4":
			System.out.println();
			return true;
		case "5":
			System.out.println("\n기타지역은 배송 서비스를 제공하지 않습니다.\n추후 서비스 확대를 기대해주세요!");
			return true;
		default:
			System.out.println("😥 잘못입력했습니다. 숫자 1~5까지 입력해주세요 😥");
			return false;
		}
	}
	
	/**
	 * 회원가입시 아이디 유효성 검사
	 * 조건 : 아이디 중복 x, 영어 소문자+숫자만, 4 ~ 12자리
	 * @param id
	 * @return 입력 성공시 true, 실패시 false
	 */
	public static boolean isvalidmember(String id){

		File fileid = new File(Path.MEMBERDIR);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileid));

			String line = null;
			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				if (id.equals(temp[0])) {
					System.out.println("이미 존재하는 아이디입니다.");
					reader.close();
					return false;
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (id.length() >= 4 && id.length() <= 12) { // 4~12자 -> 요구사항

			for (int i = 0; i < id.length(); i++) {
				if ((id.charAt(i) >= 'a' && id.charAt(i) <= 'z') // 영어 소문자
						|| (id.charAt(i) >= '0' && id.charAt(i) <= '9')) { // 숫자0~9
				} else {
					System.out.println("😥 아이디는 영어소문자와 숫자만 입력해주세요 😥"); 
					// 중요 -> 아예 모든 조건을 언급해 줄지?, 다른 곳에서도 이런것들 추가할지?
					return false;
				}
			}
		} else {
			System.out.println("😥 아이디는 4~12자리를 입력해주세요 😥");
			return false;
		}
		return true;
	} 
	
	public static void vegOption() {

		System.out.println();
		System.out.println("저희 씽씽마트에서는 베지테리언옵션을 제공하고 있습니다!\n해당하는 옵션의 번호를 입력해주세요.");
		System.out.println();
		System.out.println("1. 플렉시테리언(🐮 🐷 🐓 🐟 🍳 🍼 🍎 🌿)");
		System.out.println("2. 폴로-페스코(🐓 🐟 🍳 🍼 🍎 🌿)");
		System.out.println("3. 페스코(🐟 🍳 🍼 🍎 🌿)");
		System.out.println("4. 락토-오보(🍳 🍼 🍎 🌿)");
		System.out.println("5. 오보(🍳 🍎 🌿)");
		System.out.println("6. 락토(🍼 🍎 🌿)");
		System.out.println("7. 비건(🍎 🌿)");
		System.out.println("8. 프로테리언(🍎)");
		System.out.println();
	}
	
	/**
	 * 회원 가입시 나이 입력 유효성 검사
	 * 조건 : 정수 1 ~ 99까지 입력가능
	 * @param age 회원 나이
	 * @return 입력 성공시 true, 실패시 false
	 */
	public static boolean isAge(String age) {
		
		try {
			int Iage = Integer.parseInt(age); 
		if (Iage > 99 || Iage < 1) { 
			System.out.println("😥 죄송합니다. 회원가입은 연령은 1 ~ 99세까지입니다 😥");
			return false;
		} else {
			return true;
		}
		} catch (Exception e) {
			System.out.println("😥 회원가입은 연령은 1 ~ 99세이며 *정수*만 입력해주세요 😥");
			return false;
		}

	
	}
	
	/**
	 * 회원가입시 이름 유효성 검사
	 * 조건 : 2 ~ 4자, 한글만 입력 가능
	 * @param name 회원이름
	 * @return 입력성공시 true, 실패시 false
	 */
	public static boolean isName(String name) {
		if (name.length() >= 2 && name.length() <= 4) { // 2~4자

			for (int i = 0; i < name.length(); i++) {
				if (name.charAt(i) >= '가' && name.charAt(i) <= '힣') { // 한글
				} else {
					System.out.println("😥 이름은 한글만 입력해주세요 😥");
					return false;
				}
			}
		} else {
			System.out.println("😥 이름은 2~4자리를 입력해주세요 😥");
			return false;
		}
		return true;
	}
	
	/**
	 * 회원가입시 베지테리언 단계 설정
	 * @param veg 베지테리언 단계
	 * @return 정상입력시 ture, 입력 실패시 false;
	 */
	public static boolean isVeg(String veg) {
		switch (veg) {
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
			System.out.println();
			return true;
		default:
			System.out.println("😥 잘못입력했습니다. 숫자 1~8까지 입력해주세요 😥");
			return false;
		}
	}
	
	/**
	 * 회원가입시 비밀번호 유효성 검사
	 * @param password 비밀번호
	 * @return 입력 성공시 true, 실패시 false
	 */
	public static boolean isPasswd(String password) {
		if (password.length() >= 4 && password.length() <= 10) { // 4~10자

			for (int i = 0; i < password.length(); i++) {
				if ((password.charAt(i) >= 'A' && password.charAt(i) <= 'z') // 영어 대문자
						|| (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') // 영어 소문자
						|| (password.charAt(i) >= '0' && password.charAt(i) <= '9')) { // 숫자0~9
				} else {
					System.out.println("😥 비밀번호는 영어와 숫자만 입력해주세요 😥");
					return false;
				}
			}
		} else {
			System.out.println("😥 비밀번호는 4~10자리를 입력해주세요 😥");
			return false;
		}
		return true;
	}
	
	public static void address() {

		System.out.println();
		System.out.println("해당하는 옵션의 번호를 입력해주세요.");
		System.out.println();
		System.out.println("주소지");
		System.out.println("1. 남현동");
		System.out.println("2. 사당1동");
		System.out.println("3. 사당4동");
		System.out.println("4. 방배2동");
		System.out.println("5. 기타");
		System.out.println();
	}


	/**
	 * 사용자를 위한 멈추기 기능
	 * @param msg 특정 행동 완료후 안내 메세지 입력
	 */
	static void pause(String msg) {
		System.out.println(msg);
		System.out.println("계속하시려면 엔터키를 누르세요...");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
	}

}