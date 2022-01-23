package com.java.project.mart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Scanner;


public class ProductManagement {
	
	private static Scanner scan;
	private static ArrayList<Product> list;
	
	static {
		scan = new Scanner(System.in);
		list = new ArrayList<Product>();
	}

	public ProductManagement() throws Exception {
	
		boolean loop = true;
		//load();
		while (loop) {
			menu();
			
			System.out.println();
			System.out.print("옵션 번호 입력: ");
			String sel = scan.nextLine();
			if (sel.equals("1")) {	
				//상품 등록
				add();			
			} else if (sel.equals("2")) {
				//상품 수정
				edit();
			} else if (sel.equals("3")) {
				//상품 삭제
				delete();
			} else if (sel.equals("4")) {			
				//뒤로가기
				System.out.println("뒤로가기..");
				System.out.println();
				ManagerMainFrame mmf = new ManagerMainFrame();
				loop = false;
			}else {
				System.err.println("😥 숫자 1~4번까지 입력해주세요 😥");
				System.out.println();
			}
			
		}
	
		save();
		
	}//main
	
	private static void delete() throws Exception {
		
		load();
		
		System.out.println();
		System.out.println("\t┌────────────┐");
		System.out.println("\t상품 삭제하기");
		System.out.println("\t└────────────┘");
		System.out.println();
		String seq = "";
		boolean loop = true;
		
//		System.out.println();
//		System.out.println("[번호]\t[상품명]");
//		for(Product p : list) {
//			System.out.printf(" %3s\t  %s\n",p.getSeq(),p.getProductName());
//		}
		
		int size = list.size();
	
		while(loop) {
			try {
				System.out.print("삭제 상품 번호(1~"+size+"): ");
				seq = scan.nextLine();
				
				if(isEditNum(seq)) {
					loop = false;
				}else {
					System.err.println("😥 삭제 번호가 틀립니다. 😥");	
				}
			}catch(Exception e) {
				System.err.println("😥 삭제 번호가 틀립니다. 😥");	
			}
		}
		
	
		BufferedReader reader 
			= new BufferedReader(new FileReader(Path.PRODUCTDIR));
		
		String txt = ""; //누적 변수
		String line = null;
		int num=0;
		
		while ((line = reader.readLine()) != null) {
			String[] temp = line.split(",");
			num = Integer.parseInt(temp[0]);
			
			if(Integer.parseInt(seq)< num) {
				num = num - 1;
				temp[0] = String.valueOf(num);
			}
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
			
			if (!seq.equals(line.split(",")[0])) {

					txt += String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n"
							, p.getSeq()
							, p.getProductName()
							, p.getCategory()
							, p.getManufacturer()
							, p.getSubstitute()
							, p.getVeg()
							, p.getMinor()
							, p.getProductCount()
							, p.getProductPrice());	
					
			}
			
		}
		
	
		//list.remove(Integer.parseInt(seq)-1);
		
		reader.close();
		
		BufferedWriter writer 
			= new BufferedWriter(new FileWriter(Path.PRODUCTDIR));
		
		writer.write(txt); //삭제
		
		writer.close();
				
		pause("상품을 삭제했습니다.");	
		
