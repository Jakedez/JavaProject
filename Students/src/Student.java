public class Student {
    private String _name;
    private String _major;
    private int _age;
    

    public Student(){

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
}