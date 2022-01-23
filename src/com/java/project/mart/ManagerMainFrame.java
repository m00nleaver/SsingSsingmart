package com.java.project.mart;

import java.util.ArrayList;
import java.util.Scanner;


public class ManagerMainFrame {
	
	private static Scanner scan;
	
	private static ArrayList<Product> list;
	
	static {
		scan = new Scanner(System.in);
		list = new ArrayList<Product>();
	}
	/**
	 * 관리자 메인화면
	 * 조건 : 숫자 1 ~ 5 선택
	 * 1. 회원정보조회
	 * 2. 상품관리
	 * 3. 매출관리
	 * 4. 재고관리
	 * 5. 로그아웃
	 */
	public ManagerMainFrame() throws Exception {
		
		boolean loop = true;
		
		while (loop) {
			
			menu();
			
			System.out.println();
			System.out.print("옵션 번호 입력: ");
			String sel = scan.nextLine();
			if (sel.equals("1")) {			
				//회원정보조회
				UserInfoList u = new UserInfoList();
			} else if (sel.equals("2")) {
				
				//상품관리
				ProductManagement pm = new ProductManagement();
			} else if (sel.equals("3")) {
				
				//매출관리
				SellManagement s = new SellManagement();
			} else if (sel.equals("4")) {
				
				//재고관리
				InventoryManagement i = new InventoryManagement();
			} else if (sel.equals("5")) {
				
				//로그아웃
				System.out.println("종료..");
				
				MainFrame MainFrame = new MainFrame();	
				MainFrame.main(null);
				loop = false;
			} else {
				System.err.println("😥 숫자 1~5번까지 입력해주세요 😥");
				System.out.println();
			}
			
		}
		
	
	
		
	}//main

	private static void menu() {
		System.out.println(title.PRODUCTMANAGEMENT);
		System.out.println("안녕하세요! 관리자님.");
		System.out.println();
		System.out.println("원하는 서비스의 번호를 입력해주세요.");
	
		System.out.println("┌───────────────┐");
		System.out.println("1. 회원정보조회 ");
		System.out.println("2. 상품관리");
		System.out.println("3. 매출관리");
		System.out.println("4. 재고관리");
		System.out.println("5. 로그아웃");
		System.out.println("└───────────────┘");
		System.out.println(
							"￣￣￣￣￣＼／￣￣￣￣\r\n"
							+ "　　　　 ∧＿∧　　　　\r\n"
							+ "　　　（´・ω・） 　\r\n"
							+ "　＿＿_(っ 旦o＿＿\r\n"
							+ "　|l￣l||￣しﾞしﾞ￣|i\r\n"
							+ "");

	}
	
}