# PracticeFusionCodingTest

This project is written in Java and unit tests are in JUnit (hamcrest used).

##Input:

It takes input file from resouce folder from the project itself. Input file contains list of doctors having the following attributes:
Name
Speciality
Location
Age
Review score

Input file is csv file and is used as input.

##Algorithm:

findSimilarDoctors() function looks for speciality first followed by location of the doctor. If specility is matched, it boosts score by 100. When location matches, it boosts to 10. If nothing matched, it is considered as no matching doctor found.
Score = speciality + location + review score
Entries are displayed in desc order of score.

##Class Definition:
package: com.src.practice.fusion
Doctor.java - java bean class holds doctor object
DoctorComparator.java - contains utility for finding similar doctors and sorting of list
DoctorMainClass.java - main class that takes file input as list of doctors from resource and finds similar doctors in output

##How to run this project:
You can import this project in eclipse or any other IDE.