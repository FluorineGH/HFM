package hfm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;

public class HFMController implements Initializable{

    @FXML private TableView<?> stats;
    
    @FXML private AnchorPane AI1;
    @FXML private AnchorPane AI2;
    @FXML private AnchorPane AI3;
    @FXML private AnchorPane AI4;
    @FXML private AnchorPane AI5;
    @FXML private AnchorPane stockPane1;
    @FXML private AnchorPane stockPane2;
    @FXML private AnchorPane stockPane3;
    @FXML private AnchorPane stockPane4;
    @FXML private AnchorPane stockPane5;
    @FXML private AnchorPane stockPane6;
    @FXML private AnchorPane stockPane7;
    @FXML private AnchorPane stockPane8;
    @FXML private AnchorPane stockPane9;

    @FXML private ImageView fund1img;
    @FXML private ImageView fund2img;
    @FXML private ImageView fund3img;
    @FXML private ImageView fund4img;
    @FXML private ImageView fund5img;
    @FXML private ImageView stockDie;
    @FXML private ImageView actionDie;
    @FXML private ImageView amountDie;
    
    @FXML private Label turnLabel;
    @FXML private Label statusLabel;
      
    @FXML private Label fund1name;
    @FXML private Label fund1rank;
    @FXML private Label fund1value;
    @FXML private Label fund2name;
    @FXML private Label fund2rank;
    @FXML private Label fund2value;
    @FXML private Label fund3name;
    @FXML private Label fund3rank;
    @FXML private Label fund3value;    
    @FXML private Label fund4name;
    @FXML private Label fund4rank;
    @FXML private Label fund4value;
    @FXML private Label fund5name;
    @FXML private Label fund5rank;  
    @FXML private Label fund5value;
 
    @FXML private Label stock1name;
    @FXML private Label stock1price;
    @FXML private Label stock1volume;   
    @FXML private Label stock1high;
    @FXML private Label stock1low;
    @FXML private Label stock2name;
    @FXML private Label stock2price;
    @FXML private Label stock2volume;
    @FXML private Label stock2high;
    @FXML private Label stock2low;    
    @FXML private Label stock3name;
    @FXML private Label stock3price;
    @FXML private Label stock3volume;
    @FXML private Label stock3high;
    @FXML private Label stock3low;
    @FXML private Label stock4name;
    @FXML private Label stock4price;
    @FXML private Label stock4volume;
    @FXML private Label stock4high;
    @FXML private Label stock4low;    
    @FXML private Label stock5name;
    @FXML private Label stock5price;
    @FXML private Label stock5volume;
    @FXML private Label stock5high;
    @FXML private Label stock5low;
    @FXML private Label stock6name;
    @FXML private Label stock6price;
    @FXML private Label stock6volume;
    @FXML private Label stock6high;   
    @FXML private Label stock6low;
    @FXML private Label stock7name;
    @FXML private Label stock7price;
    @FXML private Label stock7volume;
    @FXML private Label stock7high;
    @FXML private Label stock7low;
    @FXML private Label stock8name;
    @FXML private Label stock8price;
    @FXML private Label stock8volume;
    @FXML private Label stock8high;
    @FXML private Label stock8low;
    @FXML private Label stock9name;
    @FXML private Label stock9price; 
    @FXML private Label stock9volume;
    @FXML private Label stock9high;
    @FXML private Label stock9low;
    
    @FXML private Label playerFund;
    @FXML private Label playerRank;
    @FXML private Label playerEquity;
    @FXML private Label playerCash;    
    
    @FXML private Label playerStock1name;
    @FXML private Label playerStock1owned;
    @FXML private Label playerStock2name;
    @FXML private Label playerStock2owned;
    @FXML private Label playerStock3name;
    @FXML private Label playerStock3owned;
    @FXML private Label playerStock4name;
    @FXML private Label playerStock4owned;
    @FXML private Label playerStock5name;
    @FXML private Label playerStock5owned;
    @FXML private Label playerStock6name;
    @FXML private Label playerStock6owned;
    @FXML private Label playerStock7name;
    @FXML private Label playerStock7owned;
    @FXML private Label playerStock8name;
    @FXML private Label playerStock8owned;
    @FXML private Label playerStock9name;
    @FXML private Label playerStock9owned;
 
    @FXML private ChoiceBox<String> stockPicker;
    @FXML private ChoiceBox<String> actionPicker;
    //ObservableList<String> choseStock;
    
    //@FXML private Button catsButton;
    @FXML private Button executeButton;
    @FXML private Button goButton;
    @FXML private Button quitButton;
    
    // Logon Info
    static String pNAME;
    static BigDecimal pEQUITY;
    static BigDecimal pCASH;
    static int[] pSTOCKS;
    static boolean acc;
    Logon log;
    Fund player;
   
