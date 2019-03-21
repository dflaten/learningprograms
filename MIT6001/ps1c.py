#Integers -> Integer
#Given an annual salary that increases every 6 months, 
#produce the best savings rate for getting the downpayment for your 1MM morgage
def main():
    #Integers, Floats -> Integer
    def MonthsSavingSearch(months_until_buy,dec_accuracy,total_cost, portion_down_payment, annual_salary, semi_annual_raise, investment_return_rate):
        low = 0
        high = dec_accuracy
        savings_rate = (low + high) / 2.0
        while savings_rate in range(dec_accuracy):
            #bisectionsearchsteps += 1
            guessmonths = CheckGuess(savings_rate, total_cost, portion_down_payment, annual_salary, semi_annual_raise, investment_return_rate)
            if guessmonths ==  months_until_buy:
                return savings_rate #Success!
            if guessmonths < months_until_buy:
                high = savings_rate
                savings_rate = (low +high) / 2.0
            if guessmonths > months_until_buy:
                low = savings_rate
                savings_rate = (low +high) / 2.0
            #Here I need  to account for if a guess can't be found.
        return savings_rate

    def CheckGuess(savings_rate, total_cost, portion_down_payment, annual_salary, semi_annual_raise, investment_return_rate):
        nmonths = 0
        current_savings = 0
        while current_savings < total_cost*portion_down_payment: 
            if nmonths % 6 == 0:
                if nmonths != 0:
                    annual_salary = annual_salary + annual_salary * semi_annual_raise
            current_savings = current_savings + (annual_salary/12 * savings_rate) + (current_savings*investment_return_rate/12)
            nmonths += 1
        return nmonths
    try:
        annual_salary = (int(input("Enter your annual salary:")))
    except ValueError:
        print("Not an integer value...")

    semi_annual_raise = .07
    portion_down_payment = .25
    months_until_buy = 36
    total_cost = 1000000
    #what we will calculate
    savings_rate = 0 
    #rate of return for savings
    investment_return_rate = .04 
    #how many decimal places do you want to be accurate to?
    dec_accuracy = 10000
    #how many steps in bisection search? 
    bisectionsearchsteps = 0
    savings_rate = MonthsSavingSearch(months_until_buy, dec_accuracy, total_cost, portion_down_payment, annual_salary, semi_annual_raise, investment_return_rate)
    #Sudo code for bisection search
    #Calculate Midpoint and set to savings_rate, savings rate = low + high /2
    #Calculate the value of the function checkguess(midpoint)
    #if nmonths = 36 success return savings_rate
    #if nmonths > 36 your savings_rate was to low, set savings rate to low, recalculate savings rate with savings_rate = (low + high) /2.0
    #if nmonths < 36 your savings_rate was to high, set savings rate to high, recalculate savings rate with savings_rate = (low +high) /2.0
    #Calculate the value of the function checkguess(midpoint)... repeat as needed.
    print('Best Savings Rate:', savings_rate*.0001)
    print('Steps in Bisection Search:', bisectionsearchsteps)
if __name__ == "__main__":
    main()
