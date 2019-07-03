/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
    
/**
 *
 * @author ASUS
 */
public class Koneksi {
    public Connection con;
    public String pesan;
    public PreparedStatement ps;
    public ResultSet rs;

    public Koneksi() {
        pesan ="";
        try{
            Class.forName("org.postgresql.Driver");
            con = (Connection) DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/projectpbo","pbo","pbo123");
            pesan="SUKSES";
            
        }catch (Exception e){
           e.printStackTrace();
        }
        
        System.out.println("pesan : "+pesan);
    }
    
    
}
