package com.example.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BusinessClientService {
	@Autowired BusinessService businessService;
	
	@Scheduled(fixedRate = 5_000)
	public void fun() {
		businessService.longRunningMethod2()
		               .thenAcceptAsync(System.out::println);
	}
}
