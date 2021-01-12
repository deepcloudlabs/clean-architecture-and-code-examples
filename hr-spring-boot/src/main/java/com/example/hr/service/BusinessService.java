package com.example.hr.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
	
    // async -> Thread
	@Async
	public void longRunningMethod1() { // Fire&Forget
		// long running process -> rest call, databases, bulk
	}
	@Async
	public CompletableFuture<Integer> longRunningMethod2() { // Fire&Forget
		CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
		Executors.newCachedThreadPool().submit(() -> {
			try {
				Thread.sleep(10_000);
			} catch (InterruptedException e) {
			}
			completableFuture.complete(42);			
		});
		return completableFuture;
	}
}
