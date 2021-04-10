package com.unicorn.hms;

import java.util.Scanner;

/**
 * @Author: kano_dayo
 * @Date:   2021/4/3 08:47
 */

public class Start {
    static Method ATM = new Method();
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        ATM.user();//导入用户
            int num;
            if ((num = ATM.Login()) != -2) {
                //A simple UI(一个简单的命令行UI）
                ATM.menu();
                //Select functions(选择功能)
                char choice = 'y';
                while (choice == 'y') {
                int select = 4;
                select = scan.nextInt();
                System.out.println("您选择了>>"+select+"服务");
                switch (select) {
                    case 1:
                        ATM.withdraw(Method.Card, num);//取款
                        ATM.menu();
                        break;
                    case 2:
                        ATM.deposit(Method.Card, num);//存款
                        ATM.menu();
                        break;
                    case 3:
                        ATM.query(Method.Card, num);//查询
                        ATM.menu();
                        break;
                    case 4:
                        ATM.exit();//退卡
                        break;
                    default:
                        System.out.println("¿¿¿输入有误，请重新输入");
                        break;
                }

            }System.out.println("输入Y返回上一页，N退出");
                choice =scan.next().charAt(0);

        }
    }
}