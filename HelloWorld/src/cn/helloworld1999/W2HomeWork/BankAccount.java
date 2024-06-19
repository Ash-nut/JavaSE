package cn.helloworld1999.W2HomeWork;

import java.util.Scanner;

public class BankAccount {
    private String accountNum;
    private String accountName;
    private String accountPassword;
    private double balance;
    
    public BankAccount(){

    }

    @Override
    public String toString() {
        return "BankAccount [accountNum=" + accountNum + ", accountName=" + accountName + ", balance=" + balance + "]";
    }

    public void saveMoney(){
        Scanner sc = new Scanner(System.in);
        double temp = sc.nextDouble();
        if (temp>=0) {
            setBalance(getBalance()+temp);
        }
        sc.close();
    }
    
    public void drawMoney(){
        Scanner sc = new Scanner(System.in);
        double temp = sc.nextDouble();
        if ((temp>=0) && (getBalance()-temp>=0)) {
            setBalance(getBalance()-temp);
            sc.close();
        }
    }

    public void showInformaction(){
        System.out.println(toString());
    }

    public void updateAccountPassword(){
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        setAccountPassword(temp);
    }

    public String getAccountNum() {
        return accountNum;
    }
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public String getAccountPassword() {
        return accountPassword;
    }
    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    } 
}
