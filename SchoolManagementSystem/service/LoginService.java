package service;
import java.util.ArrayList;
import model.User;
import util.FileUtil;

public class LoginService {
    public static final String USER_FILE = "data/user.txt";

    //check login
    public boolean login(String username, String password){
        ArrayList<String> users = FileUtil.readFileLine(USER_FILE);
        for(String line : users){
            String[] arr = line.split(",");
            if(arr[0].equals(username)&& arr[1].equals(password)) return true;
        }
        return false;
    }
    // check user exists or nt
        public boolean userExists(String username){
            ArrayList<String> user = FileUtil.readFileLine(USER_FILE);
        for(String line : user){
            String[] arr = line.split(",");
            if(arr[0].equals(username)) return true;
        }
        return false;
        }

        // register new user
        public void register(User user){
            FileUtil.writeFile(USER_FILE, user.toString());
        }
}
