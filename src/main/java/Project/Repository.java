package Project;

import static Project.Actor.JDBC_DRIVER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Repository {

    String searchword;

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // jdbc 드라이버 주소
    static final String DB_URL = "jdbc:mysql://localhost:3307?characterEncoding=UTF-8&&serverTimezone=UTC&&useSSL=false"; // DB 접속주소
    static final String USERNAME = "root"; // DB ID
    static final String PASSWORD = "gpwn0797"; // DB Password

    Connection conn = null;
    Statement state = null;

    final void StoreRepository() {
        connect();
        check();
        wordlist();
    }

//하위 클래스에서 확장/변화가 필요한 코드만 코딩하도록 한다.
    abstract void check(); // 검색어 저장

//공통된 부분은 상위 클래스에서 해결하여 코드 중복 최소화, 하위 클래스에서도 변하지 않는 것 
    private void wordlist() {
        System.out.println("입력하신 검색어가 저장되었습니다.");
    }

    private void connect() {
        try {
            Class.forName(JDBC_DRIVER); 
            // Class 클래스의 forName()함수를 이용해서 해당 클래스를 메모리로 로드
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            if (conn != null) {
                System.out.println("db 접속 성공");
            } else {
                System.out.println("접속 실패");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

}
