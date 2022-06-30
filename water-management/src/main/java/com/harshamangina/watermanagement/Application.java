package com.harshamangina.watermanagement;

import java.util.List;


import com.harshamangina.watermanagement.Entity.Apartment;
import com.harshamangina.watermanagement.Exception.serviceException;
import com.harshamangina.watermanagement.Service.Operations.BillOperation;
import com.harshamangina.watermanagement.Service.Operations.inputProcessor;

public class Application {
	//static String demoPath = "inputs/input1.txt";

	public static void main(String[] args) throws serviceException {

		if(args.length==0){
			throw new serviceException("No input file supplied, Please try again");
		}

		try{

				Apartment apartment = new Apartment();
				BillOperation service = null;

				//File Processing
				inputProcessor fileprocessor = new inputProcessor(args[0]);
				//Extracting the Commands from I/P File.
				List<String> commands  = fileprocessor.getCommnadsFromFile();
				for(String cmd : commands) {
					String[] arguments = cmd.split(" ");

					//Command : ALLOT_WATER 
					if(arguments[0].equals("ALLOT_WATER")){
						String[] shareSplit = arguments[2].split(":");
						apartment.AllotWater(Integer.parseInt(arguments[1]), Integer.parseInt(shareSplit[0]), Integer.parseInt(shareSplit[1]));
					}

					//Command : ADD_GUEST
					else if(arguments[0].equals("ADD_GUESTS")){
						apartment.addGuets(Integer.parseInt(arguments[1]));
					}

					//Command : BILL
					else if(arguments[0].equals("BILL")){
						service = new BillOperation(apartment);
						System.out.println(service.generateBill());
					}
				}
		}
		
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}

