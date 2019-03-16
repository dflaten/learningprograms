#Newton-Raphson for square root
#find x such that x**2 -24 is within and epsilong of 0
epsilon = .01
k = 24.0
guess = 2/2.0
nofguess = 0
while abs(guess*guess -k) >=epsilon: 
    guess = guess - (((guess**2) -k)/(2*guess))
    nofguess += 1
    print('The number of guesses is', nofguess)
print ('Square root of', k, 'is about' , guess)
