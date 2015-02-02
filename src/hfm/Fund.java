/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hfm;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author jcalvert
 */
public class Fund implements java.io.Serializable{
    
    private final String Name;
    private final String Password;
    private BigDecimal Cash;
    private int[] stocks;   
    
    public Fund(String n, String p, int c, int[] s){
        Name = n;
        Password = p;
        Cash = new BigDecimal(c);
        Cash = Cash.setScale(2, RoundingMode.CEILING);
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
    
    public BigDecimal getCash(){
        return Cash;
    }
    
    public void setCash(BigDecimal i){
        Cash = i;
    }   
}
