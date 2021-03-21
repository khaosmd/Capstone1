import random
lottery=str(random.randint(10, 99)) #Generate a random two-digit number (between 10 and 99)

guess=input("Please enter a two-digit number as your guess: \n")   #asks the user to guess the lottery number and enter their guess, converting it to an integer 


lot1=lottery[0]  #assigns the digit at the first index position from the randomly generated number to a variable called "lot1"
lot2=lottery[1]  #assigns the digit at the second index position from the randomly generated number to a variable called "lot1"  

user1=guess[0]  #assigns the digit at the first index position from the user's guess to a variable called "first" 
user2=guess[1]  #assigns the digit at the second index position from the user's guess to a variable called "second" 


print("lottery number is "+(lottery))  #print out the generated lottery number

if lottery == guess:
    print("Congratulations you have an exact match, you win R10 000.00.")   #if the lottery number matches the user's guess, print a statement

elif lot1 == user2 and lot2 == user1:
    print("Congratulations you have all digits, you win R5 000.00.")        #if the first digit of the lottery number matches the second digit of the user's guess, and the second digit of the lottery number matches the first digit of the user's guess, print a statement

elif lot1 == user1 or lot2 == user2:
    print("Congratulations you have one correct digit, you win R1 000.00.")  #If the first or second digit of the user's guess matches the corresponding lottery number digit, print a statement

else:
    print("Sorry no match.")        #if no digits of the user's guess matches the lottery number, print a statement

    

    



