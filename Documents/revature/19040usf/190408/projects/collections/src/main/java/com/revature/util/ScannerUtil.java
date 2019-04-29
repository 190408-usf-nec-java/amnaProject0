package com.revature.util;

import java.util.Scanner;

public class ScannerUtil {
	private static Scanner scanner = new Scanner(System.in);

	public static int getNumericChoice(int max) {
		int choice = -1;
		
		while(choice < 0 || choice > max) {
			System.out.println("");
			System.out.println("please enter a valid number between "
					+ "0 and " + max + ".");
			System.out.println("");
			
			if(scanner.hasNext()) {
				if(!scanner.hasNextInt()) {
					scanner.nextLine();
					continue;
				}
				choice = scanner.nextInt();
				
				scanner.nextLine();
			}
		}
		
		return choice;
	}
	
	public static String getLine() {
		return scanner.nextLine();
	}
	
	public static Double getDouble() {
		return scanner.nextDouble();
	}
	
	public static int getInteger() {
		return scanner.nextInt();
	}
}
