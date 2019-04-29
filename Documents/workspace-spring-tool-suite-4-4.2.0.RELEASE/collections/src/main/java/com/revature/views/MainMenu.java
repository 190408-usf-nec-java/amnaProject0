package com.revature.views;

import com.revature.util.ScannerUtil;

public class MainMenu implements View {

	@Override
	public View printOptions() {
		System.out.println("");
		System.out.println("	WELCOME TO BANK OF JAVA");
		System.out.println("------------------------------------------------------");
		System.out.println("1.	CREATE A USER");
		System.out.println("2.	USER LOGIN");
		System.out.println("0.	QUIT");
	
		int selection = ScannerUtil.getNumericChoice(2);
		
		switch(selection) {
		case 1: return new UserView();
		case 2: return new LoginView();
		default: return null;
		}
		
	}

}