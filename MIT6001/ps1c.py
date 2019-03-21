#Integers -> Integer
#Given an annual salary that increases every 6 months, 
#produce the best savings rate for getting the downpayment for your 1MM morgage
nmonths = 0
try:
    annual_salary = (int(input("Enter your annual salary:")))
except ValueError:
    print("Not an integer value...")
semi_annual_raise = .07
current_savings = 0
portion_down_payment = .25
nmonths = 36
mortgage = 1000000
#what we will calculate
savings_rate = 0 
#rate of return for savings
investment_return_rate = .04 
#how many decimal places do you want to be accurate to?
dec_accuracy = 10000
low = 0
high = dec_accuracy
savings_rate = (low + high) / 2.0
while savings_rate in range(dec_accuracy):
    while current_savings < total_cost*portion_down_payment: 
        if nmonths % 6 == 0:
            if nmonths != 0:
                annual_salary = annual_salary + annual_salary * semi_annual_raise
        current_savings = current_savings + (annual_salary/12 * portion_saved) + (current_savings*investment_return_rate/12)
        nmonths += 1
    
print('Best Savings Rate:', r)
