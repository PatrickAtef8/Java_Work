package com.mycompany.myregisterapp;

import com.mycompany.myregisterapp.deb.DAO;
import com.mycompany.myregisterapp.deb.UserDTO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PrimaryController {

    @FXML
    private TextArea txtarea;
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

    @FXML
    private void register() {
       
        try {
           int result =  DAO.register(new UserDTO(usrnametext.getText(), passwdtext.getText()));
             if (result > 0) {
            showAlertRegister(Alert.AlertType.INFORMATION, "Register Successful", "Welcome");
        } else {
            showAlertRegister(Alert.AlertType.ERROR, "Register Failed", "Try again.");
        }
        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      
    }

    @FXML
    private void login() {
        boolean success = DAO.login(new UserDTO(usrnametext.getText(), passwdtext.getText()));
        if (success) {
            showAlertLogin(Alert.AlertType.INFORMATION, "Login Successful", "Welcome");
        } else {
            showAlertLogin(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }
    }

    private void showAlertLogin(Alert.AlertType alertType, String title, String message) {
        Alert alertlogin = new Alert(alertType);
        alertlogin.setTitle(title);
        alertlogin.setHeaderText(null);
        alertlogin.setContentText(message);
        alertlogin.showAndWait();
    }
    
    
      private void showAlertRegister(Alert.AlertType alertType, String title, String message) {
        Alert alertregister = new Alert(alertType);
        alertregister.setTitle(title);
        alertregister.setHeaderText(null);
        alertregister.setContentText(message);
        alertregister.showAndWait();
    }
}


















//package com.mycompany.myregisterapp;
//
//import com.mycompany.myregisterapp.deb.DAO;
//import com.mycompany.myregisterapp.deb.UserDTO;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.text.Text;
//
//public class PrimaryController {
//
//    @FXML
//    private TextArea txtarea;
//    @FXML
//    private Text usrname;
//    @FXML
//    private TextField usrnametext;
//    @FXML
//    private Text passwd;
//    @FXML
//    private TextField passwdtext;
//    @FXML
//    private Button regbtn;
//    @FXML
//    private Button loginbtn;
//    
//    
//    @FXML
//    private void register(){
//        
//            try {
//           int result=  DAO.register(new UserDTO(usrnametext.getText(), passwdtext.getText()));
//        } catch (SQLException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    @FXML
//    private void login(){
//        
//    }
//
//}
//
//
