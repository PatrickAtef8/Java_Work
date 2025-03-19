/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.register;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author patrick
 */
public class PrimaryController implements Initializable {

    @FXML
    private BorderPane txtarea;
    @FXML
    private Text usrname;
    @FXML
    private TextField usrnametext;
    @FXML
    private Text passwd;
    @FXML
    private TextField passwdtext;
    @FXML
    private Button regbtn;
    @FXML
    private Button loginbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
