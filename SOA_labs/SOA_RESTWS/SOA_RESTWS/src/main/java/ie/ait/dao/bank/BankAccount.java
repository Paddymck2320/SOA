/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.ait.dao.bank;

/**
 *
 * @author A00261481
 */
public class BankAccount {
    
    private String branch_code;
    private String account_num;
    private String cust_name;
    private String cust_address;
    private int cust_rating;
    private float balance;
    
    public BankAccount(String branch_code, String account_num, String cust_name, String cust_address, int cust_rating, float balance){
        this.branch_code = branch_code;
        this.account_num = account_num;
        this.cust_name = cust_name;
        this.cust_address = cust_address;
        this.cust_rating = cust_rating;
        this.balance = balance;
    }
    
    public BankAccount(){
        
    }
    
    public String getBranchCode(){
        return branch_code;
    }
    
    public void setBranchCode(String branch_code){
        this.branch_code = branch_code;
    }
    
    public String getAccountNum(){
        return account_num;
    }
    
    public void setAccountNum(String account_num){
        this.account_num = account_num;
    }
    public String getCustName(){
        return cust_name;
    }
    
    public void setCustName(String cust_name){
        this.cust_name = cust_name;
    }
    public String getCustAddress(){
        return cust_address;
    }
    
    public void setCustAddress(String cust_address){
        this.cust_address = cust_address;
    }

    public int getCust_rating() {
        return cust_rating;
    }

    public void setCust_rating(int cust_rating) {
        this.cust_rating = cust_rating;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    
    
}
