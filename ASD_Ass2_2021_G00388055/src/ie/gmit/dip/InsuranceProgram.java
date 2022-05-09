/*
 * Name: Aron Nutley
 * Student Number:G00388055
 * Course: HDip Software Development
 * Subject: Agile Software Development
 * Title: Assignment 2 (2021)
 */

package ie.gmit.dip;

import java.util.Scanner;

public class InsuranceProgram {

	private static final int basicInsurance = 500;
	private int ageSurcharge;
	private int accidentSurcharge;
	private int totalCost;

	//Method gets user to input int values, calls on other methods, then prints to the console
	public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter your age:");
		int age = input.nextInt();
		if (age < 17) {  
			System.out.println("You are too young to drive in Ireland. We cannot provide you with insurance.");
			} else {
				System.out.println("How many accidents have you had?");
				int accidents = input.nextInt();
				if (accidents > 5) {
					System.out.println("Sorry you have had too many accidents for us to provide you with insurance.");
			} else {
				System.out.println("Basic Insurance: €" + new InsuranceProgram().getBaseRate());
				System.out.println("Surcharge: €" + new InsuranceProgram().generateAgeSurcharge(age));
				System.out.println("Accident(s) Surcharge: €" + new InsuranceProgram().generateAccidentSurcharge(accidents));
				System.out.println("Total Cost : €" + new InsuranceProgram().generateTotalCost(age, accidents));
			}
		}
			input.close();
	}

	public int getBaseRate() { // Method that calls for the basic insurance rate
		return basicInsurance;
	}


	protected int generateAgeSurcharge(int age) { //Method that calculates the surcharge for age
		if (age < 25 && age >= 17) {
			ageSurcharge = 100;
		} else {
			ageSurcharge = 0;
		}
		return ageSurcharge;
	}

	protected int generateAccidentSurcharge(int accidents) { //Method that calculates the accident surcharge
		switch (accidents) {
		case 0:
			accidentSurcharge = 0;
			break;
		case 1:
			accidentSurcharge = 50;
			break;
		case 2:
			accidentSurcharge = 125;
			break;
		case 3:
			accidentSurcharge = 225;
			break;
		case 4:
			accidentSurcharge = 375;
			break;
		case 5:
			accidentSurcharge = 575;
			break;
		default:
			accidentSurcharge = 0;
		}
		return accidentSurcharge;
	}
	
	//Method which generates the total cost
	protected int generateTotalCost(int age, int accidents) {
		if (age < 25 && age >= 17) {
			ageSurcharge = generateAgeSurcharge(age);
			accidentSurcharge = generateAccidentSurcharge(accidents);
			totalCost = basicInsurance + ageSurcharge + accidentSurcharge;
		} else {
			ageSurcharge = generateAccidentSurcharge(accidents);
			totalCost = basicInsurance + accidentSurcharge;
		}
		return totalCost;
	}
}
