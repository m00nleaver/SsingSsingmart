package com.java.project.mart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class UserInfoList {
	
	private static Scanner scan;
	
	static {
		
		scan = new Scanner(System.in);
		
	}
	
	public UserInfoList() throws Exception {
		
		list();
		
		boolean loop = true;
		
		while (loop) {
			
			System.out.println("0. 뒤로가기");
			System.out.println();
			System.out.print("입력: ");
			String input = scan.nextLine();
			
			if (input.equals("0")) {
				
				System.out.println();
				ManagerMainFrame m = new ManagerMainFrame();
				loop = false;
			} else {
				
				System.out.println();
				System.out.println("😥 올바른 번호를 입력해주세요. 😥");
				System.out.println();
			}
			
		}
		
		
	}

	private void list() throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader(Path.MEMBERDIR));
		System.out.println("                          ┌────────────┐");
		System.out.println("                          회원 정보 조회");
		System.out.println("                          └────────────┘");
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		
		String line = null;
		int i = 1;
		System.out.println();
		System.out.println("[번호]      [아이디]\t[이름]   [나이]\t  [전화번호]\t[주소지]\t[베지테리언단계]");
		
		while ((line = reader.readLine()) != null) {
			
			String[] temp = line.split(",");
			
			if (!temp[0].equals("admin")) {
				
				System.out.printf("%3d    %13s\t%s\t%3d\t%s\t%4d\t%6d\r\n"
						, i
						, temp[0]
								, temp[2]
										, Integer.parseInt(temp[3])
										, temp[4]
												, Integer.parseInt(temp[5])
												, Integer.parseInt(temp[6]));
				
				i++;
			}
			
		}
		
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println();
		
		reader.close();
		
	}
	
}//회원정보조회