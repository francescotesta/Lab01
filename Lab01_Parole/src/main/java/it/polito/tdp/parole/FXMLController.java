/**
 * Sample Skeleton for 'SceneLab01.fxml' Controller Class
 */

package it.polito.tdp.parole;


import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.parole.model.Parole;
import it.polito.tdp.parole.model.Parole2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole parole  = new Parole();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancella"
    private Button btnCancella; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtPerformance"
    private TextArea txtPerformance; // Value injected by FXMLLoader

    @FXML
    void doCancella(ActionEvent event) {

    	double start = System.nanoTime();
    	
    	String sel = txtResult.getSelectedText();
    	parole.eliminaParola(sel);
    	
    	double finish = System.nanoTime();
    	
    	txtResult.clear();
    	LinkedList<String> p = new LinkedList<String>(parole.getElenco());
    	for(String s:p) {
    		txtResult.appendText(s+"\n");
    	}
    	
    	txtPerformance.appendText("Performance cancellazione parola: "+(finish-start) +"nanosecondi \n");
    }

    @FXML
    void doInsert(ActionEvent event) {
    	
    	double start = System.nanoTime();
    	
    	String par = txtParola.getText();
    	parole.addParola(par);
    	
    	double finish = System.nanoTime();
    	//txtResult.setText(null);
    	txtResult.clear();
    	txtParola.clear();
    	LinkedList<String> p = new LinkedList<String>(parole.getElenco());
    	for(String s:p) {
    		txtResult.appendText(s+"\n");
    	}
    	
    	
    	txtPerformance.appendText("Performance inserimento parola: "+(finish-start) +"nanosecondi \n");
    }

    @FXML
    void doReset(ActionEvent event) {

    	double start = System.nanoTime();

    	
    	parole.reset();
    	txtResult.clear();
    	txtParola.clear();
    	
    	double finish = System.nanoTime();
    	txtPerformance.appendText("Performance reset: "+(finish-start) +"nanosecondi \n");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'SceneLab01.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'SceneLab01.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SceneLab01.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'SceneLab01.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SceneLab01.fxml'.";
        assert txtPerformance != null : "fx:id=\"txtPerformance\" was not injected: check your FXML file 'SceneLab01.fxml'.";
        
    }
}
