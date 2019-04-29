package com.revature.views;

import com.revature.services.MultipleAccountServices;
import com.revature.services.UserService;
import com.revature.util.ScannerUtil;

public class AccountView implements View {
	
	UserService multipleService = new UserService();
	
	@Override
	public View printOptions() {
		System.out.println("");
		System.out.println("**_____________________________________**");
		System.out.println("|							|");
		System.out.println("|	1:	CREATE ACCOUNT   	|");
		System.out.println("|	2:	VIEW ACCOUNT     	|");
		System.out.println("|	0.  	GO BACK TO MENU 	|");
		System.out.println("**_____________________________________**");
		
		int selection = ScannerUtil.getNumericChoice(2);

		switch (selection) {
		
		case 1:
			this.multipleService.createMultipleAccounts();
			return this;
		case 2:
			this.multipleService.getAccountById();
			return new DepositWithdrawView();
		default:
			return new UserView();
	}

}
}
