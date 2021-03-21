num=int(input("Enter an integer: "))  #gets the value of num from the user

if num>1:   #if condition, if the number is greater than 1
    
    for i in range(2, num):  #stating the range of i from 2 to the number
        if num%i != 0 and num%1 == 0 and num%num == 0:  #creates a condition if the number has a remainder when divided by any value of i besides 1 and itself
            print(f"{num} is a prime number!")  #if the number can't be divided by any other number besides 1 and itself (remainder is never 0 - number is a prime number)

        else:  
            print(f"{num} is not a prime number.")   #prints a statement if the number can be divided by any other number besides 1 and itself
            

