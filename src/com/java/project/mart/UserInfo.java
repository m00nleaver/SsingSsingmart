package com.java.project.mart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

//sowedzzpxk80,riBUyJ,임전지,79,010-3131-6325,5,3

//한명의 멤버 정보를 담기 위한 클래스
public class UserInfo {
	 private static ArrayList<UserInfo> UserInfoList;
	 private static Scanner scan;
	 private static BufferedReader reader;
	 
	 static {
		 UserInfoList = new ArrayList<UserInfo>();
		 scan = new Scanner(System.in);
		 try {
			reader = new BufferedReader(new FileReader(Path.MEMBERDIR));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	//멤버 구성
	//1. 멤버 변수 
	//-모든 자료형을 사용할 수 있다.
	
	//아이디 , 비밀번호 , 이름 , 나이 , 전화번호, 주소지, 단계 	
	public String id;
	public String password;
	public String name;
	public String age;
	public String tel;
	public String address;
	public String veg;
	
	public UserInfo() {
		this("","","","","","","");
	}
	
	
	
	
	public static void MemberInfo(String loginId) throws Exception {
		boolean loop = true;
		
		while (loop) {
			System.out.println("⌜ •   °    +   °   •   •   °    +   °   •   •   °    +   °   •   •   °    +   °   •  ⌝\n"
					+ "   ,-,--.       ,----.                   ,----.     _,.----.    ,--.--------.\n"
					+ " ,-.'-  _\\   ,-.--` , \\    _.-.       ,-.--` , \\  .' .' -   \\  /==/,  -   , -\\\n"
					+ "/==/_ ,_.'  |==|-  _.-`  .-,.'|      |==|-  _.-` /==/  ,  ,-'  \\==\\.-.  - ,-./\n"
					+ "\\==\\  \\     |==|   `.-. |==|, |      |==|   `.-. |==|-   |  .   `--`\\==\\- \\\n"
					+ " \\==\\ -\\   /==/_ ,    / |==|- |     /==/_ ,    / |==|_   `-' \\       \\==\\_ \\\n"
					+ " _\\==\\ ,\\  |==|    .-'  |==|, |     |==|    .-'  |==|   _  , |       |==|- |\n"
					+ "/==/\\/ _ | |==|_  ,`-._ |==|- `-._  |==|_  ,`-._ \\==\\.       /       |==|, |\n"
					+ "\\==\\ - , / /==/ ,     / /==/ - , ,/ /==/ ,     /  `-.`.___.-'        /==/ -/\n"
					+ " `--`---'  `--`-----``  `--`-----'  `--`-----``                      `--`--`\n"
					+ "\n"
					+ "⌞ °   •    +   •   °  °   •    +   •   °    °   •    +   •   °  °   •    +   •   °   ⌟\n");
			System.out.println(" "); 
			System.out.println(" "); 
			System.out.println(""); 
			System.out.println("원하시는 메뉴를 선택해주세요.");
			System.out.println("┌───────────────┐\r\n"
					+ " 1. 개인정보 조회\r\n"
					+ " 2. 개인정보 수정\r\n"
					+ " 3. 회원탈퇴\r\n"
					+ " 0. 이전화면\r\n"
					+ "└───────────────┘\r\n"
					+ "　　ᕱ ᕱ ||\r\n"
					+ "　 ( ･ω･ ||\r\n"
					+ "　 /　つΦ");
			
			System.out.print("번호 입력: ");
			String sel = scan.nextLine();
			
		
			
			if(sel.equals("1")) {
				System.out.println("개인정보 조회로 이동합니다.");
				list(MainFrame.loginId);
				
				
				loop = false;
			} else if (sel.equals("2")) {
				System.out.println("개인정보 수정으로 이동합니다.");
				edit(MainFrame.loginId);
				
				loop = false;
			} else if (sel.equals("3")) {
				System.out.println("회원탈퇴로 이동합니다.");
				delete(MainFrame.loginId);
				loop = false;
			} else if (sel.equals("0")) {
				MemberMainFrame.run(loginId);
			
			} else {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요");
			}
		}
	}

	private static void list(String loginId) throws Exception {
		System.out.println("⌜ •   °    +   °   •   •   °    +   °   •   •   °    +   °   •   •   °    +   °   •  ⌝\n"
				+ "                 ,-,--.       ,----.                    .=-.-.  .-._              _,---.      _,.---._\n"
				+ " .--.-. .-.-.  ,-.'-  _\\   ,-.--` , \\   .-.,.---.      /==/_ / /==/ \\  .-._    .-`.' ,  \\   ,-.' , -  `.\n"
				+ "/==/ -|/=/  | /==/_ ,_.'  |==|-  _.-`  /==/  `   \\    |==|, |  |==|, \\/ /, /  /==/_  _.-'  /==/_,  ,  - \\\n"
				+ "|==| ,||=| -| \\==\\  \\     |==|   `.-. |==|-, .=., |   |==|  |  |==|-  \\|  |  /==/-  '..-. |==|   .=.     |\n"
				+ "|==|- | =/  |  \\==\\ -\\   /==/_ ,    / |==|   '='  /   |==|- |  |==| ,  | -|  |==|_ ,    / |==|_ : ;=:  - |\n"
				+ "|==|,  \\/ - |  _\\==\\ ,\\  |==|    .-'  |==|- ,   .'    |==| ,|  |==| -   _ |  |==|   .--'  |==| , '='     |\n"
				+ "|==|-   ,   / /==/\\/ _ | |==|_  ,`-._ |==|_  . ,'.    |==|- |  |==|  /\\ , |  |==|-  |      \\==\\ -    ,_ /\n"
				+ "/==/ , _  .'  \\==\\ - , / /==/ ,     / /==/  /\\ ,  )   /==/. /  /==/, | |- |  /==/   \\       '.='. -   .'\n"
				+ "`--`..---'     `--`---'  `--`-----``  `--`-`--`--'    `--`-`   `--`./  `--`  `--`---'         `--`--''\n"
				+ "\n"
				+ "⌞ °   •    +   •   °  °   •    +   •   °    °   •    +   •   °  °   •    +   •   °  ⌟\n");
		
		
		BufferedReader reader = new BufferedReader(new FileReader(Path.MEMBERDIR));
		
		String line = null;
		
		System.out.println("┌──────────────────────────────────────┐");
		System.out.println("참고해주세요!");
		System.out.println("①플렉시테리언(🐮   🐷   🐔   🐠   🍳   🍼   🍎   🌿)");
		System.out.println("②폴로-페스코 ( 🐔   🐠   🍳   🍼   🍎   🌿)");	
		System.out.println("③페스코 ( 🐠   🍳   🍼   🍎   🌿)");
		System.out.println("④락토-오보 ( 🍳   🍼   🍎   🌿)");
		System.out.println("⑤오보( 🍳    🍎   🌿)");
		System.out.println("⑥락토( 🍼   🍎   🌿)");
		System.out.println("⑦비건( 🍎   🌿)");
		System.out.println("⑧프로테리언( 🍎)");
		System.out.println("└───────────────────────────────────────┘");
		System.out.println();
		
		System.out.println("[아이디]\t[비밀번호]\t[이름]\t[나이]\t[전화번호]\t[주소지]\t[베지테리언 단계]");
		
		while((line = reader.readLine())!= null) {
			if(loginId.equals(line.split(",")[0])) {
				//이 회원 정보를 수정해야 한다. 
				break;
			}
		}
		
			String[] temp = line.split(",");
			System.out.printf("%-12s\t%-8s\t%s\t%4s\t%s\t%4s\t%20s\r\n"
									,temp[0]
									,temp[1]
									,temp[2]
									,temp[3]
									,temp[4]
									,temp[5]
									,temp[6]);
			
			reader.close();
			System.out.println();
			System.out.println("이전 화면으로 돌아가려면 엔터키를 누르세요.");
			scan.nextLine();
		}
	
		
	
	





	private static void edit(String loginId) throws Exception {
		System.out.println("⌜ •   °    +   °   •   •   °    +   °   •    •   °    +   °   •   •   °    +   °   •  ⌝\n"
				+ "                 ,-,--.       ,----.                    .=-.-.  .-._              _,---.      _,.---._\n"
				+ " .--.-. .-.-.  ,-.'-  _\\   ,-.--` , \\   .-.,.---.      /==/_ / /==/ \\  .-._    .-`.' ,  \\   ,-.' , -  `.\n"
				+ "/==/ -|/=/  | /==/_ ,_.'  |==|-  _.-`  /==/  `   \\    |==|, |  |==|, \\/ /, /  /==/_  _.-'  /==/_,  ,  - \\\n"
				+ "|==| ,||=| -| \\==\\  \\     |==|   `.-. |==|-, .=., |   |==|  |  |==|-  \\|  |  /==/-  '..-. |==|   .=.     |\n"
				+ "|==|- | =/  |  \\==\\ -\\   /==/_ ,    / |==|   '='  /   |==|- |  |==| ,  | -|  |==|_ ,    / |==|_ : ;=:  - |\n"
				+ "|==|,  \\/ - |  _\\==\\ ,\\  |==|    .-'  |==|- ,   .'    |==| ,|  |==| -   _ |  |==|   .--'  |==| , '='     |\n"
				+ "|==|-   ,   / /==/\\/ _ | |==|_  ,`-._ |==|_  . ,'.    |==|- |  |==|  /\\ , |  |==|-  |      \\==\\ -    ,_ /\n"
				+ "/==/ , _  .'  \\==\\ - , / /==/ ,     / /==/  /\\ ,  )   /==/. /  /==/, | |- |  /==/   \\       '.='. -   .'\n"
				+ "`--`..---'     `--`---'  `--`-----``  `--`-`--`--'    `--`-`   `--`./  `--`  `--`---'         `--`--''\n"
				+ "\n"
				+ "⌞ °   •    +   •   °  °   •    +   •   °   °   •    +   •   °  °   •    +   •   °   ⌟\n");
			
		BufferedReader reader = new BufferedReader(new FileReader(Path.MEMBERDIR));
		
		String line = null;
		
		while ((line = reader.readLine())!= null) {	
			if(loginId.equals(line.split(",")[0])) {
				//이 회원 정보를 수정해야 한다. 
				break;
			}
		}
		System.out.println("수정하실 정보를 새로 입력하세요.");
		String[] temp = line.split(",");
		
		String id = temp[0];
		System.out.println("기존 아이디: " + id);
		System.out.println();
		
		System.out.println("기존 비밀번호: " + temp[1]);
		//- 비밀번호 입력 + 길이(4~10자) + 구성(영어 대문자, 영어 소문자, 숫자) 
		String password="";
		do {			
			System.out.print("수정 비밀번호(수정하지 않으려면 그냥 엔터):");
			password = scan.nextLine();
			if(password.equals("")) {
				password = temp[1];
			}
		} while (!isPasswd(password));
		
		System.out.println();
		
		
		System.out.println("기존 이름: " + temp[2]);
		//- 이름 입력 + 길이(2~4자) + 구성(한글만) 
		String name=""; 
		do {
			System.out.print("수정 이름(수정하지 않으려면 그냥 엔터): ");
			name = scan.nextLine();
			if(name.equals("")) {
				name = temp[2];
			}
		} while(!isName(name));
		
		
		System.out.println();
		
		
		
		
		System.out.println("기존 나이: " + temp[3]);
		//- 나이 입력 + 길이(1~2자) + 구성(1~99세까지) 
		String age="";
		do {			
			System.out.print("수정 나이(수정하지 않으려면 그냥 엔터):");
			age = scan.nextLine();
			if(age.equals("")) {
				age = temp[3];
			}
		} 
		while (!isAge(age));
		
		System.out.println();
		
		String phoneNumber = temp[4];
		System.out.println("기존 전화번호: " + phoneNumber);
		System.out.println();
		
		
			System.out.println("주소지");
			System.out.println("1. 남현동");
			System.out.println("2. 사당1동");
			System.out.println("3. 사당4동");
			System.out.println("4. 방배2동");
			System.out.println("5. 기타");
			System.out.println();
		
		System.out.println("기존 주소지: " + temp[5]);
		//- 주소 입력 + 길이(1~5자) + 구성(숫자만 1~5) 
		String address="";
		do {			
			System.out.print("수정 주소(수정하지 않으려면 그냥 엔터): ");
			address = scan.nextLine();
			if(address.equals("")) {
				address = temp[5];
			}
		} while (!isAddress(address));
		System.out.println();
		
		System.out.println("┌──────────────────────────────────────┐");
		System.out.println("참고해주세요!");
		System.out.println("①플렉시테리언(🐮   🐷   🐔   🐠   🍳   🍼   🍎   🌿)");
		System.out.println("②폴로-페스코 ( 🐔   🐠   🍳   🍼   🍎   🌿)");	
		System.out.println("③페스코 ( 🐠   🍳   🍼   🍎   🌿)");
		System.out.println("④락토-오보 ( 🍳   🍼   🍎   🌿)");
		System.out.println("⑤오보( 🍳    🍎   🌿)");
		System.out.println("⑥락토( 🍼   🍎   🌿)");
		System.out.println("⑦비건( 🍎   🌿)");
		System.out.println("⑧프로테리언( 🍎)");
		System.out.println("└───────────────────────────────────────┘");
		System.out.println();
		//- 베지테리언 입력 + 길이(1~8자) + 구성(숫자만 1~8) 
		System.out.println("기존 베지테리언: " + temp[6]);
		String veg="";
		do {			
			System.out.print("수정 베지테리언(수정하지 않으려면 그냥 엔터): ");
			veg = scan.nextLine();
			if(veg.equals("")) {
				veg = temp[6];
			}
		} while (!isVeg(veg));
		
		System.out.println();
		
		
		
		reader.close();
		
		reader = new BufferedReader(new FileReader(Path.MEMBERDIR));
		
		String txt = ""; //누적변수
		line = null;
		
		while((line = reader.readLine())!=null) {
			if(loginId.equals(line.split(",")[0])) {
				txt += String.format("%s,%s,%s,%s,%s,%s,%s\r\n"
									,id
									,password
									,name
									,age
									,phoneNumber
									,address
									,veg);
			} else {
				txt += line + "\r\n";
			}
		}
		
		reader.close();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(Path.MEMBERDIR));
		
		writer.write(txt);
		writer.close();
		
		System.out.println("수정이 완료되었습니다.");
		
		System.out.println();
		
		
	}
	
	/**
	 * @param veg 베지테리언 단계
	 * @return 정상입력시 true, 입력 실패시 false;
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
			System.out.println();
			return false;
		}
	}




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




	/**
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





	public static void delete(String loginId) throws Exception {
			System.out.println("⌜ •   °    +   °   •   •   °    +   °   •   •   °    +   °   •   •   °    +   °   •   ⌝\n"
					+ "                ,-,--.       ,----.                                   ,----.     ,---.              ,-.-.      ,----.\n"
					+ " .--.-. .-.-.  ,-.'-  _\\   ,-.--` , \\   .-.,.---.        _.-.       ,-.--` , \\  .--.'  \\      ,--.-./=/ ,/   ,-.--` , \\\n"
					+ "/==/ -|/=/  | /==/_ ,_.'  |==|-  _.-`  /==/  `   \\     .-,.'|      |==|-  _.-`  \\==\\-/\\ \\    /==/, ||=| -|  |==|-  _.-`\n"
					+ "|==| ,||=| -| \\==\\  \\     |==|   `.-. |==|-, .=., |   |==|, |      |==|   `.-.  /==/-|_\\ |   \\==\\,  \\ / ,|  |==|   `.-.\n"
					+ "|==|- | =/  |  \\==\\ -\\   /==/_ ,    / |==|   '='  /   |==|- |     /==/_ ,    /  \\==\\,   - \\   \\==\\ - ' - / /==/_ ,    /\n"
					+ "|==|,  \\/ - |  _\\==\\ ,\\  |==|    .-'  |==|- ,   .'    |==|, |     |==|    .-'   /==/ -   ,|    \\==\\ ,   |  |==|    .-'\n"
					+ "|==|-   ,   / /==/\\/ _ | |==|_  ,`-._ |==|_  . ,'.    |==|- `-._  |==|_  ,`-._ /==/-  /\\ - \\   |==| -  ,/  |==|_  ,`-._\n"
					+ "/==/ , _  .'  \\==\\ - , / /==/ ,     / /==/  /\\ ,  )   /==/ - , ,/ /==/ ,     / \\==\\ _.\\=\\.-'   \\==\\  _ /   /==/ ,     /\n"
					+ "`--`..---'     `--`---'  `--`-----``  `--`-`--`--'    `--`-----'  `--`-----``   `--`            `--`--'    `--`-----``\n"
					+ "⌞ °   •    +   •   °  °   •    +   •   °   °   •    +   •   °  °   •    +   •   °  ⌟\n");
			
			System.out.println("정말로 회원탈퇴를 하시겠습니까?\n"
							+"회원탈퇴시 모든 회원정보가 삭제됩니다.");
	            
	            System.out.print("y/n: ");
    			String del = scan.nextLine();
	           
    			if (del.equalsIgnoreCase("y")) {
	
	        		
	        		reader = new BufferedReader(new FileReader(Path.MEMBERDIR));
	        		
	        		String txt = ""; //누적변수
	        		String line = null;
	        		
	        		while((line = reader.readLine())!= null) {
	        			if(!loginId.equals(line.split(",")[0])) {
	        				txt += line + "\r\n";
	        			}
	        		}
	        		
	        		reader.close();
	        		
	        		System.out.println("회원 탈퇴가 완료되었습니다. 이용해 주셔서 감사합니다. ");
	        		
	        		BufferedWriter writer = new BufferedWriter(new FileWriter(Path.MEMBERDIR));
	        		
	        		writer.write(txt); //삭제 
	        		
	        		writer.close();
	        		System.out.println();
	        		System.out.println("이전 화면으로 돌아가려면 엔터키를 누르세요.");
	        		scan.nextLine();
	        		MainFrame.main(null);
	        		
	        		
	        	} else if (del.equalsIgnoreCase("n")) {
	        		System.out.println("이전화면으로 돌아갑니다.");
	        		MemberInfo(loginId);
	        	} else {
	        		System.out.println("잘못입력했습니다. 다시 입력 해주세요");
	        		delete(loginId);
	        	}
	        	
	       }

	public UserInfo(String id, String password , String name, String age, String tel, String address, String veg) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.address = address;
		this.veg = veg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVeg() {
		return veg;
	}

	public void setVeg(String veg) {
		this.veg = veg;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", password=" + password + ", name=" + name + ", age=" + age + ", tel=" + tel
				+ ", address=" + address + ", veg=" + veg + "]";
	}

	
	
	
	
}