import sys 
if len(sys.argv) ==2:
    k = int(sys.argv[1])
    while True:
        msg = 'nOne' 
        while msg is 'nOne':
           msg = str(input("plaintext: "))
        if msg is not 'nOne':
           break
    print ("ciphertext: ")
    #you need to encrypt each letter one by one, solution in c bellow
    for  n in range (0, len(msg)):
       if ord(msg[n]) >= ord('a') and ord(msg[n]) <= ord('z'):
          print (chr((((ord(msg[n]) + k - 97) % 26) + 97)),end="")#encrypt each letter in the string and print
       elif ord(msg[n]) >= ord('A') and ord(msg[n]) <= ord('Z'):
           print (chr((((ord(msg[n])+ k - 65) % 26) + 65)),end="" )#encrypt each letter in the string and print
       else:
          print(msg[n])
       n += 1 
    print()
    #end c solution
else:
    exit("Usage: python3 caesar.py INTEGERVALUE")
