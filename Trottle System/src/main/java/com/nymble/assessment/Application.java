package com.nymble.assessment;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.nymble.assessment.Exceptions.MyException;
import com.nymble.assessment.throttleController.throttleController;
import com.nymble.assessment.throttleController.throttleControllerImpl;


public class Application {

	private static Integer Throttle;
	private static Integer cruiseSpeed;
	private static Scanner sc = new Scanner(System.in);

	/**
	 * This is getter method for the Throttle
	 * @return Throttle Integer
	 */

	public static Integer getThrottle() {
		return Throttle;
	}

	/**
	 * This is setter method for Throttle
	 * @param throttle
	 */

	public static void setThrottle(Integer throttle) {
		Throttle = throttle;
	}

	/**
	 * We will be using an getInput() method from inputParser class to get our List of Speed 
	 * 		@param path : File Location
	 * 		@throws IOException
	 * Then we will be iterating over the speeds and getting the Throttle Level for each speed.
	 * @param args
	 * @throws IOException
	 * @throws MyException
	 */

	public static void main(String[] args) throws IOException, MyException {

		inputParser parser = new inputParser();	
		List<Integer> speeds = parser.getInput("src/main/resources/input_speed.txt");

		//throttleController object for throttleControllerImpl. 
		throttleController controller = new throttleControllerImpl();

		System.out.println("Enter cruise Speed : ");
		//Setting Cruise Speed
		cruiseSpeed = sc.nextInt();
		controller.setCruiseSpeed(cruiseSpeed);

		//Iterating through all the speeds and getting the throttleLevel.
		for(Integer speed : speeds) {
			setThrottle(controller.calculateThrottle(speed));
			//System.out.println("Speed :" + speed + " || Throttle: " + getThrottle());
			System.out.println(getThrottle());
		}

		//closing Scanner.
		ScannerClose();

	}

	/**
	 * This method closes our Scanner object after completion of the execution.
	 */

	private static void ScannerClose() {
		sc.close();
	}
}

