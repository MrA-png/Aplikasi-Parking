package project_parkir1;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luxtrada R
 */
public class koneksi {
//   Connection koneksi=null;
    Connection con;
    
    public koneksi(){
        String id,pass,driver,url;
        id="root";
        pass="";
        driver="com.mysql.jdbc.Driver";
        url="jdbc:mysql://localhost:3306/parking";
        try{
         Class.forName(driver).newInstance();
         con=DriverManager.getConnection(url,id,pass);
//         JOptionPane.showMessageDialog(null,"Konekis Berhasil");
        }catch(Exception e){
            System.out.println(""+e.getLocalizedMessage());
        }
       }
    public static void main(String[] args){
        koneksi k  = new koneksi();
    }

   
    }
    