    // AI Directives
    static ArrayList<FundAI> AIs;
    BigDecimal[] fVALUE;
    
    
    // Initialization
    static int TURN, die1, die2, die3;
    static int[] STOCKVOL, RANKS;
    private final int nameNum = 14;
    public static ArrayList<Stock> STOCKS;
    public ArrayList<Label> SNL, SPL, SVL, SHL, SLL, PSN, PSO, FN, FR, FV;
    private final ArrayList<Background> stockBackD, stockBackU;
    private final ArrayList<AnchorPane> stockBacks;      
    private String[] fundNames;
    static String[] stockNames;
    Random r;
    private Image DOWN, PAY, HALT, UP, SBD1, SBD2, SBD3, SBD4, SBD5, SBD6, SBD7, SBD8, SBD9, SBU1, SBU2, SBU3, SBU4, SBU5, SBU6, SBU7, SBU8, SBU9, SBH, SBN, SBS;
    private BackgroundImage bSBD1, bSBD2, bSBD3, bSBD4, bSBD5, bSBD6, bSBD7, bSBD8, bSBD9, bSBU1, bSBU2, bSBU3, bSBU4, bSBU5, bSBU6, bSBU7, bSBU8, bSBU9, bSBH, bSBN, bSBS;
    private Background bgSBD1, bgSBD2, bgSBD3, bgSBD4, bgSBD5, bgSBD6, bgSBD7, bgSBD8, bgSBD9, bgSBU1, bgSBU2, bgSBU3, bgSBU4, bgSBU5, bgSBU6, bgSBU7, bgSBU8, bgSBU9, bgSBH, bgSBN, bgSBS;
    
    private final String[] FNAME1 = {"Black","Red","Golden","Silver","First","Premier","Apex","Provincial","Countrywide","Global",
                              "Aspirational","Crystal","National","Interdimensional","Universal"};
    private final String[] FNAME2 = {"Squid","Rock","Tree","Horizon","Investors","Capital","Moneybags","Snatchem","Lupine","Porkbelly",
                              "Wealth","Accretion","Delta","Omega","Alpha Seeking"};
    private final String[] FNAME3 = {"Trust","Partners","Associates","Holdings","Group","Capital","Securities","Markets","Incorporated","Funds",
                              "Fund","Capital Group","Management","Equity Holdings","Advisors"};
        
    private final String[] SNAME1 = {"Platypus","Viceroy","Tachyon","Pestilence","Bugbear","Clearcut","Windy Field","The Happy Pinecone","FDMR","Birdhouses",
                              "The Golden Snakeskin","Onyx","Presidio","Ubiquitous","Pyramid","Frisky Squirrels","Stellar Express","Planetary","Exelsior",
                              "J. Chang","Abysmal Glare","Speed","Tuna Belly","Gentleman","Style","Focus","Eagle Wing","Red Door","Citadel","Olympia","Terra Nova",
                              "Anchor","Crown","Lucky Star","Lightning Bug","Billy Brat","Black Top","BoxTop","Saturn","Bakerland","Secret Circle"};
    private final String[] SNAME2 = {"INC","Corporation","LTD","GmbH","Limited","Company","Incorporated","LLC","Zaibatsu","Chaebol",
                              "Conglamorate","Corp.","Systems","Solutions","S.A."};   
    private List<String> randName1 = new ArrayList<>();
    private final List<String> randName2 = new ArrayList<>();  
    private List<String> fundName1 = new ArrayList<>();
    private List<String> fundName2 = new ArrayList<>();
    private final List<String> fundName3 = new ArrayList<>();
    
    public HFMController(){
        TURN = 0;
        this.player = HFM.player;       
        pNAME = player.getName();
        pCASH = player.getCash();
        pSTOCKS = player.getStocks();
        STOCKS = new ArrayList<>();
        log = new Logon();
        AIs = new ArrayList<>();
        SNL = new ArrayList<>();
        SPL = new ArrayList<>();
        SVL = new ArrayList<>();
        SHL = new ArrayList<>();
        SLL = new ArrayList<>();
        PSN = new ArrayList<>();
        PSO = new ArrayList<>();
        FN = new ArrayList<>();
        FR = new ArrayList<>();
        FV = new ArrayList<>();
        stockBackD = new ArrayList<>();
        stockBackU = new ArrayList<>();
        stockBacks = new ArrayList<>();
        r = new Random();
        fundNames = new String[5];
        stockNames = new String[9];
        STOCKVOL = new int[9];
        fVALUE = new BigDecimal[5];
        initLists();
        initStocks();
        initAIs();
        volumeControl();  
        loadImg();        
    }
    
    private void initLists(){
        randName1.addAll(Arrays.asList(SNAME1));
        randName2.addAll(Arrays.asList(SNAME2));
        fundName1.addAll(Arrays.asList(FNAME1));
        fundName2.addAll(Arrays.asList(FNAME2));
        fundName3.addAll(Arrays.asList(FNAME3));
    }
    
    private void initAIs(){
        log.readAIs();
        if(AIs.isEmpty()){
            String n = "";
            int c = 0;       
            while(c < 5){
                    int s1 = r.nextInt(fundName1.size());
                    int s2 = r.nextInt(fundName2.size());
                    int s3 = r.nextInt(nameNum);
                    n += fundName1.get(s1) + " " + fundName2.get(s2) + " " + fundName3.get(s2);                
                    System.out.println("fundName1 size: " + fundName1.size());
                    for(int i = 0;i<5;i++){
                        if(n.equals(fundNames[i])) continue;
                    }
                    fundName1.remove(s1);
                    fundNames[c] = n;
                    c++;
                    n = "";

                }

            for(int i = 0;i<5;i++){
                AIs.add(new FundAI(fundNames[i]));
                System.out.println("AI Added: " + fundNames[i]);

            }
        } else System.out.println("Loading AIs from AISname.file");
    }
    
