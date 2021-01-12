package com.example.app;

import com.example.service.AccountService;

public class App {

	public static void main(String[] args) {
		AccountService accSrv = new AccountService();
		System.out.println(accSrv.fun());
	}

}
