#!/usr/bin/env python
#String -> String
#Provide longest alphabetical substring from string
#def AlphabeticalString(String):
#    return SubString
def main():
    s = "aemdnvxabcdoiernxkcv"
    slength = len(s)
    b = 0
    longastring = ""
    guess = ""
    #Creates a guess char
    def GuessMaker(starchar, stringevaluated):
        a = 0
        guessinprogress = ""
        guesslength = len(stringevaluated)
        for a in range(a, guesslength-1):
            first = ord(stringevaluated[a])
            second = ord(stringevaluated[a+1])
            #import pdb; pdb.set_trace()
            if first < second:
                guessinprogress += stringevaluated[a+1]
            else: 
                return guessinprogress
    #iterate through entire string
    for b in range (b, slength):
        guess = GuessMaker(s[b], s)
        if len(longastring) < len(guess):
            longastring = guess

    print("The longest alphabetical string is: " + longastring)
    def test_answer():
        assert AlphabeticalString("bobabobdkfjbob") == "abo"
if __name__ == "__main__":
    main()
