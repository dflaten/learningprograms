#!/usr/bin/env python
import pdb
#String -> String
#counts instances of 'bob'

#def bobcount(string):
#    return 5


def bobcount(scheck):
    #pdb.set_trace()
    slength = len(scheck)
    bobs = 0
    for a in range(0, slength - 2):
        print("What is it?: " + str(scheck[a:a+3]))
        if scheck[a:a+3] == "bob":
            bobs += 1
    return bobs

print("Number of times bob occurs is: " + str(bobcount("bob")))

def test_answer():
    assert bobcount("bobabobdkfjbob") == 3
