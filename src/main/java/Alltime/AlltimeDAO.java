package Alltime;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.InputStream;

public class AlltimeDAO {

    private Connection con = null;// 데이터 베이스와 연결을 위한 객체
    private Statement stmt = null;// SQL 문을 데이터베이스에 보내기위한 객체
    private ResultSet rs = null;// SQL 질의에 의해 생성된 테이블을 저장하는 객체
    // 1. JDBC Driver Class - com.mysql.jdbc.Driver
    private static String driver = "com.mysql.jdbc.Driver";
    // 2. 데이터베이스에 연결하기 위한 정보
    private static String url = "jdbc:mysql://localhost:3307?characterEncoding=UTF-8&&serverTimezone=UTC&&useSSL=false";// 연결문자열
    private static String user = "root";// 데이터베이스 ID
    private static String pw = "gpwn0797";// 데이터베이스 PW

    public AlltimeDAO() {
        try {
            // 1. JDBC 드라이버 로딩
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void Alltime(int count) {
        String SQL = "SELECT * FROM searchword.alltime LIMIT " + count + ",10";

        try {
            // 2. Connection 객체 생성
            con = DriverManager.getConnection(url, user, pw);// DB 연결 
            // 3. Statement 객체 생성
            stmt = con.createStatement();
            // 4. SQL 문장을 실행하고 결과를 리턴
            // stmt.excuteQuery(SQL) : select
            // stmt.excuteUpdate(SQL) : insert, update, delete ..
            rs = stmt.executeQuery(SQL);
            // 5. ResultSet에 저장된 데이터 얻기 - 결과가 2개 이상
            while (rs.next()) {
                String rank = rs.getString("RANK");
                String movieNm = rs.getString("movieNm");
                String openDt = rs.getString("openDt");
                String audiCnt = rs.getString("audiCnt");
                System.out.println(String.format("순위 : %-4s 개봉일 : %s 관객수 : %s 영화명 : %s", rank, openDt, audiCnt, movieNm));
            }
        } catch (SQLException e) {
            System.out.println("SQL Error : " + e.getMessage());

        } finally {
            close(con, stmt, rs);
        }
    }

    public void close(Connection con, Statement stmt, ResultSet rs) {
        //사용순서와 반대로 close 함 
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
