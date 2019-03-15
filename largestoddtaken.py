#Integers -> Integer
#Takes 10 integers from user and prints largest odd integer
#def FindLargestOddInt(list[]):
#    return largestodd
# PLACEHOLDER - Unit Test One
# PLACEHOLDER - Unit Test Two
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
           
