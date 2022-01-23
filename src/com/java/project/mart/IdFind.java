package com.java.project.mart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class IdFind {
	static String name;
	static String tel;
	public static void idFindRun(){
		System.out.println(title.IDFIND);	
		System.out.println("\n계정을 잃어버리셨나요?\n");
		System.out.println("순서대로 이름과 전화번호를 입력해주세요.\n");
		System.out.print("이름 : ");
		Scanner scan = new Scanner(System.in);
		name = scan.nextLine();
		System.out.println("전화번호를 010-0000-0000 형식으로 입력해주세요.");
		System.out.print("전화번호 : ");
		tel = scan.nextLine();
		runIdFind();
		IdNew.pause("");
	}
	public static boolean runIdFind(){
		File src = new File(Path.MEMBERDIR);
		String line;
		try {			
			BufferedReader buf = new BufferedReader(new FileReader(src));
			while((line = buf.readLine()) != null) {
				String[] spline = line.split(",");
				if(name.equals(spline[2]) && tel.equals(spline[4])) {
					System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
					System.out.println(name + "님의 계정정보 입니다.");
					System.out.println("id : " + spline[0]);
					System.out.println("password : " + spline[1]);
					System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
				
					return true;
				}
			}
		} catch (Exception e) {
		}
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		System.out.println(name + "님의 계정정보를 찾을 수 없습니다.");
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		return false;
	}
}
