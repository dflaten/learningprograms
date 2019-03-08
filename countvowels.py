#!/usr/bin/env python

#Assume s is a string of lower case characters.
#Write a program that counts up the number of vowels contained in the string s. Valid vowels are: 'a', 'e', 'i', 'o', and 'u'. For example, if s = 'azcbobobegghakl', your program should print:
#Number of vowels: 5
s = "aemdnvxoiernxkcv"
slength = len(s)
nvowels = 0
a = 0
for a in range(0, slength):
    if any (c == s[a] for c in ("a", "e", "i", "o", "u")):
        nvowels += 1
    
print("Number of vowels: " + str(nvowels))
