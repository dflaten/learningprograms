import pytest
#String -> Integer
#Takes string and sums integers in that string
def sumDigits(s):
    sum = 0
    for i in s:         
        try:
            sum = sum + int(i)
        except ValueError:
            pass
    return sum

def testsumDigits():
    assert sumDigits("a5b3") == 8

#List of Ints -> Integer
#Takes list of ints and produces first even number in List
def findAnEven(L):
    for i in L:
        if i % 2 == 0:
            return i
        else:
            pass
    raise ValueError('findAnEven called with list containing all odds')
def testfindAnEven(): 
    assert findAnEven([1, 5, 6, 7, 2, 4]) == 6
def testfailfindAnEven(): 
    with pytest.raises(ValueError):
        findAnEven([1, 5, 5, 7, 3, 9]) 
