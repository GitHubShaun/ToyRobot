Designed and developed on:
MAC
Intellij
Java

Aim:
Create a Java Library that can be imported into a user program to be used for a toy robot simulation.
Emphasis on easy implementation for the user.

For the in-experienced, step by step guide:

Overview Compile/Run:

	javac [path to jar file] [filename.java]
	java [path to .class:path to .jar] [filename] [arguments]

ProjectName
|
|--> lib
|    |
|    |-- ToyRobot.jar
|
|--  Sim.java

"import toyrobot.ToyRobot" is required by the user in their .java file to use the .jar
Copy ToyRobot.jar to the project's lib folder
Compile (in terminal) with: 
	javac -cp ".:./lib/ToyRobot.jar" Sim.java
Run (in terminal with:
	java -cp ".:./lib/ToyRobot.jar" Sim

Alternatives:
	javac -cp "./lib/ToyRobot.jar" Sim.java
	java -cp ".:./lib/ToyRobot.jar" Sim

	using -CLASSPATH instead of -cp