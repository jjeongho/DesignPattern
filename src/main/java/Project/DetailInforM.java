
package Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DetailInforM extends ConcreateSubject {
    final static String Key = "f9aaab7315140a671c62c37f8cac285c";
    private ConcreateSubject concreatesubject;
  public  void detailInforM() {
      
  }

  public  DetailInforM update(String movieCd) {
      String urlStr
                = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?"
                + "key=" + Key + "&movieCd=" + movieCd;

         DetailInforM bo = new DetailInforM();
        // 결과 데이터를 저장할 객체를 만듭니다.
        try {
            URL url = new URL(urlStr); // 완성된 urlStr을 사용해서 URL 만들어 해당 데이터를 가져옵니다.
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            String line = "";
            String result = "";
            //버퍼에 있는 정보를 문자열로 변환
            while ((line = bf.readLine()) != null) {//bf에 있는 값을 읽어와서 하나의 문자열로 만듭니다.
                result = result.concat(line);
            }

            //문자열을 JSON으로 파싱합니다 마지막 배열형태로 저장된 데이터까지 파싱해냅니다.
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
            JSONObject json = (JSONObject) jsonObj.get("movieInfoResult");
            JSONObject json2 = (JSONObject) json.get("movieInfo");
            JSONArray nations = (JSONArray) json2.get("nations");
            JSONArray genres = (JSONArray) json2.get("genres");
            JSONArray directors = (JSONArray) json2.get("directors");
            JSONArray actors = (JSONArray) json2.get("actors");
            JSONArray audits = (JSONArray) json2.get("audits");

            JSONObject obj;
            String moviecd = (String) json2.get("movieCd");
            String movieNm = (String) json2.get("movieNm");
            String movieNmEn = (String) json2.get("movieNmEn");
            String prdtYear = (String) json2.get("prdtYear");
            String showTm = (String) json2.get("showTm");
            String openDt = (String) json2.get("openDt");
            System.out.println("영화코드 : " + moviecd);
            System.out.println("영화명(국문) : " + movieNm);
            System.out.println("영화명(영문) : " + movieNmEn);
            System.out.println("제작연도 : " + prdtYear + "년");
            System.out.println("개봉연도 : " + openDt);
            System.out.println("상영시간 : " + showTm + "분");

            System.out.print(" 관람등급 : ");
            for (int i = 0; i < 1; i++) {
                obj = (JSONObject) audits.get(i);
                String watchGradeNm = (String) obj.get("watchGradeNm");
                System.out.print(watchGradeNm);
            }

            System.out.print("국가 : ");
            for (int i = 0; i < nations.size(); i++) {
                obj = (JSONObject) nations.get(i);
                String nationNm = (String) obj.get("nationNm");
                System.out.println(nationNm + " ");
            }
            System.out.print("장르 : ");
            for (int i = 0; i < genres.size(); i++) {
                obj = (JSONObject) genres.get(i);
                String genreNm = (String) obj.get("genreNm");
                System.out.print(genreNm + "  ");
            }
            System.out.println("\n==========================감독==========================");
            for (int i = 0; i < directors.size(); i++) {
                obj = (JSONObject) directors.get(i);
                String peopleNm = (String) obj.get("peopleNm");
                String peopleNmEn = (String) obj.get("peopleNmEn");
                System.out.println("이름 : " + peopleNm + "  영문명 : " + peopleNmEn);
            }
            System.out.println("==========================배우==========================");
            for (int i = 0; i < actors.size(); i++) {
                obj = (JSONObject) actors.get(i);
                String peopleNm = (String) obj.get("peopleNm");
                String peopleNmEn = (String) obj.get("peopleNmEn");
                String cast = (String) obj.get("cast");
                System.out.println(String.format("이름 : %-4s 영문명 : %-15s 역할 : %s", peopleNm, peopleNmEn, cast));
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


