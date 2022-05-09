/*
 * Name: Aron Nutley
 * Student Number:G00388055
 * Course: HDip Software Development
 * Subject: Agile Software Development
 * Title: Assignment 2 (2021)
 */

package ie.gmit.dip;

import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class InsuranceProgramAddTests {

	public static InsuranceProgram insuranceProgramAdd;
	
	@BeforeEach
	public void startUpMessage() {
		insuranceProgramAdd = new InsuranceProgram();
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void getBaseRateTest() {
		System.out.println("getBaseRateTest() has began");
		int baseValue = insuranceProgramAdd.getBaseRate();
		assertEquals(500, baseValue);

	}

	@Test
	public void uninsurableTest() {
		System.out.println("uninsurableTest() has begun");
		int age = 16;
		int accidents = 4;
		assertThrows(IllegalArgumentException.class, () -> {
			if (age <= 17 || accidents > 5)
				throw new IllegalArgumentException();
			System.out.println("Invalid entry check age and accidents.");
		});
	}
	
	@Test
	public void inputMissmatchTest() {
		System.out.println("InputMismatch() has begun");
		assertThrows(InputMismatchException.class, () -> {
			Object input = "ten";
			if (input instanceof String)
				throw new InputMismatchException();
			System.out.println("InputMismatchException thrown. Check input.");
		});
	}
}
