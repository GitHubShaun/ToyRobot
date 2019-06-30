Run script using:
sh script.command [file.txt] [file.txt] [file.txt]
eg. 
sh script.command testcase1.txt

Designed and developed on:
MAC
IntelliJ IDEA
Java

Goal is to create a toy robot library that is able to take in commands and perform actions on a toy robot. The user would download and use this ToyRobot.jar as part of their dependancy and would have access to the constructors/methods in this library.

Easy Run Instructions:
1) Download and open .zip file
2) this README.txt is available swell as ToyRobotLibrary.pdf for further information
3) Execute/run shell script called script.command. In terminal: sh script.command [filename.txt]
	eg. sh script.command testcase1.txt
	Resulting in the output - Output: 0,1,NORTH
4) Simulation .java file allows for command line arguments, this was overlooked when creating the shell script.. oops.. 
	eg. java Simulation PLACE 0,0,NORTH MOVE REPORT
	Will give the output - Output: 0,1,NORTH
5) If adding additional test cases, test textiles MUST be in the testfiles directory in the project directory, due to compilation/executing being hardcoded. 

What is included in this care package:
dist - distribute library
JavaDoc - documentation (auto-generated from my library class)
lib - library used for the toy robot simulation execution
README.txt 
script.command - terminal script used to compile/execute the simulation
src - source files, includes the library java file (ToyRobot.java) and an example simulation java file (ToyRobotSim.java)
testfiles - directory for all the test cases, all test cases must be in here to be used with the shell script.
tests - JUnit test files
ToyRobotLibary.docx - document explaining the project
ToyRobotLibary.pdf - document explaining the project (probably useful)

Example testcases (in the testfiles directory):
testcase1.txt
PLACE 0,0,NORTH
MOVE
REPORT

testcase2.txt
PLACE 0,0,NORTH
LEFT
REPORT

testcase3.txt
PLACE 1,2,EAST
MOVE
MOVE
LEFT
MOVE
REPORT

testcase4.txt
MOVE
REPORT
PLACE 0,0,SOUTH
LEFT
REPORT
