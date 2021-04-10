package com.unicorn.hms;

import java.util.*;

/**
 * @Description: User Account properties(用户账户属性）
 * @Author: kano_dayo
 * @Date:   2021/4/3 12:20
 */
public class Account {
        private Set<Integer> set=new TreeSet<Integer>();
        private double balance;
        private String username;
        private String password;
        public Account(int uuid,String username, String password){
                this.set.add(uuid);
                this.balance = 6666;
                this.username = username;
                this.password = password;
        }
        public boolean check(int uuid) {
                Iterator<Integer> iter=set.iterator();
                while(iter.hasNext()){
                        int in=iter.next();
                        if(in==uuid){
                                return true;
                        }
                }
                return false;
        }
        public void setuuid(int uuid) {
                this.set.add(uuid);
        }
        public String getName(){
                return username;
        }
        public String getPassword(){
                return password;
        }
        public void setPassword(String password){
                this.password = password;
        }
        public double getBalance() {
                return balance;
        }
        public void setbalance(double balance) {
                this.balance += balance;
        }
        public void setbalancedown(double balance) {
                this.balance -= balance;
        }

}
