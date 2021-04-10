package com.unicorn.hms;

/**
 * @Description:Methods(各类方法，如存款，取款，查询，退卡)
 * @Author: kano_dayo
 * @Date:   2021/4/3 20:23
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Method {
    static LinkedList<Account> userList = new LinkedList<Account>();
    Scanner scan = new Scanner(System.in);
    double money;
    public static int Card = 0;

    void deposit(int Card, int i) {
        System.out.println("名字:" + userList.get(i).getName());
        System.out.println("请输入存款金额:");
        money = scan.nextDouble();
        userList.get(i).setbalance(money);
        System.out.println("存入" + money + "元");
        System.out.println("现在账号余额:" + userList.get(i).getBalance());

    }//存款方法

    void withdraw(int Card, int i) {
        System.out.println("名字:" + userList.get(i).getName());
        System.out.println("请输入取款金额:");
        money = scan.nextDouble();
        if (money < userList.get(i).getBalance()) {
            userList.get(i).setbalancedown(money);
            System.out.println("取出" + money + "元");
            System.out.println("现在账号余额:" + userList.get(i).getBalance());
        } else {
            System.out.println("兄弟整点阳间的活行不行(请确保卡上有足够的余额!!)");
        }

    }//取款方法

    void query(int Card, int i) {
        System.out.println("名字>" + userList.get(i).getName());
        System.out.println("账号余额>" + userList.get(i).getBalance());
    }//查询方法

    void user() {
        String username = "kano_dayo";
        String password = "123456";
        int uuid = 316381098;
        String Customization;
        System.out.println("-----------------------------------------------");
        System.out.println("*            *******自定义账号?********         *");
        System.out.println("*            ****输入Y确定,输入N取消****         *");
        System.out.println("-----------------------------------------------");
        Customization = scan.next();
        if (Customization.equals("Y")) {
            System.out.println("请输入姓名");
            username = scan.next();
            System.out.println("请输入密码");
            password = scan.next();
            System.out.println("自定义账户名（仅能是数字）");
            uuid = scan.nextInt();
        } else {
            uuid = 316381098;
            System.out.println("已使用默认账户");

        }
        userList.add(new Account(uuid, username, password));
        System.out.println("账号是:" + uuid);
    }//用户

    int Login() {
        String Password;
        System.out.println("请输入账号");
        Card = scan.nextInt();
        System.out.println("请输入密码");
        Password = scan.next();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).check(Card)) {
                if (userList.get(i).getPassword().equals(Password)) {
                    return i;
                } else {
                    System.out.println("密码错误");
                    break;
                }
            } else {
                System.out.println("");
            }
        }
        System.out.println("请检查账户名是否有错");
        return -2;
    }//登录方法
void menu(){
    System.out.println("-----------------------------------------------");
    System.out.println("*******************欢迎使用ATM******************");
    System.out.println("               1.取款      2.存款               ");
    System.out.println("               3.查询      4.退卡               ");
    System.out.println("-----------------------------------------------");
    System.out.println("---------------请输入数字进入相关业务--------------");
}//一个简单的菜单
    void exit() {
        String Operation;
        System.out.println("-----------------------------------------------");
        System.out.println("           ***********警告***********           ");
        System.out.println("           *******是否退出系统?*******           ");
        System.out.println("           ****输入Y确定,输入N取消****            ");
        System.out.println("-----------------------------------------------");
        Operation = scan.next();
        if (Operation.equals("Y")) {
            System.out.println("您已成功退出系统，请拔卡");
            System.out.println("欢迎您再次使用本银行业务");
            System.exit(0);
        } else {

        }
    }//退出
}
