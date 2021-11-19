/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
   //DB 종료에 따른 JDBC DRIVER 클래스
    Class.forName("com.mysql.cj.jdbc.Driver");
		
    //DB접속 url
    String url = "jdbc:mysql://localhost:3307?characterEncoding=UTF-8&&serverTimezone=UTC&&useSSL=false";
    //DB접속 ID
    String id = "root";
    //DB접속 패스워드
    String pw = "gpwn0797";
		
    //접속정보로 JDBC 연결 커넥션 생성
    Connection conn = DriverManager.getConnection(url,id,pw);
		
    return conn;



}
}