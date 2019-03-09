#!/usr/bin/env python
import pdb

#String -> String
#Provide longest alphabetical substring from string
#def CountAlphabeticalString(String):
#    return SubString
s = "aemdnvxoiernxkcv"
slength = len(s)
longastring = ""
a = 0
for a in range(0, slength):
    #while ord(s[a]) < ord(s[a+1]):
    #    longastring += s[a]
    #    longastring += s[a+1]
    if any (c == s[a] for c in ("a", "e", "i", "o", "u")):
        nvowels += 1
    
print("Number of vowels: " + str(nvowels))
def test_answer():
    assert CountAlphabeticalString("bobabobdkfjbob") == "abo"
