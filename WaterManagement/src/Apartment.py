import math
from Constants import Constants


class Apartment:

    def __init__(self, apartment_type, ratio):
        self.no_of_tenants = 0
        self.no_of_guests = 0
        self.monthly_water_allowance = 0
        self.total_bill_for_month = 0
        self.unit_cost = 0.0
        self.bore_well_ratio = 0
        self.corporation_ratio = 0
        self.slabs = Constants.TANKER_RATE
        
        if apartment_type == Constants.TWO_BHK:
            self.no_of_tenants = Constants.TENANTS_TWO_BHK

        elif apartment_type == Constants.THREE_BHK:
            self.no_of_tenants = Constants.TENANTS_THREE_BHK
        
        self.monthly_water_allowance += self.no_of_tenants * Constants.NO_OF_DAYS * Constants.ALLOTED_WATER_PER_DAY
        self.water_consumption_for_month = self.monthly_water_allowance

        self.allot_water(ratio)

    def add_guest(self, guest_count):
        self.no_of_guests += guest_count
        self.water_consumption_for_month += guest_count * Constants.ALLOTED_WATER_PER_DAY * Constants.NO_OF_DAYS

    def get_unit_cost(self):
        self.unit_cost = self.monthly_water_allowance / (self.bore_well_ratio + self.corporation_ratio)

    def allot_water(self, ratio):
        ratio = ratio.split(":")
        self.bore_well_ratio = int(ratio[1])
        self.corporation_ratio = int(ratio[0])
        self.get_unit_cost()

    def get_bill_for_bore_water(self):
        cost = self.unit_cost * self.bore_well_ratio * Constants.BOREWELL_WATER_RATE
        return cost

    def get_bill_for_corporation_water(self):
        cost = self.unit_cost * self.corporation_ratio * Constants.CORPORATION_WATER_RATE
        return cost

    def get_bill_for_guest_water(self, guest_usage):
        cost = 0

        for water_slab_bracket  in self.slabs:
            water_limit = water_slab_bracket[0]
            slab_rate = water_slab_bracket[1]

            if water_limit <= guest_usage:
                cost += slab_rate * water_limit
                guest_usage -= water_limit
            else:
                cost += slab_rate * guest_usage
                guest_usage = 0
                break

        if guest_usage > 0:
            cost += guest_usage * Constants.SLABRATE_FOR_3001L

        return cost 
    
    '''
    Method for calculating over all billl for total consumption of water
    '''
    def get_bill(self):
        #Bill For BoreWell
        self.total_bill_for_month += self.get_bill_for_bore_water()

        #Bill for Corporation
        self.total_bill_for_month += self.get_bill_for_corporation_water()

        #Bill for guest consumption
        guest_usage = self.water_consumption_for_month - self.monthly_water_allowance
        self.total_bill_for_month += self.get_bill_for_guest_water(guest_usage)

        self.total_bill_for_month = math.ceil(self.total_bill_for_month)

    













        
