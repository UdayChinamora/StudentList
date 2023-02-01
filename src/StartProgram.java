/**
 *@author Uday F Chinhamora- ufchinhamora
 *CIS175 -Spring 2023
 *Jan 31, 2023
*/

/**
 * @author uchin
 *
 */

import java.util.List;

	import java.util.Scanner;

import controller.ListStudentHelper;
import model.ListStudent;

public class StartProgram {
	
	

	

			static Scanner in = new Scanner(System.in);
			static ListStudentHelper lih = new ListStudentHelper();

			private static void addStudent() {
				// TODO Auto-generated method stub
				System.out.print("Enter a name: ");
				String name = in.nextLine();
				System.out.print("Enter an major: ");
				String major = in.nextLine();
				ListStudent toAdd = new ListStudent(name, major);
				lih.insertStudent(toAdd);

			}

			
			private static void deleteStudent() {
				// TODO Auto-generated method stub
				System.out.print("Enter the name to delete: ");
				String name = in.nextLine();
				System.out.print("Enter the major to delete: ");
				String major = in.nextLine();
				ListStudent toDelete = new ListStudent(name, major);
				lih.deleteStudent(toDelete);

			}
			
			private static void editStudent() {
				// TODO Auto-generated method stub
				System.out.println("How would you like to search? ");
				System.out.println("1 : Search by Name");
				System.out.println("2 : Search by Major");
				int searchBy = in.nextInt();
				in.nextLine();
				List<ListStudent> foundStudents;
				if (searchBy == 1) {
					System.out.print("Enter the student name: ");
					String studentName = in.nextLine();
					foundStudents = lih.searchForStudentByName(studentName);
				} else {
					System.out.print("Enter the major: ");
					String majorName = in.nextLine();
					foundStudents = lih.searchForStudentByMajor(majorName);


				}

				if (!foundStudents.isEmpty()) {
					System.out.println("Found Results.");
					for (ListStudent l : foundStudents) {
						System.out.println(l.getId() + " : " + l.toString());
					}
					System.out.print("Which ID to edit: ");
					int idToEdit = in.nextInt();

					ListStudent toEdit = lih.searchForStudentById(idToEdit);
					System.out.println("Retrieved " + toEdit.getMajor() + " from " + toEdit.getName());
					System.out.println("1 : Update name");
					System.out.println("2 : Update major");
					int update = in.nextInt();
					in.nextLine();

					if (update == 1) {
						System.out.print("New Name: ");
						String newName = in.nextLine();
						toEdit.setName(newName);
					} else if (update == 2) {
						System.out.print("New Major: ");
						String newMajor = in.nextLine();
						toEdit.setMajor(newMajor);
					}

					lih.updateStudent(toEdit);

				} else {
					System.out.println("---- No results found");
				}

			}

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				runMenu();

			}
			public static void runMenu() {
				boolean goAgain = true;
				System.out.println("--- Welcome to our student  list! ---");
				while (goAgain) {
					System.out.println("*  Select a student:");
					System.out.println("*  1 -- Add a student");
					System.out.println("*  2 -- Edit a student");
					System.out.println("*  3 -- Delete a student");
					System.out.println("*  4 -- View the list");
					System.out.println("*  5 -- Exit the awesome program");
					System.out.print("*  Your selection: ");
					int selection = in.nextInt();
					in.nextLine();

					if (selection == 1) {
						addStudent();
					} else if (selection == 2) {
						editStudent();
					} else if (selection == 3) {
						deleteStudent();
					} else if (selection == 4) {
						viewTheList();
					} else {
						lih.cleanUp();
						System.out.println("   Goodbye!   ");
						goAgain = false;
					}

				}

			}
			private static void viewTheList() {
				// TODO Auto-generated method stub
				List<ListStudent> allStudents = lih.showAllStudents();
				for(ListStudent singleStudent: allStudents) {
					System.out.println(singleStudent.returnStudentDetails());
				}

			}
}
