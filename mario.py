import sys
while True:
    n = None
    while n is None:
       try:
          n = int(input("Pyramid Height: "))
       except ValueError:
          print("Not an integer value...")
    if 0 < n < 23:
        break
    #for loop to build the entire pyramid until a is bigger than n
for a in range(2,n+2):
    j = 0
    #for loop that adds spaces in front of the pyramid to right align
    for j in range(0,((n+2)-a)):
        print(" ", end="")#need to adjust as new lines are added automatically in python? maybe?
        j += 1
    i = 0
    for i in range(0,(n-(n-a))):
        print("#", end="")
    a += 1
    print()
