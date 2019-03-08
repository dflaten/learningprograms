while True:
    cof = -1.1 
    while cof is -1.1:
       try:
           cof = float(input("Change Owed: "))
       except ValueError:
          print("Not an float value...")
    if cof > 0:
        break
coi = int(round(cof*100,2)) 
q = 0
d = 0
n = 0
p = 0
coins = 0

while coi >= 25:
    coi = coi - 25
    q += 1 
while coi >= 10:
    coi = coi - 10
    d += 1
while coi >= 5:
    coi = coi - 5
    n += 1
while coi > 0:
    coi = coi - 1
    p += 1

coins = q + d + n + p
print (coins)