    private void initStocks(){
        log.readStocks();
        if(STOCKS.isEmpty()){
            String n = "";
            int c = 0;
            while(c < 9){
                int s1 = r.nextInt(randName1.size());
                int s2 = r.nextInt(randName2.size());
                n += randName1.get(s1) + " " + randName2.get(s2);                
                System.out.println("randName1 size: " + randName1.size());
                for(int i = 0;i<5;i++){
                    if(n.equals(stockNames[i])) continue;
                }
                randName1.remove(s1);
                stockNames[c] = n;
                c++;
                n = "";
            }
            for(int i = 0;i<9;i++){
                STOCKS.add(new Stock(stockNames[i]));
                System.out.println("Stock Added: " + stockNames[i]);
            }
        } else System.out.println("Loading stocks from STOCKname.file");                    
    }
    
    private void initArrays(){
        SNL.add(stock1name);       
        SNL.add(stock2name);
        SNL.add(stock3name);
        SNL.add(stock4name);
        SNL.add(stock5name);
        SNL.add(stock6name);
        SNL.add(stock7name);
        SNL.add(stock8name);
        SNL.add(stock9name);
       
        SPL.add(stock1price);       
        SPL.add(stock2price);
        SPL.add(stock3price);
        SPL.add(stock4price);
        SPL.add(stock5price);
        SPL.add(stock6price);
        SPL.add(stock7price);
        SPL.add(stock8price);
        SPL.add(stock9price);
        
        SVL.add(stock1volume);       
        SVL.add(stock2volume);
        SVL.add(stock3volume);
        SVL.add(stock4volume);
        SVL.add(stock5volume);
        SVL.add(stock6volume);
        SVL.add(stock7volume);
        SVL.add(stock8volume);
        SVL.add(stock9volume);
        
        SHL.add(stock1high);       
        SHL.add(stock2high);
        SHL.add(stock3high);
        SHL.add(stock4high);
        SHL.add(stock5high);
        SHL.add(stock6high);
        SHL.add(stock7high);
        SHL.add(stock8high);
        SHL.add(stock9high);
        
        SLL.add(stock1low);       
        SLL.add(stock2low);
        SLL.add(stock3low);
        SLL.add(stock4low);
        SLL.add(stock5low);
        SLL.add(stock6low);
        SLL.add(stock7low);
        SLL.add(stock8low);
        SLL.add(stock9low);
       
        PSN.add(playerStock1name);       
        PSN.add(playerStock2name);
        PSN.add(playerStock3name);
        PSN.add(playerStock4name);
        PSN.add(playerStock5name);
        PSN.add(playerStock6name);
        PSN.add(playerStock7name);
        PSN.add(playerStock8name);
        PSN.add(playerStock9name);
        
        PSO.add(playerStock1owned);       
        PSO.add(playerStock2owned);
        PSO.add(playerStock3owned);
        PSO.add(playerStock4owned);
        PSO.add(playerStock5owned);
        PSO.add(playerStock6owned);
        PSO.add(playerStock7owned);
        PSO.add(playerStock8owned);
        PSO.add(playerStock9owned);
        
        FN.add(fund1name);       
        FN.add(fund2name);
        FN.add(fund3name);
        FN.add(fund4name);
        FN.add(fund5name);
        
        FR.add(fund1rank); 
        FR.add(fund2rank);
        FR.add(fund3rank);
        FR.add(fund4rank);
        FR.add(fund5rank);
        
        FV.add(fund1value); 
        FV.add(fund2value);
        FV.add(fund3value);
        FV.add(fund4value);
        FV.add(fund5value);

    }    
    
    private void initLabels(){
        turnLabel.setText(Integer.toString(TURN));
        statusLabel.setText("Welcome to Hedge Fund Manager, " + player.getName());
        for(int i = 0;i < 9; i++){
            BigDecimal bd = BigDecimal.ZERO;
            Label snl = (Label) SNL.get(i);
            Label spl = (Label) SPL.get(i);
            Label svl = (Label) SVL.get(i);
            Label shl = (Label) SHL.get(i);
            Label sll = (Label) SLL.get(i);
            Label psn = (Label) PSN.get(i);
            Label pso = (Label) PSO.get(i);            
            Stock s = (Stock) STOCKS.get(i);            
            snl.setText(s.getStockName());
            bd = s.getStockValue();
            spl.setText(bd.toString());
            bd = s.getStockHigh();
            String str = bd.toString();
            shl.setText(str);
            bd = s.getStockLow();            
            str = bd.toString();
            sll.setText(str);
            svl.setText(Integer.toString(STOCKVOL[i])); 
            psn.setText(s.getStockName());
            pso.setText(Integer.toString(pSTOCKS[i]));           
        }
        for(int i = 0;i<5;i++){
            Label fn = (Label) FN.get(i);
            Label fr = (Label) FR.get(i);
            Label fv = (Label) FV.get(i);
            FundAI fai = (FundAI) AIs.get(i);
            fn.setText(fai.getFundName());
            fr.setText("$" + AIs.get(i).getFundCash().toString());
            fv.setText(fVALUE[i].toString());
        }
        playerFund.setText(pNAME + " Hedge Fund");
        playerRank.setText("AWESOME"); // CHANGE to real rank
        pEQUITY = pEQUITY.setScale(2, RoundingMode.CEILING);
        playerEquity.setText("$" + pEQUITY.toString());
        pCASH = pCASH.setScale(2, RoundingMode.CEILING);
        playerCash.setText(pCASH.toString());
    }
    
