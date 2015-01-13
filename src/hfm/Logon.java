
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
    File dirCheck, FUND;
    Fund player;
    
    public Logon(){
        funds = new ArrayList<>();
        scoreCheck();
        readFund();
    }    
    
    public void scoreCheck(){    
        dirCheck = new File("K:\\Table Games\\Chipper\\java");
        if(dirCheck.exists()) FUND = new File("K:\\Table Games\\Chipper\\java","FUND");
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
            System.err.println("readAccount IO Error: File not found.");
            //e.printStackTrace();
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
    
    public void writeAccount(){
        try{
            FileOutputStream fileOut = new FileOutputStream(FUND);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);          
            out.writeObject(funds);
            out.close();
            fileOut.close();
            System.out.println("Serialized arraylist data is saved in FUND");
        }catch(IOException e){
            System.err.println("writeAccount failed.");
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
        funds.add(new Fund(n,p,100,new int[9]));
        System.out.println("New funds size: " + funds.size());
        writeAccount();
        return true;
    }
    
    public void login(String n, String p){
        for(int i = 0;i<funds.size();i++){
            player = (Fund) funds.get(i);
            if(n.equals(player.getName())){
                if(p.equals(player.getPassword())){
                    System.out.println("Welcome " + player.getName() + "!");
                    HFMController.NAME = player.getName();
                    HFMController.CASH = player.getCash();
                    HFMController.STOCKS = player.getStocks();
                    HFMController.acc = true;
                    return;
                }
                System.out.println("New Login: Pass does not match");
            }
        }              
    }
    
    public void updateBank(){
        for(int i = 0;i<funds.size();i++){
            player = (Fund) funds.get(i);
            if(HFMController.NAME.equals(player.getName())){
                player.setCash(HFMController.CASH);
                player.setStocks(HFMController.STOCKS);
            }
        }
    }
}
