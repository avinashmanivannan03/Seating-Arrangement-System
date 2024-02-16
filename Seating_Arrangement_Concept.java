package mini_project;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;





class Student {
	
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

public class Seating_Arrangement_Concept {

	public static void main(String[] args) {
		
		try {
			
			Scanner x = new Scanner(System.in);
			System.out.print("Enter the Number of Class Rooms Available: ");
			int num_classrooms = x.nextInt();
			
			ArrayList<Class_room> classrooms = new ArrayList<>();
			
			for(int i=0; i<num_classrooms;i++) {
				System.out.print("Enter the Room Number for Classroom "+(i+1)+": ");
				int room_Number = x.nextInt();
				
				System.out.print("Enter the Number of Benches in Classroom "+(i+1)+": ");
				int benches = x.nextInt();
				
				System.out.print("Enter the Number of Rows in Classroom "+(i+1)+": ");
				int rows = x.nextInt();
				
				classrooms.add(new Class_room(room_Number, benches, rows));
				
				
			}
			
			System.out.print("Enter the Total Number of Students: ");
			int num_students = x.nextInt();
			
			for(int i=0;i<num_students;i++) {
				System.out.print("Enter the Roll.Number of Student "+(i+1)+": ");
				String roll_Number = x.next();
				
				assignSeat(classrooms, roll_Number);
				
			}
			
			displayAndWriteToFile(classrooms);
			
		}
		
		catch(IOException e) {
			System.out.println("Error");
			
		}
		
		
	}
	
	
	private static void assignSeat(ArrayList<Class_room> classrooms, String roll_Number) {
		
		for (Class_room classroom : classrooms) {
			
			for (int i=0; i<classroom.rows;i++) {
				
				for(int j=0; j<classroom.benches; j++) {
					
					boolean seatAvailable = true;
					
					for(Student student : classroom.students) {
						
						if(student.bench == j+1 && student.row == i+1) {
							
							seatAvailable = false;
							
							break;
						}
					}
					
					if(seatAvailable) {
						
						classroom.students.add(new Student(roll_Number, i+1, j+1));
						return;
						
					}
					
				}
					
			}
		}
		
	}

	
	
	private static void displayAndWriteToFile(ArrayList<Class_room> classrooms) throws IOException {
		
		try {
			
			PrintWriter writer = new PrintWriter(new FileWriter("seating_arrangement.txt"));
			System.out.println("\nSeating Arrangement");
			
			for (Class_room classroom: classrooms) {
				
				writer.println("\nClass Room "+classroom.room_Number+": ");
				System.out.println("\nClass Room "+classroom.room_Number+": ");
				
				for (Student student: classroom.students) {
					
					System.out.println("Row "+student.row+ ", Bench "+student.bench+": "+student.roll_Number);
					writer.println("Row "+student.row+", Bench "+ student.bench+": "+student.roll_Number);	
					
				}
				
			}
			
			
			
			
		}
		
		catch(IOException e) {
			System.out.print("ERROR");
			
		}
		
		System.out.println("Seating Arrangement written to 'seating_arrangement.txt'");
		
		
	}

}