    private void updateLabels(){
//        System.out.println("~~~~~Updating Labels~~~~~");
        volumeControl();
        for(int i = 0;i<5;i++){
            fVALUE[i] = AIs.get(i).getValue();
            FR.get(i).setText("Fund Cash: $" + AIs.get(i).getFundCash().toString());
//            System.out.println("UL fVALUE: " + fVALUE[i].toString());
            FV.get(i).setText("Fund Value: $" + fVALUE[i].toString());
        }
    }
    
    private void loadImg(){
      
       DOWN = new Image(HFMController.class.getResourceAsStream("IMG/DOWN.png"));
       PAY = new Image(HFMController.class.getResourceAsStream("IMG/PAY.png"));
       HALT = new Image(HFMController.class.getResourceAsStream("IMG/HALT.png"));
       UP = new Image(HFMController.class.getResourceAsStream("IMG/UP.png"));
       SBD1 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackDown1.png"));
       bSBD1 = new BackgroundImage(SBD1,null,null,null,null);
       bgSBD1 = new Background(bSBD1);
       SBD2 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackDown2.png"));
       bSBD2 = new BackgroundImage(SBD2,null,null,null,null);
       bgSBD2 = new Background(bSBD2);
       SBD3 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackDown3.png"));
       bSBD3 = new BackgroundImage(SBD3,null,null,null,null);
       bgSBD3 = new Background(bSBD3);
       SBD4 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackDown4.png"));
       bSBD4 = new BackgroundImage(SBD4,null,null,null,null);
       bgSBD4 = new Background(bSBD4);
       SBD5 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackDown5.png"));
       bSBD5 = new BackgroundImage(SBD5,null,null,null,null);
       bgSBD5 = new Background(bSBD5);
       SBD6 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackDown6.png"));
       bSBD6 = new BackgroundImage(SBD6,null,null,null,null);
       bgSBD6 = new Background(bSBD6);
       SBD7 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackDown7.png"));
       bSBD7 = new BackgroundImage(SBD7,null,null,null,null);
       bgSBD7 = new Background(bSBD7);
       SBD8 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackDown8.png"));
       bSBD8 = new BackgroundImage(SBD8,null,null,null,null);
       bgSBD8 = new Background(bSBD8);
       SBD9 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackDown9.png"));
       bSBD9 = new BackgroundImage(SBD9,null,null,null,null);
       bgSBD9 = new Background(bSBD9);
       SBU1 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackUp1.png"));
       bSBU1 = new BackgroundImage(SBU1,null,null,null,null);
       bgSBU1 = new Background(bSBU1);
       SBU2 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackUp2.png"));
       bSBU2 = new BackgroundImage(SBU2,null,null,null,null);
       bgSBU2 = new Background(bSBU2);
       SBU3 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackUp3.png"));
       bSBU3 = new BackgroundImage(SBU3,null,null,null,null);
       bgSBU3 = new Background(bSBU3);
       SBU4 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackUp4.png"));
       bSBU4 = new BackgroundImage(SBU4,null,null,null,null);
       bgSBU4 = new Background(bSBU4);
       SBU5 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackUp5.png"));
       bSBU5 = new BackgroundImage(SBU5,null,null,null,null);
       bgSBU5 = new Background(bSBU5);
       SBU6 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackUp6.png"));
       bSBU6 = new BackgroundImage(SBU6,null,null,null,null);
       bgSBU6 = new Background(bSBU6);
       SBU7 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackUp7.png"));
       bSBU7 = new BackgroundImage(SBU7,null,null,null,null);
       bgSBU7 = new Background(bSBU7);
       SBU8 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackUp8.png"));    
       bSBU8 = new BackgroundImage(SBU8,null,null,null,null);
       bgSBU8 = new Background(bSBU8);
       SBU9 = new Image(HFMController.class.getResourceAsStream("IMG/stockBackUp9.png"));    
       bSBU9 = new BackgroundImage(SBU9,null,null,null,null);
       bgSBU9 = new Background(bSBU9);      
       
       SBH = new Image(HFMController.class.getResourceAsStream("IMG/stockBackHalt.png"));    
       bSBH = new BackgroundImage(SBH,null,null,null,null);
       bgSBH = new Background(bSBH); 
       SBN = new Image(HFMController.class.getResourceAsStream("IMG/stockBackNew.png"));    
       bSBN = new BackgroundImage(SBN,null,null,null,null);
       bgSBN = new Background(bSBN); 
       
       SBS = new Image(HFMController.class.getResourceAsStream("IMG/stockBackSplit.png"));    
       bSBS = new BackgroundImage(SBS,null,null,null,null);
       bgSBS = new Background(bSBS);
       
       // Fund Ai Backgrouds: try to make the Image > BGImage > BG into one line
    }
    
