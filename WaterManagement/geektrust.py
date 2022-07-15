import sys
sys.path.insert(0, "/home/yolo/Projects/Challenges/WaterManagement/src")

from sys import argv

from Apartment import Apartment
from Constants import Constants



'''
This method is for splitting commands and their respective arguments
'''
def get_commands_and_arguments_from_file(line):

    splitted_text = line.strip("\n").split(" ")
    command = splitted_text[0]
    arguments = splitted_text[1:]

    return command, arguments
    
'''
This method checks if the given arguments for a command are valid or not
'''        
def are_valid_arguments(command, arguments,required_arguments):
    if(len(arguments) !=  required_arguments):
        raise ValueError(command + " : " + Constants.INVALID_NO_OF_ARGUMENTS)
    return True


'''
Main method 
'''
def main():
    
    #If passed arguments is less than 0, then throw exception
    if(len(argv) != 2):
        raise Exception("Please pass the input file path")
    
    file_path = argv[1]

    with open(file_path, 'r') as fileReader:
        Lines = fileReader.readlines()
        for line in Lines:
            command, arguments = get_commands_and_arguments_from_file(line)

            if command ==  Constants.ALLOT_WATER:
                #Check if the command and argumnets passed are valid not not.
                if(are_valid_arguments(command, arguments, 2)):
                    apartment = Apartment(int(arguments[0]), arguments[1])

            if command == Constants.ADD_GUESTS:
                #Check if the command and argumnets passed are valid not not.
                if(are_valid_arguments(command, arguments, 1)):
                    apartment.add_guest(int(arguments[0]))

            if command == Constants.BILL:
                apartment.get_bill()
    
    total_water_consumption = apartment.water_consumption_for_month
    bill = apartment.total_bill_for_month
    print(total_water_consumption, bill)

if __name__ == "__main__":
    main()





