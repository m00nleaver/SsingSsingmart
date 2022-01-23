package com.java.project.mart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class SellManagement {
	
	private static Scanner scan;
	
	static {
		
		scan = new Scanner(System.in);
		
	}
	
	public SellManagement() throws Exception {
		
		boolean loop = true;
		
		while (loop) {
		
			sellMenu();
			
			System.out.print("입력: ");
			Scanner scan = new Scanner(System.in);
			
			String input = scan.nextLine();
			
			if (input.equals("1")) {
				
				total();
			} else if (input.equals("2")) {
				
				cash();
			} else if (input.equals("3")) {
				
				card();
			} else if (input.equals("4")) {
				
				System.out.println();
				loop = false;
			} else {
				
				System.out.println();
				System.out.println("😥 올바른 번호를 입력해주세요. 😥");
				System.out.println();
			}
		}
		
	}

	private void sellMenu() {
		
		System.out.println();
		System.out.println("무엇을 출력하시겠습니까?");
		System.out.println();
		System.out.println("┌───────────────┐");
		System.out.println("1. 총 매출 출력");
		System.out.println("2. 현금 매출 출력");
		System.out.println("3. 카드 매출 출력");
		System.out.println("4. 뒤로가기");
		System.out.println("└───────────────┘");
		System.out.println(
				"￣￣￣￣￣＼／￣￣￣￣\r\n"
				+ "　　　　 ∧＿∧　　　　\r\n"
				+ "　　　（´・ω・） 　\r\n"
				+ "　＿＿_(っ 旦o＿＿\r\n"
				+ "　|l￣l||￣しﾞしﾞ￣|i\r\n"
				+ "");
		System.out.println();
		
	}

	private void card() throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader(Path.PAYMENTLISTDIR));
		
		String line = null;
		int cardSum = 0;
		
		while ((line = reader.readLine()) != null) {
			
			String[] temp = line.split(",");
			
			if (temp[6].equals("카드")) {
				
				cardSum += Integer.parseInt(temp[4]);
				
			}
			
		}
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		System.out.printf("카드 매출 내역: %,d원\r\n", cardSum);
		
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		
		reader.close();
		
		turnback();
		
	}

	private void cash() throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader(Path.PAYMENTLISTDIR));
		
		String line = null;
		int cashSum = 0;
		
		while ((line = reader.readLine()) != null) {
			
			String[] temp = line.split(",");
			
			if (temp[6].equals("현금")) {
				
				cashSum += Integer.parseInt(temp[4]);
				
			}
			
		}
		
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		System.out.printf("현금 매출 내역: %,d원\r\n", cashSum);
		
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		
		reader.close();
		
		turnback();
		
	}

	private void total() throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader(Path.PAYMENTLISTDIR));
		
		String line = null;
		int totalSum = 0;
		
		while ((line = reader.readLine()) != null) {
			
			String[] temp = line.split(",");
			
			totalSum += Integer.parseInt(temp[4]);
			
		}
		
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		System.out.printf("총 매출 내역: %,d원\r\n", totalSum);
	
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		
		reader.close();
		
		turnback();
		
	}

	private void turnback() {
		
		boolean loop = true;
		
		while (loop) {
		
			
			System.out.println();
			System.out.println("0. 뒤로가기");
			
			System.out.println();
			System.out.print("입력: ");
			String back = scan.nextLine();
			
			if (back.equals("0")) {
				
				System.out.println();
				loop = false;
			} else {
				
				System.out.println();
				System.out.println("😥 올바른 번호를 입력해주세요. 😥");
				System.out.println();
			}
			
		}
		
		
	}

}//매출관리