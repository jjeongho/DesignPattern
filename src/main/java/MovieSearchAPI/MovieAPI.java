/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieSearchAPI;

import ActorSearchAPI.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*BoxOfficeJSON 클래스는 영화진흥위원회에서 제공하는 박스오피스 데이터를 JSON형태로 가져오는
클래스 입니다.
* 박스오피스 데이터를 JSON데이터로 가져와서 BoxOffice 객체를 만들어 저장하여 반환합니다.
 */
public class MovieAPI {

    /*서비스키로 영화진흥위원에서 제공해줍니다. 고정적으로 사용되기 때문에 final 
    statcic변수로 설정하겠습니다.*/
    final static String Key = "f9aaab7315140a671c62c37f8cac285c";

    //조회하고자 하는 날짜를 입력하면 해당하는 날짜의 박스오피스 정보를
    //JSON데이터로 가져와 BoxOffice 객체를 만들어 반환합니다.
    public MovieAPI getMovieAPI(String movieNm) {
        //JSON데이터를 요청하는 URLstr을 만듭니다.
        
        String urlStr
                = " http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?"
                + "key=" + Key + "&movieNm=" + movieNm;
        MovieAPI bo = new MovieAPI();
        // 결과 데이터를 저장할 객체를 만듭니다.
        try {
            URL url = new URL(urlStr); // 완성된 urlStr을 사용해서 URL 만들어 해당 데이터를 가져옵니다.
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
            String line = "";
            String result = "";
            //버퍼에 있는 정보를 문자열로 변환
            while ((line = bf.readLine()) != null) {//bf에 있는 값을 읽어와서 하나의 문자열로 만듭니다.
                result = result.concat(line);
            }

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
                
                    
                if(repGenreNm.equals("액션"))
                    System.out.println("액션영화");
                //검색한 카테고리와 일치하는 변수에 문자형으로 데이터를 저장합니다.
                //데이터들이 형태가 달라 문자열로 통일해야 편합니다. 꺼내서 사용할 때 다시 변환하는게 좋습니다.

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
