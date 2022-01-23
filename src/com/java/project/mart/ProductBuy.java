package com.java.project.mart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class ProductBuy {
	// (**)변수 초기화
	private static BufferedReader reader;
	private static Scanner scan;
	private static String dir = Path.PRODUCTDIR;
	private static String dirm = Path.PAYMENTLISTDIR;
	private static String replace;
	private static String plus;
	private static ArrayList<String> array = new ArrayList<String>();
	static {
		scan = new Scanner(System.in);

	}

	// (**) main 메소드 역할을 할 run 메소드
	public static void run() throws Exception {
		// (**) 제목 출력 메소드
		title();

		// (**) 구분선
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		
		// 장바구니 목록 출력
		ShoppingBag sb = new ShoppingBag();
		Set<Integer> keySet = sb.map.keySet();

		// 장바구니가 비어있다면 구매 불가
		if (sb.map.isEmpty()) {
			System.out.println("\r\n 😥장바구니에 담긴 물건이 없습니다.😥\r\n" + "장바구니를 담으러 가시겠습니까?");
			System.out.println();
			System.out.println("┌───────────────┐\r\n"
					+ " 1.장바구니\r\n"
					+ " 2.상품검색\r\n"
					+ " 0.초기화면\r\n"
					+ "└───────────────┘\r\n"
					+ "　　ᕱ ᕱ ||\r\n"
					+ "　 ( ･ω･ ||\r\n"
					+ "　 /　つΦ");
			int answer = scan.nextInt();
			System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			

			// 대답이 1이면 장바구니로 돌아감
			if (answer == 1) {
				try {
					ShoppingBag.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 대답이 0이면 초기화면으로 돌아감
			} else if (answer == 0) {
				MemberMainFrame.run(MainFrame.loginId);
				//대답이 2면 검색으로 돌아감
			}else if(answer ==2) {
				try {
					ProductSearch.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 장바구니가 비어 있지 않으니 구매 가능
		} else if (!sb.map.isEmpty()) {
			System.out.println("╭─────────────────────────╮\r\n"); 
			System.out.println("👜장바구니 출력👜\r\n");
			String line = null;
			try {
				BufferedReader reader = new BufferedReader(new FileReader(dir));
				while ((line = reader.readLine()) != null) {
					for (Integer key : keySet) {
						String[] temp = line.split(",");
						String[] temp2 = temp[4].split("■");
						String strkey = key + "";
						if (temp[0].equals(strkey)) {
							// 장바구니 출력
							System.out.println(temp[1] + ":" + sb.map.get(key) + "개");
						}
					}
				}
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("╰─────────────────────────╯");
			System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			
			System.out.println("😃정말로 구매하시겠습니까?(y/n)😃");
			System.out.print("입력: ");
			String answer = scan.nextLine();
			System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			
			
			// 입력 유효성 검사
			answerCheck(answer);
		}

	}

	private static void answerCheck(String answer) throws Exception {

		if (answer.equals("Y") || answer.equals("y")) {// Y, y 의 경우
			System.out.println();
			System.out.println("결제화면을 출력합니다..");
			
			System.out.println();

			// 결제화면으로 넘어가기
			payment();

		} else if (answer.equals("N") || answer.equals("n")) { // N, n의 경우

			// 초기화면으로 돌아가기
			System.out.println();
			System.out.println("초기화면으로 돌아갑니다..");
			System.out.println();
			System.out.println("😃메뉴를 다시 출력하시려면 엔터를 눌러주세요😃");
			String blank = scan.nextLine();
			MemberMainFrame.run(MainFrame.loginId);
			System.out.println("\r\n▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			
			
		} 
		//else if ((!answer.equals("Y")) && (!answer.equals("N")) && (!answer.equals("y")) && (!answer.equals("n"))) {
		else {
			System.out.println();
			System.out.println("😥잘못 입력되었습니다😥");
			System.out.println();
			System.out.println("메뉴를 다시 출력하시려면 엔터를 눌러주세요");
			String blank = scan.nextLine();
			run();
			
		}
	}

	// 결제화면
	private static void payment() throws Exception {
		System.out.println();
		System.out.println("😃결제 방법을 입력해주세요.😃");
		System.out.println();
		System.out.println("1. 현금💵");
		System.out.println("2. 카드💳");
		System.out.println("\r\n▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		
		System.out.print("입력: ");
		
		String payment = scan.nextLine();
			
			if(payment.equals("1")||payment.equals("2")) {
				
			}
			else if (!payment.equals("1") && !payment.equals("2")) {
				System.out.println("😥결제수단을 다시 입력해주세요😥");
				
				payment();
				
			}
			delivery(payment);
		}
		

	private static void delivery(String payment) throws Exception {

		System.out.println("\r\n▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		
		
		System.out.println();

		System.out.println("배송하시겠습니까?");
		System.out.println("😥배송비는 구매금액과 상관 없이 3천원 추가 비용이 발생합니다.😥");

		System.out.println("\r\n▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		
		
		System.out.println();
		System.out.println("Y.네, 배송하겠습니다.");
		System.out.println("N.픽업하겠습니다.");
		
		System.out.print("입력: ");
		String deilvery = scan.nextLine();
		System.out.println("\r\n▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		
		

		if (deilvery.equalsIgnoreCase("Y")) {
			
			// 배송비는 매출액으로 산출하지 않는걸로,,??
			System.out.printf("%,d + 배송비 = %,d\n", total(), total() + 3000);
			System.out.println("😃결제 해주셔서 감사합니다.😃");
			System.out.println("\r\n▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			System.out.println("로그아웃을 위해 초기화면으로 돌아갑니다...");
			

			if (payment.equals("1")) {// 현금 구매 내역 업데이트
				cashUpdate(payment);
			} else if (payment.equals("2")) {// 카드 구매
				cardUpdate(payment);
			}

			ProductUpdate();// 제품 재고 현황 업데이트
			ShoppingBag.map.clear();// 장바구니 리스트 비우기
			ShoppingBag.list.clear();// 장바구니 제품 현황 업데이트를 위해 비우기
			MemberMainFrame.run(MainFrame.loginId);// 초기화면으로 돌아감
			
		} else if (deilvery.equalsIgnoreCase("N")) {
			
			System.out.printf("총 구매 금액= %,d\n", total());
			System.out.println("😃결제 해주셔서 감사합니다.😃");
			System.out.println("2~3일 영업시간 내로 방문해주시길 바랍니다.");
			System.out.println("\r\n▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			System.out.println("초기화면으로 돌아갑니다...");

			if (payment.equals("1")) {
				cashUpdate(payment);

			} else if (payment.equals("2")) {
				cardUpdate(payment);
			}
			ProductUpdate();
			ShoppingBag.map.clear();
			ShoppingBag.list.clear();
			MemberMainFrame.run(MainFrame.loginId);

		} else {
			
			System.out.println("\r\n▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			
			System.out.println("😥배송수단을 다시 입력해주세요.😥");
			System.out.println("\r\n▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			
			
		}
		
	}

	// 현금 매출 업데이트
	private static void cashUpdate(String payment) {
		editmoney(payment);
	}

	// 재고 업데이트
	private static void edit() {
		// 생성 및 초기화
		ShoppingBag sb = new ShoppingBag();
		Set<Integer> keySet = sb.map.keySet();
		String line = null;

		try {
			reader = new BufferedReader(new FileReader(dir));
			String txt = "";
			String count = "";
			while ((line = reader.readLine()) != null) {
				txt += line + "\r\n";// 읽어온 파일 문자열 누적
				for (Integer key : keySet) {
					String strkey = key + "";
					if (strkey.equals(line.split(",")[0])) {// 장바구니와 같은 내용이면
						String[] temp = line.split(",");
						count = (Integer.parseInt(temp[7]) - (sb.map.get(key))) + "";
						replace = count + "";
						txt = txt.replace(temp[7], replace);// 대체한다
					}
				}
			}
			reader.close();
			//System.out.println("출력 arraytoString; " + array.toString());

			// 누적한 문자열로 txt 파일의 내용을 대체한다.
			BufferedWriter writer = new BufferedWriter(new FileWriter(dir));
			writer.write(txt);
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void cardUpdate(String payment) {// 카드 사용 내역에 넣어주기
		editmoney(payment);
	}

	// 장바구니 금액 총액을 구하기 위한 메소드
	private static int total() {
		// 초기화
		int totalCount = 0;
		ShoppingBag sb = new ShoppingBag();
		Set<Integer> keySet = sb.map.keySet();
		String line = null;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(dir));
			while ((line = reader.readLine()) != null) {
				for (Integer key : keySet) {
					String strkey = key + "";
					if (strkey.equals(line.split(",")[0])) {// 장바구니와 일치하면
						String[] temp = line.split(",");// 문자열 분리 후 추출
						totalCount = +((sb.map.get(key)) * (Integer.parseInt(temp[7])));// 계산
						// temp[7] : 물품의 개당 금액
						// sb.map.get(key) : 물품의 수량

					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return totalCount;
	}

	private static void editmoney(String payment) {// 금액 수정
		ShoppingBag sb = new ShoppingBag();

		Set<Integer> keySet = sb.map.keySet();
		String line = null;
		// 기존의 전체 구매 내역 누적
		try {
			String txt = "";
			reader = new BufferedReader(new FileReader(dirm));
			while ((line = reader.readLine()) != null) {
				txt += line + "\r\n";
			}
			reader.close();

			// 최신 구매 내역
			reader = new BufferedReader(new FileReader(dir));
			String paymenthow = "";// 현금인지 카드인지 상황에 따라 다르게 함
			while ((line = reader.readLine()) != null) {

				for (Integer key : keySet) {
					String strkey = key + "";

					if (strkey.equals(line.split(",")[0])) {
						String[] temp = line.split(",");
						// 현금, 카드 선택 옵션에 따라 다르게 누적
						if (payment.equals("1")) {
							paymenthow = "현금";
						} else if (payment.equals("2")) {
							paymenthow = "카드";
						}
						// 신규 구매내역 누적
						plus = String.format("%s,%s,%s,%s,%s,%s,%s\r\n", temp[0], MainFrame.loginId, temp[1], sb.map.get(key),
								temp[8], temp[6], paymenthow);
						txt += plus;
					}
				}
			}
			//System.out.println("결론\r\n" + txt);
			reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(dirm));
			writer.write(txt);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void ProductUpdate() {
		edit();
		// 데이터 파일 수정하기
	}

	private static void title() {
		System.out.print(
				"⌜ •   °    +   °   •   •   °    +   °   •   •   °    +   °   •   •   °    +   °   •  •   °    +   °   •   •     ⌝"
						+ "\r\n"
						+ "     _ __       ,---.                              ___        ,----.   .-._          ,--.--------."
						+ "\r\n"
						+ "  .-`.' ,`.   .--.'  \\      ,--.-.  .-,--.  .-._ .'=.'\\    ,-.--` , \\ /==/ \\  .-._  /==/,  -   , -\\"
						+ "\r\n"
						+ " /==/, -   \\  \\==\\-/\\ \\    /==/- / /=/_ /  /==/ \\|==|  |  |==|-  _.-` |==|, \\/ /, / \\==\\.-.  - ,-./ "
						+ "\r\n"
						+ "|==| _ .=. |  /==/-|_\\ |   \\==\\, \\/=/. /   |==|,|  / - |  |==|   `.-. |==|-  \\|  |   `--`\\==\\- \\ "
						+ "\r\n"
						+ "|==| , '=',|  \\==\\,   - \\   \\==\\  \\/ -/    |==|  \\/  , | /==/_ ,    / |==| ,  | -|        \\==\\_ \\ "
						+ "\r\n"
						+ "|==|-  '..'   /==/ -   ,|    |==|  ,_/     |==|- ,   _ | |==|    .-'  |==| -   _ |        |==|- | "
						+ "\r\n"
						+ "|==|,  |     /==/-  /\\ - \\   \\==\\-, /      |==| _ /\\   | |==|_  ,`-._ |==|  /\\ , |        |==|, | "
						+ "\r\n"
						+ "/==/ - |     \\==\\ _.\\=\\.-'   /==/._/       /==/  / / , / /==/ ,     / /==/, | |- |        /==/ -//"
						+ "\r\n"
						+ "`--`---'      `--`           `--`-`        `--`./  `--`  `--`-----``  `--`./  `--`        `--`--` "
						+ "\r\n"
						+ "⌞ °   •    +   •   °  °   •    +   •   °    °   •    +   •   °  °   •    +   •   °    °   •    +   •   °  °    ⌟\r\n");

	}
}