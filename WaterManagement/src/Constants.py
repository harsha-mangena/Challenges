#This class only contains the constants that are used along the methods.

class Constants:

    def __init__(self):
        pass

    #Commands
    ALLOT_WATER = "ALLOT_WATER"
    ADD_GUESTS = "ADD_GUESTS"
    BILL = "BILL"

    #Error Messages
    INVALID_NO_OF_ARGUMENTS = "Invalid number of arguments"


    #Apartment 
    TWO_BHK = 2
    THREE_BHK = 3
    TENANTS_TWO_BHK = 3
    TENANTS_THREE_BHK = 5
    NO_OF_DAYS = 30
    ALLOTED_WATER_PER_DAY = 10

    #Rates
    CORPORATION_WATER_RATE = 1
    BOREWELL_WATER_RATE = 1.5
    TANKER_RATE = [ [500, 2.0], 
                   [1000, 3.0],
                   [1500, 5.0] ]
    SLABRATE_FOR_3001L = 8.0


