package Decorator;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Similar extends Decorator {
    private static final Similar sqlConnector = new Similar(); 
    
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // jdbc 드라이버 주소
    static final String DB_URL = "jdbc:mysql://localhost:3307?characterEncoding=UTF-8&&serverTimezone=UTC&&useSSL=false"; // DB 접속주소
    static final String USERNAME = "root"; // DB ID
    static final String PASSWORD = "gpwn0797"; // DB Password
    Connection conn = null;
    Statement stmt = null;
    
  private Similar() {
         this.recommendation = recommendation;

  }
  
public boolean DatabaseConnector(){   
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            System.out.println("서버에 접속하셨습니다.");
            return true;
        }
        catch(ClassNotFoundException e){
            System.out.println("에러 : 드라이버 로딩 실패");
            return false;
        }
        catch(SQLException e){
            System.out.println("에러 : " + e);
            return false;
        }   
    }
   
 public Statement getStatement() {
        return this.stmt;
    }
    
      public static Similar getInstance() {
        return sqlConnector;
    }
  
  public String getDescription() {
      return recommendation.getDescription();
  }
  
    public String  getData(){
        return null;
}
    
}
