package com.revature.views;

import com.revature.services.AccountsService;
import com.revature.services.UserService;
import com.revature.util.ScannerUtil;

public class DepositWithdrawView implements View {
	
	UserService accountService = new UserService();
	
	@Override
	public View printOptions() {
		System.out.println("");
		System.out.println("");
		System.out.println("********************************");
		System.out.println("**********TRANSACTIONS**********");
		System.out.println("********************************");
		System.out.println("1:	WITHDRAW AND DEPOSIT");
		System.out.println("2:	TRANSFER MONEY");
		System.out.println("0.	GO BACK TO ACCOUNTS");
		
		int selection = ScannerUtil.getNumericChoice(2);

		switch (selection) {
		
		case 1:
		this.accountService.createAccounts();
			return this;
		case 2:
			this.accountService.transferMoney();
			return this;
		default:
			return new AccountView();
	}

}
}