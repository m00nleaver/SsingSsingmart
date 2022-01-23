package com.java.project.mart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PaymentList {
	private static ArrayList<Product> ProductList;
	private static Scanner scan;
	private static BufferedReader reader;
	
	static {
		ProductList = new ArrayList<Product>();
		scan = new Scanner(System.in);
		 try {
				reader = new BufferedReader(new FileReader(Path.MEMBERDIR));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	
	public static void list(String logId) throws Exception {
		System.out.println("⌜ •   °    +   °   •   •   °    +   °   •   ⌝\n"
				+ "\n"
				+ "\n"
				+ "     _ __       ,---.                              ___        ,----.   .-._          ,--.--------.                  .=-.-.    ,-,--.   ,--.--------.\n"
				+ "  .-`.' ,`.   .--.'  \\      ,--.-.  .-,--.  .-._ .'=.'\\    ,-.--` , \\ /==/ \\  .-._  /==/,  -   , -\\      _.-.      /==/_ /  ,-.'-  _\\ /==/,  -   , -\\\n"
				+ " /==/, -   \\  \\==\\-/\\ \\    /==/- / /=/_ /  /==/ \\|==|  |  |==|-  _.-` |==|, \\/ /, / \\==\\.-.  - ,-./    .-,.'|     |==|, |  /==/_ ,_.' \\==\\.-.  - ,-./\n"
				+ "|==| _ .=. |  /==/-|_\\ |   \\==\\, \\/=/. /   |==|,|  / - |  |==|   `.-. |==|-  \\|  |   `--`\\==\\- \\      |==|, |     |==|  |  \\==\\  \\     `--`\\==\\- \\\n"
				+ "|==| , '=',|  \\==\\,   - \\   \\==\\  \\/ -/    |==|  \\/  , | /==/_ ,    / |==| ,  | -|        \\==\\_ \\     |==|- |     |==|- |   \\==\\ -\\         \\==\\_ \\\n"
				+ "|==|-  '..'   /==/ -   ,|    |==|  ,_/     |==|- ,   _ | |==|    .-'  |==| -   _ |        |==|- |     |==|, |     |==| ,|   _\\==\\ ,\\        |==|- |\n"
				+ "|==|,  |     /==/-  /\\ - \\   \\==\\-, /      |==| _ /\\   | |==|_  ,`-._ |==|  /\\ , |        |==|, |     |==|- `-._  |==|- |  /==/\\/ _ |       |==|, |\n"
				+ "/==/ - |     \\==\\ _.\\=\\.-'   /==/._/       /==/  / / , / /==/ ,     / /==/, | |- |        /==/ -/     /==/ - , ,/ /==/. /  \\==\\ - , /       /==/ -/\n"
				+ "`--`---'      `--`           `--`-`        `--`./  `--`  `--`-----``  `--`./  `--`        `--`--`     `--`-----'  `--`-`    `--`---'        `--`--`\n"
				+ "\n"
				+ "⌞ °   •    +   •   °  °   •    +   •   °   ⌟\n");
		System.out.println("조회 할 구매내역의 번호를 입력하세요.");
		System.out.println("┌───────────────┐\r\n"
				+ " 1. 최근 구매 내역\r\n"
				+ " 2. 지난 구매 내역\r\n"
				+ " 0. 이전 화면\r\n"
				+ "└───────────────┘\r\n"
				+ "　　ᕱ ᕱ ||\r\n"
				+ "　 ( ･ω･ ||\r\n"
				+ "　 /　つΦ");
	
		System.out.print("번호 입력: ");
		String num = scan.nextLine();
		
		
		
		if(num.equals("1")) {
			System.out.println("최근 구매내역으로 이동합니다.");
			newbuy(MainFrame.loginId);
			
		}else if(num.equals("2")) {
			System.out.println("지난 구매내역으로 이동합니다.");
			oldbuy(MainFrame.loginId);
			
		}else if(num.equals("0")) {
			MemberMainFrame.run(logId);
		}else {
			System.out.println("잘못된 번호입니다. 다시 입력해주세요");
			list(logId);
		}
		
	}
	private static void newbuy(String loginId) throws Exception {
		System.out.println("⌜ •   °    +   °   •   •   °    +   °   •   ⌝\n"
				+ "     _ __       ,---.                              ___        ,----.   .-._          ,--.--------.                  .=-.-.    ,-,--.   ,--.--------.\n"
				+ "  .-`.' ,`.   .--.'  \\      ,--.-.  .-,--.  .-._ .'=.'\\    ,-.--` , \\ /==/ \\  .-._  /==/,  -   , -\\      _.-.      /==/_ /  ,-.'-  _\\ /==/,  -   , -\\\n"
				+ " /==/, -   \\  \\==\\-/\\ \\    /==/- / /=/_ /  /==/ \\|==|  |  |==|-  _.-` |==|, \\/ /, / \\==\\.-.  - ,-./    .-,.'|     |==|, |  /==/_ ,_.' \\==\\.-.  - ,-./\n"
				+ "|==| _ .=. |  /==/-|_\\ |   \\==\\, \\/=/. /   |==|,|  / - |  |==|   `.-. |==|-  \\|  |   `--`\\==\\- \\      |==|, |     |==|  |  \\==\\  \\     `--`\\==\\- \\\n"
				+ "|==| , '=',|  \\==\\,   - \\   \\==\\  \\/-/    |==|  \\/  , | /==/_ ,    / |==| ,  | -|        \\==\\_ \\     |==|- |     |==|- |   \\==\\ -\\         \\==\\_ \\\n"
				+ "|==|-  '..'   /==/ -   ,|    |==|  ,_/     |==|- ,   _ | |==|    .-'  |==| -   _ |        |==|- |     |==|, |     |==| ,|   _\\==\\ ,\\        |==|- |\n"
				+ "|==|,  |     /==/-  /\\ - \\   \\==\\-, /      |==| _ /\\   | |==|_  ,`-._ |==|  /\\ , |        |==|, |     |==|- `-._  |==|- |  /==/\\/ _ |       |==|, |\n"
				+ "/==/ - |     \\==\\ _.\\=\\.-'   /==/._/       /==/  / / , / /==/ ,     / /==/, | |- |        /==/ -/     /==/ - , ,/ /==/. /  \\==\\ - , /       /==/ -/\n"
				+ "`--`---'      `--`           `--`-`        `--`./  `--`  `--`-----``  `--`./  `--`        `--`--`     `--`-----'  `--`-`    `--`---'        `--`--`\n"
				+ "\n"
				+ "⌞ °   •    +   •   °  °   •    +   •   °   ⌟\n");
		
		BufferedReader reader = new BufferedReader(new FileReader(Path.PAYMENTLISTDIR));
		String line = null;
		
		ArrayList<String> txt = new ArrayList<String>(); //loginId 일치한 배열 불러오는 ArrayList
		
		while((line = reader.readLine())!= null) {
				
			if(loginId.equals(line.split(",")[1])) { 
				
				txt.add(line);
			}
		}
		
		if(txt.size() == 0) {
			System.out.println("구매한 기록이없습니다.");
			reader.close();
			System.out.println("이전 화면으로 돌아가려면 엔터키를 누르세요.");
			scan.nextLine();
			MemberMainFrame.run(loginId);
		} else {
		
		line = txt.get(txt.size()-1);
		String[] temp = line.split(",");
		
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		
		System.out.println("[상품명]\t[수량]\t[가격]\t[배송정보]");
		System.out.printf(" %-14s%s\t%s\t%s\r\n"
										,temp[2]
										,temp[3]
										,temp[4]
										,"배송완료");  
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		
		
		reader.close();
		System.out.println("이전 화면으로 돌아가려면 엔터키를 누르세요.");
		scan.nextLine();
		MemberMainFrame.run(loginId);
		}
}

	private static void oldbuy(String loginId) throws Exception {
		System.out.println("⌜ •   °    +   °   •   •   °    +   °   •   ⌝\n"
				+ "     _ __       ,---.                              ___        ,----.   .-._          ,--.--------.                  .=-.-.    ,-,--.   ,--.--------.\n"
				+ "  .-`.' ,`.   .--.'  \\      ,--.-.  .-,--.  .-._ .'=.'\\    ,-.--` , \\ /==/ \\  .-._  /==/,  -   , -\\      _.-.      /==/_ /  ,-.'-  _\\ /==/,  -   , -\\\n"
				+ " /==/, -   \\  \\==\\-/\\ \\    /==/- / /=/_ /  /==/ \\|==|  |  |==|-  _.-` |==|, \\/ /, / \\==\\.-.  - ,-./    .-,.'|     |==|, |  /==/_ ,_.' \\==\\.-.  - ,-./\n"
				+ "|==| _ .=. |  /==/-|_\\ |   \\==\\, \\/=/. /   |==|,|  / - |  |==|   `.-. |==|-  \\|  |   `--`\\==\\- \\      |==|, |     |==|  |  \\==\\  \\     `--`\\==\\- \\\n"
				+ "|==| , '=',|  \\==\\,   - \\   \\==\\  \\/-/    |==|  \\/  , | /==/_ ,    / |==| ,  | -|        \\==\\_ \\     |==|- |     |==|- |   \\==\\ -\\         \\==\\_ \\\n"
				+ "|==|-  '..'   /==/ -   ,|    |==|  ,_/     |==|- ,   _ | |==|    .-'  |==| -   _ |        |==|- |     |==|, |     |==| ,|   _\\==\\ ,\\        |==|- |\n"
				+ "|==|,  |     /==/-  /\\ - \\   \\==\\-, /      |==| _ /\\   | |==|_  ,`-._ |==|  /\\ , |        |==|, |     |==|- `-._  |==|- |  /==/\\/ _ |       |==|, |\n"
				+ "/==/ - |     \\==\\ _.\\=\\.-'   /==/._/       /==/  / / , / /==/ ,     / /==/, | |- |        /==/ -/     /==/ - , ,/ /==/. /  \\==\\ - , /       /==/ -/\n"
				+ "`--`---'      `--`           `--`-`        `--`./  `--`  `--`-----``  `--`./  `--`        `--`--`     `--`-----'  `--`-`    `--`---'        `--`--`\n"
				+ "\n"
				+ "⌞ °   •    +   •   °  °   •    +   •   °   ⌟\n");
		BufferedReader reader = new BufferedReader(new FileReader(Path.PAYMENTLISTDIR));
		String line = null;
		
		ArrayList<String> txt = new ArrayList<String>(); //loginId 일치한 배열 불러오는 ArrayList
		
		while((line = reader.readLine())!= null) {
	
		if(loginId.equals(line.split(",")[1])) {
			
				txt.add(line);
				
			}
		
		}
		
		if(txt.size() == 0) {
			System.out.println("구매했던 기록이없습니다.");
			reader.close();
			System.out.println("이전 화면으로 돌아가려면 엔터키를 누르세요.");
			scan.nextLine();
			MemberMainFrame.run(loginId);
		}
		
		int num = txt.size(); //ArrayList index 값 맨 끝방 
		
		for(int i=num-2; i>=0; i--) {
			
			line = txt.get(i);
			
			String[] temp = line.split(",");
			
			System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			
			System.out.println("[상품명]\t[수량]\t[가격]\t[배송정보]");
			System.out.printf(" %-14s%s\t%s\t%s\r\n"
											,temp[2]
											,temp[3]
											,temp[4]
											,"배송완료");  
			System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			
			
			
		}
		reader.close();
		System.out.println("이전 화면으로 돌아가려면 엔터키를 누르세요.");
		scan.nextLine();
		MemberMainFrame.run(loginId);
		
	}
	

}