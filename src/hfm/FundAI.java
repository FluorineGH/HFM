/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hfm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 *
 * @author jcalvert
 */
public class FundAI implements java.io.Serializable{
    
    private final String fundName;
    private BigDecimal fundCash;
    private BigDecimal fundValue;
    private int[] fundStocks;
    private int aiType;
    private int TYPE = 3;
    Random r;
    
    public FundAI(String s){
        fundName = s;
        fundCash = new BigDecimal(10000.00);
        fundValue = fundCash;
        fundCash = fundCash.setScale(2, RoundingMode.CEILING);
        fundValue = fundValue.setScale(2, RoundingMode.CEILING); 
        r = new Random();
        aiType = initAi();
        fundStocks = new int[9];
        fundStocks = initFund();
    }

    private int initAi(){
        int i = r.nextInt(TYPE);
        System.out.println("Ai Type is: " + i);
        return i;        
    }
    
    private int[] initFund(){
        // Set the Fund Ai here and buy initial holdings       
        int b = 0;
        BigDecimal price = new BigDecimal(1000);
        price = price.setScale(2, RoundingMode.CEILING);
        switch(aiType){
            case 0: // Balanced
                b = r.nextInt(9);
                for(int i = 0;i<9;i++){    
                    if(i == b){
                        fundStocks[i] += 100;
                        fundCash = fundCash.subtract(price);
                        System.out.println("Balanced Fund " + fundName + " bought extra 100 shares of " + i);
                    }
                    fundStocks[i] += 100;
                    fundCash = fundCash.subtract(price);
                    System.out.println("Balanced Fund " + fundName + " bought 100 shares of " + i);
                }
                System.out.println("Balanced Fund cash left is: " + fundCash.toString());
                break;
            case 1: // Random
                while(fundCash.compareTo(BigDecimal.ZERO) == 1){
                    b = r.nextInt(9);
                    fundStocks[b] += 100;
                    fundCash = fundCash.subtract(price);
                    System.out.println("Random Fund cash left is: " + fundCash.toString());
                    System.out.println("Random Fund " + fundName + " bought 100 shares of " + b);
                }
                break;
            case 2: // Gambler
                b = r.nextInt(9);
                fundStocks[b] += 1000;
                fundCash = BigDecimal.ZERO;
                System.out.println("Gambler Fund cash left is: " + fundCash.toString());
                System.out.println("Gambler Fund " + fundName + " bought 1000 shares of " + b);
                break;
        }
                
        return fundStocks;
    }
    
    public int getType(){
        return aiType;
    }
    
    public String getFundName() {
        return fundName;
    }
    
    public BigDecimal getFundCash() {
        return fundCash;
    }

    public void setFundCash(BigDecimal fundCash) {
        this.fundCash = fundCash;
    }

    public void divFund(BigDecimal bd){
        fundCash = fundCash.add(bd);
    }
    
    public int[] getFundStocks() {
        return fundStocks;
    }

    public void setFundStocks(int[] fundStocks) {
        this.fundStocks = fundStocks;
    }

    public BigDecimal getValue(){  
        fundValue = BigDecimal.ZERO;
        BigDecimal sval = BigDecimal.ZERO;
        for(int i = 0;i < 9;i++){
            sval = HFMController.STOCKS.get(i).getStockValue().multiply(new BigDecimal(fundStocks[i]));
//            Stock s = HFMController.STOCKS.get(i);
//            sval = s.getStockValue().multiply(new BigDecimal(fundStocks[i]));
            fundValue = fundValue.add(sval);
        }
        fundValue.add(fundCash);
        return fundValue;
    }
    
    public void aiTurn(){
        if(fundValue.compareTo(BigDecimal.ZERO) == 0 && fundCash.compareTo(BigDecimal.ZERO) == 0){
            System.out.println(fundName + " is BROKE!");
            /// OUT OF BUSINESS
            return;
        }
        BigDecimal low = new BigDecimal(100);
        int lowi = 10;
        BigDecimal lowfive = new BigDecimal(100);
        int lowi5 = 10;
        BigDecimal high = BigDecimal.ZERO;
        int highi = 10;
        BigDecimal price = new BigDecimal(100);
        BigDecimal price2 = new BigDecimal(100);
        
        for(int i = 0;i<9;i++){
            if(HFMController.STOCKS.get(i).getStockValue().compareTo(low) == -1){
                low = HFMController.STOCKS.get(i).getStockValue();
                lowi = i;
            }
            if(HFMController.STOCKS.get(i).getStockValue().compareTo(lowfive) == -1 && HFMController.STOCKS.get(i).getStockValue().compareTo(new BigDecimal(5)) == 1){
                lowfive = HFMController.STOCKS.get(i).getStockValue();
                lowi5 = i;
            }
            if(HFMController.STOCKS.get(i).getStockValue().compareTo(high) == 1 && fundStocks[i] > 0){
                high = HFMController.STOCKS.get(i).getStockValue();
                highi = i;
            }
        }
        
        switch(aiType){           
            case 0: // Balanced
                if(lowi5 == 10) break;
                price = price.multiply(lowfive);
                while(fundCash.compareTo(price) == 1 || fundCash.compareTo(price) == 0){
                    fundStocks[lowi5] += 100;
                    fundCash = fundCash.subtract(price);
                    System.out.println("Balanced " + fundName + " bought 100 shares of " + HFMController.STOCKS.get(lowi5).getStockName());
                }
                break;
            case 1: // Random
                price = price.multiply(low);
                int i;
                while(fundCash.compareTo(price) == 1){
                    i = r.nextInt(9);
                    price2 = HFMController.STOCKS.get(i).getStockValue().multiply(new BigDecimal(100));
                    if(fundCash.compareTo(price2) == 1){
                        fundStocks[i] += 100;
                        fundCash = fundCash.subtract(price2);
                        System.out.println("Random " + fundName + " bought 100 shares of " + HFMController.STOCKS.get(i).getStockName());
                    }
                }
                break;
                
            case 2: // Gambler
                price = price.multiply(low);
                price2 = price2.multiply(high);
                if(price.compareTo(price2) == 0) break;
                if(highi == 10) break;
                while(fundStocks[highi] > 0){
                    fundStocks[highi] -= 100;
                    fundCash = fundCash.add(price2);
                    System.out.println("Gambler " + fundName + " sold 100 shares of " + HFMController.STOCKS.get(highi).getStockName());
                }
                while(fundCash.compareTo(price) == 1 || fundCash.compareTo(price) == 0){
                    fundStocks[lowi] += 100;
                    fundCash = fundCash.subtract(price);
                    System.out.println("Gambler " + fundName + " bought 100 shares of " + HFMController.STOCKS.get(lowi).getStockName());
                }
                break;
        }
    }   
// END
}
