package com.java.project.mart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class ShoppingBag {
	private static Scanner scan;
	public static HashMap<Integer, Integer> map = new HashMap<>();
	
	private static String dir = Path.PRODUCTDIR;
	//private static String dir = Path.PRODIR;
	public static ArrayList<Product> list;

	static {
		scan = new Scanner(System.in);
		map = new HashMap<Integer, Integer>(); // 장바구니
		list = new ArrayList<Product>();

	}

	public static void run()  {
		
		int inputShopBag = 0;
		load();
		int inputShopBagCount = 0;
		int size = Integer.parseInt(list.get(list.size() - 1).getSeq());
		int count = 0;
		String name ="";
		System.out.println();
		System.out.println();
		
		System.out.println();
		System.out.println("😃장바구니에 담을 상품의 번호를 입력해주세요.😃");
		System.out.println();
		System.out.println("유효한 상품 번호 : 1 ~ "+size);
		System.out.println();

		System.out.print("입력: ");// seq

			while (true) {
				try {
				inputShopBag= scan.nextInt();
				System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
				
				if (inputShopBag <= size) {
					
					count = Integer.parseInt(list.get(inputShopBag-1).getProductCount());
					name = list.get(inputShopBag-1).getProductName();
					System.out.println();
					System.out.println("상품명: "+ name);
					System.out.println("상품의 재고: "+count);
					System.out.println();
					System.out.println("😃장바구니에 담을 상품의 수량을 입력해주세요.😃\r\n");
					System.out.println("😃수량은 구매하시고 싶으신 만큼 입력해주세요.😃\r\n");
					System.out.print("입력: ");// 수량
					if(count==0) {
						
						System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
						System.out.println();
						System.out.println("😥해당 상품은 품절입니다.😥");
						System.out.println("😥다른 상품을 구매해주세요.😥");
						System.out.println();
						System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
						run();
					}
					while (true) {
						try {
							inputShopBagCount = scan.nextInt();
							System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
							break;
						} catch (InputMismatchException ime) {
							// scan.close();
							scan = new Scanner(System.in);
							System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
							System.out.println("😥잘못된 수량 입력입니다.😥");
							System.out.println("😥숫자만 입력하세요.😥");
							System.out.print("입력: ");
							
						}
					}

					if (inputShopBagCount <= count) {
						try {
							bagList(inputShopBag, inputShopBagCount);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
						System.out.println("\r\n😥잘못된 수량입력입니다.😥\r\n😥다시 시도해주세요.😥\r\n");
						System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
						run();
					}
				} else {
					System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
					System.out.println("\r\n😥잘못된 상품 번호입니다.😥\r\n😥다시 시도해주세요.😥\r\n");
					System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
					run();
				}
				// >결제: 수량만큼 더미데이터에서 빼기
				} catch (InputMismatchException ime) {
					// scan.close();
					scan = new Scanner(System.in);
					System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
					System.out.println("\r\n😥잘못된 상품 번호 입력입니다.😥");
					System.out.println("😥숫자만 입력하세요.😥\r\n");
					System.out.print("입력: ");
				} catch(IndexOutOfBoundsException iobe) {
					
					scan = new Scanner(System.in);
					System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
					System.out.println("\r\n😥잘못된 상품 번호 입력입니다.😥");
					System.out.println("😃유효한 상품 번호를 입력해주세요.😃\r\n");
					System.out.println("유효한 상품 번호 : 1 ~ "+size);
					System.out.print("입력: ");
					
				}
			}
			
	}


	private static void load() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(dir));
			String line = null;

			while ((line = reader.readLine()) != null) {
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

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void bagList(int inputShopBag, int inputShopBagCount) throws Exception  {

		map.put(inputShopBag, inputShopBagCount);
		System.out.println("\r\n😃계속해서 입력하시겠습니까?😃");
		System.out.println();
		System.out.println(
				"┌───────────────┐\r\n"
				+ " 1. 계속 입력\r\n"
				+ " 2. 장바구니 출력\r\n"
				+ " 3. 장바구니 구매\r\n"
				+ " 0. 초기화면\r\n"
				+ "└───────────────┘\r\n"
				+ "　　ᕱ ᕱ ||\r\n"
				+ "　 ( ･ω･ ||\r\n"
				+ "　 /　つΦ");
		System.out.println();
		System.out.print("입력: ");
		try {
			int answer = scan.nextInt();
			if (answer == 1) {
				// 재귀호출
				run();
			} else if (answer == 2) {
				// 장바구니 목록 출력
				Set<Integer> keySet = map.keySet();
				if (!map.isEmpty()) {
					if (map.get(inputShopBag) == 0) {
						map.remove(inputShopBag);
					}
				}

				System.out.println("╭─────────────────────────╮\r\n"); 
				System.out.println("👜장바구니 출력👜\r\n");
				// key ==seq, seq 넘버로 값 불러오기!?
				String line = null;
				//값이 0이면 삭제해주기
				try {
					BufferedReader reader = new BufferedReader(new FileReader(dir));
					while ((line = reader.readLine()) != null) {
						for (Integer key : keySet) {
							String[] temp = line.split(",");
							String[] temp2 = temp[4].split("■");
							String strkey = key + "";
							if (temp[0].equals(strkey)) {
								
								System.out.println(temp[0] + "." + temp[1] + ":" + map.get(key) + "개");
								
							}
						}
					}
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println("╰─────────────────────────╯");
				bagList(inputShopBag, inputShopBagCount);
				//answerCheck();
				
				
			} else if (answer == 0) {

				MemberMainFrame.run(MainFrame.loginId);

			}else if(answer ==3) {
				ProductBuy.run();
			}
			
		}catch(InputMismatchException ime) {	
			System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		
		System.out.println("\r\n😥잘못된 입력입니다! 다시 시도해주세요😥\r\n");
		
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		scan = new Scanner(System.in);
		bagList(inputShopBag, inputShopBagCount);	
		}

		

	}

	private static void answerCheck() throws Exception {
		
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		
		System.out.println("\r\n😃계속해서 입력하시겠습니까?😃");
		System.out.println();
		System.out.println("0. 초기화면");
		System.out.println("1. 계속 입력");
		System.out.println("2. 장바구니 출력");
		System.out.println("3. 장바구니 구매");
		System.out.println();
		System.out.print("입력: ");
		int baganswer = scan.nextInt();
		System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
		
		if (baganswer == 1) {
			
			try {
				run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(baganswer ==2) {
			
		}else if (baganswer == 3) {
			
			ProductBuy.run();

		} else if (baganswer == 0) {
			
			// 초기화면
			MemberMainFrame.run(MainFrame.loginId);
		} else {
			System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			
			System.out.println("😥잘못된 입력입니다! 다시 시도해주세요😥");
			System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			
			answerCheck();
		}
		
	}


	

}