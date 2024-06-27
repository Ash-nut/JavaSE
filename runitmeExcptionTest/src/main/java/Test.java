import java.util.Enumeration;

public class Test {
    static boolean login() throws RuntimeException{
        String uname = "";
        if(uname == null || uname.trim().equals("")){
            throw new RuntimeException("抛");
        }
        if(uname.equals("admin")){
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        login();
    }
}
