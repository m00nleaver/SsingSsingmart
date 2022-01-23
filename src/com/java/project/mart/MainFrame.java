package com.java.project.mart;

import java.io.IOException;
import java.util.Scanner;

public class MainFrame {
	static String loginId;
	public static void main(String[] args) throws Exception {
		while(true) {
			while (MainFrame.mainHeader());
			loginId = Login.loginCheck();
			if (loginId.equals("admin")) {
				ManagerMainFrame f = new ManagerMainFrame();
			} else {
				
				
				
				MemberMainFrame.run(loginId);
			}
		}

	}
	
	static boolean mainHeader() {
		System.out.println(title.MAINFRAME);
		System.out.println("안녕하세요! 씽씽마트에 오신걸 환영합니다.\n");
		System.out.println("😀원하시는 서비스의 번호를 입력해주세요.😀\n");
		System.out.println("┌───────────────┐\r\n");
		System.out.println("1.로그인🔑");
		System.out.println("2.회원가입👐");
		System.out.println("3.계정찾기🔍");
		System.out.println("4.프로그램종료🌙\r\n");
		System.out.println("└───────────────┘\r\n"
				+ "　　ᕱ ᕱ ||\r\n"
				+ "　 ( ･ω･ ||\r\n"
				+ "　 /　つΦ\r\n");
		System.out.print("입력 : ");
		Scanner scan = new Scanner(System.in);
		try {
			int num = scan.nextInt();
			switch (num) {
			case 1: {
				//login
				return false;
			}
			case 2: {
				
				IdNew.idNewRun();
				return true;
			}
			case 3: {
				
				IdFind.idFindRun();
				return true;
			}
			case 4:{
				System.out.println("프로그램을 종료합니다...");
				System.exit(0);
			}
			default:
				System.out.println("😥정확한 메뉴를 입력해주세요😥.\n\n");
				return true;
			}
		} catch (Exception e) {
			System.out.println("😥정확한 메뉴를 입력해주세요.😥\n\n");			
		}
		return true;
	}
	
}