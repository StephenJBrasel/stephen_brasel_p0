package com.revature.revabank.screens;

import com.revature.revabank.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.revature.revabank.AppDriver.app;

public class HomeScreen extends Screen{
	//region Constructors
	public HomeScreen() {
		super("HomeScreen", "/home");
//		System.out.println("[LOG] - Instantiating " + this.getClass().getName());
	}

	//endregion

	//region Overridden Methods
	@Override
	public void render() {
		System.out.println(	"\n" +
				"____/\\\\\\\\\\\\\\\\\\______/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\__/\\\\\\________/\\\\\\_____/\\\\\\\\\\\\\\\\\\_____/\\\\\\\\\\\\\\\\\\\\\\\\\\_______/\\\\\\\\\\\\\\\\\\_____/\\\\\\\\\\_____/\\\\\\__/\\\\\\________/\\\\\\_        \n" +
				" __/\\\\\\///////\\\\\\___\\/\\\\\\///////////__\\/\\\\\\_______\\/\\\\\\___/\\\\\\\\\\\\\\\\\\\\\\\\\\__\\/\\\\\\/////////\\\\\\___/\\\\\\\\\\\\\\\\\\\\\\\\\\__\\/\\\\\\\\\\\\___\\/\\\\\\_\\/\\\\\\_____/\\\\\\//__       \n" +
				"  _\\/\\\\\\_____\\/\\\\\\___\\/\\\\\\_____________\\//\\\\\\______/\\\\\\___/\\\\\\/////////\\\\\\_\\/\\\\\\_______\\/\\\\\\__/\\\\\\/////////\\\\\\_\\/\\\\\\/\\\\\\__\\/\\\\\\_\\/\\\\\\__/\\\\\\//_____      \n" +
				"   _\\/\\\\\\\\\\\\\\\\\\\\\\/____\\/\\\\\\\\\\\\\\\\\\\\\\______\\//\\\\\\____/\\\\\\___\\/\\\\\\_______\\/\\\\\\_\\/\\\\\\\\\\\\\\\\\\\\\\\\\\\\__\\/\\\\\\_______\\/\\\\\\_\\/\\\\\\//\\\\\\_\\/\\\\\\_\\/\\\\\\\\\\\\//\\\\\\_____     \n" +
				"    _\\/\\\\\\//////\\\\\\____\\/\\\\\\///////________\\//\\\\\\__/\\\\\\____\\/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\_\\/\\\\\\/////////\\\\\\_\\/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\_\\/\\\\\\\\//\\\\\\\\/\\\\\\_\\/\\\\\\//_\\//\\\\\\____    \n" +
				"     _\\/\\\\\\____\\//\\\\\\___\\/\\\\\\________________\\//\\\\\\/\\\\\\_____\\/\\\\\\/////////\\\\\\_\\/\\\\\\_______\\/\\\\\\_\\/\\\\\\/////////\\\\\\_\\/\\\\\\_\\//\\\\\\/\\\\\\_\\/\\\\\\____\\//\\\\\\___   \n" +
				"      _\\/\\\\\\_____\\//\\\\\\__\\/\\\\\\_________________\\//\\\\\\\\\\______\\/\\\\\\_______\\/\\\\\\_\\/\\\\\\_______\\/\\\\\\_\\/\\\\\\_______\\/\\\\\\_\\/\\\\\\__\\//\\\\\\\\\\\\_\\/\\\\\\_____\\//\\\\\\__  \n" +
				"       _\\/\\\\\\______\\//\\\\\\_\\/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\______\\//\\\\\\_______\\/\\\\\\_______\\/\\\\\\_\\/\\\\\\\\\\\\\\\\\\\\\\\\\\/__\\/\\\\\\_______\\/\\\\\\_\\/\\\\\\___\\//\\\\\\\\\\_\\/\\\\\\______\\//\\\\\\_ \n" +
				"        _\\///________\\///__\\///////////////________\\///________\\///________\\///__\\/////////////____\\///________\\///__\\///_____\\/////__\\///________\\///__\n"+
				"Welcome to RevaBank! Please select an option:\n" +
				"=============================================\n" +
				"1. Login\n" +
				"2. Register\n" +
				"3. Exit Application\n" +
				"> ");
		String input = "";
		try {
			input = app.getConsole().readLine().trim();
			switch (input.toLowerCase()) {
				case "1": case "login":
					app.getRouter().navigate("/login");
					break;
				case "2": case "register":
					app.getRouter().navigate("/register");
					break;
				case "3": case "exit":
					app.setAppRunning(false);
					break;
					//region testing
				case "hi": case "hello":
					System.out.println("Well, hello!");
					break;
				case "roll tide!":
					System.out.println("Roll Tide!");
					break;
					//endregion
				default:
//					System.out.println("[LOG] - Invalid Selection!");
					break;
			}
		} catch (IOException ioe) {
			System.out.println("An exception occurred. Please try again.");
//			ioe.printStackTrace();
		}

	}

	//endregion
}
