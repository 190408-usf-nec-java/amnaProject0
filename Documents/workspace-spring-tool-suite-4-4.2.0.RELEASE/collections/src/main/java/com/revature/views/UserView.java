package com.revature.views;

import com.revature.beans.MultipleAccounts;
import com.revature.services.AccountsService;
import com.revature.services.MultipleAccountServices;
import com.revature.services.UserService;
import com.revature.util.ScannerUtil;

public class UserView implements View {

	UserService userService = new UserService();
	
	@Override
	public View printOptions() {
		System.out.println("");
		System.out.println("THANK YOU FOR CHOOSING TO BANK");
		System.out.println("          WITH US");
		System.out.println("********************************");

		System.out.println("1. CREATE USER");
		System.out.println("0. RETURN TO MAIN MENU");

		int selection = ScannerUtil.getNumericChoice(1);

		switch (selection) {
		case 1:
			this.userService.createUser();
			return this;
		default:
			return new MainMenu();
		}
	}

}
