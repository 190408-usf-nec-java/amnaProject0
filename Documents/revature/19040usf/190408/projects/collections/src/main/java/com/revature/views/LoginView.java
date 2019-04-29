package com.revature.views;
import com.revature.services.UserService;
import com.revature.util.ScannerUtil;

public class LoginView implements View {

	UserService userService = new UserService();
	
	@Override
	public View printOptions() {
		System.out.println("");
		System.out.println("'''''''''WELCOME BACK'''''''''");
		System.out.println("1. LOGIN");
		System.out.println("0. BACK");

		int selection = ScannerUtil.getNumericChoice(3);

		switch (selection) {
		case 1:
			this.userService.getUserById();
				return new AccountView();
		case 2:
			return new AccountView();
		default:
			return new MainMenu();
	}
	}
}

