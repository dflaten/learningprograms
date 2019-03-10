#!/usr/bin/env python
#String -> String
#Provide longest alphabetical substring from string
#def AlphabeticalString(String):
#    return SubString
def main():
    s = "aemdnvxoiernxkcv"
    slength = len(s)
    a = 0
    b = 0
    longastring = ""
    #Creates a guess char
    def GuessMaker(starchar, ):
        for a in range(a, slength-1):
            first = ord(s[a])
            second = ord(s[a+1])
            import pdb; pdb.set_trace()
            if first < second:
                guess += s[a+1]
            else 
                return guess
    #iterate through entire string
    for b in range (b, slength):
        guess = GuessMaker(s[a], s)
        if len(longastring) < len(guess):
            longastring = guess''

    print("The longest alphabetical string is: " + longastring)
    def test_answer():
        assert AlphabeticalString("bobabobdkfjbob") == "abo"
if __name__ == "__main__":
    main()
