package cn.helloworld1999;
import java.util.Scanner;
import java.util.Arrays;

public class AccountManage {
    static public String[] strAccountsInformaction = new String[]{
        "20230111-  李朝宗 - 男 - 15067682233 - 30899 - JAVA工程师",
        "20230112 - 杨星阑 - 男 - 15067682255 - 26000 - JAVA工程师",
        "20230113 - 唐碗儿 - 女 - 15067682266 - 18899 - WEB工程师",
        "20230114 - 杨婉柔 - 女 - 15367682277 - 60000 - UI工程师"};
        static Account[] accounts = new Account[0];
    public static void main(String[] args) {
        AccountManage.accounts = initAccountArray(strAccountsInformaction);     //OK 初始化
        while (true) {
            menu(AccountManage.accounts);
        }
    }
    static public void menu(Account[]accounts){
        System.out.println("1.查看所有账户");
        System.out.println("2.新增一条账户信息");
        System.out.println("3.输入用户ID,修改任意信息");
        System.out.println("4.输入用户ID,删除用户");
        System.out.println("5.查询指定编号的账户信息");
        System.out.println("6.查询所有性别是“女”的账户信息");
        System.out.println("7.找出所有姓“杨”的账户信息");
        System.out.println("8.找出余额最高的那个账户信息");
        System.out.println("9.找出电话号码以'150'开头的账户信息");
        System.out.println("10.根据职业统计出不同职业类型的人数，并且显示出这个性别的所有账户信息是那些");
        System.out.println("11.退出");
        Scanner sc = new Scanner(System.in);
        byte key = sc.nextByte();
        switch (key) {
            case 1:
                showAccountsInformaction(AccountManage.accounts);
                break;
            case 2:
                AccountManage.accounts = createNewAccout(AccountManage.accounts);
                break;
            case 3:
                AccountManage.accounts = updataAccount(AccountManage.accounts);
                break;
            case 4:
                AccountManage.accounts = dropAccountInformaction(AccountManage.accounts);
                break;
            case 5:
                retrieveAccount(AccountManage.accounts);
                break;
            case 6:
                showAllGenderIsWomen(AccountManage.accounts);
                break;
            case 7:
                showAllLastNameIsYang(AccountManage.accounts);
                break;
            case 8:
                showBalanceMaxUserInformaction(AccountManage.accounts);
                break;
            case 9:
                showPhoneNumStartIsThatNum(AccountManage.accounts);
                break;
            case 10:
                showPerfession(AccountManage.accounts);
                break;
            case 11:
                System.exit(0);
                break;
            default:
                System.out.println("非法输入");
                break;
        }
    }
    /**
     * 初始化对象数组
     * @param strArray  用户信息字符串数组
     * @return  用户信息对象数组
     */
    static public Account[] initAccountArray(String[] strArray){
        Account[] accounts = new Account[strArray.length];
        for(int i = 0;i<strArray.length;i++){
            accounts[i] = new Account(
            strArray[i].replaceAll(" ","").split("-")[0], 
            strArray[i].replaceAll(" ","").split("-")[1], 
            strArray[i].replaceAll(" ","").split("-")[2], 
            strArray[i].replaceAll(" ","").split("-")[3], 
            Double.parseDouble(strArray[i].replaceAll(" ","").split("-")[4]), 
            strArray[i].replaceAll(" ","").split("-")[5]);
        }
        return accounts;
    }
    /**
     * 通过用户ID进行检索
     * @param str
     * @param accounts
     * @return  目标ID在用户对象数组的索引，寻找失败返回 -1
     */
    static public int cheakInputAccoutNumAndReturnIndex(String str,Account[] accounts){
        if(!str.matches("[2][0][0-9]{6}")){
            System.out.println("输入的用户ID非法");
            return -2;
        }
        for(int i = 0;i<accounts.length;i++){
            if (str.equals(accounts[i].accountID)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * 功能1，展示全体用户信息
     * @param accounts 用户对象数组
     */
    static public void showAccountsInformaction(Account[] accounts){
        System.out.println("全体用户信息");
        System.out.println("账号ID | 用户名 | 性别 | 联系电话 | 余额 | 职业");
        for(int i = 0;i<accounts.length;i++){
            System.out.println(accounts[i].accountID+" | "+accounts[i].accountName+" | "+accounts[i].gender+" | "+accounts[i].phoneNum+" | "+accounts[i].balance+" | "+accounts[i].profession);
        }
    }
    /**
     * 功能2，创建一个新用户
     * @param accounts
     */
    static public Account[] createNewAccout(Account[] accounts){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入想要创建的用户【账号ID】:");
        String strAccoutnID = sc.next();
        if (cheakInputAccoutNumAndReturnIndex(strAccoutnID, accounts)==-2){
            return accounts;
        }
        if (cheakInputAccoutNumAndReturnIndex(strAccoutnID, accounts) == -1) {
            accounts = Arrays.copyOf(accounts,accounts.length+1);
            System.out.println("输入想要创建的用户【用户名】:");
            String strAccountUserName = sc.next();
            System.out.println("输入想要创建的用户【性别】:");
            String strAccountUsergender = sc.next();
            System.out.println("输入想要创建的用户【联系电话】:");
            String strAccountUserPhoneNumber = sc.next();
            System.out.println("输入想要创建的用户【余额】:");
            double strAccountUserBalance = sc.nextDouble();
            System.out.println("输入想要创建的用户【职业】:");
            String strAccountUserProfession = sc.next();
            accounts[accounts.length-1] = new Account(strAccoutnID, strAccountUserName, strAccountUsergender, strAccountUserPhoneNumber, strAccountUserBalance, strAccountUserProfession);
            System.out.println("创建完毕");
            return accounts;
        }else{
            System.out.println("非法输入");
        }
        return accounts;
    }
    /**
     * 功能5,通过ID查找指定目标
     * @param accounts
     */
    static public void retrieveAccount(Account[] accounts){
        System.out.println("输入待查找的目标ID:");
        Scanner sc = new Scanner(System.in);
        String strAccountID = sc.next();
        int i = cheakInputAccoutNumAndReturnIndex(strAccountID, accounts);
        if (i == -2) {
            System.out.println("输入格式有误");
        }else if (i == -1) {
            System.out.println("查无此人");
        }else{
            System.out.println("账号ID | 用户名 | 性别 | 联系电话 | 余额 | 职业");
            System.out.println(accounts[i].accountID+" | "+accounts[i].accountName+" | "+accounts[i].gender+" | "+accounts[i].phoneNum+" | "+accounts[i].balance+" | "+accounts[i].profession);
        }
    }
    static public Account[] updataAccount(Account[] accounts){
        System.out.println("输入待查找的目标ID:");
        Scanner sc = new Scanner(System.in);
        String strAccountID = sc.next();
        int i = cheakInputAccoutNumAndReturnIndex(strAccountID, accounts);
        if (i == -2) {
            System.out.println("输入格式有误");
        }else if (i == -1) {
            System.out.println("查无此人");
        }else{
            System.out.println("账号ID | 用户名 | 性别 | 联系电话 | 余额 | 职业");
            System.out.println(accounts[i].accountID+" | "+accounts[i].accountName+" | "+accounts[i].gender+" | "+accounts[i].phoneNum+" | "+accounts[i].balance+" | "+accounts[i].profession);
            System.out.println("输入你想修改的信息(1.账号ID | 2.用户名 | 3.性别 | 4.联系电话 | 5.余额 | 6.职业):");
            byte key = sc.nextByte();
            switch (key) {
                case 1:
                    System.out.println("修改账号ID为:");
                    accounts[i].resetAccountID(accounts);
                    break;
                case 2:
                    System.out.println("修改用户名为:");
                    accounts[i].resetAccountName();
                    break;
                case 3:
                    System.out.println("修改性别:");
                    accounts[i].resetGender();
                    break;
                case 4:
                    System.out.println("修改联系电话为:");
                    accounts[i].resetPhoneNum();
                    break;
                case 5:
                    System.out.println("修改余额:");
                    accounts[i].resetBalance();
                    break;
                case 6:
                    System.out.println("修改职业为:");
                    accounts[i].resetProfession();
                    break;    
                default:
                System.out.println("非法输入");
                    break;
            }
        }
        return accounts;
    }
    /**
     * 删除指定目标
     * @param accounts
     * @return
     */
    public static Account[] dropAccountInformaction(Account[]accounts){
        System.out.println("输入待删除的目标ID:");
        Scanner sc = new Scanner(System.in);
        String strAccountID = sc.next();
        int i = cheakInputAccoutNumAndReturnIndex(strAccountID, accounts);
        if (i == -2) {
            System.out.println("输入格式有误");
        }else if (i == -1) {
            System.out.println("查无此人");
        }else{
            accounts[i] = accounts[accounts.length-1];
            accounts = Arrays.copyOf(accounts, accounts.length-1);
        }
        return accounts;
    }
    /**
     * 所有女性用户信息
     * @param accounts
     */
    public static void showAllGenderIsWomen(Account[] accounts){
        System.out.println("所有性别为“女”的账户信息：");
        System.out.println("账号ID | 用户名 | 性别 | 联系电话 | 余额 | 职业");
        for(Account i:accounts){
            if (i.gender.equals("女")) {
                System.out.println(i.accountID+" | "+i.accountName +" | "+i.gender+" | "+i.phoneNum+i.balance+" | "+i.profession);
            }
        }
    }
    public static void showAllLastNameIsYang(Account[] accounts){
        System.out.println("所有姓氏为“杨”的账户信息：");
        System.out.println("账号ID | 用户名 | 性别 | 联系电话 | 余额 | 职业");
        for(Account i:accounts){
            if (i.accountName.startsWith("杨")) {
                System.out.println(i.accountID+" | "+i.accountName +" | "+i.gender+" | "+i.phoneNum+i.balance+" | "+i.profession);
            }
        }
    }
    /**
     * 显而易见的，为了提升程序的健壮性，咱们得先搜出最高的 balance的值，然后去输出等于这个值的账户，避免出现并列第一却统计缺失
     * @param accounts
     */
    public static void showBalanceMaxUserInformaction(Account[]accounts){
        System.out.println("余额最高的用户信息为：");
        System.out.println("账号ID | 用户名 | 性别 | 联系电话 | 余额 | 职业");
        double indexBalance = 0;
        for(int i = 0;i<accounts.length-1;i++){
            indexBalance = accounts[i].balance>=indexBalance?accounts[i].balance:indexBalance;
        }
        for(Account i :accounts){
            if (indexBalance==i.balance) {
                System.out.println(i.accountID+" | "+i.accountName +" | "+i.gender+" | "+i.phoneNum+i.balance+" | "+i.profession);
            }
        }
    }
    /**
     * 没什么特别之处
     * @param accounts
     */
    public static void showPhoneNumStartIsThatNum(Account[]accounts){
        System.out.println("话号码以'150'开头的账户信息为：");
        System.out.println("账号ID | 用户名 | 性别 | 联系电话 | 余额 | 职业");
        for(Account i:accounts){
            if (i.phoneNum.matches("[1][5][0][0-9]{8}")) {
                System.out.println(i.accountID+" | "+i.accountName +" | "+i.gender+" | "+i.phoneNum+i.balance+" | "+i.profession);
            }
        }
    }
    public static void showPerfession(Account[]accounts){
        int i = 0;
        int j = 0;
        String[] prefessionTypesArray = new String[0];
        int [] prefessionNumArray = new int[0];
        //我用信息表做外层，类型表做内层
        for(j = 0;j<accounts.length;j++){
            boolean flag = false;
            //逐个比对类型表，检查是否存在该类型，我给它i是为了把i传出去
            for(i=0;i<prefessionTypesArray.length;i++){
                if (accounts[j].profession.equals(prefessionTypesArray[i])) {
                    prefessionNumArray[i]+=1;
                    flag = true;
                    break;
                }         
            }
            if (!flag) {
                prefessionNumArray = Arrays.copyOf(prefessionNumArray, prefessionNumArray.length+1);
                prefessionTypesArray = Arrays.copyOf(prefessionTypesArray, prefessionTypesArray.length+1);
                prefessionTypesArray[prefessionTypesArray.length-1] = accounts[j].profession;
                prefessionNumArray[prefessionNumArray.length-1] = 1;
            }
        }
        for(int l =0;l<prefessionTypesArray.length;l++){
            System.out.println("职业为："+prefessionTypesArray[l]+"的人数为："+prefessionNumArray[l]+"详细信息如下：");
            System.out.println("账号ID | 用户名 | 性别 | 联系电话 | 余额 | 职业");
            for(Account ii:accounts){
                if (ii.profession.equals(prefessionTypesArray[l])) {
                    System.out.println(ii.accountID+" | "+ii.accountName +" | "+ii.gender+" | "+ii.phoneNum+ii.balance+" | "+ii.profession);
                }
            }
        }
    }
}




/**
 * 用户信息类，当结构体来用的
 */
class Account {
    String accountID = null;    //账号
    String accountName = null;  //用户名
    String gender = null;   //性别
    String phoneNum = null;     //联系电话
    double balance = 0;     //余额
    String profession = null;       //职业

    Account(String accountID,String accountName,String gender,String phoneNum,double balance,String profession){
        this.accountID = accountID;
        this.accountName = accountName;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.balance = balance;
        this.profession = profession;
    }
    void resetAccountID(Account[]accounts){
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        if (AccountManage.cheakInputAccoutNumAndReturnIndex(temp, accounts)==-2) {
            System.out.println("输入格式错误，修改失败");
            return;
        }else if(AccountManage.cheakInputAccoutNumAndReturnIndex(temp, accounts)==-1){
            System.out.println("ID已存在,修改失败");
        }else{
            accountID = sc.next();
        }
    }
    void resetAccountName(){
        Scanner sc = new Scanner(System.in);
        accountName = sc.next();
    }
    void resetGender(){
        Scanner sc = new Scanner(System.in);
        gender = sc.next();
    }
    void resetPhoneNum(){
        Scanner sc = new Scanner(System.in);
        phoneNum = sc.next();
    }
    void resetBalance(){
        Scanner sc = new Scanner(System.in);
        balance = sc.nextDouble();
    }
    void resetProfession(){
        Scanner sc = new Scanner(System.in);
        profession = sc.next();
    }
}
