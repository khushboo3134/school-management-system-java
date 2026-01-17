package service;
import util.InputUtil;
import model.Teacher;
import java.util.ArrayList;

public class TeacherService {
    private ArrayList<Teacher> teachers = new ArrayList<>(); 
    
    // Add teacher
    public void addTeacher(){
        System.out.print("Enter Teacher ID: ");
        int id = InputUtil.sc.nextInt();
        InputUtil.sc.nextLine();

        System.out.print("Enter Teacher Name: ");
        String name = InputUtil.sc.nextLine();

        System.out.print("Enter Subject: ");
        String subject = InputUtil.sc.nextLine();

        Teacher t = new Teacher(id, name, subject);
        teachers.add(t);

        System.out.println("Teacher added successfully");
    }
    // view teacher
    public void viewTeacher(){
        if(teachers.isEmpty()){
            System.out.println("No teacher available");
            return;
        }
        for(Teacher t : teachers){
            System.out.println(t);
        }
    }
    // search teacher
    public void searchTeacher(int id){
        boolean f = false;
        for(Teacher t : teachers){
            if(t.getId() == id){
                System.out.println("Teacher found");
                System.out.println(t);
                f = true;
                break;
            }
        }
        if(!f) System.out.println("Teacher not found");
    }
    // delete teacher
    public void deleteTeacher(int id){
        boolean f = false;
        for(int i = 0 ; i < teachers.size(); i++){
            if(teachers.get(i).getId() == id){
                teachers.remove(i);
                f = true;
                break;
            }
        }
        if(f) System.out.println("Teacher deleted successfully");
        else System.out.println("Teacher not found");
    }
}