    @FXML void executeButtonAction(ActionEvent event) {
        statusLabel.setText("");
        if(actionPicker.getSelectionModel().getSelectedIndex() == -1){
            statusLabel.setText("You must pick an action!");
                return;
        }
        if(stockPicker.getSelectionModel().getSelectedIndex() == -1){
            statusLabel.setText("You must pick a stock!");
                return;
        }
        
        if(actionPicker.getSelectionModel().getSelectedIndex() == 0){
            int i = stockPicker.getSelectionModel().getSelectedIndex();           
            if(STOCKS.get(i).isHalt(TURN)){
                statusLabel.setText(STOCKS.get(i).getStockName() + " is under a trading halt! Cannot buy or sell shares.");
                return;
            }
            BigDecimal p = STOCKS.get(i).getStockValue().multiply(new BigDecimal(100));
            System.out.println("p cost: " + p.toString());
            if(pCASH.compareTo(p) == -1){
                statusLabel.setText("Insufficient Funds!");
                return;
            } else {
                pSTOCKS[i] += 100;
                pCASH = pCASH.subtract(p);
                playerEquity.setText("$" + pEQUITY.toString());               
                playerCash.setText("$" + pCASH.toString());
                PSO.get(i).setText(Integer.toString(pSTOCKS[i])); 
                statusLabel.setText("PURCHASE: 100 shares of " + stockNames[i]);
                
                //SVL.get(die1).setText(Integer.toString(STOCKVOL[die1]));
            }                        
        } else { // SELL
            int i = stockPicker.getSelectionModel().getSelectedIndex();
            if(pSTOCKS[i] == 0){
                statusLabel.setText("You do not own any shares of " + stockNames[i]);
                return;
            }
            if(STOCKS.get(i).isHalt(TURN)){
                statusLabel.setText(STOCKS.get(i).getStockName() + " is under a trading halt! Cannot buy or sell shares.");
                return;
            }
            BigDecimal p = STOCKS.get(i).getStockValue().multiply(new BigDecimal(100));
            pSTOCKS[i] -= 100;
            pCASH = pCASH.add(p);
            playerEquity.setText("$" + pEQUITY.toString());               
            playerCash.setText("$" + pCASH.toString());
            PSO.get(i).setText(Integer.toString(pSTOCKS[i]));
            statusLabel.setText("SOLD: 100 shares of " + stockNames[i]);
            
            //SVL.get(die1).setText(Integer.toString(STOCKVOL[die1]));
        }
        volumeControl();
        playerEquity.setText("$" + pEQUITY.toString());
        SVL.get(stockPicker.getSelectionModel().getSelectedIndex()).setText(Integer.toString(STOCKVOL[stockPicker.getSelectionModel().getSelectedIndex()]));
        
       
    }

