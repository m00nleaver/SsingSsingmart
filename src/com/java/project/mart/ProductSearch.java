package com.java.project.mart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductSearch {

	private static ArrayList<ProductSearch> list;
	 private static Scanner scan;
	 //private static String dir ="mart\\Product.txt";
	 //private static String dir ="mart\\pro.txt";
	 private static String dir =Path.PRODUCTDIR;
	 private static String name;
	
	 public static String getName() {
		return name;
	}

	public static void setName(String name) {
		ProductSearch.name = name;
	}

	private static final char HANGUL_BEGIN_UNICODE = 44032; // 가
	 private static final char HANGUL_LAST_UNICODE = 55203; // 힣
	 private static final char HANGUL_BASE_UNIT = 588;//각자음 마다 가지는 글자수
	 //자음
	 private static final char[] INITIAL_SOUND = { 'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 
			 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ' };
	 
	static {
		list = new ArrayList<ProductSearch>();
		scan = new Scanner(System.in);
		
	}
	
	 public static void run() throws Exception {
		 title();
		
		 System.out.println("😃검색하려는 상품을 입력해주세요.😃");
		 System.out.println();
		 System.out.println("전체 상품의 목록을 출력하시려면 엔터를 눌러주세요.");
		 System.out.println();
			System.out.print("입력:");
			String inputProduct = scan.nextLine();
			System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			
			search(inputProduct);
			
}


	private static void search(String inputProduct) throws Exception {//찾기 메소드
		BufferedReader reader = new BufferedReader(new FileReader(dir));
		 
		String line = null; 
	      
	      try {
			while ((line = reader.readLine()) != null) {
			     
			        String[] temp = line.split(",");
			        String[] temp2 = temp[4].split("■");
			        
			       ProductSearch search = new ProductSearch();
			       //seq,ProductName,category,manufacturer,substitute,veg,minor,ProductCount,ProductPrice
			       
			    int won = Integer.parseInt(temp[8]);
			    int count = Integer.parseInt(temp[7]);

			       for(int i=0;i<temp2.length;i++) {//대체어가 완전히 같을 때 검색
			    	   if(inputProduct.equals(temp2[i])) {
			    		   
			    		   System.out.printf("%3s.%-20.8s\t%,d개\t%,6d원\r\n",temp[0],temp[1],count,won);
			    		   setName(temp[1]);
			    		   list.add(search);
			    	
			    	   } else if(inputProduct.equals("0")) {
			    		   
			    		   MemberMainFrame.run(MainFrame.loginId);
			    		   
			    		   
			    		   //초성
			    	   } else if(matchString(temp2[i], inputProduct)) {
			    		   System.out.printf("%3s.%-20.8s\t%,d개\t%,6d원\r\n",temp[0],temp[1],count,won);
			    		   
			    		   setName(temp[1]);
			    		   list.add(search);
			    		   break;
			    	   }
			    	   
			       }
			  }//while
			reader.close();
			
			
			//예외처리
	      if(getName()==null) {
	    	  //System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
				System.out.println("😥검색결과가 없습니다.😥");
				System.out.println();
				System.out.println("😃다시 실행하시려면 enter를 눌러주세요😃");
				String blank = scan.nextLine();
	      }else if(!matchString(getName(),inputProduct)) {
	    	  if(list.isEmpty()) {
	    		 // System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
	    		  System.out.println("😥검색결과가 없습니다.😥");
	    		  System.out.println();
	    		  System.out.println("😃다시 실행하시려면 enter를 눌러주세요😃");
		    	  String blank = scan.nextLine();
		    	  System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		    	 
	    	  }
		      }
	      choice();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	      
	     
	}

	private static void choice() throws Exception {
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println("😃원하시는 메뉴의 숫자키를 입력해주세요.😃");
		System.out.println();
		System.out.println(
				"┌───────────────┐\r\n"
				+ " 0. 되돌아가기\r\n"
				+ " 1. 추가 검색\r\n"
				+ " 2. 장바구니 담기\r\n"
				+ "└───────────────┘\r\n"
				+ "　　ᕱ ᕱ ||\r\n"
				+ "　 ( ･ω･ ||\r\n"
				+ "　 /　つΦ");
		System.out.println();
		System.out.println("입력: ");
		String choice = scan.nextLine();
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		if(choice.equals("1")) {
			try {
				run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(choice.equals("0")) {
			MemberMainFrame.run(MainFrame.loginId);
		}else if(choice.equals("2")){
			System.out.println(title.SHOPPINGBAG);
			ShoppingBag.run();
		}
		else {
			System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			System.out.println();
			System.out.println("😥잘못된 입력입니다.😥");
			System.out.println("😃재검색합니다.😃");
			System.out.println();
			System.out.println(".");
			System.out.println(".");
			System.out.println(".");
			System.out.println();
			System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			try {
				run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	private static boolean matchString(String value, String search) {
		 int t = 0;
		  int seof = value.length() - search.length();
		  int slen = search.length();
		  if(seof < 0)
		   return false; //검색어가 더 길면 false를 리턴한다.
		  for(int i = 0;i <= seof;i++){
		   t = 0;
		   while(t < slen){
		    if(isInitialSound(search.charAt(t))==true && isHangul(value.charAt(i+t))){
		     //만약 현재 char이 초성이고 value가 한글이면
		     if(getInitialSound(value.charAt(i+t))==search.charAt(t))
		      //각각의 초성끼리 같은지 비교한다
		      t++;
		     else
		      break;
		    } else {
		     //char이 초성이 아니라면
		     if(value.charAt(i+t)==search.charAt(t))
		      //그냥 같은지 비교한다.
		      t++;
		     else
		      break;
		    }
		   }
		   if(t == slen)
		    return true; //모두 일치한 결과를 찾으면 true를 리턴한다.
		   }
		  return false; //일치하는 것을 찾지 못했으면 false를 리턴한다.
	}

	private static char getInitialSound(char c) {
		int hanBegin = (c - HANGUL_BEGIN_UNICODE);
		  int index = hanBegin / HANGUL_BASE_UNIT;
		  return INITIAL_SOUND[index];
	}

	private static boolean isHangul(char c) {
		return HANGUL_BEGIN_UNICODE <= c && c <= HANGUL_LAST_UNICODE;
	}

	private static boolean isInitialSound(char searchar) {
		 for(char c:INITIAL_SOUND){
			   if(c == searchar){
			    return true;
			   }
			  }
			  return false;
	}
 
	private static void title() {
		System.out.println(title.PRODUCTSEARCH);
		
	}
}

