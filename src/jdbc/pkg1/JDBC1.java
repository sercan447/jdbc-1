
package jdbc.pkg1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 @SuppressWarnings("deprecation")
public class JDBC1 {
   
    public static void main(String[] args) {

        
        try{
          JDBC_DORT();
        
        }catch(SQLException sqle){
        
        }catch(ClassNotFoundException clsfon){
        
        }finally{ 
            
        } 
   }//main 
    @Deprecated
    public static void JDBC_DORT()throws SQLException , ClassNotFoundException{
        
        Connection con = MYSQLConnUtils.getMYSQLConnection();
        String sqli = "SELECT  * FROM book.husnu WHERE Kolaj_adi = ?";
        
        PreparedStatement pstm = con.prepareStatement(sqli);
        
        pstm.setString(1, "YTR");
        ResultSet rs = pstm.executeQuery();
        
        while(rs.next()){
            System.out.println("---");
            System.out.print(rs.getString("isimus")+" ");
            System.out.print(rs.getString("Sinif_ismi")+ " ");
            System.out.println(rs.getString("Kolaj_adi")+ " ");
        }
        
       
        pstm.setString(1, "LKL");
        rs = pstm.executeQuery();
       
        while(rs.next()){
            System.out.println("----");
            System.out.print(rs.getString(1)+ " ");
            System.out.print(rs.getString(2)+ " ");
            System.out.print(rs.getString(3)+" ");
            System.out.println(rs.getString(4) + " ");
        }   
        
        pstm.setString(1, "IET");
        rs = pstm.executeQuery();
        
        while(rs.next()){
            System.out.println("----");
            System.out.print(rs.getString(1) + " ");
            System.out.print(rs.getString(2) + " ");
            System.out.print(rs.getString(3) + " ");
            System.out.print(rs.getString(4) + " ");
        }
    }
    
    @Deprecated
    public static void JDBC_UC()throws SQLException,ClassNotFoundException{
        
        Connection connection = MYSQLConnUtils.getMYSQLConnection();
        Statement statement = connection.createStatement();
        
        String sqli =  "INSERT INTO universite (UniversiteID_Baglandi,Univer_Adi) VALUES ('4','Mugla Universitesi')";
        int rowCount = statement.executeUpdate(sqli);
        
        System.out.println("Row count affected : "+rowCount);
        
    }
    
    @Deprecated
    public static void JDBC_IKI()throws SQLException,ClassNotFoundException{
        
           Connection connection = MYSQLConnUtils.getMYSQLConnection();
           Statement state = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           
           String sql = "SELECT UniversiteID_Baglandi,Univer_Adi FROM universite";
           ResultSet rs = state.executeQuery(sql);
           
           boolean last = rs.last();
           
           System.out.println("last :"+last);
           
           if(last){
               System.out.print(rs.getString("UniversiteID_Baglandi")+" ");
               System.out.println(rs.getString("Univer_Adi"));
           }
           
           System.out.println("\n\n");
         //  boolean previus = rs.previous();
         // System.out.println("Previus 1 : "+previus);
           
          boolean previus = rs.previous();
           System.out.println("Previus 2 : "+previus);
           
           while(rs.next()){
               String a1 = rs.getString(2);
               int a2 = rs.getInt(1);
               
               System.out.println(a1 + " - "+a2);
           }//while
           
           
    }
    @Deprecated
    public static void JDBC_ILK()throws SQLException,ClassNotFoundException{
    
          Connection conn = MYSQLConnUtils.getMYSQLConnection();
        Statement state = conn.createStatement();
        
        //String sql = "SELECT City_Override,Pincode_Overrides,Street_Override,Passis,Isimler FROM book.personel_verileri";
        String sql = "SELECT nom,ad,soyad,ADRES_NO_Baglandi,UniversiteID_Baglandi FROM studentt";
        ResultSet rs = state.executeQuery(sql);
        while(rs.next()){
        
            System.out.print(rs.getString(1)+" ");
            System.out.print(rs.getString(2) + " ");
            System.out.print(rs.getString(3)+  " ");
            System.out.print(rs.getString(4) + " ");
            System.out.println(rs.getInt("UniversiteID_Baglandi"));
    }//while
  }
}
