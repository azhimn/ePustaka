/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epustaka.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mazhn
 */
public class Config {
    public static Connection mysqlconfig;
    public static Connection configDB() throws SQLException {
        try {
            String url  = "jdbc:mysql://localhost:3306/pbo_pustaka";
            String user = "root";
            String password = "";
            
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.print("Koneksi gagal" + e.getMessage());
        }
        return mysqlconfig;
    }
}
