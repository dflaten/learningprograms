#!/usr/bin/env python
#Float -> Float
#Given the balance, annualInterestRate, and monthlyPaymentRate calculate the Remaining balance  
def main():
    balance = 484 
    annualInterestRate = .2
    monthlyPaymentRate = .04

    monthlyInterestRate = annualInterestRate/12.0

    index = 1

    #import pdb; pdb.set_trace()
    previousbalance = float(balance)
    for index in range(0,12):
        previousbalance = previousbalance - (previousbalance * monthlyPaymentRate)
        previousbalance = previousbalance + (monthlyInterestRate * previousbalance)

    print("Remaining Balance: " + str(float("{0:.2f}".format(previousbalance))))
    

if __name__ == "__main__":
    main()
