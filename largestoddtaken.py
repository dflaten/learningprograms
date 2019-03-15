#Integers -> Integer
#Takes 10 integers from user and prints largest odd integer
#def FindLargestOddInt(list[]):
#    return largestodd
import sys

usernumbers = []

for n in range (0,10):
   try:
      usernumbers.append(int(input("Input 10 integers one at a time:")))
      n += 1
   except ValueError:
      print("Not an integer value...")
usernumbers.sort()
#currently prints all odd numbers starting with largest, need it to stop after one.
for number in reversed(usernumbers):
   if number % 2 != 0:
      print ("Largest odd number is: " + str(number))
      break
#these don't currntly test due to needing a method to fake a user entering the numbers from the command line.            
def test_answer():
    assert FindLargestOddInt(1,2,3,4,5,6,7,8,9,10) == 9
def test_answer():
    assert FindLargestOddInt(-5l,2,3,4,5,6,7,8,12,10) == 7
