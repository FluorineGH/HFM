/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hfm;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Stock implements java.io.Serializable {
    
    private final String stockName;
    private BigDecimal stockValue;
    private BigDecimal stockHigh;
    private BigDecimal stockLow;

    public Stock(String s){
        
        stockName = s;
        stockValue = new BigDecimal(10.00);
        stockHigh = new BigDecimal(10.00);
        stockLow = new BigDecimal(10.00);
        stockValue = stockValue.setScale(2, RoundingMode.CEILING);
        stockHigh = stockHigh.setScale(2, RoundingMode.CEILING);
        stockLow = stockLow.setScale(2, RoundingMode.CEILING);               
    }
    
    public String getStockName(){
        return stockName;
    }
    
     public BigDecimal getStockValue() {
        return stockValue;
    }

    public void setStockValue(BigDecimal stockValue) {
        this.stockValue = stockValue;
    }

    public BigDecimal getStockHigh() {
        return stockHigh;
    }

    public void setStockHigh(BigDecimal stockHigh) {
        this.stockHigh = stockHigh;
    }

    public BigDecimal getStockLow() {
        return stockLow;
    }

    public void setStockLow(BigDecimal stockLow) {
        this.stockLow = stockLow;
    }        
// END
}
