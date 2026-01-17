package model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String className;

    public Student(int id, String name, int age, String className){
        this.id = id;
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public int getId(){
        return id;
    }
    public String getname(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getClassName(){
        return className;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        if(age > 0){
            this.age = age;
        }
        else{
            this.age = 1;
        }
    }

    public void setClassName(String className){
        this.className = className;
    }

    @Override
    public String toString(){
        return id + "," + name + "," + age + "," + className;
    }
}
