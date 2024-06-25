package cn.helloworld1999;

public class User {
    private String userName;
    private String userID;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public User(String userName, String userID) {
        this.userName = userName;
        this.userID = userID;
    }
    public User() {
    }
}
