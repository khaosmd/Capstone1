for x in range(1, 10):  #create a loop that will go from 1 to 10
    for y in range (1, x + 1): #create a second loop that will go up to the outer loops incremented value and add 1
        print(x*y, end=' ')  #prints out the product of the incremented value of the second loop and the value in the firstl loop. End = ' ' is to make sure that there are spaces between the values.
    print('\n')  #prints a new line
    
  
