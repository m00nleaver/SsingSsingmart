package com.java.project.mart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import com.java.project.mart.Path;

/**
 * 관리자 및 회원 로그인 클래스입니다.
 * @author 이정현
 *
 */
public class Login { //로그인
	
	/**
	 * 로그인 실행 메소드입니다.
	 * @return 입력한 id를 반환합니다.
	 */
	public static String loginCheck() {
		
		Scanner scan = new Scanner(System.in);
		String id;
		String pw;
		
		header(); 
			
		do {
			System.out.println("😃 id와 pw에 0을 입력하면 초기화면으로 돌아갑니다 😃");
			System.out.print("id : ");
			id = scan.nextLine();
			System.out.print("pw : ");
			pw = scan.nextLine();
			System.out.println();
				
		} while (!isaccessibility(id, pw));
		return id;
	}
	
	private static boolean isaccessibility(String id, String pw) {

		File file = new File(Path.MEMBERDIR);
		int flag = 0;
		String name = ""; 
		
		if (file.exists()) { //파일 존재 유무 유효성 검사
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));

				String line = null;
				
				while ((line = reader.readLine()) != null) {

					String[] temp = line.split(",");
					
					if(id.equals("0") && pw.equals("0")) { // 초기화면으로 돌아가기
						MainFrame.mainHeader();
						break;
					}
					
					if (id.equals("admin") && pw.equals("1234")) { // 관리자 로그인
						flag = 1;
						break;
					}
					if (id.equals(temp[0]) && pw.equals(temp[1])) { // 로그인 정보 모두 일치
						name = temp[2];
						flag = 2;
						break; 
					} 
					//*계정찾기시 비밀번호가 같은 회원이 있을 경우 아이디 불일치라고 생기는 예외때문에 새로추가한 코드
					//반대의 경우는 중복아이디가 없기때문에 처리 안해도 됨
					if (id.equals(temp[0]) && !pw.equals(temp[1])) { //아이디 일치 + 비밀번호 불일치
						flag = 3;
						break;
					}
					if (pw.equals(temp[1])) { //아이디 불일치 + 비밀번호 일치
						flag = 4;
						break;
					}
					if (id.equals(temp[0])) { //아이디 일치 + 비밀번호 불일치
						flag = 5;
						break;
					} 
					
				}//while
			
				
			if (flag == 1) { //관리자
				//ManagerMainFrame f = new ManagerMainFrame(); -> 메인프레임 업데이트
				return true;
			} else if (flag == 2) { //사용자
				System.out.printf("😀%s님 안녕하세요! 오늘도 즐거운 쇼핑하세요!😀\n", name);
				return true;
			} else if (flag == 3) { 
				//비밀번호
				System.out.println(
						"　　＿\r\n"
						+ "　 /～ヽ   비밀번호를\r\n"
						+ "　(｡･-･)　다시 입력해주세요\r\n"
						+ "　ﾟし-Jﾟ"); 
				return false;
			} else if (flag == 4) {
				//아이디
				System.out.println(
						"　　＿\r\n"
						+ "　 /～ヽ   아이디를\r\n"
						+ "　(｡･o･)　다시 입력해주세요\r\n"
						+ "　ﾟし-Jﾟ\r\n"
						+ ""); 
				return false;
			} else if (flag == 5) { 
				//비밀번호
				System.out.println(
						"　　＿\r\n"
						+ "　 /～ヽ   비밀번호를\r\n"
						+ "　(｡･-･)　다시 입력해주세요\r\n"
						+ "　ﾟし-Jﾟ"); 
				return false;
			} else {
				System.out.println("┌───────────────┐\r\n"
						+ " 아이디와 비밀번호를\r\n"
						+ " 다시 입력해주시거나\r\n"
						+ " 회원가입을 해주세요.\r\n"
						+ "└───────────────┘\r\n"
						+ "　　ᕱ ᕱ ||\r\n"
						+ "　 ( ･ω･ ||\r\n"
						+ "　 /　つΦ\r\n"
						+ ""); 
				return false;
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if
		System.out.println("😥 해당 경로에 Member.txt파일이 존재하지 않습니다 😥");
		return false;
	}
	

	private static void header() { 
		System.out.print("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
				+ "|　로그인　　　　　　　　　　　　　　　　　　　　　[－][口][×]   |\r\n"
				+ "|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣|\r\n"
				+ "|　 안녕하세요, 씽씽마트입니다.              　　 　     　　　  |\r\n"
				+ "|　 불편사항은 언제든 매장으로 연락주세요. 　　 　　　　　　　 　|\r\n"
				+ "|　                                        　　 　　　　　　　   |\r\n"
				+ "|　                         　　　 　　　　　　　 　　　　　　   |\r\n"
				+ "|　           　　　　　　　　　　　　　　　　　　　　　　　　   |\r\n"
				+ "|　　　　＿＿＿＿＿＿　　　            ＿＿＿＿＿＿　　　　　    |\r\n"
				+ "| 　　　| id:  　 　|　　　            | pw:   　  | 　          |\r\n"
				+ "|　　　　￣￣￣￣￣￣　　　          　 ￣￣￣￣￣￣ 　　　　　  |\r\n"
				+ "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
				+ "");                         
	}
}