/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.util.Scanner;


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

public class BriefInfor implements Observer {
        private ConcreateSubject concreatesubject;
        final static String Key = "f9aaab7315140a671c62c37f8cac285c";
        
    public void briefInfor(ConcreateSubject concreatesubject) {
      this.concreatesubject = concreatesubject;        
    
    }

    public BriefInfor updateM(String movieNm) {
       
        String urlStr
                = " http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?"
                + "key=" + Key + "&movieNm=" + movieNm;
         BriefInfor bo = new BriefInfor();
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
        //api 계산식
    
    public BriefInfor updateA(String peopleNm){
          String urlStr
                = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/people/searchPeopleList.json?"
                + "key=" + Key + "&peopleNm=" + peopleNm;
        BriefInfor bo = new BriefInfor();
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
            JSONObject json = (JSONObject) jsonObj.get("peopleListResult");
            JSONArray array = (JSONArray) json.get("peopleList");

            JSONObject obj;

            for (int i = 0; i < array.size(); i++) {
                obj = (JSONObject) array.get(i); // 해당 item을 가져옵니다.
                
                peopleNm = (String) obj.get("peopleNm");//영화인
                String peopleNmEn = (String) obj.get("peopleNmEn");//영화인명(영문)
                String repRoleNm = (String) obj.get("repRoleNm");//분야
                String filmoNames = (String) obj.get("filmoNames");//필모리스트
                 String peopleCd = (String) obj.get("peopleCd"); 
                System.out.println(peopleNmEn);

                System.out.println("영화인 : "  + peopleNm + " 영문 명 :"  + peopleNmEn + "분야 : " + repRoleNm + 
                "   필모리스트 : " +  filmoNames + "  \n 배우코드 : " +  peopleCd);
               
                /*
                //검색한 카테고리와 일치하는 변수에 문자형으로 데이터를 저장합니다.
                //데이터들이 형태가 달라 문자열로 통일해야 편합니다. 꺼내서 사용할 때 다시 변환하는게 좋습니다.
*/
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

    @Override
    public void hear(String voice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void people() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    }
 

    