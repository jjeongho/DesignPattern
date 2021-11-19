package DetailSearchActor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*BoxOfficeJSON 클래스는 영화진흥위원회에서 제공하는 박스오피스 데이터를 JSON형태로 가져오는
클래스 입니다.
* 박스오피스 데이터를 JSON데이터로 가져와서 BoxOffice 객체를 만들어 저장하여 반환합니다.
 */
public class Detailed_Search {

    /*서비스키로 영화진흥위원에서 제공해줍니다. 고정적으로 사용되기 때문에 final 
    statcic변수로 설정하겠습니다.*/
    final static String Key = "f9aaab7315140a671c62c37f8cac285c";

    //조회하고자 하는 날짜를 입력하면 해당하는 날짜의 박스오피스 정보를
    //JSON데이터로 가져와 BoxOffice 객체를 만들어 반환합니다.
    public Detailed_Search getDetailed_Search(String peopleCd) {
        //JSON데이터를 요청하는 URLstr을 만듭니다.
        String urlStr
                = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/people/searchPeopleInfo.json?"
                + "key=" + Key + "&peopleCd=" + peopleCd;

        Detailed_Search bo = new Detailed_Search();
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
            JSONObject json = (JSONObject) jsonObj.get("peopleInfoResult");
            JSONObject json2 = (JSONObject) json.get("peopleInfo");
            JSONArray filmos = (JSONArray) json2.get("filmos");
           
            JSONObject obj;
            
            String peopleNm = (String) json2.get("peopleNm");
            String peopleNmEn = (String) json2.get("peopleNmEn");
          
            System.out.println("배우명(국문) : " + peopleNm);
            System.out.println("영화명(영문) : " + peopleNmEn);
         

            System.out.println("==========================필모그래피==========================");
            for (int i = 0; i < filmos.size(); i++) {
                obj = (JSONObject) filmos.get(i);
                String movieNm = (String) obj.get("movieNm");
                String moviePartNm = (String) obj.get("moviePartNm");
                //String cast = (String) obj.get("cast");
                System.out.println(String.format("영화 : %-4s 분야 : %-15s ", movieNm, moviePartNm));
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
