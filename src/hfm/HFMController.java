package hfm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class HFMController {

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
    @FXML private Label statuslabel;
      
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
    static String NAME;
    static int CASH;
    static int[] STOCKS;
    static boolean acc;
    Logon log;
    Fund player;
    @FXML private AnchorPane gamePane;
    @FXML private Pane splashPane;
    
    public HFMController(){
        log = new Logon();
        
    }
    
    private void loadImg(){
       // ONE     = new Image(FXMLCrapsController.class.getResourceAsStream("1.png"));
    }
    
    @FXML void loginButtonAction(ActionEvent event) {        
/*        splashPane.setDisable(true);
        catsButton.setDisable(true);
        splashPane.setVisible(false);
        catsButton.setVisible(false);
        gamePane.setVisible(true);
        gamePane.setPrefSize(1200, 800);
*/       
        
    }
    
    @FXML void executeButtonAction(ActionEvent event) {

    }

    @FXML void goButtonAction(ActionEvent event) {

    }

    @FXML void quitButtonAction(ActionEvent event) {

    }

}
