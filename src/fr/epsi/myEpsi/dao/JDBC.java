package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	
	// JDBC - Java DataBase Connectivity 
	
	Connection connection;
    
	// Initialisation de la connection � faux
    Boolean isConnected = false;
    
    public JDBC() {

        try {
            Class.forName("org.hsqldb.jdbcDriver");
            // Le jdbcDriver permet la connexion avec une base de donn�es 
            
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:8080");
            // url permettant l'affichage d'un message 
            
            isConnected = true;
            // Connexion �tablie
            
        } catch (ClassNotFoundException | SQLException e) {
            
            e.printStackTrace();
        } 
        
    }
    
    
    public Connection getConnection() throws Exception{
    	
    	// Initialisation de connect � NULL
    	Connection connect = null;
    	
    	if(isConnected){
    		connect = this.connection;
    		// La connexion est �tablie
    	}
    	else{
    		throw new Exception("La connexion a �chou�.");
    		// Sinon, affichage d'un message indiquant que la connexion a �chou�
    	}
    	
    	return connect;
    }
    
    public ResultSet sqlRequete(String request) throws SQLException{
    	
    	// Initialisation de result � NULL
        ResultSet result = null;
        
        // Si connect�
        if(isConnected){
        	
        	// Initialisation d'un relev�
            Statement st = connection.createStatement();
            
            // Lancement de la requ�te
            result = st.executeQuery(request);
        }
        return result;
    }
}


