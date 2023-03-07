import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Director {
    private static HashMap<String, Student> students = new HashMap<String, Student>();
    private static Student activeStudent = null;
    private static boolean running = true;
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> menu = new ArrayList<String>() {
        {
            add(new String("Add Student"));
            add(new String("Lookup Student"));
            add(new String("Get Record Count"));
            add(new String("Log out Student"));
            add(new String("Remove Student"));
            add(new String("Edit Student"));
            add(new String("Exit"));
        }
    };

    private static void print(String string){
        System.out.println(string);
        return;
    }

    private static Student searchStudent(){
        System.out.println("Please search for a student record: ");
        String name = readString();
        if (students.containsKey(name)){
            print("Student Found!");
            return students.get(name);
        }
        else{
            print(String.format("No Record found for student with name \"%s\".\n", name));
            return null;
        }
    }

    private static void printMenu(){
        for (int i = 0; i < menu.size(); i++){
            System.out.println(String.format("%d. %s", i + 1, menu.get(i)));
        }
        System.out.println("\n\n");
        return;
    }

    private static void printActive(){
        if (activeStudent == null){
            print("No student Account Selected.\n");
        }
        else{
            print(String.format("Student: %s\nAge: %d\nMajor: %s\nCredits: %d\n\n", activeStudent.getName(), activeStudent.getAge(), activeStudent.getMajor(), activeStudent.getCredits()));
        }
        return;
    }

    private static void addStudent(){
        print("Please enter the student's information: \n\n");
        Student localStudent = new Student();
        students.put(localStudent.getName(), localStudent);
        return;
    }

    private static void diselectStudent(){
        if (activeStudent != null){
            activeStudent = null;
            print("Student logged out!\n");
        }
        else{
            print("No student currently logged in.\n");
        }
    }

    private static void removeStudent(){
        if (activeStudent != null){
            students.remove(activeStudent.getName());
            activeStudent = null;
            print("Account removed!");
        }
        else{
            print("No student currently logged in.\n");
        }
        return;
    }

    private static void editStudent(){
        boolean confirmed = false;
        int choice = 0;
        if (activeStudent != null){
            while (!confirmed){
                print("\n\n");
                printActive();
                print("1. Change Age");
                print("2. Change Major");
                print("3. Add Credits");
                print("4. Change Credit Count");
                print("5. Return to Main menu");
                choice = readInt("\nPlease select an option: ");
                switch (choice){
                    case 1:
                    activeStudent.setAge(readInt("Please enter a new age: "));
                    break;
                    case 2:
                    print("Please Type a new Major: ");
                    activeStudent.setMajor(readString());
                    break;
                    case 3:
                    activeStudent.addCredits(readInt("Please enter additional credits to add: "));
                    break;
                    case 4:
                    activeStudent.setCredits(readInt("Please enter total credits: "));
                    break;
                    case 5:
                    confirmed = true;
                    break;
                    default:
                    print("Please Select a valid option.");
                    break;

                }
    
            }
        }
        else{
            print("There is no student logged in to modify.\n\n");
        }
        return;
    }

    private static void getCount(){
        print(String.format("Current Record Count: %d\n", students.size()));
        return;
    }
    
    private static int readInt(String prompt){
        int number = 0;
        boolean confirmed = false;
        while (!confirmed){
            try{
                System.out.println(prompt);
                number = Integer.parseInt(scanner.nextLine());
                confirmed = true;
            }
            catch(Exception e){
                System.out.println("Please type a valid number\n\n");
            }
        }
        return number;
    }

    private static String readString(){
        String string = scanner.nextLine();
        return string;
    }

    private static void selectOption(){
        int option = 0;
        option = readInt("Please Select an Option: ");
        switch (option){
            case 1:
                addStudent();
                break;
            case 2:
                activeStudent = searchStudent();
                break;
            case 3:
                getCount();
                break;
            case 4:
                diselectStudent();
                break;
            case 5:
                removeStudent();
                break;
            case 6:
                editStudent();
                break;
            case 7:
                running = false;
                break;
            default:
                print("Please Select a Valid Option\n\n");
                break;
        }
            
        
        return;
        
    }

    public static void Direct(){
        while (running){
            printActive();
            printMenu();
            selectOption();
        }
        return;
    }
}
