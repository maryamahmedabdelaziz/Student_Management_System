package studenttree;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentTree {

    public static void main(String[] args) {
     
        BinarySearchTree tree = new BinarySearchTree();
        Scanner scan = new Scanner(System.in);
        
        while(true){
            
            try{
            
                System.out.println("----- STUDENT GRADE MANAGEMENT SYSTEM -----");
                System.out.println("-------------------------------------------");
                System.out.println("1. INSERT STUDENT");
                System.out.println("2. SEARCH STUDENT");
                System.out.println("3. REMOVE STUDENT");
                System.out.println("4. NUMBER OF STUDENTS");
                System.out.println("5. TOP 5 SORTED BY ID");
                System.out.println("6. TOP 10 SORTED BY GPA");
                System.out.println("7. DISPLAY ALL STUDENTS");
                System.out.println("8. STUDENTS GPA LESS THAN 2");
                System.out.println("9. CLEAR LIST");
                System.out.println("0. EXIT");
                System.out.println("-------------------------------------------");
                System.out.print("ENTER CHOICE: ");
            
                int choice = scan.nextInt();
            
                switch(choice){
                
                    case 1:
                        System.out.print("ENTER STUDENT ID: ");
                        int id1 = scan.nextInt();
                        scan.nextLine();
                    
                        System.out.print("ENTER STUDENT NAME: ");
                        String name = scan.nextLine();
                        
                        while(name.matches(".*\\d.*")){
                            System.out.println("INVALID NAME! PLEASE TRY AGAIN");
                            name = scan.nextLine();
                        }
                         
                        System.out.print("ENTER STUDENT GPA: ");
                        double gpa = scan.nextDouble();
                    
                        tree.insertStudent(new Student(id1, name, gpa));
                        break;
                    
                    case 2:
                        System.out.print("ENTER STUDENT ID TO SEARCH: ");
                        int id2 = scan.nextInt();
                        tree.searchStudent(id2);
                        break;
                
                    case 3:
                        System.out.print("ENTER STUDENT ID REMOVE: ");
                        int id3 = scan.nextInt();
                        tree.removeStudent(id3);
                        break;
                    
                    case 4:
                        System.out.println("NUMBER OF STUDENTS: " + tree.size());
                        break;
                    
                    case 5:
                        tree.TOP5();
                         break;
                    
                    case 6:
                        tree.TOP10();
                        break;
                     
                    case 7:
                        tree.display();
                        break;
                    
                    case 8:
                        tree.lessThan2GPA();
                        break;
                 
                    case 9:
                        tree.clear();
                        System.out.println("LIST CLEARED");
                        break;
                    
                    case 0:
                        System.out.println("EXIT");
                        return;
                    
                    default:
                        System.out.println("INVALID CHOICE");
                        
            }
        
        }
            catch(InputMismatchException e){
                System.out.println("INVALID INPUT! PLEASE TRY AGAIN");
                scan.nextLine();   
                
            }
        }
    }
    
}

