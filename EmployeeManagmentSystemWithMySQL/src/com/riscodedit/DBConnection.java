package com.riscodedit;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
   static Connection con;
    public static Connection createDbConnection(){
        String url = "---";
        String username = "----";
        String password = "----";
        try {
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //get connection
          con =  DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}
