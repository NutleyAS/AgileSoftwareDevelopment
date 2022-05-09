/*
 * Name: Aron Nutley
 * Student Number:G00388055
 * Course: HDip Software Development
 * Subject: Agile Software Development
 * Title: Assignment 2 (2021)
 */

package ie.gmit.dip;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InsuranceProgramTest {

	public static InsuranceProgram insuranceProgram;

	@BeforeAll
	public static void initialMessage() {
		System.out.println("Insurance Program Tests are starting...");
	}

	@BeforeEach
	public void startUpMessage() {
		insuranceProgram = new InsuranceProgram();
	}

	@AfterEach
	public void singleTestCompletedMessage() {
		System.out.println("This test has completed.");
	}
	
	@AfterAll
	public static void finalMessage() {
		System.out.println("InsuranceProgramTest's complete.");

	}

	

	@ParameterizedTest
	@CsvSource({ "0, 29", "0, 14", "100, 19", "100, 21", "100, 19", "0, 50", "0, 28" })
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void generateAgeSurchargeTest(int expectedResult, int age) {
		System.out.println("generateAgeSurchargeTest() has begun.");
		assertEquals(expectedResult, insuranceProgram.generateAgeSurcharge(age));
	}

	@ParameterizedTest
	@CsvSource({ "50, 1", "0, 8", "375, 4", "0, 41", "575, 5", "225, 3" })
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void generateAccidentSurchargeTest(int expectedResult, int accidents) {
		System.out.println("generateAccidentSurchargeTest() has begun.");
		assertEquals(expectedResult, insuranceProgram.generateAccidentSurcharge(accidents));

	}

	@ParameterizedTest
	@CsvSource({ "825, 23, 3", "1175, 17, 5", "550, 32, 1", "725, 26, 3", "875, 56, 4" })
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void generateTotalCostTest(int expectedResult, int age, int accidents) {
		System.out.println("generateTotalCostTest() has begun.");
		assertEquals(expectedResult, insuranceProgram.generateTotalCost(age, accidents));
	}
	


}