    @FXML void goButtonAction(ActionEvent event) {
        die1 = r.nextInt(9); // Stocks
        die2 = r.nextInt(100); // Action
        die3 = r.nextInt(10)+1; // Base Amount 0.10 - 1.00

        // Set stock stockBackU neutral
        backUpdate();
        
        BigDecimal delta = new BigDecimal(die3).movePointLeft(1);
        delta = delta.setScale(2, RoundingMode.CEILING);
               
        int selector = 0;
        if(die2 < 3) selector = 0;                  // Abysmal
        if(die2 > 3 && die2 < 10) selector = 1;     // Bad
        if(die2 > 9 && die2 < 35) selector = 2;     // Negative
        if(die2 > 34 && die2 < 40) selector = 3;    // Low Div
        if(die2 > 39 && die2 < 50) selector = 4;    // DIV
        if(die2 > 49 && die2 < 52) selector = 5;    // HALT
        if(die2 > 51 && die2 < 62) selector = 6;    // DIV
        if(die2 > 61 && die2 < 67) selector = 7;    // High Div
        if(die2 > 66 && die2 < 90) selector = 8;    // Positive
        if(die2 > 89 && die2 < 97) selector = 9;    // Good
        if(die2 > 96) selector = 10;                // Awesome
        
        switch(selector){
            case 0: // Abysmal
                actionDie.setImage(DOWN);
                stockBacks.get(die1).setBackground(stockBackD.get(die1));
                if(STOCKS.get(die1).getStockValue().compareTo(new BigDecimal(2)) == -1){
                    stockFold(die1);
                    break;
                }
                if(STOCKS.get(die1).getStockValue().compareTo(delta.multiply(new BigDecimal(5))) == 1){
                    delta = delta.multiply(new BigDecimal(5));                   
                } else {
                    delta = delta.divide(new BigDecimal(2));
                }
                statusLabel.setText("DISASTER! Board of " + stockNames[die1] + " convicted of cooking the books! Stock values plunge $" + delta.toString() + " per share!");
                STOCKS.get(die1).setStockValue(STOCKS.get(die1).getStockValue().subtract(delta));
                SPL.get(die1).setText("$" + STOCKS.get(die1).getStockValue().toString());
                if(STOCKS.get(die1).getStockLow().compareTo(STOCKS.get(die1).getStockValue()) == 1){
                    STOCKS.get(die1).setStockLow(STOCKS.get(die1).getStockValue());
                    SLL.get(die1).setText(STOCKS.get(die1).getStockValue().toString());
                }
                break;
            case 1: // Bad
                actionDie.setImage(DOWN);                               
                if(STOCKS.get(die1).isHalt(TURN)){
                    statusLabel.setText(stockNames[die1] + " price frozen due to Trading Halt!");
                    return;
                }
                stockBacks.get(die1).setBackground(stockBackD.get(die1));
                delta = delta.multiply(new BigDecimal(2));
                if(STOCKS.get(die1).getStockValue().compareTo(delta) == -1){
                    stockFold(die1);
                    break;
                }
                statusLabel.setText("Earnings miss! Analysts pessimistic. " + stockNames[die1] + " price drops $" + delta.toString() + " per share!");                
                STOCKS.get(die1).setStockValue(STOCKS.get(die1).getStockValue().subtract(delta));
                SPL.get(die1).setText("$" + STOCKS.get(die1).getStockValue().toString());
                if(STOCKS.get(die1).getStockLow().compareTo(STOCKS.get(die1).getStockValue()) == 1){
                    STOCKS.get(die1).setStockLow(STOCKS.get(die1).getStockValue());
                    SLL.get(die1).setText(STOCKS.get(die1).getStockValue().toString());
                }
                break;
            case 2: // Negative
                actionDie.setImage(DOWN);                
                if(STOCKS.get(die1).isHalt(TURN)){
                    statusLabel.setText(stockNames[die1] + " price frozen due to Trading Halt!");
                    return;
                }
                if(STOCKS.get(die1).getStockValue().compareTo(delta) == -1){
                    stockFold(die1);
                    break;
                }
                stockBacks.get(die1).setBackground(stockBackD.get(die1));
                statusLabel.setText(stockNames[die1] + " price drops $" + delta.toString() + " per share!");                
                STOCKS.get(die1).setStockValue(STOCKS.get(die1).getStockValue().subtract(delta));
                SPL.get(die1).setText("$" + STOCKS.get(die1).getStockValue().toString());
                if(STOCKS.get(die1).getStockLow().compareTo(STOCKS.get(die1).getStockValue()) == 1){
                    STOCKS.get(die1).setStockLow(STOCKS.get(die1).getStockValue());
                    SLL.get(die1).setText(STOCKS.get(die1).getStockValue().toString());
                }
                break;
            case 3: // Low DIV
                actionDie.setImage(PAY);
                if(STOCKS.get(die1).isHalt(TURN)){
                    statusLabel.setText(stockNames[die1] + " cannot distribute capital during Trading Halt!");
                    return;
                }
                delta.divide(new BigDecimal(2));
                statusLabel.setText("Due to structural weaknesses, dividends are slashed. " + stockNames[die1] + " only pays $" + delta.toString() + " per share!");
                BigDecimal lbd = new BigDecimal(pSTOCKS[die1]).multiply(delta);
                pCASH = pCASH.add(lbd);
                playerCash.setText("$" + pCASH.toString());
                for(int i = 0;i<5;i++){
                    int[] fs = AIs.get(i).getFundStocks();
                    lbd = new BigDecimal(fs[die1]).multiply(delta);
                    AIs.get(i).divFund(lbd);
                    System.out.println("Paying " + AIs.get(i).getFundName() + " dividends of: " + lbd);
                }
                break;
            case 4: // DIV
                actionDie.setImage(PAY);
                if(STOCKS.get(die1).isHalt(TURN)){
                    statusLabel.setText(stockNames[die1] + " cannot distribute capital during Trading Halt!");
                    return;
                }
                statusLabel.setText("Distribution! " + stockNames[die1] + " pays $" + delta.toString() + " per share!");
                BigDecimal dbd = new BigDecimal(pSTOCKS[die1]).multiply(delta);
                pCASH = pCASH.add(dbd);
                playerCash.setText("$" + pCASH.toString());
                for(int i = 0;i<5;i++){
                    int[] fs = AIs.get(i).getFundStocks();
                    lbd = new BigDecimal(fs[die1]).multiply(delta);
                    AIs.get(i).divFund(lbd);
                    System.out.println("Paying " + AIs.get(i).getFundName() + " dividends of: " + lbd);
                }
                break;
            case 5: // HALT
                actionDie.setImage(HALT);
                stockBacks.get(die1).setBackground(bgSBH);
                int h = TURN + 11;
                statusLabel.setText("Hold! " + stockNames[die1] + " under investigation for price fixing. Trading Halt called until turn " + h + "!");
                STOCKS.get(die1).setHalt(true, h);
                break;
            case 6: // DIV
                actionDie.setImage(PAY);
                if(STOCKS.get(die1).isHalt(TURN)){
                    statusLabel.setText(stockNames[die1] + " cannot distribute capital during Trading Halt!");
                    return;
                }
                statusLabel.setText("Distribution! " + stockNames[die1] + " pays $" + delta.toString() + " per share!");
                BigDecimal bd = new BigDecimal(pSTOCKS[die1]).multiply(delta);
                pCASH = pCASH.add(bd);
                playerCash.setText("$" + pCASH.toString());
                for(int i = 0;i<5;i++){
                    int[] fs = AIs.get(i).getFundStocks();
                    lbd = new BigDecimal(fs[die1]).multiply(delta);
                    AIs.get(i).divFund(lbd);
                    System.out.println("Paying " + AIs.get(i).getFundName() + " dividends of: " + lbd);
                }
                break;
            case 7: // High DIV
                actionDie.setImage(PAY);
                if(STOCKS.get(die1).isHalt(TURN)){
                    statusLabel.setText(stockNames[die1] + " cannot distribute capital during Trading Halt!");
                    return;
                }
                delta = delta.multiply(new BigDecimal(2));
                statusLabel.setText("Bonanza! " + stockNames[die1] + " beats earnings estimates by 10%! Disbursement of $" + delta.toString() + " per share!");
                BigDecimal hbd = new BigDecimal(pSTOCKS[die1]).multiply(delta);
                pCASH = pCASH.add(hbd);
                playerCash.setText("$" + pCASH.toString());
                for(int i = 0;i<5;i++){
                    int[] fs = AIs.get(i).getFundStocks();
                    lbd = new BigDecimal(fs[die1]).multiply(delta);
                    AIs.get(i).divFund(lbd);
                    System.out.println("Paying " + AIs.get(i).getFundName() + " dividends of: " + lbd);
                }
                break;
            case 8: // Positive
                actionDie.setImage(UP);
                if(STOCKS.get(die1).isHalt(TURN)){
                    statusLabel.setText(stockNames[die1] + " price frozen due to Trading Halt!");
                    return;
                }
                if(STOCKS.get(die1).getStockValue().compareTo(new BigDecimal(18)) == 1){
                    stockSplit(die1);
                    break;
                }
                stockBacks.get(die1).setBackground(stockBackU.get(die1));                
                statusLabel.setText(stockNames[die1] + " price rises $" + delta.toString() + " per share!");
                STOCKS.get(die1).setStockValue(STOCKS.get(die1).getStockValue().add(delta));
                SPL.get(die1).setText("$" + STOCKS.get(die1).getStockValue().toString());
                if(STOCKS.get(die1).getStockHigh().compareTo(STOCKS.get(die1).getStockValue()) == 1) STOCKS.get(die1).setStockHigh(STOCKS.get(die1).getStockValue());
                SHL.get(die1).setText(STOCKS.get(die1).getStockValue().toString());
                break;               
            case 9: // GOOD
                actionDie.setImage(UP);
                if(STOCKS.get(die1).isHalt(TURN)){
                    statusLabel.setText(stockNames[die1] + " price frozen due to Trading Halt!");
                    return;
                }
                if(STOCKS.get(die1).getStockValue().compareTo(new BigDecimal(18)) == 1){
                    stockSplit(die1);
                    break;
                }
                stockBacks.get(die1).setBackground(stockBackU.get(die1));                
                delta = delta.multiply(new BigDecimal(2));
                statusLabel.setText("Tech Breakthrough! " + stockNames[die1] + " price rockets $" + delta.toString() + " per share!");
                STOCKS.get(die1).setStockValue(STOCKS.get(die1).getStockValue().add(delta));
                SPL.get(die1).setText("$" + STOCKS.get(die1).getStockValue().toString());
                if(STOCKS.get(die1).getStockHigh().compareTo(STOCKS.get(die1).getStockValue()) == 1) STOCKS.get(die1).setStockHigh(STOCKS.get(die1).getStockValue());
                SHL.get(die1).setText(STOCKS.get(die1).getStockValue().toString());
                
                break;
            case 10: // AWESOME
                actionDie.setImage(UP);
                if(STOCKS.get(die1).getStockValue().compareTo(new BigDecimal(18)) == 1){
                    stockSplit(die1);
                    break;
                }
                stockBacks.get(die1).setBackground(stockBackU.get(die1));
                if(STOCKS.get(die1).getStockValue().add(delta.multiply(new BigDecimal(5))).compareTo(new BigDecimal(20)) == -1){
                    delta = delta.multiply(new BigDecimal(5));
                } else {
                     if(STOCKS.get(die1).getStockValue().compareTo(new BigDecimal(5)) == -1)
                    delta = STOCKS.get(die1).getStockValue().multiply(new BigDecimal(2));
                }
                statusLabel.setText("Merger! Buyout rumours pump " + stockNames[die1] + " share price! Units up $" + delta.toString() + " per share !");
                STOCKS.get(die1).setStockValue(STOCKS.get(die1).getStockValue().add(delta));
                SPL.get(die1).setText("$" + STOCKS.get(die1).getStockValue().toString());
                if(STOCKS.get(die1).getStockHigh().compareTo(STOCKS.get(die1).getStockValue()) == 1) STOCKS.get(die1).setStockHigh(STOCKS.get(die1).getStockValue());
                SHL.get(die1).setText(STOCKS.get(die1).getStockValue().toString());
                break;
        }
        
        // AI Turns
        for(int i = 0;i< AIs.size();i++){
//            statusLabel.setText("AI Turn: " + AIs.get(i).getFundName());
            AIs.get(i).aiTurn();
            updateLabels();
        }
        
        volumeControl();        
        playerEquity.setText("$" + pEQUITY.toString());
        TURN++;
        turnLabel.setText(Integer.toString(TURN));
    }

