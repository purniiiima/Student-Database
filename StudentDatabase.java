import java.util.HashMap;
import java.util.Scanner;

class Student {
    public String Name;
    public int RollNo;
    public int Age;
    public int Marks;

    //class serves as a blueprint or template for creating objects
    //public keyword is an access modifier that is used to declare the visibility of a class, method, or field.

    //constructors are the methods which have same as class and they do not have return type.

    public Student(String Name, int RollNo, int Age, int Marks) {
        this.Name = Name;
        this.RollNo = RollNo;
        this.Age = Age;
        this.Marks = Marks;


    }
    public void viewStudent(){
        System.out.println("Name: " + Name);
        System.out.println("RollNo: " + RollNo);
        System.out.println("Age: " + Age);
        System.out.println("Marks: " + Marks);
    }
}

public class StudentDatabase {
    public static void main(String[] args) {

        //static keyword is used to define members of a class that belong to the class itself
        //void keyword is used to declare that a method does not return a value
        //main method is a special method that serves as the entry point for a Java app.

        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Student> database = new HashMap<>();
        while(true){
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.print("Enter Name: ");
                    String Name = sc.nextLine();
                    System.out.print("Enter RollNo: ");
                    int RollNo = sc.nextInt();
                    System.out.print("Enter Age: ");
                    int Age = sc.nextInt();
                    System.out.print("Enter Marks: ");
                    int Marks = sc.nextInt();
                    Student std = new Student(Name, RollNo, Age, Marks);
                    database.put(RollNo, std);
                    System.out.println("Student added Successfully");
                    break;
                case 2:
                    System.out.println("List of students: ");
                    for(Student i:database.values()){
                       i.viewStudent();
                    }
                    break;
                case 3:
                    System.out.print("Enter your RollNo: ");
                    int Roll = sc.nextInt();
                    Student data = database.get(Roll);
                    if(data!=null){
                       data.viewStudent();
                    }else{
                        System.out.println("Student not found");
                    }
                    System.out.println("*****");
                    break;
                case 4:
                    int totalStudent = database.size();
                    int totalMarks = 0;
                    for(Student j:database.values()){
                        totalMarks = totalMarks + j.Marks;
                    }
                    double average = (double) totalMarks/totalStudent;
                    System.out.println("Average Marks: " + average);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");

            }
        }
    }
}