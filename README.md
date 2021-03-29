# Productivity Management
This is a java console application to prototype a productivity management tool. I tried to use the MVC pattern to code this prototype. And inside the controller I used the state pattern to maintain different input states.

# Instructions
- Type "home" and enter to go back to home state.
- Type "back" and enter to go back one state.
- Just type enter to input empty value.
- The app will crash if the input data type doesn't match the desired data type or if the input the input value doesn't meet the desired condition.

# Demo
This demo is prepoluated with some consumable in the constructor of **ConsumableModel** class.

Starting Instruction
```
Type "home" and press enter to go home from any state.
Type "back" and press enter to go back one state.
```

Home Page
```
Type the number associated with the option and press enter to continue
----------------------------------------------------------------------------------------------------
1. Create a consumable
2. Edit a consumable
3. Delete a consumable
4. See consumable list
5. See overall info
----------------------------------------------------------------------------------------------------
Enter the corresponding digit: 1
```
## Create a consumable (option 1)

Consumable Creation Page
```
Type the number associated with the option and press enter to create a consumable
----------------------------------------------------------------------------------------------------
Select the corresponding number to create that type of consumable
1. Book
2. Movie
3. Series
----------------------------------------------------------------------------------------------------
Enter the corresponding digit: 1
```

Creating a new Book consumable
```
Creating new Book
----------------------------------------------------------------------------------------------------
name: harry potter
rating: 
starting date(yyyy-mm-dd): 2012-4-2
ending date(yyyy-mm-dd): 
consumption time(hour): 40

Book created successfully
```

## Edit a consumable (option 2)

Edit consumable page
```
Select consumable type to edit
----------------------------------------------------------------------------------------------------
1. Book
2. Movie
3. Series
----------------------------------------------------------------------------------------------------
Enter number: 1
```

Select the consumable to edit
```
Select a Book to edit
----------------------------------------------------------------------------------------------------
1. Book: book1, rating: 5.4, startingDate: 2018-06-03, endingDate: 2020-23-03, totalConsumptionTimeInHours: 34.0
2. Book: book2, rating: 3.5, startingDate: 2018-06-02, endingDate: 2020-16-03, totalConsumptionTimeInHours: 82.0
3. Book: book3, rating: 9.8, startingDate: 2018-06-03, endingDate: 2020-07-03, totalConsumptionTimeInHours: 37.0
4. Book: sherlock holmes, totalConsumptionTimeInHours: 20.0
5. Book: harry potter, startingDate: 2012-02-04, totalConsumptionTimeInHours: 40.0

----------------------------------------------------------------------------------------------------
Enter Book number: 5
```

```
Select which parameter you want to edit
----------------------------------------------------------------------------------------------------
1. Edit rating
2. Edit ending date
3. Add consumption time
----------------------------------------------------------------------------------------------------
Enter number: 1
```

Editing rating of the newly created book
```
Enter the new rating
----------------------------------------------------------------------------------------------------
new rating(0-10): 5
edited successfully
```

Automatically goes back to edit parameter page after editing.  
Editing ending date
```
Enter the new date
----------------------------------------------------------------------------------------------------
ending date(yyyy-mm-dd): 2016-6-3
edited successfully
```

Can't further edit this book
```
Add consumption time in hours
----------------------------------------------------------------------------------------------------
time(hour): 14
Add consumption date
----------------------------------------------------------------------------------------------------
date(yyyy-mm-dd): 2019-6-3
Select which parameter you want to edit
customexceptions.ConsumableEndedException: Can't edit consumable with end date.
	at model.Consumable.addConsumptionTimeInHours(Consumable.java:51)
	at model.Book.addConsumptionTimeInHoursWithDay(Book.java:21)
	at controller.ConsumableController.addConsumableTimeInHour(ConsumableController.java:229)
	at controller.EditStateTimeDate.processInput(EditStateTimeDate.java:43)
	at controller.ConsumableController.startApplication(ConsumableController.java:317)
	at controller.ConsumableController.main(ConsumableController.java:277)
```

## Delete a consumable (option 3)

```
Select consumable type
----------------------------------------------------------------------------------------------------
1. Book
2. Movie
3. Series
----------------------------------------------------------------------------------------------------
Enter number: 1
```

```
Select a Book to delete
----------------------------------------------------------------------------------------------------
1. Book: book1, rating: 5.4, startingDate: 2018-06-03, endingDate: 2020-23-03, totalConsumptionTimeInHours: 34.0
2. Book: book2, rating: 3.5, startingDate: 2018-06-02, endingDate: 2020-16-03, totalConsumptionTimeInHours: 82.0
3. Book: book3, rating: 9.8, startingDate: 2018-06-03, endingDate: 2020-07-03, totalConsumptionTimeInHours: 37.0
4. Book: sherlock holmes, totalConsumptionTimeInHours: 20.0
5. Book: harry potter, rating: 5.0, startingDate: 2012-02-04, endingDate: 2016-03-06, totalConsumptionTimeInHours: 40.0

----------------------------------------------------------------------------------------------------
Enter Book number: 5

Book deleted successfully
```

## Table view (option 4)

```
+----------------------------+----------------------------+----------------------------+
| Type Name                  | Consumption Days           | Consumption Hours          |
+----------------------------+----------------------------+----------------------------+
| 1. Book                    | 9                          | 213.0                      |
+----------------------------+----------------------------+----------------------------+
| 2. Movie                   | 7                          | 182.0                      |
+----------------------------+----------------------------+----------------------------+
| 3. Series                  | 6                          | 171.0                      |
+----------------------------+----------------------------+----------------------------+
Select a consumable type to see further details: 
```

```
+----------------------------+----------------------------+----------------------------+----------------------------+
| Book Name                  | Consumption Days           | Consumption Hours          | Rating                     |
+----------------------------+----------------------------+----------------------------+----------------------------+
| 1. book1                   | 1                          | 34.0                       | 5.4                        |
| 2. book2                   | 5                          | 82.0                       | 3.5                        |
| 3. book3                   | 3                          | 37.0                       | 9.8                        |
| 4. sherlock holmes         | 0                          | 20.0                       | null                       |
+----------------------------+----------------------------+----------------------------+----------------------------+
Select a Book to see further details: 1
```

```
+----------------------------+----------------------------+----------------------------+----------------------------+----------------------------+----------------------------+
| Book Name                  | Consumption Days           | Consumption Hours          | Rating                     | Starting Date              | Ending Date                |
+----------------------------+----------------------------+----------------------------+----------------------------+----------------------------+----------------------------+
| book1                      | 1                          | 34.0                       | 5.4                        | 2018-06-03                 | 2020-23-03                 |
+----------------------------+----------------------------+----------------------------+----------------------------+----------------------------+----------------------------+
Type back or home and press enter: home
```

## Overall Info (option 5)

```
Productivity management overall info.
----------------------------------------------------------------------------------------------------
1. The total consumption time in hours across all types
Ans: 566.0

2. Individual consumption time in hours of each type
Ans: Book - 213.000000, Movie - 182.000000, Series - 171.000000

3. The total days of consumption across all types
Ans: 17

4. Individual days of consumption of each type
Ans: Book - 9, Movie - 7, Series - 6

5. Average rating across all types
Ans: 5.3777776

6. Average individual rating of each type
Ans: Book - 6.233334, Movie - 3.900000, Series - 6.000000

7. Total number of consumable across all types
Ans: 10

8. Individual number of consumable of each type
Ans: Book - 4, Movie - 3, Series - 3


----------------------------------------------------------------------------------------------------
Type back or home and press enter to continue: 
```