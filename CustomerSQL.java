import java.sql.*;
import java.util.*;
import java.io.*;

/**
 * Write a description of class CustomerSQL here.
 * 
 * @author steven susanto 
 * @version 3 May 2016
 */
public class CustomerSQL
{
    
    /**
     * digunakan untuk mengambil data customer dari MySQL BLOB ke ArrayList pada Bank
     * @return ArrayList al;
     */
    synchronized static public ArrayList importSQL(){
        String sql = "SELECT resume FROM tes WHERE id = 1" ;
        ArrayList al = null;
        Object o = null;
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbank", "root", "") ; 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                InputStream is = rs.getBlob("resume").getBinaryStream();
                ObjectInputStream oip = new ObjectInputStream(is);
                al = (ArrayList)oip.readObject();
                is.close();
                oip.close();
            }
            rs.close();
            pstmt.close();
            conn.close();
            System.out.println("berhasil import dari MySQL");
        }
        catch(Exception e){
            System.out.println("sql " +e.getMessage());
        }
        
        return al;
    }
    
    
    /**
     * digunakan untuk menyimpan data customer arrayList ke MySQL dalam bentuk BLOB
     * @param ArrayList al
     * @return boolean - true bila simpan berhasil
     */
    synchronized static  public boolean exportSQL(ArrayList al){
        String sql = "UPDATE tes SET resume = ? WHERE id = 1" ;
        
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbank", "root", "") ; 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, al);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            System.out.println("berhasil export ke MySQL");
            return true;
        }
        catch(Exception e){
            System.out.println("sql " +e.getMessage());
        }
        return false;
    }
}