    private void stockFold(int s){
        String temp = STOCKS.get(s).getStockName();
        System.out.println("~~~~~ STOCK FOLD ~~~~~" + temp);
        statusLabel.setText(temp + " has gone out of business and is off the market!");
        STOCKS.remove(s);
        pSTOCKS[s] = 0;
        for(int i = 0;i < AIs.size();i++){
            int[] x = AIs.get(i).getFundStocks();
            x[s] = 0;
            AIs.get(i).setFundStocks(x);
        }
        boolean unique = false;
        String n = "";
        while(unique == false){
            System.out.println("while loop");
            n = "";
            n += randName1.get(r.nextInt(randName1.size())) + " " + SNAME2[r.nextInt(nameNum)];
            for(int i = 0;i<STOCKS.size();i++){
                if(!STOCKS.get(i).getStockName().equals(n)){
                    System.out.println("New stock name: " + n);
                    unique = true;
                    break;
                }
            }           
        }
        Stock newStock = new Stock(n);
        stockNames[s] = n;
        STOCKS.add(s, newStock);
        initLabels();
        stockPicker.getItems().remove(s);
        stockPicker.getItems().add(s, n);
        statusLabel.setText("With " + temp + " folding, " + STOCKS.get(s).getStockName() + " has been added to the market!");
        stockBacks.get(die1).setBackground(bgSBN);
    }
    
