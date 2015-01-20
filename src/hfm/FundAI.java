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
public class FundAI implements java.io.Serializable{
    
    private final String fundName;
    private BigDecimal fundCash;
    private BigDecimal fundValue;
    private int[] fundStocks;
    
    public FundAI(String s){
        fundName = s;
        fundCash = new BigDecimal(1000.00);
        fundValue = fundCash;
        fundCash = fundCash.setScale(2, RoundingMode.CEILING);
        fundValue = fundValue.setScale(2, RoundingMode.CEILING);        
        fundStocks = new int[9];      
    }

    private void initFund(){
        // Set the Fund Ai here and buy initial holdings
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
            Stock s = HFMController.STOCKS.get(i);
            sval = s.getStockValue().multiply(new BigDecimal(fundStocks[i]));
            fundValue.add(sval);
        }
        fundValue.add(fundCash);
        return fundValue;
    }
// END
}
