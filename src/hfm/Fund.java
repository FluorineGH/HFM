/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hfm;

/**
 *
 * @author jcalvert
 */
public class Fund implements java.io.Serializable{
    
    private String Name;
    private String Password;
    private int Cash;
    private int[] stocks;   
    
    public Fund(String n, String p, int c, int[] s){
        Name = n;
        Password = p;
        Cash = c;
        stocks = new int[9];      
    }

    public int[] getStocks() {
        return stocks;
    }

    public void setStocks(int[] stocks) {
        this.stocks = stocks;
    }

    public void tradeBuy(int s, int a){
        stocks[s] += a;
    }
    
    public void tradeSell(int s, int a){
        stocks[s] -= a;
    }
    
    public String getName(){
      return Name;
    }

    public String getPassword(){
      return Password;
    }
    
    public int getCash(){
      return Cash;
    }
    
    public void setCash(int i){
      Cash = i;
    }   
}
