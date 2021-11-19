/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.sql.*;

public class ActorList {
      
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // jdbc 드라이버 주소
    static final String DB_URL = "jdbc:mysql://localhost:3307?characterEncoding=UTF-8&&serverTimezone=UTC&&useSSL=false"; // DB 접속주소
    static final String USERNAME = "root"; // DB ID
    static final String PASSWORD = "gpwn0797"; // DB Password

    public void List() {

        Connection conn = null;
        Statement state = null;

        System.out.print("User Table 접속 : ");

        try {
            Class.forName(JDBC_DRIVER); // Class 클래스의 forName()함수를 이용해서 해당 클래스를 메모리로 로드
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            if (conn != null) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
            state = conn.createStatement();
            
            String sql;
            sql = "SELECT * FROM searchword.actorsearchword order by count desc;";
            
            ResultSet rs = state.executeQuery(sql);
            int num = 1;
            System.out.println("==========배우 실시간 검색어===========");
            while(rs.next()){
                String word = rs.getString("searchword");
                int count = rs.getInt("count");
                System.out.println(num + "위 -> " + "검색어 : " + word + " / 검색 횟수 : " + count);
                
               if(num==5){
                   break;
               }
               num++;
               
            }
            
            rs.close();
            state.close();
            conn.close();
            
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception : " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
