package cn.helloworld1999.userManagement;
/**
 * User
 */
public class User {

    private String userNum;
    private String userName;
    private String userGender;
    private double userBalance;
    private String userBirthday;
    
    public User(){
        
    }

    public User(String userNum, String userName, String userGender, double userBalance, String userBirthday) {
        this.userNum = userNum;
        this.userName = userName;
        this.userGender = userGender;
        this.userBalance = userBalance;
        this.userBirthday = userBirthday;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(double userBalance) {
        this.userBalance = userBalance;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    @Override
    public String toString() {
        return "User [userNum=" + userNum + ", userName=" + userName + ", userGender=" + userGender + ", userBalance="
                + userBalance + ", userBirthday=" + userBirthday + "]";
    }
    
}