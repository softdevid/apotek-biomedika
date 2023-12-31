package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ZAFL
 */
public class MySQLConnection {
  private static Connection conn;
  
  public static Connection connectDB() {
    if (conn == null) {
      try {
        String url = "jdbc:mysql://localhost:3306/apotek_biomedika";
        String user = "root";
        String password = "";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
      } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Error: "+e.getMessage());
      }
    }
    
    return conn;
  }
}
