/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.InputStream;
import java.sql.*;
 import java.util.Date;


/**
 *
 * @author salman
 */
public class Actor {
          String URL="jdbc:mysql://localhost:3306/test";
            String USERNAME="root";
            String PASSWORD="123456";

            Connection connection = null;
            PreparedStatement insertJobs=null;
        PreparedStatement Login=null;
     ResultSet resultSet=null;
    
     
     public Actor()
            {
                try{
                    
                    connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                    insertJobs = connection.prepareStatement("Insert into postjob (`EligibleProfession`,`JobDescription`,`Date`)"
                    +"VALUES(?,?,?)");
                  
                }
                 catch(SQLException e){
                    e.printStackTrace();
                }


            }
            
      public ResultSet Login(String EmailIn,String PasswordIn)
         {
         int result=0;
            try
            {
                String sql="SELECT * from test.signup where Email='"+EmailIn+"' and Password='"+PasswordIn+"'";
                
                
                Login=connection.prepareStatement(sql);
                resultSet=Login.executeQuery();
            }catch(SQLException e){
            e.printStackTrace();
            }
            return resultSet;
            }
         
         
         
            
 
   
}
