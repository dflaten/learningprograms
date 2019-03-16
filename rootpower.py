#Integer -> Integer
#Takes an integer, a, and finds new integer, b, such that a**b = a
#def rootpower(numone):
#    return numone, numetwo

try:
    root = (int(input("Input a integer:")))
except ValueError:
    print("Not an integer value...")
pwr =0
for pwr in range(0,6):
    if root**pwr == root:
        print ("Root: ", root, "Pwr: " , pwr)
        break

#print("There is no integer where root**pwr = root where root = " , root)

def test_answer():
    assert rootpower(1) == 1
