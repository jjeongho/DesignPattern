package Project;

import java.sql.*;

class Movie extends Repository {

    String str;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // jdbc 드라이버 주소
    static final String DB_URL = "jdbc:mysql://localhost:3307?characterEncoding=UTF-8&&serverTimezone=UTC&&useSSL=false"; // DB 접속주소
    static final String USERNAME = "root"; // DB ID
    static final String PASSWORD = "gpwn0797"; // DB Password

    Connection conn = null;
    Statement state = null;

    Movie(String str) {
        this.str = str; // 사용자가 입력한 검색어
    }
    void check() {
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sql = "select * from searchword.moviesearchword where searchword = '" + str + "';";

            state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);

            if (rs.next()) {
                int count = rs.getInt("count");
                count = count + 1;
                String sql3 = "update searchword.moviesearchword set count = " + count + " where searchword = '" + str + "';";
                state = (Statement) conn.createStatement();
                state.executeUpdate(sql3);
            } else {
                int num = 1;
                String sql4 = "insert into searchword.moviesearchword (searchword,count) values('" + str + "'," + num + ")";
                state = (Statement) conn.createStatement();
                state.executeUpdate(sql4);
            }
            rs.close();
            state.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception : " + e.getMessage());
            e.printStackTrace();
        }

    }

}