    private void stockSplit(int s){
        System.out.println("~~~~~ STOCK SPLIT ~~~~~" + STOCKS.get(s).getStockName());
        statusLabel.setText(STOCKS.get(s).getStockName() + " has split! All shares doubled!");
        for(int i = 0;i < AIs.size();i++){
            int[] x = AIs.get(i).getFundStocks();
            x[s] += x[s];
            AIs.get(i).setFundStocks(x);
        }
        pSTOCKS[s] += pSTOCKS[s];
        stockBacks.get(s).setBackground(bgSBS);
        PSO.get(s).setText(Integer.toString(pSTOCKS[s]));
        BigDecimal delta = BigDecimal.ZERO;        
        delta = STOCKS.get(die1).getStockValue().divide(new BigDecimal(2));
        delta = delta.setScale(2, RoundingMode.CEILING);
        STOCKS.get(die1).setStockValue(delta);
        SPL.get(die1).setText("$" + STOCKS.get(die1).getStockValue().toString());
    }
    
    private void backUpdate(){
        for(int i = 0;i < STOCKS.size();i++){
            if(STOCKS.get(i).isHalt(TURN)) stockBacks.get(i).setBackground(bgSBH);
            else stockBacks.get(i).setBackground(Background.EMPTY);
        }
    }
    
    @FXML void quitButtonAction(ActionEvent event) { 
        log.updateBank();
        log.writeFund();
        log.writeStocks(STOCKS);
        log.writeAIs(AIs);
        System.out.println("New bank record: " + pCASH);
        System.exit(0);
    }

    private void volumeControl(){
        pEQUITY = BigDecimal.ZERO;
        pEQUITY = pEQUITY.setScale(2, RoundingMode.CEILING);
        for(int i = 0;i < 9;i++){
            STOCKVOL[i] = 0;
            STOCKVOL[i] += pSTOCKS[i];           
            pEQUITY = pEQUITY.add(STOCKS.get(i).getStockValue().multiply(new BigDecimal(pSTOCKS[i])));
        }
        for(int f = 0;f < 5;f++){
            FundAI fai = (FundAI) AIs.get(0);
            int[] a1 = fai.getFundStocks();
            fVALUE[f] = fai.getValue();
            for(int i = 0;i < 9;i++){
                STOCKVOL[i] += a1[i];
            }
        }
    }
    
    private void initBacks(){
        stockBacks.add(stockPane1);
        stockBacks.add(stockPane2);
        stockBacks.add(stockPane3);
        stockBacks.add(stockPane4);
        stockBacks.add(stockPane5);
        stockBacks.add(stockPane6);
        stockBacks.add(stockPane7);
        stockBacks.add(stockPane8);
        stockBacks.add(stockPane9);
        stockBackD.add(bgSBD1);
        stockBackD.add(bgSBD2);
        stockBackD.add(bgSBD3);
        stockBackD.add(bgSBD4);
        stockBackD.add(bgSBD5);
        stockBackD.add(bgSBD6);
        stockBackD.add(bgSBD7);
        stockBackD.add(bgSBD8);
        stockBackD.add(bgSBD9);
        stockBackU.add(bgSBU1);
        stockBackU.add(bgSBU2);
        stockBackU.add(bgSBU3);
        stockBackU.add(bgSBU4);
        stockBackU.add(bgSBU5);
        stockBackU.add(bgSBU6);
        stockBackU.add(bgSBU7);
        stockBackU.add(bgSBU8);
        stockBackU.add(bgSBU9);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stockDie.setOpacity(1);
        actionDie.setOpacity(1);
        amountDie.setOpacity(1);
        initArrays();
        initLabels();
        playerEquity.setText("$" + pEQUITY.toString());
        stockPicker.getItems().addAll(stockNames);
        actionPicker.setItems(FXCollections.observableArrayList("Buy", "Sell"));    
        initBacks();
        updateLabels();
    }
}
