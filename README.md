# Seating Arrangement GUI

This Java program implements a seating arrangement system for classrooms using a graphical user interface (GUI) built with Swing.

## Description
The program allows the user to input the number of classrooms, the number of benches and rows in each classroom, and the total number of students. Then, it assigns seats to each student in the classrooms based on availability.

## Functions
1. Student Class: Represents a student with attributes like roll number, row, and bench number.
2. Class_room Class: Represents a classroom with attributes like room number, number of benches, number of rows, and a list of students.
3. Seating_Arrangement_GUI_Integrated Class: Contains the main method to start the GUI application.
4. createAndShowGUI(): Creates and displays the main GUI frame with input fields, output area, and a start button.
5. startSeatingArrangement(): Reads input values, creates classroom objects, assigns seats to students, and displays the seating arrangement.
6. assignSeat(): Assigns a seat to a student in a classroom based on availability.
7. displayAndWriteToFile(): Displays the seating arrangement in the GUI output area and writes it to a text file named "Seating_Arrangement.txt".

### Features
- Input fields for number of classrooms, benches, rows, and students
- Display of seating arrangement in the GUI output area
- Writing the seating arrangement to a text file

## How to Use
1. Run the program.
2. Input the number of classrooms, benches, rows, and students.
3. Click on the "START SEATING ARRANGEMENT" button.
4. Follow the prompts to input classroom details and student roll numbers.
5. The seating arrangement will be displayed in the GUI output area.
6. The seating arrangement will also be written to a text file named "Seating_Arrangement.txt".

## Requirements
- Java Development Kit (JDK)
- Swing GUI library

## How to Run
Compile and run the `Seating_Arrangement_GUI_Integrated.java` file.

```bash
javac Seating_Arrangement_GUI_Integrated.java
java Seating_Arrangement_GUI_Integrated
