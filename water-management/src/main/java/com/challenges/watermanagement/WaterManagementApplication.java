package com.challenges.watermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.challenges.inputParser;
import com.challenges.watermanagement.Exception.BillException;
import com.challenges.watermanagement.Service.BillService;
import com.challenges.watermanagement.Entity.Apartment;
import com.challenges.watermanagement.Enum.Commands;

public class WaterManagementApplication {

	public static void main(String[] args) {
		try{
			if(args.length < 0){
				throw new BillException("No input file found, Please try again");
			}

			Apartment apartment = new Apartment();
			inputParser parser = new inputParser();
			BillService service = new BillService();
			List<String> inputLine = parser.getCommands("/home/yolo/Projects/Challenges/water-management/src/main/resources/inputs/input1.txt");

			for(String string : inputLine){
				String[] commands = string.split(" ");

				if(Commands.valueOf(commands[0]) == (Commands.ALLOT_WATER)){
					String[] share = commands[2].split(":");
					apartment.AllotWater(Integer.parseInt(commands[1]), Integer.parseInt(share[0]), Integer.parseInt(share[1]));
				}

				if(Commands.valueOf(commands[0]) == (Commands.ADD_GUEST)){
					apartment.addGuest(Integer.parseInt(commands[1]));
				}

				if(Commands.valueOf(commands[0]) == Commands.BILL){
					System.out.println(service.getBill());
				}
			}

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
