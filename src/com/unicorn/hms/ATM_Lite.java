package com.unicorn.hms;
import java.util.Scanner;
public class ATM_Lite {
    static Scanner scan = new Scanner(System.in);
    public String cardid,password;
    public float balance;
    public ATM_Lite(String cardid, String password, float balance) {
        this.cardid = cardid;
        this.password = password;
        this.balance = balance;
    }
    static ATM_Lite[] account = {new ATM_Lite("316381098", "123456", 6666)};
    public void setBalanceUp(float balance) { this.balance += balance; }
    public void setBalanceDown(float balance) { this.balance -= balance; }
    public float getBalance() { return balance; }
    static void menu() {
        System.out.println("*******************欢迎使用ATM******************");
        System.out.println("               1.取款      2.存款               ");
        System.out.println("               3.查询      4.退卡               ");
        System.out.println("**********************************************");
    }
    static void login() {
        System.out.println("请输入卡号与密码");
        String cardid= scan.next();
        String password = scan.next();
        if (cardid.equals("316381098") && password.equals("123456")) {menu();}else{System.out.println("账户名或密码错误");System.exit(0);}
    }
    public static void main(String[] args) {
        ATM_Lite.login();
        char choice = 'y';
        while (choice == 'y') {
            int select = scan.nextInt();
            switch (select) {
                case 1:
                    System.out.println("请输入取款金额：");
                    float money = scan.nextFloat();
                    if(money<account[0].getBalance()){
                    account[0].setBalanceDown(money);
                    System.out.println("余额：" + account[0].getBalance());
                    menu();}else {System.out.println("余额不足");}
                    break;
                case 2:
                    System.out.println("请输入存款金额：");
                    money = scan.nextFloat();
                    account[0].setBalanceUp(money);
                    System.out.println("余额：" + account[0].getBalance());
                    menu();
                    break;
                case 3:
                    System.out.println("余额：" + account[0].getBalance());
                    menu();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        }choice =scan.next().charAt(0);
    }
}



