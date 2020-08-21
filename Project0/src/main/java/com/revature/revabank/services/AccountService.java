package com.revature.revabank.services;

import com.revature.revabank.models.*;
import com.revature.revabank.repos.AccountRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import static com.revature.revabank.AppDriver.app;

public class AccountService {
	private AccountRepository accountRepo;

	//region Constructors

	public AccountService(AccountRepository accountRepo) {
		System.out.println("[LOG] - Instantiating " + this.getClass().getName());
		this.accountRepo = accountRepo;
	}

	//endregion

	//region Methods
	public Set<Account> getAllAccounts() {
		return null;
	}

	public Set<Account> getAccountsByUser() {
		return null;
	}

	public Set<Account> getAccountsById() {
		return null;
	}

	public Account getAccountById(int id) {
		return null;
	}

	public Account getAccountByAccountName(String name) {
		return null;
	}

	public double deposit(double amount) {
		//edge cases
		if (amount < 0) {
			//TODO throw new custom exception
			throw new RuntimeException("Negative deposits are not allowed.");
		}
		if (amount + app.getCurrentAccount().getBalance() == Double.POSITIVE_INFINITY) { //
			//TODO throw new custom exception
			throw new RuntimeException("Infinite Money. You've crashed all economies.");
		}
		app.getCurrentAccount().setBalance(app.getCurrentAccount().getBalance() + amount);

		//TODO Get Transaction Description
		String description = "";
		String id = Integer.toString(
				(LocalDate.now().toString() +
						description +
						amount +
						app.getCurrentAccount().toString() +
						app.getCurrentAccount().getBalance() +
						app.getCurrentAccount().getOwner().toString() +
						""
				)
						.hashCode());
		Transaction t = new Transaction(id,
				description,
				amount,
				app.getCurrentAccount(),
				app.getCurrentAccount().getOwner(),
				null
		);
		return app.getCurrentAccount().getBalance();
	}

	/**
	 * Withdraws amount from account and returns the amount withdrew.
	 *
	 * @param amount The amount to withdraw
	 * @return amount
	 */
	public double withdraw(double amount) {
		//edge cases
		if (amount < 0) {
			//TODO throw new custom exception
			throw new RuntimeException("Negative withdrawals are not allowed.");
		}
		if (Double.compare((app.getCurrentAccount().getBalance() - amount), 0) < 0) { //
			//TODO throw new custom exception
			throw new RuntimeException("Withdrawal failed: lack of funds.");
		}
		app.getCurrentAccount().setBalance(app.getCurrentAccount().getBalance() - amount);
		return amount;
	}

	public void addAccount(String accountType){
		Account acc = null;
		switch (accountType.toLowerCase()){
			case "1": case "saving": case "savings": default:
				acc = new AccountChecking();
				break;
			case "2": case "checking": case "checkings":
				acc = new AccountSavings();
				break;
		}
		app.getCurrentUser().addAccount(acc);
	}
	//endregion
}
