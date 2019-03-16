#Sum characters in string s and print them. 
s = '1.23,2.4,523'
total = 0
for char in s:
    try:
        value = int(char)
        total = total + value
    except ValueError:
        pass
print ("Sum of all numbers in string s is: " ,total)
