package com.example.demo.ticket;

import java.util.UUID;

import net.bytebuddy.utility.RandomString;

public class PNRGenerator {

	public static String getPNRNumber() {
		String randomString = usingUUID();
		System.out.println("Random string is: " + randomString);
		System.out.println("Random string of 8 characters is: " + randomString.substring(0, 8));
		return randomString.substring(0, 6);

	}

	static String usingUUID() {
		UUID randomUUID = UUID.randomUUID();
		return randomUUID.toString().replaceAll("-", "");
	}
}
