package seating_arrangement_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;


class Student{
	String roll_Number;
	int row;
	int bench;
	
	Student(String roll_Number, int row, int bench){
		this.roll_Number = roll_Number;
		this.row = row;
		this.bench = bench;
	}
	
}

class Class_room {
	
	int room_Number;
	int benches;
	int rows;
	ArrayList<Student> students;
	
	Class_room(int room_Number, int benches, int rows){
		
		this.room_Number = room_Number;
		this.benches = benches;
		this.rows = rows;
		this.students = new ArrayList<>();
		
	}
	
	
}


public class Seating_Arrangement_GUI_Integrated {
	
	private static JFrame frame;
	private static JTextArea outputTextArea;
	private static JTextField classroomsField;
	private static JTextField studentsField;
	

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(()->{
			
			try {
				
				createAndShowGUI();
			}
			
			catch (IOException e) {
				
				e.printStackTrace();
			}
			
		});
		

	}
	
	private static void createAndShowGUI() throws IOException{
		
		JFrame frame = new JFrame("SEATING ARRANGEMENT");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel inputPanel = createInputPanel();
		JPanel outputPanel = createOutputPanel();
		JButton startButton = new JButton("START SEATING ARRANGEMENT");
		
		startButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					startSeatingArrangement();
				}
				
				catch(IOException ioException) {
					ioException.printStackTrace();
				}
				
			}
			
		});;
		
		
		
		frame.setLayout(new BorderLayout());
		frame.add(inputPanel, BorderLayout.NORTH);
		frame.add(outputPanel, BorderLayout.CENTER);
		frame.add(startButton, BorderLayout.SOUTH);	
		
		
		frame.pack();
		frame.setSize(700,600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		

		
	}
	
	private static JPanel createInputPanel() {
		
		JPanel inputPanel = new JPanel(new GridLayout(4,3));
		classroomsField = new JTextField();
		studentsField = new JTextField();
		JTextField benchesField = new JTextField();
		JTextField rowsField = new JTextField();
		
		
		inputPanel.add(new JLabel("Number of Available Classroom/Classrooms: "));
		inputPanel.add(classroomsField);
		inputPanel.add(new JLabel("Number of Benches in Classroom/Classrooms: "));
		inputPanel.add(benchesField);
		inputPanel.add(new JLabel("Number of Rows in Classroom/Classrooms: "));
		inputPanel.add(rowsField);
		inputPanel.add(new JLabel("Total Number of Students: "));
		inputPanel.add(studentsField);
		
		return inputPanel;	
		
	}
	
	
	private static JPanel createOutputPanel() {
		
		JPanel outputPanel = new JPanel(new BorderLayout());
		outputTextArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(outputTextArea);
		
		outputPanel.add(scrollPane, BorderLayout.CENTER);
		
		return outputPanel;
		
	}
	
		
	
	private static void startSeatingArrangement() throws IOException {
		
		int num_classrooms = Integer.parseInt(classroomsField.getText());
		ArrayList<Class_room> classrooms = new ArrayList<>();
		
		for (int i=0;i<num_classrooms;i++) {
			
			// Get input for unique class room number
			int room_Number = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Classroom Number for Classroom "+(i+1)+": "));
			
		    //Get input for number of benches, rows, and class room number using dialogs
			int benches = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Number of Benches for Classroom "+room_Number+": "));
			int rows = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Number of Rows for Classroom "+room_Number+": "));
			
			classrooms.add(new Class_room(room_Number,benches,rows));
			
		}
		
		int num_students = Integer.parseInt(studentsField.getText());
		
		for(int i=0; i<num_students;i++) {
			
			String roll_Number = JOptionPane.showInputDialog(frame,"Enter the Roll.Number of Student "+(i+1)+": ");
			assignSeat(classrooms, roll_Number);
		
		}
		
		displayAndWriteToFile(classrooms);
		
		
	}
	
	private static void assignSeat(ArrayList<Class_room> classrooms, String roll_Number) {
		
		for (Class_room classroom : classrooms) {
			
			for(int i=0;i<classroom.rows;i++) {
				
				for (int j=0;j<classroom.benches;j++) {
					
					boolean seatAvailable = true;
					
					for(Student student : classroom.students) {
						
						if(student.bench== j+1 && student.row == i+1) {
							seatAvailable = false;
							break;
							
						}
						
					}
					
					
					if (seatAvailable) {
						
						classroom.students.add(new Student(roll_Number, i+1, j+1));
						return;
						
					}
					
				}
			}
			
		}
		
	}
	
	private static void displayAndWriteToFile(ArrayList<Class_room> classrooms) throws IOException {
		
		try {
			
			PrintWriter writer = new PrintWriter(new FileWriter("Seating_Arrangement.txt"));
			outputTextArea.append("\nSeating Arrangement\n");
			
			for(Class_room classroom : classrooms) {
				
				writer.println("\nClass Room "+classroom.room_Number+": \n");
				outputTextArea.append("\nClass Room "+classroom.room_Number+": \n");
				
				for(Student student : classroom.students) {
					
					outputTextArea.append("Row "+student.row+"- Bench "+student.bench+": "+student.roll_Number+"\n");
					writer.println("Row "+student.row+"- Bench "+student.bench+": "+student.roll_Number);
					
				}
				
			}
			
			writer.close();
			
		}
		
		catch(IOException e) {
			
			outputTextArea.append("Error");
		}
		
		outputTextArea.append("Seating Arrangement Written to 'Seating_Arrangement.txt'");
		
	}

}