		list.clear();
	}
	
	
	private static void edit() throws Exception {
					
		load();
		
		BufferedReader reader = new BufferedReader(new FileReader(Path.PRODUCTDIR));
		
		System.out.println();
		System.out.println("\t┌────────────┐");
		System.out.println("\t상품 수정하기");
		System.out.println("\t└────────────┘");
		System.out.println();
	
		
//		System.out.println();
//		System.out.println("[번호]\t[상품명]");
//		for(Product p : list) {
//			System.out.printf(" %3s\t  %s\n",p.getSeq(),p.getProductName());
//		}
		
		//System.out.println();
		
		String seq = "";
		boolean loop = true;
		int size = list.size();
		while(loop) {
			try {
				System.out.print("수정 상품 번호(1~"+size+"): ");
				seq = scan.nextLine();
				
				if(isEditNum(seq)) {
					loop = false;
				}else {
					System.err.println("😥 수정 번호가 틀립니다. 😥");	
				}
			}catch(Exception e) {
				System.err.println("😥 수정 번호가 틀립니다. 😥");	
			}
		}
	
	
		
		String line = null;
		
		while ((line = reader.readLine()) != null) {
			if (seq.equals(line.split(",")[0])) {
				//이 회원 정보를 수정해야 한다.
	
				break;
			}			
		}
		
		String[] temp = line.split(",");
		
		System.out.println();	
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		System.out.println("기존 상품명: " + temp[1]);
		
		String ProductName = "";
		loop = true;
		while(loop) {
			try {
				System.out.print("수정 상품명(수정하지 않으려면 그냥 엔터): ");
				ProductName = scan.nextLine();
				
				if (ProductName.equals("")) {
					ProductName = temp[1];
				
					loop = false;
				}else if(isOverlap(ProductName)) {
					System.err.println("😥 중복 상품명입니다. 😥");
				}else {
					loop = false;
				}
			}catch(Exception e) {
				System.err.println("😥 중복 상품명입니다. 😥");
			}
		}
		
		
		System.out.println();	
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		
		System.out.println("카테고리 여러개 입력시 띄어쓰기 ex)유제품 냉동");
		System.out.println("기존 카테고리: " + temp[2]);
		System.out.print("수정 카테고리(수정하지 않으려면 그냥 엔터): ");
		String Category = scan.nextLine();

		Category = Category.replace(" ", "■");
		
		if (Category.equals("")) {
			Category = temp[2];
		}
		
		System.out.println();	
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		
		System.out.println("기존 제조사(원산지): " + temp[3]);
		System.out.print("수정 제조사(수정하지 않으려면 그냥 엔터): ");
		String Manufacturer = scan.nextLine();
		if (Manufacturer.equals("")) {
			Manufacturer = temp[3];
		}
		
		System.out.println();	
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		System.out.println("대체어 여러개 입력시 띄어쓰기 ex)유제품 냉동");
		System.out.println("기존 대처어: " + temp[4]);
		System.out.print("수정 대체어(수정하지 않으려면 그냥 엔터): ");
		String Substitute = scan.nextLine();
		Substitute = Substitute.replace(" ", "■");
		
		if (Substitute.equals("")) {
			Substitute = temp[4];
		}
		
		System.out.println();	
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();	
		System.out.println("1. 플렉시테리언(🐮 🐷 🐓 🐟 🍳 🍼 🍎 🌿)");
		System.out.println("2. 폴로-페스코(🐓 🐟 🍳 🍼 🍎 🌿)");
		System.out.println("3. 페스코(🐟 🍳 🍼 🍎 🌿)");
		System.out.println("4. 락토-오보(🍳 🍼 🍎 🌿)");
		System.out.println("5. 오보(🍳 🍎 🌿)");
		System.out.println("6. 락토(🍼 🍎 🌿)");
		System.out.println("7. 비건(🍎 🌿)");
		System.out.println("8. 프로테리언(🍎)");
		System.out.println();
		System.out.println("기존 베지테리언: " + temp[5]);
		String Veg = "";
		loop = true;
		while(loop) {
			try {			
				System.out.print("수정 베지테리언(수정하지 않으려면 그냥 엔터): ");
				Veg = scan.nextLine();
				if (Veg.equals("")) {
					Veg = temp[5];
					loop = false;
				} else if(!(Integer.parseInt(Veg)>=1
						 && Integer.parseInt(Veg)<=8)) {
					System.err.println("😥 베지테리언(1~8단계)를 입력해주세요 😥");	
				}else {
					loop = false;
				}
			}catch(NumberFormatException e) {
				System.err.println("😥 베지테리언(1~8단계)를 입력해주세요 😥");
			}
		}	
		
		System.out.println();	
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		
		
		String Minor = "";
	
		System.out.println("미성년자 구매 가능 : T  | 미성년자 구매 못함: F ");
		System.out.println("기존 미성년자: " + temp[6]);
		loop = true;
		while(loop) {
			try {			
				System.out.print("수정 미성년자(수정하지 않으려면 그냥 엔터): ");	
				Minor = scan.nextLine();
				Minor = Minor.replace("t", "T");
				Minor = Minor.replace("f", "F");
				if (Minor.equals("")) {
					Minor = temp[6];
					loop = false;
				} else if((!Minor.equalsIgnoreCase("T") && (!Minor.equalsIgnoreCase("F")))) {
					System.err.println("😥 미성년자(T/F)를 입력해주세요 😥");	
				}else {
					loop = false;
				}
			}catch(NumberFormatException e) {
				System.err.println("😥 미성년자(T/F)를 입력해주세요 😥");	
			}
		}	
		
		
		
		System.out.println();	
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		
		System.out.println("기존 수량: " + temp[7]);
		System.out.println("숫자만 입력해주세요");
		String ProductCount="";
		loop = true;
		while(loop) {
			try {			
				System.out.print("수정 수량(수정하지 않으려면 그냥 엔터): ");
				ProductCount = scan.nextLine();
				if (ProductCount.equals("")) {
					ProductCount = temp[7];
					loop = false;
				} else if(Integer.parseInt(ProductCount)<=100) {
					System.err.println("😥 기본수량(100개) 보다 많이 입력해주세요 😥");	
				}else {
					loop = false;
				}
			}catch(NumberFormatException e) {
				System.err.println("😥 기본수량(100개) 보다 많이 입력해주세요 😥");	
			}
		}	
		System.out.println();	
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		
		System.out.println("기존 가격: " + temp[8]);
		System.out.println("숫자만 입력해주세요");
		String ProductPrice="";
		
		loop = true;
		while(loop) {
			try {			
				System.out.print("수정 가격(수정하지 않으려면 그냥 엔터): ");
				ProductPrice = scan.nextLine();
				if (ProductPrice.equals("")) {
					ProductPrice = temp[8];
					loop = false;
				} else if(!(Integer.parseInt(ProductPrice)>=100
						 &&Integer.parseInt(ProductPrice)<=1000000)) {
					System.err.println("😥 가격(100 ~ 1,000,000)을 입력해주세요 😥");	
				}else {
					loop = false;
				}
			}catch(NumberFormatException e) {
				System.err.println("😥 가격(100 ~ 1,000,000)을 입력해주세요 😥");	
			}
		}	
		System.out.println();	
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		
		pause("상품을 수정했습니다.");
		
		
		Product p = new Product();
		
		p.setSeq(seq);
		p.setProductName(ProductName);
		p.setCategory(Category);
		p.setManufacturer(Manufacturer);
		p.setSubstitute(Substitute);
		p.setVeg(Veg);
		p.setMinor(Minor);	
		p.setProductCount(ProductCount);
		p.setProductPrice(ProductPrice);
		
		//list.set(Integer.parseInt(seq)-1, p);
		
		
		reader.close();
		
		reader = new BufferedReader(new FileReader(Path.PRODUCTDIR));
		
		String txt = ""; //누적변수
		line = null;	
		while ((line = reader.readLine()) != null) {
			if (seq.equals(line.split(",")[0])) {
				txt += String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n"
										, seq
										, ProductName
										, Category
										, Manufacturer
										, Substitute
										, Veg
										, Minor
										, ProductCount
										, ProductPrice);
			} else {
				txt += line + "\r\n";
			}			
		}
		
		reader.close();
		
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(Path.PRODUCTDIR));
		writer.write(txt);
		writer.close();
		
		list.clear();
		
	}

	private static void save() throws Exception {
		
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(Path.PRODUCTDIR));
		
		for (Product p : list) {
			
			//Member m -> member.dat -> 1줄씩 저장
			String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s"
								, p.getSeq()
								, p.getProductName()
								, p.getCategory()
								, p.getManufacturer()
								, p.getSubstitute()
								, p.getVeg()
								, p.getMinor()
								, p.getProductCount()
								, p.getProductPrice());	
			writer.write(line);
			writer.newLine();
			
		}
		
		writer.close();
		
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


	private static void add() throws Exception {
		
		load();
		System.out.println();
		System.out.println("\t┌────────────┐");
		System.out.println("\t상품 등록하기");
		System.out.println("\t└────────────┘");
		
		
		String seq = getSeq();
		
		boolean loop = true;
		
		String ProductName="";
		String Category="";
		String Manufacturer="";
		String Substitute="";
		String Veg="";
		String Minor="";
		String ProductCount="";
		String ProductPrice="";
		
		System.out.println();
		while(loop) {
			System.out.print("상품명: ");
			ProductName = scan.nextLine();
				
			if (ProductName.equals("")) {
				System.err.println("😥 상품명을 입력해주세요 😥");
			}else if(isOverlap(ProductName)) {
				System.err.println("😥 중복 상품명입니다. 😥");
			}else {
				loop = false;
			}
				
			
		}
		
		loop = true;
		System.out.println();		
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		System.out.println("카테고리 여러개 입력시 띄어쓰기 ex)유제품 냉동");
		while(loop) {
			System.out.print("카테고리: ");
			
			Category = scan.nextLine();
			Category = Category.replace(" ", "■");
			
			if (Category.equals("")) {
				System.err.println("😥 카테고리를 입력해주세요 😥");	
			}else {
				loop = false;
			}
		}
		
		loop = true;
		System.out.println();		
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		System.out.println("ex)한국 미국 중국");
		while(loop) {
			System.out.print("제조사(원산지): ");
			Manufacturer = scan.nextLine();
	
			if (Manufacturer.equals("")) {
				System.err.println("😥 제조사를 입력해주세요 😥");	
			}else {
				loop = false;
			}
		}
		
		loop = true;
		System.out.println();		
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		System.out.println("대체어 여러개 입력시 띄어쓰기 ex)유제품 냉동");
		while(loop) {
			System.out.print("대체어: ");
			Substitute = scan.nextLine();
			Substitute = Substitute.replace(" ", "■");
		
			if (Substitute.equals("")) {
				System.err.println("😥 대체어를 입력해주세요 😥");	
			}else {
				loop = false;
			}
		}
		
		System.out.println();		
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		System.out.println("1. 플렉시테리언(🐮 🐷 🐓 🐟 🍳 🍼 🍎 🌿)");
		System.out.println("2. 폴로-페스코(🐓 🐟 🍳 🍼 🍎 🌿)");
		System.out.println("3. 페스코(🐟 🍳 🍼 🍎 🌿)");
		System.out.println("4. 락토-오보(🍳 🍼 🍎 🌿)");
		System.out.println("5. 오보(🍳 🍎 🌿)");
		System.out.println("6. 락토(🍼 🍎 🌿)");
		System.out.println("7. 비건(🍎 🌿)");
		System.out.println("8. 프로테리언(🍎)");
		System.out.println();
		
		loop = true;
		while(loop) {
			try {
				System.out.print("베지테리언(1~8 숫자 입력): ");
				Veg = scan.nextLine();
				
				if (!(Integer.parseInt(Veg)>=1 && Integer.parseInt(Veg)<=8)){
					System.err.println("😥 베지테리언(1~8단계)를 입력해주세요 😥");	
				}else {
					loop = false;
				}
			}catch(NumberFormatException e) {
				System.err.println("😥 베지테리언(1~8단계)를 입력해주세요 😥");	
			}
			
		}	
		
		loop = true;
		
		System.out.println();		
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		System.out.println("미성년자 구매 가능 : T  | 미성년자 구매 못함: F ");
		while(loop) {
			System.out.print("미성년자(T/F): ");
			Minor = scan.nextLine();
			Minor = Minor.replace("t", "T");
			Minor = Minor.replace("f", "F");
			if ((!Minor.equalsIgnoreCase("T") && (!Minor.equalsIgnoreCase("F")))) {
				System.err.println("😥 미성년자(T/F)를 입력해주세요 😥");	
			}else {
				loop = false;
			}
		}
	
		loop = true;
		System.out.println();		
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		while(loop) {
			try {
				
				System.out.print("수량(숫자만 입력): ");
				ProductCount = scan.nextLine();
				
				if (ProductCount.equals("")) {
					ProductCount = "100" ;
					System.out.println("기본 수량 100개");	
					loop = false;
				}else if(Integer.parseInt(ProductCount)<=100) {
					System.err.println("😥 기본수량(100개) 보다 많이 입력해주세요 😥");	
				}else {
					loop = false;
				}
			}catch(NumberFormatException e) {
				System.err.println("😥 기본수량(100개) 보다 많이 입력해주세요 😥");		
			}
		}	
		
		loop = true;
		System.out.println();		
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		while(loop) {
			try {
			    System.out.print("가격(숫자만 입력): ");
				ProductPrice = scan.nextLine();
				
				if (!(Integer.parseInt(ProductPrice)>=100
						 && Integer.parseInt(ProductPrice)<=1000000)) {
					System.err.println("😥 가격(100 ~ 1,000,000)을 입력해주세요 😥");	
				}else {
					loop = false;
				}
			}catch(NumberFormatException e) {
				System.err.println("😥 가격(100 ~ 1,000,000)을 입력해주세요 😥");	
			}
		}
		System.out.println();	
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		
	    BufferedWriter writer = new BufferedWriter(new FileWriter(Path.PRODUCTDIR, true));
	      writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n"
	                           , seq
	                           , ProductName
	                           , Category
	                           , Manufacturer
	                           , Substitute
	                           , Veg
	                           , Minor
	                           , ProductCount
	                           , ProductPrice));
	      writer.close();
	            
	      pause("상품을 등록했습니다.");
	      
	      list.clear();
	}

	//중복검사
	private static boolean isOverlap(String ProductName) {		
		
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

		return false;
		
		
	}
	
	//수정할 번호 검사
	private static boolean isEditNum(String seq) {		
			
			String str="";
			
			for(Product p : list) {
				str += p.getSeq()+",";
			}		
			
			String[] temp = str.split(",");
			
			for(int i=0;i<temp.length;i++) {
				if(seq.equals(temp[i])) {
					return true;
				}
			}
	
			return false;
			
			
	}
	private static boolean isDelNum(String seq) {		
		
		String str="";
		
		for(Product p : list) {
			str += p.getSeq()+",";
		}		
		
		String[] temp = str.split(",");
		
		for(int i=0;i<temp.length;i++) {
			if(seq.equals(temp[i])) {
				return true;
			}
		}

		return false;
		
		
}
	private static String getSeq() {
		
		if(list.size() == 0 ) {
			return "1";
		}
		return Integer.parseInt(list.get(list.size()-1).getSeq()) + 1 + "";				
	}

	private static void menu() {
		
		//System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		System.out.println("┌───────────────┐");
		System.out.println("1. 상품 등록하기");
		System.out.println("2. 상품 수정하기");
		System.out.println("3. 상품 삭제하기");
		System.out.println("4. 뒤로가기");
		System.out.println("└───────────────┘");
		//System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println(
							"￣￣￣￣￣＼／￣￣￣￣\r\n"
							+ "　　　　 ∧＿∧　　　　\r\n"
							+ "　　　（´・ω・） 　\r\n"
							+ "　＿＿_(っ 旦o＿＿\r\n"
							+ "　|l￣l||￣しﾞしﾞ￣|i\r\n"
							+ "");
	}
	
	private static void pause(String msg) {
		//잠시 휴식.. 프로그램 잠시 멈춤
		System.out.println();
		System.out.println(msg);
		System.out.println();
		System.out.println("계속하시려면 엔터키를 누르세요..");
		scan.nextLine();
	}
	
}








