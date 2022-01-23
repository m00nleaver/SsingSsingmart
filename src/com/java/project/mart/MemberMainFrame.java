package com.java.project.mart;
import java.io.IOException;

import java.util.Scanner;

public class MemberMainFrame {
   
   private static Scanner scan;
   
   static {
      scan = new Scanner(System.in);
   }

   public static void run(String loginId) throws Exception {
   //메소드   

      boolean loop = true;
      
      while (loop) {

         menu();
         
         System.out.print("옵션 번호 입력: ");
         String sel = scan.nextLine();
      
         if (sel.equals("1")) {
            //상품검색
            System.out.println("상품검색으로 이동합니다.");
            try {
            	ProductSearch.run();
			} catch (Exception e) {
				e.printStackTrace();
			}

            loop=false;
            
         } else if (sel.equals("2")) {
            //장바구니 담기
        	 loop=false;
            System.out.println("장바구니로 이동합니다.");
            System.out.println();
            System.out.println(title.SHOPPINGBAG);
            try {
            	ShoppingBag.run();
			} catch (Exception e) {
				e.printStackTrace();
			}
            
            
         } else if (sel.equals("3")) {
        	 loop=false;
            System.out.println("상품결제으로 이동합니다.");
            ProductBuy.run();
            
         } else if (sel.equals("4")) {
            System.out.println("개인정보조회로 이동합니다.");
            try {
				UserInfo.MemberInfo(MainFrame.loginId);
			} catch (Exception e) {
				e.printStackTrace();
			}
            
         } else if (sel.equals("5")) {
        	 loop=false;
            PaymentList list = new PaymentList();
            System.out.println("결제내역조회로 이동합니다.");
            try {
				list.list(loginId);
			} catch (Exception e) {
				e.printStackTrace();
			}
            break;
         } else if(sel.equals("6")){
        	 
        	 System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
        	 		+ "|　로그아웃　　　　　　　　　　　　　　　　　　　　　[－][口][×] |\r\n"
        	 		+ "|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣|\r\n"
        	 		+ "|　 즐거운 쇼핑 되셨나요?                  　　 　　　　　　　 　|\r\n"
        	 		+ "|　 불편사항은 언제든 매장으로 연락주세요. 　　 　　　　　　　 　|\r\n"
        	 		+ "|　                                        　　 　　　　　　　 　|\r\n"
        	 		+ "|　로그아웃을 하시겠습니까?　　　 　　　　　　　　　　　　　　 　|\r\n"
        	 		+ "|　           　　　　　　　　　　　　　　　　　　　　　　　　 　|\r\n"
        	 		+ "|　　　　＿＿＿＿＿＿　　　           　＿＿＿＿＿＿　　　　　　 |\r\n"
        	 		+ "| 　　　｜y 　　　　｜　　　          ｜n        　｜ 　         |\r\n"
        	 		+ "| 　　  ｜          ｜                ｜           ｜            |\r\n"
        	 		+ "|　　　　￣￣￣￣￣￣　　　          　￣￣￣￣￣￣　　　　　　　|\r\n"
        	 		+ "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n");
        	 
        	 System.out.print("입력: ");
             String answer = scan.nextLine();
             if(answer.equalsIgnoreCase("Y")){
            	 loop=false;
            	 //로그아웃 > 초기화면으로 돌아가기
            	 System.out.println("초기화면으로 돌아갑니다..");
            	 ShoppingBag.map.clear();
            	 
            	 try {
					MainFrame.main(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
            	 
             }else if(answer.equalsIgnoreCase("N")) {
            	 //초기화면으로 돌아가기
            	 System.out.println("메뉴를 다시 출력하시려면 엔터를 눌러주세요");
            	 String blank = scan.nextLine();
             }else {
            	 System.out.println("잘못입력하였습니다.");
            	 System.out.println("메뉴를 다시 출력하시려면 엔터를 눌러주세요");
            	 String blank = scan.nextLine();
             }
         }  else {
            System.out.println("잘못입력되었습니다. 옵션을 다시 입력해주세요.");
            System.out.println("메뉴를 다시 출력하시려면 엔터를 눌러주세요");            
            String blank = scan.nextLine();
         }
         
      }
      
      
      
      
   }//main

   
   





private static void menu() {
      System.out.println();
      System.out.println("😀안녕하세요!😀");
      System.out.println("원하시는 옵션의 번호를 입력해주세요");
      System.out.println();
      System.out.println("┌─────────────────┐");
      System.out.println("1. 상품검색");
      System.out.println("2. 장바구니 담기");
      System.out.println("3. 상품결제");
      System.out.println("4. 개인정보 조회");
      System.out.println("5. 결제내역 조회");
      System.out.println("6. 로그아웃");
      System.out.println("└───────────────┘\r\n"
      		+ "　　ᕱ ᕱ ||\r\n"
      		+ "　 ( ･ω･ ||\r\n"
      		+ "　 /　つΦ\r\n"
      		+ "");
      
   }
   
}