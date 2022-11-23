# -CS330_Project-

Lock and Unlock Software
By Bryan Evans

Description
This program accepts a user input of integers that will provide a lock or unlock case when the correct input of one of my six digit
code (830271 for unlock, 830274 for lock) is inputed. It was programmed on Eclipse IDE. It can take the inputs of any number of digits, including 1.

Test Usage
-Executing java -jar Part1.jar/part2.jar on the already existing .jar files works in windows 10
-Building an execuatble jar file with the $ ./gradlew jar on the java files is another option in linux/ubuntu.
-Running the executable with $ java -jar DIRECTORY/Part1.jar works in linux/ubuntu.
-Another option is executing ./gradlew clean build on the file to run the main task without the executable.
-This program can be tested by inputting 1 digit at a time, one of the codes by themselves, then with digits before and/or after the codes. When I tested this, none of these generated an error. Running the random number generator didn't generate an error either. This was tested on Eclipse IDE as well as the command console/terminal.

Memo
My program contains several different objects, including an arraylist, an array, char application, and the random math method. The array is designed to comb through the arraylist one at a time like a queue data structure: first in, first out. If only one integer is inputed, it steps one integer at a time. But if 
a larger integer of multiple digits is inputed, it will read through the number of digits step by step until it reaches the end. The program is coded
in Java.
![image](https://user-images.githubusercontent.com/89946767/203472404-6e71905c-4794-4d81-952a-3ec0195559f6.png)


Support
Email me @ bevans11@hawk.iit.edu for more information.
