package hfm;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class HFMController implements Initializable{

    @FXML private TableView<?> stats;
    
    @FXML private AnchorPane AI1;
    @FXML private AnchorPane AI2;
    @FXML private AnchorPane AI3;
    @FXML private AnchorPane AI4;
    @FXML private AnchorPane AI5;

    @FXML private ImageView fund1img;
    @FXML private ImageView fund2img;
    @FXML private ImageView fund3img;
    @FXML private ImageView fund4img;
    @FXML private ImageView fund5img;
    @FXML private ImageView die1;
    @FXML private ImageView die2;
    @FXML private ImageView die3;
    
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
 
    @FXML private ChoiceBox<?> stockPicker;
    @FXML private ChoiceBox<?> actionPicker;
    
    @FXML private Button catsButton;
    @FXML private Button executeButton;
    @FXML private Button goButton;
    @FXML private Button quitButton;
    
    // Logon Info
    static String pNAME;
    static int pCASH;
    static int[] pSTOCKS;
    static boolean acc;
    Logon log;
    Fund player;
   
    // AI Directives
    ArrayList<FundAI> AIs;
    BigDecimal[] fVALUE;
    
    
    // Initialization
    static int TURN, pEQUITY;
    static int[] STOCKVOL, RANKS;
    private final int nameNum = 14;
    public static ArrayList<Stock> STOCKS; //stock1, stock2, stock3, stock4, stock5, stock6, stock7, stock8, stock9;
    public ArrayList<Label> SNL, SPL, SVL, SHL, SLL, PSN, PSO, FN, FR, FV;
    private String[] fundNames;
    private String[] stockNames;
    private String[] FNAME1 = {"Black","Red","Golden","Silver","First","Premier","Apex","Provincial","Countrywide","Global",
                              "Aspirational","Crystal","National","Interdimensional","Universal"};
    private String[] FNAME2 = {"Squid","Rock","Tree","Horizon","Investors","Capital","Moneybags","Snatchem","Lupine","Porkbelly",
                              "Wealth","Accretion","Delta","Omega","Alpha Seeking"};
    private String[] FNAME3 = {"Trust","Partners","Associates","Holdings","Group","Capital","Securities","Markets","Incorporated","Funds",
                              "Fund","Capital Group","Management","Equity Holdings","Advisors"};
    
    private String[] SNAME1 = {"Platypus","Viceroy","Tachyon","Pestilence","Bugbear","Clearcut","Windy Field","The Happy Pinecone","FDMR","Birdhouses",
                              "The Golden Snakeskin","Onyx","Presidio","Ubiquitous","Pyramid"};
    private String[] SNAME2 = {"INC","Corporation","LTD","GmbH","Limited","Company","Incorporated","LLC","Zaibatsu","Chaebol",
                              "Conglamorate","Corp.","Systems","Solutions","S.A."};
    
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
        fundNames = new String[5];
        stockNames = new String[9];
        STOCKVOL = new int[9];
        fVALUE = new BigDecimal[5];
        initAIs();
        initStocks();
        volumeControl();        
    }
    
    private void initAIs(){
        String n = "";
        Random r = new Random();
        int c = 0;       
        while(c < 5){
            n += FNAME1[r.nextInt(nameNum)] + " " + FNAME2[r.nextInt(nameNum)] + " " + FNAME3[r.nextInt(nameNum)];
            for(int i = 0;i<5;i++){
                if(n.equals(fundNames[i])) continue;
            }
            fundNames[c] = n;
            c++;
            n = "";
        }        
        for(int i = 0;i<5;i++){
            AIs.add(new FundAI(fundNames[i]));
            System.out.println("AI Added: " + fundNames[i]);
        }
    }
    
    private void initStocks(){
        log.readStocks();
        if(STOCKS.isEmpty()){
            String n = "";
            Random r = new Random();
            int c = 0;
            while(c < 9){
                n += SNAME1[r.nextInt(nameNum)] + " " + SNAME2[r.nextInt(nameNum)];
                    for(int i = 0;i<5;i++){
                    if(n.equals(stockNames[i])) continue;
                }
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
    
    private void setLabels(){
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
            //String str = bd.toString();
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
            fr.setText(Integer.toString(999));
            fv.setText(fVALUE[i].toString());
        }
        playerFund.setText(pNAME + " Hedge Fund");
        playerRank.setText("AWESOME");
        playerEquity.setText(Integer.toString(pEQUITY));
        playerCash.setText(Integer.toString(pCASH));
    }
    
    private void loadImg(){
       // ONE     = new Image(FXMLCrapsController.class.getResourceAsStream("1.png"));
    }
    
    @FXML void executeButtonAction(ActionEvent event) {

    }

    @FXML void goButtonAction(ActionEvent event) {

    }

    @FXML void quitButtonAction(ActionEvent event) {                    
        log.updateBank();
        log.writeFund();
        log.writeStocks(STOCKS);
        System.out.println("New bank record: " + pCASH);
        System.exit(0);
    }

    private void volumeControl(){
        pEQUITY = 0;
        for(int i = 0;i < 9;i++){
            STOCKVOL[i] = 0;
            STOCKVOL[i] += pSTOCKS[i];           
            pEQUITY += pSTOCKS[i];
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initArrays();
        setLabels();
    }
}
