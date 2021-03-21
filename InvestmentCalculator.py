import math

P = float(input("Please enter the amount that you are depositing: "))  #asking the user to enter the value of a variable
i = float(input("Please enter the interest rate - just the number: "))    #asking the user to enter the value of a variable
t = int(input("Please enter the number of years of the investment: "))  #asking the user to enter the value of a variable
interest = (input("Enter the interest you want, either 'simple' or 'compound': "))   #asking the user to enter the value of a variable

r = (i/100) #calculating the interest rate entered above as a percentage

if interest == "simple":
      A = P*(1+r*t)           #simple interest calculation

else:
      A = P*math.pow((1+r),t)     #compound interest calculation

A = str(A)        #converting the answer to the calculation to a string

print(A)      #printing the (string) answer



