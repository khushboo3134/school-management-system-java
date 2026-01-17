import util.InputUtil;
import service.LoginService;
import model.Student;
import util.FileUtil;
import service.StudentService;
import model.Teacher;
import service.TeacherService;
import model.User;
public class Main{
    public static void main(String[]args){
        LoginService ls = new LoginService();
        System.out.print("Enter Username : ");
        String s = InputUtil.sc.nextLine();
        
        System.out.println("Enter Password: ");
        String p = InputUtil.sc.nextLine();

        if (!ls.login(s, p)) {
            System.out.println("Invalid user");

            System.out.print("Do you want to register? (yes/no): ");
            String choice = InputUtil.sc.nextLine();

        if (choice.equalsIgnoreCase("yes")) {

        if (ls.userExists(s)) {
            System.out.println("User already exists. Exit.");
            return;
        }

        User u = new User(s, p);
        ls.register(u);
        System.out.println("Registered successfully. Login again.");
        return;

        } 
        else {
        System.out.println("Exiting...");
        return;
        }
}

        System.out.println("Login successful");


       
        //Menu

        StudentService ss = new StudentService();

        TeacherService ts = new TeacherService();

        int choice;
        do{
            System.out.println("\n===== SCHOOL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Edit Student");
            System.out.println("6. Exit");
            System.out.println("7. Add Teacher");
            System.out.println("8. View Teachers");
            System.out.println("9. Search Teacher");
            System.out.println("10. Delete Teacher");

            System.out.print("Enter choice: ");
            choice = InputUtil.sc.nextInt();
            InputUtil.sc.nextLine(); //buffer clear krta h ye 
            switch(choice){
                case 1:
                    ss.addStudent();
                    System.out.println("Press Enter to continue...");
                    break;
                case 2:
                    ss.viewStu();
                    System.out.println("Press Enter to continue...");
                    break;
                case 3:   // 🔥 SEARCH
                    System.out.print("Enter student ID to search: ");
                    int sid = InputUtil.sc.nextInt();
                    InputUtil.sc.nextLine();
                    ss.searchById(sid);
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int did = InputUtil.sc.nextInt();
                    InputUtil.sc.nextLine();
                    ss.deleteById(did);
                    break;

                case 5:
                    System.out.print("Enter student ID to edit: ");
                    int eid = InputUtil.sc.nextInt();
                    InputUtil.sc.nextLine();
                    ss.updateById(eid);
                    break;
                case 6:
                    System.out.println("Exiting program.....");
                    break;
                case 7:
                    ts.addTeacher();
                    break;

                case 8:
                    ts.viewTeacher();
                    break;

                case 9:
                    System.out.print("Enter teacher ID: ");
                    int tid = InputUtil.sc.nextInt();
                    InputUtil.sc.nextLine();
                    ts.searchTeacher(tid);
                    break;

                case 10:
                    System.out.print("Enter teacher ID: ");
                    int tdel = InputUtil.sc.nextInt();
                    InputUtil.sc.nextLine();
                    ts.deleteTeacher(tdel);
                    break;

                default:
                    System.out.println("Invalid choice, try again !!!!");
            }
        } while(choice != 3);
    }
}