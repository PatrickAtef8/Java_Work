package com.mycompany.myregisterapp.deb;

import java.sql.Connection;
import org.apache.derby.jdbc.ClientDriver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
    
    public static int register(UserDTO user) throws SQLException {
        int result = -1;
        DriverManager.registerDriver(new ClientDriver());
        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/register", "root", "root");
             PreparedStatement statement = connection.prepareStatement("INSERT INTO UserTable VALUES (?, ?)") ) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            result = statement.executeUpdate();
        }
        return result;
    }
    
    public static boolean login(UserDTO user) {
        boolean result = false;
        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/register", "root", "root");
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM UserTable WHERE username = ? AND password = ?") ) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            ResultSet rs = statement.executeQuery();
            result = rs.next(); 
             statement.close();
            connection.close();
        } catch (SQLException e) {
        }
        return result;
    }
}












///
///
///
///
///
//////*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.myregisterapp.deb;
//import java.sql.Connection;
//import org.apache.derby.jdbc.ClientDriver;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
///**
// *
// * @author patrick
// */
//public class DAO {
//    
//    
//    public static int register(UserDTO user) throws SQLException{
//        
//        int result = -1;
//        DriverManager.registerDriver(new ClientDriver());
//        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/register","root","root"); 
//                PreparedStatement statement = connection.prepareStatement("Insert into UserTable values (?,?)")) {
//            statement.setString(1,user.getUsername());
//            statement.setString(2,user.getPassword());
//            result = statement.executeUpdate();
//        }
//        
//                
//        return result;
//        
//}
//    
//public static boolean login(UserDTO user){
//    
//        boolean result = false;
//        return result;
//    
//
//}
//
//}
//
