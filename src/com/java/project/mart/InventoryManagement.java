package com.java.project.mart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class InventoryManagement {
	
	private static Scanner scan;
	private static ArrayList<Product> list;
	
	static {
		scan = new Scanner(System.in);
		list = new ArrayList<Product>();
	}
	
	
	public InventoryManagement() throws Exception {
		
		boolean loop = true;
		
		while (loop) {
			
			menu();
		
			System.out.print("입력: ");
			String nums1 = scan.nextLine();
			
			if (nums1.equals("1")) {
				
				productadd();
				
			} else if (nums1.equals("2")) {
				
				productlist();
			} else if (nums1.equals("3")) {
				
				loop = false;
			} else {
				
				System.out.println();
				System.out.println("😥 올바른 번호를 입력해주세요. 😥");
				System.out.println();
			}
		}
		
	}

	private static void menu() {
		
			
		System.out.println();
		System.out.println("원하시는 메뉴를 선택해주세요.");
		System.out.println("┌───────────────┐");
		System.out.println("1. 상품 입고");
		System.out.println("2. 상품 재고 조회");
		System.out.println("3. 뒤로가기");
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

	private static void productlist() throws Exception {
		
		System.out.println("                          ┌────────────┐");
		System.out.println("                         마트 상품 리스트");
		System.out.println("                          └────────────┘");
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		System.out.println("     [번호]      [원산지]      [수량]          [가격]                       [상품명]");
		
		BufferedReader reader = new BufferedReader(new FileReader(Path.PRODUCTDIR));
		
		String line = null;
		String txt = "";
		
		while ((line = reader.readLine()) != null) {
			
			String[] temp = line.split(",");

			txt += String.format("     %3s           %2s        %,5d개     %,10d원     %20s\r\n" 
					, temp[0] //번호
					, temp[3].substring(0, 2) //제조사(원산지)
					//, temp[2] 카테고리 
					, Integer.parseInt(temp[7]) 
					//, temp[4]  검색어
					//, temp[5] 베지테리언 
					//, temp[6] 미성년자
					, Integer.parseInt(temp[8]) //수량
					, temp[1]); //상품명
		}
		System.out.println(txt);
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		reader.close();
		
		boolean loop = true;
		
		while (loop) {
			System.out.println();
			System.out.println("다른 메뉴로 이동을 원하실 경우 숫자를 입력해주세요.");
			System.out.println("┌───────────────┐");
			System.out.println("1. 상품 입고");
			System.out.println("2. 뒤로가기");
			System.out.println("└───────────────┘");
			System.out.println(
					"￣￣￣￣￣＼／￣￣￣￣\r\n"
					+ "　　　　 ∧＿∧　　　　\r\n"
					+ "　　　（´・ω・） 　\r\n"
					+ "　＿＿_(っ 旦o＿＿\r\n"
					+ "　|l￣l||￣しﾞしﾞ￣|i\r\n"
					+ "");
			
			System.out.println();
			System.out.print("입력: ");
			String input = scan.nextLine();
			System.out.println();
			
			if (input.equals("1")) {
				
				productadd();
			} else if (input.equals("2")) {
				
				System.out.println();
				loop = false;
			} else {
				
				System.out.println("😥 올바른 번호를 입력해주세요. 😥");
				System.out.println();
			}
			
		}
		
		
	}

	 private static void productadd() throws Exception {
	      
	      System.out.println();
	      System.out.println("입고하시려는 상품의 이름과 수량을 입력해주세요.");
	      System.out.println();
	      
	      boolean loop = true;
	      String productname="";
	      
	      while(loop) {
		      System.out.print("상품명: ");
		      productname = scan.nextLine();
		      
		      if (productname.equals("")) {
					System.err.println("😥 상품명을 입력해주세요 😥");
				}else {
					loop = false;
				}
		      
	      }
	      System.out.println();
	      String productcount="";
	      loop = true;
	      while(loop) {
	    	  System.out.print("수량: ");
	    	  productcount = scan.nextLine();
		     
		      if (productcount.equals("")) {
					System.err.println("😥 수량을 입력해주세요 😥");
				}else {
					loop = false;
				}
		      
	      }
	    
	      System.out.println();
	      
	      BufferedReader reader = new BufferedReader(new FileReader(Path.PRODUCTDIR));
	      
	      String line = null;
	      String txt = "";
	      
	      while ((line = reader.readLine()) != null) {
	         
	         String[] temp = line.split(",");
	            
	         if (productname.equals(temp[1])) {
	            
	            int count = Integer.parseInt(temp[7]);
	            
	            count += Integer.parseInt(productcount);
	            
	            temp[7] = Integer.toString(count);
	            
	         }
	         
	         txt += String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n"
	                     , temp[0]
	                     , temp[1]
	                     , temp[2]
	                     , temp[3]
	                     , temp[4]
	                     , temp[5]
	                     , temp[6]
	                     , temp[7]
	                     , temp[8]);
	      }
	      
	      reader.close();
	      
	      BufferedWriter writer = new BufferedWriter(new FileWriter(Path.PRODUCTDIR));
	      
	      writer.write(txt);
	      
	      writer.close();
	      
	      System.out.println("입고되었습니다.\r\n");

	      loop = true;
	      
	      while (loop) {
	         
	         System.out.print("더 입고하시겠습니까? [Y/N]: ");
	         String more = scan.nextLine();
	         System.out.println();
	         
	         if (more.equalsIgnoreCase("Y")){	               
	        	 productadd();
	        	 loop = false;
	         } else if (more.equalsIgnoreCase("N")) {
	            loop = false;
	         } else {  
	            System.err.println("😥 올바르게 입력해주세요. 😥");
	            System.out.println();
	         }
	         
	      }
	      
	   }
	 
	 private static boolean isOverlap(String ProductName) throws Exception {		
			load();
		 	
			String str="";
			
			for(Product p : list) {
				str += p.getProductName()+",";
			}		
			
			String[] temp = str.split(",");
			
			for(int i=0;i<temp.length;i++) {
				if(ProductName.equals(temp[i])) {
					return true;
				}
			}

			list.clear();
			
			return false;
			
			
			
		}
	 
	 private static void load() throws Exception {
			
			BufferedReader reader = new BufferedReader(new FileReader(Path.PRODUCTDIR));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				//1회전 > 멤버 1명 > Member 객체 1개 생성
				
				String[] temp = line.split(",");
				
				Product p = new Product();

				p.setSeq(temp[0]);
				p.setProductName(temp[1]);
				p.setCategory(temp[2]);
				p.setManufacturer(temp[3]);
				p.setSubstitute(temp[4]);
				p.setVeg(temp[5]);
				p.setMinor(temp[6]);
				p.setProductCount(temp[7]);
				p.setProductPrice(temp[8]);
				
				list.add(p);
				
			}
			
			reader.close();
			
		}
}//재고관리
































