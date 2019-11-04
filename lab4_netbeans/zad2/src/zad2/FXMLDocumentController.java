/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Pogoda
 */
public class FXMLDocumentController implements Initializable {
    
    ScatterChart<Number, Number> myChart = Zad2.createChart();
    
    @FXML
    private Label label;
    
    @FXML
    private GridPane grid;
    
    @FXML
    private TextField valueA;
    
    @FXML
    private TextField valueB;
    
    @FXML
    private TextField valueC;
    
    @FXML
    private ComboBox<String> combo;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    @FXML
    private void comboShow(ActionEvent event){
        
        if(combo.getValue().equals("f(x)=0")){
            Zad2.addChart(myChart, 0, 0, 0);
        }
        else if(combo.getValue().equals("f(x)=-x^2")){
            Zad2.addChart(myChart, -1,0, 0);
        }
        else if(combo.getValue().equals("f(x)=x^2-x+3")){
            Zad2.addChart(myChart, 1, -1, 3);
        }
        
    }
    
    @FXML
    private void showChart(ActionEvent event) {
       Zad2.addChart(myChart, Double.valueOf(valueA.getText()), Double.valueOf(valueB.getText()), Double.valueOf(valueC.getText()));
        
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        grid.add(myChart, 0, 0);
        
    }  
    
}
