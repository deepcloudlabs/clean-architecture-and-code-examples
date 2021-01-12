package com.example;

import java.util.WeakHashMap;
// comment
/* 
 * comment
 * 
 * */
// javadoc -> internal documentation -> external (browseable html/css)
/**
 * Manages Account Entities
 * @author dcl
 *
 */
public interface AccountService {
	                     // intention?
	/**
	 * 
	 * @author dcl
	 *
	 */
	public Account       getNextActiveAccount();
	/**
	 * 
	 * @return
	 */
	public WeakHashMap<String,Account> getActiveAccounts();
	public Account       getActiveAccountInfo();
}
