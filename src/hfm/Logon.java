
package hfm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Logon {
    
    ArrayList<Fund> funds;
    ArrayList<Stock> stocks;
    File dirCheck, FUND, STOCKS;
    Fund player;
    Boolean dirTrue;
    
    public Logon(){
        funds = new ArrayList<>();
        stocks = new ArrayList<>();
        infoCheck();
        readFund();
        //readStocks();
        dirTrue = false;
    }    
    
    public void infoCheck(){    
        dirCheck = new File("K:\\Table Games\\Chipper\\java");
        if(dirCheck.exists()){
            FUND = new File("K:\\Table Games\\Chipper\\java","FUND");
            System.out.println("K:\\Table Games\\Chipper\\java\\FUND");
        }
        if(dirCheck.exists()) dirTrue = true;
        else {
            System.out.println("DIRECTORY DOES NOT EXIST! Using current DIR.");
            FUND = new File(System.getProperty("user.dir"),"FUND");
        }
    }
    
    public void readFund(){
        player = null;        
        try{
            FileInputStream fileIn = new FileInputStream(FUND);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            funds = (ArrayList) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException e){
            //e.printStackTrace();
            System.err.println("readFund IO Error: File FUND not found.");
            return;
        }catch(ClassNotFoundException cnf){
            cnf.printStackTrace();
            System.err.println("Class Not Found Error: not sure what this is...");
            return;
        }
        for(int i = 0;i<funds.size();i++){
            player = (Fund)funds.get(i);
            System.out.println("Deserialized Arraylist: " + i);
            System.out.println("Name: " + player.getName());
            System.out.println("Password: " + player.getPassword());
            System.out.println("Cash: " + player.getCash());
            int[] ii = player.getStocks();
            for(int j = 0;j<9;j++){
                System.out.println("Stock " + j + ": " + ii[j]);
            }
        }        
    }
    
    public void writeFund(){
        try{
            FileOutputStream fileOut = new FileOutputStream(FUND);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);          
            out.writeObject(funds);
            out.close();
            fileOut.close();
            System.out.println("Serialized arraylist data is saved in FUND");
        }catch(IOException e){
            System.err.println("writeFund failed.");
            e.printStackTrace();
        }
    }
    
    public void readStocks(){
        infoCheck();
        String saveStocks = "STOCKS" + player.getName();
        File saveFile;
        if(dirTrue == true){
            saveFile = new File("K:\\Table Games\\Chipper\\java",saveStocks);
        } else saveFile = new File(saveStocks);
        if(!saveFile.exists()){
             System.err.println("readStocks: File " + saveStocks + " not found.");
            return;
        }
        try{
            FileInputStream fileIn = new FileInputStream(saveFile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            stocks = (ArrayList) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException e){
            System.err.println("readStocks IO Error: File " + saveStocks + " not found.");
            return;
        }catch(ClassNotFoundException cnf){
            cnf.printStackTrace();
            System.err.println("Class Not Found Error: not sure what this is...");
            return;
        }
        for(int i = 0;i<stocks.size();i++){
            Stock s = (Stock) stocks.get(i);
            System.out.println("readStock list: " + i);
            System.out.println("Stock Name: " + s.getStockName());
            System.out.println("Stock Price: " + s.getStockValue());
            System.out.println("Stock High: " + s.getStockHigh());
            System.out.println("Stock Low: " + s.getStockLow());
            HFMController.stockNames[i] = s.getStockName();
        }
        HFMController.STOCKS = stocks;
    }
    
    public void writeStocks(ArrayList a){
        infoCheck();
        stocks = a;
        String listName = "STOCKS" + player.getName();
        File fileName = new File(listName);
        if(dirTrue == true){
            fileName = new File("K:\\Table Games\\Chipper\\java",listName);
        } else fileName = new File(listName);         
        try{
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);          
            out.writeObject(stocks);
            out.close();
            fileOut.close();
            System.out.println("Serialized arraylist data is saved in " + listName);
        }catch(IOException e){
            System.err.println("writeStocks failed.");
            e.printStackTrace();
        }
    }
    
    public boolean newFund(String n, String p){
        for(int i = 0;i<funds.size();i++){
            player = (Fund)funds.get(i);
            if(n.equals(player.getName())){
                return false;
            }
        }
        funds.add(new Fund(n,p,10000,new int[9]));
        writeFund();
        return true;
    }
    
    public Fund login(String n, String p){
        for(int i = 0;i<funds.size();i++){
            player = (Fund) funds.get(i);
            if(n.equals(player.getName())){
                if(p.equals(player.getPassword())){
                    return player;
                }
                System.out.println("New Login: Pass does not match");
            }
        } 
        return null;
    }
    
    public void updateBank(){
        for(int i = 0;i<funds.size();i++){
            player = (Fund) funds.get(i);
            if(HFMController.pNAME.equals(player.getName())){
                player.setCash(HFMController.pCASH);
                player.setStocks(HFMController.pSTOCKS);
            }
        }
    }
}
