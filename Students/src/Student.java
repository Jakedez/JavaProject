import java.util.Scanner;

public class Student {
    private String _name;
    private String _major;
    private int _age;
    private int _credits;
    private Scanner scanner = new Scanner(System.in);
    

    private int readInt(String prompt){
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

    private String readString(){
        String string = "";
        string = scanner.nextLine();
        return string;
    }


    public Student(){
        System.out.println("Please enter the student's name: ");
        _name = readString();
        _age = readInt("please enter the student's age (Years): ");
        System.out.println("Please enter the student's major: ");
        _major = readString();
        _credits = readInt("please enter the student's credit count: ");
    }

    public int getAge() {
        return _age;
    }
    public void setAge(int age){
        _age = age;
        return;
    }
    public String getName(){
        return _name;
    }
    public void setName(String name){
        _name = name;
    }
    public String getMajor(){
        return _major;
    }
    public void setMajor(String major){
        _major = major;
    }
    public int getCredits(){
        return _credits;
    }
    public void setCredits(int credits){
        _credits = credits;
    }
    public void addCredits(int credits){
        _credits += credits;
    }
}