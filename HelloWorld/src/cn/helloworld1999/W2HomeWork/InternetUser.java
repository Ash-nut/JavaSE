package cn.helloworld1999.W2HomeWork;

public class InternetUser {
    private String id;
    private String password;
    private String emailAddress;

    public InternetUser(String id, String password, String emailAddress) {
        this.id = id;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public InternetUser(String id, String password) {
        this.id = id;
        this.password = password;
        this.emailAddress = id+"@gameschool.com";
    }
    
}
