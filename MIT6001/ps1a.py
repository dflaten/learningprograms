#Integers -> Integer
#Given an annual salary, percentage of salary to save, and cost of dream
#home produce number of months needed to save
nmonths = 0
try:
    annual_salary = (int(input("Enter your annual salary:")))
except ValueError:
    print("Not an integer value...")
try:
    portion_saved = (float(input("Enter the percent of your salary to save, as a decimal:")))
except ValueError:
    print("Not an float value...")
try:
    total_cost = (int(input("Enter the cost of your dream home:")))
except ValueError:
    print("Not an integer value...")
current_savings = 0
portion_down_payment = .25
#rate of return for savings
r = .04

while current_savings < total_cost*portion_down_payment: 
    current_savings = current_savings + (annual_salary/12 * portion_saved) + (current_savings*r/12)
    nmonths += 1
print('Number of months:', nmonths)
