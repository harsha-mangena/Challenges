import sys
sys.path.insert(0, "/home/yolo/Projects/Challenges/WaterManagement/src")

import unittest

from Apartment import Apartment

class TestForGenerateBill(unittest.TestCase):

    def __init__(self) -> None:
        self.apartment_test  = Apartment(3, "3:5")

    def test_for_generate_bill(self):
        expected_result = 3300
        self.assertEqual(self.apartment_test.generate_bill(), expected_result)




if __name__ == "__main__":
    unittest.main()