package Decorator;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Search extends Recommendation {
    final static String Key = "f9aaab7315140a671c62c37f8cac285c"; 
    private static ResultSet rs = null; //db저장
  public Search() {
      description = "=============================\n지금 추천 하는 영화는? ";
  }


  public Search getDescription(String movieNm) throws SQLException {
        Similar.getInstance().DatabaseConnector();// 데이터베이스
        String urlStr
                = " http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?"
                + "key=" + Key + "&movieNm=" + movieNm;
        Search bo = new Search();
        // 결과 데이터를 저장할 객체를 만듭니다.
        try {
           // urlStr=URLEncoder.encode(urlStr,"UTF-8");
            URL url = new URL(urlStr); // 완성된 urlStr을 사용해서 URL 만들어 해당 데이터를 가져옵니다.
            //reader = new BufferedReader(new InputStreamReader(urlStr.openStream(),"UTF-8"));
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
            String line = "";
            String result = "";
            //버퍼에 있는 정보를 문자열로 변환
            while ((line = bf.readLine()) != null) {//bf에 있는 값을 읽어와서 하나의 문자열로 만듭니다.
                result = result.concat(line);
            }
            //System.out.println(result);

            //문자열을 JSON으로 파싱합니다 마지막 배열형태로 저장된 데이터까지 파싱해냅니다.
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
            JSONObject json = (JSONObject) jsonObj.get("movieListResult");
            JSONArray array = (JSONArray) json.get("movieList");

            JSONObject obj;

            for (int i = 0; i < array.size(); i++) {
                obj = (JSONObject) array.get(i); // 해당 item을 가져옵니다.
                //개봉연도 , 감독 ,장르
                String movieName = (String) obj.get("movieNm");//영화제목
                String openDt = (String) obj.get("openDt");//개봉연도
                String repGenreNm = (String) obj.get("repGenreNm");//장르
                String movieCd = (String) obj.get("movieCd"); // 상세 영화 검색을 위한 영화 코드
                

                System.out.println("영화제목 : "  + movieName + " 개봉연도 : "  + openDt + /*" 감독 : " + peopleNm + */ 
                "   장르 : " +  repGenreNm + " 영화코드 : " + movieCd);
                
                    
              
                //검색한 카테고리와 일치하는 변수에 문자형으로 데이터를 저장합니다.
                //데이터들이 형태가 달라 문자열로 통일해야 편합니다. 꺼내서 사용할 때 다시 변환하는게 좋습니다.
                 if(repGenreNm.equals("액션")){
                    rs = Similar.getInstance().getStatement().executeQuery("SELECT * FROM searchword.deocorator WHERE genre = 'Action'");
       
                try {

                        while (rs.next()) {
                // 칼럼 받아오는 코드
                        System.out.println("영화추천 : " + rs.getString("genre") + "  " + rs.getString("title") + "  " + rs.getString("star"));
                    }
                 } catch (SQLException ex) {
                        System.err.println(ex);
                      }
                 }
                 // 액션 장르
                 else if(repGenreNm.equals("코미디")){
                    rs = Similar.getInstance().getStatement().executeQuery("SELECT * FROM searchword.deocorator WHERE genre = 'Comedy'");
       
                try {

                        while (rs.next()) {
                // 칼럼 받아오는 코드
                        System.out.println("영화추천 : " + rs.getString("genre") + "  " + rs.getString("title") + "  " + rs.getString("star"));
                    }
                 } catch (SQLException ex) {
                        System.err.println(ex);
                      }
                 }
                 //코미디 장르
                else if(repGenreNm.equals("드라마")){
                    rs = Similar.getInstance().getStatement().executeQuery("SELECT * FROM searchword.deocorator WHERE genre = 'Drama'");
       
                try {

                        while (rs.next()) {
                // 칼럼 받아오는 코드
                        System.out.println("영화추천 : " + rs.getString("genre") + "  " + rs.getString("title") + "  " + rs.getString("star"));
                    }
                 } catch (SQLException ex) {
                        System.err.println(ex);
                      }
                 }
                 // 드라마 장르
                 else if(repGenreNm.equals("로맨스")){
                    rs = Similar.getInstance().getStatement().executeQuery("SELECT * FROM searchword.deocorator WHERE genre = 'Rommance'");
       
                try {

                        while (rs.next()) {
                // 칼럼 받아오는 코드
                        System.out.println("영화추천 : " + rs.getString("genre") + "  " + rs.getString("title") + "  " + rs.getString("star"));
                    }
                 } catch (SQLException ex) {
                        System.err.println(ex);
                      }
                 }
                 // 로맨스 장르
                 else if(repGenreNm.equals("SF")){
                    rs = Similar.getInstance().getStatement().executeQuery("SELECT * FROM searchword.deocorator WHERE genre = 'SF'");
       
                try {

                        while (rs.next()) {
                // 칼럼 받아오는 코드
                        System.out.println("영화추천 : " + rs.getString("genre") + "  " + rs.getString("title") + "  " + rs.getString("star"));
                    }
                 } catch (SQLException ex) {
                        System.err.println(ex);
                      }
                 }
                 // SF 장르
                  else if(repGenreNm.equals("스릴러")){
                    rs = Similar.getInstance().getStatement().executeQuery("SELECT * FROM searchword.deocorator WHERE genre = 'Thriller'");
       
                try {

                        while (rs.next()) {
                // 칼럼 받아오는 코드
                        System.out.println("영화추천 : " + rs.getString("genre") + "  " + rs.getString("title") + "  " + rs.getString("star"));
                    }
                 } catch (SQLException ex) {
                        System.err.println(ex);
                      }
                 }
                 // 스릴러 장르
                  else
                     ;
                 
           } 
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException : " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("ParseException : " + e.getMessage());
        }

      return bo;//모든값이 저장된 BoxOffice객체를 반환합니다.
    
     
      
  } 

}
