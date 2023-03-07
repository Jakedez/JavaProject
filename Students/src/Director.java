import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Director {
    // private ArrayList<Student> students = new ArrayList<Student>();
    private static HashMap<String, Student> students = new HashMap<String, Student>();
    private static Student activeStudent = null;
    private static boolean running = true;
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> menu = new ArrayList<String>() {
        {
            add(new String("Add Student"));
            add(new String("Lookup Student"));
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
        String name = scanner.nextLine();
        if (students.containsKey(name)){
            return students.get(name);
        }
        else{
            print(String.format("No Record found for student with name \"%s\".", name));
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
            print("No student Account Selected.\n\n");
        }
        else{
            print(String.format("Student: %s\nAge: %d\nMajor: %s\n\n", activeStudent.getName(), activeStudent.getAge(), activeStudent.getMajor()));
        }
        return;
    }

    private static void selectOption(){
        try{
            int option = 0;
            print("Please Select an Option: ");
            option = scanner.nextInt();
            switch (option){
                case 1:

                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    running = false;
                    break;
                default:
                    print("Please Select a Valid Option\n\n");
                    break;
                
                
            }
        }
        catch (Exception e){
            scanner.next();
            print("Please Select a Valid Option\n\n");
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
