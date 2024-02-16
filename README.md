Description:
The code provided is a Java program for generating a seating arrangement for students in classrooms. It includes a Graphical User Interface (GUI) built with Swing for user interaction. The program allows the user to input the number of classrooms, the number of benches and rows in each classroom, and the total number of students. It then assigns seats to students and displays the seating arrangement in the GUI.

Components:
-> Main Class (Seating_Arrangement_GUI_Integrated):
This class contains the main method and handles the GUI initialization and user interactions.
It creates a JFrame and adds input fields, output area, and a button for starting the seating arrangement.
The createAndShowGUI method initializes the GUI components.
-> Input panel (createInputPanel) creates input fields for classrooms, benches, rows, and students.
-> Output panel (createOutputPanel) creates a text area for displaying the seating arrangement.
The startSeatingArrangement method processes user inputs, assigns seats to students, and displays the arrangement.
-> Student and Class_room Classes:
Student class represents a student with a roll number, row, and bench.
Class_room class represents a classroom with a room number, number of benches, number of rows, and a list of students.
-> Assigning Seats (assignSeat Method):
The assignSeat method iterates through classrooms, rows, and benches to assign seats to students.
It checks for seat availability and assigns a seat if available.
-> Displaying and Writing to File (displayAndWriteToFile Method):
The displayAndWriteToFile method displays the seating arrangement in the GUI and writes it to a text file named "Seating_Arrangement.txt".
It iterates through classrooms and students, printing their seating details to the GUI and the text file.
