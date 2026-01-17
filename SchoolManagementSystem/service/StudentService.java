package service;

import java.util.ArrayList;
import model.Student;
import util.InputUtil;
import util.FileUtil;
import java.util.*;


public class StudentService {
    private ArrayList<Student> s = new ArrayList<>();

    // ADD STUDENT
    public void addStudent(){
        System.out.println("Enter ID: ");
        int id = InputUtil.sc.nextInt();
        InputUtil.sc.nextLine();

        System.out.print("Enter Name: ");
        String name = InputUtil.sc.nextLine();

        System.out.print("Enter Age: ");
        int age = InputUtil.sc.nextInt();
        InputUtil.sc.nextLine();

        System.out.print("Enter class:");
        String classname = InputUtil.sc.nextLine();
        
        Student ss = new Student(id,name,age,classname);
        s.add(ss);

        FileUtil.writeFile("data/students.txt",ss.toString());

        System.out.println("student added successfully");
    }

    // VIEW STUDENT
        public void viewStu(){
            if(s.isEmpty()){
                System.out.println("No student in memory");
                return;
            }
            for(Student st : s){
                System.out.println(st);
            }
        }

        // ram ke bajaye file se menu mein data aaye uske liye ye methhod

        public StudentService(){
            loadStuFromFile();
        }
        private void loadStuFromFile(){
            ArrayList<String> line = FileUtil.readFileLine("data/students.txt");
            for(String l : line){
                String[] arr = l.split(",");

                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                int age = Integer.parseInt(arr[2]);
                String cls = arr[3];

                Student st = new Student(id, name, age, cls);
                s.add(st);
            }
            
        }

        // search feature
        public void searchById(int id){
            boolean f = false;
            for(Student stud : s){
                if(stud.getId() == id){
                    System.out.println("Student found");
                    System.out.println(stud);
                    f = true;
                    break;
                }
            }
            if(!f)System.out.println("Student not found");
        }
        //delete feature
        public void deleteById(int id){
            boolean remove = false;
            for(int i = 0 ; i < s.size(); i++){
                if(s.get(i).getId() == id){
                    s.remove(i);
                    remove = true;
                    break;
                }
            }
            if(remove) System.out.println("Student deleted successfully");
            else System.out.println("student not found");
        } 
        // edit feature
        public void updateById(int id){
            boolean edit = false;
            for(Student stud : s){
                if(stud.getId() == id){
                    System.out.println("Enter new name");
                    String name = InputUtil.sc.nextLine();
                    stud.setName(name);

                    System.out.println("Enter new age");
                    int age = InputUtil.sc.nextInt();
                    InputUtil.sc.nextLine();

                    System.out.println("enter new class");
                    String cls = InputUtil.sc.nextLine();
                    stud.setName(cls);

                    System.out.println("Student detail updated successfully");
                    edit = true;
                    break;
                }
            }
            if(!edit) System.out.println("Student not found");
        }
}
